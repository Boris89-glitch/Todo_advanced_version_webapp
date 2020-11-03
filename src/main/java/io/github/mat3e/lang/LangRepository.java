package io.github.mat3e.lang;

import io.github.mat3e.HibernateUtil;

import java.util.List;
import java.util.Optional;

public class LangRepository {
    public Optional<Lang> findById(Integer id){
        var session = HibernateUtil.getSessionFactory().openSession();
        var result = session.get(Lang.class, id);
        var transaction = session.beginTransaction();
        transaction.commit();
        session.close();

        return Optional.ofNullable(result);

        /*return languages
                .stream()
                .filter(l -> l.getId().equals(id))
                .findFirst();*/
    }

    List<Lang> findAll() {
        var session = HibernateUtil.getSessionFactory().openSession();
        var result = session.createQuery("from Lang", Lang.class).list();
        var transaction = session.beginTransaction();
        transaction.commit();
        session.close();

        return result;
    }
}
