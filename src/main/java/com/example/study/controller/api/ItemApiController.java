package com.example.study.controller.api;


import com.example.study.controller.CrudController;
import com.example.study.ifs.CrudInterface;
import com.example.study.model.entity.Item;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.ItemApiRequest;
import com.example.study.model.network.response.ItemApiResponse;
import com.example.study.service.ItemApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/item")
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse, Item> {

    // Service 추상화 적용
//    @Autowired
//    private ItemApiLogicService itemApiLogicService;
//
//    @PostConstruct // 초기생성자와 같이 동작
//    public void init() {
//        this.baseService = itemApiLogicService;
//    }

// CrudController 추상클래스 상속 받음으로써 생략 가능
//    @Override
//    @PostMapping("") // /api/item
//    public Header<ItemApiResponse> create(@RequestBody Header<ItemApiRequest> request) {
//        return itemApiLogicService.create(request);
//    }
//
//    @Override
//    @GetMapping("{id}") // /api/item/{id}
//    public Header<ItemApiResponse> read(@PathVariable long id) {
//        return itemApiLogicService.read(id);
//    }
//
//    @Override
//    @PutMapping("") // /api/item
//    public Header<ItemApiResponse> update(@RequestBody Header<ItemApiRequest> request) {
//        return itemApiLogicService.update(request);
//    }
//
//    @Override
//    @DeleteMapping("{id}") // /api/item/{id}
//    public Header delete(@PathVariable long id) {
//        return itemApiLogicService.delete(id);
//    }
}
