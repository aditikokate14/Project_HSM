package com.hospital;

import java.sql.*;

public class UserDAO {
    public static User getUserById(int id) {
        User user = null;
        try {
            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM users WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setMobile(rs.getLong("mobile"));
                user.setHospital(rs.getString("hospital_name")); // ✅ match DB column
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
