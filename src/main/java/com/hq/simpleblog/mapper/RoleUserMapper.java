package com.hq.simpleblog.mapper;

import com.github.pagehelper.Page;
import com.hq.simpleblog.entity.RoleUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户角色关联表(RoleUser)表数据库访问层
 *
 * @author HQ
 * @version v1.0
 * @since 2020-03-22 21:12:04
 */
@Mapper
@Repository
public interface RoleUserMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param roleUserId 主键
     * @return 实例对象
     */
    RoleUserEntity getById(Long roleUserId);

    /**
     * 获取所有实例对象
     *
     * @return 对象列表
     */
    List<RoleUserEntity> getAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param roleUserEntity 实例对象
     * @return 对象列表
     */
    List<RoleUserEntity> getByEntity(RoleUserEntity roleUserEntity);

    /**
     * 分页获取数据
     * 通过实体作为筛选条件查询
     *
     * @param roleUserEntity 实例对象
     * @return 分页信息和对象列表
     */
    Page<RoleUserEntity> page(RoleUserEntity roleUserEntity);

    /**
     * 新增数据
     *
     * @param roleUserEntity 实例对象
     * @return 影响行数
     */
    int insert(RoleUserEntity roleUserEntity);

    /**
     * 修改数据
     *
     * @param roleUserEntity 实例对象
     * @return 影响行数
     */
    int update(RoleUserEntity roleUserEntity);

    /**
     * 通过主键删除数据
     *
     * @param roleUserId 主键
     * @return 影响行数
     */
    int deleteById(Long roleUserId);

}