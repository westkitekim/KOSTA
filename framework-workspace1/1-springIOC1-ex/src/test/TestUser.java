package test;

import model.Hammer;
import model.Tool;

/**
 * ▣ 기존 제어방식 
 *   - 사용자가 망치(컴포넌트)를 사용하기 위해서는 Hammer 객체를 생성하고 work를 호출
 *     만약 도구를 삽으로 변경해야 한다면 객체 생성부를 수정하여 
 *     new Spade() 를 명시해야 한다.
 *   - 추상화 or 계층구조화 or 캡슐화가 되어있지 않다면 메서드 호출부 또한 변경해야 한다
 *     
 *   - 이러한 경우 도구(or 컴포넌트<시스템이 필요한 부품>)가 변경될 때마다 
 *     해당 코드 부분의 수정은 불가피하다.
 *     
 *     => 사용자 측과 도구(컴포넌트) 측과의 결합도가 높은 상태( 낮은 유지보수성 )
 *   
 *   - 계층구조화를 통해 메서드 또는 소통방식의 표준화를 시킨다
 *     ▷ Interface : Tool
 *     ▷ abstract method : work() 
 *     
 *     => 표준화를 시켜도 객체 생성부분 클래스는 매번 변경해줘야하는 단점이 있다.
 *     => 현 구조에서는 컴포넌트를 변경할 때 코드 수정은 불가피하다.
 * ▣ 
 *
 *
 */
public class TestUser {
	public static void main(String[] args) {
		Tool tool = new Hammer();//처음 사용하던 방식, 더 나아간다면 Singleton
		//tool.work();//망치 도구로 일하다
		
		//삽으로 일하고 싶을 경우 
		//Tool tool = new Spade();//처음 사용하던 방식, 더 나아간다면 Singleton
		tool.work();//망치 도구로 일하다
		
	}
}
