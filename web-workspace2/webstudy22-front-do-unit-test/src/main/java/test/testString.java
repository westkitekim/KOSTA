package test;
//substring 연습예제
public class testString {
	public static void main(String[] args) {
		String uri="/webstudy22-front-do-unit-test/FindController.do";
		//FindController만 추출하기 
		//substring : index는 0부터 시작, begin index 부터 end index 앞까지 출력(index는 포함되지 않는다)
		//substring은 index가 0부터 시작해서 첨차값만으로는 마치 index는 포함하지 않는 사이값 추출하는 것처럼 보이므로 주의할 것
		//위 uri 에서 context path 인 /webstudy22-front-do-unit-test 와 .do 를 제외한 문자열을 추출
		String contextPath = "/webstudy22-front-do-unit-test";//서버에서 구할 수 있는 url
		System.out.println(contextPath.length());//30
		System.out.println(uri.substring(contextPath.length() + 1));//FindController.do 반환, +1 하면 / 제외
		//practice
		String name = "디카프리오";
		System.out.println(name.substring(2, 4));//beginIndex 2부터(프) endIndex 4 앞까지(리) 이므로 "프리" 반환
		System.out.println(uri.length());//48
		System.out.println(uri.length() - 3);//45
		//아래 코드에 45가 들어가는 것 uri.length() - 3
		System.out.println(uri.substring(0, uri.length() - 3));//0부터 .do 앞까지 추출 /webstudy22-front-do-unit-test/FindController 반환
		System.out.println(uri.substring(contextPath.length() + 1, uri.length() - 3));//start,end index
		System.out.println("*****************구분선*****************");
		String str1 = "/kosta/RegController.do";
		String context = "/kosta";
		System.out.println(str1.substring(6));//반환:	/RegController.do
		System.out.println(str1.substring(6+1));//반환: RegController
		System.out.println(context.length());// 6
		System.out.println(str1.substring(context.length() + 1));// beginIndex 는 7로 할당 ( index 는 0부터 시작하므로 R부터 시작 ) RegController.do
		System.out.println(str1.length());//23
		System.out.println(str1.substring(0, 23 - 3)); // endIndex를 20으로 할당하면 /kosta/RegController 즉 .do 를 제외, 0부터 시작해 20 index 앞까지 
		System.out.println(str1.substring(context.length() + 1, str1.length() - 3));//RegController
		//
		String str2 = "/a/b.do";
		String context2 = "/a";
		System.out.println(str2.substring(3, 4));// b만 추출해본다, 직접 index를 입력
		int beginIndex = context2.length() + 1;//3
		int endIndex = str2.length() - 3;//7 - 3 = 4
		System.out.println(str2.substring(beginIndex, endIndex));
		//풀어서 표현하면
		System.out.println(str2.substring(context2.length() + 1, str2.length() - 3));
		
		
	}
}
