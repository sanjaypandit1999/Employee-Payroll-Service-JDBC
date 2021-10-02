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
    @Test
    public void givenBasicPay_whenUpdated_ShouldReturnUpdateBasicPay() {
        EmployeePayRollDBService employeePayroll = new EmployeePayRollDBService();
        String UPDATE = "UPDATE employee_payroll SET Basic_Pay = ? WHERE name = ?";
        double Basic_Pay = 3000000.0;
        String Name = "Monisha";
        double salaryUpdated = employeePayroll.updateBasicPay(UPDATE, Name, Basic_Pay);
        Assertions.assertEquals(Basic_Pay, salaryUpdated);
    }
    @Test
    void givenDataRange_WhenRetrieved_Should_ReturnEmployeeCount(){
        EmployeePayRollDBService employeePayroll = new EmployeePayRollDBService();
        String start = "2021-02-25";
        String end = "2022-05-25";
        List<Employee> employeeList = employeePayroll.retrieveEmployeeByGivenDataRange(start,end);
        Assertions.assertEquals(4,employeeList.size());
    }
}
