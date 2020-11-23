package edu.upc.dsa;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
public class TestService {
    private Covid19Manager cv;

    @Before
    public void setUp() throws Exception {
        this.cv = Covid19ManagerImp.getInstance();
        this.cv.addPers("user1", "Juana", "Lo","buena");


        this.cv.addLab("L1","Done");
        Assert.assertEquals(1, this.cv.numlabs());



    }

    @After
    public void tearDown(){
        this.cv.clear();
    }

    @org.junit.Test
    public void testAddUser() {
        this.cv.addPers("p", "Juan", "Ord","buena");
        Assert.assertEquals("Juan", this.cv.getPers("p"));
    }

}
