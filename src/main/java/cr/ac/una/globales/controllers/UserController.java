/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.globales.controllers;

import cr.ac.una.globales.database.dao.UserDao;
import cr.ac.una.globales.database.entity.Category;
import cr.ac.una.globales.database.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rody
 */
@RestController
public class UserController {
    
    @Autowired
    private UserDao userDao;

    @RequestMapping(method = GET, path = "/user/list")
    @ResponseBody
    public List<User> getList() {
        Iterable<User> list = null;
        try {
            list = userDao.findAll();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(list);
        return (List<User>) list;
    }
}
