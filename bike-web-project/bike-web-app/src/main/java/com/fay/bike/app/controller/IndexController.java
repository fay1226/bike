package com.fay.bike.app.controller;

import com.fay.bike.app.system.Result;
import com.fay.bike.app.vo.IndexVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页Controller
 * @author fanqingfeng
 * @date 2018/11/5 17:48
 */
@Slf4j
@RestController
@RequestMapping("/index")
public class IndexController {

    @GetMapping("/index")
    public Result<IndexVo> index() {
        IndexVo indexVo = new IndexVo();
        indexVo.setAge(18);
        indexVo.setName("Fay");
        log.info("info日志测试{}", indexVo);
        return new Result<IndexVo>().success(indexVo);
    }

    @GetMapping("/test")
    public Result<List> test() {
        List<IndexVo> list = new ArrayList<>();
        IndexVo indexVo = new IndexVo();
        indexVo.setAge(18);
        indexVo.setName("Fay");
        list.add(indexVo);
        log.error("error日志测试{}", indexVo);
        return new Result<List>().success(list);
    }
}
