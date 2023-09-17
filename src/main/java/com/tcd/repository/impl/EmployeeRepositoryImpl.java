/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tcd.repository.impl;

import com.tcd.pojo.Employees;
import com.tcd.repository.EmployeeRepository;
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
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;
    
    @Override
    public List<Employees> getEmployee(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Employees> q = b.createQuery(Employees.class);
        Root root = q.from(Employees.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("tennhanvien"), String.format("%%%s%%", kw)));
            }

            String fromvitricongviec = params.get("vitricongviec");
            if (fromvitricongviec != null && !fromvitricongviec.isEmpty()) {
                predicates.add(b.greaterThanOrEqualTo(root.get("vitricongviec"), Double.parseDouble(fromvitricongviec)));
            }

            String torole = params.get("role");
            if (torole != null && !torole.isEmpty()) {
                predicates.add(b.lessThanOrEqualTo(root.get("role"), Double.parseDouble(torole)));
            }
            q.where(b.and(predicates.toArray(new Predicate[0])));
        }

        q.orderBy(b.desc(root.get("employeesId")));

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
    public int countEmployee() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT COUNT(*) FROM Medicine");

        return Integer.parseInt(q.getSingleResult().toString());
    }
    @Override
    public boolean addOrUpdateEmployee(Employees e) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (e.getEmployeesId() == null) {
                s.save(e);
            } else {
                s.update(e);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Employees getEmployeeById(int employeesId) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Employees.class, employeesId);
    }

    public boolean deleteEmployee(int employeesId) {
        Session s = this.factory.getObject().getCurrentSession();
        
        try {
            Employees e = this.getEmployeeById(employeesId);
            s.delete(e);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
