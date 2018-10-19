package Models;

import java.sql.*;
import java.util.ArrayList;

public class DBConnect {

    private static String userName = "root";
    private static String password = "066981408";

    public static ArrayList<String> getPhoneManufacturers() throws SQLException {
        ArrayList<String> manufacturers = new ArrayList<>();
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            //1. connect to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/phones?useSSL=false",
                    userName, password);

            //2.  Create a statement object
            statement = conn.createStatement();

            //3.  create and execute the query
            resultSet = statement.executeQuery("SELECT * FROM manufacturers ORDER BY manufacturer");

            //4.  loop over the results and add to the ArrayList
            while (resultSet.next())
            {
                manufacturers.add(resultSet.getString("manufacturer"));
            }
        }
        catch (SQLException e)
        {
            System.err.println(e);
        }
        finally {
            if (conn != null)
                conn.close();
            if (statement != null)
                statement.close();
            if (resultSet != null)
                resultSet.close();
        }

        return manufacturers;
    }//end of getPhoneManufacturers()

    public static ArrayList<Phone> getPhones() throws SQLException {
        ArrayList<Phone> phones = new ArrayList<>();
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            //1. connect to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/phones?useSSL=false",
                    userName, password);

            //2.  Create a statement object
            statement = conn.createStatement();

            //3.  create and execute the query
            resultSet = statement.executeQuery("SELECT * FROM phones");

            //4.  loop over the results and add to the ArrayList
            while (resultSet.next())
            {
                Phone newPhone = new Phone(
                                    resultSet.getString("make"),
                                    resultSet.getString("model"),
                                    resultSet.getString("os"),
                                    resultSet.getDouble("screenSize"),
                                    resultSet.getDouble("memory"),
                                    resultSet.getDouble("frontCamRes"),
                                    resultSet.getDouble("rearCamRes"));

                phones.add(newPhone);
            }
        }
        catch (SQLException e)
        {
            System.err.println(e);
        }
        finally {
            if (conn != null)
                conn.close();
            if (statement != null)
                statement.close();
            if (resultSet != null)
                resultSet.close();
        }

        return phones;
    }//end of getPhones()

    public static ArrayList<String> getOSs() throws SQLException {
        ArrayList<String> manufacturers = new ArrayList<>();
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            //1. connect to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/phones?useSSL=false",
                    userName, password);

            //2.  Create a statement object
            statement = conn.createStatement();

            //3.  create and execute the query
            resultSet = statement.executeQuery("SELECT DISTINCT os FROM manufacturers");

            //4.  loop over the results and add to the ArrayList
            while (resultSet.next())
            {
                manufacturers.add(resultSet.getString("os"));
            }
        }
        catch (SQLException e)
        {
            System.err.println(e);
        }
        finally {
            if (conn != null)
                conn.close();
            if (statement != null)
                statement.close();
            if (resultSet != null)
                resultSet.close();
        }

        return manufacturers;
    }//end of getOSs()

    public static String getOSForManufacturer(String manufacturer) {
        String os = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
            //1. try to connect with the DB
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/phones?useSSL=false",
                    userName, password);

            //2. create a sql statement
            String sql = "SELECT os FROM manufacturers WHERE manufacturer=?";

            //3. create the prepared statement
            ps = conn.prepareStatement(sql);

            //4. bind values to the parameters
            ps.setString(1, manufacturer);

            //5. get the results
            resultSet=ps.executeQuery();

            //6. loop over the result(s)
            resultSet.next();
            os = resultSet.getString("os");

        }
        catch (SQLException e)
        {
            System.err.println(e);
        }
        return os;
    }//end of getOSForManufacturer

    public static void insertPhoneIntoDB(Phone newPhone) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        try{
            //1. connect to DB
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/phones?useSSL=false",  userName, password);

            //2. create a sql statement
            String sql = "INSERT INTO phones (make, model, os, sceenSize, memory, frontcamRes, rearCamRes) VALUES (?, ?, ?, ?, ?, ?, ?);";

            //3. Create a prepared statement
            ps = conn.prepareStatement(sql);

            //4. bind the paramters
            ps.setString(1, newPhone.getMake());
            ps.setString(2, newPhone.getModel());
            ps.setString(3, newPhone.getOs());
            ps.setDouble(4, newPhone.getScreenSize());
            ps.setDouble(5, newPhone.getMemory());
            ps.setDouble(6, newPhone.getFrontCameraRes());
            ps.setDouble(6, newPhone.getRearCameraRes());

            //5. execute the update
            ps.executeUpdate();

        }
        catch (SQLException e)
        {
            System.err.println(e);
        }
        finally {
            if (conn != null)
                conn.close();
            if(ps != null)
                ps.close();
        }
    }//end of getOSForManufacturer
}//end

