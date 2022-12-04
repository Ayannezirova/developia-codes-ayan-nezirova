package az.developia.exerciseregistration.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import az.developia.exerciseregistration.config.Session;
import az.developia.exerciseregistration.dao.ExerciseDAO;
import az.developia.exerciseregistration.model.Exercise;
import az.developia.exerciseregistration.repository.ExerciseRepository;

@Controller
@RequestMapping(path = { "/exercises", "/" })
public class ExerciseController {

	@Autowired
	ExerciseDAO exerciseDAO;

	@Autowired
	Session session;

	@Autowired
	ExerciseRepository exerciseRepository;

	@GetMapping
	public String list(Model model) {

		List<Exercise> exercises = exerciseDAO.findAllByUsername(session.getUsername());
		model.addAttribute("exercises", exercises);
		return "exercises";

	}

	@GetMapping(path = "/delete/{id}")
	public String delete(@PathVariable Integer id, Model model2) {
		if (exerciseRepository.findById(id).isPresent()) {
			exerciseRepository.deleteById(id);
		} else {
			model2.addAttribute("message", "tapşırıq tapılmadı, id = " + id);
			return "errorumuz";
		}

		return "redirect:/exercises";
	}

	@GetMapping(path = "/edit/{id}")
	public String edit(@PathVariable Integer id, Model model5) {
		Optional<Exercise> exerciseOptional = exerciseRepository.findById(id);
		Exercise exercise = new Exercise();
		if (exerciseRepository.findById(id).isPresent()) {
			exercise = exerciseOptional.get();
		} else {

		}
		model5.addAttribute("exercise", exercise);

		return "save-exercise";
	}

	@GetMapping(path = "/new")
	public String registration(Model model3) {
		Exercise e = new Exercise();
		model3.addAttribute("exercise", e);

		return "save-exercise";
	}

	@PostMapping(path = "/save")
	public String saveExercise(@Valid @ModelAttribute(name = "exercise") Exercise exercise, BindingResult br) {

		if (br.hasErrors()) {
			return "save-exercise";
		}

		exercise.setUsername(session.getUsername());
		exerciseRepository.save(exercise);

		return "redirect:/exercises";
	}

}
