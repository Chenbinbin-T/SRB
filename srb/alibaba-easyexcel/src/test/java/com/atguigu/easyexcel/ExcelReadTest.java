package com.atguigu.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.atguigu.easyexcel.dto.ExcelStudentDTO;
import com.atguigu.easyexcel.listener.ExcelStudentDTOListener;
import org.junit.Test;

public class ExcelReadTest {

    /**
     * 最简单的读，比EasyExcel.write多传了一个监听器
     */
    @Test
    public void simpleReadXlsx() {
        String fileName = "D:/JAVA Program/srb-project/test_output/simpleWrite.xlsx";
        // 这里默认读取第一个sheet
        EasyExcel.read(fileName, ExcelStudentDTO.class, new ExcelStudentDTOListener()).sheet().doRead();
    }

    @Test
    public void simpleReadXls() {
        String fileName = "D:/JAVA Program/srb-project/test_output/simpleWrite.xls";
        EasyExcel.read(fileName, ExcelStudentDTO.class, new ExcelStudentDTOListener()).excelType(ExcelTypeEnum.XLS).sheet().doRead();
    }
}
