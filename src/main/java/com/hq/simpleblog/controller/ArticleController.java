package com.hq.simpleblog.controller;

import com.hq.simpleblog.dto.ArticleDTO;
import com.hq.simpleblog.dto.ArticleQueryDTO;
import com.hq.simpleblog.enums.Code;
import com.hq.simpleblog.service.ArticleService;
import com.hq.simpleblog.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * (Article)表控制层
 *
 * @author HQ
 * @version v1.0
 * @since 2020-04-23 22:07:30
 */
@RestController
@RequestMapping("/api/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 根据主键获取数据
     *
     * @param articleId 主键
     * @author HQ
     * @since 2020-04-23 22:07:30
     **/
    @GetMapping("/{articleId}")
    public ResultVO getById(@PathVariable Long articleId) {
        ResultVO resultVO = new ResultVO();
        if (articleId == null || articleId < 1) {
            resultVO.setCode(Code.RequestParamError);
            return resultVO;
        }
        return articleService.getById(articleId);
    }

    /**
     * 分页获取 Article 列表
     *
     * @param articleQueryDTO 查询条件
     * @author HQ
     * @since 2020-04-23 22:07:30
     **/
    @PostMapping("/getByPage")
    public ResultVO getByPage(@RequestBody @Valid ArticleQueryDTO articleQueryDTO) {
        return articleService.getByPage(articleQueryDTO);
    }

    /**
     * 获取 Article 所有数据
     *
     * @author HQ
     * @since 2020-04-23 22:07:30
     **/
    @GetMapping("/getAll")
    public ResultVO getAll() {
        return articleService.getAll();
    }

    /**
     * 新增 Article 数据
     *
     * @author HQ
     * @since 2020-04-23 22:07:30
     **/
    @PostMapping("/")
    public ResultVO insert(@RequestBody @Valid ArticleDTO articleDTO) {
        return articleService.insert(articleDTO);
    }

    /**
     * 修改 Article 数据
     *
     * @author HQ
     * @since 2020-04-23 22:07:30
     **/
    @PutMapping("/")
    public ResultVO update(@RequestBody @Valid ArticleDTO articleDTO) {
        return articleService.update(articleDTO);
    }

    /**
     * 通过主键删除数据
     *
     * @author HQ
     * @since 2020-04-23 22:07:30
     **/
    @DeleteMapping("/{articleId}")
    public ResultVO deleteById(@PathVariable Long articleId) {
        return articleService.deleteById(articleId);
    }

}