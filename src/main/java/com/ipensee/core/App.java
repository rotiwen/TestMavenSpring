package com.ipensee.core;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    	Date birthday = new Date();
//    	try {
//    		birthday = new SimpleDateFormat("yyyy-MM-dd").parse("1976-2-7");
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//    	UserMapper userMapper = (UserMapper) context.getBean("userMapper");
//    	User user = (User) context.getBean("user");
//    	user.setId(UUID.randomUUID().toString());
//    	user.setUserName("rotiwen");
//    	user.setBirthday(birthday);
//    	
//    	userMapper.insert(user);
    	
    	Date birthday = new Date();
    	try {
    		birthday = new SimpleDateFormat("yyyy-MM-dd").parse("2014-1-1");
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	UserMapper userMapper = (UserMapper) context.getBean("userMapper");
    	UserExample userExample = (UserExample) context.getBean("userExample");
    	userExample.createCriteria().andBirthdayLessThan(birthday);
    	userExample.setOrderByClause("birthday desc, user_name asc");
    	
    	List<User> userList = userMapper.selectByExample(userExample);
    	
    	for (User user: userList) {
    		System.out.println(user);
    	}
    }
}
