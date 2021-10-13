package model;
//step-sequence.sql 사용
public class GuestBookDTO {
	//sql의 number는 int, long, String 등 가능
	//sql파일의 guestbook_no 변수의 언더바와 카멜케이스가 연동
	//guestbook_no로 사용하지 않는다 ==> CamelCase 사용!
	private int guestbookNo;
	private String title;
	private String content;
	public GuestBookDTO() {//기본생성자
		super();
		
	}
	//insert시 사용 
	public GuestBookDTO(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	public GuestBookDTO(int guestbookNo, String title, String content) {
		super();
		this.guestbookNo = guestbookNo;
		this.title = title;
		this.content = content;
	}
	public int getGuestbookNo() {
		return guestbookNo;
	}
	public void setGuestbookNo(int guestbookNo) {
		this.guestbookNo = guestbookNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "GuestBookDTO [guestbookNo=" + guestbookNo + ", title=" + title + ", content=" + content + "]";
	}
	
	
}
