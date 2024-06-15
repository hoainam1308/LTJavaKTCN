package com.example.tuan3.repository;

import com.example.tuan3.entity.NHANVIEN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INhanVienRepository extends JpaRepository<NHANVIEN, String> {

}
