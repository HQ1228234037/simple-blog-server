package com.hq.simpleblog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hq.simpleblog.dto.RoleUserDTO;
import com.hq.simpleblog.dto.RoleUserQueryDTO;
import com.hq.simpleblog.entity.RoleUserEntity;
import com.hq.simpleblog.enums.Code;
import com.hq.simpleblog.mapper.RoleUserMapper;
import com.hq.simpleblog.service.RoleUserService;
import com.hq.simpleblog.utils.JSONUtils;
import com.hq.simpleblog.vo.ResultVO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户角色关联表(RoleUser)表服务实现类
 *
 * @author HQ
 * @version v1.0
 * @since 2020-03-22 21:12:04
 */
@Service()
public class RoleUserServiceImpl implements RoleUserService {

    @Autowired
    private RoleUserMapper roleUserMapper;

    @Override
    public ResultVO getById(Long roleUserId) {
        ResultVO resultVO = new ResultVO();
        RoleUserEntity roleUserEntity = roleUserMapper.getById(roleUserId);
        if (roleUserEntity == null) {
            resultVO.setCode(Code.DataError);
        } else {
            resultVO.setData(JSONUtils.getJSONObject(roleUserEntity));
        }
        return resultVO;
    }

    @Override
    public ResultVO getAll() {
        ResultVO resultVO = new ResultVO();
        List<RoleUserEntity> roleUserEntitys = roleUserMapper.getAll();
        resultVO.getData().put("list", JSONUtils.getJSONArray(roleUserEntitys));
        return resultVO;
    }

    @Override
    public ResultVO getByPage(RoleUserQueryDTO roleUserQueryDTO) {
        ResultVO resultVO = new ResultVO();
        // 设置分页信息
        PageHelper.startPage(roleUserQueryDTO.getPageNumber(), roleUserQueryDTO.getPageSize());
        // 根据实体查询数据
        RoleUserEntity roleUserEntity = roleUserQueryDTO.getEntity();
        Page<RoleUserEntity> roleUserPage = roleUserMapper.page(roleUserEntity);
        PageInfo<RoleUserEntity> roleUserPageInfo = new PageInfo<>(roleUserPage);
        resultVO.setCode(Code.Success);
        resultVO.setData(JSONUtils.getJSONObject(roleUserPageInfo));
        return resultVO;
    }

    @Override
    public ResultVO insert(RoleUserDTO roleUserDTO) {
        ResultVO resultVO = new ResultVO();
        RoleUserEntity roleUserEntity = roleUserDTO.getEntity();
        int insert = roleUserMapper.insert(roleUserEntity);
        if (insert < 1) {
            resultVO.setCode(Code.Failure);
        }
        return resultVO;
    }

    @Override
    public ResultVO update(RoleUserDTO roleUserDTO) {
        ResultVO resultVO = new ResultVO();
        RoleUserEntity roleUserEntity = roleUserDTO.getEntity();
        int insert = roleUserMapper.update(roleUserEntity);
        if (insert < 1) {
            resultVO.setCode(Code.Failure);
        }
        return resultVO;
    }

    @Override
    public ResultVO deleteById(Long roleUserId) {
        ResultVO resultVO = new ResultVO();
        int delete = roleUserMapper.deleteById(roleUserId);
        if (delete < 1) {
            resultVO.setCode(Code.Failure);
        }
        return resultVO;
    }

    @Override
    public List<Long> getRoleIdsByUserId(Long userId) {
        List<Long> roleIds = new ArrayList<>();

        RoleUserEntity searchRoleUserEntity = new RoleUserEntity();
        searchRoleUserEntity.setUserId(userId);
        List<RoleUserEntity> roleUserEntities = roleUserMapper.getByEntity(searchRoleUserEntity);

        if (CollectionUtils.isEmpty(roleUserEntities)) {
            return roleIds;
        }

        for (RoleUserEntity roleUserEntity : roleUserEntities) {
            roleIds.add(roleUserEntity.getRoleId());
        }

        return roleIds;
    }

}