package com.db.grad.javaapi.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.meanbean.test.BeanTester;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AllDtos {



    @Test
    @DisplayName("Test All Dto's getters and setters")
    public void testAllDtos() {
        BeanTester beanTester = new BeanTester();
        beanTester.testBean(UserDto.class);
    }
}
