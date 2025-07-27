package com.rezanrzdh.springboot.controllers;

import com.rezanrzdh.springboot.models.PersonModel;
import com.rezanrzdh.springboot.services.comparable.ComparableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comparable")
public class ComparableController {

    private final ComparableService comparableService;

    public ComparableController(ComparableService comparableService) {
        this.comparableService = comparableService;
    }

    @GetMapping("")
    public ResponseEntity<List<PersonModel>> getComparable(){
        return ResponseEntity.ok(comparableService.getSortedPersonList());
    }
}
