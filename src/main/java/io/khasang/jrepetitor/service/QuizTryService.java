package io.khasang.jrepetitor.service;

import io.khasang.jrepetitor.dto.QuizTryDTOInterface;
import io.khasang.jrepetitor.model.UserTryWrapper;

import java.util.List;

public interface QuizTryService {

    QuizTryDTOInterface createTry(UserTryWrapper userTryWrapper, String userLogin);

    List<QuizTryDTOInterface> getAll();

    QuizTryDTOInterface getById(Long Id);

    QuizTryDTOInterface deleteById(long l);
}
