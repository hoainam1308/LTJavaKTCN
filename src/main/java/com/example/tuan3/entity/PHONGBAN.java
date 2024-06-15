package com.example.tuan3.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="PHONGBAN")
public class PHONGBAN {
    @Id
    @NotNull
    @Column(name = "Ma_Phong")
    @Size(max = 2, min = 1)
    private String Ma_Phong;

    @Column(name = "Ten_Phong")
    @NotNull
    @Size(max = 50, min = 1)
    private String Ten_Phong;
    @OneToMany(mappedBy = "phongban", cascade = CascadeType.ALL)
    private List<NHANVIEN> nhanviens;
}
