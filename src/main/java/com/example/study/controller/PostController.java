package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
public class PostController {

    // HTML <Form>
    // ajax 검색 (비동기)
    // http post body -> data
    // json, xml, multipart-form, text-plain

    // @RequestMapping(method = RequestMethod.POST, path = "/postMethod", produces = "application/json")
    // @PostMapping(value = "/postMethod", produces = {"application/json"})
    @PostMapping("/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam){

        return searchParam;
    }
}
