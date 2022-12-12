package com.experiment.article.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.experiment.article.Component.Utils.RedisUtil;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@RestController
@RequestMapping("/code")
//这是使用Redis生成验证码的接口,可以不用
public class VerificationCode {

//    @Resource没事，@auto就有事，为啥
    @Resource
    private RedisUtil redisUtil;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    @GetMapping("/captcha")
//    http://localhost:8080/code/captcha
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 4);
        specCaptcha.setFont(Captcha.FONT_1);
        String id = UUID.randomUUID().toString();
        response.setHeader("id", id);
        CaptchaUtil.out(specCaptcha, request, response);
        String verCode = specCaptcha.text().toLowerCase();
        //不设置过期
//        redisTemplate.opsForValue().set(id,verCode);
//        三分钟过期

//        redisTemplate.opsForValue().set(id,verCode,180);
        System.out.println(id);
//        System.out.println(verCode);
//        System.out.println(redisTemplate.opsForValue().get(id));

//   这是他封装的redis工具类，直接用其实也行
        redisUtil.set(id,verCode,180);
        System.out.println(redisUtil.get(id));
    }

    @PostMapping(value = "/check")
    public boolean check(@RequestBody String info) {
        JSONObject jsonObject = JSON.parseObject(info);
        //获取传过来的id 和 code
        String id = jsonObject.getString("id");
        String code = jsonObject.getString("code");
        System.out.println(id);
        System.out.println(code);

        //获取redis里面存的code
        String s = redisUtil.get(id).toString();
        //比较输入的code和redis的code，这里怎么G了啊
        System.out.println(s);
        boolean flag = code.equalsIgnoreCase(s);
        //匹配成功就删除redis存储
        if(flag){
            redisTemplate.delete(id);
        }
        return flag;
    }
}

