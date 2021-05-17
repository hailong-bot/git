package com.chl.depression.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Question {
    long id;
    String question;
    String main;
    String one;
    String two;
    String three;
    String four;
    String five;
}
