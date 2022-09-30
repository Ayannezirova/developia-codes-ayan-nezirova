package az.developia.springfiltering.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springfiltering.dto.StudentDTO;
import az.developia.springfiltering.model.Student;
import az.developia.springfiltering.repository.StudentRepository;

@RestController
@RequestMapping(path = "/students")
@CrossOrigin(origins = "*")
public class StudentRestController {

	@Autowired
	public StudentRepository studentRepository;

	ModelMapper mapper = new ModelMapper();

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
	public List<StudentDTO> findAllForStudent() {

		List<Student> students = studentRepository.findAll();

		List<StudentDTO> studentDtos = new ArrayList<StudentDTO>();
		for (Student st : students) {
			StudentDTO dto = new StudentDTO();
			mapper.map(st, dto);
			studentDtos.add(dto);
		}

		return studentDtos;
	}
}