package ru.testing.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;


@Getter
@Table("test")
public class Verification implements Persistable<Long> {
    @Id
    private final Long verificationId;
    private final Integer result;
    private final Long userKey;
    private final LocalDate createDate;

    @Transient
    private final boolean isNew;

    @PersistenceCreator
    public Verification(Long verificationId, Integer result, Long userKey, LocalDate createDate) {
        this.verificationId = verificationId;
        this.result = result;
        this.userKey = userKey;
        this.createDate = createDate;
        this.isNew = false;
    }

    public Verification(Integer result, Long userKey) {
        this.verificationId = null;
        this.result = result;
        this.userKey = userKey;
        this.createDate = LocalDate.now();
        this.isNew = true;
    }

    @Override
    public Long getId() {
        return verificationId;
    }
}
