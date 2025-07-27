package com.rezanrzdh.springboot.services.collections;

import com.rezanrzdh.springboot.models.LinkedListModel;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class LinkedListService {
    List<String> list = new LinkedList<>();

    public List<String> getList() {
        return list;
    }

    public void addToList(LinkedListModel linkedListModel) {
        if(linkedListModel.getIndex() == null)
            linkedListModel.setIndex(0);

        list.add(linkedListModel.getIndex(), linkedListModel.getStr());
    }

    public void removeFromList(String str) {
        list.remove(str);
    }

    public Integer getListSize() {
        return list.size();
    }

    public Boolean getListContaines(String str) {
        return list.contains(str);
    }
}
