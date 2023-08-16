package ru.testing.domain;


import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Getter
@Table("usr")
public class User implements UserDetails, Persistable<Long> {
    @Id
    private final Long userId;
    private final String username;
    private final String password;
    private final UserRole userRole;
    @MappedCollection(idColumn = "user_key")
    private final Set<Verification> verificationSet;

    @Transient
    private final boolean isNew;

    @PersistenceCreator
    public User(Long userId, String username, String password, UserRole userRole, Set<Verification> verificationSet) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
        this.verificationSet = verificationSet;
        this.isNew = false;
    }

    public User(String username, String password, UserRole userRole, Set<Verification> verificationSet) {
        this.userId = null;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
        this.verificationSet = verificationSet;
        this.isNew = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.userRole.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Long getId() {
        return userId;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }
}
