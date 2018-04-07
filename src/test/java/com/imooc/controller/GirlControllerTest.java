package com.imooc.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GirlControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void girlList() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/girls"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("[{\"id\":9,\"cupSize\":\"B\",\"age\":23,\"money\":233.0},{\"id\":10,\"cupSize\":\"B\",\"age\":23,\"money\":21.0},{\"id\":11,\"cupSize\":\"B\",\"age\":23,\"money\":21.0},{\"id\":12,\"cupSize\":\"B\",\"age\":9,\"money\":12.0},{\"id\":13,\"cupSize\":\"B\",\"age\":13,\"money\":12.0}]"));
    }

}