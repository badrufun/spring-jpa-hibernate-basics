package in.advertiss.springjpahibernate.repository;

import in.advertiss.springjpahibernate.dao.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {

    @PersistenceContext
    private EntityManager manager;

    public Person findById(long id){
        return manager.find(Person.class, id);
    }

    public List<Person> findAll(){
        TypedQuery<Person> q = manager.createNamedQuery("find_all_person", Person.class);
        return q.getResultList();
    }

    public void deleteById(int id){
        Person p = findById(id);
        manager.remove(p);
    }

    public Person save(Person person){
        return manager.merge(person);
    }

    public Person update(Person person){
        return manager.merge(person);
    }
}
