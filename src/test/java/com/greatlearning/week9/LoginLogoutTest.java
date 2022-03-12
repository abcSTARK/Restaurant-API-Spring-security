package com.greatlearning.week9;

import com.greatlearning.week9.service.MyUserDetails;
import com.greatlearning.week9.service.ProductService;
import org.junit.jupiter.api.Test;
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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles({"ADMIN","USER"})
public class LoginLogoutTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ProductService productService;

    @MockBean
    MyUserDetails myUserDetails;

    //test login to home page/ home Controller
    @Test
    @WithMockUser(username = "aniruddha",password = "pass") //userid pass login checked
    public void testlogin() throws Exception {

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/")).andExpect(ResultMatcher.matchAll()).andReturn();
        //System.out.println(result.getResponse().getContentType().length());
        assertThat(result.getResponse().getStatus()).isNotNull();

        //MockHttpServletResponse:
        //           Status = 200
    }

}
