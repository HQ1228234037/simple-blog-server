package com.hq.simpleblog.service;

import com.hq.simpleblog.dto.ArticleLikeDTO;
import com.hq.simpleblog.dto.ArticleLikeQueryDTO;
import com.hq.simpleblog.vo.ResultVO;

/**
 * (ArticleLike)表服务接口
 *
 * @author HQ
 * @version v1.0
 * @since 2020-04-23 22:07:30
 */
public interface ArticleLikeService {

    /**
     * 通过ID查询单条数据
     *
     * @param articleLikeId 主键
     * @return 实例对象
     */
    ResultVO getById(Long articleLikeId);

    /**
     * 查询全部数据
     *
     * @return 对象列表
     */
    ResultVO getAll();

    /**
     * 分页查询数据
     *
     * @param articleLikeQueryDTO 实例查询DTO对象
     * @return 对象列表
     */
    ResultVO getByPage(ArticleLikeQueryDTO articleLikeQueryDTO);

    /**
     * 新增数据
     *
     * @param articleLikeDTO 实例DTO对象
     * @return 实例对象
     */
    ResultVO insert(ArticleLikeDTO articleLikeDTO);

    /**
     * 修改数据
     *
     * @param articleLikeDTO 实例DTO对象
     * @return 实例对象
     */
    ResultVO update(ArticleLikeDTO articleLikeDTO);

    /**
     * 通过主键删除数据
     *
     * @param articleLikeId 主键
     * @return 是否成功
     */
    ResultVO deleteById(Long articleLikeId);

}