package designs;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LRUCache implements ICache
{
	LRUHash   cache = null;
	protected ReentrantReadWriteLock      lock = new ReentrantReadWriteLock() ;
	protected Lock                        readLock = lock.readLock() ;
	protected Lock                        writeLock = lock.writeLock() ;
	int capacity = 5;
	
	public LRUCache(int capacity)
	{
		this.capacity = capacity;
		cache = new LRUHash(capacity);
	}
	
	@Override
	public Object get(Object key) {
		if (key == null)
		    return null;
		
		readLock.lock();
		Object val = null;
		try
		{
		   val = cache.get(key);
		   readLock.unlock();
		}
		catch (Throwable E)
		{
			readLock.unlock();
		}
		return val;
	}

	@Override
	public boolean put(Object key, Object val) {
		writeLock.lock();
		
		if (key == null)
			return false;
		
		try
		{
			cache.put(key, val);
			writeLock.unlock();
			return true;
		}
		catch(Throwable t)
		{
			writeLock.unlock();
		}
		return true;
	}
}

class LRUHash extends LinkedHashMap<Object,Object>
{
	/**
	 * Serial version UID. 
	 */
	private static final long serialVersionUID = -7203399589561987796L;
	int capacity ;
	public LRUHash(int capacity)
	{
		super(capacity);
		this.capacity = capacity;
	}
	
	public boolean removeEldestEntry(Entry<Object,Object> eldest)
	{
		boolean remove = size() > capacity;
		return remove;
	}
}