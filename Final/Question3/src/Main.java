import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(getValidString("a)b(c)d"));
    }

    private static String getValidString(String str) {
        Stack<Integer> parenthesesStack = new Stack<>();
        ArrayList<Integer> invalidIndexes = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                parenthesesStack.push(i);
            }
            else if (str.charAt(i) == ')') {
                if (parenthesesStack.isEmpty()) {
                    invalidIndexes.add(i);
                }
                else {
                    parenthesesStack.pop();
                }
            }
        }

        while (!parenthesesStack.isEmpty()) {
            invalidIndexes.add(parenthesesStack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (!invalidIndexes.contains(i)) {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }

}

//time complexity : O(n)
//space complexity : O(n)