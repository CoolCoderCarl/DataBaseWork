import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Connections implements Query{

    public void db_Work() {

        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/contactdb";
            String login = "postgres";
            String password = "root";
            Connection con = DriverManager.getConnection(url, login, password);
            System.out.println("Connections success !");

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String command;
            System.out.print("Type command: ");
            do {
                command = reader.readLine().trim();
                try {

                    if (command.equals("close")){
                        CloseCon(con);
                    }
                    if (command.equals("select")){
                        SelectFrom(con);
                    }
                    if (command.equals("input")){
                        System.out.println("Type first name: ");
                        String firstName = reader.readLine().trim();
                        System.out.println("Type last name: ");
                        String lastName = reader.readLine().trim();
                        System.out.println("Type phone: ");
                        String phone = reader.readLine().trim();
                        System.out.println("Type email: ");
                        String email = reader.readLine().trim();

                        InputNewData(con, firstName, lastName, phone, email);

                    }
                    if (command.equals("delete")){
                        System.out.println("Type id for delete: ");
                        String id = reader.readLine().trim();
                        Integer newid = Integer.parseInt(id);
                        DeleteData(con, newid);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } while (command.equals("EXIT"));

        } catch (Exception e) {
            System.out.println("Error message - " + e.getMessage());
            e.printStackTrace();
        }
    }

//----------------------------------------------------------------------------------------------------------------------
    @Override
    public void SelectFrom(Connection connection) throws Exception {
       RealQuery.RealSelect(connection);
    }
//----------------------------------------------------------------------------------------------------------------------
    @Override
    public void CloseCon(Connection connection) throws SQLException {
        RealQuery.RealCloseCon(connection);
    }
//----------------------------------------------------------------------------------------------------------------------
    @Override
    public void InputNewData(Connection connection, String firstName, String lastName, String phone, String email)
            throws SQLException {
        RealQuery.RealInputNewData(connection,firstName, lastName, phone, email);
    }
//----------------------------------------------------------------------------------------------------------------------
    @Override
    public void DeleteData(Connection connection, Integer id) throws SQLException {
        RealQuery.DeleteData(connection, id);

    }
//----------------------------------------------------------------------------------------------------------------------
}
