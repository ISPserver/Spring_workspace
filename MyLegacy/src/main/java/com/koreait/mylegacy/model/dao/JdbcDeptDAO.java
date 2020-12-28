package com.koreait.mylegacy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.mylegacy.model.domain.Dept;
import com.koreait.mylegacy.model.pool.PoolManager;

//Dept ���̺��� ���� CRUD�� �����ϵ�, jdbc������� �ڵ� �ۼ�
@Repository
public class JdbcDeptDAO {	
	private Connection con;	
	public void setCon(Connection con) {
		this.con = con;
	}
	
	public List selectAll() {
		List list = null;
		return list;
	}
	
	public Dept select(int deptno) {
		Dept dept = null;
		return dept;
	}
	
	public int regist(Dept dept)  throws SQLException{
		int result= 0;
		String sql = "insert into dept(deptno,dname,loc) values(?,?,?)";		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());
			result = pstmt.executeUpdate();			
			
		}  finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return result;		
	}
	
	public int delete(int deptno) {
		int result=0;
		return result;
	}
}