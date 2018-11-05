package com.fay.bike.app.controller;

import com.fay.bike.app.system.Result;
import com.fay.bike.app.vo.IndexVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        indexVo.setAge(18);
        indexVo.setName("Fay");
        return new Result<IndexVo>().success(indexVo);
    }
}
