package com.example.tuan3.controller;


import com.example.tuan3.entity.NHANVIEN;
import com.example.tuan3.service.NhanVienService;
import com.example.tuan3.service.PhongBanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nhanviens")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private PhongBanService phongBanService;
    @GetMapping
    public String showAllNhanVien(Model model, @RequestParam(defaultValue = "0") int page){
        Page<NHANVIEN> nhanviens = nhanVienService.getNhanVien(page, 5);
        model.addAttribute("nhanviens", nhanviens.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", nhanviens.getTotalPages());
        return "nhanvien/list";
    }
    @GetMapping("/add")
    public String addNhanVienForm(Model model){
        model.addAttribute("nhanvien", new NHANVIEN());
        model.addAttribute("phongbans", phongBanService.getAllPhongBan());
        return "nhanvien/add";
    }
    @PostMapping("/add")
    public String addNhanVien(@Valid @ModelAttribute("nhanvien") NHANVIEN nhanvien, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("phongbans", phongBanService.getAllPhongBan());
            return "nhanvien/add";
        }
        nhanVienService.addNhanVien(nhanvien);
        return "redirect:/nhanviens";
    }
    @GetMapping("/edit/{id}")
    public String editNhanVienForm(Model model, @PathVariable String id) {
        NHANVIEN nhanvien = nhanVienService.getNhanVienById(id);
        if (nhanvien!=null) {
            model.addAttribute("nhanvien", nhanvien);
            model.addAttribute("phongbans", phongBanService.getAllPhongBan());
            return "nhanvien/edit";
        }
        model.addAttribute("message", "Nhan Vien not found");
        return "redirect:/nhanviens";
    }
    @PostMapping("/edit")
    public String editNhanVien(@Valid @ModelAttribute("nhanvien") NHANVIEN nhanvien, BindingResult result) {
        if (result.hasErrors()) {
            return "nhanvien/edit";
        }
        nhanVienService.updateNhanVien(nhanvien);
        return "redirect:/nhanviens";
    }
    @GetMapping("/delete/{id}")
    public String deleteNhanVien(@PathVariable String id, Model model) {
        nhanVienService.deleteNhanVien(id);
        return "redirect:/nhanviens";
    }
}
