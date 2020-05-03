package com.hq.simpleblog.mapper;

import com.github.pagehelper.Page;
import com.hq.simpleblog.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户表(User)表数据库访问层
 *
 * @author HQ
 * @version v1.0
 * @since 2020-03-22 16:59:09
 */
@Mapper
@Repository("userMapper")
public interface UserMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    UserEntity getById(Long userId);

    /**
     * 获取所有实例对象
     *
     * @return 对象列表
     */
    List<UserEntity> getAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param userEntity 实例对象
     * @return 对象列表
     */
    List<UserEntity> getByEntity(UserEntity userEntity);

    /**
     * 分页获取数据
     * 通过实体作为筛选条件查询
     *
     * @param userEntity 实例对象
     * @return 分页信息和对象列表
     */
    Page<UserEntity> page(UserEntity userEntity);

    /**
     * 新增数据
     *
     * @param userEntity 实例对象
     * @return 影响行数
     */
    int insert(UserEntity userEntity);

    /**
     * 修改数据
     *
     * @param userEntity 实例对象
     * @return 影响行数
     */
    int update(UserEntity userEntity);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 影响行数
     */
    int deleteById(Long userId);

    /**
     * 根据邮箱查询用户信息
     *
     * @param email 邮箱
     * @return 用户信息
     */
    UserEntity getUserByEmail(String email);

}