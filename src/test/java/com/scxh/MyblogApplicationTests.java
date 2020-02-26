package com.scxh;

import com.scxh.mapper.BlogMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyblogApplicationTests {
    @Autowired
    private BlogMapper blogMapper;
    @Test
    void contextLoads() {
        System.out.println(blogMapper.getAll());
    }

}
