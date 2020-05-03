package com.hq.simpleblog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (ArticleLike)表实体类
 *
 * @author HQ
 * @version v1.0
 * @since 2020-04-23 22:07:30
 */
@Data
public class ArticleLikeEntity implements Serializable {

    private static final long serialVersionUID = -98377707372184208L;

    /**
     *  id
     */
    private Long articleLikeId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     *  文章id
     */
    private Long articleId;

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