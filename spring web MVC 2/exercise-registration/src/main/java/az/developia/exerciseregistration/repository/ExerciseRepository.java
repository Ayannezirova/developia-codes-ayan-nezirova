package az.developia.exerciseregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.exerciseregistration.model.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer>{

}
