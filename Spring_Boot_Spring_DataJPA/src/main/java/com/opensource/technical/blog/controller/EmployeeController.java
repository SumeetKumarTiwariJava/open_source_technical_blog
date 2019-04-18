package com.opensource.technical.blog.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.opensource.technical.blog.constant.MessageConstant;
import com.opensource.technical.blog.domain.Employee;
import com.opensource.technical.blog.irepository.IEmployeeRepository;
import com.opensource.technical.blog.response.Response;

/**
 * @author sumeet tiwari<OPEN SOURCE TECHNICAL BLOG>
 *
 */
@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	IEmployeeRepository iempRepo;
	
	/**
	 * @param emp
	 * @return
	 */
	@RequestMapping(value = "/save", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<Response> saveEmployee(@RequestBody Employee emp) {
		HttpStatus httpstatus = HttpStatus.OK;
		Response resp = new Response();
		resp.setHttpstatus(httpstatus);
		Employee empSaved = null;
		try {
			empSaved=iempRepo.save(emp);
			if(null!=empSaved) {
				resp.setDescription(MessageConstant.SAVE_SUCCESS);
				resp.setHttpstatus(HttpStatus.CREATED);
				resp.setObj(empSaved);
			}
		} catch (Exception e) {
			resp.setDescription(MessageConstant.INTERNAL_SERVER_ERROR);
			resp.setHttpstatus(HttpStatus.INTERNAL_SERVER_ERROR);
			resp.setObj(null);
		}
		return new ResponseEntity<Response>(resp, httpstatus);
	}
	
	
	@RequestMapping(value = "/update", consumes = "application/json", method = RequestMethod.PUT)
	ResponseEntity<Response> updateEmployee(@RequestBody Employee emp) {
		HttpStatus httpstatus = HttpStatus.OK;
		Response resp = new Response();
		resp.setHttpstatus(httpstatus);
		Optional<Employee> empToUpdate = null;
		Employee empReturnVal =null;
		try {
			empToUpdate=iempRepo.findById(emp.getEmpId());
			if(empToUpdate.isPresent()) {
				emp.setEmpId(emp.getEmpId());
				emp.setEmpName(emp.getEmpName());
				emp.setCompanyName(emp.getCompanyName());
				emp.setEmpAge(emp.getEmpAge());
				empReturnVal=iempRepo.save(emp);
				if(null!=empReturnVal) {
					resp.setDescription(MessageConstant.UPDATE_SUCCESS);
					resp.setHttpstatus(HttpStatus.OK);
					resp.setObj(empReturnVal);
				}
			}
			else {
				resp.setDescription(MessageConstant.NOT_FOUND);
				resp.setHttpstatus(HttpStatus.NOT_FOUND);
				resp.setObj(empReturnVal);
			}
		} catch (Exception e) {
			resp.setDescription(MessageConstant.INTERNAL_SERVER_ERROR);
			resp.setHttpstatus(HttpStatus.INTERNAL_SERVER_ERROR);
			resp.setObj(null);
		}
		return new ResponseEntity<Response>(resp, httpstatus);
	}
	
	
	@RequestMapping(value = "/get/{id}", consumes = "application/json", method = RequestMethod.GET)
	ResponseEntity<Response> getEmployee(@PathVariable(value = "id") Long empId) {
		HttpStatus httpstatus = HttpStatus.OK;
		Response resp = new Response();
		Optional<Employee> empGet = null;
		try {
			empGet=iempRepo.findById(empId);
			if(empGet.isPresent()) {
				resp.setDescription(MessageConstant.GET_EMP_SUCCESS);
				resp.setHttpstatus(HttpStatus.OK);
				resp.setObj(empGet.get());
			}
			else {
				resp.setDescription(MessageConstant.NOT_FOUND);
				resp.setHttpstatus(HttpStatus.NOT_FOUND);
				resp.setObj(null);
			}
		} catch (Exception e) {
			resp.setDescription(MessageConstant.INTERNAL_SERVER_ERROR);
			resp.setHttpstatus(HttpStatus.INTERNAL_SERVER_ERROR);
			resp.setObj(null);
		}
		return new ResponseEntity<Response>(resp, httpstatus);
	}
	
	
	/**
	 * @param empId
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", consumes = "application/json", method = RequestMethod.DELETE)
	ResponseEntity<Response> deleteEmployee(@PathVariable(value = "id") Long empId) {
		HttpStatus httpstatus = HttpStatus.OK;
		Response resp = new Response();
		Optional<Employee> empDelete = null;
		try {
			empDelete=iempRepo.findById(empId);
			if(empDelete.isPresent()) {
				iempRepo.delete(empDelete.get());
				resp.setDescription(MessageConstant.DELETE_EMP_SUCCESS);
				resp.setHttpstatus(HttpStatus.OK);
				resp.setObj(null);
			}
			else {
				resp.setDescription(MessageConstant.NOT_FOUND);
				resp.setHttpstatus(HttpStatus.NOT_FOUND);
				resp.setObj(empDelete);
			}
		} catch (Exception e) {
			resp.setDescription(MessageConstant.INTERNAL_SERVER_ERROR);
			resp.setHttpstatus(HttpStatus.INTERNAL_SERVER_ERROR);
			resp.setObj(null);
		}
		return new ResponseEntity<Response>(resp, httpstatus);
	}
}
