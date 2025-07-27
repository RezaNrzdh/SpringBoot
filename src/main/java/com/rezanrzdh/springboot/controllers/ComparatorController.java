package com.rezanrzdh.springboot.controllers;

import com.rezanrzdh.springboot.models.PersonWithoutComparableModel;
import com.rezanrzdh.springboot.services.comparable.ComparatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("comparator")
public class ComparatorController {

    private final ComparatorService comparatorService;

    public ComparatorController(ComparatorService comparatorService) {
        this.comparatorService = comparatorService;
    }

    @GetMapping("age")
    public ResponseEntity<List<PersonWithoutComparableModel>> getAgeComparator() {
        return ResponseEntity.ok(comparatorService.getSortedPersonList());
    }

    @GetMapping("name")
    public ResponseEntity<List<PersonWithoutComparableModel>> getNameComparator() {
        return ResponseEntity.ok(comparatorService.getSortedPersonNameList());
    }
}
