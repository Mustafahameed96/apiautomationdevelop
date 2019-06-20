package core.dbConnect;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import core.configuration.TestsConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbConnect_mySql {
    public DbConnect_mySql(){}

    //DB Credentials
    public static String username = TestsConfig.getConfig().getDbUserNameMySql();
    public static String password = TestsConfig.getConfig().getDbPasswordMySql();
    public static String server = TestsConfig.getConfig().getDbServerMySql();

    public static Connection dbConnection() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser(username);
        dataSource.setPassword(password);
        dataSource.setServerName(server);
//        dataSource.setPortNumber(3306);
        Connection conn = dataSource.getConnection();
        return  conn;
    }

    public static List<String> getDataFromPatientConsentTable(String hcNumber) throws SQLException {

        List<String> data = new ArrayList<>();

        Connection conn = dbConnection();
        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT * FROM droobi.patient_consents where hc_number = 'HC12345677';");
        ResultSet rs = stmt.executeQuery("SELECT CONVERT(email USING utf8) as email, CONVERT(name USING utf8) as name, hospital_id, CONVERT(phone USING utf8) as phone, CONVERT(hc_number USING utf8) as hc_number, status FROM  droobi.patient_consents where hc_number = '"+ hcNumber +"';");
        rs.setFetchSize(100);
        while (rs.next()){
            data.add(rs.getString("email"));
            data.add(rs.getString("name"));
            data.add(rs.getString("hospital_id"));
            data.add(rs.getString("phone"));
            data.add(rs.getString("hc_number"));
            data.add(rs.getString("status"));
            break;
        }
        rs.close();
        stmt.close();
        conn.close();

        return data;

    }
}
