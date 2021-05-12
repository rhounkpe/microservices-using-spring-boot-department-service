package be.digitcom.department.service;

import be.digitcom.department.entity.Department;
import be.digitcom.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {
    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    public Department save(Department department) {
        log.info("Inside DepartmentService#save method.");
        return repository.save(department);
    }

    public Department getById(Long id) {
        log.info("Inside DepartmentService#getById method.");
        return repository.findById(id).orElseThrow();
    }
}
