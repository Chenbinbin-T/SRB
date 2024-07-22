package com.atguigu.srb.core.service;

import com.atguigu.srb.core.pojo.dto.ExcelDictDTO;
import com.atguigu.srb.core.pojo.entity.Dict;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * 数据字典 服务类
 * </p>
 *
 * @author cbb
 * @since 2024-06-30
 */
public interface DictService extends IService<Dict> {
//    导入Excel数据
    void importData(InputStream inputStream);

//    将数据库中的dict数据转换为ExcelDictDTO类型
    List<ExcelDictDTO> listDictData();

//    通过ParentId展示数据字典
    List<Dict> listByParentId(Long parentId);

    List<Dict> findByDictCode(String dictCode);

    String getNameByParentDictCodeAndValue(String dictCode,Integer value);
}
