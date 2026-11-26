package pcodes.EmployeeManagementSystem.controller;

import org.springframework.web.bind.annotation.*;
import pcodes.EmployeeManagementSystem.entity.Employee;
import pcodes.EmployeeManagementSystem.model.EmployeeAddRequest;
import pcodes.EmployeeManagementSystem.model.EmployeeAddResponse;
import pcodes.EmployeeManagementSystem.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/check")
    public String check(){
        return "Server is running";
    }

    @PostMapping("/add")
    public EmployeeAddResponse addEmployee(@RequestBody EmployeeAddRequest employee){
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/all")
    public List<EmployeeAddResponse> getAllEmployee(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeAddResponse getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/department/{department}")
    public List<Employee> getEmployeeDepartment(@PathVariable String department){
        return employeeService.getEmployeesByDepartment(department);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@RequestBody EmployeeAddRequest request, @PathVariable Long id){
        return employeeService.updateEmployee(request,id);
    }
}
