package co.sovan.repository;


import co.sovan.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee,String> {
    Optional<Employee> findByEmail(String email);
}
