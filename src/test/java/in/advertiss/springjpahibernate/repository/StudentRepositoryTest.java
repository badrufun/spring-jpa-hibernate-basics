package in.advertiss.springjpahibernate.repository;

import in.advertiss.springjpahibernate.SpringJpaHibernateApplication;
import in.advertiss.springjpahibernate.entity.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest
class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EntityManager eManager;

    @Test
    @Transactional
    public void findById(){
        Student s = eManager.find(Student.class, 20002l);
        logger.info("student -> {}", s);
        logger.info("passport -> {}", s.getPassport());
    }
}