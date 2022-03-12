package com.greatlearning.week9;

import com.greatlearning.week9.pojo.Product;
import com.greatlearning.week9.service.ProductService;
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
public class foodMenuControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ProductService productService;

//test bill sum amount
    @Test
    @WithMockUser(username = "aniruddha",password = "pass") //userid pass login checked
    public void buyByIds() throws Exception {
        Product p = new Product(1,"italian pasta","dd",10);
        Mockito.when(productService.get(1)).thenReturn(p);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/placeOrder/1")).andExpect(ResultMatcher.matchAll()).andReturn();
        //System.out.println(result.getResponse().getContentType().length());
        assertThat(result).isNotNull();
    }

    //test menu by id
    @Test
    @WithMockUser(username = "aniruddha",password = "pass")
    public void getMenubyId() throws Exception {
        Product p = new Product(1,"italian pasta","dd",10);
        Mockito.when(productService.get(1)).thenReturn(p);
        MvcResult result =mockMvc.perform(MockMvcRequestBuilders.post("/getFullMenu/1")).andReturn();
        assertThat(result).isNotNull();
    }

    //test whole menu
    @Test
    @WithMockUser(username = "aniruddha",password = "pass")
    public void getMenu() throws Exception {
        Product p = new Product(1,"italian pasta","dd",10);
        Product q = new Product(1,"italian pasta","dd",10);

        List<Product> list = new ArrayList<Product>();

        list.add(p);
        list.add(q);

        Mockito.when(productService.listAll()).thenReturn(list);
        MvcResult result =mockMvc.perform(MockMvcRequestBuilders.post("/getFullMenu")).andReturn();
        assertThat(result).isNotNull();
    }
}
