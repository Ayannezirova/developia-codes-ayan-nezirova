package az.developia.mylibrary.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@Size(min = 2, message = "Tələbənin adı minimum 2 simvol olmalıdır!")
	@Size(max = 20, message = "Tələbənin adı maksimum 20 simvol olmalıdır!")
	@NotBlank(message = "Tələbənin adını boş qoymaq olmaz!")
	@NotEmpty(message = "Ad mütləqdir!")
	String name;

	@Size(min = 2, message = "Tələbənin soyadı minimum 2 simvol olmalıdır!")
	@Size(max = 20, message = "Tələbənin soyadı maksimum 20 simvol olmalıdır!")
	@NotBlank(message = "Tələbənin soyadını boş qoymaq olmaz!")
	@NotEmpty(message = "Soyad mütləqdir!")
	String surname;

	@Pattern(regexp = "[0-9]{3}-[0-9]{3}-[0-9]{4}", message = "Telefonu düzgün yaz!")
	String telephone;

	@Size(max = 200, message = "Tələbənin ünvanı 200 simvolu keçməməlidir!")
	String address;

	@Size(min = 2, message = "Tələbənin istifadəçi adı minimum 2 simvol olmalıdır!")
	@Size(max = 20, message = "Tələbənin istifadəçi adı maksimum 20 simvol olmalıdır!")
	@NotBlank(message = "Tələbənin istifadəçi adını boş qoymaq olmaz!")
	@NotEmpty(message = "İstifadəçi adı mütləqdir!")
	String username;

	@Size(min = 2, message = "Tələbənin şifrəsi minimum 2 simvol olmalıdır!")
	@Size(max = 20, message = "Tələbənin şifrəsi maksimum 20 simvol olmalıdır!")
	@NotBlank(message = "Tələbənin şifrəsi boş qoymaq olmaz!")
	@NotEmpty(message = "Şifrə mütləqdir!")
	String password;
	
	String edition;

}