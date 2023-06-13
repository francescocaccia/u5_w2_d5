package container.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import container.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
