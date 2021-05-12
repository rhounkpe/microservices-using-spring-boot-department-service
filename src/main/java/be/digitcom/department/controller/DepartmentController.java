package be.digitcom.department.controller;

import be.digitcom.department.entity.Department;
import be.digitcom.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @PostMapping("/")
    public Department save(@RequestBody Department department) {
        log.info("Inside DepartmentController#save method");
        return service.save(department);
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable("id") UUID id) {
        log.info("Inside DepartmentController#getById method.");
        return service.getById(id);
    }
}
