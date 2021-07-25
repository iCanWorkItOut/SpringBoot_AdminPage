package com.example.study.service;

import com.example.study.ifs.CrudInterface;
import com.example.study.model.network.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component // Autowired를 받기 위해
public abstract class BaseService<Req, Res, Entity> implements CrudInterface<Req,Res> {

    @Autowired(required = false) // required = false : Autowired가 디폴트는 아님
    protected JpaRepository<Entity, Long> baseRepository;
}
