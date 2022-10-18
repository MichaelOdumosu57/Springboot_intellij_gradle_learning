package javaconceptsbyjay.com.youtube.controller;

import javaconceptsbyjay.com.youtube.entity.Singers;
import javaconceptsbyjay.com.youtube.service.SingersService;
import javaconceptsbyjay.com.youtube.service.SingersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api/singers")
public class SingersController {
    @Autowired
    private SingersService singersService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Singers singers)
    {
        ResponseEntity<String> responseEntity = null;
        try{
            Integer integer = singersService.saveSingers(singers);
            responseEntity = new ResponseEntity<String >("Singer "+integer+" created", HttpStatus.OK);
        }catch (Exception e){
            responseEntity =new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
        return responseEntity;

    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Singers singers)
    {
        ResponseEntity<String> responseEntity = null;
        boolean available = singersService.isAvailable(singers.getSingersPosition());
        if(available){
            singersService.update(singers);
            responseEntity = new ResponseEntity<String>("updated successfully",HttpStatus.OK);
        }
        else{
            responseEntity = new ResponseEntity<String >("Record "+singers.getSingersPosition() + " not found",HttpStatus.BAD_REQUEST);

        }
        return  responseEntity;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id)
    {
        ResponseEntity<String> responseEntity = null;
        boolean availableSinger = singersService.isAvailable(id);
        if(availableSinger)
        {
            singersService.delete(id);
            responseEntity = new ResponseEntity<String>("deleted "+ id +" successfully",HttpStatus.OK);
        }
        else {
            responseEntity = new ResponseEntity<String >("Record "+id + " not found",HttpStatus.BAD_REQUEST);
        }


        return responseEntity;
    }


    @GetMapping(value = "/getSingleSinger/{id}",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_CBOR_VALUE})
    public ResponseEntity getSingleSingerById(@PathVariable Integer id)
    {
        ResponseEntity responseEntity = null;
        if(singersService.isAvailable(id))
        {
            Singers oneSinger =singersService.getOneSinger(id);
            responseEntity = new ResponseEntity<Singers>(oneSinger,HttpStatus.OK);
        }
        else{
            responseEntity = new ResponseEntity<String>("record not found",HttpStatus.OK);
        }
        return responseEntity;
    }


}
