package com.example.study.controller.api;

import com.example.study.controller.CrudController;
import com.example.study.ifs.CrudInterface;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.UserApiRequest;
import com.example.study.model.network.response.UserApiResponse;
import com.example.study.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.swing.text.html.parser.Entity;
import java.util.List;

@Slf4j // Simple Logging Facade for Java
@RestController
@RequestMapping("/api/user")
public class UserApiController extends CrudController<UserApiRequest, UserApiResponse, Entity> {

    @Autowired
    private UserApiLogicService userApiLogicService;

    @GetMapping
    public Header<List<UserApiResponse>> search(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
        log.info("{}", pageable);
        return userApiLogicService.search(pageable);
    }
//    @Autowired
//    private UserApiLogicService userApiLogicService;
//    @PostConstruct
//    public void init() {
//        this.baseService = userApiLogicService;
//    }

//    @Override
//    @PostMapping("") // /api/user
//    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request) {
//        log.info("{}", request); // Slf4j
//        return userApiLogicService.create(request);
//    }
//
//    @Override
//    @GetMapping("{id}") // /api/user/{id}
//   public Header<UserApiResponse> read(@PathVariable(name = "id") long id) { // {id} 변수명이 파라미터 id명과 같을 경우 (name = ) 생략 가능
//        log.info("read id : {}", id);
//        return userApiLogicService.read(id);
//    }
//
//    @Override
//    @PutMapping("") // /api/user
//    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> request) {
//        return userApiLogicService.update(request);
//    }
//
//    @Override
//    @DeleteMapping("{id}") // /api/user/{id}
//    public Header delete(@PathVariable long id) {
//        log.info("delete : {}", id);
//        return userApiLogicService.delete(id);
//    }
}
