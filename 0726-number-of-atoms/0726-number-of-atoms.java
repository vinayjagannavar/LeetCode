public class Solution {
    static class Pair {
        String element;
        int count;
        public Pair(String element, int count) {
            this.element = element;
            this.count = count;
        }
    }

    public String countOfAtoms(String formula) {
        Stack<Pair> stack = new Stack<>();
        Map<String, Integer> map = new TreeMap<>();
        int i = 0, n = formula.length();

        while (i < n) {
            if (formula.charAt(i) == '(') {
                stack.push(new Pair("(", 0));
                i++;
            } else if (formula.charAt(i) == ')') {
                List<Pair> temp = new ArrayList<>();
                i++;
                int num = 0;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    num = num * 10 + (formula.charAt(i) - '0');
                    i++;
                }
                num = (num == 0) ? 1 : num;

                while (!stack.peek().element.equals("(")) {
                    Pair p = stack.pop();
                    p.count *= num;
                    temp.add(p);
                }
                stack.pop();  // remove the "("
                for (Pair p : temp) {
                    stack.push(p);
                }
            } else {
                int start = i++;
                while (i < n && Character.isLowerCase(formula.charAt(i))) i++;
                String element = formula.substring(start, i);

                int num = 0;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    num = num * 10 + (formula.charAt(i) - '0');
                    i++;
                }
                num = (num == 0) ? 1 : num;

                stack.push(new Pair(element, num));
            }
        }

        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            map.put(p.element, map.getOrDefault(p.element, 0) + p.count);
        }

        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result.append(entry.getKey());
            if (entry.getValue() > 1) {
                result.append(entry.getValue());
            }
        }
        return result.toString();
    }
}