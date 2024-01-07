package jp.ac.ccmc.crud_sample.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import jp.ac.ccmc.crud_sample.model.Student;
public interface StudentRepository extends JpaRepository<Student, Long> {
}
