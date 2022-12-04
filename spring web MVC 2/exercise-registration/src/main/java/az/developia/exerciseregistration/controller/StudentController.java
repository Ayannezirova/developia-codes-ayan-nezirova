package az.developia.exerciseregistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import az.developia.exerciseregistration.config.Session;
import az.developia.exerciseregistration.dao.ExerciseDAO;
import az.developia.exerciseregistration.model.Exercise;

public class StudentController {

	@Autowired
	ExerciseDAO exerciseDAO;

	@Autowired
	Session session;

	@GetMapping(path = "/exercises")
	public String showStudentPage(Model model) {
		List<Exercise> exercises = exerciseDAO.findAll();
		model.addAttribute("exercises", exercises);
		System.out.println(session.getUsername());
		return "exercises";
	}
}
