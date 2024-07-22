package com.atguigu.easyexcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.atguigu.easyexcel.dto.ExcelStudentDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExcelStudentDTOListener extends AnalysisEventListener<ExcelStudentDTO> {
    /**
     * 监听读取的Excel文件的每一行
     * @param data
     * @param context
     */
    @Override
    public void invoke(ExcelStudentDTO data, AnalysisContext context) {
        log.info("解析到一条数据记录：{}",data);
        // 调用mapper层的save方法
    }

    /**
     * 读取完所有行后的收尾工作
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("所有数据解析完成");
    }
}
