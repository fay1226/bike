package com.fay.bike.services.user.mapper;


import com.fay.bike.services.user.entity.TbUser;

import java.util.List;

/**
 * TbUserMapper
 *
 * @author fanqingfeng
 * @date 2018/10/31 15:17
 */
public interface TbUserMapper {
    /**
     * 获得TbUser数据的总行数
     *
     * @return .
     */
    long getTbUserRowCount();

    /**
     * 获得TbUser数据集合
     *
     * @return .
     */
    List<TbUser> queryTbUserList();

    /**
     * 通过TbUser的id获得TbUser对象
     *
     * @param id .
     * @return .
     */
    TbUser getTbUserById(Integer id);

    /**
     * 插入TbUser到数据库,包括null值
     *
     * @param tbUser .
     * @return .
     */
    int insertTbUser(TbUser tbUser);

    /**
     * 批量插入TbUser到数据库
     *
     * @param tbUser .
     * @return .
     */
    int insertTbUserList(List<TbUser> tbUser);

    /**
     * 通过TbUser的id更新TbUser中的数据,包括null值
     *
     * @param tbUser .
     * @return .
     */
    int updateTbUser(TbUser tbUser);

}