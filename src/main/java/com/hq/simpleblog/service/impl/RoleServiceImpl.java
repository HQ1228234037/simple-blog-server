package com.hq.simpleblog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hq.simpleblog.dto.RoleDTO;
import com.hq.simpleblog.dto.RoleQueryDTO;
import com.hq.simpleblog.entity.RoleEntity;
import com.hq.simpleblog.enums.Code;
import com.hq.simpleblog.mapper.RoleMapper;
import com.hq.simpleblog.service.RoleService;
import com.hq.simpleblog.utils.JSONUtils;
import com.hq.simpleblog.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色表(Role)表服务实现类
 *
 * @author HQ
 * @version v1.0
 * @since 2020-03-22 21:11:47
 */
@Service()
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public ResultVO getById(Long roleId) {
        ResultVO resultVO = new ResultVO();
        RoleEntity roleEntity = roleMapper.getById(roleId);
        if (roleEntity == null) {
            resultVO.setCode(Code.DataError);
        } else {
            resultVO.setData(JSONUtils.getJSONObject(roleEntity));
        }
        return resultVO;
    }

    @Override
    public ResultVO getAll() {
        ResultVO resultVO = new ResultVO();
        List<RoleEntity> roleEntitys = roleMapper.getAll();
        resultVO.getData().put("list", JSONUtils.getJSONArray(roleEntitys));
        return resultVO;
    }

    @Override
    public ResultVO getByPage(RoleQueryDTO roleQueryDTO) {
        ResultVO resultVO = new ResultVO();
        // 设置分页信息
        PageHelper.startPage(roleQueryDTO.getPageNumber(), roleQueryDTO.getPageSize());
        // 根据实体查询数据
        RoleEntity roleEntity = roleQueryDTO.getEntity();
        Page<RoleEntity> rolePage = roleMapper.page(roleEntity);
        PageInfo<RoleEntity> rolePageInfo = new PageInfo<>(rolePage);
        resultVO.setCode(Code.Success);
        resultVO.setData(JSONUtils.getJSONObject(rolePageInfo));
        return resultVO;
    }

    @Override
    public ResultVO insert(RoleDTO roleDTO) {
        ResultVO resultVO = new ResultVO();
        RoleEntity roleEntity = roleDTO.getEntity();
        int insert = roleMapper.insert(roleEntity);
        if (insert < 1) {
            resultVO.setCode(Code.Failure);
        }
        return resultVO;
    }

    @Override
    public ResultVO update(RoleDTO roleDTO) {
        ResultVO resultVO = new ResultVO();
        RoleEntity roleEntity = roleDTO.getEntity();
        int insert = roleMapper.update(roleEntity);
        if (insert < 1) {
            resultVO.setCode(Code.Failure);
        }
        return resultVO;
    }

    @Override
    public ResultVO deleteById(Long roleId) {
        ResultVO resultVO = new ResultVO();
        int delete = roleMapper.deleteById(roleId);
        if (delete < 1) {
            resultVO.setCode(Code.Failure);
        }
        return resultVO;
    }

    @Override
    public List<String> getRoleNamesByRoleIds(List<Long> roleIds) {
        return roleMapper.getRoleNamesByRoleIds(roleIds);
    }

}