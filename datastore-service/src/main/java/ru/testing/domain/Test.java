package ru.testing.domain;


import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Getter
@Table("test")
public class Test implements Persistable<Long> {
    @Id
    private final Long testId;
    private final String text;
    private final Long subjectKey;
    @MappedCollection(idColumn = "test_key")
    private final Set<Answer> answers;

    @Transient
    private final boolean isNew;

    @PersistenceCreator
    public Test(Long testId, String text, Long subjectKey, Set<Answer> answers) {
        this.testId = testId;
        this.text = text;
        this.subjectKey = subjectKey;
        this.answers = answers;
        this.isNew = false;
    }

    public Test(String text, Long subjectKey, Set<Answer> answers) {
        this.testId = null;
        this.text = text;
        this.subjectKey = subjectKey;
        this.answers = answers;
        this.isNew = true;
    }

    @Override
    public Long getId() {
        return testId;
    }
}
