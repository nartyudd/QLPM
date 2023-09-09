/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tcd.repository.impl;

import com.tcd.pojo.Medicine;
import com.tcd.repository.MedicineRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author admin
 */
@Repository
@PropertySource("classpath:configs.properties")
@Transactional
public class MedicineRepositoryImpl implements MedicineRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;
    
    @Override
    public List<Medicine> getMedicine(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Medicine> q = b.createQuery(Medicine.class);
        Root root = q.from(Medicine.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("medicineName"), String.format("%%%s%%", kw)));
            }

            String fromunitPrice = params.get("fromunitPrice");
            if (fromunitPrice != null && !fromunitPrice.isEmpty()) {
                predicates.add(b.greaterThanOrEqualTo(root.get("unitPrice"), Double.parseDouble(fromunitPrice)));
            }

            String tounitPrice = params.get("tounitPrice");
            if (tounitPrice != null && !tounitPrice.isEmpty()) {
                predicates.add(b.lessThanOrEqualTo(root.get("unitPrice"), Double.parseDouble(tounitPrice)));
            }
            q.where(b.and(predicates.toArray(new Predicate[0])));
        }

        q.orderBy(b.desc(root.get("id")));

        Query query = s.createQuery(q);

        if (params != null) {
            String page = params.get("page");
            int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
            if (page != null) {
                query.setFirstResult((Integer.parseInt(page) - 1) * pageSize);
                query.setMaxResults(pageSize);
            }
        }

        return query.getResultList();

    }
    
    @Override
    public int countMedicine() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT COUNT(*) FROM Medicine");

        return Integer.parseInt(q.getSingleResult().toString());
    }
    @Override
    public boolean addOrUpdateMedicine(Medicine p) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (p.getId() == null) {
                s.save(p);
            } else {
                s.update(p);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Medicine getMedicineById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Medicine.class, id);
    }

    public boolean deleteMedicine(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        
        try {
            Medicine p = this.getMedicineById(id);
            s.delete(p);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
