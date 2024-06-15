package com.example.Library.Management.System.Service;

import com.example.Library.Management.System.Entity.User;
import com.example.Library.Management.System.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


     UserRepo userRepo;
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User save(User user) {
        return userRepo.save(user);
    }
}
