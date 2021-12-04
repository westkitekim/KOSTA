package test.xml;

import java.io.FileWriter;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

/*
 *  XML ( Extensible Markup Language ) 
 *  : 특수한 목적의 언어를 생성하고 로딩하여 
 *    사용하고자 할 때 쓰는 마크업 언어.
 *    주 용도는 설정 정보와 데이터 전송 용도가 있다 
 *    Ajax 통신에서는 데이터 전송용으로 XML을 이용한다 
 *    
 *    아래 예제는 jdom 라이브러리를 이용해 xml 파일을 
 *    생성하는 예제 (디렉토리에서 확인)
 */
public class TestCreateXML {
	public static void main(String[] args) {
		//xml을 생성 
		Document myDocument=new Document();
		Element root=new Element("car");
		myDocument.setRootElement(root);
		root.addContent(new Element("model").addContent("SM6"));
		root.addContent(new Element("price").addContent("500"));
		//xml 파일로 출력 
		XMLOutputter xmlOut=new XMLOutputter();
		try {
			FileWriter fw=new FileWriter("C:\\kosta224\\test.xml");
			xmlOut.output(myDocument, fw);
			System.out.println("xml 생성");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
















