package com.hq.simpleblog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hq.simpleblog.dto.ArticleTypeDTO;
import com.hq.simpleblog.dto.ArticleTypeQueryDTO;
import com.hq.simpleblog.entity.ArticleTypeEntity;
import com.hq.simpleblog.enums.Code;
import com.hq.simpleblog.mapper.ArticleTypeMapper;
import com.hq.simpleblog.service.ArticleTypeService;
import com.hq.simpleblog.utils.JSONUtils;
import com.hq.simpleblog.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (ArticleType)表服务实现类
 *
 * @author HQ
 * @version v1.0
 * @since 2020-04-23 22:07:31
 */
@Service()
public class ArticleTypeServiceImpl implements ArticleTypeService {

    @Autowired
    private ArticleTypeMapper articleTypeMapper;

    @Override
    public ResultVO getById(Long articleTypeId) {
        ResultVO resultVO = new ResultVO();
        ArticleTypeEntity articleTypeEntity = articleTypeMapper.getById(articleTypeId);
        if (articleTypeEntity == null) {
            resultVO.setCode(Code.DataError);
        } else {
            resultVO.setData(JSONUtils.getJSONObject(articleTypeEntity));
        }
        return resultVO;
    }

    @Override
    public ResultVO getAll() {
        ResultVO resultVO = new ResultVO();
        List<ArticleTypeEntity> articleTypeEntitys = articleTypeMapper.getAll();
        resultVO.getData().put("list", JSONUtils.getJSONArray(articleTypeEntitys));
        return resultVO;
    }

    @Override
    public ResultVO getByPage(ArticleTypeQueryDTO articleTypeQueryDTO) {
        ResultVO resultVO = new ResultVO();
        // 设置分页信息
        PageHelper.startPage(articleTypeQueryDTO.getPageNumber(), articleTypeQueryDTO.getPageSize());
        // 根据实体查询数据
        ArticleTypeEntity articleTypeEntity = articleTypeQueryDTO.getEntity();
        Page<ArticleTypeEntity> articleTypePage = articleTypeMapper.page(articleTypeEntity);
        PageInfo<ArticleTypeEntity> articleTypePageInfo = new PageInfo<>(articleTypePage);
        resultVO.setCode(Code.Success);
        resultVO.setData(JSONUtils.getJSONObject(articleTypePageInfo));
        return resultVO;
    }

    @Override
    public ResultVO insert(ArticleTypeDTO articleTypeDTO) {
        ResultVO resultVO = new ResultVO();
        ArticleTypeEntity articleTypeEntity = articleTypeDTO.getEntity();
        int insert = articleTypeMapper.insert(articleTypeEntity);
        if (insert < 1) {
            resultVO.setCode(Code.Failure);
        }
        return resultVO;
    }

    @Override
    public ResultVO update(ArticleTypeDTO articleTypeDTO) {
        ResultVO resultVO = new ResultVO();
        ArticleTypeEntity articleTypeEntity = articleTypeDTO.getEntity();
        int insert = articleTypeMapper.update(articleTypeEntity);
        if (insert < 1) {
            resultVO.setCode(Code.Failure);
        }
        return resultVO;
    }

    @Override
    public ResultVO deleteById(Long articleTypeId) {
        ResultVO resultVO = new ResultVO();
        int delete = articleTypeMapper.deleteById(articleTypeId);
        if (delete < 1) {
            resultVO.setCode(Code.Failure);
        }
        return resultVO;
    }

}