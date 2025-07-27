package com.rezanrzdh.springboot.services.comparable;

import com.rezanrzdh.springboot.models.PersonModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ComparableService {
    public List<PersonModel> getSortedPersonList() {
        List<PersonModel> list = new ArrayList<>();
        list.add(new PersonModel("Reza", 36));
        list.add(new PersonModel("Mahsa", 35));
        list.add(new PersonModel("Liana", 1));

        Collections.sort(list);
        return list;
    }
}
