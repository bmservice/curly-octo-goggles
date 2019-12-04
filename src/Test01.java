import java.util.*;

public class Test01 {
    public static void main(String[] args) {
        HashMap<Integer,User> userHashMap=new HashMap<>();
        userHashMap.put(1,new User(12,"张"));
        userHashMap.put(2,new User(7,"里"));
        userHashMap.put(3,new User(8,"张ji"));
        userHashMap.put(4,new User(9,"胡"));
        System.out.println(userHashMap);
        HashMap<Integer,User> sortHash=sort(userHashMap);
        System.out.println(sortHash);
    }
    public static HashMap<Integer,User> sort(HashMap<Integer,User> map){
        Set<Map.Entry<Integer,User>> set=map.entrySet();
        List<Map.Entry<Integer,User>> list=new ArrayList<>(set);
        Collections.sort(list, new Comparator<Map.Entry<Integer, User>>() {
            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                return o2.getValue().getAge()-o1.getValue().getAge();
            }
        });
        LinkedHashMap<Integer,User> linkedHashMap=new LinkedHashMap<>();
        for (Map.Entry<Integer,User> entry:list){
            linkedHashMap.put(entry.getKey(),entry.getValue());
        }
        return linkedHashMap;
    }
}
