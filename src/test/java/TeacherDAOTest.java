/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import model.dao.TeacherDAO;
import model.entity.Teacher;
import model.dao.CourseDAO;
import model.entity.Course;
import model.entity.Student;
import model.dao.StudentDAO;

import javax.ejb.EJB;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author albinbecevic
 */
@RunWith(Arquillian.class)
public class TeacherDAOTest{
    @Deployment
    public static WebArchive createDeployment(){
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(TeacherDAO.class, Teacher.class, CourseDAO.class, Course.class, StudentDAO.class, Student.class)
                .addAsResource("META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE,"beans.xml");
    }
    
    @EJB
    private TeacherDAO teacherDao;
    
    @EJB
    private CourseDAO courseDao;
    
    @EJB
    private StudentDAO studentDao;
    /*
    @Before
    public void init(){
        
        studentDao.create(new Student(1, "Billy", "James", "RickJames", "Billy1", "Billy@James"));
        studentDao.create(new Student(2, "Billy", "Flare", "RickFlare", "Billy2", "Billy@Flare"));
        studentDao.create(new Student(3, "Billy", "Jones", "RickJones", "Billy3", "Billy@Jones"));
        
        Course c1 = new Course(1, "Maths");
        Course c2 = new Course(2, "Eng");
        Course c3 = new Course(3, "Bio");
        
        courseDao.create(c1);
        courseDao.create(c2);
        courseDao.create(c3);
        
        Teacher t1 = new Teacher(1, "Rick", "James", "RickJames", "Rick1", "Rick@James");
        Teacher t2 = new Teacher(2, "Rick", "Flare", "RickFlare", "Rick2", "Rick@Flare");
        Teacher t3 = new Teacher(3, "Rick", "Jones", "RickJones", "Rick3", "Rick@Jones");
        
        t1.addCourse(c1);
        t1.addCourse(c2);
        t2.addCourse(c3);
        
        
        teacherDao.create(t1);
        teacherDao.create(t2);
        teacherDao.create(t3);
        
        
        
        
        
        teacherDao.create(new Teacher(1, "Rick", "James", "RickJames", "Rick1", "Rick@James"));
        teacherDao.create(new Teacher(2, "Rick", "Flare", "RickFlare", "Rick2", "Rick@Flare"));
        teacherDao.create(new Teacher(3, "Rick", "Jones", "RickJones", "Rick3", "Rick@Jones"));
        
    }
    
    
    @Test
    public void checkThatFindCarsMatchingNameMatchesCorrectly() {
        Assert.assertTrue(true);        
    }*/
}
