package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.BookDAO;
import com.example.demo.entity.Book;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Table;


import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "도서 API", description = "도서 관련 API를 제공합니다.")
@Controller
public class BookController {
    
    @Autowired
    private BookDAO dao;
    
    @CrossOrigin(origins = "*")
    @Operation(summary = "도서 목록 조회", description = "저장된 모든 도서의 목록을 반환합니다.")
    @GetMapping("/book/list")
    @ResponseBody
    public List<Book> list() {
        return dao.findAll();
    }
    
    @Operation(summary = "도서 추가", description = "새로운 도서를 데이터베이스에 추가합니다.")
    @Parameter(name = "b", description = "추가할 도서 정보", required = true)
    @PostMapping("/book/insert")
    public String insertSubmit(Book b) {
        System.out.println("insertSubmit 동작함");
        dao.save(b);
        return "redirect:/book/list";
    }
}





