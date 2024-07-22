package com.atguigu.srb.core.controller.admin;


import com.atguigu.common.result.R;
import com.atguigu.srb.core.pojo.entity.UserLoginRecord;
import com.atguigu.srb.core.service.UserLoginRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户登录记录表 前端控制器
 * </p>
 *
 * @author cbb
 * @since 2024-06-30
 */
@Api(tags = "会员登录日志接口")
@RestController
@RequestMapping("admin/core/userLoginRecord")
@Slf4j
//@CrossOrigin
public class AdminLoginRecordController {
    @Resource
    private UserLoginRecordService userLoginRecordService;

    @ApiOperation(value = "获取会员登录日志")
    @GetMapping("/listTop50/{userID}")
    public R listTop50(
            @ApiParam(value = "用户id", required = true)
            @PathVariable Long userID
    ) {
        List<UserLoginRecord> userLoginRecordList = userLoginRecordService.listTop50(userID);
        return R.ok().data("list", userLoginRecordList);
    }
}

