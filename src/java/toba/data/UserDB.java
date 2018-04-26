/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toba.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import toba.business.User;

public class UserDB {
    public static void insertUser(User user) {
        EntityManager manager = DBUtil.getFactory().createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        try {
            manager.persist(user);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
            transaction.rollback();
        } finally {
            manager.close();
        }        
    }
}
