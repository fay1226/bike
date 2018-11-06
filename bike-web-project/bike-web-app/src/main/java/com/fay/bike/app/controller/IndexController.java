package com.fay.bike.app.controller;

import com.fay.bike.app.system.Result;
import com.fay.bike.app.vo.IndexVo;
import com.fay.bike.base.exception.SysException;
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
@RestController
@RequestMapping("/index")
public class IndexController {

    @GetMapping("/index")
    public Result<IndexVo> index() {
        IndexVo indexVo = new IndexVo();
        //indexVo.setAge(18);
        indexVo.setName("Fay");
        return new Result<IndexVo>().success(indexVo);
    }

    @GetMapping("/test")
    public Result<List> test() {
        List<IndexVo> list = new ArrayList<>();
        IndexVo indexVo = new IndexVo();
        //indexVo.setAge(18);
        indexVo.setName("Fay");
        list.add(indexVo);
        return new Result<List>().success(list);
    }
}
