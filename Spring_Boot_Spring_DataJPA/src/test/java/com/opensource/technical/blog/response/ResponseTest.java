package com.opensource.technical.blog.response;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.opensource.technical.blog.domain.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResponseTest {

	@Test
	public void responseSuccess() {
		Response resp = new Response();
		resp.setDescription("description");
		resp.setHttpstatus(HttpStatus.OK);
		resp.setObj(new Employee());
		resp.getDescription();
		resp.getHttpstatus();
		resp.getObj();
		resp.toString();
	}
}
