package com.rezanrzdh.springboot.controllers;

import com.rezanrzdh.springboot.services.collections.ArrayListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("collection")
public class CollectionController {

    private final ArrayListService arrayListService;

    public CollectionController(ArrayListService arrayListService) {
        this.arrayListService = arrayListService;
    }

    @GetMapping("")
    public ResponseEntity<List<String>> getArrayList() {
        return ResponseEntity.ok(arrayListService.getArrayList());
    }

    @PostMapping("")
    public ResponseEntity<String> addToList(@RequestBody String str) {
        arrayListService.addToList(str);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("")
    public ResponseEntity<String> removeFromList(@RequestBody String str) {
        arrayListService.removeFromList(str);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("size")
    public ResponseEntity<Integer> getListSize(){
        return ResponseEntity.ok(arrayListService.getListSize());
    }

    @GetMapping("contains")
    public ResponseEntity<Boolean> getListContains(@RequestBody String str) {
        return ResponseEntity.ok(arrayListService.getListContains(str));
    }
}
