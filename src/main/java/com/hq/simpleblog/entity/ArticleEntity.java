package com.hq.simpleblog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (Article)表实体类
 *
 * @author HQ
 * @version v1.0
 * @since 2020-04-23 22:07:30
 */
@Data
public class ArticleEntity implements Serializable {

    private static final long serialVersionUID = 266217922051798359L;

    /**
     * 文章id 
     */
    private Long articleId;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 文章描述
     */
    private String articleDescription;

    /**
     * 文章内容
     */
    private Object articleContent;

    /**
     * 文章类型id
     */
    private Long articleTypeId;

    /**
     * 阅读数
     */
    private Long readCount;

    /**
     * 点赞数
     */
    private Long likeCount;

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