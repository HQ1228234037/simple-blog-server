package com.hq.simpleblog.service;

import com.hq.simpleblog.dto.ArticleDTO;
import com.hq.simpleblog.dto.ArticleQueryDTO;
import com.hq.simpleblog.vo.ResultVO;

/**
 * (Article)表服务接口
 *
 * @author HQ
 * @version v1.0
 * @since 2020-04-23 22:07:30
 */
public interface ArticleService {

    /**
     * 通过ID查询单条数据
     *
     * @param articleId 主键
     * @return 实例对象
     */
    ResultVO getById(Long articleId);

    /**
     * 查询全部数据
     *
     * @return 对象列表
     */
    ResultVO getAll();

    /**
     * 分页查询数据
     *
     * @param articleQueryDTO 实例查询DTO对象
     * @return 对象列表
     */
    ResultVO getByPage(ArticleQueryDTO articleQueryDTO);

    /**
     * 新增数据
     *
     * @param articleDTO 实例DTO对象
     * @return 实例对象
     */
    ResultVO insert(ArticleDTO articleDTO);

    /**
     * 修改数据
     *
     * @param articleDTO 实例DTO对象
     * @return 实例对象
     */
    ResultVO update(ArticleDTO articleDTO);

    /**
     * 通过主键删除数据
     *
     * @param articleId 主键
     * @return 是否成功
     */
    ResultVO deleteById(Long articleId);

}