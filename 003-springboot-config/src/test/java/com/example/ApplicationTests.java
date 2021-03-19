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

}
