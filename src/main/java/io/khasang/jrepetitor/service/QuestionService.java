package io.khasang.jrepetitor.service;

import io.khasang.jrepetitor.dto.QuestionDTOInterface;
import io.khasang.jrepetitor.entity.Question;

import java.util.List;

public interface QuestionService {
    /**
     * method for add Question
     *
     * @param Question = new Question for creation in DB
     * @return created Question
     */
    Question addQuestion(Question Question);

    /**
     * method for receiving all Questions
     *
     * @return all Questions
     */
    List<QuestionDTOInterface> getAllQuestions();

    /**
     * method for receive specify Question by id
     *
     * @param id = uniq Question id
     * @return specify Question by id
     */
    QuestionDTOInterface getQuestionById(long id);

    /**
     * method for Question delete
     *
     * @param id = Question's id for delete
     * @return removed Question
     */
    QuestionDTOInterface deleteQuestion(long id);
}
