package designPattern.method;

public class LazySingletonDemo {
	
	public static void main(String[] args) {
		
		//多线程
		new Thread(	()->{
			LazySingleton i=LazySingleton.getInstance();
			System.out.println(i);
		}).start();
		new Thread(	()->{
			LazySingleton i=LazySingleton.getInstance();
			System.out.println(i);
		}).start();
		
		//单线程没有问题
//		LazySingleton i1=LazySingleton.getInstance();
//		LazySingleton i2=LazySingleton.getInstance();
//		System.out.println(i1==i2);
	}

}

//懒汉模式
class LazySingleton{
	//使用volatile保证顺序正常（防止重排序）
	private volatile static LazySingleton instance;
	//防止外部进行实例化
	private LazySingleton(){
		
	}
	public static LazySingleton getInstance() {
		if(instance==null) {
			//解决多线程
			synchronized (LazySingleton.class) {
				//解决并发
				if(instance==null) {
					instance=new LazySingleton();
					//字节码层：正常顺序（分配空间，初始化，引用赋值）
					//可能2和3顺序对调出现下面情况
					//1.分配空间
					//2.引用赋值（多线程时：第一个线程走到这里，instance已经不为空，第二个线程可能会直接获取instance，因为没有初始化会出现空指针异常）
					//3.初始化
				}
			}
		}
		return instance;
	}
}