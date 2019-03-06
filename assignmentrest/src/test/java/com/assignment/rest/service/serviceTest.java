package com.assignment.rest.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.assignment.rest.Student;

public class serviceTest {
    service serviceTest = new service();
    Student[] infoTest = new Student[2];


    @Test
    public void modificationTestSingleJSONObject(){

        infoTest[0] = new Student();
        infoTest[0].setName("ashish");
        infoTest[0].setPlace("blr");
        Student[] result = serviceTest.modification(infoTest);
        assertEquals(null,result[0].getName());
        assertEquals(null,result[0].getPlace());
    }

    @Test
    public void modificationTestSameNameDiffPlace(){
        infoTest[0] = new Student();
        infoTest[1] = new Student();

        infoTest[0].setName("ashish");
        infoTest[0].setPlace("blr");

        infoTest[1].setName("ashish");
        infoTest[1].setPlace("jbp");

        Student[] result = serviceTest.modification(infoTest);
        assertEquals("ashish",result[0].getName());
        assertEquals("blr jbp",result[0].getPlace());

    }

    @Test
    public void modificationTestDiffNameDiffPlace(){
        infoTest[0] = new Student();
        infoTest[1] = new Student();

        infoTest[0].setName("ashish");
        infoTest[0].setPlace("blr");

        infoTest[1].setName("amogh");
        infoTest[1].setPlace("jbp");

        Student[] result = serviceTest.modification(infoTest);
        assertEquals("ashish amogh",result[0].getName());
        assertEquals("blr jbp",result[0].getPlace());

    }

    @Test
    public void modificationTestDiffNameSamePlace(){
        infoTest[0] = new Student();
        infoTest[1] = new Student();

        infoTest[0].setName("ashish");
        infoTest[0].setPlace("blr");

        infoTest[1].setName("amogh");
        infoTest[1].setPlace("blr");

        Student[] result = serviceTest.modification(infoTest);
        assertEquals("ashish amogh",result[0].getName());
        assertEquals("blr",result[0].getPlace());

    }

    @Test
    public void modificationTestDiffNameNullPlace(){
        infoTest[0] = new Student();
        infoTest[1] = new Student();

        infoTest[0].setName("ashish");
        infoTest[0].setPlace("blr");

        infoTest[1].setName("lavanya");

        Student[] result = serviceTest.modification(infoTest);
        assertEquals("ashish lavanya",result[0].getName());
        assertEquals(null,result[0].getPlace());

    }

    @Test
    public void modificationTestSameNameNullPlace(){

        infoTest[0] = new Student();
        infoTest[1] = new Student();
        infoTest[0].setName("ashish");
        infoTest[0].setPlace("blr");

        infoTest[1].setName("ashish");

        Student[] result = serviceTest.modification(infoTest);
        assertEquals(null,result[0].getName());
        assertEquals(null,result[0].getPlace());

    }

    @Test
    public void modificationTestNullNameDiffPlace(){
        infoTest[0] = new Student();
        infoTest[1] = new Student();

        infoTest[0].setName("ashish");
        infoTest[0].setPlace("blr");

        infoTest[1].setPlace("lkw");

        Student[] result = serviceTest.modification(infoTest);
        assertEquals(null,result[0].getName());
        assertEquals(null,result[0].getPlace());

    }

    @Test
    public void modificationTestNullNameSamePlace(){
        infoTest[0] = new Student();
        infoTest[1] = new Student();

        infoTest[0].setName("ashish");
        infoTest[0].setPlace("blr");

        infoTest[1].setPlace("lkw");
        Student[] result = serviceTest.modification(infoTest);
        assertEquals(null,result[0].getName());
        assertEquals(null,result[0].getPlace());

    }
}
