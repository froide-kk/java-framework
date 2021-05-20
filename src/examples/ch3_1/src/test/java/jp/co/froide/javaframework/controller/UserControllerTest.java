package jp.co.froide.javaframework.controller;

import jp.co.froide.javaframework.dao.UserDao;
import jp.co.froide.javaframework.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserControllerTest {

    private MockMvc mockMvc;

    @Autowired
    UserDao userDao;

    @Mock
    UserDao userDaoMock;

    @InjectMocks
    UserController userController;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void getUserListTest() throws Exception {
        List<User> userDataList = userDao.selectAll();
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("userList"));

    }

    @Test
    public void getUserList() throws Exception{
        Mockito.when(userDaoMock.selectAll()).thenReturn(new ArrayList<User>());
        Mockito.when(userDaoMock.selectById(1)).thenReturn(new User());
        //実装途中
        assertThat(this.userController.userList(), is("hello"));
    }


}

