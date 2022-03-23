package com.wjl.library;

import com.wjl.library.Mapper.BookMapper;
import com.wjl.library.bean.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LibraryApplicationTests {


    @Autowired
    BookMapper bookMapper;
    @Test
    void contextLoads() {

    }



}
