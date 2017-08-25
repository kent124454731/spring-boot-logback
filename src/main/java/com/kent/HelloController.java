package com.kent;

import com.kent.entity.User;
import com.kent.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @Author Kent.Wang
 * @Date 2017/7/4
 */
@RestController
public class HelloController {
    private static final Logger logger = LoggerFactory
            .getLogger(HelloController.class);

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "hello/{name}")
    public String hello(@PathVariable String name) {
        try {
            User user = userRepository.findFirstByUsername(name);
//            File file = new File("D:/test1.txt");
            if (user == null) {
                logger.error("没有找到该用户");
                return "没有找到该用户";
            }
            if (user.getPhone() != null) {
                logger.info("手机号:" + user.getPhone() + "登录了");
            } else {
                logger.info("name未绑定手机号:");
            }
            return "hello," + name;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return "没有找到该用户";
        }
    }

    @RequestMapping(value = "hello2/{name}")
    public String hello2(@PathVariable String name) {
        try {
            File file = new File("D:/test1.txt");
            OutputStream outputStream = new FileOutputStream(file);
            String message = "hello," + name;
            byte[] bytes = message.getBytes();
            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();
            return "hello," + name;
        } catch (Exception e) {
            e.printStackTrace();
            return "没有找到该用户";
        }
    }

    @RequestMapping(value = "hello3")
    public void hello3() {
        java.util.logging.Logger.getGlobal().info("test util.logging");
    }


}
