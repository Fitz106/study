package com.jyp.studydemo.controller;

import com.jyp.studydemo.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：jiyuepeng
 * @date ：Created in 2019/9/14 21:57
 * @description：${description}
 */
@Slf4j
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    TestService testService;

    /**
     *
     * @param
     * @return
     */
    @PostMapping(value = "/strategy")
    String strategy() {
        testService.testStrategy("xx");
        return "success";
    }


}
