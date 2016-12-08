/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedme.dao;

import com.feedme.dto.ManagerDTO;
import com.feedme.entities.Manager;
import com.feedme.info.Information;
import com.feedme.utils.Encrypt;
import com.feedme.utils.Json;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Giang
 */
public class ManagerDAO {

    private EntityManager em;
    private EntityTransaction trans;

    public ManagerDAO() {
        em = Persistence.createEntityManagerFactory("FeedMe-WSPU").createEntityManager();
        trans = em.getTransaction();
    }

    public boolean add(ManagerDTO m) {
        try {
            Information inf = Json.DeserializeObject(m.getInfo(), Information.class);
            inf.put("_lastChanged", new Date().getTime() + "");
            m.setInfo(Json.SerializeObject(inf));
        } catch (Exception ex) {
        }
        m.setPassword(Encrypt.hash("8ja374Z0B5sHYud" + m.getPassword() + "0j4212kE8CQhoPR"));
        trans.begin();
        em.persist(m.getManager());
        trans.commit();
        return true;
    }

    public boolean update(ManagerDTO manager) {
        Manager m = manager.getManager();
        Manager find = em.find(Manager.class, m.getId());
        if (find == null) {
            return false;
        }
        trans.begin();
        try {
            find.setInfo(m.getInfo());
            find.setPriviledge(m.getPriviledge());
            find.setUsername(m.getUsername());
            trans.commit();
            return true;
        } catch (Exception ex) {
            trans.rollback();
            return false;
        }
    }

    public boolean updatePassword(ManagerDTO manager) {
        Manager m = manager.getManager();
        try {
            Information inf = Json.DeserializeObject(m.getInfo(), Information.class);
            inf.put("_lastChanged", new Date().getTime() + "");
            m.setInfo(Json.SerializeObject(inf));
        } catch (Exception ex) {
        }
        Manager find = em.find(Manager.class, m.getId());
        if (find == null) {
            return false;
        }
        trans.begin();
        try {
            find.setPassword(Encrypt.hash("8ja374Z0B5sHYud" + m.getPassword() + "0j4212kE8CQhoPR"));
            m = manager.getManager();
            find.setInfo(m.getInfo());
            trans.commit();
            return true;
        } catch (Exception ex) {
            trans.rollback();
            return false;
        }
    }

    public boolean remove(short id) {
        Manager find = em.find(Manager.class, id);
        if (find == null) {
            return false;
        }
        trans.begin();
        em.remove(find);
        trans.commit();
        return true;
    }

    public List<ManagerDTO> getAll() {
        List<ManagerDTO> list = new ArrayList<>();
        List<Manager> resultList = em.createNamedQuery("Manager.findAll").getResultList();
        for (Manager m : resultList) {
            list.add(new ManagerDTO(m));
        }
        return list;
    }

    public ManagerDTO getById(short id) {
        Manager find = em.find(Manager.class, id);
        if (find == null) {
            return null;
        }
        return new ManagerDTO(find);
    }

    public ManagerDTO getLogin(String user, String pass) {
        List<Manager> resultList = em.createNamedQuery("Manager.login")
                .setParameter("username", user)
                .setParameter("password", pass).getResultList();
        if (resultList.size() > 0) {
            return new ManagerDTO(resultList.get(0));
        }
        return null;
    }
}
