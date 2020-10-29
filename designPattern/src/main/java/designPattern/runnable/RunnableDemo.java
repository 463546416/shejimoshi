package designPattern.runnable;

public class RunnableDemo {

	public static void main(String[] args) {
		//创建runnable接口实现类对象
		RunnableA a=new RunnableA();
		RunnableB b=new RunnableB();
		//创建线程
		Thread ta=new Thread(a);
		Thread tb=new Thread(b);
		//开启线程
		ta.start();
		tb.start();
	}

}

class RunnableA implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("我是RunnableA："+i);
		}
	}
	
}

class RunnableB implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("我是RunnableB："+i);
		}
	}
	
}