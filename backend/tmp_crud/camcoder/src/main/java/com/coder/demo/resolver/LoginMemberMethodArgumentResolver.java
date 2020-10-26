package com.coder.demo.resolver;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.coder.demo.component.LoginUser;
import com.coder.demo.exception.InvalidAuthenticationException;
import com.coder.demo.service.UserService;
import com.coder.demo.vo.User;


@Component
public class LoginMemberMethodArgumentResolver implements HandlerMethodArgumentResolver {
    private final UserService userService;

    public LoginMemberMethodArgumentResolver(UserService userService) {
        this.userService = userService;
    }
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(LoginUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws InvalidAuthenticationException {
        String id = (String) webRequest.getAttribute("loginUserId", 0);
        if (StringUtils.isBlank(id)) {
            return new User();
        }
        try {
            return userService.selectOneByID(id);
        } catch (Exception e) {
            throw new InvalidAuthenticationException("비정상적인 로그인");
        }
    }
}
