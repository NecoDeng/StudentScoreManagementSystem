/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssms.dal.dao;

import ssms.entity.User;


/**
 *
 * @author apple
 */
public interface UserDao 
{
    public boolean addUser(User user);
    public boolean update(User user);
    public boolean certifyUser(String account,String password);
}
