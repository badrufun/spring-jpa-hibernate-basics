package in.advertiss.springjpahibernate.repository;

import in.advertiss.springjpahibernate.SpringJpaHibernateApplication;
import in.advertiss.springjpahibernate.entity.Course;
import in.advertiss.springjpahibernate.entity.Review;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private EntityManager eManager;

    @Test
    @Transactional
    public void findById(){
        Course c = courseRepository.findById(10001l);
        logger.info("course finding :: " + c);
        logger.info("reviews for course :: reviews ::" + c.getReviews());
        Review review0 = c.getReviews().get(0);

        Review r = new Review("8", "Awesome book");
        r.setCourse(c);
        eManager.persist(r);
        eManager.flush();


        eManager.refresh(c);
        logger.info("course finding - update review :: " + c);
        logger.info("reviews for course :: reviews  - update review ::" + c.getReviews());


        c.removeReviews(review0);
        eManager.persist(c);
        eManager.flush();

        eManager.refresh(c);
        logger.info("deleted review :: " + review0);
        logger.info("course finding - deleted review :: " + c);
        logger.info("reviews for course :: reviews  - deleted review ::" + c.getReviews());

        //assertEquals("Hibernate", c.getName());
        //fail("Manual failling.");
    }

    @Test
    @DirtiesContext
    public void deleteById(){
        //courseRepository.deleteById(10002l);
        //assertNull(courseRepository.findById(10002l));
    }

    @Test
    @DirtiesContext
    public void saveById(){
        //Course c = courseRepository.save(new Course("Postgres"));
        //assertNull(c);
    }

    @Test
    @DirtiesContext
    public void palyWithEntityManager(){

        //courseRepository.playWithEntityManager();
    }
}