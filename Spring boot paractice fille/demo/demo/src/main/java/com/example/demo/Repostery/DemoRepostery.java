package com.example.demo.Repostery;

import com.example.demo.Modules.Todo;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Component;

//CURD - create read update delete
public interface DemoRepostery extends JpaRepository<Todo,Long > {
}
