package model;

public class Employee {
	//사원번호가 number라서 number로 관리해도 되고 String 으로 해도 됨 
	//변경되지 않는 고정값이ㄴ면 String 으로 해도 무방하다 , 호환된다 
	private String empno;
	private String name;
	private String job;
	//월급은 application에서 활용가능하기 때문에(연산 etc) int 타입으로 해준다//개발자 마음
	private int salary; 
	
	//한명의 사원 등록시 empno는 자동발급 되어 필요 없을 수 있다 sequence 
	//매개 변수 있는 생성자가 존재하면 기본생성자는 더 이상 들어가지 않기 때문에 필요에 의해 작성. 
	//기본생성자 명시해주명 setter, getter 메서드에 접근하기 위함 
	//일일이 오버라이딩 하기 보다는 set으로 세팅, ? 
	public Employee() {
		super();
		
	}
	//empno는 시퀀스를 통해 자동발급 되므로 필요 없다 (넣어도 되긴 함) 
	//아래 생성자는 사원정보 생성시에 필요한 생성자 
	public Employee(String name, String job, int salary) {
		super();
		this.name = name;
		this.job = job;
		this.salary = salary;
	}
	//전체 조회 시에 필요한 생성자 
	public Employee(String empno, String name, String job, int salary) {
		super();
		this.empno = empno;
		this.name = name;
		this.job = job;
		this.salary = salary;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", name=" + name + ", job=" + job + ", salary=" + salary + "]";
	}
	
	
	
	
}





































