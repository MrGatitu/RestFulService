package com.example.RESTfulService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class UsersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetUserValidId() throws Exception {
        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("User{id=2, name='Barry', email='mail@example.com'}"));
    }

    @Test
    public void testGetUserInvalidId() throws Exception {
        mockMvc.perform(get("/users/10"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("User not found: User ID 10 is out of bounds. Maximum ID is 2"));
    }

    @Test
    public void testGetUserNegativeId() throws Exception {
        mockMvc.perform(get("/users/-1"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("User not found: User ID -1 is out of bounds. Maximum ID is 2"));
    }

    @Test
    public void testGetUserZeroId() throws Exception {
        mockMvc.perform(get("/users/0"))
                .andExpect(status().isOk())
                .andExpect(content().string("User{id=1, name='Vivian', email='123@example.com'}"));
    }
}
