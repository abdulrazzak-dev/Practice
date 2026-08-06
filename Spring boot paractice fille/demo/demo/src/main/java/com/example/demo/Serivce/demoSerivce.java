package com.example.demo.Serivce;



import com.example.demo.Modules.Todo;
import com.example.demo.Repostery.DemoRepostery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Spring Data Domain Imports (Pagination)
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
@Service
public class demoSerivce {

    @Autowired
    private DemoRepostery demoRepostery;

    // 1. புதிய Todo உருவாக்க
    public Todo createTodo(Todo todo) {
        return demoRepostery.save(todo);
    }

    // 2. ID வைத்து ஒரு Todo பெற
    public Todo GetTodo(Long id) {
        return demoRepostery.getReferenceById(id);
    }
    public Page<Todo> getAllTodoPages(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return demoRepostery.findAll(pageable);
    }

    // 3. அனைத்து Todo பட்டியலையும் பெற
    public List<Todo> ListGetTodo() {
        return demoRepostery.findAll();
    }

    // 4. Todo ஆப்ஜெக்ட் வைத்து நீக்க
    public void delet(Todo todo) {
        demoRepostery.delete(todo);
    }

    // 5. ID வைத்து நேரடியாக நீக்க (Controller-க்கு இது தேவை)
    public void deletId(Long id) {
        demoRepostery.deleteById(id);
    }

}