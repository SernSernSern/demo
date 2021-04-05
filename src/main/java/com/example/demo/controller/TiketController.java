package com.example.demo.controller;

import com.example.demo.entity.Tiket;
import com.example.demo.service.TiketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class TiketController {

    private TiketService tiketService;

    public TiketController(TiketService tiketService) {
        this.tiketService = tiketService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Boolean> getById(@PathVariable int id) throws IOException {
        if(tiketService.SearchRecordbyID(id)){
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/all")
    public void getAll() throws IOException {
        tiketService.ViewAllRecord();
    }


    @PostMapping("/create")
    public ResponseEntity createNewTiket(@RequestBody Tiket tiket) throws IOException {
        tiketService.addTiket(tiket);
        return new ResponseEntity(HttpStatus.OK);
    }
}
