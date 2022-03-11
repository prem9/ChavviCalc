package calculator.chavviCalcExample.chavviCalcExample;

import java.util.*;

/*
 * chavvi calc calculator
 */
public class ChavviCalcExampleApp {
  private static double aVariable = 0;
  private static double bVariable = 0;
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Character command = '_';
    
    // loop until user quits
    while (command != 'q') {
      printMenu();
      System.out.print("Enter a command: ");
      command = menuGetCommand(scan);
      

      executeCommand(scan, command);
    }

    scan.close();
  }

  //
  // menu functions
  //
  private static void printMenuLine() {
    System.out.println(
      "----------------------------------------------------------"
    );
  }

  private static void printAandBLine(Double a, Double b) 
  {
    
    System.out.printf("A = %.3f     B = %.3f%n", a,b);
  }

  private static void printMenuCommand(Character command, String desc) {
    System.out.printf("%s\t%s\n", command, desc);
  }

  // prints the menu
  public static void printMenu() {
    printMenuLine();
    System.out.println("ChavviCalc");
    printMenuLine();

    printAandBLine(aVariable, bVariable);

    printMenuLine();
    
    printMenuCommand('a', "Enter a value for A");
    printMenuCommand('b', "Enter a value for B");
    printMenuCommand('+', "Add");
    printMenuCommand('-', "Subtract");
    printMenuCommand('*', "Multiply");
    printMenuCommand('/', "Divide");
    printMenuCommand('c', "Clear");
    printMenuCommand('q', "Quit");

    printMenuLine();
  }

  // get first character from input
  private static Character menuGetCommand(Scanner scan) {
    Character command = '_';

    String rawInput = scan.nextLine();

    if (rawInput.length() > 0) {
      rawInput = rawInput.toLowerCase();
      command = rawInput.charAt(0);
    }

    return command;
  }

  // calculator functions
  private static Boolean executeCommand(Scanner scan, Character command) {
    Boolean success = true;

    switch (command) {
      case 'a': 
        
        aVariable = scan.nextDouble();
        break;
      case 'b':
        bVariable = scan.nextDouble();
        break;
      case '+':
        aVariable = aVariable + bVariable;
        break;
      case '-':
        aVariable = aVariable - bVariable;
        break;
      case '*':
        aVariable = aVariable * bVariable;
        break;
      case '/':
        if (bVariable == 0)
        {
          System.out.println("Invalid User Input.");
          break;
        }
        aVariable = aVariable/bVariable;
        break;
      case 'c': 
        aVariable = 0; 
        bVariable = 0;
        break;
      case 'q':
        System.out.println("Thank you for using Chavvi Calc");
        break;
      default:
        System.out.println("ERROR: Unknown commmand");
        success = false;
    }

    return success;
  }
}
