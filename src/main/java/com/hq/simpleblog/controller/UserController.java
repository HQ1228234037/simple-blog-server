package com.hq.simpleblog.controller;

import com.hq.simpleblog.dto.UserDTO;
import com.hq.simpleblog.dto.UserQueryDTO;
import com.hq.simpleblog.enums.Code;
import com.hq.simpleblog.service.UserService;
import com.hq.simpleblog.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 用户表(User)表控制层
 *
 * @author HQ
 * @version v1.01
 * @since 2020-03-22 17:15:40
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据主键获取数据
     *
     * @param userId 主键
     * @author HQ
     * @since 2020-03-22 17:15:40
     **/
    @GetMapping("/{userId}")
    public ResultVO getById(@PathVariable Long userId) {
        ResultVO resultVO = new ResultVO();
        if (userId == null || userId < 1) {
            resultVO.setCode(Code.RequestParamError);
            return resultVO;
        }
        return userService.getById(userId);
    }

    /**
     * 分页获取 User 列表
     *
     * @param userQueryDTO 查询条件
     * @author HQ
     * @since 2020-03-22 17:15:40
     **/
    @PostMapping("/getByPage")
    public ResultVO getByPage(@RequestBody @Valid UserQueryDTO userQueryDTO) {
        return userService.getByPage(userQueryDTO);
    }

    /**
     * 获取 User 所有数据
     *
     * @author HQ
     * @since 2020-03-22 17:15:40
     **/
    @GetMapping("/getAll")
    public ResultVO getAll() {
        return userService.getAll();
    }

    /**
     * 新增 User 数据
     *
     * @author HQ
     * @since 2020-03-22 17:15:40
     **/
    @PostMapping("/")
    public ResultVO insert(@RequestBody @Valid UserDTO userDTO) {
        return userService.insert(userDTO);
    }

    /**
     * 修改 User 数据
     *
     * @author HQ
     * @since 2020-03-22 17:15:40
     **/
    @PutMapping("/")
    public ResultVO update(@RequestBody @Valid UserDTO userDTO) {
        return userService.update(userDTO);
    }

    /**
     * 通过主键删除数据
     *
     * @author HQ
     * @since 2020-03-22 17:15:40
     **/
    @DeleteMapping("/{userId}")
    public ResultVO deleteById(@PathVariable Long userId) {
        return userService.deleteById(userId);
    }

}