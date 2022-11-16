package az.developia.mylibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.mylibrary.model.AuthorityModel;

public interface AuthRepository extends JpaRepository<AuthorityModel, Integer> {

}
