package com.example.demo.Controler;

import com.example.demo.Modules.Todo;
import com.example.demo.Serivce.demoSerivce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api/v1/todo")
public class newControler {

    @Autowired
    private demoSerivce DemoSerivce;

    @GetMapping("/todo1")
    public String newTodo() {
        return "Todo";
    }

    @GetMapping("/todo2")
    public String newTodo2() {
        return "Todo2";
    }

    @GetMapping("/{id}")
    public String newTodo2(@PathVariable long id) {
        return "Todo3" + id;

    }

    // Single Todo-வை பெற
    @GetMapping("/get")
    public ResponseEntity<Todo> newTodo3(@RequestParam Long id) {
        return new ResponseEntity<>(DemoSerivce.GetTodo(id), HttpStatus.OK);
    }

    // அனைத்து Todo பட்டியலையும் (List) பெற
    @GetMapping("/all")
    public ResponseEntity<List<Todo>> newTodo9() {
        return new ResponseEntity<>(DemoSerivce.ListGetTodo(), HttpStatus.OK);
    }

    // புதிய Todo உருவாக்க
    @PostMapping("/create")
    public ResponseEntity<Todo> newTodo4(@RequestBody Todo todo) {
        return new ResponseEntity<>(DemoSerivce.createTodo(todo), HttpStatus.CREATED);
    }

    // Update செய்ய
    @PutMapping("/{id}")
    public String newTodo5Updata(@PathVariable long id) {
        return "todo " + id;
    }
    @GetMapping("/page")
    public ResponseEntity<Page<Todo>> getTodoPages(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Page<Todo> todos = DemoSerivce.getAllTodoPages(page, size);
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    // ID மூலம் நீக்க (Delete)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> newTodo5Delete(@PathVariable Long id) {
        DemoSerivce.deletId(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }
}