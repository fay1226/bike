package com.fay.bike.base.vo;

import com.fay.bike.base.exception.SysException;
import net.sf.cglib.beans.BeanCopier;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 父类BaseVo
 * @author fanqingfeng
 * @date 2018/10/31 15:17
 */
public class BaseVo implements Serializable {
    public BaseVo() {super();}

    private static final transient long serialVersionUID = 1L;

    private static ConcurrentMap<String, BeanCopier> beanCopiers = new ConcurrentHashMap<>();

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public String toLineString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    public <T> T copyTo(Class<T> clazz) {
        try {
            T clone = clazz.newInstance();
            String key = clazz.getName() + ":" + this.getClass().getName();
            BeanCopier copier;
            if (beanCopiers.containsKey(key)) {
                copier = beanCopiers.get(key);
            } else {
                copier = BeanCopier.create(this.getClass(), clazz, false);
                beanCopiers.putIfAbsent(key, copier);
            }

            copier.copy(this, clone, null);
            return clone;
        } catch (Exception e) {
            throw new SysException(e);
        }
    }

    public static <A extends BaseVo, B extends BaseVo> List<B> copyListTo(List<A> sources, Class<B> clazz) {
        try {
            List<B> newList = new ArrayList<>();
            if (sources == null || sources.isEmpty()) {
                return newList;
            }
            A val = sources.get(0);
            String key = clazz.getName() + ":" + val.getClass().getName();
            BeanCopier copier;
            if (beanCopiers.containsKey(key)) {
                copier = beanCopiers.get(key);
            } else {
                copier = BeanCopier.create(val.getClass(), clazz, false);
                beanCopiers.putIfAbsent(key, copier);
            }
            for (A a : sources) {
                B clone = clazz.newInstance();
                copier.copy(a, clone, null);
                newList.add(clone);
            }
            return newList;
        } catch (Exception e) {
            throw new SysException(e);
        }
    }
}
