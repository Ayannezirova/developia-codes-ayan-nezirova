package az.developia.mylibrary.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@Size(min = 2, message = "Kitabın adı minimum 2 simvol olmalıdır!")
	@Size(max = 40, message = "Kitabın adı maksimum 40 simvol olmalıdır!")
	@NotBlank(message = "Kitabın adını boş qoymaq olmaz!")
	String name;

	@Size(min = 0, message = "Kitabın qiyməti minimum 0 olmalıdır!")
	@Size(max = 10_000, message = "Kitabın qiyməti maksimum 10.000 olmalıdır!")
	String price;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past(message = "Keçmiş zamanda olmalıdır!")
	LocalDate edition;

}
