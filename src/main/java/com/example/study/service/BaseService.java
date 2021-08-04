package com.example.study.service;

import com.example.study.ifs.CrudInterface;
import com.example.study.model.network.Header;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component // @Autowired를 받기 위해서 사용
public abstract class BaseService<Req, Res, Entity> implements CrudInterface<Req, Res> {
    
    @Autowired(required = false)
    protected JpaRepository<Entity, Long> baseRepository;
    
    // CRUD 구현은 BaseService를 상속받은 클래스에서 구현
}
