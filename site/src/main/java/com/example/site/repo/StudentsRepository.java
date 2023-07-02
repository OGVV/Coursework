package com.example.site.repo;

import com.example.site.models.Students;
import org.springframework.data.repository.CrudRepository;

public interface StudentsRepository extends CrudRepository<Students,Long> {
}
