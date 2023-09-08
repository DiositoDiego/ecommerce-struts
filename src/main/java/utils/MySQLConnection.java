package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MySQLConnection {

    private static String host;
    private static String dbName;
    private static String user;
    private static String password;
    private static String port;
    private static ResourceBundle propiedadesBD;
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        if( propiedadesBD == null ) {
            propiedadesBD = ResourceBundle.getBundle("connection");
            host = propiedadesBD.getString("host");
            dbName = propiedadesBD.getString("db_name");
            user = propiedadesBD.getString("user");
            password = propiedadesBD.getString("password");
            port = propiedadesBD.getString("port");
        }

        return DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+dbName+"?serverTimezone=UTC",user,password);
    }

    public static void main(String [] args){
        try{
            Connection con = getConnection();
            System.out.println("Conexion efectuada...");
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
