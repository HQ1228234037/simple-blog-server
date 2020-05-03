package com.hq.simpleblog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hq.simpleblog.dto.ArticleLikeDTO;
import com.hq.simpleblog.dto.ArticleLikeQueryDTO;
import com.hq.simpleblog.entity.ArticleLikeEntity;
import com.hq.simpleblog.enums.Code;
import com.hq.simpleblog.mapper.ArticleLikeMapper;
import com.hq.simpleblog.service.ArticleLikeService;
import com.hq.simpleblog.utils.JSONUtils;
import com.hq.simpleblog.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (ArticleLike)表服务实现类
 *
 * @author HQ
 * @version v1.0
 * @since 2020-04-23 22:07:30
 */
@Service()
public class ArticleLikeServiceImpl implements ArticleLikeService {

    @Autowired
    private ArticleLikeMapper articleLikeMapper;

    @Override
    public ResultVO getById(Long articleLikeId) {
        ResultVO resultVO = new ResultVO();
        ArticleLikeEntity articleLikeEntity = articleLikeMapper.getById(articleLikeId);
        if (articleLikeEntity == null) {
            resultVO.setCode(Code.DataError);
        } else {
            resultVO.setData(JSONUtils.getJSONObject(articleLikeEntity));
        }
        return resultVO;
    }

    @Override
    public ResultVO getAll() {
        ResultVO resultVO = new ResultVO();
        List<ArticleLikeEntity> articleLikeEntitys = articleLikeMapper.getAll();
        resultVO.getData().put("list", JSONUtils.getJSONArray(articleLikeEntitys));
        return resultVO;
    }

    @Override
    public ResultVO getByPage(ArticleLikeQueryDTO articleLikeQueryDTO) {
        ResultVO resultVO = new ResultVO();
        // 设置分页信息
        PageHelper.startPage(articleLikeQueryDTO.getPageNumber(), articleLikeQueryDTO.getPageSize());
        // 根据实体查询数据
        ArticleLikeEntity articleLikeEntity = articleLikeQueryDTO.getEntity();
        Page<ArticleLikeEntity> articleLikePage = articleLikeMapper.page(articleLikeEntity);
        PageInfo<ArticleLikeEntity> articleLikePageInfo = new PageInfo<>(articleLikePage);
        resultVO.setCode(Code.Success);
        resultVO.setData(JSONUtils.getJSONObject(articleLikePageInfo));
        return resultVO;
    }

    @Override
    public ResultVO insert(ArticleLikeDTO articleLikeDTO) {
        ResultVO resultVO = new ResultVO();
        ArticleLikeEntity articleLikeEntity = articleLikeDTO.getEntity();
        int insert = articleLikeMapper.insert(articleLikeEntity);
        if (insert < 1) {
            resultVO.setCode(Code.Failure);
        }
        return resultVO;
    }

    @Override
    public ResultVO update(ArticleLikeDTO articleLikeDTO) {
        ResultVO resultVO = new ResultVO();
        ArticleLikeEntity articleLikeEntity = articleLikeDTO.getEntity();
        int insert = articleLikeMapper.update(articleLikeEntity);
        if (insert < 1) {
            resultVO.setCode(Code.Failure);
        }
        return resultVO;
    }

    @Override
    public ResultVO deleteById(Long articleLikeId) {
        ResultVO resultVO = new ResultVO();
        int delete = articleLikeMapper.deleteById(articleLikeId);
        if (delete < 1) {
            resultVO.setCode(Code.Failure);
        }
        return resultVO;
    }

}