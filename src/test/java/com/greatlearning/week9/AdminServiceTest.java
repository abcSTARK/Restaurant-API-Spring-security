package com.greatlearning.week9;

import com.greatlearning.week9.pojo.User;
import com.greatlearning.week9.repository.AdminRepository;
import com.greatlearning.week9.service.AdminService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class AdminServiceTest {

    @Autowired
    AdminService adminService;

    @MockBean
    AdminRepository adminRepository;

    //PositiveTestCase
    @Test
    public void testCreateUser(){
        User user = new User(20L,"userrr","pass",true);

        Mockito.when(adminRepository.save(user)).thenReturn(user);

        assertThat(adminService.addUser(user)).isEqualTo(user);

    }

    @Test
    public void testgetAllUser(){

        assertThat(adminService.listAll().size()).isGreaterThanOrEqualTo(0);

    }

    //NegativeTestCase
    @Test
    public void testgetUserbyId(){

        Assertions.assertThrows(NullPointerException.class,
                ()->{
                    String test = adminService.get(20L).getUsername();
                });

    }


}
