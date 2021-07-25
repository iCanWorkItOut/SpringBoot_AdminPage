package com.example.study.controller.api;

import com.example.study.service.UserApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//CREATE TABLE IF NOT EXISTS `study`.`settlement` (
//        `user_id` BIGINT NOT NULL,
//        `price` DECIMAL(12,4) NULL,
//        PRIMARY KEY (`user_id`),
//        CONSTRAINT `fk_settlement_user`
//        FOREIGN KEY (`user_id`)
//        REFERENCES `study`.`user` (`id`)
//        ON DELETE NO ACTION
//        ON UPDATE NO ACTION)
//        ENGINE = InnoDB;

@RestController
@RequestMapping("settlement")
public class SettlementApiController {

    @Autowired
    private SettlementApiLogicService settlementApiLogicService; // todo SettlementApiLogicService 구현

    @GetMapping("{id}")
    public Header<SettlementApiResponse> read(@PathVariable long id) { // todo SettlementApiRespose (user_id, price)
        return settlementApiLogicService.read(id);
        // todo SettlementApiLogicService read 메서드 구현
        //  : User -> findByid(id) -> select price from settle where id = ?
    }
}