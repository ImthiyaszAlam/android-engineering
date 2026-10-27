import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {

    static String findOrder(String[] words) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int inDegreee[] = new int[26];

        boolean exists[] = new boolean[26];
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                exists[ch - 'a'] = true;
            }
        }

        for(int i=0;i<i+1<words.length;i++){
            String w1 = words[i];
            String w2 = words[i+1];
            int len = Math.min(w1.length(),w2.length());
            int j = 0;

            while (j<len && w1.charAt(j)==w2.charAt(j)) {
                j++;
            }
            if (j<len) {
                int u = w1.charAt(j)-'a';
                int v = w2.charAt(j)-'a';
                graph.get(u).add(v);
                inDegreee[v]++;
            }else if (w1.length()>w2.length()) {
                return "";
            }
            
        }

        Queue<Integer>q  = new LinkedList<>();
        for(int i=0;i<26;i++){
            if (exists[i] && inDegreee[i]==0) {
                q.offer(i);
            }
        }

    }

    public static void main(String[] args) {
        String[] words={"a","b","c"}
        System.out.println(findOrder(words))
    }
}
