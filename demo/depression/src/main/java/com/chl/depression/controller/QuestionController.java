package com.chl.depression.controller;

import com.chl.depression.bean.Question;
import com.chl.depression.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    QuestionService questionService;

    /**
     * 通过id获取某一个问题
     * @return
     */
    @GetMapping("/question")
    public Question getQuestionById(@RequestParam("id") int id){
        Question question = questionService.getQuestionById(id);
        return question;
    }

    @GetMapping("/allQuestion")
    public List<Question> getAllQuestion(){
        List<Question> list = questionService.allQuestion();
        return list;
    }
}
