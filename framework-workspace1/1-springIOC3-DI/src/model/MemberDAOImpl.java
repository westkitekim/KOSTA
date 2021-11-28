package model;
//IOC 적용시 spring container 가 singleton을 운용해주기 때문에 별도의 singleton 생성이 필요없다
public class MemberDAOImpl implements MemberDAO {
	@Override
	public String findMemberById(String id) {
		if(id.equals("java")) {
			return "java 아이유 오리";
		}
		else
			return null;
	}
}
