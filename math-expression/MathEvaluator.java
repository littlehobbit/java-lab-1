import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;



public class MathEvaluator {
    int iter = 0;
    boolean lastIsOperation = true;
    Stack<Double> operands = new Stack<>();
    Stack<Operation> operations = new Stack<>();

    enum Operation {
        PLUS,
        MINUS,
        MULTIPLY,
        DIVISION,
        UNARY_PLUS,
        UNARY_MINUS,
        OPEN_BRACKETS,
        CLOSE_BRACKETS
    } 

    static final Map<Operation, Integer> OPERATION_PRIORITY = Map.of(
        Operation.OPEN_BRACKETS, 4,
        Operation.CLOSE_BRACKETS, 4,
        Operation.UNARY_MINUS, 3,
        Operation.UNARY_PLUS, 3,
        Operation.MULTIPLY, 2,
        Operation.DIVISION, 2,
        Operation.PLUS, 1,
        Operation.MINUS, 1
    );
    
    public double calculate(String expression) {

        while (iter < expression.length()) {
            char total = expression.charAt(iter);
            if (Character.isDigit(total)) {
                readAndInsertNum(expression);
            } else {
                readAndProcOperation(expression);
                iter++;
            }
        }
        
        while (!operations.empty()) {
            popAndProcOperation();
        }
        
        return operands.pop();
    }

    private void readAndInsertNum(String expression) {
        operands.add(readNum(expression));
        lastIsOperation = false;
    }

    private double readNum(String expression) {
        int numEnd = iter + 1;
        while (numEnd < expression.length() 
               && (Character.isDigit(expression.charAt(numEnd)) || expression.charAt(numEnd) == '.')) {
            numEnd++;
        }

        String numStr = expression.substring(iter, numEnd);
        var num = Double.parseDouble(numStr);
        iter = numEnd;
        return num;
    }

    private void readAndProcOperation(String expression) {
        char total = expression.charAt(iter);
        if (Character.isWhitespace(total)) {
            return;
        }

        var operation = getOperationFromChar(total);
        if (operation != Operation.CLOSE_BRACKETS) {
            lastIsOperation = true;
        }

        procOperation(operation);
    }

    private void procOperation(Operation operation) {
        if (operation != Operation.OPEN_BRACKETS) {
            if (operation == Operation.CLOSE_BRACKETS) {
                while (!operations.empty() && operations.peek() != Operation.OPEN_BRACKETS) {
                    popAndProcOperation(); 
                }
                operations.pop(); // pop last open brackets
                return;
            } else {
                // check last operations priority
                while (!operations.empty() 
                       && operations.peek() != Operation.OPEN_BRACKETS
                       && OPERATION_PRIORITY.get(operations.peek()) >= OPERATION_PRIORITY.get(operation)) {
                    popAndProcOperation(); 
                }
            }
        }

        operations.push(operation);
    }

    private void popAndProcOperation() {
        var operation = operations.pop();
        Double rhs = operands.pop();
        double ans;
        switch (operation) {
            case PLUS:
                ans = operands.pop() + rhs;
                break;

            case MINUS:
                ans =  operands.pop() - rhs;
                break;

            case MULTIPLY:
                ans =  operands.pop() * rhs;
                break;

            case DIVISION:
                ans =  operands.pop() / rhs;
                break;

            case UNARY_MINUS:
                ans =  -rhs;
                break;

            case UNARY_PLUS:
                ans =  +rhs;
                break;

            default:
                return;
        }

        operands.push(ans);
    }

    private Operation getOperationFromChar(char ch) {
        switch (ch) {
            case '+':
                if (lastIsOperation)
                    return Operation.UNARY_PLUS;
                else 
                    return Operation.PLUS;

            case '-':
                if (lastIsOperation)
                    return Operation.UNARY_MINUS;
                else 
                    return Operation.MINUS;

            case '*':
                return Operation.MULTIPLY;
        
            case '/':
                return Operation.DIVISION;

            case '(':
                return Operation.OPEN_BRACKETS;

            case ')':
                return Operation.CLOSE_BRACKETS;

            default:
                return null;
        }
    }
  
  }