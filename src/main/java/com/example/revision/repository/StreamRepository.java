package com.example.revision.repository;

import com.example.revision.model.Stream;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamRepository extends CrudRepository<Stream,Long> {
}
