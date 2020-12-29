package com.koreait.mylegacy.exception;

/*모든 예외의 최상위 객체는 그냥 Exception 인데,
 *이 예외는 크게 컴파일 타임에 처리를 강요하는 예외
 *런타임시 예외를 처리할 수 있는 런타임 예외가 있다(강요하지 않음)*/
public class RuntimeExceptionApp {
	public static void main(String[] args) {
		int[] arr = new int[3];
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		
		//비록 아래의 코드를 대상으로 예외처리를 강요하지는 않지만, 개발자는
		//보다 안정적인 프로그램으로 제작하려면, 적어도 비정상 종료는 방지해야 함
		
		try {			
			arr[3] = 3;//존재하지 않는 인덱스() 배열의 범위를 넘음
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("오류 발생");			
		}
		
	}
}
