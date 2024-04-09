package com.codingbox.mylogin.intercepter;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

public class LogInterceptor implements HandlerInterceptor {

    public static final String LOG_ID = "logId";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String reqURI = request.getRequestURI();
        String uuid = UUID.randomUUID().toString();

        request.setAttribute(LOG_ID,uuid);

        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
        }

        System.out.println("[inteceptor] uuid : "+uuid);
        System.out.println("[inteceptor] reqURI : "+reqURI);
        System.out.println("[inteceptor] handler : "+handler);

        return true; // if return == false -> 진행 X
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        System.out.println("[inteceptor] postHandle : "+modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        String reqURI = request.getRequestURI();
        String logId = (String) request.getAttribute(LOG_ID);

        System.out.println("[intecepter] logID : " + logId);
        System.out.println("[intecepter] reqURI : " + reqURI);
    }
}
