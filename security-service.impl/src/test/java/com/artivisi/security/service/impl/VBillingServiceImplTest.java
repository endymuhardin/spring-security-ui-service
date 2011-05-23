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
package com.artivisi.security.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.artivisi.security.domain.Group;
import com.artivisi.security.domain.Role;
import com.artivisi.security.service.SpringSecurityService;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class VBillingServiceImplTest {
    private static AbstractApplicationContext applicationContext;
    private static SpringSecurityService vBillingService;

    @BeforeClass
    public static void initSpring() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath*:com/artivisi/**/applicationContext.xml");
        applicationContext.registerShutdownHook();

        vBillingService = (SpringSecurityService) applicationContext.getBean("vBillingService");

//		clearDatabase();
    }

    private static void clearDatabase() throws SQLException {
        DataSource ds = (DataSource) applicationContext.getBean("dataSource");
        Connection conn = ds.getConnection();
        conn.createStatement().executeUpdate("truncate users");
        conn.createStatement().executeUpdate("truncate groups_authority");
        conn.createStatement().executeUpdate("truncate groups");
        conn.createStatement().executeUpdate("truncate role");
        conn.close();
    }

    @AfterClass
    public static void destroySpring() {
        applicationContext.destroy();
    }


    @Test
    public void testHello() {
        Role role = new Role("Super Admin");
        vBillingService.save(role);

        Role role2 = new Role("Wakil Admin");
        vBillingService.save(role2);

        Group group = new Group();
        group.setId(1l);
        group.setName("Super Duper ah");
        List<Role> roles = new ArrayList<Role>();
        roles.add(role);
        roles.add(role2);
        group.setRoles(roles);

        vBillingService.save(group);
    }

}
