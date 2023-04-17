package com.broCode.StudentLibraryManagementSystem.Repositories;

import com.broCode.StudentLibraryManagementSystem.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
