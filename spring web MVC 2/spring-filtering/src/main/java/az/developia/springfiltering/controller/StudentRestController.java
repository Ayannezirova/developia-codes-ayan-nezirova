package az.developia.springfiltering.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springfiltering.model.Student;
import az.developia.springfiltering.repository.StudentRepository;
import az.developia.springfiltering.util.MyUtil;

@RestController
@RequestMapping(path = "/students")
@CrossOrigin(origins = "*")
public class StudentRestController {

	@Autowired
	public StudentRepository studentRepository;

	@Autowired
	ModelMapper mapper;

	@GetMapping(path = "/{id}")
	public Student get(@PathVariable Integer id) {
		Student s = studentRepository.findById(id).get();

		return s;
	}

	@GetMapping
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@GetMapping(path = "/for-student")
	public MappingJacksonValue findAllForStudent() {
		return MyUtil.filter(MyUtil.dtos(studentRepository.findAll(), mapper), "student", "id", "name", "surname");

	}

	@GetMapping(path = "/for-manager")
	public MappingJacksonValue findAllForManager() {

		return MyUtil.filter(MyUtil.dtos(studentRepository.findAll(), mapper), "student", "id", "name", "phone");

	}

	@GetMapping(path = "/for-teacher")
	public MappingJacksonValue findAllForTeacher() {

		return MyUtil.filter(MyUtil.dtos(studentRepository.findAll(), mapper), "student", "id", "name", "email",
				"surname");
	}
}