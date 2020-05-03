package com.hq.simpleblog.mapper;

import com.github.pagehelper.Page;
import com.hq.simpleblog.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色表(Role)表数据库访问层
 *
 * @author HQ
 * @version v1.0
 * @since 2020-03-22 21:11:47
 */
@Mapper
@Repository
public interface RoleMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    RoleEntity getById(Long roleId);

    /**
     * 获取所有实例对象
     *
     * @return 对象列表
     */
    List<RoleEntity> getAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param roleEntity 实例对象
     * @return 对象列表
     */
    List<RoleEntity> getByEntity(RoleEntity roleEntity);

    /**
     * 分页获取数据
     * 通过实体作为筛选条件查询
     *
     * @param roleEntity 实例对象
     * @return 分页信息和对象列表
     */
    Page<RoleEntity> page(RoleEntity roleEntity);

    /**
     * 新增数据
     *
     * @param roleEntity 实例对象
     * @return 影响行数
     */
    int insert(RoleEntity roleEntity);

    /**
     * 修改数据
     *
     * @param roleEntity 实例对象
     * @return 影响行数
     */
    int update(RoleEntity roleEntity);

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 影响行数
     */
    int deleteById(Long roleId);

    /**
     * 根据 roleId 集合获取 roleName 集合
     *
     * @param roleIds: roleId 集合
     * @author HQ
     * @since 2020/3/22 21:31
     **/
    List<String> getRoleNamesByRoleIds(List<Long> roleIds);
}