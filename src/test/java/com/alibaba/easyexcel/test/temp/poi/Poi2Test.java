package com.alibaba.easyexcel.test.temp.poi;

import java.io.File;
import java.io.IOException;

import customize.org.apache.poi.xssf.streaming.SXSSFRow;
import customize.org.apache.poi.xssf.streaming.SXSSFSheet;
import customize.org.apache.poi.xssf.streaming.SXSSFWorkbook;
import customize.org.apache.poi.xssf.usermodel.XSSFRow;
import customize.org.apache.poi.xssf.usermodel.XSSFSheet;
import customize.org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Ignore;
import org.junit.Test;
import customize.org.slf4j.Logger;
import customize.org.slf4j.LoggerFactory;

import com.alibaba.easyexcel.test.util.TestFileUtil;

/**
 * 测试poi
 *
 * @author Jiaju Zhuang
 **/
@Ignore
public class Poi2Test {
    private static final Logger LOGGER = LoggerFactory.getLogger(Poi2Test.class);

    @Test
    public void test() throws IOException {
        String file = "D:\\test\\珠海.xlsx";
        SXSSFWorkbook xssfWorkbook = new SXSSFWorkbook(new XSSFWorkbook(file));
        SXSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
        LOGGER.info("一共行数:{}", xssfSheet.getLastRowNum());
        SXSSFRow row = xssfSheet.getRow(0);
        LOGGER.info("第一行数据:{}", row);
    }

    @Test
    public void lastRowNumXSSF() throws IOException {
        String file = "D:\\test\\珠海.xlsx";
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(file);
        LOGGER.info("一共:{}个sheet", xssfWorkbook.getNumberOfSheets());
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
        LOGGER.info("一共行数:{}", xssfSheet.getLastRowNum());
        XSSFRow row = xssfSheet.getRow(0);
        LOGGER.info("第一行数据:{}", row);
        xssfSheet.createRow(20);
        LOGGER.info("一共行数:{}", xssfSheet.getLastRowNum());
    }
}
