import java.util.Stack;

public class Brackets {
    class Solution {
        public int solution(String S) {
            if (S.isEmpty())
                return 1;

            char[] characters = S.toCharArray();
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < characters.length; i++) {
                if (!stack.empty()) {
                    if (isNested(stack.peek(), characters[i])) {
                        stack.pop();
                    } else {
                        stack.add(characters[i]);
                    }
                } else {
                    stack.add(characters[i]);
                }
            }

            if (stack.empty())
                return 1;

            return 0;
        }

        public boolean isNested(char a, char b) {
            if (a == '{' && b == '}')
                return true;
            if (a == '(' && b == ')')
                return true;
            if (a == '[' && b == ']')
                return true;

            return false;
        }
    }
}
