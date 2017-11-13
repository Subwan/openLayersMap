package com.openLayersMap.www.Servlet;

import com.google.gson.Gson;
import com.openLayersMap.www.BDConnect.AbstractMapper;

import com.openLayersMap.www.Model.Line;
import com.openLayersMap.www.Model.Polygon;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/map/polygon/*")
public class PolygonServlet extends HttpServlet {

        private AbstractMapper mapMapper = new AbstractMapper();

        @Override
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
            response.setContentType("text/html;charset=utf-8");
//        String json = gerAllMarkers();
//        response.getWriter().write(json);

        }

        @Override
        public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
            Polygon polygon = new Gson().fromJson(request.getReader(), Polygon.class);
            response.setContentType("text/html;charset=utf-8");
            if (polygon.getId() == 0) {
                long id = insertPolygon(polygon);
                response.getWriter().write(String.valueOf(id));
            } else {
                updatePolygon(polygon);
            }
        }

        private long insertPolygon(Polygon polygon) {
            Line line = new Line(polygon.getType(), refactorCoords(polygon));
            return mapMapper.insertFigure(line);
        }

    private void updatePolygon(Polygon polygon) {
            Line line = new Line(polygon.getId(), polygon.getType(), refactorCoords(polygon));
            mapMapper.updateFigure(line);
        }

    private List<double[]> refactorCoords(Polygon polygon) {
        List<double[]> coords = new ArrayList<>();
        coords = polygon.getCoordinates().get(0);
        return coords;
    }

//    private String gerAllMarkers() {
//        List<Marker> markers = mapMapper.getAllMarkers();
//        return new Gson().toJson(markers);
//    }
}

