package com.example.springWeather;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WeatherReporterController {

    @RequestMapping(value = "/reporters", produces = "application/json")
    public ArrayList<Reporter> getAllReporters()
    {
        ArrayList<Reporter> reporterCollection=new ArrayList<>();

        Reporter repOne = new Reporter(1,"Lokesh","Kanagaraj","lokesh@gmail.com");
        Reporter repTwo = new Reporter(2,"Amit","Jindal","jindal@yahoo.com");
        Reporter repThree = new Reporter(3,"Vasan","Iyannar","vasan@gmail.com");


        reporterCollection.add(repOne);
        reporterCollection.add(repTwo);
        reporterCollection.add(repThree);

        return reporterCollection;
    }

    @RequestMapping(value = "/reporters/{id}", produces = "application/xml")
    public ResponseEntity<Reporter> getReporterById (@PathVariable("id") int id)
    {
        if (id <= 3) {
            Reporter repOne = new Reporter(1,"Lokesh","Kanagaraj","lokesh@gmail.com");
            return new ResponseEntity<Reporter>(repOne, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
