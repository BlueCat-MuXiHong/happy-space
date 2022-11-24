package com.bookServer.controller;


import com.bookServer.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("startTask")
public class StartTaskController {
    @Autowired
    private Task task;

    @GetMapping("bookInfoTask")
    public void bookInfoTask() throws Exception {
        task.bookInfoTask();
    }


    @GetMapping("bookChapterTask")
    public void bookChapterTask() throws Exception {
        task.bookChapterTask();
    }

    @GetMapping("bookContentTask")
    public void bookContentTask() throws Exception {
        task.insertEsBookContent();
    }



}
