package io.khasang.jrepetitor.service.impl;

import io.khasang.jrepetitor.dao.QuestionDao;
import io.khasang.jrepetitor.dto.QuestionDTOInterface;
import io.khasang.jrepetitor.dto.impl.QuestionDTOImpl;
import io.khasang.jrepetitor.entity.Question;
import io.khasang.jrepetitor.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private QuestionDTOImpl questionDTO;

    @Override
    public Question addQuestion(Question question) {
        return questionDao.create(question);
    }

    @Override
    public List<QuestionDTOInterface> getAllQuestions() {
        return questionDTO.getQuestionDTOList(questionDao.getList());
    }

    @Override
    public QuestionDTOInterface getQuestionById(long id) {
        return new QuestionDTOImpl().getQuestionDTO(questionDao.getById(id));
    }

    @Override
    public QuestionDTOInterface deleteQuestion(long id) {
        Question deletedQuestion = questionDao.delete(questionDao.getById(id));
        return new QuestionDTOImpl().getQuestionDTO(deletedQuestion);
    }
}
