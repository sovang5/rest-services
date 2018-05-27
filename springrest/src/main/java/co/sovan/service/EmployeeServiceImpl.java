package co.sovan.service;

import co.sovan.Exception.BadRequestException;
import co.sovan.Exception.EmployeeNotFoundException;
import co.sovan.entity.Employee;
import co.sovan.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> findAll() {
        return (List<Employee>) repository.findAll();
    }


    public Employee findOne(String id) {
        Optional<Employee> existing = repository.findById(id);
        if (!existing.isPresent()) {
            throw new EmployeeNotFoundException("Employee with id " + id + " doesn't exist.");
        }
        return existing.get();
    }


    @Transactional
    public Employee create(Employee emp) {
        Optional<Employee> existing = repository.findByEmail(emp.getEmail());
        if (existing.isPresent()) {
            throw new BadRequestException("Employee with email " + emp.getEmail() + " already exists.");
        }
        return repository.save(emp);
    }

    @Transactional
    public Employee update(String id, Employee emp) {
        Optional<Employee> existing = repository.findById(id);
        if (!existing.isPresent()) {
            throw new EmployeeNotFoundException("Employee with id " + id + " doesn't exist.");
        }
        return repository.save(emp);
    }


    @Transactional
    public void delete(String id) {
        Optional<Employee> existing = repository.findById(id);
        if (!existing.isPresent()) {
            throw new EmployeeNotFoundException("Employee with id " + id + " doesn't exist.");
        }
        repository.delete(existing.get());
    }
}
