package designs;

public interface ICache 
{
    public Object get(Object key);
    public boolean put(Object key, Object val);
}
