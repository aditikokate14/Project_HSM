package com.hospital;
import java.sql.*;

public class RegistrationDAO {
    public static int save(String name, Long mobile, String email, String password, String hospital_name ) {
        int status = 0;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO users(name,mobile,email,password,hospital_name) VALUES(?,?,?,?,?)");
            ps.setString(1, name);
            ps.setLong(2, mobile);
            ps.setString(3, email);
            ps.setString(4, password);
            ps.setString(5, hospital_name);
            status = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
