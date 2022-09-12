package az.developia.springsecurityayaan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springsecurityayaan.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
