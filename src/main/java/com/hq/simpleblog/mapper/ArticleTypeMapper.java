package com.hq.simpleblog.mapper;

import com.github.pagehelper.Page;
import com.hq.simpleblog.entity.ArticleTypeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (ArticleType)表数据库访问层
 *
 * @author HQ
 * @version v1.0
 * @since 2020-04-23 22:07:31
 */
@Mapper
@Repository
public interface ArticleTypeMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param articleTypeId 主键
     * @return 实例对象
     */
    ArticleTypeEntity getById(Long articleTypeId);

    /**
     * 获取所有实例对象
     *
     * @return 对象列表
     */
    List<ArticleTypeEntity> getAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param articleTypeEntity 实例对象
     * @return 对象列表
     */
    List<ArticleTypeEntity> getByEntity(ArticleTypeEntity articleTypeEntity);

    /**
     * 分页获取数据
     * 通过实体作为筛选条件查询
     *
     * @param articleTypeEntity 实例对象
     * @return 分页信息和对象列表
     */
    Page<ArticleTypeEntity> page(ArticleTypeEntity articleTypeEntity);

    /**
     * 新增数据
     *
     * @param articleTypeEntity 实例对象
     * @return 影响行数
     */
    int insert(ArticleTypeEntity articleTypeEntity);

    /**
     * 修改数据
     *
     * @param articleTypeEntity 实例对象
     * @return 影响行数
     */
    int update(ArticleTypeEntity articleTypeEntity);

    /**
     * 通过主键删除数据
     *
     * @param articleTypeId 主键
     * @return 影响行数
     */
    int deleteById(Long articleTypeId);

}