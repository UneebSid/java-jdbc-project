import java.rmi.ConnectException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

public class EmployeeDaoImpl implements EmployeeDao
{
    Connection connection;

    public EmployeeDaoImpl()
    {
        connection = ConnectionFactory.getConnection();
    }
    @Override
    public void addEmployee(Employee employee) throws SQLException {
        String sql = "insert into employee (name, email) values (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,employee.getName());
        preparedStatement.setString(2, employee.getEmail());
        int count = preparedStatement.executeUpdate();
        if(count > 0)
        {
            System.out.println("Employee added ");
        }
        else
        {
            System.out.println("oops, something went wrong, please try again!");
        }
    }

    @Override
    public void updateEmployee(Employee employee) throws SQLException {
        String sqlName = "update employee set name =?, email=? where id =?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlName);
        preparedStatement.setString(1,employee.getName());
        preparedStatement.setString(2,employee.getEmail());
        preparedStatement.setInt(3,employee.getId());
        int count = preparedStatement.executeUpdate();
        if(count > 0)
        {
            System.out.println("Employee updated ");
        }
        else
        {
            System.out.println("oops, something went wrong, please try again!");
        }

    }

    @Override
    public void deleteEmployee(int id) throws SQLException {
        String sql = "delete from employee where id=" + id;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int count = preparedStatement.executeUpdate();
        if(count > 0)
        {
            System.out.println("Employee deleted");
        }
        else
        {
            System.out.println("oops, something went wrong, please try again!");
        }
    }

    @Override
    public List<Employee> getEmployees() throws SQLException {
        String sql = "select * from employee";
        List<Employee> employeeList = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            Employee employee = new Employee();
            employee.setName(resultSet.getString("name"));
            employee.setEmail(resultSet.getString("email"));
            employee.setId(resultSet.getInt("id"));
            employeeList.add(employee);
        }


        return employeeList;
    }

    @Override
    public Employee getEmployeeByID(int id) throws SQLException {
        String sql = "select * from employee where id =" + id;
        Employee employee = new Employee();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            employee.setEmail(resultSet.getString("email"));
            employee.setName(resultSet.getString("name"));
            employee.setId(resultSet.getInt("id"));
        }else
        {
            System.out.println("No matching result");
        }
        return employee;
    }
}
