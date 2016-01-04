/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnt.dao;

import com.rnt.model.Employee;
import com.rnt.model.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nuno
 */

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao{

    public User findById(int id) {
        return getByKey(id);
    }

    public void saveUser(User user) {
        persist(user);
    }

    public void deleteUserByNif(long nif) {
        Query query = getSession().createSQLQuery("delete from User where user_nif = :nif");
	query.setString("nif", Long.toString(nif));
        query.executeUpdate();
    }

    public List<User> findAllUsers() {
        Criteria criteria = createEntityCriteria();
        return (List<User>) criteria.list();
    }

    public User findUserByNif(long nif) {
        Criteria criteria = createEntityCriteria();
	criteria.add(Restrictions.eq("user_nif", Long.toString(nif)));
	return (User) criteria.uniqueResult();
    }

    public List<User> fingUserByName(String name) {
        Criteria criteria = createEntityCriteria();
	criteria.add(Restrictions.eq("user_name", name));
        return (List<User>) criteria.list();
    }
    
    
    
}
