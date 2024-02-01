/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author NGUYEN THI NGUYET VY
 */
public class Kho {
    private String makho;
    private String maSach;
    private String tenSach;
    private String maNV;
    private String ngaytao;
    private int soluong;

    public Kho() {
    }

    public Kho(String makho, String maSach, String tenSach, String maNV, String ngaytao, int soluong) {
        this.makho = makho;
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.maNV = maNV;
        this.ngaytao = ngaytao;
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

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

}
