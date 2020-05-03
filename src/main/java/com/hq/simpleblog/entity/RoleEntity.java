package com.hq.simpleblog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色表(Role)表实体类
 *
 * @author HQ
 * @version v1.0
 * @since 2020-03-22 21:11:47
 */
@Data
public class RoleEntity implements Serializable {

    private static final long serialVersionUID = -26784739370232061L;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 角色名称
     */
    private String roleName;

    private String remark;

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