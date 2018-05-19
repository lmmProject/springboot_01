package com.lmm.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;

/**
 * Created by lmm on 2018/4/20.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transient
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("B");
        girlB.setAge(18);

//        System.out.println(1/0);
        girlRepository.save(girlB);

    }
}
