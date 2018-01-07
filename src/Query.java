import java.sql.Connection;
import java.sql.SQLException;

public interface Query {

    void SelectFrom(Connection connection) throws Exception;

    void CloseCon(Connection connection) throws SQLException;

    void InputNewData(Connection connection, String firstName, String lastName,
                      String phone, String email) throws SQLException;

    void DeleteData(Connection connection, Integer id) throws SQLException;

}
