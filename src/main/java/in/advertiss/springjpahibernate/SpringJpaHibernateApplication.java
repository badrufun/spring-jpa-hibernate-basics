package in.advertiss.springjpahibernate;

import in.advertiss.springjpahibernate.entity.Course;
import in.advertiss.springjpahibernate.entity.Passport;
import in.advertiss.springjpahibernate.entity.Student;
import in.advertiss.springjpahibernate.entity.emp.Employee;
import in.advertiss.springjpahibernate.entity.emp.FulltimeEmp;
import in.advertiss.springjpahibernate.entity.emp.ParttimeEmp;
import in.advertiss.springjpahibernate.repository.CourseRepository;
import in.advertiss.springjpahibernate.repository.EmployeeRepository;
import in.advertiss.springjpahibernate.repository.PersonJpaRepository;
import in.advertiss.springjpahibernate.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJpaHibernateApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PersonJpaRepository repository;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private StudentRepository sRepository;
	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJpaHibernateApplication.class, args);
		/*for (String beanName: context.getBeanDefinitionNames()) {
			//System.out.println(beanName);
		}*/
	}


	@Override
	public void run(String... args) throws Exception {
		Employee e = new FulltimeEmp("Umar", "10000");
		Employee e2 = new ParttimeEmp("Rahmat", "100");
		employeeRepository.save(e);
		employeeRepository.save(e2);

		/*sRepository.saveStudentWithPassport(null);
		Student s = new Student("Umar");
		//s.getPassport().setStudent(s);
		sRepository.save(s);*/
	}

	/*@Override
	public void run(String... args) throws Exception {
		Course c = courseRepository.findById(10001l);
		logger.info("Course : " + c);
		c.setName("Updated Java");
		c = courseRepository.save(c);
		logger.info("Updated Course : " + c);

		courseRepository.deleteById(10003l);
		courseRepository.save(new Course("Oracle"));


		*//*logger.info("Person : " + repository.findById(10001));
		List<Person> list = repository.findAll();
		System.out.println(list);*//*
		//List<Person> list = repository.findAll();
		*//*logger.info("Person : " + list);
		logger.info("Person : " + personJdbcDao.findById(10001));
		logger.info("Deleted id 10001 : " + personJdbcDao.deleteById(10001));
		logger.info("Inserted id 10009 : " + personJdbcDao.save(
				new Person(10009, "new name", "new location", new Date())
		));
		logger.info("Fetched id 10009 : " + personJdbcDao.findById(10009));

		logger.info("Update id 10003 : " + personJdbcDao.update(
				new Person(10003, "updated name", "updated location", new Date())
		));
		logger.info("updated id 10003 : " + personJdbcDao.findById(10003));*//*
	}*/

}
