package com.greatlearning.week9;

import com.greatlearning.week9.pojo.User;
import com.greatlearning.week9.service.AdminService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//@WebMvcTest(foodMenuController.class)
@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles({"ADMIN","USER"})
class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    AdminService adminService;

    //test get user by id
    @Test
    @WithMockUser(username = "aniruddha",password = "pass") //userid pass login checked
    public void getuserbyId() throws Exception {
        User user = new User(20L,"userrr","pass",true);
        Mockito.when(adminService.get(20L)).thenReturn(user);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/getUserById/1")).andExpect(ResultMatcher.matchAll()).andReturn();
        assertThat(result).isNotNull();
    }

    //test add user
    @Test
    @WithMockUser(username = "aniruddha",password = "pass")
    public void adduser() throws Exception {
        User user = new User(20L,"userrr","pass",true);
        Mockito.when(adminService.addUser(user)).thenReturn(user);
        MvcResult result =mockMvc.perform(MockMvcRequestBuilders.post("/addUser")).andReturn();
        assertThat(result).isNotNull();
    }

    //test get all users
    @Test
    @WithMockUser(username = "aniruddha",password = "pass")
    public void getallusers() throws Exception {
        User user = new User(20L,"userrr","pass",true);
        User user2 = new User(22L,"userrr","pass",true);

        List<User> list = new ArrayList<User>();

        list.add(user);
        list.add(user2);

        Mockito.when(adminService.listAll()).thenReturn(list);
        MvcResult result =mockMvc.perform(MockMvcRequestBuilders.post("/getAllUsers")).andReturn();
        assertThat(result).isNotNull();
    }
}
