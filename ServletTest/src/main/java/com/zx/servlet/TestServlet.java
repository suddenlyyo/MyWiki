package com.zx.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * <p>
 * description: Servlet 测试 <br>
 * create: 2024-03-06 14:09 <br>
 * </p>
 *
 * @author zhou  xun
 */
@WebServlet("/testServlet")
public class TestServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");
        String userName = req.getParameter("userName");
        String result = "服务端servlet已经收到请求:" + userName;
        PrintWriter writer = resp.getWriter();
        writer.write(result);
    }


}
