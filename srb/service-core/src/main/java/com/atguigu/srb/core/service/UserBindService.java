package com.atguigu.srb.core.service;

import com.atguigu.srb.core.pojo.entity.UserBind;
import com.atguigu.srb.core.pojo.vo.UserBindVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 用户绑定表 服务类
 * </p>
 *
 * @author cbb
 * @since 2024-06-30
 */
public interface UserBindService extends IService<UserBind> {

    String commitBindUser(UserBindVO userBindVO, Long userId);

    void notify(Map<String, Object> paramMap);

    String getBindCodeByUserId(Long userId);
}
