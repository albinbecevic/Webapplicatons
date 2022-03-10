/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import model.dao.TeacherFileDAO;
import model.entity.TeacherFile;
import model.dao.CourseModuleDAO;
import model.entity.CourseModule;
import model.dao.StudentDAO;
import model.entity.Student;
import model.dao.TeacherDAO;
import model.entity.Teacher;
import model.dao.CourseDAO;
import model.entity.Course;


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
public class TeacherFileDAOTest {
    @Deployment
    public static WebArchive createDeployment(){
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(TeacherFileDAO.class, TeacherFile.class, CourseModuleDAO.class, CourseModule.class, StudentDAO.class, Student.class, Teacher.class, TeacherDAO.class, CourseDAO.class, Course.class)
                .addAsResource("META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE,"beans.xml");
    }
    
    @EJB
    private TeacherFileDAO teacherFileDao;
    
    @EJB
    private CourseModuleDAO courseModuleDao;
    
    @EJB
    private StudentDAO studentDao;
    
    @EJB
    private CourseDAO courseDao;
    
    @EJB
    private TeacherDAO teacherDao;
    
    /*
    @Before
    public void init(){
        Student s1 = new Student(1, "Billy", "James", "BillyJames", "Billy1", "Billy@James");
        studentDao.create(s1);
        
        Teacher t1 = new Teacher(1, "Rick", "James", "RickJames", "Rick1", "Rick@James");
        teacherDao.create(t1);
        
        Course c1 = new Course(1, "Maths");
        courseDao.create(c1);
        
        CourseModule cm1 = new CourseModule(1, 1, "Algorithms", "1,2,3", null);
        courseModuleDao.create(cm1);
        
        TeacherFile tf1 = new TeacherFile(1, "Math quiz", "Bunch of questions", 1);
        teacherFileDao.create(tf1);
        
        
        Student s1 = new Student(1, "Billy", "James", "BillyJames", "Billy1", "Billy@James");
        Student s2 = new Student(2, "Billy", "Flare", "BillyFlare", "Billy2", "Billy@Flare");
        Student s3 = new Student(3, "Billy", "Jones", "BillyJones", "Billy3", "Billy@Jones");       
        
        Course c1 = new Course(1, "Maths");
        Course c2 = new Course(2, "Eng");
        Course c3 = new Course(3, "Bio");
        
        s1.addCourse(c1);
        s2.addCourse(c2);
        s3.addCourse(c3);
        s3.addCourse(c1);
        
        
        c1.addStudent(s1);
        c2.addStudent(s2);
        c3.addStudent(s3);
        c1.addStudent(s3);
        
        studentDao.create(s1);
        studentDao.create(s2);
        studentDao.create(s3);

        courseDao.create(c1);
        courseDao.create(c2);
        courseDao.create(c3);
        
        
        Module m1 = new Module(1, 1, "lecture1", "exercises 1");
        Module m2 = new Module(2, 1, "lecture1", "exercises 1");
        Module m3 = new Module(3, 1, "lecture1", "exercises 1");   
        
        TeacherFile tf1 = new TeacherFile(1, "Math exam", "Just a bunch of text", 1, 1);
        TeacherFile tf2 = new TeacherFile(2, "Eng exam", "Bunch of text", 2, 2);
        TeacherFile tf3 = new TeacherFile(3, "Bio exam", "Bunch of text", 3, 3);
        TeacherFile tf4 = new TeacherFile(4, "Math exam2", "Bunch of text", 4, 4);
        
        m1.addTeacherFile(tf1);
        m1.addTeacherFile(tf4);
        m2.addTeacherFile(tf2);
        m3.addTeacherFile(tf3); 
        
        moduleDao.create(m1);
        moduleDao.create(m2);
        moduleDao.create(m3);
        
        teacherFileDao.create(tf1);
        teacherFileDao.create(tf2);
        teacherFileDao.create(tf3);
        teacherFileDao.create(tf4);
        
        c1.addModule(m1);
        c2.addModule(m2);
        c3.addModule(m3);
        
        Teacher t1 = new Teacher(1, "Rick", "James", "RickJames", "Rick1", "Rick@James");
        Teacher t2 = new Teacher(2, "Rick", "Flare", "RickFlare", "Rick2", "Rick@Flare");
        Teacher t3 = new Teacher(3, "Rick", "Jones", "RickJones", "Rick3", "Rick@Jones");
        
        t1.addCourse(c1);
        t1.addCourse(c2);
        t2.addCourse(c3);
        
        courseDao.create(c1);
        courseDao.create(c2);
        courseDao.create(c3);
              
        teacherDao.create(t1);
        teacherDao.create(t2);
        teacherDao.create(t3);                      
    }
    
    @Test
    public void checkaddModule() {
         TeacherFile tf1 = teacherFileDao.find(1);
         CourseModule cm1 = courseModuleDao.find(1);
         
         teacherFileDao.addCourseModule(tf1, cm1);
         
         Assert.assertTrue(tf1.getCourseModules().contains(cm1));
         Assert.assertFalse(cm1.getTeacherFiles() == null);
         Assert.assertTrue(cm1.getTeacherFiles().contains(tf1));
         Assert.assertTrue(cm1.getTeacherFiles().get(0).equals(tf1));
    }*/
}
