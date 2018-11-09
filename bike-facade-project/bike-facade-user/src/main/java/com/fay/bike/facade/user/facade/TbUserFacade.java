package com.fay.bike.facade.user.facade;

import com.fay.bike.facade.user.dto.User;

import java.util.List;

/**
 * UserFacade
 *
 * @author fanqingfeng
 * @date 2018/10/31 15:17
 */
public interface TbUserFacade {
    /**
     * 获得User数据的总行数
     *
     * @return .
     */
    long getUserRowCount();

    /**
     * 获得User数据集合
     *
     * @return .
     */
    List<User> queryUserList();

    /**
     * 通过User的id获得User对象
     *
     * @param id .
     * @return .
     */
    User getUserById(Integer id);

    /**
     * 插入User到数据库,包括null值
     *
     * @param tbUser .
     * @return .
     */
    int insertUser(User tbUser);

    /**
     * 批量插入User到数据库
     *
     * @param tbUser .
     * @return .
     */
    int insertUserList(List<User> tbUser);

    /**
     * 通过User的id更新User中的数据,包括null值
     *
     * @param tbUser .
     * @return .
     */
    int updateUser(User tbUser);
}