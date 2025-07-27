package com.rezanrzdh.springboot.controllers;

import com.rezanrzdh.springboot.models.LinkedListModel;
import com.rezanrzdh.springboot.services.collections.LinkedListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("linkedlist")
public class LinkedListController {
    private final LinkedListService linkedListService;

    public LinkedListController(LinkedListService linkedListService) {
        this.linkedListService = linkedListService;
    }

    @GetMapping("")
    public ResponseEntity<List<String>> getList() {
        return ResponseEntity.ok(linkedListService.getList());
    }

    @PostMapping("")
    public ResponseEntity<List<String>> addToList(@RequestBody LinkedListModel linkedListModel) {
        linkedListService.addToList(linkedListModel);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("")
    public ResponseEntity<String> removeFromList(@RequestBody String str) {
        linkedListService.removeFromList(str);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("size")
    public ResponseEntity<Integer> getListSize() {
        return ResponseEntity.ok(linkedListService.getListSize());
    }

    @PostMapping("contains")
    public ResponseEntity<Boolean> getListContaines(@RequestBody String str) {
        return ResponseEntity.ok(linkedListService.getListContaines(str));
    }
}
