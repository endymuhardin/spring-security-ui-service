package com.artivisi.security.domain;

import org.hibernate.annotations.Index;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Author : Deny Prasetyo S.T.
 * E-mail : jasoet87@gmail.com
 */
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
@Cacheable(value = false)
public class User implements Serializable {
/*------------------------------ Fields ------------------------------*/

    @Id
    @GeneratedValue
    @Column(name = "users_id")
    private Long id;

    @Column(nullable = false, length = 50, name = "username")
    @Size(max = 50, min = 1)
    @Index(name = "users_username_idx")
    private String username;

    @Column(nullable = false, length = 150)
    @Size(max = 150, min = 1)
    private String password;

    @Column(nullable = false)
    private boolean enabled;


    @Column(length = 50)
    private String salt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_", nullable = true)
    private Group group;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    /* --------------------- Getter and Setter ---------------------*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
