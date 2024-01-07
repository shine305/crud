package jp.ac.ccmc.crud_sample.controller;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jp.ac.ccmc.crud_sample.model.Student;
import jp.ac.ccmc.crud_sample.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentRepository repository;
    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("students", repository.findAll());
        return "student/list";
    }
    @GetMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        return "student/form";
    }
    @PostMapping("/process")
    public String process(@Validated @ModelAttribute Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "student/form";
        }
        repository.save(student);
        return "redirect:./";
    }
    @GetMapping("/edit")
    public String editStudent(@RequestParam Long id, Model model) {
        model.addAttribute("student", repository.findById(id));
        return "student/form";
    }
    @GetMapping("/delete")
    public String deleteStudent(@RequestParam Long id) {
        repository.deleteById(id);
        return "redirect:./";
    }
    @ExceptionHandler(Exception.class)
    public String error(Exception e, HttpServletResponse response) {
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return "student/error";
    }
}
