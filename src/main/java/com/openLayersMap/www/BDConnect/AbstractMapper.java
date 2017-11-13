package com.openLayersMap.www.BDConnect;


import com.openLayersMap.www.Model.Dot;
import com.openLayersMap.www.Model.Point;
import com.openLayersMap.www.Model.Line;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AbstractMapper {

    private BasicDataSource connect() throws SQLException {
        BasicDataSource dataSource = new BasicDataSource();
        try {
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUsername("root");
            dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/map?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    private SqlSessionFactory dataSource() throws SQLException {
        BasicDataSource dataSource = connect();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development",
                transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        sqlSessionFactory.getConfiguration().addMapper(FigureMapper.class);

        return sqlSessionFactory;

    }

    public long insertFigure(Line figure) {
        long id = 0;
        try {
            SqlSessionFactory sqlSessionFactory = dataSource();
            SqlSession session = sqlSessionFactory.openSession();
            FigureMapper mapper = session.getMapper(FigureMapper.class);
            mapper.insertMarker(figure.getType());
            id = mapper.getId();
            for (double[] dot : figure.getCoordinates()) {
                mapper.insertCoordinates(dot[0], dot[1], id);
            }
            session.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public void updateFigure(Line figure) {
        try {
            SqlSessionFactory sqlSessionFactory = dataSource();
            SqlSession session = sqlSessionFactory.openSession();
            FigureMapper mapper = session.getMapper(FigureMapper.class);
            List<Dot> dotOld = mapper.selectById(figure.getId());
            int size = dotOld.size();
            int i = 0;
            long coordsID;
            for (double[] coord : figure.getCoordinates()) {
                if (i < size) {
                    if ((dotOld.get(i).getLat() != coord[0]) || (dotOld.get(i).getLon() != coord[1])) {
                        coordsID = mapper.getFK(figure.getId(), i);
                        mapper.updateCoordinates(coord[0], coord[1], coordsID);
                    }
                } else {
                    mapper.insertCoordinates(coord[0], coord[1], figure.getId());
                }
                i++;
            }
            session.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Line> getAllMarkers() {
        List<Line> markers = new ArrayList<>();
        try {
            SqlSessionFactory sqlSessionFactory = dataSource();
            SqlSession session = sqlSessionFactory.openSession();
            FigureMapper mapper = session.getMapper(FigureMapper.class);
            markers = mapper.getAllMarkers();
            session.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return markers;
    }

    public long insertPoint(Point point) {
        long id = 0;
        try {
            SqlSessionFactory sqlSessionFactory = dataSource();
            SqlSession session = sqlSessionFactory.openSession();
            FigureMapper mapper = session.getMapper(FigureMapper.class);
            mapper.insertMarker(point.getType());
            id = mapper.getId();
            mapper.insertCoordinates(point.getCoordinates()[0], point.getCoordinates()[1], id);
            session.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public void updatePoint(Point point) {
        try {
            SqlSessionFactory sqlSessionFactory = dataSource();
            SqlSession session = sqlSessionFactory.openSession();
            FigureMapper mapper = session.getMapper(FigureMapper.class);
            mapper.updatePoint(point.getCoordinates()[0], point.getCoordinates()[1], point.getId());
            session.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFigure(long id) {
        try {
            SqlSessionFactory sqlSessionFactory = dataSource();
            SqlSession session = sqlSessionFactory.openSession();
            FigureMapper mapper = session.getMapper(FigureMapper.class);
            mapper.deleteFigureCoordinates(id);
            mapper.deleteFigure(id);
            session.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
