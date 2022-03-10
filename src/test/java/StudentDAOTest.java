/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

/**
 *
 * @author albinbecevic
 */
@RunWith(Arquillian.class)
public class StudentDAOTest{
    @Deployment
    public static WebArchive createDeployment(){
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(StudentDAO.class, Student.class)
                .addAsResource("META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE,"beans.xml");
    }
    
    @EJB
    private StudentDAO studentDao;
    /*
    @Before
    public void init(){
        studentDao.create(new Student(1, "Billy", "James", "RickJames", "Billy1", "Billy@James"));
        studentDao.create(new Student(2, "Billy", "Flare", "RickFlare", "Billy2", "Billy@Flare"));
        studentDao.create(new Student(3, "Billy", "Jones", "RickJones", "Billy3", "Billy@Jones"));
    }
    
    
    @Test
    public void checkThatFindStudentMatchingNameMatchesCorrectly() {
        Assert.assertTrue(true);
        
    }*/
}
