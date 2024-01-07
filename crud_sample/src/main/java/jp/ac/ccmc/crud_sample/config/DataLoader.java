package jp.ac.ccmc.crud_sample.config;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import jp.ac.ccmc.crud_sample.model.Department;
import jp.ac.ccmc.crud_sample.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {
    private final DepartmentRepository repository;
    @Override
    public void run(String... args) throws Exception {
        Department department = new Department();
        department.setName("IT・Web");
        repository.save(department);
        department = new Department();
        department.setName("AIプロジェクト");
        repository.save(department);
    }
}
