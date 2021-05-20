package jp.co.froide.javaframework.Controller;

import jp.co.froide.javaframework.controller.UserController;
import jp.co.froide.javaframework.dao.UserDao;
import jp.co.froide.javaframework.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.ArrayList;
import java.util.List;
public class ControllerTest {

    MockMvc mvc;

    @Autowired
    UserController userController;

    @Mock
    UserDao userDaoMock;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void userListTest()throws Exception{

        //Mockito.when(userDaoMock.selectAll()).thenReturn(new ArrayList<User>());

        mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                //.andExpect(model().attribute("userList",userList))
                .andExpect(model().hasErrors());



    }

    @Test
    public void insertMoveTest(){

    }

    @Test
    public void indexMoveTest(){

    }

    @Test
    public void selectListTest(){

    }

    @Test
    public void insertListTest(){

    }

    @Test
    public void upDateListTest(){

    }

    @Test
    public void deleteListTest(){

    }



}
