package com.opensource.technical.blog.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.opensource.technical.blog.domain.Employee;
import com.opensource.technical.blog.irepository.IEmployeeRepository;
import com.opensource.technical.blog.response.Response;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeControllerTest {
	
	@InjectMocks
	EmployeeController empContrl;
	
	@Mock
	IEmployeeRepository iempRepo;
	
	@Before
	public void init() {
		/*
		 * final Employee emp = new Employee(); emp.setEmpId(12L);
		 * emp.setEmpName("sumeet tiwari"); emp.setCompanyName("Google");
		 * emp.setEmpAge(27); when(iempRepo.findById(1L)).thenReturn(Optional.of(emp));
		 */}
	
	@Test
	public void saveEmployee_Created() {
		final Employee emp = new Employee();
		emp.setEmpId(12L);
		emp.setEmpName("sumeet");
		emp.setCompanyName("Google");
		emp.setEmpAge(27);
		when(iempRepo.save(any(Employee.class))).thenReturn(emp);
		ResponseEntity<Response> resp = empContrl.saveEmployee(emp);
		assertEquals(HttpStatus.CREATED, resp.getBody().getHttpstatus());
	}
	
	@Test
	public void saveEmployee_OK() {
		final Employee emp = new Employee();
		emp.setEmpId(12L);
		emp.setEmpName("sumeet");
		emp.setCompanyName("Google");
		emp.setEmpAge(27);
		when(iempRepo.save(any(Employee.class))).thenReturn(null);
		ResponseEntity<Response> resp = empContrl.saveEmployee(emp);
		assertEquals(HttpStatus.OK, resp.getBody().getHttpstatus());
	}
	
	@Test
	public void saveEmployee_Internal_Server_Error() {
		final Employee emp = new Employee();
		emp.setEmpId(12L);
		emp.setEmpName("sumeet");
		emp.setCompanyName("Google");
		emp.setEmpAge(27);
		when(iempRepo.save(any(Employee.class))).thenThrow(new RuntimeException("Exception Occours"));
		ResponseEntity<Response> resp = empContrl.saveEmployee(emp);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, resp.getBody().getHttpstatus());
	}
	
	@Test
	public void updateEmployee_Success() {
		final Employee emp = new Employee();
		emp.setEmpId(12L);
		emp.setEmpName("sumeet tiwari");
		emp.setCompanyName("Google");
		emp.setEmpAge(27);
		when(iempRepo.findById(12L)).thenReturn(Optional.of(emp));
		when(iempRepo.save(any(Employee.class))).thenReturn(emp);
		ResponseEntity<Response> resp = empContrl.updateEmployee(emp);
		assertEquals(HttpStatus.OK, resp.getBody().getHttpstatus());
	}
	
	@Test
	public void updateEmployee_Not_Found() {
		final Employee emp = new Employee();
		emp.setEmpId(12L);
		emp.setEmpName("sumeet tiwari");
		emp.setCompanyName("Google");
		emp.setEmpAge(27);
		when(iempRepo.findById(13L)).thenReturn(Optional.of(emp));
		when(iempRepo.save(any(Employee.class))).thenReturn(emp);
		ResponseEntity<Response> resp = empContrl.updateEmployee(emp);
		assertEquals(HttpStatus.NOT_FOUND, resp.getBody().getHttpstatus());
	}
	
	@Test
	public void updateEmployee_SAVE_Return_Null() {
		final Employee emp = new Employee();
		emp.setEmpId(12L);
		emp.setEmpName("sumeet tiwari");
		emp.setCompanyName("Google");
		emp.setEmpAge(27);
		when(iempRepo.findById(12L)).thenReturn(Optional.of(emp));
		when(iempRepo.save(any(Employee.class))).thenReturn(null);
		ResponseEntity<Response> resp = empContrl.updateEmployee(emp);
		assertEquals(HttpStatus.OK, resp.getBody().getHttpstatus());
	}
	
	@Test
	public void updateEmployee_Internal_Server_Error() {
		final Employee emp = new Employee();
		emp.setEmpId(12L);
		emp.setEmpName("sumeet tiwari");
		emp.setCompanyName("Google");
		emp.setEmpAge(27);
		when(iempRepo.findById(12L)).thenReturn(Optional.of(emp));
		when(iempRepo.save(any(Employee.class))).thenThrow(new RuntimeException("Exception Occours"));
		ResponseEntity<Response> resp = empContrl.updateEmployee(emp);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, resp.getBody().getHttpstatus());
	}
	
	@Test
	public void getEmployee_OK() {
		final Employee emp = new Employee();
		emp.setEmpId(12L);
		emp.setEmpName("sumeet tiwari");
		emp.setCompanyName("Google");
		emp.setEmpAge(27);
		when(iempRepo.findById(12L)).thenReturn(Optional.of(emp));
		ResponseEntity<Response> resp = empContrl.getEmployee(12L);
		assertEquals(HttpStatus.OK, resp.getBody().getHttpstatus());
	}
	
	@Test
	public void getEmployee_NOT_FOUND() {
		final Employee emp = new Employee();
		emp.setEmpId(12L);
		emp.setEmpName("sumeet tiwari");
		emp.setCompanyName("Google");
		emp.setEmpAge(27);
		when(iempRepo.findById(12L)).thenReturn(Optional.of(emp));
		ResponseEntity<Response> resp = empContrl.getEmployee(13L);
		assertEquals(HttpStatus.NOT_FOUND, resp.getBody().getHttpstatus());
	}
	
	@Test
	public void getEmployee_INTERNAL_SERVER_ERROR() {
		final Employee emp = new Employee();
		emp.setEmpId(12L);
		emp.setEmpName("sumeet tiwari");
		emp.setCompanyName("Google");
		emp.setEmpAge(27);
		when(iempRepo.findById(12L)).thenThrow(new RuntimeException("Exception Occours"));
		ResponseEntity<Response> resp = empContrl.getEmployee(12L);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, resp.getBody().getHttpstatus());
	}
	
	@Test
	public void deleteEmployee_OK() {
		final Employee emp = new Employee();
		emp.setEmpId(12L);
		emp.setEmpName("sumeet tiwari");
		emp.setCompanyName("Google");
		emp.setEmpAge(27);
		when(iempRepo.findById(12L)).thenReturn(Optional.of(emp));
		ResponseEntity<Response> resp = empContrl.deleteEmployee(12L);
		assertEquals(HttpStatus.OK, resp.getBody().getHttpstatus());
	}
	
	@Test
	public void deleteEmployee_NOT_FOUND() {
		final Employee emp = new Employee();
		emp.setEmpId(12L);
		emp.setEmpName("sumeet tiwari");
		emp.setCompanyName("Google");
		emp.setEmpAge(27);
		when(iempRepo.findById(11L)).thenReturn(Optional.of(emp));
		ResponseEntity<Response> resp = empContrl.deleteEmployee(12L);
		assertEquals(HttpStatus.NOT_FOUND, resp.getBody().getHttpstatus());
	}
	
	@Test
	public void deleteEmployee_INTERNAL_SERVER_ERROR() {
		final Employee emp = new Employee();
		emp.setEmpId(12L);
		emp.setEmpName("sumeet tiwari");
		emp.setCompanyName("Google");
		emp.setEmpAge(27);
		when(iempRepo.findById(12L)).thenThrow(new RuntimeException("Exception Occours"));
		ResponseEntity<Response> resp = empContrl.deleteEmployee(12L);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, resp.getBody().getHttpstatus());
	}

}
