package com.hq.simpleblog.service;

import com.hq.simpleblog.dto.UserDTO;
import com.hq.simpleblog.dto.UserQueryDTO;
import com.hq.simpleblog.entity.UserEntity;
import com.hq.simpleblog.vo.ResultVO;

/**
 * 用户表(User)表服务接口
 *
 * @author HQ
 * @version v1.0
 * @since 2020-03-22 16:59:09
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    ResultVO getById(Long userId);

    /**
     * 查询全部数据
     *
     * @return 对象列表
     */
    ResultVO getAll();

    /**
     * 分页查询数据
     *
     * @param userQueryDTO 实例查询DTO对象
     * @return 对象列表
     */
    ResultVO getByPage(UserQueryDTO userQueryDTO);

    /**
     * 新增数据
     *
     * @param userDTO 实例DTO对象
     * @return 实例对象
     */
    ResultVO insert(UserDTO userDTO);

    /**
     * 修改数据
     *
     * @param userDTO 实例DTO对象
     * @return 实例对象
     */
    ResultVO update(UserDTO userDTO);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    ResultVO deleteById(Long userId);

    /**
     * 根据邮箱查询用户信息
     *
     * @param email: 邮箱号
     * @author HQ
     * @since 2020/3/22 21:18
     **/
    UserEntity getByEmail(String email);
}