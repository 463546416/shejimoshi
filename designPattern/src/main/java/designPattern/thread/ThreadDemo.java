package designPattern.thread;

//简单多线程创建
public class ThreadDemo {

	public static void main(String[] args) {

		//创建线程
		ThreadA a=new ThreadA();
		ThreadB b=new ThreadB();
		//开启线程
		a.start();
		b.start();
		
	}

}

//继承thread，重写run
class ThreadA extends Thread{
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("我是threadA："+i);
		}
	}
}

class ThreadB extends Thread{
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("我是threadB："+i);
		}
	}
}