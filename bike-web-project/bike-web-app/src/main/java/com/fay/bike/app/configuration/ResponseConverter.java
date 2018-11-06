package com.fay.bike.app.configuration;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.google.common.collect.Lists;
import org.apache.commons.lang.CharEncoding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * 响应内容过滤器
 * @author fanqingfeng
 * @date 2018/11/6 15:43
 */
@Configuration
public class ResponseConverter extends WebMvcConfigurationSupport {
    @Bean
    public HttpMessageConverter<String> stringConverter() {
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName(CharEncoding.UTF_8));
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.TEXT_HTML);
        supportedMediaTypes.add(MediaType.TEXT_PLAIN);
        stringHttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
        return stringHttpMessageConverter;
    }

    @Bean
    public HttpMessageConverter fastJsonConverters() {
        //创建FastJson信息转换对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        //创建FastJson对象并设定序列化规则
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                //格式化输出
                SerializerFeature.PrettyFormat,
                //输出值为null的字段
                SerializerFeature.WriteMapNullValue,
                //数字null转为0
                SerializerFeature.WriteNullNumberAsZero,
                //字符串null转为""
                SerializerFeature.WriteNullStringAsEmpty,
                //List数组null转为[]
                SerializerFeature.WriteNullListAsEmpty,
                //布尔值null转为false
                SerializerFeature.WriteNullBooleanAsFalse
        );
        fastConverter.setFastJsonConfig(fastJsonConfig);
        fastConverter.setSupportedMediaTypes(Lists.newArrayList(MediaType.APPLICATION_JSON_UTF8));
        return fastConverter;
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.clear();
        converters.add(stringConverter());
        converters.add(fastJsonConverters());
    }
}
