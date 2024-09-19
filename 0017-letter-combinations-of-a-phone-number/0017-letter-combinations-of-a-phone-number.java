class Solution {    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }
        Map<Character, String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        backtrack(digits, result, new StringBuilder(), 0, digitToLetters);
        return result;
    }

    public void backtrack(String digits, List<String> result, StringBuilder sb, int idx, Map<Character, String> digitToLetters) {
        if (digits.length() == idx) {
            result.add(sb.toString());
            return;
        }
        String letters = digitToLetters.get(digits.charAt(idx));
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            backtrack(digits, result, sb, idx+1, digitToLetters);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}