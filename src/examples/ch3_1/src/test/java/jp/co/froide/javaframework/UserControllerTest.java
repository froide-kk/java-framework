package jp.co.froide.javaframework;

import jp.co.froide.javaframework.controller.UserController;
import jp.co.froide.javaframework.dao.UserDao;
import jp.co.froide.javaframework.dsl.UserDsl;
import jp.co.froide.javaframework.entiDSL.UserEntity;
import jp.co.froide.javaframework.entity.User;
import jp.co.froide.javaframework.form.UserForm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class UserControllerTest {
    private MockMvc mockMvc;

    @Autowired
    Validator validator;

    @Mock
    UserDao userDaoMock;
    @Mock
    BindingResult result;
    @Mock
    UserDsl userDslMock;
    @Mock
    Model model;
    @Mock
    RedirectAttributes ra;

    @InjectMocks
    UserController userController;a

    @BeforeEach
    public void serUp(){
        MockitoAnnotations.openMocks(this);

    }

    @Test
    public void UserSelectTest(){
        User user = new User();
        user.setId(23);
        user.setName("foo");
        user.setPassword("hoge");
        //Mockito.when(userDaoMock.selectById(23)).thenReturn(user);

        User user2 = new User();
        user.setId(23);
        user.setName("foo");
        user.setPassword("hoge");
        Mockito.when(userDaoMock.selectById(23)).thenReturn(user2);


        User expected = userController.userDetail(23);
        assertThat(expected,is(user2));
    }
/*
    @Test
    public void UserPostTest(Model model){

        UserEntity user = new UserEntity();
        user.setId(23);
        user.setName("foo");
        user.setPassword("hoge");

        Mockito.doNothing().when(userDslMock).insert(user);

        String expected = "redirect:/users/list";
        assertThat(expected, is("redirect:/users/list"));*/

    @Test
    public void getListTest()  {
        String expected = userController.userList(model);
        assertThat(expected,is("test1/userList"));
    }

    @Test
    public  void postErrorTest() {
        UserForm form = new UserForm();
        form.setName("hoge");
        form.setPassword("ss");
        form.setPasswordConfirm("hjk");
        Mockito.when(result.hasErrors()).thenReturn(true);

        String expected = userController.postUser(form, result, model, ra );
        assertThat(expected, is("redirect:/users/post"));
    }

}
