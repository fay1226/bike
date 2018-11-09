package com.fay.bike.services.user.impl;

import com.fay.bike.facade.user.dto.User;
import com.fay.bike.facade.user.facade.TbUserFacade;
import com.fay.bike.services.user.service.TbUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * TbUserFacadeImpl
 * @author fanqingfeng
 * @date 2018/10/31 15:17
 */
@Service
public class TbUserFacadeImpl implements TbUserFacade {
    @Resource
    private TbUserService tbUserService;

    /**
     * 获得User数据的总行数
     *
     * @return .
     */
    @Override
    public long getUserRowCount() {
        return 0;
    }

    /**
     * 获得User数据集合
     *
     * @return .
     */
    @Override
    public List<User> queryUserList() {
        return null;
    }

    /**
     * 通过User的id获得User对象
     *
     * @param userId .
     * @return .
     */
    @Override
    public User getUserById(Integer userId) {
        return tbUserService.getUserById(userId);
    }

    /**
     * 插入User到数据库,包括null值
     *
     * @param tbUser .
     * @return .
     */
    @Override
    public int insertUser(User tbUser) {
        return 0;
    }

    /**
     * 批量插入User到数据库
     *
     * @param tbUser .
     * @return .
     */
    @Override
    public int insertUserList(List<User> tbUser) {
        return 0;
    }

    /**
     * 通过User的id更新User中的数据,包括null值
     *
     * @param tbUser .
     * @return .
     */
    @Override
    public int updateUser(User tbUser) {
        return 0;
    }
}