package ru.testing.domain;

import java.time.LocalDate;

public record Verification(Integer result, LocalDate createDate, String subjectName) {
}
