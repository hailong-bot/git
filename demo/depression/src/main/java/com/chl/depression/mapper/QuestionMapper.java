package com.chl.depression.mapper;

import com.chl.depression.bean.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {
    @Select(value = "SELECT * FROM questions WHERE id = #{id}")
    public Question getQuestionById(long id);

    @Select(value = "SELECT * FROM questions")
    public List<Question> allQuestion();
}
