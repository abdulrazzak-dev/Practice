package com.example.demo.Serivce;



import com.example.demo.Modules.User;
import com.example.demo.Repostery.UserRepostery;
import com.example.demo.Repostery.UserRepostery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Spring Data Domain Imports (Pagination)
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
@Service
public class UserSerivce {

    @Autowired
    private UserRepostery userRepostery;

    // 1. புதிய User உருவாக்க
    public User createUser(User user) {
        return userRepostery.save(user);
    }

    // 2. ID வைத்து ஒரு User பெற
    public User GetUser(Long id) {
        return userRepostery.getReferenceById(id);
    }

}