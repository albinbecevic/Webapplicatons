/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
import model.dao.UserDAO;
import model.entity.User;
import model.dao.TeacherDAO;
import model.entity.Teacher;
import model.dao.StudentDAO;
import model.entity.Student;

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
*/

/**
 *
 * @author albinbecevic
 */

/* The table User no longer has to be used anymore, we seperate teacher and 
   student tables
*/


/*
@RunWith(Arquillian.class)
public class UserDAOTest{
    @Deployment
    public static WebArchive createDeployment(){
        return ShrinkWrap.create(WebArchive.class).addClasses(UserDAO.class, User.class, TeacherDAO.class, Teacher.class, StudentDAO.class, Student.class)
                .addAsResource("META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE,"beans.xml");
    }
    
    @EJB
    private UserDAO userDao;
    
    @EJB
    private TeacherDAO teacherDao;
    
    @EJB
    private StudentDAO studentDao;
    
    @Before
    public void init(){
               
        Teacher t1 = new Teacher(1, "Rick", "James", "Rick@James");
        teacherDao.create(t1);
        userDao.create(new User(1, "Ricky", "pass1", "Rick", "James", "Rick@James", "teacher", t1, null));
                
    }
    
    @Test
    public void checkThatFindUsersMatchingNameMatchesCorrectly() {
        Assert.assertTrue(true);
        
    }
}*/
