package com.openLayersMap.www.Servlet;


import com.openLayersMap.www.BDConnect.AbstractMapper;
import com.openLayersMap.www.Model.Marker;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MapServlet extends HttpServlet {

    private AbstractMapper mapMapper = new AbstractMapper();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)  {
        response.setContentType("text/html;charset=utf-8");

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String type = request.getParameter("type");
        String coordinates = request.getParameter("coord");
        response.setContentType("text/html;charset=utf-8");
        long id = insertMarker(type, coordinates);
        response.getWriter().write((int) id);
    }

    private long insertMarker(String type, String coordinates) {
        Marker marker = new Marker(type, coordinates);
        return mapMapper.insertMarker(marker);
    }
}
