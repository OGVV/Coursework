package com.example.site.repo;

import com.example.site.models.Marks;
import org.springframework.data.repository.CrudRepository;

public interface MarkRepository extends CrudRepository<Marks,Long> {
}

