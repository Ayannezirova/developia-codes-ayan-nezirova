package az.developia.springfiltering.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "students")
@AllArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	String name;
	String surname;
	String phone;
	String address;
	String email;

}
