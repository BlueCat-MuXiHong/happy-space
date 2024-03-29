package com.bookServer.facade.userModule.entity;

import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
 

import java.util.Date;
 
@Excel("department")
@Data
public class Department {
    @ExcelField(value = "编号", width = 50)
    private Long id;
 
    @ExcelField(value = "部门名称", width = 100)
    private String name;
 
    @ExcelField(value = "联系电话", width = 120)
    private String phone;
 
    @ExcelField(value = "部门地址", width = 150)
    private String address;
 
    @ExcelField(value = "创建时间", dateFormat = "yyyy年MM月dd日 HH:mm:ss", width = 180)
    private Date createTime;
 
    @ExcelField(value = "修改时间", dateFormat = "yyyy年MM月dd日 HH:mm:ss", width = 180)
    private Date modifiedTime;
 
}