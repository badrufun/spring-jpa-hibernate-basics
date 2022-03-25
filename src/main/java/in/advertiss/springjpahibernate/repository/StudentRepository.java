package in.advertiss.springjpahibernate.repository;

import in.advertiss.springjpahibernate.entity.Passport;
import in.advertiss.springjpahibernate.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
    private EntityManager eManager;

    public Student findById(Long id){
        return eManager.find(Student.class, id);
    }

    public void deleteById(Long id){
        Student c = findById(id);
        eManager.remove(c);
    }

    public Student save(Student student){
        if(student.getId() == 0){
            eManager.persist(student);
        }else{
            eManager.merge(student);
        }
        return student;
    }

    public void saveStudentWithPassport(Student student){
        Passport p = new Passport("R9428894");
        eManager.persist(p);
        Student r = new Student("Rahmat", p);
        eManager.persist(r);
    }
}
