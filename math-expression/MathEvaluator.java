import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class MathEvaluator {
    int iter = 0;
    boolean lastIsOperation = true;
    Stack<Double> operands = new Stack<>();
    Stack<Operation> operations = new Stack<>();

    // Обратная польская запись
    // Получение числа
    // Получение операции
    // Работа со стеком

    enum Operation {
        PLUS,
        UNARY_PLUS,
        MINUS,
        UNARY_MINUS,
        MULTIPLY,
        DIVISION,
        OPEN_BRACKETS,
        CLOSE_BRACKETS
    }   
    
    public double calculate(String expression) {

        while (iter < expression.length()) {
            char total = expression.charAt(iter);
            if (Character.isDigit(total)) {
                readAndInsertNum(expression);
            } else {
                readAndProcessOperation(expression);
            }
        }
        
        return 0.0;
    }

    private void readAndInsertNum(String expression) {
        int numEnd = iter + 1;
        while (Character.isDigit(numEnd) && numEnd < expression.length()) {
            numEnd++;
        }

        String numStr = expression.substring(iter, numEnd);
        var num = Double.parseDouble(numStr);
        operands.add(num);
        
        iter = numEnd;
        lastIsOperation = false;
    }

    private void readAndProcessOperation(String expression) {
        char total = expression.charAt(iter);
        if (Character.isWhitespace(total)) {
            iter++;
            return;
        }

        switch (total) {
            case '+':

                break;
        
            default:
                break;
        }

        lastIsOperation = true;
    }
  
  }