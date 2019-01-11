package com.fay.bike.base.utils;

import com.fay.bike.base.exception.SysException;
import com.google.common.collect.Lists;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Bean工具类
 * @author fanqingfeng
 * @date 2018/11/9 15:43
 */
@Slf4j
@NoArgsConstructor
public class BeanUtil {

    /**
     * 对象拷贝
     * @param source .
     * @param res .
     * @param <T> .
     * @return .
     */
    public static <T> T copyToObj(Object source, Class<T> res) {
        if(null == source){
            return null;
        }
        try {
            T resultObj = res.newInstance();
            BeanUtils.copyProperties(source, resultObj);
            return resultObj;
        } catch (Exception e) {
            log.error("对象转换异常", e);
            throw new SysException("对象转换异常");
        }
    }

    /**
     * 对象List拷贝
     * @param sourceList .
     * @param resList .
     * @param <T> .
     * @return .
     */
    public static <T> List<T> copyToList(Collection sourceList, Class<T> resList) {
        if(null == sourceList || sourceList.isEmpty()){
            return Collections.emptyList();
        }
        List<T> resultList = Lists.newArrayList();
        for (Object source : sourceList) {
            resultList.add(copyToObj(source, resList));
        }
        return resultList;
    }
}
