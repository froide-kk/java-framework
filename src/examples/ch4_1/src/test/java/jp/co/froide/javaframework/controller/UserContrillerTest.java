package jp.co.froide.javaframework.controller;

import jp.co.froide.javaframework.dao.UserDao;
import jp.co.froide.javaframework.entity.User;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.MatcherAssert.assertThat;
import static  org.hamcrest.CoreMatchers.is;

import static org.mockito.MockitoAnnotations.openMocks;

import java.util.ArrayList;
import java.util.List;

public class UserContrillerTest {
    @InjectMocks
    UserController userController;

    @Mock
    UserDao userDaoMock;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void usersTest(){
        Mockito.when(userDaoMock.selectAll()).thenReturn(new ArrayList<User>());
        Mockito.when(userDaoMock.selectById(Mockito.anyInt())).thenReturn(new User());
        List<User> users = userController.userList();
        assertThat(users.size(),is(0));
    }
}
