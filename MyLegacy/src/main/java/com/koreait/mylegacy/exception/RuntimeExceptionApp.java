package com.koreait.mylegacy.exception;

/*��� ������ �ֻ��� ��ü�� �׳� Exception �ε�,
 *�� ���ܴ� ũ�� ������ Ÿ�ӿ� ó���� �����ϴ� ����
 *��Ÿ�ӽ� ���ܸ� ó���� �� �ִ� ��Ÿ�� ���ܰ� �ִ�(�������� ����)*/
public class RuntimeExceptionApp {
	public static void main(String[] args) {
		int[] arr = new int[3];
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		
		//��� �Ʒ��� �ڵ带 ������� ����ó���� ���������� ������, �����ڴ�
		//���� �������� ���α׷����� �����Ϸ���, ��� ������ ����� �����ؾ� ��
		
		try {			
			arr[3] = 3;//�������� �ʴ� �ε���() �迭�� ������ ����
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("���� �߻�");			
		}
		
	}
}
