package com.hq.simpleblog.service;

import com.hq.simpleblog.dto.ArticleTypeDTO;
import com.hq.simpleblog.dto.ArticleTypeQueryDTO;
import com.hq.simpleblog.vo.ResultVO;

/**
 * (ArticleType)表服务接口
 *
 * @author HQ
 * @version v1.0
 * @since 2020-04-23 22:07:31
 */
public interface ArticleTypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param articleTypeId 主键
     * @return 实例对象
     */
    ResultVO getById(Long articleTypeId);

    /**
     * 查询全部数据
     *
     * @return 对象列表
     */
    ResultVO getAll();

    /**
     * 分页查询数据
     *
     * @param articleTypeQueryDTO 实例查询DTO对象
     * @return 对象列表
     */
    ResultVO getByPage(ArticleTypeQueryDTO articleTypeQueryDTO);

    /**
     * 新增数据
     *
     * @param articleTypeDTO 实例DTO对象
     * @return 实例对象
     */
    ResultVO insert(ArticleTypeDTO articleTypeDTO);

    /**
     * 修改数据
     *
     * @param articleTypeDTO 实例DTO对象
     * @return 实例对象
     */
    ResultVO update(ArticleTypeDTO articleTypeDTO);

    /**
     * 通过主键删除数据
     *
     * @param articleTypeId 主键
     * @return 是否成功
     */
    ResultVO deleteById(Long articleTypeId);

}