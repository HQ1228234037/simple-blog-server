package com.hq.simpleblog.mapper;

import com.github.pagehelper.Page;
import com.hq.simpleblog.entity.ArticleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Article)表数据库访问层
 *
 * @author HQ
 * @version v1.0
 * @since 2020-04-23 22:07:30
 */
@Mapper
@Repository
public interface ArticleMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param articleId 主键
     * @return 实例对象
     */
    ArticleEntity getById(Long articleId);

    /**
     * 获取所有实例对象
     *
     * @return 对象列表
     */
    List<ArticleEntity> getAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param articleEntity 实例对象
     * @return 对象列表
     */
    List<ArticleEntity> getByEntity(ArticleEntity articleEntity);

    /**
     * 分页获取数据
     * 通过实体作为筛选条件查询
     *
     * @param articleEntity 实例对象
     * @return 分页信息和对象列表
     */
    Page<ArticleEntity> page(ArticleEntity articleEntity);

    /**
     * 新增数据
     *
     * @param articleEntity 实例对象
     * @return 影响行数
     */
    int insert(ArticleEntity articleEntity);

    /**
     * 修改数据
     *
     * @param articleEntity 实例对象
     * @return 影响行数
     */
    int update(ArticleEntity articleEntity);

    /**
     * 通过主键删除数据
     *
     * @param articleId 主键
     * @return 影响行数
     */
    int deleteById(Long articleId);

}