package com.openLayersMap.www.Servlet;

import com.google.gson.Gson;
import com.openLayersMap.www.BDConnect.AbstractMapper;
import com.openLayersMap.www.Model.Point;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/map/dot/*")
public class PointServlet extends HttpServlet {

    AbstractMapper dotMapper = new AbstractMapper();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
//        String json = gerAllMarkers();
//        response.getWriter().write(json);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Point dot = new Gson().fromJson(request.getReader(), Point.class);
        response.setContentType("text/html;charset=utf-8");
        if (dot.getId() == 0) {
            long id = insertPoint(dot);
            response.getWriter().write(String.valueOf(id));
        } else {
            updatePoint(dot);
        }
    }

    private long insertPoint(Point point) {
        return dotMapper.insertPoint(point);
    }

    private void updatePoint(Point point) {
        dotMapper.updatePoint(point);
    }

//    private String gerAllMarkers() {
//        List<Marker> markers = mapMapper.getAllMarkers();
//        return new Gson().toJson(markers);
//    }
}
