package com.example.anhnqth01267.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SinhVien {
    private String ma;
    private String ten;
    private Integer tuoi;
    private Boolean gioiTinh;
    private String nganhHoc;
}
