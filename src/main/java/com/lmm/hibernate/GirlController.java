package com.lmm.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lmm on 2018/4/20.
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private  GirlService girlService;

    /**
     * 查询所有女生列表
     */
    @GetMapping(value = "/getGirl")
    public List<Girl> getGirl(){
        return girlRepository.findAll();
    }

    /**
     * 新增女生信息
     */
    @PostMapping("/addGirl")
    public Girl addGirl(@RequestParam("cupSize") String cupSize,
                          @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     *根据id查询一个女生
     */
    @GetMapping("/getGirl/{id}")
    public Girl getGirlById(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    /**
     * 通过put方式更新一个女生信息
     * 注意：put方式请求时，Body数据类型为x-www-form-urlencoded
     */
    @PutMapping("/getGirl/{id}")
    public Girl updateGirlById(@PathVariable("id") Integer id,
                               @RequestParam("cupSize") String cupSize,
                               @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     * 删除
     */
    @DeleteMapping("/getGirl/{id}")
    public void delGirlById(@PathVariable("id") Integer id){
        girlRepository.delete(id);
    }

    /**
     * 通过年龄查询女生的信息
     */
    @GetMapping("/girls/{age}")
    public List<Girl> getGirlsByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    @GetMapping("/girls/two")
    public void insertTwo(){
        girlService.insertTwo();
    }
}
