//package core.dbConnect;
//
//import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
//import core.configuration.TestsConfig;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DbConnect_mySql {
//    public DbConnect_mySql(){}
//
//    //DB Credentials
//    public static String username = TestsConfig.getConfig().getDbUserNameMySql();
//    public static String password = TestsConfig.getConfig().getDbPasswordMySql();
//    public static String server = TestsConfig.getConfig().getDbServerMySql();
//    static Connection connection = null;
//    static Statement statement = null;
//
//    public static Connection dbConnection() throws SQLException {
//        MysqlDataSource dataSource = new MysqlDataSource();
//        dataSource.setUser(username);
//        dataSource.setPassword(password);
//        dataSource.setServerName(server);
//        dataSource.setPortNumber(3306);
//        Connection conn = dataSource.getConnection();
//        return  conn;
//    }
//
////    public static List<String> getDataFromPatientConsentTable(String hcNumber) throws SQLException {
////        String query = "";
////
////        List<String> data = new ArrayList<>();
////        ArrayList orderIds = new ArrayList();
////
////
////        Connection conn = dbConnection();
////        Statement stmt = conn.createStatement();
//////        ResultSet rs = stmt.executeQuery("SELECT * FROM droobi.patient_consents where hc_number = 'HC12345677';");
//////        ResultSet rs = stmt.executeQuery("SELECT CONVERT(email USING utf8) as email, CONVERT(name USING utf8) as name, hospital_id, CONVERT(phone USING utf8) as phone, CONVERT(hc_number USING utf8) as hc_number, status FROM  droobi.patient_consents where hc_number = '"+ hcNumber +"';");
////        ResultSet rs = stmt.executeQuery("SELECT booking_confirmation_id FROM servicemarket_business.booking_confirmation WHERE booking_id=53045");
////        rs.setFetchSize(100);
//////        while (rs.next()){
//////            data.add(rs.getString("email"));
//////            data.add(rs.getString("name"));
//////            data.add(rs.getString("hospital_id"));
//////            data.add(rs.getString("phone"));
//////            data.add(rs.getString("hc_number"));
//////            data.add(rs.getString("status"));
//////            break;
//////        }
////        statement = connection.createStatement();
////        rs = statement.executeQuery(query);
////        rs.setFetchSize(100);
////
////        while(rs.next()) {
////            orderIds.add(rs.getString("booking_confirmation_id"));
////        }
////        rs.close();
////        stmt.close();
////        conn.close();
////
////        return data;
////
////    }
//}
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package core.dbConnect;

import com.relevantcodes.extentreports.LogStatus;
import core.configuration.TestsConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static utils.LogHelper.logStep;

public class DbConnect_mySql {
    public static String url = TestsConfig.getConfig().getDbUrl();
    public static String username = TestsConfig.getConfig().getDbUsername();
    public static String password = TestsConfig.getConfig().getDbPassword();
    static Connection connection = null;
    static Statement statement = null;

    public DbConnect_mySql() {
    }

    public static void connectDb(String url, String username, String password) throws ClassNotFoundException, SQLException {
        connection = DriverManager.getConnection(url, username, password);
        logStep("DB connected");
    }

    public static
//    List<String>
   void
    ConnectDataBase() throws SQLException {
//        String query = "";
//        ResultSet rs = null;
//        ArrayList orderIds = new ArrayList();

        try {
            connectDb(url, username, password);
        } catch (ClassNotFoundException var4) {
            var4.printStackTrace();
        }
//
//        query = "SELECT booking_confirmation_id FROM servicemarket_business.booking_confirmation WHERE booking_id=53045";
//        statement = connection.createStatement();
//        rs = statement.executeQuery(query);
//        rs.setFetchSize(100);

//        while(rs.next()) {
//         //   orderIds.add(rs.getString("booking_confirmation_id"));
//        }

//        rs.close();
//        statement.close();
       // return orderIds;
    }
    public static List<String> orderIdlist() throws SQLException {
        String query = "";
        ResultSet rs = null;
        ArrayList orderIds = new ArrayList();



        query = "SELECT booking_confirmation_id FROM servicemarket_business.booking_confirmation WHERE booking_id=53045";
        statement = connection.createStatement();
        rs = statement.executeQuery(query);
        rs.setFetchSize(100);

        while(rs.next()) {
            orderIds.add(rs.getString("booking_confirmation_id"));
        }

        rs.close();
        statement.close();
         return orderIds;
    }


}
