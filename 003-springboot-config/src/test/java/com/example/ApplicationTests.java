package com.example;

import com.example.pojo.Dog;
import com.example.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private Dog dog;

	@Autowired
	private Person person;

	@Test
	void contextLoads() {
		System.out.println(dog);//Dog{name='旺财', age=3}
	}

	@Test
	void testYaml(){
		System.out.println(person);
		//Person{name='zhangsan', age=3, happy=false, birth=Fri Mar 19 00:00:00 CST 2021, maps={k1=v1, k2=v2}, list=[code, music, grl], dog=Dog{name='喵喵酱', age=3}}
	}

	/**
	 * 测试使用自定义的配置文件
	 */
	@Test
	void testDuoZiJie(){
		System.out.println(person);
		//Person{name='夺子姐', age=null, happy=null, birth=null, maps=null, list=null, dog=null}
	}

	/**
	 * 测试多模块的yaml
	 */
	@Test
	void testMultiYaml(){
		System.out.println(person);
		//Person{name='李四', age=13, happy=false, birth=Sat Mar 20 00:00:00 CST 2021, maps={k1=v1, k2=v2}, list=[code, music, girl], dog=Dog{name='hello_旺财', age=3}}
	}
}
