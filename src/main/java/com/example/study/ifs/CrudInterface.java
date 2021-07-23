package com.example.study.ifs;

import com.example.study.model.network.Header;

public interface CrudInterface<Request, Response> {

    Header<Response> create(Request request); // todo request object 추가
    Header<Response> read(long id);
    Header<Response> update(Request request);
    Header delete(long id);
}