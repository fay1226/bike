package com.fay.bike.app.controller;

import com.alibaba.fastjson.JSONObject;
import com.fay.bike.app.vo.IndexVo;
import com.fay.bike.base.vo.Result;
import com.fay.bike.facade.user.dto.User;
import com.fay.bike.facade.user.facade.TbUserFacade;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 首页Controller
 * @author fanqingfeng
 * @date 2018/11/5 17:48
 */
@Slf4j
@RestController
public class IndexController {

    @Autowired(required = false)
    private TbUserFacade tbUserFacade;

    @GetMapping("/user")
    public Result<User> getUser() {
        User user = tbUserFacade.getUserById(1);
        log.info("user = {}", user);
        return new Result<User>().success(user);
    }

    @GetMapping("/index")
    public Result<IndexVo> index() {
        IndexVo indexVo = new IndexVo();
        indexVo.setAge(18);
        indexVo.setName("Fay");
        log.info("indexVo = {}", indexVo);
        return new Result<IndexVo>().success(indexVo);
    }

    @GetMapping("/list")
    public Result<List> list() {
        List<IndexVo> list = Lists.newArrayList();
        IndexVo indexVo = new IndexVo();
        indexVo.setAge(18);
        indexVo.setName("Fay");
        list.add(indexVo);
        log.info("list = {}", JSONObject.toJSONString(list));
        return new Result<List>().success(list);
    }

    @GetMapping("/log")
    public Result<String> log() {
        log.error("error日志测试");
        log.warn("warn日志测试");
        log.info("info日志测试");
        return new Result<String>().success("success");
    }

}
