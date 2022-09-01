package az.developia.springjpaayaan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

@Transactional 

public interface BookRepository extends JpaRepository<Book, Integer> {

	// select * from books where name = "name";
	List<Book> findAllByName(String name); // query method. name ucundur. axtaris ederken melumat adini tam yazmalisiz.

	List<Book> findAllByPriceOrName(String price, String name2); // query method. price ve name ucundur. onlardan
																	// hansinisa axtaris ederken axtardiginiz melumati
																	// tam yazmalisiz.

	List<Book> findAllByNameContaining(String name3); // query method. name ucundur ve mysql-de olan like kodunun isini
														// gorur(meselen, sadece bir simvol yazmaqla axtaris etmek olar)

	List<Book> findAllByNameContainingOrPriceContaining(String name4, String price2); // query method. name ve price
																						// ucundur ve mysql-de olan like
																						// kodunun isini gorur(meselen,
																						// sadece bir simvol yazmaqla
																						// axtaris etmek olar)

	@Query(value = "select * from books order by name desc", nativeQuery = true) // native query bu annotasiya
																					// vasitesile ise salinir. Iki metod
																					// qebul edir. "Value" metodu sql
																					// sorgularini yazmaq ucundur,
																					// "nativeQuery" ise sorgunun native
																					// query oldugunu tesdiqlemek
																					// ucundur.

	List<Book> hamisiniTapin(); // adin onemi yoxdur ancaq gorunus ucun ve qarisiqliq yaratmamaq ucun duzgun
								// ad qoymaq meslehetdir

	@Query(value = "select * from books limit ?1,?2", nativeQuery = true)
	List<Book> hamisiniTapinLimit(Integer begin, Integer length);

	
	@Query(value = "delete from books where name=?1", nativeQuery = true)
	@Modifying // @Query annotasiyasını təkmilləşdirmək üçün istifadə olunur ki, biz təkcə "select" sorğularını deyil, həm də "insert", "update", "delete" sorğularını yerinə yetirə bilək. 
	void deleteByName(String name); // ada gore silir

}
