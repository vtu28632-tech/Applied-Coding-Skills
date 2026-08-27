public class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> remove = new HashSet<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') stack.push(i);
            else if (arr[i] == ')') {
                if (stack.isEmpty()) remove.add(i);
                else stack.pop();
            }
        }
        while (!stack.isEmpty()) remove.add(stack.pop());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (!remove.contains(i)) sb.append(arr[i]);
        }
        return sb.toString();
    }
}
