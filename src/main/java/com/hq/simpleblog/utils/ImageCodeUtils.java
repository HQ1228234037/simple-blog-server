package com.hq.simpleblog.utils;

import com.hq.simpleblog.security.code.ImageCode;
import com.hq.simpleblog.security.constant.ImageCodeConstant;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 图片验证码工具类
 * 网上查找的
 *
 * @author HQ
 * @version v1.0
 * @since 2020/3/26 22:14
 **/
public class ImageCodeUtils {

    /**
     * 生成图片验证码
     *
     * @author HQ
     * @since 2020/3/26 22:15
     **/
    public static ImageCode generate() {
        int width = ImageCodeConstant.IMAGE_WIDTH;
        int height = ImageCodeConstant.IMAGE_HEIGHT;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics g = image.getGraphics();

        Random random = new Random();

        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);
        g.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        g.setColor(getRandColor(160, 200));
        for (int i = 0; i < 155; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }

        StringBuilder sRand = new StringBuilder();
        for (int i = 0; i < ImageCodeConstant.CODE_LENGTH; i++) {
            String rand = String.valueOf(random.nextInt(10));
            sRand.append(rand);
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            g.drawString(rand, 13 * i + 6, 16);
        }

        g.dispose();

        return new ImageCode(image, sRand.toString(), ImageCodeConstant.CODE_EXPIREIN);
    }

    /**
     * 生成随机背景条纹
     *
     * @author HQ
     * @since 2020/3/26 22:22
     **/
    private static Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

}
