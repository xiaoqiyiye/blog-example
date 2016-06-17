package seven.xiaoqiyiye.spring.cache;

public class Hello {

	String name;

	public Hello(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Hello," + name;
	}
	
}
