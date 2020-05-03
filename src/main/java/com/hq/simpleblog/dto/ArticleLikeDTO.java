package com.hq.simpleblog.dto;

import com.hq.simpleblog.entity.ArticleLikeEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * (ArticleLike)表 DTO 类
 *
 * @author HQ
 * @version v1.0
 * @since 2020-04-23 22:07:31
 */
@Data
public class ArticleLikeDTO implements Serializable {

    private static final long serialVersionUID = -23767740385451287L;

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

    public ArticleLikeEntity getEntity() {
        ArticleLikeEntity articleLikeEntity = new ArticleLikeEntity();
        BeanUtils.copyProperties(this, articleLikeEntity);
        return articleLikeEntity;
    }

}