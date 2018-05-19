package com.lmm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lmm on 2018/4/19.
 */
@RestController
public class HelloController {

    @Value("${cupSize}")
    private String cupsize;

    @Value("${content}")
    private String content;

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String say(){
        return cupsize+"</br>"+content+"</br>"+girlProperties.getCupSize();
    }

    @GetMapping(value="/hello2")
    public String say2(@RequestParam(value="id", required = false, defaultValue = "0") Integer myId){
        return "id:"+myId;
    }
}
