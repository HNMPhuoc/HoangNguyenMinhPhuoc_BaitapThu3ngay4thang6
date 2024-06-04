package com.Demo.baikiemtra.Repositories;

import com.Demo.baikiemtra.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User,String>{
    @Query("select s from User s where s.email=?1")
    User findByEmail(String email);
}
