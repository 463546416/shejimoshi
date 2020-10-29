package designPattern.method;

//静态代理模式
//真是对象和代理对象都要实现一个接口
public class StaticProxy {

	public static void main(String[] args) {
		GongSi g=new GongSi(new You());
		g.HappyMarry();
	}

}

interface Marry{
	public void HappyMarry();
}

//真是对象
class You implements Marry{
	@Override
	public void HappyMarry() {
		System.out.println("德玛要结婚了，超开心！");
	}
}

//代理对象
class GongSi implements Marry{
	
	private Marry marry;
	
	public GongSi(Marry marry) {
		this.marry=marry;
	}
	
	@Override
	public void HappyMarry() {
		qian();
		this.marry.HappyMarry();
		hou();
	}
	
	public void qian() {
		System.out.println("结婚前准备，布置现场！");
	}
	public void hou() {
		System.out.println("结婚后准备，尾款结算！");
	}
	
}
