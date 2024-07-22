package com.atguigu.srb.core.service;

import com.atguigu.srb.core.pojo.entity.LendItem;
import com.atguigu.srb.core.pojo.entity.LendItemReturn;
import com.atguigu.srb.core.pojo.vo.InvestVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 标的出借记录表 服务类
 * </p>
 *
 * @author cbb
 * @since 2024-06-30
 */
public interface LendItemService extends IService<LendItem> {

    String commitInvest(InvestVO investVO);

    String notify(Map<String, Object> paramMap);

    LendItem getByLendItemNo(String lendItemNo);

    List<LendItem> selectByLendId(Long lendId);

    List<LendItem> selectByLendId(Long lendId, Integer status);
}
