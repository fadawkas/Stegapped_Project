/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package base;

import java.io.File;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 *
 * @author mfada
 */
public class Decoder {
    static String imgPath;
    static String imgName;
    
    BufferedImage newImageFetch() {
        File f = new File(imgPath + "\\" + imgName + ".png");
        BufferedImage img = null;
        try {
            img = ImageIO.read(f);
        } catch (Exception ex) {
        }
        return img;
    }

    String revealMsg(int msgLen, int offset) {
        BufferedImage img = newImageFetch();
        byte[] msgBytes = extractHiddenBytes(img, msgLen, offset);
        if (msgBytes == null)
            return null;
        String msg = new String(msgBytes);
        return (msg);
    }

    byte[] extractHiddenBytes(BufferedImage img, int size, int offset) {

        int i = 0;
        int j = 0;
        byte[] hiddenBytes = new byte[size];

        for (int l = 0; l < size; l++) {
            for (int k = 0; k < 8; k++) {
                Color c = new Color(img.getRGB(j, i));
                byte blue = (byte) c.getBlue();
                hiddenBytes[l] = (byte) ((hiddenBytes[l] << 1) | (blue & 1));
                j++;
            }
            i++;
        }
        return hiddenBytes;
    }
}

