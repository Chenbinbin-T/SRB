package com.atguigu.srb.core;

import com.alibaba.excel.EasyExcel;
import com.atguigu.srb.core.pojo.dto.ExcelDictDTO;
import com.atguigu.srb.core.pojo.entity.Dict;
import com.atguigu.srb.core.pojo.entity.IntegralGrade;
import com.atguigu.srb.core.service.DictService;
import com.atguigu.srb.core.service.IntegralGradeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ExcelWriteTest {
    @Resource
    private DictService dictService;

    @Resource
    private IntegralGradeService integralGradeService;

    private List<ExcelDictDTO> DictData() {
        List<ExcelDictDTO> list = new ArrayList<ExcelDictDTO>();
        List<Dict> dicts = dictService.list();
        for (Dict d : dicts) {
            ExcelDictDTO dictDTO = new ExcelDictDTO();
            dictDTO.setId(d.getId());
            dictDTO.setParentId(d.getParentId());
            dictDTO.setName(d.getName());
            dictDTO.setValue(d.getValue());
            dictDTO.setDictCode(d.getDictCode());
            list.add(dictDTO);
        }

        return list;
    }

    @Test
    public void test() {
        List<IntegralGrade> list = integralGradeService.list();
        for (IntegralGrade d : list) {
            System.out.println(d);
        }
    }

    @Test
    public void simpleWriteDictDataXlsx() {
        String fileName = "D:/JAVA Program/srb-project/test_output/DictData.xlsx"; //需要提前新建目录
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, ExcelDictDTO.class).sheet("sheet1").doWrite(DictData());
    }
}
