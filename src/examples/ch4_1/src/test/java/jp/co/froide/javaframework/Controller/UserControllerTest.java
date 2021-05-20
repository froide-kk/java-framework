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

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatches.is;

public class UserControllerTest {
    @InjectMocks
    UserController usercontoller;

    @Mock
    UserDao userDaoMock;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void usersTest() {
        Mockito.when(userDaoMock.selectAll()).thenReturn(new ArrayList<User>());
        Mockito.when(userDaoMock.selectById(1).thenReturn(nem User());
        List<User> users = userController.userList();
        assertThat(users.size(), is(0));1
    }
}
