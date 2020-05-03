package com.hq.simpleblog.dto;

import com.hq.simpleblog.entity.RoleEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色表(Role)表查询 DTO 类
 *
 * @author HQ
 * @version v1.0
 * @since 2020-03-22 21:11:47
 */
@Data
public class RoleQueryDTO implements Serializable {

    private static final long serialVersionUID = -14953070338038558L;

    /**
     * 页码
     */
    private Integer pageNumber;

    /**
     * 每页大小（查询数）
     */
    private Integer pageSize;

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

    public RoleEntity getEntity() {
        RoleEntity roleEntity = new RoleEntity();
        BeanUtils.copyProperties(this, roleEntity);
        return roleEntity;
    }

}