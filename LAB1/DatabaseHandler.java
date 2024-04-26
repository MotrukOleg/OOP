import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DatabaseHandler extends  Config {
    Connection dbConnection;
    public Connection getDbConnection() throws  ClassNotFoundException , SQLException{
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbport + "/" + dbName;

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString , dbUser , dbPass);
        if(dbConnection != null){
            System.out.println("Database Connected successfully");
        }
        else {
            System.out.println("Database Connection failed");
        }

        return  dbConnection;
    }

    public  void signUpUser(String Name , String  Surname , String Phone_number ,String Time){
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" +
                Const.USERS_NAME + "," +
                Const.USERS_SURNAME + "," +
                Const.USERS_PHONE_NUMBER + "," +
                Const.USERS_TIME + ")" +
                "VALUES(?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1 , Name );
            prSt.setString(2 , Surname );
            prSt.setString(3 , Phone_number);
            prSt.setString(4 , Time );
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void signUpCar(String Name , String Model  , String Doors , String TypeOfVehicle){
        String insert = "INSERT INTO " + Const.VEHICLE_TABLE + "(" +
                Const.VEHICLE_NAME + "," +
                Const.VEHICLE_MODEL+ "," +
                Const.VEHICLE_DOORS + "," +
                Const.VEHICLE_TYPE  +
                ")" +
                "VALUES(?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1 , Name );
            prSt.setString(2 , Model );
            prSt.setString(3 , Doors);
            prSt.setString(4 , TypeOfVehicle);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void signUpMoto(String Name , String Model , String Doors ,  String TypeOfVehicle){
        String insert = "INSERT INTO " + Const.VEHICLE_TABLE+ "(" +
                Const.VEHICLE_NAME + "," +
                Const.VEHICLE_MODEL+ "," +
                Const.VEHICLE_DOORS+ "," +
                Const.VEHICLE_TYPE +
                ")" +
                " VALUES(?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1 , Name );
            prSt.setString(2 , Model );
            prSt.setString(3 , Doors );
            prSt.setString(4 , TypeOfVehicle);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}