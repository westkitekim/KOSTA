package test.xml;

import java.io.File;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

// xml 파일로부터 정보를 입력받아 확인하는 예제 
public class TestReadXML {
	public static void main(String[] args) {
		String path="C:\\kosta224\\test.xml";
		try {
			Document loadDocument=new SAXBuilder().build(new File(path));
			Element element=loadDocument.getRootElement();
			System.out.println(element.getName());
			@SuppressWarnings("unchecked")
			List<Element> list=element.getContent();
			for(int i=0;i<list.size();i++) {
				Element e=list.get(i);
				System.out.println(e.getName()+" "+e.getText());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}



















