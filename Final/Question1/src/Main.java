import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String[] arr = {"eat","tea","tan","ate","nat","bat"};
        ArrayList<ArrayList<String>> groupedAnagrams = groupAnagrams(arr);
        System.out.printf("[");
        for(ArrayList<String> anagram : groupedAnagrams){
            System.out.printf("[");
            for(String str : anagram){
                System.out.printf("\""+str+"\",");
            }
            System.out.printf("],");
        }
        System.out.printf("]");
    }

    public static ArrayList<ArrayList<String>> groupAnagrams(String[] arr) {
        ArrayList<ArrayList<String>> groupedAnagrams = new ArrayList<>();
        HashMap<String, ArrayList<String>> hm = new HashMap<>();

        for (String str : arr) {
            char[] strChs = str.toCharArray();
            Arrays.sort(strChs);
            String anagram = String.valueOf(strChs);

            if(!hm.containsKey(anagram)){
                ArrayList<String> anagramGroup = new ArrayList<>();
                anagramGroup.add(str);
                hm.put(anagram, anagramGroup);
            }
            else{
                ArrayList<String> anagramGroup = hm.get(anagram);
                anagramGroup.add(str);
                hm.put(anagram, anagramGroup);
            }
        }

        for (ArrayList<String> anagramGroup: hm.values()) {
            groupedAnagrams.add(anagramGroup);
        }

        return groupedAnagrams;
    }
}


//time complexity: O(n)
//space complexity: O(n)