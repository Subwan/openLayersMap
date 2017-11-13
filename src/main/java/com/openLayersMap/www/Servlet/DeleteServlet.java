package com.openLayersMap.www.Servlet;


import com.openLayersMap.www.BDConnect.AbstractMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/map/delete/*")
public class DeleteServlet  extends HttpServlet {

    AbstractMapper mapMapper = new AbstractMapper();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        long id = Long.parseLong(request.getParameter("id"));
        deleteFigure(id);
    }

    private void deleteFigure(long id) {
        mapMapper.deleteFigure(id);
    }
}
