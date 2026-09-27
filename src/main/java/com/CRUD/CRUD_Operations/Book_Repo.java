package com.CRUD.CRUD_Operations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Book_Repo extends JpaRepository<BookManagement,Integer> {
    List<BookManagement> findByName(String name);
    List<BookManagement> findById(int id);
    List<BookManagement> findByAuthor(String author);
    List<BookManagement> findByPrice(double price);
    void deleteById(int id);

    List<BookManagement> findByNameOrderByPriceAsc(String name);
}
