package com.hq.simpleblog.security.code;

import lombok.Data;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 图片验证码
 *
 * @author HQ
 * @version v1.0
 * @since 2020/3/26 22:15
 **/
@Data
public class ImageCode implements Serializable {

    private BufferedImage image;
    private String code;
    private LocalDateTime expireIn;

    public ImageCode(BufferedImage image, String code, int expire) {
        this.image = image;
        this.code = code;
        this.expireIn = LocalDateTime.now().plusSeconds(expire);
    }

    boolean isExpire() {
        return LocalDateTime.now().isAfter(expireIn);
    }

}
