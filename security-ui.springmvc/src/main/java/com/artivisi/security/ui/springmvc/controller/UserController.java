package com.artivisi.security.ui.springmvc.controller;

import com.artivisi.security.service.VBillingService;
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
    private VBillingService billingService;

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
