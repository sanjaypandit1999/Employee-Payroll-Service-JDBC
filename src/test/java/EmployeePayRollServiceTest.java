import com.bridgelabz.Employee;
import com.bridgelabz.EmployeePayRollDBService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EmployeePayRollServiceTest {
    EmployeePayRollDBService employeePayRollService = new EmployeePayRollDBService();
    @Test
    public void givenEmployeePayrollDB_WhenRetrieved_ShouldMatchEmployeeCount() {
        String sqlQuery = "select * from employee_payroll";
        List<Employee> employeePayrollDataList = employeePayRollService.readData(sqlQuery);
        int empCount = employeePayrollDataList.size();
        Assertions.assertEquals(5,empCount);
    }
}
