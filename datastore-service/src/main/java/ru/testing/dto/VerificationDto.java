package ru.testing.dto;

import java.time.LocalDate;

public record VerificationDto(Integer result, LocalDate createDate) {
}
