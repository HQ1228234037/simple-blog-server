package com.hq.simpleblog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hq.simpleblog.dto.ArticleDTO;
import com.hq.simpleblog.dto.ArticleQueryDTO;
import com.hq.simpleblog.entity.ArticleEntity;
import com.hq.simpleblog.enums.Code;
import com.hq.simpleblog.mapper.ArticleMapper;
import com.hq.simpleblog.service.ArticleService;
import com.hq.simpleblog.utils.JSONUtils;
import com.hq.simpleblog.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Article)表服务实现类
 *
 * @author HQ
 * @version v1.0
 * @since 2020-04-23 22:07:30
 */
@Service()
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public ResultVO getById(Long articleId) {
        ResultVO resultVO = new ResultVO();
        ArticleEntity articleEntity = articleMapper.getById(articleId);
        if (articleEntity == null) {
            resultVO.setCode(Code.DataError);
        } else {
            resultVO.setData(JSONUtils.getJSONObject(articleEntity));
        }
        return resultVO;
    }

    @Override
    public ResultVO getAll() {
        ResultVO resultVO = new ResultVO();
        List<ArticleEntity> articleEntitys = articleMapper.getAll();
        resultVO.getData().put("list", JSONUtils.getJSONArray(articleEntitys));
        return resultVO;
    }

    @Override
    public ResultVO getByPage(ArticleQueryDTO articleQueryDTO) {
        ResultVO resultVO = new ResultVO();
        // 设置分页信息
        PageHelper.startPage(articleQueryDTO.getPageNumber(), articleQueryDTO.getPageSize());
        // 根据实体查询数据
        ArticleEntity articleEntity = articleQueryDTO.getEntity();
        Page<ArticleEntity> articlePage = articleMapper.page(articleEntity);
        PageInfo<ArticleEntity> articlePageInfo = new PageInfo<>(articlePage);
        resultVO.setCode(Code.Success);
        resultVO.setData(JSONUtils.getJSONObject(articlePageInfo));
        return resultVO;
    }

    @Override
    public ResultVO insert(ArticleDTO articleDTO) {
        ResultVO resultVO = new ResultVO();
        ArticleEntity articleEntity = articleDTO.getEntity();
        int insert = articleMapper.insert(articleEntity);
        if (insert < 1) {
            resultVO.setCode(Code.Failure);
        }
        return resultVO;
    }

    @Override
    public ResultVO update(ArticleDTO articleDTO) {
        ResultVO resultVO = new ResultVO();
        ArticleEntity articleEntity = articleDTO.getEntity();
        int insert = articleMapper.update(articleEntity);
        if (insert < 1) {
            resultVO.setCode(Code.Failure);
        }
        return resultVO;
    }

    @Override
    public ResultVO deleteById(Long articleId) {
        ResultVO resultVO = new ResultVO();
        int delete = articleMapper.deleteById(articleId);
        if (delete < 1) {
            resultVO.setCode(Code.Failure);
        }
        return resultVO;
    }

}