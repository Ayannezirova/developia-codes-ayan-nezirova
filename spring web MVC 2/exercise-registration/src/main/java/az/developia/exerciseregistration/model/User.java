package az.developia.exerciseregistration.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {

	@Size(min = 1, message = "İstifadəçi adı minimum 1 simvol olmalıdır")
	@Size(max = 20, message = "İstifadəçi adı maximum 20 simvol olmalıdır")
	@NotEmpty(message = "Boş qoymaq olmaz")
	String username;

	@Size(min = 5, message = "Şifrə minimum 5 simvol olmalıdır")
	@Size(max = 20, message = "Şifrə maximum 20 simvol olmalıdır")
	@NotEmpty(message = "Boş qoymaq olmaz")

	String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}

}
