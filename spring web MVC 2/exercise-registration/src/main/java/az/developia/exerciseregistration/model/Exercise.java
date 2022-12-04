package az.developia.exerciseregistration.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "exercises")
public class Exercise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@NotEmpty(message = "Boş qoymaq olmaz")
	@Size(min = 2, message = "Minimum 2 simvol olmalıdır")
	@Size(max = 30, message = "Maximum 2000 simvol olmalıdır")
	String taskGiven;

	@NotEmpty(message = "Boş qoymaq olmaz")
	@Size(max = 30, message = "Maximum 30 simvol olmalıdır")
	String day;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past(message = "Keçmiş zamanda olmalıdır!")
	LocalDate date;

	@NotEmpty(message = "Boş qoymaq olmaz")
	@Size(min = 2, message = "Minimum 2 simvol olmalıdır")
	@Size(max = 30, message = "Maximum 100 simvol olmalıdır")
	String category;

	String username;
}
