package com.hitech.hitech.intercaptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**  定义一个拦截器 **/
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 检测session是否有uid，有则放行，无则重定向到登录界面
     * @param request 请求对象
     * @param response 响应对象
     * @param handler 处理器（路径映射）
     * @return 如果返回true：表示放行，如果返回false表示拦截
     * @throws Exception
     */
    @Override//所有请求方法之前
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //通过HttpServletRequest获取session
        Object uid = request.getSession().getAttribute("uid");
        Object id = request.getSession().getAttribute("id");
        if (uid == null&& id == null) { // uid为空，用户未登录，转跳到登录界面
            response.sendRedirect("/login");
            //结束后续调用
            return false;
        }
        //请求放行
        return true;
    }

    @Override//在ModelAndView对象返回之后调用
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override//在整个请求整个关联资源执行之后
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
