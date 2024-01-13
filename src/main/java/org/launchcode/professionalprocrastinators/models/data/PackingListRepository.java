package org.launchcode.professionalprocrastinators.models.data;

import org.launchcode.professionalprocrastinators.models.PackingList;
import org.springframework.data.repository.CrudRepository;

public interface PackingListRepository extends CrudRepository <PackingList, Integer> {
}
