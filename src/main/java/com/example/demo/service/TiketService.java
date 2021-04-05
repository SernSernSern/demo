package com.example.demo.service;

import com.example.demo.entity.Tiket;

import java.io.IOException;

public interface TiketService {

    void addTiket(Tiket tiket) throws IOException;

    void ViewAllRecord() throws IOException;

    void DeleteRecordByID(int id) throws IOException;

    boolean SearchRecordbyID(int id) throws IOException;

    boolean checkIn(Tiket tiket) throws  IOException;

    double discount(Tiket tiket) throws IOException;

}
