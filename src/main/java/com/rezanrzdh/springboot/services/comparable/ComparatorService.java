package com.rezanrzdh.springboot.services.comparable;

import com.rezanrzdh.springboot.models.PersonWithoutComparableModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class AgeComparator implements Comparator<PersonWithoutComparableModel> {
    @Override
    public int compare(PersonWithoutComparableModel o1, PersonWithoutComparableModel o2) {
        return o1.getAge() - o2.getAge();
    }
}

class NameComparator implements Comparator<PersonWithoutComparableModel> {
    @Override
    public int compare(PersonWithoutComparableModel o1, PersonWithoutComparableModel o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

@Service
public class ComparatorService {

    public List<PersonWithoutComparableModel> getSortedPersonList() {
        List<PersonWithoutComparableModel> list = new ArrayList<>();
        list.add(new PersonWithoutComparableModel("Saeed", 23));
        list.add(new PersonWithoutComparableModel("mohsen", 17));
        list.add(new PersonWithoutComparableModel("ali", 20));

        //OLD Version: before Java 8.0
        //Collections.sort(list, new AgeComparator());

        //New Version: After Java 8.0
        list.sort(new AgeComparator());
        return list;
    }

    public List<PersonWithoutComparableModel> getSortedPersonNameList() {
        List<PersonWithoutComparableModel> list = new ArrayList<>();
        list.add(new PersonWithoutComparableModel("saeed", 23));
        list.add(new PersonWithoutComparableModel("mohsen", 17));
        list.add(new PersonWithoutComparableModel("ali", 20));

        list.sort(new NameComparator());
        return list;
    }
}
