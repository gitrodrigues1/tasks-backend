package br.ce.wcaquino.taskbackend.controller;

import org.junit.Assert;
import org.junit.Test;

public class RootControllerTest {



    @Test
    public void testHello() {
        RootController rootController = new RootController();
        
        Assert.assertEquals( "Hello World Tasks Backend!!!", rootController.hello());
    }
}
