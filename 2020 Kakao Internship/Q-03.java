import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_formula {

    private static List<Long> nums = new ArrayList<>();
    private static List<Character> operands = new ArrayList<>();
    private static List<char[]> operandOrders = new ArrayList<>();

    private static List<Long> tmpNums;
    private static List<Character> tmpOperands;

    private static long answer;

    public long solution(String expression) {
        parseExpression(expression);
        calcMaxResult();
        return answer;
    }

    private void parseExpression(String expression) {
        seperateNumsAndOperands(expression);
        char[] tmpOperandType = checkOperandTypes();
        doPermutationForOperandOrders(tmpOperandType, 0);
    }

    private void seperateNumsAndOperands(String expression) {
        StringBuilder sb = new StringBuilder();
        for (char ch : expression.toCharArray()) {
            if (ch == '+' || ch == '-' || ch == '*') {
                nums.add(Long.parseLong(sb.toString()));
                operands.add(ch);
                sb = new StringBuilder();
            } else
                sb.append(ch);
        }
        nums.add(Long.parseLong(sb.toString()));
    }

    private char[] checkOperandTypes() {
        Set<Character> operandTypeSet = new HashSet<>(operands);
        char[] operandType = new char[operandTypeSet.size()];
        int i = 0;
        for (Character op : operandTypeSet) {
            operandType[i++] = op;
        }
        return operandType;
    }

    private void doPermutationForOperandOrders(char[] arr, int start) {
        int length = arr.length;
        if (start == length - 1) {
            operandOrders.add(arr.clone());
            return;
        }

        for (int i = start; i < length; i++) {
            swap(arr, start, i);
            doPermutationForOperandOrders(arr, start + 1);
            swap(arr, start, i);
        }
    }

    private void swap(char[] arr, int n1, int n2) {
        char temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }


    private void calcMaxResult() {
        for (char[] order : operandOrders) {
            long result = calcResultWithGivenOrder(order);
            updateAnswer(result);
        }
    }

    private long calcResultWithGivenOrder(char[] order) {
        tmpNums = new ArrayList<>(nums);
        tmpOperands = new ArrayList<>(operands);
        for (char targetOp : order) {
            calcOnTargetOperand(targetOp);
        }
        return tmpNums.get(0);
    }

    private void calcOnTargetOperand(char targetOp) {
        int length = tmpOperands.size();
        for (int i = 0; i < length; i++) {
            char op = tmpOperands.get(i);
            if (op == targetOp) {
                calc(i, op);
                tmpOperands.remove(i--);
                length--;
            }
        }
    }

    private void calc(int index, char op) {
        long left = tmpNums.get(index);
        long right = tmpNums.get(index + 1);
        long result = switch (op) {
            case '*' -> left * right;
            case '+' -> left + right;
            case '-' -> left - right;
            default -> 0;
        };
        tmpNums.set(index, result);
        tmpNums.remove(index + 1);
    }

    private void updateAnswer(long result) {
        long absResult = Math.abs(result);
        if (absResult > answer) answer = absResult;
    }
}
