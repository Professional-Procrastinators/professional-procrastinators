package org.launchcode.professionalprocrastinators.models.data;

import org.launchcode.professionalprocrastinators.models.PackingList;
import org.launchcode.professionalprocrastinators.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackingListRepository extends CrudRepository <PackingList, Integer> {
    List<PackingList> findAll();
}