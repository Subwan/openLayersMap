package com.openLayersMap.www.Servlet;

import com.google.gson.Gson;
import com.openLayersMap.www.BDConnect.AbstractMapper;
import com.openLayersMap.www.Model.Figure;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/map/figure/*")
public class FigureServlet extends HttpServlet {

    private AbstractMapper mapMapper = new AbstractMapper();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        String json = gerAllMarkers();
        response.getWriter().write(json);

    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Figure figure = new Gson().fromJson(request.getReader(), Figure.class);
        response.setContentType("text/html;charset=utf-8");
        if (figure.getId() == 0) {
            long id = insertFigure(figure);
            response.getWriter().write(String.valueOf(id));
        } else {
            updateFigure(figure);
        }
    }

    private long insertFigure(Figure figure) {
        return mapMapper.insertFigure(figure);
    }

    private void updateFigure(Figure figure) {
        mapMapper.updateFigure(figure);
    }

    private String gerAllMarkers() {
        List<Figure> figures = mapMapper.getAllFigures();
        String json = new Gson().toJson(figures);
        return json;
    }
}
