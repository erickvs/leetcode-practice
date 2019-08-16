package easy;

public class RemoveOuterParenthesesProblem {
    public String removeOuterParentheses(String S) {
        StringBuilder s = new StringBuilder();
        int opened = 0;
        for (char c : S.toCharArray()) {
            if (c == '(' && opened++ > 0) s.append(c);
            if (c == ')' && opened-- > 1) s.append(c);
        }
        return s.toString();
    }

    public String removeOuterParenthesesLong(String S) {
        StringBuilder sb = new StringBuilder();
        boolean isInnerParentheses = false;
        int count = 0;
        for (int index = 0; index < S.length(); index++) {
            char currentParentheses = S.charAt(index);
            count = currentParentheses == '(' ? ++count : --count;
            if (count >= 2) {
                sb.append(currentParentheses);
            }
            else {
                if ( !isInnerParentheses && count == 1 ) {
                    isInnerParentheses = true;
                    continue;
                }
                if ( isInnerParentheses && count == 0  ) {
                    isInnerParentheses = false;
                    continue;
                }
                sb.append(currentParentheses);
            }
        }
        return sb.toString();
    }
}
