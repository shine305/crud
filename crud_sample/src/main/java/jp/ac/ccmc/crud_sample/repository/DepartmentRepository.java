package jp.ac.ccmc.crud_sample.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import jp.ac.ccmc.crud_sample.model.Department;
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
