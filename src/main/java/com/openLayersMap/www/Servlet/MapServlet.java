package com.openLayersMap.www.Servlet;


import com.google.gson.Gson;
import com.openLayersMap.www.BDConnect.AbstractMapper;
import com.openLayersMap.www.Model.Marker;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class MapServlet extends HttpServlet {

    private AbstractMapper mapMapper = new AbstractMapper();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)  {
        response.setContentType("text/html;charset=utf-8");
        String json = gerAllMarkers();
        try {
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String method = request.getParameter("method");
        String type = request.getParameter("type");
        String coordinates = request.getParameter("coord");
        response.setContentType("text/html;charset=utf-8");
        if (Objects.equals(method, "insert")) {
            long id = insertMarker(type, coordinates);
            response.getWriter().write((int) id);
        } else if (Objects.equals(method, "modify")) {
            long id = Long.parseLong(request.getParameter("id"));
            updateMarker(id, type, coordinates);
        }
    }

    private long insertMarker(String type, String coordinates) {
        Marker marker = new Marker(type, coordinates);
        return mapMapper.insertMarker(marker);
    }

    private void updateMarker(long id, String type, String coordinates) {
        Marker marker = new Marker(id, type, coordinates);
        mapMapper.updateMarker(marker);
    }

    private String gerAllMarkers() {
        List<Marker> markers = mapMapper.getAllMarkers();
        return new Gson().toJson(markers);
    }
}
