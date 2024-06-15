package com.example.tuan3.entity;

import com.example.tuan3.validator.annotation.ValidPhongBanId;
import com.example.tuan3.validator.annotation.ValidUserId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
@Entity
@Table(name="NhanVien")
public class NHANVIEN {
    @Id
    @Column(name = "Ma_NV")
    @NotNull
    @Size(max=3, min=1)
    private String Ma_NV;

    @Column(name = "Ten_NV")
    @NotNull
    @Size(max=100, min=1)
    private String Ten_NV;

    @Column(name = "Phai")
    @Size(max=3, min=1)
    private String Phai;

    @Column(name = "Noi_Sinh")
    @Size(max=200, min=1)
    private String Noi_Sinh;

    @Column(name = "Luong")
    private int Luong;

    @ManyToOne
    @JoinColumn(name = "Ma_Phong")
    @ValidPhongBanId
    private PHONGBAN phongban;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ValidUserId
    private User user;
}
