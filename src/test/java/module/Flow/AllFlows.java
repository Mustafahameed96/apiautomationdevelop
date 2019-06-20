package module.Flow;

import core.general.BaseTest;
import core.general.ReusableMethods;
import module.Validations.*;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

public class AllFlows extends BaseTest{
    public AllFlows(){}

    @Test
    public void createNewEmployee(){
        logStep("Create new employee");
        CreateEmployees.sanityFlowCreateEmployees("Maaz", "10", "");
    }

    @Test
    public void updateEmployeeDetails() throws SQLException, ClassNotFoundException {
        logStep("Update employee details");

        FetchEmployees.sanityFlowFetchEmployees();

        List<String> id = response.jsonPath().getJsonObject("id");
        int random = ReusableMethods.generateRandomIntIntRange(0, 10);

        FetchRespectiveEmployees.sanityFlowFetchRespectiveEmployees(id.get(0));

        String name = response.path("employee_name").toString();
        String salary = response.path("employee_salary").toString();
        String age = response.path("employee_age").toString();

        UpdateEmployeeDetails.sanityFlowUpdateEmployeeDetails(id.get(0), name, salary, age);
    }

    @Test
    public void deleteEmployeeDetails() throws SQLException, ClassNotFoundException {
        logStep("Delete employee details");

        FetchEmployees.sanityFlowFetchEmployees();

        List<String> id = response.jsonPath().getJsonObject("id");
        DeleteEmployees.sanityFlowDeleteEmployees(id.get(5));
    }

}
