package com.csi.repo;

import com.csi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public List<Employee> findByEmpName(String empName);

    public Employee findByEmpContact(long empContact);

    public Employee findByEmpEmailIdAndEmpPassword(String empEmailId, String empPassword);
}
