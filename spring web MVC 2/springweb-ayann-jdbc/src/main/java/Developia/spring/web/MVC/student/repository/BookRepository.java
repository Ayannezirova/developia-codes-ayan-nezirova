package Developia.spring.web.MVC.student.repository;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Developia.spring.web.MVC.student.model.Book;

@Repository

//bazayla bir basa elaqede olan sinifdir.
public class BookRepository {

	@Autowired
	DataSource dataSource;

	public List<Book> findAll() {
		List<Book> list = new ArrayList<Book>();

		try {

			Connection conn = dataSource.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from students");
			while (rs.next()) {
				Book bkk = new Book();
				bkk.setId(rs.getInt("id"));
				bkk.setName(rs.getString("name"));
				bkk.setPrice(rs.getInt("price"));
				bkk.setPhone(rs.getInt("phone"));
				list.add(bkk);

			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public void save(Book bkk) {

		try (Connection conn = dataSource.getConnection()) {

			PreparedStatement st = conn.prepareStatement("insert into books (name,price,phone) values (?,?,?);");
			st.setString(1, bkk.getName());
			st.setInt(2, bkk.getPrice());
			st.setInt(3, bkk.getPhone());

			st.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
