package com.hq.simpleblog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hq.simpleblog.dto.UserDTO;
import com.hq.simpleblog.dto.UserQueryDTO;
import com.hq.simpleblog.entity.UserEntity;
import com.hq.simpleblog.enums.Code;
import com.hq.simpleblog.mapper.UserMapper;
import com.hq.simpleblog.service.UserService;
import com.hq.simpleblog.utils.JSONUtils;
import com.hq.simpleblog.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户表(User)表服务实现类
 *
 * @author HQ
 * @version v1.0
 * @since 2020-03-22 16:59:09
 */
@Service()
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultVO getById(Long userId) {
        ResultVO resultVO = new ResultVO();
        UserEntity userEntity = userMapper.getById(userId);
        if (userEntity == null) {
            resultVO.setCode(Code.DataError);
        } else {
            resultVO.setData(JSONUtils.getJSONObject(userEntity));
        }
        return resultVO;
    }

    @Override
    public ResultVO getAll() {
        ResultVO resultVO = new ResultVO();
        List<UserEntity> userEntitys = userMapper.getAll();
        resultVO.getData().put("list", JSONUtils.getJSONArray(userEntitys));
        return resultVO;
    }

    @Override
    public ResultVO getByPage(UserQueryDTO userQueryDTO) {
        ResultVO resultVO = new ResultVO();
        // 设置分页信息
        PageHelper.startPage(userQueryDTO.getPageNumber(), userQueryDTO.getPageSize());
        // 根据实体查询数据
        UserEntity userEntity = userQueryDTO.getEntity();
        Page<UserEntity> userPage = userMapper.page(userEntity);
        PageInfo<UserEntity> userPageInfo = new PageInfo<>(userPage);
        resultVO.setCode(Code.Success);
        resultVO.setData(JSONUtils.getJSONObject(userPageInfo));
        return resultVO;
    }

    @Override
    public ResultVO insert(UserDTO userDTO) {
        ResultVO resultVO = new ResultVO();
        UserEntity userEntity = userDTO.getEntity();
        int insert = userMapper.insert(userEntity);
        if (insert < 1) {
            resultVO.setCode(Code.Failure);
        }
        return resultVO;
    }

    @Override
    public ResultVO update(UserDTO userDTO) {
        ResultVO resultVO = new ResultVO();
        UserEntity userEntity = userDTO.getEntity();
        int insert = userMapper.update(userEntity);
        if (insert < 1) {
            resultVO.setCode(Code.Failure);
        }
        return resultVO;
    }

    @Override
    public ResultVO deleteById(Long userId) {
        ResultVO resultVO = new ResultVO();
        int delete = userMapper.deleteById(userId);
        if (delete < 1) {
            resultVO.setCode(Code.Failure);
        }
        return resultVO;
    }

    @Override
    public UserEntity getByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }

}