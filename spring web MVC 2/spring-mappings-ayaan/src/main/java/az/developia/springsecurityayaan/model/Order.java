package az.developia.springsecurityayaan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "orders")
@AllArgsConstructor
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id; // Unidirectional

	String address; // Unidirectional

	Double price; // Unidirectional

	@ManyToOne
	@JoinColumn(name = "customer_id") // Bidirectional əlaqəsi qurulduqda JoinColumn many tərəfə yazılmalıdır.
	Customer customer; // Bidirectional

	public Order(Integer id, String address, Double price) {
		super();
		this.id = id;
		this.address = address;
		this.price = price;
	}

}
