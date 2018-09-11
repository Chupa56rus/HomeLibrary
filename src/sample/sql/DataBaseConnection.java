package sample.sql;

import java.sql.*;

public class DataBaseConnection {

    private static String username = "root";
    //private static String password = "berupe57";
    private static String password = "1q2w3e4r!Q@W#E$R";
    private static String url = "jdbc:mysql://localhost:3306/mysql";

    public static String getUrl() {
        return url;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }


    public static void tryConnection() throws ClassNotFoundException, SQLException {
        DataBaseConnection con = new DataBaseConnection();
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(con.url, con.username, con.password)) {
            System.out.println("We are connected");
        }

    }

    public static void createTables() throws ClassNotFoundException, SQLException {
        DataBaseConnection con = new DataBaseConnection();
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(con.url, con.username, con.password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("create database if not exists homelib;");
            statement.executeUpdate("CREATE TABLE if not exists homelib.t_users " +
                    "(f_user_id int(11) NOT NULL AUTO_INCREMENT," +
                    " f_user_username varchar(45) NOT NULL," +
                    " f_user_name varchar(45) NOT NULL," +
                    " f_user_password varchar(45) NOT NULL," +
                    " f_user_location varchar(100)," +
                    " f_user_email varchar(100)," +
                    " f_user_phonenumber varchar(100)," +
                    " PRIMARY KEY (f_user_id)," +
                    " UNIQUE KEY f_user_id_UNIQUE (f_user_id)," +
                    " UNIQUE KEY f_user_username_UNIQUE (f_user_username)," +
                    " UNIQUE KEY f_user_password_UNIQUE (f_user_password))" +
                    " ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Users table';");
        }
    }

}