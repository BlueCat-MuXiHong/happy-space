package com.bookServer.facade.bookType.service;


import com.bookServer.facade.bookType.Mapper.BookTypeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookTypeService {


    @Resource
    private BookTypeMapper bookTypeMapper;

    /**
     * 更具图书类型id获取类型名
     * @param id
     * @return
     */
    public String getBookTypeById(Integer id){
        return bookTypeMapper.getBookTypeById(id);
    }



}
