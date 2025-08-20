package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "book")
@Entity
@Data
@NoArgsConstructor
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	private String title;
	private String author;
	private Double price;
	
	public Book(Long id, String title, String author, Double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }
}
