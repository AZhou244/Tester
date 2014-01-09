package hashmap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.AbstractMap.SimpleEntry;

/**
 * An academic map that does not support null keys or values and makes no guarantees about run time.
 */
public class MyHashMap<K,V>
{
	private ArrayList<LinkedList<Map.Entry<K, V>>> theBuckets;
	private int size; // number of mappings

	private static final int CAPACITY = 100; // number of buckets
	
	public MyHashMap()
	{
		
	}

	public int size()
	{
		return -1;
	}

	public boolean containsKey(Object key)
	{
		return false;
	}
	
	public V put(K key, V value)
	{
		return null;
	}
	
	public V get(Object key)
	{
		return null;
	}

	public V remove(Object key)
	{
		return null;
	}
	
	public Set<K> keySet()
	{
		return null;
	}	

	/**
	 * @return the index (for theBuckets) of the specified key, 0 if null.
	 */
	private int getIndex(Object key)
	{
		return -1;
	}

	/**
	 * @return the entry corresponding to the specified key, or null if no entry exists.
	 */
	private Map.Entry<K, V> getEntry(Object key)
	{
		return null;
	}
}
