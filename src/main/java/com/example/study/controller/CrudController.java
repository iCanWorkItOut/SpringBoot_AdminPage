package com.example.study.controller;

import com.example.study.ifs.CrudInterface;
import com.example.study.model.network.Header;
import com.example.study.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

//public abstract class CrudController<Req, Res> implements CrudInterface<Req, Res> {
@Component // use for @Autowired
public abstract class CrudController<Req, Res, Entity> implements CrudInterface<Req, Res> {

//    protected CrudInterface<Req, Res> baseService; // 모든 ApiLogicService는 CrudInterface를 구현하고 있음
    @Autowired(required = false) // Service 추상화 : PostConstruct 생략 후 baseService 값을 채우기 위해
    // -> @Autowired를 하지 않을 경우 basService가 뭘 가르키는지 알 수 없음. Autowired를 통해 해당 변수 및 메서드에 스프링이 관리하는
    // Bean을 자동으로 주입 : DI // AutoWired는 Type으로 DI, @Resource는 이름으로 DI
    protected BaseService<Req, Res, Entity> baseService; // BaseService 구현 후

    @Override
    @PostMapping("")
    public Header<Res> create(@RequestBody Header<Req> request) {
        return baseService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header<Res> read(@PathVariable long id) {
        return baseService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<Res> update(@RequestBody Header<Req> request) {
        return baseService.update(request);
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable long id) {
        return baseService.delete(id);
    }
}
