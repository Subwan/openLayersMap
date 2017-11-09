package com.openLayersMap.www.BDConnect;


import com.openLayersMap.www.Model.Marker;
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
            dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/marker?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
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
        sqlSessionFactory.getConfiguration().addMapper(MapMapper.class);

        return sqlSessionFactory;

    }

    public long insertMarker(Marker marker) {
        long id = 0;
        try {
            SqlSessionFactory sqlSessionFactory = dataSource();
            SqlSession session = sqlSessionFactory.openSession();
            MapMapper mapper = session.getMapper(MapMapper.class);
            id = mapper.insertMarker(marker.getType(), marker.getCoordinates());
            session.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public void updateMarker(Marker marker) {
        try {
            SqlSessionFactory sqlSessionFactory = dataSource();
            SqlSession session = sqlSessionFactory.openSession();
            MapMapper mapper = session.getMapper(MapMapper.class);
            mapper.updateMarker(marker.getId(), marker.getType(), marker.getCoordinates());
            session.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Marker> getAllMarkers() {
        List<Marker> markers = new ArrayList<>();
        try {
            SqlSessionFactory sqlSessionFactory = dataSource();
            SqlSession session = sqlSessionFactory.openSession();
            MapMapper mapper = session.getMapper(MapMapper.class);
            markers = mapper.getAllMarkers();
            session.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return markers;
    }
}
