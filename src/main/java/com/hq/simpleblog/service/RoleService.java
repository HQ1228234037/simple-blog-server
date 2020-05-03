package com.hq.simpleblog.service;

import com.hq.simpleblog.dto.RoleDTO;
import com.hq.simpleblog.dto.RoleQueryDTO;
import com.hq.simpleblog.vo.ResultVO;

import java.util.List;

/**
 * 角色表(Role)表服务接口
 *
 * @author HQ
 * @version v1.0
 * @since 2020-03-22 21:11:47
 */
public interface RoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    ResultVO getById(Long roleId);

    /**
     * 查询全部数据
     *
     * @return 对象列表
     */
    ResultVO getAll();

    /**
     * 分页查询数据
     *
     * @param roleQueryDTO 实例查询DTO对象
     * @return 对象列表
     */
    ResultVO getByPage(RoleQueryDTO roleQueryDTO);

    /**
     * 新增数据
     *
     * @param roleDTO 实例DTO对象
     * @return 实例对象
     */
    ResultVO insert(RoleDTO roleDTO);

    /**
     * 修改数据
     *
     * @param roleDTO 实例DTO对象
     * @return 实例对象
     */
    ResultVO update(RoleDTO roleDTO);

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 是否成功
     */
    ResultVO deleteById(Long roleId);

    /**
     * 根据角色id集合获取角色名称集合
     *
     * @param roleIds: 角色id集合
     * @author HQ
     * @since 2020/3/22 21:30
     **/
    List<String> getRoleNamesByRoleIds(List<Long> roleIds);
}