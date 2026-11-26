package pcodes.EmployeeManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pcodes.EmployeeManagementSystem.entity.Employee;
import pcodes.EmployeeManagementSystem.model.EmployeeAddRequest;
import pcodes.EmployeeManagementSystem.model.EmployeeAddResponse;
import pcodes.EmployeeManagementSystem.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public EmployeeAddResponse addEmployee(EmployeeAddRequest employeeAddRequest) {

        Employee employee = new Employee();
        employee.setName(employeeAddRequest.getName());
        employee.setDepartment(employeeAddRequest.getDepartment());
        employee.setSalary(employeeAddRequest.getSalary());

        Employee storedEmployee = repository.save(employee);
        return new EmployeeAddResponse(storedEmployee.getId(), storedEmployee.getName(), storedEmployee.getDepartment());
    }

    public List<EmployeeAddResponse> getAllEmployees() {
        List<Employee> employees = repository.findAll();
        List<EmployeeAddResponse> employeeResponses = new ArrayList<>();

        for (Employee e : employees) {
            EmployeeAddResponse response = new EmployeeAddResponse(e.getId(), e.getName(),e.getDepartment());
            employeeResponses.add(response);
        }
        return employeeResponses;
    }

    public EmployeeAddResponse getEmployeeById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Employee ID cannot be null");
        }
        Employee dbemployee = repository.findById(id).orElseThrow(()->new RuntimeException("Employee not found with id: " + id));
        return new EmployeeAddResponse(dbemployee.getId(), dbemployee.getName(),dbemployee.getDepartment());
    }

    public List<Employee> getEmployeesByDepartment(String department) {
      return repository.findBydepartment(department);
//        List<EmployeeAddResponse> employeeResponses = new ArrayList<>();
//
//        for (Employee e : employees) {
//            EmployeeAddResponse response = new EmployeeAddResponse(e.getId(), e.getName());
//            employeeResponses.add(response);
//        }
//        return employeeResponses;
    }


    public Employee updateEmployee(EmployeeAddRequest request, Long id){
        if(id==null || request ==null)return null;
        Employee dbEmployee = repository.findById(id).orElseThrow(()->new RuntimeException("Employee not found with id: " + id));
        if(dbEmployee.getName()!=null)dbEmployee.setName(request.getName());
        if(dbEmployee.getDepartment()!=null)dbEmployee.setDepartment(request.getDepartment());
        if(dbEmployee.getSalary()!=null)dbEmployee.setSalary(request.getSalary());
        return repository.save(dbEmployee);
    }





}
