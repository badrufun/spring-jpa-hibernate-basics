package in.advertiss.springjpahibernate.repository;

import in.advertiss.springjpahibernate.entity.emp.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class EmployeeRepository {

    @Autowired
    private EntityManager eManager;

    public Employee save(Employee e){
        if (e != null && e.getId()==0){
            eManager.persist(e);
        }else {
            eManager.merge(e);
        }
        return e;
    }
}
