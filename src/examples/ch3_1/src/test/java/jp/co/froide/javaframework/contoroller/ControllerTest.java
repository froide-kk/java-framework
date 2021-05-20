package jp.co.froide.javaframework.contoroller;

import jp.co.froide.javaframework.controller.ItemController;
import jp.co.froide.javaframework.dao.ItemDao;
import jp.co.froide.javaframework.entity.Item;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;


public class ControllerTest {
    @InjectMocks
    ItemController itemController;
    Model model;

    @Mock
    ItemDao itemDaoMock;

    @BeforeAll
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void itemListTest(){
        Mockito.when(itemDaoMock.selectAll()).thenReturn(new ArrayList<Item>());
        //Mockito.when(itemDaoMock.selectById(1)).thenReturn(new Item());
        List<Item> items = itemController.itemList();
        assertThat(items.size(), is(0));
    }
//
//    @Test
//    public void helloTest(){
//        List<Item> list = itemController.itemList();
//        Model m = model.addAttribute(list);
//        assertThat( itemController.hello(model), is("hello"));
//    }
}
