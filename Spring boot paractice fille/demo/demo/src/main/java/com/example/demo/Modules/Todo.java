package com.example.demo.Modules; // உங்கள் package பெயர்

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Entity
@Data
//@Getter
@Slf4j  // loge
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank(message = "Name cannot be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Must be a 10-digit number")
     String name;
    //log.info("gjg");
    //log.warn();
    //log.error();

     Boolean isComplete;
}