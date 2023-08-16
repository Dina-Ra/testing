package ru.testing.dto;

import ru.testing.domain.Answer;

import java.util.Set;

public record TestDto(String text, Set<Answer> answerSet) {
}
