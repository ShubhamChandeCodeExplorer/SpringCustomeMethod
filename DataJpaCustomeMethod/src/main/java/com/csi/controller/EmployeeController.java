package com.csi.controller;

import com.csi.entity.Employee;
import com.csi.exception.RecordNotFoundException;
import com.csi.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeService;

    @PostMapping("/signup")
    public ResponseEntity<Employee> signup(@RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.signup(employee));
    }

    @GetMapping("/signin/{empEmailId}/{empPassword}")
    public ResponseEntity<Boolean> signIn(@PathVariable String empEmailId, @PathVariable String empPassword) {
        return ResponseEntity.ok(employeeService.signin(empEmailId, empPassword));
    }

    @GetMapping("/findbyid/{empId}")
    public ResponseEntity<Optional<Employee>> findById(@PathVariable long empId) {
        return ResponseEntity.ok(employeeService.findByid(empId));
    }

    @GetMapping("/findbyname/{empName}")
    public ResponseEntity<List<Employee>> findbyname(@PathVariable String empName) {
        return ResponseEntity.ok(employeeService.findByEmpName(empName));
    }

    @GetMapping("/findbycontact/{empContact}")
    public ResponseEntity<Employee> findByContact(@PathVariable long empCntact) {
        return ResponseEntity.ok(employeeService.findByContact(empCntact));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Employee>> findall() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<Employee> update(@RequestBody Employee employee, @PathVariable long empId) {
        Employee employee1 = employeeService.findByid(empId).orElseThrow(() -> new RecordNotFoundException("it does not exist..."));

        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpContact(employee.getEmpContact());
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpEmailId(employee.getEmpEmailId());
        employee1.setEmpPassword(employee.getEmpPassword());

        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.update(employee1));
    }

    @DeleteMapping("/deletebyid/{empId}")
    public ResponseEntity<String> deletebyid(@PathVariable long empId) {
        employeeService.deleteById(empId);
        return ResponseEntity.ok("DATA deleted Sucessfully");
    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<String> deleteall() {
        employeeService.deleteAll();
        return ResponseEntity.ok(" all data deleted Succesfully...");
    }

}
