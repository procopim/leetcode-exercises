//3ms solution

class Solution {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int top = -1;
        for(String token : tokens){
            if (isOperator(token)){
                if (top >= 1){
                    int b = stack[top--];
                    int a = stack[top--];
                    top++;
                    if (token.equals("+")){
                        stack[top] = a+b;
                    }
                    else if (token.equals("-")){
                        stack[top] = a-b;
                    }
                    else if (token.equals("*")){
                        stack[top] = a*b;
                    }
                    else if (token.equals("/")){
                        stack[top] = a/b;
                    }
                }
                else{
                    return 0;
                }
            } else{
                top++;
                stack[top] = Integer.valueOf(token);
            }
        }
        return stack[top];
    }
    private boolean isOperator(String token){
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
}
//https://leetcode.com/problems/evaluate-reverse-polish-notation
