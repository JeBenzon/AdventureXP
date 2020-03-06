package adventurexp.demo.controller.frontoffice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusinessCustomersControllerTest {

    BusinessCustomersController businessCustomersController = new BusinessCustomersController();


    @Test
    public void index()throws Exception{
        assertEquals("index", businessCustomersController.index());
    }






}