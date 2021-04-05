package com.example.demo.service;

import com.example.demo.entity.Tiket;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Random;
import java.util.StringTokenizer;

@Service
public class TiketServiceImpl implements TiketService{
    @Override
    public void addTiket(Tiket tiket)throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("naldrix_db.txt", true));

        bw.write(tiket.getId() + "," + tiket.getBaggageId() + "," + tiket.getDestinationId() + "," + tiket.getMoney());
        bw.flush();
        bw.newLine();
        bw.close();
    }

    @Override
    public void ViewAllRecord() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("naldrix_db.txt"));

        String record;

        System.out.println(" ------------------------------------------------------------- ");
        System.out.println("|	ID		BaggageId 				DestinationId			Money 		  |");
        System.out.println(" ------------------------------------------------------------- ");

        while ((record = br.readLine()) != null) {

            StringTokenizer st = new StringTokenizer(record, ",");

            System.out.println("|	" + st.nextToken() + "	" + st.nextToken() + " 		" + st.nextToken() + "			" + st.nextToken() + "      |");

        }

        System.out.println("|	                                            	          |");
        System.out.println(" ------------------------------------------------------------- ");
        br.close();
    }

    @Override
    public void DeleteRecordByID(int id) throws IOException{
        File tempDB = new File("naldrix_db_temp.txt");
        File db = new File("naldrix_db.txt");

        String record;
        BufferedReader br = new BufferedReader(new FileReader(db));
        BufferedWriter bw = new BufferedWriter(new FileWriter(tempDB));

        while ((record = br.readLine()) != null) {


            if (record.contains(""+id))
                continue;

            bw.write(record);
            bw.flush();
            bw.newLine();

        }

        br.close();
        bw.close();

        db.delete();

        tempDB.renameTo(db);

    }

    @Override
    public boolean SearchRecordbyID(int id)throws IOException {
        String record;
        BufferedReader br = new BufferedReader(new FileReader("naldrix_db.txt"));

        while ((record = br.readLine()) != null) {

            StringTokenizer st = new StringTokenizer(record, ",");
            if (record.contains(""+id)) {
                return true;
            }


        }

        br.close();
        return false;
    }


    @Override
    public boolean checkIn(Tiket tiket) throws IOException {

        if(tiket.getDestinationId() != 0  && tiket.getBaggageId() != 0){
            return true;
        }

        return false;
    }

    @Override
    public double discount(Tiket tiket) throws IOException {

        if(tiket.getDestinationId() > 0 && tiket.getMoney() > 0){
            Random random = new Random();
            int a = random.nextInt(2);
            if(a == 0){
                return tiket.getMoney() * 0.3;
            }else if(a == 1){
                return tiket.getMoney() * 0.1;
            }else if(a == 2){
                return tiket.getMoney() * 0.5;
            }
        }
        return 0;
    }
}
