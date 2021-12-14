package com.upload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upload.model.Doc;

@Repository
public interface DocRepository extends JpaRepository<Doc,Integer> {

}
