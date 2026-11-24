package pcodes.EmployeeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pcodes.EmployeeManagementSystem.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee , Long> {
}
