package com.example.ReadCSV.repository;

import com.example.ReadCSV.pojo.ZipCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipcodesRepository extends JpaRepository<ZipCode, Long>
{
}
