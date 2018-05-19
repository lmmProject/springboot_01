package com.lmm.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lmm on 2018/4/20.
 */
public interface GirlRepository extends JpaRepository<Girl, Integer>{
    /**
     * 该方法名不能随便写
     */
    List<Girl> findByAge(Integer age);
}
