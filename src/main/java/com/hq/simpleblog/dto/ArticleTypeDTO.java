package com.hq.simpleblog.dto;

import com.hq.simpleblog.entity.ArticleTypeEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * (ArticleType)表 DTO 类
 *
 * @author HQ
 * @version v1.0
 * @since 2020-04-23 22:07:31
 */
@Data
public class ArticleTypeDTO implements Serializable {

    private static final long serialVersionUID = -64755644697724341L;

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

    public ArticleTypeEntity getEntity() {
        ArticleTypeEntity articleTypeEntity = new ArticleTypeEntity();
        BeanUtils.copyProperties(this, articleTypeEntity);
        return articleTypeEntity;
    }

}