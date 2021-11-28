package model;
//IOC 적용시 spring container 가 singleton을 운용해주기 때문에 별도의 singleton 생성이 필요없다
public class MemberDAOImplVer2 implements MemberDAO {
	@Override
	public String findMemberById(String id) {
		if(id.equals("java")) {
			return "java 아이유 오리 ver2 검색기능향상";
		}
		else
			return null;
	}
}
