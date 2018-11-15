package view;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Mail;

public class MailListReaderDB {
    
    private Connection connect() {
        String url = "jdbc:sqlite:mail.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public List<Mail> read(){
        
        String sql = "SELECT * FROM direcc_email";
        List<Mail> mailList = new LinkedList<>();
        Mail mail;
            
        try (Connection conn = this.connect();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)){

            while (rs.next()) {
                mail = new Mail(rs.getString("Mail"));
                mailList.add(mail);
            }
            
            return mailList;
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            return mailList;
        }
    }
}
