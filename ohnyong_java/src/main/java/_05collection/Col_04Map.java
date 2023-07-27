package _05collection;

import java.util.HashMap;
import java.util.Map;

public class Col_04Map {
    public static void main(String[] args) {
        //Map
        /*
        * Key - Value 쌍(pair)로 존재한다 중요.
        *
        * key라는 값으로 Unique하게 보장돼야 함.
        * Map -> HashMap, TreeMap으로 응용
        *
        * */

        Map<String, Integer> intMap = new HashMap<>();

        //Key 값
        intMap.put("일", 11);
        intMap.put("이", 12);
        intMap.put("삼", 11);
        intMap.put("사", 13); // 중복 key
        intMap.put("사", 12); // 중복 key

        //key 값 전체 출력(향상된 for문)
        for (String key: intMap.keySet()){
            System.out.println(key);
        }
        //value 값 전체 출력 (향상된 for문)
        for (Integer value: intMap.values()){
            System.out.println(value);
        }
        //위 중복 key에서 뒤에 실행된 value가 12인 코드가 위 13을 덮어 써서 12가 출력된다.

        //key로부터 값 가져오기. get()
        System.out.println(intMap.get("삼"));
    }
}
