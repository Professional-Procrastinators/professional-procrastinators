package org.launchcode.professionalprocrastinators.models.data;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.launchcode.professionalprocrastinators.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

    Optional<User> findByEmailOrName(String email, String name);

    Optional<User> findById(int id);


    Optional<User> findByUsername(String username);
}
