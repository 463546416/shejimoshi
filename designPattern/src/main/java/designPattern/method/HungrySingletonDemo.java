package designPattern.method;

public class HungrySingletonDemo {
	
	public static void main(String[] args) {
		HungrySingleton h1=HungrySingleton.getInstance();
		HungrySingleton h2=HungrySingleton.getInstance();
		System.out.println(h1==h2);
		
	}
	
	
}

//饿汉模式（利用jvm类加载机制）
class HungrySingleton{
	private static HungrySingleton instance=new HungrySingleton();
	private HungrySingleton(){
		//防止反射创建多个实例（懒汉模式不能防止）
		if(instance!=null) {
			throw new RuntimeException(" 单例不允许多个实例 ");
		}
	}
	public static HungrySingleton getInstance() {
		return instance;
	}
}






