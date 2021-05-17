package com.chl.depression.service.impl;

import com.chl.depression.bean.Question;
import com.chl.depression.mapper.QuestionMapper;
import com.chl.depression.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Resource
    QuestionMapper questionMapper;

    @Override
    public Question getQuestionById(long id) {
       return questionMapper.getQuestionById(id);
    }

    @Override
    public List<Question> allQuestion() {
        return questionMapper.allQuestion();
    }
}
