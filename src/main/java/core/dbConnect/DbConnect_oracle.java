package core.dbConnect;

import core.configuration.TestsConfig;

import java.sql.*;

public class DbConnect_oracle {
    public DbConnect_oracle(){}

    //DB Credentials
    public static String url = TestsConfig.getConfig().getDbUrl();
    public static String username = TestsConfig.getConfig().getDbUsername();
    public static String password = TestsConfig.getConfig().getDbPassword();

    static Connection connection = null;
    static Statement statement = null;

    public static void connectDb(String url, String username, String password) throws ClassNotFoundException, SQLException {

        Class.forName("oracle.jdbc.driver.OracleDriver"); // load oracle driver
        connection = DriverManager.getConnection(url, username, password); //DB connection
    }

    //Sample database connection (Vistajet)
    public static String getVerificationCode() throws SQLException {
        String Verif_Code = "";
        String query =
                "select * from VJ_EXTERNAL_APP_CONFIG " +
                        "where key = 'DUMMY_VERIFICATION_CODE' ";

        try {
            connectDb(url, username, password);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Verif_Code = resultSet.getString("VALUE");
                System.out.println(Verif_Code);
            }

            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        } finally {
            statement.close();
            connection.close();
        }

        return Verif_Code;
    }
}
