package org.launchcode.professionalprocrastinators.data;

import org.launchcode.professionalprocrastinators.models.Vacation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacationRepository extends CrudRepository <Vacation, Integer> {


}
