package az.developia.springsecurityayaan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springsecurityayaan.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, String> {

}
