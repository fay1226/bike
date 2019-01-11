package com.fay.bike.services.user.service;

import com.fay.bike.base.utils.BeanUtil;
import com.fay.bike.facade.user.dto.User;
import com.fay.bike.services.user.entity.TbUser;
import com.fay.bike.services.user.mapper.TbUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * TbUserService
 *
 * @author fanqingfeng
 * @date 2018/10/31 15:17
 */
@Service
public class TbUserService {
	@Resource
	private TbUserMapper tbUserMapper;

	public User getUserById(Integer userId) {
		TbUser tbUser = tbUserMapper.getTbUserById(userId);
		return BeanUtil.copyToObj(tbUser, User.class);
	}
}