package com.hq.simpleblog.dto;

import com.hq.simpleblog.entity.ArticleEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * (Article)表查询 DTO 类
 *
 * @author HQ
 * @version v1.0
 * @since 2020-04-23 22:07:30
 */
@Data
public class ArticleQueryDTO implements Serializable {

    private static final long serialVersionUID = -37918390242518237L;

    /**
     * 页码
     */
    private Integer pageNumber;

    /**
     * 每页大小（查询数）
     */
    private Integer pageSize;

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

    public ArticleEntity getEntity() {
        ArticleEntity articleEntity = new ArticleEntity();
        BeanUtils.copyProperties(this, articleEntity);
        return articleEntity;
    }

}