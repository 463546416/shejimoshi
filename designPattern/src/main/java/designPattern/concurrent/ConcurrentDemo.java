package designPattern.concurrent;

//并发
public class ConcurrentDemo {

	public static void main(String[] args) {
		//买票对象
		HuoChePiaoB r=new HuoChePiaoB();
		//多线程抢票
		new Thread(r,"德玛西亚").start();
		new Thread(r,"诺克萨斯").start();
		new Thread(r,"黄牛党").start();
	}

}

//模拟火车票，多线程时安全
class HuoChePiaoB implements Runnable{
	private static int chePiao=100;
	boolean b=true;	//外部停止
	@Override
	public void run() {
		while (b) {
			buy();
		}
	}
	
	private synchronized void buy() {
		if(chePiao<=0) {
			b=false;
			return;
		}
		//模拟延时
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		System.out.println(Thread.currentThread().getName()+"-->拿到了第"+chePiao--+"票！");
	}
	
	
}

//模拟火车票，多线程时不安全
class HuoChePiao implements Runnable{
	private static int chePiao=10;
	@Override
	public void run() {
		while (true) {
			if(chePiao<=0) {
				break;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"-->拿到了第"+chePiao--+"票！");
		}
	}
}
