package com.lifeifei.springboot.springbootbuild.components;

import com.lifeifei.springboot.springbootbuild.mode.Result;
import com.lifeifei.springboot.springbootbuild.mode.enums.ResultType;
import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;


public class HandlerMethodReturnValueHandlerProxy implements HandlerMethodReturnValueHandler {
    private HandlerMethodReturnValueHandler proxyObject;

    public HandlerMethodReturnValueHandlerProxy(HandlerMethodReturnValueHandler proxyObject) {
        this.proxyObject = proxyObject;
    }

    @Override
    public boolean supportsReturnType(MethodParameter methodParameter) {
        return this.proxyObject.supportsReturnType(methodParameter);
    }

    /**
     * 作者：icarusliu81
     * 来源：CSDN
     * 原文：https://blog.csdn.net/icarusliu/article/details/80515222
     * 版权声明：本文为博主原创文章，转载请附上博文链接！
     *
     * @param o
     * @param methodParameter
     * @param nativeWebRequest
     * @throws Exception
     */
    @Override
    public void handleReturnValue(Object o, MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest) throws Exception {
        Result<Object> result = new Result<>(STATUS_CODE_SUCCEEDED,
                ResultType.SUCCESS.name(), o);
        proxyObject.handleReturnValue(result, methodParameter, modelAndViewContainer, nativeWebRequest);
    }

    private static final String STATUS_CODE_SUCCEEDED = "200";
}
