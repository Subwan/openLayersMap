package com.openLayersMap.www.Servlet;


import com.google.gson.Gson;
import com.openLayersMap.www.BDConnect.AbstractMapper;
import com.openLayersMap.www.Model.Line;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/map/line/*")
public class LineServlet extends HttpServlet {

    private AbstractMapper mapMapper = new AbstractMapper();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
//        String json = gerAllMarkers();
//        response.getWriter().write(json);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Line line = new Gson().fromJson(request.getReader(), Line.class);
        response.setContentType("text/html;charset=utf-8");
        if (line.getId() == 0) {
            long id = insertLine(line);
            response.getWriter().write(String.valueOf(id));
        } else {
            updateLine(line);
        }
    }

    private long insertLine(Line line) {
        return mapMapper.insertFigure(line);
    }

    private void updateLine(Line line) {
        mapMapper.updateFigure(line);
    }

//    private String gerAllMarkers() {
//        List<Marker> markers = mapMapper.getAllMarkers();
//        return new Gson().toJson(markers);
//    }
}


