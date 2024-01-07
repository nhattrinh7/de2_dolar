
package de2_dolar;


public class Person {
    
    public String hoTen;
    public String ngaySinh;
    public String diaChi;
    public String gioiTinh;

    public Person(String hoTen, String ngaySinh, String diaChi, String gioiTinh) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
    }

    
    
    public void hienThiThongTin() {
        System.out.println("Ho ten " + this.hoTen);
        System.out.println("Ngay sinh " + this.ngaySinh);
        System.out.println("Dia chi " + this.diaChi);
        System.out.println("Gioi tinh " + this.gioiTinh);
    }


    public static void main(String[] args) {
        JFNhanvien nv = new JFNhanvien();    
        nv.show();
    }
    
}
