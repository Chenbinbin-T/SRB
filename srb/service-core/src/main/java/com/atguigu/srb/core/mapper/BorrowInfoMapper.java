package com.atguigu.srb.core.mapper;

import com.atguigu.srb.core.pojo.entity.BorrowInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 借款信息表 Mapper 接口
 * </p>
 *
 * @author cbb
 * @since 2024-06-30
 */
public interface BorrowInfoMapper extends BaseMapper<BorrowInfo> {

    List<BorrowInfo> selectBorrowInfoList();
}
