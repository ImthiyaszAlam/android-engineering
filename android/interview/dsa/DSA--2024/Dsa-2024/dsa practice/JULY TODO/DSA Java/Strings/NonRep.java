import java.util.*;

import javafx.scene.web.WebHistory.Entry;
public class NonRep {
    public static void main(String[] args) {
        String str = "learning";
        Map<Character,Integer> map = new LinkedHashMap();
        for(char ch:str.toCharArray()){
            map.put(ch,map.containsKey(ch)?map.get(ch)+1:1);
        }
        for(Entry<Character,Integer>entry:map.entrySet() ){
            if (entry.getValue == 1) {
                System.out.println(entry.getKey());
            }
        }

        
    }
}
