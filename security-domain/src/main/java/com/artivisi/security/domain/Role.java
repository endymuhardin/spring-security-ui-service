/**
 * Copyright (C) 2011 Deny Prasetyo <jasoet87@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.artivisi.security.domain;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Author : Deny Prasetyo S.T.
 * E-mail : jasoet87@gmail.com
 */

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority, Serializable {
/*------------------------------ Fields ------------------------------*/

    @Id
    @Column(length = 20, name = "authority")
    @Size(max = 20, min = 1)
    private String authority;

/* --------------------------- Constructor ---------------------------*/

    public Role() {
    }

    public Role(String authority) {
        this.authority = authority;
    }

/* --------------------- Getter and Setter ---------------------*/

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

/* ------------------------ Canonical Methods ------------------------*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (authority != null ? !authority.equals(role.authority) : role.authority != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return authority != null ? authority.hashCode() : 0;
    }

/* -------------------------- Other Methods -------------------------- */

    public int compareTo(Object o) {
        return authority.compareTo((String) o);
    }
}
