package com.imooc.bilibili.api.support;

import com.imooc.bilibili.domain.exception.ConditionException;
import com.imooc.bilibili.service.util.TokenUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
//验证token
public class UserSupport {
    public Long getCurrentUserId(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes(); //为了获取token，抓取请求上下文
        String token = requestAttributes.getRequest().getHeader("token");
        Long userId = TokenUtil.verifyToken(token);
        if(userId < 0){
            throw new ConditionException("非法用户！");
        }
        return userId;
    }
}
