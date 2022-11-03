package az.developia.springrestayaan.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReadDB {

	public List<String> readDbNames(String username, String pass) {
		List<String> dbNames = new ArrayList<String>();
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", username, pass);

			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery("SHOW DATABASES;");

			if (stmt.execute("SHOW DATABASES;")) {
				resultSet = stmt.getResultSet();
			}

			while (resultSet.next()) {
				dbNames.add(resultSet.getString("Database"));
			}

			resultSet.close();
			stmt.close();
			conn.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {

		}
		return dbNames;
	}
}
