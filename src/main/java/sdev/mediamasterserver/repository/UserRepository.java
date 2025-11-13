package sdev.mediamasterserver.repository;

import org.springframework.data.repository.CrudRepository;
import sdev.mediamasterserver.entity.User;

interface UserRepository extends CrudRepository<User, Long> {

}
