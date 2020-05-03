package com.hq.simpleblog.dto;

import com.hq.simpleblog.entity.UserEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表(User)表 DTO 类
 *
 * @author HQ
 * @version v1.0
 * @since 2020-03-22 16:59:09
 */
@Data
public class UserDTO implements Serializable {

    private static final long serialVersionUID = -41206881555039293L;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 性别
     */
    private String sex;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 用户未锁定
     */
    private Boolean lock;

    /**
     * 删除标识
     */
    private Boolean deleted;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;

    public UserEntity getEntity() {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(this, userEntity);
        return userEntity;
    }

}