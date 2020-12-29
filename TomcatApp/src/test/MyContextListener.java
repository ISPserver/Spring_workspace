package test;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*��Ĺ�� ���� ��û�� �����⵵ ���� ������, �� ������ �����ϴ� ������ �̺�Ʈ��
 * ������ �� �ִ� ServletContextListener�� �̿���, ServletContext ��ü��
 * ���𰡸� �۾��غ���*/
public class MyContextListener implements ServletContextListener{

	//���ø����̼��� �ʱ�ȭ �ɶ� ȣ��Ǵ� �޼���
	public void contextInitialized(ServletContextEvent sc) {
		System.out.println("��Ĺ ���� ���� �Բ� ����");
		//���ø����̼��� ������ ������ ����, ���Ǻ��ٵ� �ξ� ���� ��ư��� ServletContext��
		//����Ͻ� ��ü��(Service, DAO)�� �ø���
		ServletContext context = sc.getServletContext();
		context.setAttribute("msg", "�� �ູ�ϰ� ���� ���");
		
		String obj =  context.getInitParameter("contextConfigLocation");
		System.out.println("���ø����̼� ������ �޸� �÷��� �����"+obj);
		
		
	}
	
	//���ø����̼��� ���� �ɶ� ȣ��Ǵ� �޼���
	public void contextDestroyed(ServletContextEvent sc) {
		System.out.println("���� ���� ���� �Բ� ����");
	}
}
