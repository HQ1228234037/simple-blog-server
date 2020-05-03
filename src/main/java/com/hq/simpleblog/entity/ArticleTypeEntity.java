package com.hq.simpleblog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (ArticleType)表实体类
 *
 * @author HQ
 * @version v1.0
 * @since 2020-04-23 22:07:31
 */
@Data
public class ArticleTypeEntity implements Serializable {

    private static final long serialVersionUID = -85319049829592856L;

    /**
     * 文章类型id
     */
    private Long articleTypeId;

    /**
     * 文章类型名称
     */
    private String articleTypeName;

    /**
     * 删除标识
     */
    private Object deleted;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;

}