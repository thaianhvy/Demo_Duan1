/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import javax.swing.ImageIcon;

/**
 *
 * @author Vy The Monkey
 */
public class SanPham {
    private Integer masp;
    private String tensp;
    private String hinhsp;

    public Integer getMasp() {
        return masp;
    }

    public void setMasp(Integer masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getHinhsp() {
        return hinhsp;
    }

    public void setHinhsp(String hinhsp) {
        this.hinhsp = hinhsp;
    }

    public SanPham(Integer masp, String tensp, String hinhsp) {
        this.masp = masp;
        this.tensp = tensp;
        this.hinhsp = hinhsp;
    }

    public SanPham() {
    }
    
    
}
