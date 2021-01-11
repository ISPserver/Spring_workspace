package com.koreait.fashionshop.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/*앞으로 로그인이 필요한 서비스 여부를 처리하기 위한 코드는, 컨트롤러에 두지 않고
 * 지금 이 객체로 공통화 시켜 AOP를 적용할 것*/
public class MemberSessionCheckAspect {
	public Object sessionCheck(ProceedingJoinPoint joinPoint) {
		return null;
	}
}
