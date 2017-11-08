package com.openLayersMap.www.Servlet;


import com.openLayersMap.www.BDConnect.AbstractMapper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MapServlet extends HttpServlet {

    private AbstractMapper mapMapper = new AbstractMapper();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)  {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String type = request.getParameter("type");
        response.setContentType("text/html;charset=utf-8");
        long id = findId(type);
        response.getWriter().write((int) id);
    }

    private long findId(String type) {
        long id = mapMapper.findId(type);
        return id;
    }
}
