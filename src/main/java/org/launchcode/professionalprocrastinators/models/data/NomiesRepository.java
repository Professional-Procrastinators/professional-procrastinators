package org.launchcode.professionalprocrastinators.models.data;

import org.launchcode.professionalprocrastinators.models.Nomies;
import org.launchcode.professionalprocrastinators.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface NomiesRepository extends CrudRepository<Nomies, Integer> {



}
