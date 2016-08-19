import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by op on 15.08.16.
 */
public class Calculator {
    private static final String ERROR_MESSAGE_IF_NUMBER_IS_WRONG = "Invalid number. Please, Try again";
    private static final Pattern PATTERN_FOR_OPERATORS = Pattern.compile("((?=.*[-+*/]).{0,1})");
    //private static final Pattern PATTERN_FOR_NUMBERS = Pattern.compile("((?=.*[.]).{0,1})(?=.*[0-9])");
    private static final Pattern PATTERN_FOR_NUMBERS = Pattern.compile("/d");

    private static String inputFirstNumber, inputSecondNumber,inputThirdNumber, inputOperator;
    // private static String firstOperator, secondOperator;
    private static double firstNumber, secondNumber, thirdNumber, sum;
    private static Scanner scanner = new Scanner(System.in);
    private static String continueMessage;

    public static void setFirstNumber() {
        System.out.println("First");
        inputFirstNumber = scanner.next();
        try {
            firstNumber = Double.parseDouble(inputFirstNumber);
        } catch (Exception e) {
            System.out.println(ERROR_MESSAGE_IF_NUMBER_IS_WRONG);
            setFirstNumber();
        }
    }

 /*   public static void setFirstNumber() {
        System.out.println("Write first number");
        inputFirstNumber = scanner.next();
        if (!PATTERN_FOR_NUMBERS.matcher(inputFirstNumber).matches()) {
            System.out.println("Invalid value. If value is double, then use point ( e.g. : 2.4 )");
            setFirstNumber();
        }
    }*/

    public static void setOperator() {
        System.out.println("Write operator. Allowed operators: +-/*");
        inputOperator = scanner.next();
        if (!PATTERN_FOR_OPERATORS.matcher(inputOperator).matches()) {
            System.out.println("Invalid operator. Allowed operators: +-/*");
            setOperator();
        }
    }

    public static void setSecondNumber() {
        System.out.println("Write second number");
        inputSecondNumber = scanner.next();
        try {
            secondNumber = Double.parseDouble(inputSecondNumber);
        } catch (Exception e) {
            System.out.println(ERROR_MESSAGE_IF_NUMBER_IS_WRONG);
            setSecondNumber();
        }
    }

/*    public static void setSecondNumber() {
        System.out.println("Write second number");
        inputSecondNumber = scanner.next();
       if (!PATTERN_FOR_NUMBERS.matcher(inputSecondNumber).matches()) {
           System.out.println("Invalid value. If value is double, then use point ( e.g. : 2.4 )");
           setSecondNumber();
       }
    }*/

    public static void calculation() {
        switch (inputOperator) {
            case "+":
                sum = firstNumber + secondNumber;
                break;
            case "-":
                sum = firstNumber - secondNumber;
                break;

            case "*":
                sum = firstNumber * secondNumber;
                break;

            case "/":
                sum = firstNumber / secondNumber;
                break;
            default:
                System.out.println("Sorry, we didn't recognize any character.Please try again");
        }
        //    System.out.printf ("%6.0d", sum);
    }

    public static void resultForFirstOperator() {
        calculation();
        //System.out.println(inputFirstNumber + inputOperator + inputSecondNumber + "=" + sum);
    }




    private static void continueCalculation() {
        System.out.println("Do you want to write third number? Y or N");
        continueMessage = scanner.next();
        switch (continueMessage) {
            case "n":
            case "N":
                resultForFirstOperator();
                System.out.println("Result:" + " " + sum);
                break;
            case "y":
            case "Y":
                setOperator();
                setThirdNumber();
                calculationForThirdNumber();
                System.out.println("Result:" + " " + sum);
                break;

            default:
                System.out.println("Error message");
                break;
        }
    }

    private static void setThirdNumber(){
        System.out.println("Write third number");
        inputThirdNumber = scanner.next();
        try {
            thirdNumber = Double.parseDouble(inputThirdNumber);
        } catch (Exception e) {
            System.out.println(ERROR_MESSAGE_IF_NUMBER_IS_WRONG);
            setThirdNumber();
        }
    }

/*public static void setThirdNumber() {
    System.out.println("Write third number");
    inputThirdNumber = scanner.next();
    if (!PATTERN_FOR_NUMBERS.matcher(inputThirdNumber).matches()) {
        System.out.println("Invalid value. If value is double, then use point ( e.g. : 2.4 )");
        setThirdNumber();
    }
}*/

    private  static void calculationForThirdNumber() {

        switch (inputOperator) {
            case "+":
                sum = sum + thirdNumber;
                break;
            case "-":
                sum = sum - thirdNumber;
                break;
            case "/":
                sum = sum / thirdNumber;
                break;
            case "*":
                sum = sum * thirdNumber;
                break;
            default:
                System.out.println("Invalid operator ");
        }}



    public static void main(String[] args) {
        setFirstNumber();
        setOperator();
        setSecondNumber();
        resultForFirstOperator();
        continueCalculation();
    }}