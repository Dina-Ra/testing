package ru.testing.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table("answer")
public class Answer {
    @Id
    private final Long answerId;
    private final String text;
    private final Integer point;
    private final boolean isTrue;
    private final Long testKey;

    @PersistenceCreator
    public Answer(Long answerId, String text, Integer point, boolean isTrue, Long testKey) {
        this.answerId = answerId;
        this.text = text;
        this.point = point;
        this.isTrue = isTrue;
        this.testKey = testKey;
    }
}
