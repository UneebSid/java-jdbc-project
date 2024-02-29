import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao //{DAO = data Access Object}
{
    void addEmployee(Employee employee) throws SQLException; //insert
    void updateEmployee(Employee employee) throws SQLException; //update
    void deleteEmployee(int id) throws SQLException;  //delete
    List<Employee> getEmployees() throws SQLException; //select *
    Employee getEmployeeByID(int id) throws SQLException; // select
}
