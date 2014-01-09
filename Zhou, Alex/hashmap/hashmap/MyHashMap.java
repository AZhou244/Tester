package hashmap;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
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
		theBuckets = new ArrayList<LinkedList<Map.Entry<K, V>>>(CAPACITY);

		Map.Entry<K, V> newEntry =null;
		LinkedList<Map.Entry<K, V>> empty = new LinkedList<Map.Entry<K, V>>();
		empty.add(newEntry);
		
		for (int x =0; x<CAPACITY; x++){
			theBuckets.add(x,empty);		
		}
		size =0;
	}

	public int size()
	{
		return size;
	}

	public boolean containsKey(Object key)
	{
		return getEntry(key) != null;
	}
	
	public V put(K key, V value)
	{
		if (key == null)
			throw new NullPointerException();
				
		Map.Entry<K, V> newEntry = new AbstractMap.SimpleEntry <K, V>(key, value);
		Map.Entry<K, V> entry = getEntry(key);
		int indexOfBucket = getIndex(key);
		V oldValue = null;
		
		if (theBuckets.get(indexOfBucket).get(0) == null){		//if bucket is empty
			theBuckets.get(indexOfBucket).set(0, newEntry);
			size++;
			return oldValue;
		}
		if (entry != null){					//if key already exists empty
			oldValue = entry.getValue();
			entry.setValue(value);
			return oldValue;
		}
		
		theBuckets.get(indexOfBucket).add(newEntry);
		size++;
		return oldValue;
			}
	
	public V get(Object key)
	{
		
		Map.Entry<K, V> entry = getEntry(key);
			if (entry == null)
			return null;
		return entry.getValue();   
	}

	public V remove(Object key)
	{

		Map.Entry<K, V> entry = getEntry(key);
		if (entry == null){
			return null;
		}
		int indexOfBucket = getIndex(key);
		V oldValue = null;
		oldValue = entry.getValue();
		theBuckets.get(indexOfBucket).remove(entry);
		if (theBuckets.get(indexOfBucket).size()==0){
			theBuckets.get(indexOfBucket).add(null);
		}
		return oldValue;
	}
	
	public Set<K> keySet()
	{

		Set<K> keySet = new HashSet<K>();
			
		for (int x =0; x<theBuckets.size(); x++){
			Iterator<Entry<K, V>> itr = theBuckets.get(x).iterator();
			while (itr.hasNext()){
				Map.Entry<K, V> entry = itr.next();
				if (entry!= null && (entry.getKey()!= null)){
					keySet.add(entry.getKey());
				}
			}
		}
		return keySet;
	}	

	/**
	 * @return the index (for theBuckets) of the specified key, 0 if null.
	 */
	private int getIndex(Object key)
	{
		if (key == null)
			throw new NullPointerException();
		int h = key.hashCode();
		if (h<0) 
			h = -h;
		int bucketIndex = h % CAPACITY;
		return bucketIndex;   
	
	}

	/**
	 * @return the entry corresponding to the specified key, or null if no entry exists.
	 */
	private Map.Entry<K, V> getEntry(Object key)
	{
		if (key == null){
			throw new NullPointerException();
		}
		Map.Entry<K, V> entry;
		int indexOfBucket = getIndex(key);
		if (theBuckets.get(indexOfBucket).get(0) == null)		//if bucket is empty
			return null;
		else{
			for (int x =0; x<theBuckets.get(indexOfBucket).size(); x++){
				entry = theBuckets.get(indexOfBucket).get(x);
				if(entry!= null && key.equals(entry.getKey())){
					return entry;
				}
			}
		}
		return null;
	
	}
}
