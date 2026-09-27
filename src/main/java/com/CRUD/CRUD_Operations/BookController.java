package com.CRUD.CRUD_Operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private Book_Repo bookRepo;

    @PostMapping("/inputData")
    public List<BookManagement> inputData(@RequestBody List<BookManagement> bm){
        return bookRepo.saveAll(bm);
    }

    @DeleteMapping("/removeSingle/{id}")
    public String removeSingleData(@PathVariable int id){
        bookRepo.deleteById(id);

        return "Data Removed Successfully";
    }

    @GetMapping("/displayData")
    public List<BookManagement> getData(){
        return bookRepo.findAll();
    }

   /* @GetMapping("/getbyfields/{id}")
    public Optional<BookManagement> getSpecific0(@PathVariable("id")int id){
        if(bookRepo.isPresent()){
            return bookRepo.get()
        }else{

        }

    }*/

    @GetMapping("/getbyfeilds1/{name}")
    public List<BookManagement>getspecific1(@PathVariable("name")String name){
        return bookRepo.findByName(name);
    }

    @GetMapping("/getbyfeilds2/{price}")
    public List<BookManagement>getSpecific1(@PathVariable("price")double pricee){
        return bookRepo.findByPrice(pricee);
    }

    @GetMapping("/getbyfeilds3/{author}")
    public List<BookManagement> getSpecific2(@PathVariable("author")String authorr){
        return bookRepo.findByAuthor(authorr);
    }

    @GetMapping("/getbyfeilds4/{id}")
    public List<BookManagement> getSpecific3(@PathVariable("id")int id){
        return bookRepo.findById(id);
    }

    @PutMapping("/updateVal")
    public BookManagement updateData(@RequestParam("name")String name,@RequestParam("price")double price,@RequestParam("author")String author,BookManagement bmg){
        return bookRepo.save(bmg);
    }
}


