package az.developia.springrestayaan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springrestayaan.controller.MyMenu;

public interface MenuRepository extends JpaRepository<MyMenu, Integer> {

	// select * from langs where lang='';
	MyMenu findByLang(String l);
}
