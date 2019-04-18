package com.opensource.technical.blog.constant;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageConstantTest {
	
	@InjectMocks
	MessageConstant msgConstant;
	
	@Test
	public void constant() {
		String saveSuccess = msgConstant.SAVE_SUCCESS;
		String internalServerError = msgConstant.INTERNAL_SERVER_ERROR;
		String updateSuccess = msgConstant.UPDATE_SUCCESS;
		String notFound = msgConstant.NOT_FOUND;
		String getEmpSuccess = msgConstant.GET_EMP_SUCCESS;
		String deleteEmpSuccess = msgConstant.DELETE_EMP_SUCCESS;
	}

}
