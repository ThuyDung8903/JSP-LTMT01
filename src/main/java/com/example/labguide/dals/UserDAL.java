package com.example.labguide.dals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAL {
    public static boolean login(Connection connection, String username, String password) throws SQLException {
        String sql = "SELECT COUNT(*) FROM `users` WHERE `nick_name` = ? AND `pass` = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                resultSet.next();
                int count = resultSet.getInt(1);
                return count > 0;
            }
        }
    }
}
