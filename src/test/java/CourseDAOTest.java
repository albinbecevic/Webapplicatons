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
import model.entity.CourseModule;
import model.dao.CourseModuleDAO;
import model.entity.TeacherFile;
import model.dao.TeacherFileDAO;

import javax.ejb.EJB;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author albinbecevic
 */

@RunWith(Arquillian.class)
public class CourseDAOTest {
    @Deployment
    public static WebArchive createDeployment(){
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(TeacherDAO.class, Teacher.class, CourseDAO.class, Course.class, StudentDAO.class, Student.class, CourseModuleDAO.class, CourseModule.class, TeacherFileDAO.class, TeacherFile.class)
                .addAsResource("META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE,"beans.xml");
    }
    
    @EJB
    private TeacherDAO teacherDao;
    
    @EJB
    private CourseDAO courseDao;
    
    @EJB
    private StudentDAO studentDao;
    
    @EJB
    private CourseModuleDAO courseModuleDao;
    
    @EJB
    private TeacherFileDAO teacherFileDao;
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
        studentDao.create(s1);
        
        Teacher t1 = new Teacher(1, "Rick", "James", "RickJames", "Rick1", "Rick@James");
        teacherDao.create(t1);
        
        Course c1 = new Course(2, "Maths");
        courseDao.create(c1);
        t1.addCourse(c1);
        CourseModule cm1 = new CourseModule(1, 1, "Algorithms", "1,2,3", c1);
        courseModuleDao.create(cm1);
        TeacherFile tf1 = new TeacherFile(1, "Math quiz", "Bunch of questions", 1);
        teacherFileDao.create(tf1);
        cm1.addTeacherFile(tf1);
        tf1.addModule(cm1);
        c1.addModule(cm1);
        c1.addStudent(s1);
        s1.addCourse(c1);
        
        
        Student s1 = new Student(1, "Billy", "James", "BillyJames", "Billy1", "Billy@James");
        studentDao.create(s1);
        Teacher t1 = new Teacher(1, "Rick", "James", "RickJames", "Rick1", "Rick@James");
        teacherDao.create(t1);
        Course c1 = new Course(1, "Maths");
        TeacherFile tf1 = new TeacherFile(1, "Math quiz", "Bunch of questions", 1);
        teacherFileDao.create(tf1);
        //CourseModule cm1 = new CourseModule(1, 1, "Algorithms", "1,2,3");
        //c1.addModule(cm1);
        courseDao.create(c1);
        //courseModuleDao.create(cm1);
        courseModuleDao.create(new CourseModule(1, 1, "Algorithms", "1,2,3", null, null));
        
        
        
        
        
        
        
        Student s1 = new Student(1, "Billy", "James", "BillyJames", "Billy1", "Billy@James");
        Student s2 = new Student(2, "Billy", "Flare", "BillyFlare", "Billy2", "Billy@Flare");
        Student s3 = new Student(3, "Billy", "Jones", "BillyJones", "Billy3", "Billy@Jones");       
        
        Course c1 = new Course(1, "Maths");
        Course c2 = new Course(2, "Eng");
        Course c3 = new Course(3, "Bio");
        
        
        
        CourseModule cm1 = new CourseModule(1, 1, "Algorithms", "1,2,3", c1);
        TeacherFile tf1 = new TeacherFile(1, "Math quiz", "Bunch of questions", 1);
        tf1.addModule(cm1);
        teacherFileDao.create(tf1);
        cm1.addTeacherFile(tf1);
        c1.addModule(cm1);
        courseModuleDao.create(cm1);
        
        s1.addCourse(c1);
        s2.addCourse(c1);
        s3.addCourse(c3);
        s3.addCourse(c2);
        
        courseDao.create(c1);
        courseDao.create(c2);
        courseDao.create(c3);
        
        Teacher t1 = new Teacher(1, "Rick", "James", "RickJames", "Rick1", "Rick@James");
        Teacher t2 = new Teacher(2, "Rick", "Flare", "RickFlare", "Rick2", "Rick@Flare");
        Teacher t3 = new Teacher(3, "Rick", "Jones", "RickJones", "Rick3", "Rick@Jones");
        
        c1.addStudent(s1);
        c1.addStudent(s2);
        c2.addStudent(s3);
        c3.addStudent(s3);
        
        t1.addCourse(c1);
        t1.addCourse(c2);
        t2.addCourse(c3);
        
        
        teacherDao.create(t1);
        teacherDao.create(t2);
        teacherDao.create(t3);
        
        studentDao.create(s1);
        studentDao.create(s2);
        studentDao.create(s3);
                         
        
        teacherDao.create(new Teacher(1, "Rick", "James", "RickJames", "Rick1", "Rick@James"));
        teacherDao.create(new Teacher(2, "Rick", "Flare", "RickFlare", "Rick2", "Rick@Flare"));
        teacherDao.create(new Teacher(3, "Rick", "Jones", "RickJones", "Rick3", "Rick@Jones"));
        
    }
    
    
    @Test
    public void checkAddCourse(){
        Course c = courseDao.find(1);
        CourseModule cm = courseModuleDao.find(1);
        
        courseDao.addCourseModule(c, cm);
        
        Assert.assertTrue(c.getCourseModules().contains(cm));
        Assert.assertFalse(cm.getCourse() == null);
        Assert.assertTrue(cm.getCourse().equals(c));
    }
    
    @Test
    public void checkAddStudent(){
        Course c = courseDao.find(1);
        Student s = studentDao.find(1);
        
        courseDao.addStudents(c, s);
        
        Assert.assertTrue(c.getStudents().contains(s));
        Assert.assertFalse(s.getCourses().get(0) == null);
        Assert.assertTrue(s.getCourses().contains(c));
    }*/
}
