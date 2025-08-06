package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="persons")
@Entity
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name="first_name")
  private String fname;
  @Column(name="last_name")
  private String lname;
  @Column(name="email",nullable = false,unique = true)
  private String email;
}
