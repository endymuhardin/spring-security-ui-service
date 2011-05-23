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
package com.artivisi.security.service;

import com.artivisi.security.domain.Group;
import com.artivisi.security.domain.Role;
import com.artivisi.security.domain.User;

import java.util.List;

public interface SpringSecurityService {

    public void save(Role role);

    public void delete(Role role);

    public Role findRole(String authority);

    public List<Role> findRoles();

    public Long countRoles();

    /*=================================================*/
    public void save(Group group);

    public void delete(Group group);

    public Group findGroup(Long id);

    public List<Group> findGroups();

    public Long countGroups();

    public List<Group> findGroupsByName(String name);

    public Long countGroupsByName(String name);


    /*=================================================*/
    public void save(User user);

    public void delete(User user);

    public User findUser(Long id);

    public List<User> findUsers();

    public Long countUsers();

    public List<User> findUsersByUsername(String username);

    public Long countUsersByUsername(String username);


}
