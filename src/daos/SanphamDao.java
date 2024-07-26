package daos;

import entitys.SanPham;
import helpers.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import services.JdbcService;


public class SanphamDao implements JdbcService<SanPham,String> {
    String selectAll = "select * from san_pham";
    
    public static void main(String[] args) {
        SanphamDao spDao = new SanphamDao();
        if  (JdbcHelper.connect()!=null) {
            List<SanPham> lSp = spDao.findAll();
            for (SanPham sp : lSp)
               System.out.println(sp.getTensp() + "," + sp.getLink());
        } else System.out.println("Fail !");
    }

    @Override
    public List<SanPham> findAll() {        
        List<SanPham> list = new ArrayList<>();
        ResultSet rs = JdbcHelper.executeQuery(selectAll);
        try {
            while (rs.next()) {
                SanPham sp = new SanPham(
                        rs.getInt("id"),
                        rs.getString("tensp"),
                        rs.getString("link")
                );
                list.add(sp);            
            }   
            rs.close();
        } catch (SQLException ex) { return null; }
        return list;
    }
    
    
}
