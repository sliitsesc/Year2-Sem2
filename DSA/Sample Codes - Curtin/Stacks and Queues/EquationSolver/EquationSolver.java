import java.util.Scanner;
import java.lang.Math;

class EquationSolver
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the equation: ");
        String equation = sc.nextLine();
        System.out.println(answer);
    }

    public static double solve(String equation)
    {
        ShuffledQ postFix = new ShuffledQ();
        postFix = parseInfixToPostfix(equation);
        Double answer = evaluatePostfix(postFix);
        while (1 == 1)
        {
            System.out.println
        }
        return answer;
    }

    private static ShuffledQ parseInfixToPostfix(String equation)
    {
        Stack solveStack = new Stack();
        String[] equationParts = equation.split(" ");
        ShuffledQ postFix = new ShuffledQ();
        int precedence = 0;
        int y = 0;

        for (int x = 0; x < equationParts.length; x ++)
        {
            if (precedenceOf(equationParts[x]) == 0)
            {
                if (equationParts[x].equals("("))
                {
                    solveStack.push(equationParts[x]);
                }
                else if (equationParts[x].equals(")"))
                {
                    while (!solveStack.peek().equals("("))
                    {
                        postFix.enqueue(solveStack.pop());
                    }
                    solveStack.pop();
                }
                else
                {
                    postFix.enqueue(equationParts[x]);
                }
            }
            else
            {
                if (solveStack.isEmpty() == true)
                {
                    solveStack.push(equationParts[x]);
                }
                else
                {
                    while (precedenceOf(equationParts[x]) <= precedenceOf(solveStack.peek()) && solveStack.isEmpty() == false)
                    {
                        postFix.enqueue(solveStack.pop());
                    }
                    solveStack.push(equationParts[x]);
                }
            }
            precedence = precedenceOf(equationParts[x]);
        }
        while (solveStack.isEmpty() == false)
        {
            postFix.enqueue(solveStack.pop());
        }
        return postFix;
    }

    private static int precedenceOf(Object theOp)
    {
       if (theOp.equals("+")  || theOp.equals("-"))
       {
           return 1;
       }
       else if (theOp.equals("*")  || theOp.equals("/") )
       {
           return 2;
       }
       else if (theOp.equals("^") )
       {
           return 3;
       }
       else
       {
           return 0;
       }
    }

    private static double evaluatePostfix(ShuffledQ postFix)
    {
        double ans;
        Double operand1;
        Double operand2;
        char operator;
        Stack ansStack = new Stack();
        Object headElement;
        Double returnVal;

        while (postFix.isEmpty() == false)
        {
            headElement = postFix.dequeue();
            if ( precedenceOf(headElement) == 0 )
            {
                ansStack.push(headElement);
            }
            else
            {
                operand1 = Double.valueOf(ansStack.pop().toString()).doubleValue();
                operand2 = Double.valueOf(ansStack.pop().toString()).doubleValue();
                operator = headElement.toString().charAt(0);
                ans = executeOperation(operator, operand1, operand2);
                ansStack.push(ans);
            }
        }
        returnVal = Double.valueOf(ansStack.pop().toString()).doubleValue();
        return returnVal;
    }
    private static double executeOperation(char op, double op1, double op2)
    {
        double returnVal = 0;
        if (op == '+')
        {
            returnVal = op2 + op1;
        }
        else if (op == '-')
        {
            returnVal = op2 - op1;
        }
        else if (op == '/')
        {
            returnVal = op2 / op1;
        }
        else if (op == '*')
        {
            returnVal = op2 * op1;
        }
        else if (op == '^')
        {
            returnVal =Math.pow(op2, op1);
        }
        return returnVal;
    }
}