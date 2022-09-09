package az.developia.springsecurityayaan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springsecurityayaan.model.AuthorityModel;

public interface AuthorityRepository extends JpaRepository<AuthorityModel, Integer> {

}
