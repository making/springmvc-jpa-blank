package com.example.mvc.repository.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.query.QueryUtils;

import com.example.mvc.entity.Person;
import com.example.mvc.repository.custom.PersonRepositoryCustom;

public class PersonRepositoryImpl implements PersonRepositoryCustom {
    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public Page<Person> findByNameLike(String name, Pageable pageable) {
        // Pageで返すと複雑になる。。
        TypedQuery<Person> query = getQuery(name, pageable);
        query.setFirstResult(pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());
        Long total = getCountQuery(name).getSingleResult();
        return new PageImpl<Person>(query.getResultList(), pageable, total);
    }

    protected TypedQuery<Person> getQuery(String name, Pageable pageable) {
        // JPQLで書いた方が良かった。。
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery = cb.createQuery(Person.class);
        Root<Person> root = criteriaQuery.from(Person.class);
        criteriaQuery.select(root);
        criteriaQuery
                .orderBy(QueryUtils.toOrders(pageable.getSort(), root, cb));
        this.<Person> whereLike(criteriaQuery, cb, root, name);
        TypedQuery<Person> query = entityManager.createQuery(criteriaQuery);
        return query;
    }

    protected TypedQuery<Long> getCountQuery(String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = cb.createQuery(Long.class);
        Root<Person> root = criteriaQuery.from(Person.class);
        criteriaQuery.select(cb.count(root));
        this.<Long> whereLike(criteriaQuery, cb, root, name);
        TypedQuery<Long> query = entityManager.createQuery(criteriaQuery);
        return query;
    }

    protected <T> CriteriaQuery<T> whereLike(CriteriaQuery<T> criteriaQuery,
            CriteriaBuilder cb, Root<Person> root, String name) {
        Expression<String> expr = root.get("name");
        Predicate condition = cb.like(expr, cb.literal("%" + name + "%"));
        criteriaQuery.where(condition);
        return criteriaQuery;
    }
}
