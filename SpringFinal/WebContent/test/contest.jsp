<%@page import="com.study.springfinal.domain.Emp"%>
<%@page import="com.study.springfinal.domain.Dept"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.study.springfinal.mybatis.config.MybatisConfigManager"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%!
	MybatisConfigManager manager = MybatisConfigManager.getInstance();	
%>
<%
	//service메서드 영역
	SqlSession sqlSession = manager.getSqlSession();
	List<Dept> list = sqlSession.selectList("Dept.selectAll");
	out.print("검색된 총 사원수:"+list.size());	
%>

<table border="1px">
	<tr>
		<td>부서번호</td>
		<td>부서명</td>
		<td>부서위치</td>
		<td>사원정보</td>
		
	</tr>
	<%for(int i=0; i<list.size(); i++){ %>
	<%Dept deptList = list.get(i); %>	
	<tr>
		<td><%=deptList.getDeptno() %></td>
		<td><%=deptList.getDname() %></td>
		<td><%=deptList.getLoc() %></td>
		<td>
			<table>
				<%List<Emp> empList = deptList.getEmpList(); %>
				<%for(int j=0; j<empList.size(); j++){ %>
				<%Emp emp = empList.get(j); %>
				<tr>
					<td><%=emp.getEmpno() %></td>
					<td><%=emp.getEname() %></td>
					<td><%=emp.getSal() %></td>
					<td><%=emp.getHiredate() %></td>
					<td><%=emp.getComm() %></td>
					<td><%=emp.getMgr() %></td>
				</tr>
				<%} %>
			</table>
		</td>
		
	</tr>
	<%} %>
</table>