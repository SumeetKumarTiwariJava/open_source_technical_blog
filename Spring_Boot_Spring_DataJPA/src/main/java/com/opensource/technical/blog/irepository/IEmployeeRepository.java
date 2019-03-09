package com.opensource.technical.blog.irepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.opensource.technical.blog.domain.Employee;

/**
 * @author sumeet tiwari<OPEN SOURCE TECHNICAL BLOG>
 *
 */
//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete

@Repository
public interface IEmployeeRepository extends CrudRepository<Employee, Long>{

}
