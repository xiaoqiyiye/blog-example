package seven.xiaoqiyiye.spring.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

	/**
	 * 以Hello#name属性域作为缓存key（不管缓存是否存在，都会去执行）
	 * @param hello
	 * @return
	 */
	@CachePut(value="hello", key="#hello.name")
	public Hello put(Hello hello){
		System.out.println("put Hello:" + hello.getName());
		return hello;
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	@Cacheable(value="hello", key="#name")
	public Hello get(String name){
		System.out.println("new Hello:" + name);
		return new Hello(name);
	}
	
	/**
	 * 
	 * @param name
	 */
	@CacheEvict(value="hello", key="#name")
	public void remove(String name){
		System.out.println("remove Hello:" + name);
	}
	
	/**
	 * 
	 */
	@CacheEvict(value="hello", allEntries=true)
	public void removeAll(){
		System.out.println("remove all!");
	}
}
