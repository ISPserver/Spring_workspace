package com.study.springfinal.domain;

import java.util.List;

public class Dept {
	/*부서와 사원관의 관계가 1:다 관계, 다수의 자식을 보유한 관계를
	 * Mybatis에서는 Collection 이라고 한다. */
	private int deptno;
	private String dname;
	private String loc;
	//사원들을 거느린다
	private List<Emp> empList;//즉 하나의 부서는 여러 사원을 소속시킬수 있다.
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public List<Emp> getEmpList() {
		return empList;
	}
	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
	}
	
	
	
	
		
	
}
