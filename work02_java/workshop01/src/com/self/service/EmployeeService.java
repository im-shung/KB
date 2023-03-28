package com.self.service;

import com.self.vo.Employee;
import com.self.vo.Engineer;
import com.self.vo.Manager;

public class EmployeeService {

	Employee[] es;
	int idx;
	int size;

	private static EmployeeService service = new EmployeeService(8);

	public static EmployeeService getInstance() {
		return service;
	}

	private EmployeeService() {
	}

	private EmployeeService(int size) {
		es = new Employee[size];
	}

	public void addEmployee(Employee e) {
		es[idx++] = e;
	}

	public void deleteEmployee(String name) {
		for (int i = 0; i < idx; i++) {
			if (es[i].getName().equals(name)) {
				for (int j = i; j < idx; j++) {
					es[j] = es[j + 1];
				}
				es[idx] = null;
				idx--;
				break;
			}
		}
	}

	public void updateEmployee(Employee e) {
		for (Employee employee : es) {
			if (employee == null)
				continue;
			if (!(employee instanceof Engineer))
				continue;
			if (employee.getName().equals(e.getName())) {
				employee.setSalary(e.getSalary());
				employee.setBirthDate(e.getBirthDate());
				((Engineer) employee).setTech(((Engineer) e).getTech());
				((Engineer) employee).setBonus(((Engineer) e).getBonus());
				break;
			}
		}
	}
	
	public void updateEmployee(double salary, String dept,int deptno,  String name) {
		for (Employee employee : es) {
			if (employee == null)
				continue;
			if (!(employee instanceof Manager))
				continue;
			if (employee.getName().equals(name)) {
				employee.setSalary(salary);
				((Manager) employee).setDept(dept);
				((Manager) employee).setDeptno(deptno);
				
				break;
			}
		}
	}


	// Method Overloading
	/*
	 * 하는일은 똑같은데...처리하는 데이타를 달리할때 쓰는 기법 메소드의 통일감을 강조하면서도 서로다른 데이타를 처리할수 있게끔 해준다.
	 */

	public Employee findEmployee(String name) {
		Employee e = null;

		for (Employee employee : es) {
			if (employee == null)
				continue;
			if (employee.getName().equals(name)) {
				e = employee;
				break;
			}
		}

		return e;
	}

	public Employee[] findEmployee(int deptno) {
		Employee[] temp = new Employee[es.length];
		int counter = 0;
		for (Employee employee : es) {
			if (employee == null)
				continue;
			if (employee instanceof Manager) {
				if (((Manager) employee).getDeptno() == deptno) {
					temp[counter++] = employee;
				}
			}
		}

		return temp;
	}
	
	
	//추가
	// 특정한 직원의 연봉을 리턴하는 기능을 정의
	public int getAnnualSalary(Employee e) {
		int annualSalary = 0;
		annualSalary = (int) (e.getSalary() * 12);
		if (e instanceof Engineer) {
			annualSalary = (int) (e.getSalary() * 12 + ((Engineer) e).getBonus());
		}
		return annualSalary;
	}
	
	// 모든 직원의 연간 총 인건비를 리턴하는 기능을 정의
	public int getTotalCost() {
		int totalCost = 0;
		for (Employee employee : es) {
			if (employee == null)
				continue;
			totalCost += getAnnualSalary(employee);
		}
		return totalCost;
	} 

	public void printManagers() {		
		for(Employee e : es) {
			if(e!=null && e instanceof Manager)
				System.out.println(e);
		}
	}
	
	public void printEngineers() {		
		for(Employee e : es) {
			if(e!=null && e instanceof Engineer)
				System.out.println(e);
		}
	}

}
