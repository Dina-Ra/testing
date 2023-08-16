package ru.testing.domain;

import java.util.Set;

public record Test(String text, Set<Answer> answerSet) {
}
