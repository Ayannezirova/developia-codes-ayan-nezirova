package Developia.spring.web.MVC.student.model;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Book {

	Integer id;

	@NotBlank(message = "Kitab adı boş qoyulmamalıdır!")
	@Size(min = 2, message = "Kitab adı minimum 2 simvol olmalıdır!")
	@Size(max = 15, message = "Kitab adı maximum 15 simvol olmalıdır!")
	@NotEmpty(message = "Kitab adı mütləqdir!")
	String name;

	@Max(value = 40, message = "Kitabın qiyməti maximum 40 olmalıdır!")
	@Min(value = 10, message = "Kitabın qiyməti minimum 10 olmalıdır!")
	@NotNull(message = "Kitab qiymeti mutleqdir")
	Integer price;

	@Pattern(regexp = "[0-9]{3}-[0-9]{3}[0-9]{4}", message = "Telefonu düz yaz!")
	Integer phone;

}
