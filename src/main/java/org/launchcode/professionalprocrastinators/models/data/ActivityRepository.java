package org.launchcode.professionalprocrastinators.models.data;

import org.launchcode.professionalprocrastinators.models.Activity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Integer> {
}
