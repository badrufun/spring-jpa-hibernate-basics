package in.advertiss.springjpahibernate.repository;

import in.advertiss.springjpahibernate.entity.Course;
import in.advertiss.springjpahibernate.entity.Passport;
import in.advertiss.springjpahibernate.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    private EntityManager eManager;

    public Course findById(Long id){
        return eManager.find(Course.class, id);
    }

    public void deleteById(Long id){
        Course c = findById(id);
        eManager.remove(c);
    }

    public Course save(Course course){
        if(course.getId() == null){
            eManager.persist(course);
        }else{
            eManager.merge(course);
        }
        return course;
    }

    public void playWithEntityManager(){
        Course course = new Course("Entity Manager");
        eManager.persist(course);
        course.setName("Entity Manager - Updated");
    }
}
