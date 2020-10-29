package designPattern.method;


/**
 * 工厂方法模式
 * @author root
 *
 */
public class FactoryMethod {
	
	public static void main(String[] args) {
		Application a=new ConcreteProductB();
		Product p=a.getObject();
		p.method();
	}

}

abstract class Application{
	
	abstract Product createProduct();
	
	Product getObject() {
		return createProduct();
	}
	
}

class ConcreteProductA extends Application{
	@Override
	Product createProduct() {
		return new ProductA();
	}
}

class ConcreteProductB extends Application{
	@Override
	Product createProduct() {
		return new ProductB();
	}
}

interface Product{
	public void method();
}

class ProductA implements Product{
	public void method() {
		System.out.println("hello productA.");
	}
}

class ProductB implements Product{
	public void method() {
		System.out.println("hello productB.");
	}
}



