package az.developia.mylibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.mylibrary.model.UserModel;


public interface UserRepository extends JpaRepository<UserModel, String> {

}
