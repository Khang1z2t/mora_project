/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Kho;
import entities.Sach;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NGUYEN THI NGUYET VY
 */
public class KhoDAO {
   public void insert(Kho model){
       String sql="Insert into khosach values(?,?,?,?,?)";
       utils.JDBCHelper.update(sql, 
               model.getMakho(),
               model.getMaSach(),
               model.getTenSach(),
               model.getSoluong(),
                model.getMaNV(),
                model.getNgaytao());
   }
   public void update(Kho model){
        String sql="UPDATE kho set makho=?, masach = ?,tensach= ?,soluong = ?,manv = ?,ngaytao =? WHERE makho = ?";
        utils.JDBCHelper.update(sql, 
               model.getMakho(),
               model.getMaSach(),
               model.getTenSach(),
               model.getSoluong(),
                model.getMaNV(),
                model.getNgaytao());
    }
    
    public void delete(String MaNV){
        String sql="DELETE FROM kho WHERE makho = ?";
        utils.JDBCHelper.update(sql, MaNV);
    }
    
    public Kho selectById(String masach){
        String sql = "SELECT * FROM Kho WHERE makho = ?";
        List<Kho> list = this.SelectBySQL(sql, masach);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<Kho> SelectBySQL(String sql, Object... args) {
        List<Kho> listS = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = utils.JDBCHelper.query(sql, args);
                while (rs.next()) {
                    Kho st = new Kho();
                    st.setMakho(rs.getString(1));
                    st.setMaSach(rs.getString(2));
                    st.setTenSach(rs.getString(3));
                    st.setSoluong(rs.getInt(4));
                    st.setMaNV(rs.getString(5));
                    st.setNgaytao(rs.getString(6));
                    listS.add(st);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listS;
    }
    public List<Sach> SelectBySQLS(String sql, Object... args) {
        List<Sach> listS = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = utils.JDBCHelper.query(sql, args);
                while (rs.next()) {
                    Sach st = new Sach();
                    st.setMaSach(rs.getString(1));
                    st.setTenSach(rs.getString(2));
                    st.setNamXB(rs.getInt(3));
                    st.setNhaXB(rs.getString(4));
                    st.setGia(rs.getInt(5));
                    st.setTentacgia(rs.getString(6));
                    st.setTheloai(rs.getString(7));
                    st.setGhiChu(rs.getString(8));
                    st.setHinh(rs.getString(9));
                    listS.add(st);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listS;
    }

    public List<Kho> SelectAll() {
        String sql = "SELECT * FROM sach";
        return SelectBySQL(sql);
    }
    
    public List<Kho> SelectByKeyword(String keyword) {
        String sql = "SELECT * FROM sach WHERE tensach LIKE ?";
        return SelectBySQL(sql, "%" + keyword + "%");
    }
    public List<Sach> selectBySach(String masach) {
        String sql = "SELECT * FROM khosach WHERE MAsach = ?";
        return SelectBySQLS(sql, masach);
    }
}
