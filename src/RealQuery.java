import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RealQuery {
//----------------------------------------------------------------------------------------------------------------------
    static public void RealSelect(Connection connection) throws Exception{
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM JC_CONTACT");
        while (rs.next()) {
            String id_firstName = rs.getString("contact_id") + " : " + rs.getString(2);
            String lastName_phone = rs.getString("last_name") + " : " + rs.getString("phone");
            String email = rs.getString("email");
            System.out.println("Contact: " + id_firstName + " : " + lastName_phone + " : " + email);
        }
        rs.close();
        stmt.close();
    }
//----------------------------------------------------------------------------------------------------------------------
    static public void RealCloseCon(Connection connection) throws SQLException{
        connection.close();
        System.out.println("Connection was closed.");
    }
//----------------------------------------------------------------------------------------------------------------------
    static public void RealInputNewData(Connection connection, String firstName,
                                        String lastName, String phone, String email) throws SQLException {
        System.out.println("Start to input values...");
        Statement stmt = connection.createStatement();
        stmt.executeQuery("INSERT INTO JC_CONTACT (FIRST_NAME, LAST_NAME, PHONE, EMAIL) VALUES"
                + "(" + "'" + firstName + "'" + ", " + "'" + lastName + "'" + ", " + "'" + phone + "'" +
                ", " + "'" + email + "'" + ");");
        stmt.close();
    }
//----------------------------------------------------------------------------------------------------------------------
    static public void DeleteData(Connection connection, Integer id) throws SQLException{
        System.out.println("Start to delete data...");
        Statement stmt = connection.createStatement();
        stmt.executeQuery("DELETE FROM JC_CONTACT WHERE contact_id = " +  id  + ";");
        stmt.close();
    }
}
