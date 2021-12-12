package com.bk.GradeManager.repository.web;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bk.GradeManager.entity.web.StudentDb;
public interface StudentDbRepository extends JpaRepository<StudentDb, Integer>  {



}