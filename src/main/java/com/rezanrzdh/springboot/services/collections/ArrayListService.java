package com.rezanrzdh.springboot.services.collections;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArrayListService {

    List<String> list = new ArrayList<>();

    public List<String> getArrayList() {
        return list;
    }

    public void addToList(String str) {
        list.add(str);
    }

    public void removeFromList(String str) {
        list.remove(str);
    }

    public Integer getListSize() {
        return list.size();
    }

    public boolean getListContains(String str) {
        return list.contains(str);
    }
}
