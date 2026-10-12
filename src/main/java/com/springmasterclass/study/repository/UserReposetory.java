package com.springmasterclass.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springmasterclass.study.entity.User;

@Repository
public interface UserReposetory extends JpaRepository<User, Long> {

     void deleteById(Long id);

     boolean existsByEmail(String email);

     boolean existsByEmailAndIdNot(String email, Long id);
}
