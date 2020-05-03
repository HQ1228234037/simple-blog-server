package com.hq.simpleblog.controller;

import com.hq.simpleblog.dto.ArticleLikeDTO;
import com.hq.simpleblog.dto.ArticleLikeQueryDTO;
import com.hq.simpleblog.enums.Code;
import com.hq.simpleblog.service.ArticleLikeService;
import com.hq.simpleblog.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * (ArticleLike)表控制层
 *
 * @author HQ
 * @version v1.0
 * @since 2020-04-23 22:07:30
 */
@RestController
@RequestMapping("/api/articleLike")
public class ArticleLikeController {

    @Autowired
    private ArticleLikeService articleLikeService;

    /**
     * 根据主键获取数据
     *
     * @param articleLikeId 主键
     * @author HQ
     * @since 2020-04-23 22:07:30
     **/
    @GetMapping("/{articleLikeId}")
    public ResultVO getById(@PathVariable Long articleLikeId) {
        ResultVO resultVO = new ResultVO();
        if (articleLikeId == null || articleLikeId < 1) {
            resultVO.setCode(Code.RequestParamError);
            return resultVO;
        }
        return articleLikeService.getById(articleLikeId);
    }

    /**
     * 分页获取 ArticleLike 列表
     *
     * @param articleLikeQueryDTO 查询条件
     * @author HQ
     * @since 2020-04-23 22:07:30
     **/
    @PostMapping("/getByPage")
    public ResultVO getByPage(@RequestBody @Valid ArticleLikeQueryDTO articleLikeQueryDTO) {
        return articleLikeService.getByPage(articleLikeQueryDTO);
    }

    /**
     * 获取 ArticleLike 所有数据
     *
     * @author HQ
     * @since 2020-04-23 22:07:30
     **/
    @GetMapping("/getAll")
    public ResultVO getAll() {
        return articleLikeService.getAll();
    }

    /**
     * 新增 ArticleLike 数据
     *
     * @author HQ
     * @since 2020-04-23 22:07:30
     **/
    @PostMapping("/")
    public ResultVO insert(@RequestBody @Valid ArticleLikeDTO articleLikeDTO) {
        return articleLikeService.insert(articleLikeDTO);
    }

    /**
     * 修改 ArticleLike 数据
     *
     * @author HQ
     * @since 2020-04-23 22:07:30
     **/
    @PutMapping("/")
    public ResultVO update(@RequestBody @Valid ArticleLikeDTO articleLikeDTO) {
        return articleLikeService.update(articleLikeDTO);
    }

    /**
     * 通过主键删除数据
     *
     * @author HQ
     * @since 2020-04-23 22:07:30
     **/
    @DeleteMapping("/{articleLikeId}")
    public ResultVO deleteById(@PathVariable Long articleLikeId) {
        return articleLikeService.deleteById(articleLikeId);
    }

}