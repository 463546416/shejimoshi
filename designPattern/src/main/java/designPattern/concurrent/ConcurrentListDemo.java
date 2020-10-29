package designPattern.concurrent;

import java.util.ArrayList;
import java.util.List;

//线程不安全的集合
public class ConcurrentListDemo {

	public static void main(String[] args) {
		
		//线程安全，加到10000
		List<String> list=new ArrayList<String>();
		for (int i = 0; i < 10000; i++) {
			new Thread(()->{
				synchronized (list) {
					list.add(Thread.currentThread().getName());
				}
			}) .start();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(list.size());
		
		
		
		//线程不安全，可能没加到10000
//		List<String> list=new ArrayList<String>();
//		for (int i = 0; i < 10000; i++) {
//			new Thread(()->{
//				list.add(Thread.currentThread().getName());
//			}) .start();
//		}
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println(list.size());
	}

}
