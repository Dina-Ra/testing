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
@Table("subject")
public class Subject implements Persistable<Long> {
    @Id
    private final Long subjectId;
    private final String name;
    @MappedCollection(idColumn = "subject_key")
    private final Set<Test> testSet;

    @Transient
    private final boolean isNew;

    @PersistenceCreator
    public Subject(Long subjectId, String name, Set<Test> testSet) {
        this.subjectId = subjectId;
        this.name = name;
        this.testSet = testSet;
        this.isNew = false;
    }

    public Subject(String name, Set<Test> testSet) {
        this.subjectId = null;
        this.name = name;
        this.testSet = testSet;
        this.isNew = true;
    }

    @Override
    public Long getId() {
        return subjectId;
    }
}
