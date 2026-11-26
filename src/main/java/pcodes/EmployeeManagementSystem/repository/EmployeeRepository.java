package pcodes.EmployeeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pcodes.EmployeeManagementSystem.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee , Long> {
    List<Employee> findBydepartment(String department);
}
