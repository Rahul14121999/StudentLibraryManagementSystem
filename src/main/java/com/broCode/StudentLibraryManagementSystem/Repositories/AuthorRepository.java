package com.broCode.StudentLibraryManagementSystem.Repositories;

import com.broCode.StudentLibraryManagementSystem.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {

}
