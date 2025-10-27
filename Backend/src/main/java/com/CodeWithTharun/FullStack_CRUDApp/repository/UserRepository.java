package com.CodeWithTharun.FullStack_CRUDApp.repository;

import com.CodeWithTharun.FullStack_CRUDApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
