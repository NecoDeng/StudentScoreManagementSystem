/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssms.dal.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import ssms.dal.DBUtil;
import ssms.dal.dao.UserDao;
import ssms.entity.User;


/**
 *
 * @author apple
 */
public class UserDaoImpl implements UserDao
{

    @Override
    public boolean addUser(User user) {
        String insert="insert into user(account,password, username) values('"+user.getAccount()+"','"+user.getPassword()+"','"+user.getUserName()+"')";
        System.out.println(insert);
        try {
            DBUtil.runUpdate(insert);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean certifyUser(String account, String password) {
        String select="select * from user where account='"+ account +"' and password='"+password+"'";
        boolean isCertifyUser=false;
        try {
            ResultSet rs=DBUtil.runQuery(select);
            if(rs!=null)
            {
                 isCertifyUser=rs.next();
                 DBUtil.realeaseAll();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isCertifyUser;
    }
    
}
