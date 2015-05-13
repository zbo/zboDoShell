package safenet;

import java.util.*;

public class someTestMain {
    public static void main(String[] args){
        //testList();
        //testHashSet();
        //testHashMap();
        //testHashTable();
        //testArray();
    }

    private static void testArray() {
        Integer[] array={1,2,3,4,5,6,2,7,9};
        System.out.println(array.length);
        System.out.println(array[5]);
        List<Integer> list= Arrays.asList(array);
    }

    private static void testList() {
        List<String> myList=new ArrayList<String>();
        myList.size();
        myList.add("aaa");
        myList.add("bbb");
        myList.indexOf("aaa");
        myList.remove("aaa");
        myList.iterator();
        Iterator<String> itor=myList.iterator();
        while(itor.hasNext()){
            System.out.println(itor.next());
        }
        System.out.println(myList.get(0));
    }

    private static void testHashSet() {
        HashSet<String> mySet=new HashSet<String>();
        mySet.add("AAA");
        mySet.add("AAA");
        mySet.add("BBB");
        System.out.println(mySet.size());
        Iterator<String> itor=mySet.iterator();
        while(itor.hasNext()){
            System.out.println(itor.next());
        }
        mySet.remove("AAA");
        mySet.contains("AAA");
    }

    private static void testHashMap() {
        HashMap<Integer,String> map=new HashMap<Integer, String>();
        boolean contains = map.containsKey(1);
        map.size();
        System.out.println(contains);
        for(Integer key:map.keySet()){
            System.out.println(map.get(key));
        }
        for(Map.Entry<Integer,String> entry : map.entrySet()){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }

    private static void testHashTable() {
        Integer[] arrayInput={1,2,3,4,5,7};
        List<Integer> intList = Arrays.asList(arrayInput);
        intList.get(2);
        Hashtable<Integer,String> myHash=new Hashtable<Integer,String>();
        myHash.put(1,"ssss");
        myHash.put(2, "kkkk");
        myHash.size();
        for(Integer key : myHash.keySet()){
            System.out.println(myHash.get(key));
        }
        for(Map.Entry<Integer,String> enrty:myHash.entrySet()){
            System.out.println(enrty.getKey()+"="+enrty.getValue());
        }
    }
}
