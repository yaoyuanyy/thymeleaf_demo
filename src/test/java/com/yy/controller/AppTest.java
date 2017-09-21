package com.yy.controller;

import com.yy.APP;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/9/21 at 下午3:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {APP.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppTest {

}