/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package base;


import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.FileReader;
import java.io.File;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 *
 * @author mfada
 */
public class ImageProcess {
    static String imgPath;
    static String imgName;
    BufferedImage fetchImage() throws Exception {
        File f = new File(imgPath + "\\" + imgName + ".png");
        BufferedImage img = ImageIO.read(f);
        return img;
    }

    void hideText(BufferedImage img, byte[] txt) throws Exception {
        int i = 0;
        int j = 0;
        for (byte b : txt) {
            for (int k = 7; k >= 0; k--) {
                Color c = new Color(img.getRGB(j, i));
                byte blue = (byte) c.getBlue();
                int red = c.getRed();
                int green = c.getGreen();
                int bitVal = (b >>> k) & 1;
                blue = (byte) ((blue & 0xFE) | bitVal);
                Color newColor = new Color(red, green, (blue & 0xFF));
                img.setRGB(j, i, newColor.getRGB());
                j++;
            }
            i++;
        }

        System.out.println("Text Hidden");
        createImgWithMsg(img);
    }

    void createImgWithMsg(BufferedImage img) {
        
        try {
            File ouptut = new File("C:\\Users\\mfada\\OneDrive\\Documents\\Training Arc\\Java Arc\\Kriptografi\\Steganography_Project\\src\\embeddedOutput\\" + imgName + ".png");
            ImageIO.write(img, "png", ouptut);
        } catch (Exception ex) {
        }
    }
}
