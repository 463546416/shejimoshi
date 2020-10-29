package designPattern.method;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

	public static void main(String[] args) {
		Map<String,String> map=null;
		for (int i = 0; i < 100; i++) {
			map=new HashMap<String,String>();
			map.put(i+"", i+"");
			System.out.println(map.hashCode());
		}
	}

}

class getstudent{
	
	private static student s=new student();
	
	private getstudent() {}
	
	public static student get() {
		return s;
	}
}

class student{
	private String code;
	private String name;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}



