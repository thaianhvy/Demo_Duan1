package utils;

import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class XImage {
    /**
     * Ảnh biểu tượng của ứng dụng, xuất hiện trên mọi cửa sổ
     */
    public static Image getAppIcon(){
        String file = "/com/edusys/icon/fpt.png";
        return new ImageIcon(XImage.class.getResource(file)).getImage();
    }
    
    /**
     * Sao chép file logo chuyên đề vào thư mục logo
     * @param src là đối tượng file ảnh
     */   
    public static void save(File src){
        /* chep file image tu dia chi src vao folder logos */
        File dst = new File("logos", src.getName());
        if(!dst.getParentFile().exists()){
            dst.getParentFile().mkdirs();
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } 
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    /**
     * Đọc hình ảnh logo chuyên đề
     * @param fileName  là tên file logo
     * @return ảnh đọc được
     */   
    public static ImageIcon read(String fileName){
        File path = new File("logos", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }
    
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(600, 800);
        f.setIconImage(XImage.getAppIcon());
        f.setVisible(true);
    }
}