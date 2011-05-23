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
package com.artivisi.security.ui.springmvc.controller;

import com.artivisi.security.service.SpringSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Deny Prasetyo, S.T.
 * Email : jasoet87@gmail.com
 * Date: 4/26/11
 * Time: 12:54 AM
 */
@Controller
public class UserController {

    @Autowired
    private SpringSecurityService billingService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public
    @ResponseBody
    Map<String, Object> getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
                                 @RequestParam(value = "start", defaultValue = "0") int start,
                                 @RequestParam(value = "limit", defaultValue = "0") int limit) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("users", billingService.findUsers());
        result.put("total", billingService.countUsers());
        return result;
    }
}
