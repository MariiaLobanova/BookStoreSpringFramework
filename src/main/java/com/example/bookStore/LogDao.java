package com.example.bookStore;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LogDao {

    private DBConnection dbConnection;

    @Autowired
    public LogDao(DBConnection dbConnection){
        this.dbConnection= dbConnection;
    }
    public LogDao() {}

    public List<Log> getAllLogs() {

        List<Log> logList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM logs");
            while (rs.next()) {
                Log log = new Log(rs.getInt("id"),
                        rs.getString("host"),
                        rs.getString("headers"),
                        rs.getString("body"),
                        rs.getInt("status"),
                        rs.getDate("createdAt"),
                        rs.getDate("updatedAt"),
                        rs.getString("response"));

                logList.add(log);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return logList;
    }

}
