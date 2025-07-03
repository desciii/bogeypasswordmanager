package com.descii.bpm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PasswordManager {

    public static boolean addPassword(int userId, String website, String login, String password) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO passwords (user_id, website, username, password) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            stmt.setString(2, website);
            stmt.setString(3, login);
            stmt.setString(4, EncryptionHelper.encrypt(password)); // 🔐 encrypt here

            int rowsInserted = stmt.executeUpdate();
            stmt.close();
            conn.close();
            return rowsInserted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
