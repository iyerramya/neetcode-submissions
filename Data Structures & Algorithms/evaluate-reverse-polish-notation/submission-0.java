class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        for(String token : tokens) {
            if(!operators.contains(token)) {
                stack.push(Integer.valueOf(token));
            } else {
                int element2 = stack.pop();
                int element1 = stack.pop();
                int res = 0;
                switch(token) {
                    case "+": {
                        res += element1+element2;
                        break;
                        }
                     case "-": {
                        res += element1-element2;
                        break;
                        }
                     case "*": {
                        res += element1*element2;
                        break;
                        }
                     case "/": {
                        res += element1/element2;
                        break;
                        }
                }
                stack.push(res);
            }
        }
        return stack.pop();
    }
}
