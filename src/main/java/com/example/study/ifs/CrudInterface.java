package com.example.study.ifs;

import com.example.study.model.network.Header;

public interface CrudInterface {

    Header create(); // todo request object 추가
    Header read(long id);
    Header update();
    Header delete(long id);
}
