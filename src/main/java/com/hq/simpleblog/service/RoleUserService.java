package com.hq.simpleblog.service;

import com.hq.simpleblog.dto.RoleUserDTO;
import com.hq.simpleblog.dto.RoleUserQueryDTO;
import com.hq.simpleblog.vo.ResultVO;

import java.util.List;

/**
 * 用户角色关联表(RoleUser)表服务接口
 *
 * @author HQ
 * @version v1.0
 * @since 2020-03-22 21:12:04
 */
public interface RoleUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param roleUserId 主键
     * @return 实例对象
     */
    ResultVO getById(Long roleUserId);

    /**
     * 查询全部数据
     *
     * @return 对象列表
     */
    ResultVO getAll();

    /**
     * 分页查询数据
     *
     * @param roleUserQueryDTO 实例查询DTO对象
     * @return 对象列表
     */
    ResultVO getByPage(RoleUserQueryDTO roleUserQueryDTO);

    /**
     * 新增数据
     *
     * @param roleUserDTO 实例DTO对象
     * @return 实例对象
     */
    ResultVO insert(RoleUserDTO roleUserDTO);

    /**
     * 修改数据
     *
     * @param roleUserDTO 实例DTO对象
     * @return 实例对象
     */
    ResultVO update(RoleUserDTO roleUserDTO);

    /**
     * 通过主键删除数据
     *
     * @param roleUserId 主键
     * @return 是否成功
     */
    ResultVO deleteById(Long roleUserId);

    /**
     * 根据用户id获取角色id集合
     *
     * @param userId: 用户 id
     * @author HQ
     * @since 2020/3/22 21:25
     **/
    List<Long> getRoleIdsByUserId(Long userId);
}