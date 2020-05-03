package com.hq.simpleblog.controller;

import com.hq.simpleblog.enums.Code;
import com.hq.simpleblog.security.code.ImageCode;
import com.hq.simpleblog.security.constant.ImageCodeConstant;
import com.hq.simpleblog.security.constant.SecurityConstants;
import com.hq.simpleblog.utils.ImageCodeUtils;
import com.hq.simpleblog.vo.ResultVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 验证码controller
 *
 * @author HQ
 * @version v1.0
 * @since 2020/3/26 23:05
 **/
@RestController
@RequestMapping("/api/code")
public class CodeController {

    /**
     * 获取图片验证码
     *
     * @author HQ
     * @since 2020/3/26 23:08
     **/
    @GetMapping("/imageCode")
    public ResultVO getImageCode(HttpServletRequest request) throws IOException {
        ResultVO resultVO = new ResultVO();

        // 生成验证码
        ImageCode imageCode = ImageCodeUtils.generate();
        BufferedImage image = imageCode.getImage();
        imageCode.setImage(null);
        // 保存验证码到 session 中
        request.getSession().setAttribute(SecurityConstants.IMAGE_CODE_KEY, imageCode);

        String imageBase64 = imageToBase64(image);
        if (StringUtils.isNotBlank(imageBase64)) {
            resultVO.getData().put("imageCode", imageBase64);
        } else {
            resultVO.setCode(Code.Failure);
        }

        return resultVO;
    }

    /**
     * 将验证码图片转换成 base64
     *
     * @param image 验证码图片
     * @author HQ
     * @since 2020/3/26 23:07
     **/
    public String imageToBase64(BufferedImage image) throws IOException {
        // io流
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        // 写入流中
        ImageIO.write(image, "png", byteArrayOutputStream);
        // 转换成字节
        byte[] bytes = byteArrayOutputStream.toByteArray();
        BASE64Encoder encoder = new BASE64Encoder();
        // 转换成base64串
        String imageBase64 = encoder.encodeBuffer(bytes).trim();
        return imageBase64.replaceAll("\n", "").replaceAll("\r", "");
    }

}
