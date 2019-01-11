package com.fay.bike.facade.user.dto;

import com.fay.bike.base.vo.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * User
 * @author fanqingfeng
 * @date 2018/10/31 15:17
 */
@Setter
@Getter
public class User extends BaseVo {
    private Integer id;
    private String uName;
    private Integer num;
    private String email;

}
