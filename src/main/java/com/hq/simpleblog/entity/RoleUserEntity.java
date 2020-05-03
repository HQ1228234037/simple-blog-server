package com.hq.simpleblog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户角色关联表(RoleUser)表实体类
 *
 * @author HQ
 * @version v1.0
 * @since 2020-03-22 21:12:03
 */
@Data
public class RoleUserEntity implements Serializable {

    private static final long serialVersionUID = -60308360478719434L;

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

}