package com.orznewbie;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LocalFuck {
    @Test
    public void test01() {
        ApplicationContext c = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
}