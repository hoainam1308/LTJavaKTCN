package com.example.tuan3.service;

import com.example.tuan3.entity.NHANVIEN;
import com.example.tuan3.repository.INhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import java.util.List;

@Service
public class NhanVienService {
    @Autowired
    private INhanVienRepository nhanVienRepository;

    public Page<NHANVIEN> getNhanVien(int page, int size)
    {
        return nhanVienRepository.findAll(PageRequest.of(page, size));
    }

    public NHANVIEN getNhanVienById(String id){
        return nhanVienRepository.findById(id).orElse(null);
    }

    public void addNhanVien(NHANVIEN nhanvien){
        nhanVienRepository.save(nhanvien);
    }

    public void deleteNhanVien(String id){
        nhanVienRepository.deleteById(id);
    }

    public void updateNhanVien(NHANVIEN nhanvien){
        nhanVienRepository.save(nhanvien);
    }
}
