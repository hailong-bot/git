package com.chl.depression.service;


import com.chl.depression.bean.Question;

import java.util.List;

public interface QuestionService {
    public Question getQuestionById(long id);
    public List<Question> allQuestion();
}
