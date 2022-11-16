package az.developia.mylibrary.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import az.developia.mylibrary.model.Student;
import az.developia.mylibrary.repository.StudentRepository;

@Controller
@RequestMapping(path = "/students")
public class StudentController {

	@Autowired
	StudentRepository studentRepository;

	@GetMapping(path = "/list")
	@PreAuthorize(value = "hasAuthority('students:list')")
	public String list(Model model) {

		model.addAttribute("students", studentRepository.findAll());
		return "students"; // students.html

	}

	@GetMapping(path = "/delete/{id}")
	@PreAuthorize(value = "hasAuthority('student:delete')")
	public String delete(@PathVariable Integer id, Model model2) {
		if (studentRepository.findById(id).isPresent()) {
			studentRepository.deleteById(id);
		} else {
			model2.addAttribute("message", "bu id-li tələbə tapilmadi, id = " + id);
			return "errorumuz";
		}

		return "redirect:/students/list";
	}

	@GetMapping(path = "/edit/{id}")
	@PreAuthorize(value = "hasAuthority('student:edit')")
	public String edit(@PathVariable Integer id, Model model5) {
		Optional<Student> studentOptional = studentRepository.findById(id);
		Student student = new Student();
		if (studentRepository.findById(id).isPresent()) {
			student = studentOptional.get();
		} else {

		}
		model5.addAttribute("student", student);

		return "save-student";
	}

	@GetMapping(path = "/new")
	@PreAuthorize(value = "hasAuthority('student:save')")
	public String registration(Model model3) {
		Student s = new Student();
		model3.addAttribute("student", s);

		return "save-student";
	}

	@PostMapping(path = "/save")
	@PreAuthorize(value = "hasAuthority('student:save')")
	public String saveStudent(@Valid @ModelAttribute(name = "student") Student student, BindingResult br) {

		if (br.hasErrors()) {
			return "save-student";
		}

		studentRepository.save(student);

		return "redirect:/students/list";
	}

	@ExceptionHandler
	public String handleAccessDeniedException(AccessDeniedException exc, Model model4) {
		model4.addAttribute("message", "Sizin əməliyyat etməyinizə icazə yoxdur.");

		return "errorumuz";
	}

}
