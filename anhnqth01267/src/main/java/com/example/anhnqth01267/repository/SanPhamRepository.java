package com.example.anhnqth01267.repository;

import com.example.anhnqth01267.entity.HoaDonChiTiet;
import com.example.anhnqth01267.entity.SanPham;
import com.example.anhnqth01267.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class SanPhamRepository {
    private Session s;
    public SanPhamRepository(){
        s = HibernateUtil.getFACTORY().openSession();
    }

    public List<SanPham> getAll(){
        return s.createQuery("from SanPham ").list();
    }

    public SanPham getOne(Integer id){
        return s.find(SanPham.class, id);
    }
    public List<HoaDonChiTiet> getListCombobox(){
        return s.createQuery("from HoaDonChiTiet ").list();
    }

    public HoaDonChiTiet getOneInvoice(Integer id){
        return s.find(HoaDonChiTiet.class, id);
    }
    public void addSanPham(SanPham sp){
        try{
            s.getTransaction().begin();
            s.save(sp);
            s.getTransaction().commit();
        } catch (Exception e){
            s.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public void delete(SanPham sp){
        try{
            s.getTransaction().begin();
            s.delete(sp);
            s.getTransaction().commit();
        } catch (Exception e){
            s.getTransaction().rollback();
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        System.out.println(new SanPhamRepository().getAll());
    }
}
