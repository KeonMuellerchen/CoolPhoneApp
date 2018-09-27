package Models;

import java.sql.SQLException;

public class DBtest {
    public static void main(String[] args){
        try {
            System.out.println(DBConnect.getPhoneManufacturers());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//end
}
