package org.launchcode.professionalprocrastinators.models.data;


import org.launchcode.professionalprocrastinators.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {


    User findById(int id);

    User findByUsername(String username);

    User findByEmail(String email);

}
