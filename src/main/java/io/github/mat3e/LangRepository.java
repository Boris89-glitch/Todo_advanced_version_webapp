package io.github.mat3e;

import java.util.Optional;

class LangRepository {
    Optional<Lang> findById(Integer id){
        var session = HibernateUtil.getSessionFactory().openSession();
        var result = session.get(Lang.class, id);
        return Optional.ofNullable(result);

        /*return languages
                .stream()
                .filter(l -> l.getId().equals(id))
                .findFirst();*/
    }
}
