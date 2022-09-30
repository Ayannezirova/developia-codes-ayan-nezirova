package az.developia.springfiltering.dto;

import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonFilter(value = "student")
public class StudentDTO {

	Integer id;
	String name;
	String surname;
	String phone;
	String address;
	String email;
}
