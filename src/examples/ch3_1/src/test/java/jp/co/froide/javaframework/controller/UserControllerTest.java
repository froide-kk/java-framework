package jp.co.froide.javaframework.controller;

import jp.co.froide.javaframework.UserController;
import jp.co.froide.javaframework.dao.UserDao;
import jp.co.froide.javaframework.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.Controller;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.spy;

public class UserControllerTest {

    @InjectMocks
    UserController userController;

    @Mock
    UserDao userDaoMock;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void userListTest(){
        Mockito.when(userDaoMock.selectAll()).thenReturn(new ArrayList<User>());
        List<User> users = userController.userList();
        assertThat(users.size(),is(0));
    }

    @Test
    public void userEntryList(){
        Mockito.when(userDaoMock.selectAll()).thenReturn(new ArrayList<User>());
        List<User> users = userController.userList();
        assertThat(users.size(),is(0));
    }

    @Test
    public void insert(){

    }
}