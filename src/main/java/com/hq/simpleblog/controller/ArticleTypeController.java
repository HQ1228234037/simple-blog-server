package com.hq.simpleblog.controller;

import com.hq.simpleblog.dto.ArticleTypeDTO;
import com.hq.simpleblog.dto.ArticleTypeQueryDTO;
import com.hq.simpleblog.enums.Code;
import com.hq.simpleblog.service.ArticleTypeService;
import com.hq.simpleblog.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * (ArticleType)表控制层
 *
 * @author HQ
 * @version v1.0
 * @since 2020-04-23 22:07:31
 */
@RestController
@RequestMapping("/api/articleType")
public class ArticleTypeController {

    @Autowired
    private ArticleTypeService articleTypeService;

    /**
     * 根据主键获取数据
     *
     * @param articleTypeId 主键
     * @author HQ
     * @since 2020-04-23 22:07:31
     **/
    @GetMapping("/{articleTypeId}")
    public ResultVO getById(@PathVariable Long articleTypeId) {
        ResultVO resultVO = new ResultVO();
        if (articleTypeId == null || articleTypeId < 1) {
            resultVO.setCode(Code.RequestParamError);
            return resultVO;
        }
        return articleTypeService.getById(articleTypeId);
    }

    /**
     * 分页获取 ArticleType 列表
     *
     * @param articleTypeQueryDTO 查询条件
     * @author HQ
     * @since 2020-04-23 22:07:31
     **/
    @PostMapping("/getByPage")
    public ResultVO getByPage(@RequestBody @Valid ArticleTypeQueryDTO articleTypeQueryDTO) {
        return articleTypeService.getByPage(articleTypeQueryDTO);
    }

    /**
     * 获取 ArticleType 所有数据
     *
     * @author HQ
     * @since 2020-04-23 22:07:31
     **/
    @GetMapping("/getAll")
    public ResultVO getAll() {
        return articleTypeService.getAll();
    }

    /**
     * 新增 ArticleType 数据
     *
     * @author HQ
     * @since 2020-04-23 22:07:31
     **/
    @PostMapping("/")
    public ResultVO insert(@RequestBody @Valid ArticleTypeDTO articleTypeDTO) {
        return articleTypeService.insert(articleTypeDTO);
    }

    /**
     * 修改 ArticleType 数据
     *
     * @author HQ
     * @since 2020-04-23 22:07:31
     **/
    @PutMapping("/")
    public ResultVO update(@RequestBody @Valid ArticleTypeDTO articleTypeDTO) {
        return articleTypeService.update(articleTypeDTO);
    }

    /**
     * 通过主键删除数据
     *
     * @author HQ
     * @since 2020-04-23 22:07:31
     **/
    @DeleteMapping("/{articleTypeId}")
    public ResultVO deleteById(@PathVariable Long articleTypeId) {
        return articleTypeService.deleteById(articleTypeId);
    }

}