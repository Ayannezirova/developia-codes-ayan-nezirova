package az.developia.springsecurityayaan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

	@NotBlank(message = "Kitab adı boş qoyulmamalıdır!")
	@Size(min = 2, message = "Kitab adı minimum 2 simvol olmalıdır!")
	@Size(max = 15, message = "Kitab adı maximum 15 simvol olmalıdır!")
	@NotEmpty(message = "Kitab adı mütləqdir!")

	@Column(columnDefinition = "TEXT", name = "ad")
	String name;

	@Max(value = 40, message = "Kitabın qiyməti maximum 40 olmalıdır!")
	@Min(value = 10, message = "Kitabın qiyməti minimum 10 olmalıdır!")
	@NotNull(message = "Kitab qiymeti mutleqdir")
	String price;

}
