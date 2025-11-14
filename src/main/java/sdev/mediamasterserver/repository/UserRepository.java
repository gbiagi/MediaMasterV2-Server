package sdev.mediamasterserver.repository;

import org.springframework.data.repository.CrudRepository;
import sdev.mediamasterserver.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserName(String username);
}
