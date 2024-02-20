/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author NGUYEN THI NGUYET VY
 */
public class Kho {
    private String makho;
    private String maSach;
    private String tenSach;
    private String maNV;
    private String GhiChu;
    private Date ngaytao = new Date();
    private int soluong;

    public Kho() {
    }

    public Kho(String makho, String maSach, String tenSach, String maNV, String GhiChu, int soluong) {
        this.makho = makho;
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.maNV = maNV;
        this.GhiChu = GhiChu;
        this.soluong = soluong;
    }

    public String getMakho() {
        return makho;
    }

    public void setMakho(String makho) {
        this.makho = makho;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

}