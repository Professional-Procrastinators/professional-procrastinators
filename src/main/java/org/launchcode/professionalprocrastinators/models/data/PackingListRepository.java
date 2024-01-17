package org.launchcode.professionalprocrastinators.models.data;

import org.launchcode.professionalprocrastinators.models.PackingList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackingListRepository extends CrudRepository<PackingList, Integer> {
//    PackingList findPackingListKey(String key);

}
