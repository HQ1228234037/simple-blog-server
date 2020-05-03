package com.hq.simpleblog.mapper;

import com.github.pagehelper.Page;
import com.hq.simpleblog.entity.ArticleLikeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (ArticleLike)表数据库访问层
 *
 * @author HQ
 * @version v1.0
 * @since 2020-04-23 22:07:30
 */
@Mapper
@Repository
public interface ArticleLikeMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param articleLikeId 主键
     * @return 实例对象
     */
    ArticleLikeEntity getById(Long articleLikeId);

    /**
     * 获取所有实例对象
     *
     * @return 对象列表
     */
    List<ArticleLikeEntity> getAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param articleLikeEntity 实例对象
     * @return 对象列表
     */
    List<ArticleLikeEntity> getByEntity(ArticleLikeEntity articleLikeEntity);

    /**
     * 分页获取数据
     * 通过实体作为筛选条件查询
     *
     * @param articleLikeEntity 实例对象
     * @return 分页信息和对象列表
     */
    Page<ArticleLikeEntity> page(ArticleLikeEntity articleLikeEntity);

    /**
     * 新增数据
     *
     * @param articleLikeEntity 实例对象
     * @return 影响行数
     */
    int insert(ArticleLikeEntity articleLikeEntity);

    /**
     * 修改数据
     *
     * @param articleLikeEntity 实例对象
     * @return 影响行数
     */
    int update(ArticleLikeEntity articleLikeEntity);

    /**
     * 通过主键删除数据
     *
     * @param articleLikeId 主键
     * @return 影响行数
     */
    int deleteById(Long articleLikeId);

}