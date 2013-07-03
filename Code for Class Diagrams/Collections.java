//import java.util.*;
//
//public class Collections {
//
//    public static void main(String[] args) throws InterruptedException {
//
//	// JavaBeans!
////	FavBean a = new FavBean();
////	a.setSymbols("aaa");
////	a.setPrice(10.01);
////
////	FavBean b = new FavBean();
////	b.setSymbols("bbb");
////	b.setPrice(12.21);
////
////	FavBean c = new FavBean();
////	c.setSymbols("ccc");
////	c.setPrice(21.12);
////
////	FavBean z = new FavBean();
////	c.setSymbols("zzz");
////	c.setPrice(10000.03);
//
//	// HashMap
//	// http://www.tutorialspoint.com/java/java_hashmap_class.htm
//	HashMap<String, FavBean> myMap = new HashMap<String, FavBean>();
//	myMap.put("one", a);
//	myMap.put("two", b);
//	myMap.put("three", c);
//	
//	HashMap<String, FavBean> emptyMap = new HashMap<String, FavBean>();
//
//	// size() will return number of key/value pairs in the map.
//	System.out.println("size() will return number of key/value pairs in the map.\n\t"
//			+ myMap.size() + "\n");
//		
//	// keySet() will return all keys contained in the map.
//	System.out.println("keySet() return all keys contained in the map.\n\t"
//			+ myMap.keySet() + "\n");
//	
//	// values() will return collection view of values in map.
//	System.out.println("values() will return collection view of map. " 
//			+ "format is [mapValue, mapValue,...] if mapValue is an object then "
//			+ "[attr:attrValue attr:attrValue,...]\n\t"
//			+ myMap.values() + "\n");
//	
//	// entrySet() will return collection view of map.
//	System.out.println("entrySet() will return collection view of map. " 
//			+ "format is [mapKey=mapValue,...] if mapValue is an object then "
//			+ "[mapKey=(attr:attrValue attr:attrValue),...]\n\t"
//			+ myMap.entrySet() + "\n");
//
//	// containsKey() will return true if specified key is in map.
//	System.out.println("containsKey() will return true if specified key is in map.\n\t"
//			+ "(is in map) "
//			+ myMap.containsKey("one")
//			+ " (is NOT in map) "
//			+ myMap.containsKey("test")
//			+ "\n");
//
//	// containsValue() will return true if specified value is in map.
//	System.out.println("containsValue() will return true if specified value is in map.\n\t"
//			+ "(is in map) "
//			+ myMap.containsValue(a)
//			+ " (is NOT in map) " + myMap.containsValue(z) + "\n");
//	
//	// targetMap.putAll(sourceMap) will copy and paste from one map to another.
//	emptyMap.putAll(myMap);
//	System.out.println("putAll() will copy and paste from one map to another.\n\t" 
//			+ "emptyMap.entrySet() -> "+emptyMap.entrySet() + "\n");
//	
//	// clear() will remove all contents from map. (like TRUNCATE)
//	emptyMap.clear();
//	System.out.println("clear() will remove all contents from map. (like TRUNCATE)\n\t" 
//			+ "emptyMap.isEmpty() ? -> "+emptyMap.isEmpty() + "\n");
//	
//	// isEmpty() will return true if map is empty.
//	System.out.println("isEmpty() will return true if map is empty.\n\t"
//			+ "(map is empty) "
//			+ emptyMap.isEmpty()
//			+ " (map is NOT empty) " + myMap.isEmpty() + "\n");
//	
//	// clone() will make shadow copy.
//	HashMap shadow = (HashMap) myMap.clone();
//	shadow.put("z", z);
//	System.out.println("clear() will remove all contents from map. (like TRUNCATE)\n\t"
//			+ "myMap.keySet() ? -> "+myMap.keySet() + "\n\t"
//			+ "shadow.keySet() ? -> "+shadow.keySet() + "\n");
//	
//	// remove(key)
//	
//	
//	// get
//	
//
//	
//	
//	
//	
//	
//	// ArrayList Example
//	// http://www.tutorialspoint.com/java/java_arraylist_class.htm
//	// ArrayList<FavoriteBean> myAList = new ArrayList<FavoriteBean>();
//	// myAList.add(a);
//	// myAList.add(b);
//	// myAList.add(c);
//
//	// for (FavoriteBean o : myAList)
//	// System.out.println(o.getSymbol());
//
//	// TreeSet
//	// http://www.tutorialspoint.com/java/java_treeset_class.htm
//
//	// LinkedList
//	// http://www.tutorialspoint.com/java/java_linkedlist_class.htm
//
//	// TreeMap
//
//    }
//
//}
