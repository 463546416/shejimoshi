package designPattern.method;

public class InnerClassSingletonDemo {
	
	public static void main(String[] args) {
		
	}

}

//静态内部类模式,延迟加载，调用getInstance才初始化（利用jvm类加载机制）
class INnerClassSingleton{
	private static class InnerClassHolder{
		private static INnerClassSingleton instance=new INnerClassSingleton();
	}
	private INnerClassSingleton() {
		//防止反射创建多个实例
		if(InnerClassHolder.instance!=null) {
			throw new RuntimeException(" 单例不允许多个实例 ");
		}
	}
	public static INnerClassSingleton getInstance() {
		return  InnerClassHolder.instance;
	}
}