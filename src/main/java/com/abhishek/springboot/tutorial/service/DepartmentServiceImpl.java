package com.abhishek.springboot.tutorial.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.abhishek.springboot.tutorial.error.DepartmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhishek.springboot.tutorial.entity.Department;
import com.abhishek.springboot.tutorial.repository.DepartmentRepository;

import javax.swing.text.html.Option;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department saveDepartment(Department department) {
		
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> fetchDepartmentList() {
		return departmentRepository.findAll();
	}

	@Override
	public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException {
		
		Optional<Department> department = departmentRepository.findById(id);
		if(department.isEmpty()){
			throw new DepartmentNotFoundException("department with this id not found");
		}

		return department.get();
	}

	@Override
	public void deleteDepartmentById(Long departmentId) {
		departmentRepository.deleteById(departmentId);
	}

	@Override
	public Department updateDepartment(Long departmentId, Department department) {
		
		Department depDB = departmentRepository.findById(departmentId).get();
		
		
//		if anything is not null and not blank, set its value
		if(Objects.nonNull(department.getDepartmentName()) &&
				!"".equalsIgnoreCase(department.getDepartmentName())) {
			depDB.setDepartmentName(department.getDepartmentName());
		}
		if(Objects.nonNull(department.getDepartmentCode()) &&
				!"".equalsIgnoreCase(department.getDepartmentCode())) {
			depDB.setDepartmentCode(department.getDepartmentCode());
		}
		if(Objects.nonNull(department.getDepartmentAddress()) &&
				!"".equalsIgnoreCase(department.getDepartmentAddress())) {
			depDB.setDepartmentAddress(department.getDepartmentAddress());
		}
		
		return departmentRepository.save(depDB);
	}

	@Override
	public Department fetchDepartmentByName(String departmentName) {
		
		return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
	}

}
