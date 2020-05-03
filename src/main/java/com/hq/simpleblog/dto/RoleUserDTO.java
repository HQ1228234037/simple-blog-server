package com.hq.simpleblog.dto;

import com.hq.simpleblog.entity.RoleUserEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户角色关联表(RoleUser)表 DTO 类
 *
 * @author HQ
 * @version v1.0
 * @since 2020-03-22 21:12:04
 */
@Data
public class RoleUserDTO implements Serializable {

    private static final long serialVersionUID = 182762854849654715L;

    /**
     * 用户角色关联id
     */
    private Long roleUserId;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 用户id
     */
    private Long userId;

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

    public RoleUserEntity getEntity() {
        RoleUserEntity roleUserEntity = new RoleUserEntity();
        BeanUtils.copyProperties(this, roleUserEntity);
        return roleUserEntity;
    }

}