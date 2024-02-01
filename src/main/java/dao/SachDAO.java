/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Sach;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author NGUYEN THI NGUYET VY
 */
public class SachDAO {
   public void insert(Sach model){
       String sql="Insert into sach values(?,?,?,?,?,?,?,?,?,?,?)";
       utils.JDBCHelper.update(sql, 
               model.getMaSach(),
               model.getTenSach(),
               model.getNamXB(),    
               model.getNhaXB(),
               model.getGia(),
               model.getTentacgia(),
               model.getTheloai(),
               model.getGhiChu(),
                model.getHinh(),
                model.getMaTheLoai(),
                model.getMaTacGia());
   }
   public void update(Sach model){
        String sql="UPDATE sach SET tensach = ?, namXB = ?, nhaXB = ?, tentacgia = ?,theloai =?, GhiChu = ?,hinh = ?,matheloai =?,matacgia=? WHERE masach = ?";
        utils.JDBCHelper.update(sql, 
                model.getTenSach(), 
                model.getNamXB(), 
                model.getNhaXB(),
                model.getTentacgia(),
                model.getTheloai(),
                model.getGhiChu(),
                model.getMaSach(),
                model.getHinh(),
                model.getMaTheLoai(),
                model.getMaTacGia());
    }
    
    public void delete(String MaNV){
        String sql="DELETE FROM sach WHERE masach = ?";
        utils.JDBCHelper.update(sql, MaNV);
    }
    
    public Sach selectById(String masach){
        String sql = "SELECT * FROM sach WHERE masach = ?";
        List<Sach> list = this.SelectBySQL(sql, masach);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<Sach> SelectBySQL(String sql, Object... args) {
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
                    st.setMaTheLoai(rs.getString(10));
                    st.setMaTheLoai(rs.getString(11));
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

    public List<Sach> SelectAll() {
        String sql = "SELECT * FROM sach";
        return SelectBySQL(sql);
    }
    
    public List<Sach> SelectByKeyword(String keyword) {
        String sql = "SELECT * FROM sach WHERE tensach LIKE ?";
        return SelectBySQL(sql, "%" + keyword + "%");
    }
    public List<Sach> selectByTheLoai(String Matl) {
        String sql = "SELECT * FROM Sach WHERE theloai = ?";
        return SelectBySQL(sql, Matl);
    }
}
