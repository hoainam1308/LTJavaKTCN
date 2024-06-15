package com.example.tuan3.repository;

import com.example.tuan3.entity.PHONGBAN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhongBanRepository extends JpaRepository<PHONGBAN, String> {
}
