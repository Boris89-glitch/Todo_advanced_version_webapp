package io.github.mat3e.Todo;

import io.github.mat3e.HibernateUtil;

import java.util.List;

public class TodoRepository {

    List<Todo> findAll() {
        var session = HibernateUtil.getSessionFactory().openSession();
        var result = session.createQuery("from Todo", Todo.class).list();
        var transaction = session.beginTransaction();
        transaction.commit();
        session.close();

        return result;
    }
}
