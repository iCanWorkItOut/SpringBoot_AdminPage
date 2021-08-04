package com.example.study.controller.api;


import com.example.study.controller.CrudController;
import com.example.study.ifs.CrudInterface;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.ItemApiRequest;
import com.example.study.model.network.response.ItemApiResponse;
import com.example.study.service.ItemApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/item")
//public class ItemApiController implements CrudInterface<ItemApiRequest, ItemApiResponse> {
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse> { // CrudController가 CrudInterface를 대체

    @Autowired
    private ItemApiLogicService itemApiLogicService;

//      CrudInterface의 crud부분의 구현(오버라이딩)을 CrudController에서 대신 했기 때문에 새로 할 필요가 없음.
    @PostConstruct // 초기 생성자 메서드처럼 동작, CrudController의 baseService가 어떤 Api의 Service인지 모르기 때문에
    public void init() {
        this.baseService = itemApiLogicService;
    }
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
