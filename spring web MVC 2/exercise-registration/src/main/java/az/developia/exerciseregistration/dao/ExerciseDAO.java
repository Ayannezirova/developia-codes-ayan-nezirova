package az.developia.exerciseregistration.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.exerciseregistration.model.Exercise;

public interface ExerciseDAO extends JpaRepository<Exercise, String> {

	public List<Exercise> findAllByUsername(String username);
}
