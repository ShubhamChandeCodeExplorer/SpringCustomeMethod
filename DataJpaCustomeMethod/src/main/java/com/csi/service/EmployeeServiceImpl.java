package com.csi.service;

import com.csi.entity.Employee;
import com.csi.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee signup(Employee employee) {
        return employeeRepository.save(employee);
    }

    public boolean signin(String empEmailId, String empPassword) {
        Employee employee = employeeRepository.findByEmpEmailIdAndEmpPassword(empEmailId, empPassword);
        boolean flag = false;
        if (employee != null && employee.getEmpEmailId().equals(empEmailId) && employee.getEmpPassword().equals(empPassword)) {
            flag = true;

        }
        return flag;

    }

    public Optional<Employee> findByid(long empId) {
        return employeeRepository.findById(empId);
    }

    public List<Employee> findByEmpName(String empName) {
        return employeeRepository.findByEmpName(empName);
    }

    public Employee findByContact(long empContact) {
        return employeeRepository.findByEmpContact(empContact);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteById(long empId) {
        employeeRepository.deleteById(empId);
    }

    public void deleteAll() {
        employeeRepository.deleteAll();
    }

}
