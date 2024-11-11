package designs;

public class Client 
{
    public static void main(String args[])
    {
    	ICache cache = new LRUCache(5);
    	
    	cache.put("x", "Hello");
    	cache.put("y", "Hi");
    	
    	System.out.println("x: "+cache.get("x").toString());
    	System.out.println("y: "+cache.get("y").toString());
    	
    	cache.put(100, new Emp(1,"Jai",1100000));   
    	cache.put(101, new Emp(2,"Dev",1200000)); 
    	cache.put(102, new Emp(3,"Man",100001)); 
    	cache.put(103, new Emp(4,"Rai",100002)); 
    	cache.put(104, new Emp(5,"Pia",1000003)); 
    	cache.put(105, new Emp(6,"Sia",1000004)); 
    	
    	//System.out.println(cache.get(100).toString());
    	System.out.println(cache.get(101).toString());
    	System.out.println(cache.get(102).toString());
    	System.out.println(cache.get(103).toString());
    	System.out.println(cache.get(104).toString());
    	System.out.println(cache.get(105).toString());
    }
}
class Emp
{
	int id;
	String name;
	int salary;
	
	public Emp(int id,String name, int sal)
	{
		this.id = id;
		this.name = name;
		this.salary = sal;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
}