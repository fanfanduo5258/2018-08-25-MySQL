package com.db.demo;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class DemoTest1 {
	public static Demo d = new Demo();

	@Before
	public void setUp() throws Exception {
	}

	@Before
	public void testCreateDb() {
		d.createDb();
	}

	@Ignore
	public void testInsert() {
		Map param = new HashMap<>();
		param.put("id", "6");
		param.put("name", "larry");
		param.put("password", "123456");
		//向数据库插入数据
		d.insert(param);
	}

	@Test
	public void testGetAll() {
		d.getAll();
	}

	@After
	public void testClose() {
		d.close();
	}

}
