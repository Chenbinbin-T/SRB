package com.atguigu.srb.core.controller.api;


import com.atguigu.common.result.R;
import com.atguigu.srb.base.util.JwtUtils;
import com.atguigu.srb.core.pojo.entity.BorrowInfo;
import com.atguigu.srb.core.service.BorrowInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

/**
 * <p>
 * 借款信息表 前端控制器
 * </p>
 *
 * @author cbb
 * @since 2024-06-30
 */
@Api(tags = "借款信息")
@RestController
@RequestMapping("/api/core/borrowInfo")
@Slf4j
public class BorrowInfoController {
    @Resource
    private BorrowInfoService borrowInfoService;

    @ApiOperation("获取借款额度")
    @GetMapping("/auth/getBorrowAmount")
    public R getBorrowAmount(HttpServletRequest request) {
        String token = request.getHeader("token");
        Long userId = JwtUtils.getUserId(token);
        BigDecimal borrowAmount = borrowInfoService.getBorrowAmount(userId);
        return R.ok().data("borrowAmount", borrowAmount);
    }

    @ApiOperation("提交借款申请")
    @PostMapping("/auth/save")
    public R save(@RequestBody BorrowInfo borrowInfo,HttpServletRequest request){
        String token = request.getHeader("token");
        Long userId = JwtUtils.getUserId(token);
        borrowInfoService.saveBorrowInfo(borrowInfo, userId);
        return R.ok().message("提交成功");
    }

    @ApiOperation("获取借款申请审批状态")
    @GetMapping("/auth/getBorrowInfoStatus")
    public R getBorrowerStatus(HttpServletRequest request){
        String token = request.getHeader("token");
        Long userId = JwtUtils.getUserId(token);
        Integer status = borrowInfoService.getStatusByUserId(userId);
        return R.ok().data("borrowInfoStatus", status);
    }
}

