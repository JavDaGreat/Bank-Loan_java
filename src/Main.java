import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte MONTH_IN_YEAR = 12;
    final static byte PERCENT = 100;
    public static void main(String[] args) {

        int loanAmount =  (int)readInput("How much do you want to Loan:",1000,100_000_000);
        float interestRate= (float) readInput("Annual Interest Rate:",1,30);
        byte years = (byte) readInput("Period(Years): ",1,30);

        PrintMortgage(loanAmount, interestRate, years);
        printPaymentRemainig(years, loanAmount, interestRate);


    }

    private static void PrintMortgage(int loanAmount, float interestRate, byte years) {
        double mortgage = calculateMortgage(loanAmount, interestRate, years);
        String MortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("Mortgage");
        System.out.println("-------------");
        System.out.println("Monthly Payment : "+ MortgageFormatted);
    }

    private static void printPaymentRemainig(byte years, int loanAmount, float interestRate) {
        System.out.println();
        System.out.println("Remaining");
        System.out.println("-------------");
        for (short month = 1; month < years *MONTH_IN_YEAR; month ++){
            double remaining = calculateRemaining(loanAmount, interestRate, years,month);
            System.out.println("Remaining after month:"+ month+ " : "+NumberFormat.getCurrencyInstance().format(remaining));
        }
    }

    public static double calculateMortgage(int amount ,float interest,byte years){

        float numberOfPayments = years * MONTH_IN_YEAR;
        float monthlyInterest = interest / PERCENT / MONTH_IN_YEAR;

        return amount *(monthlyInterest * Math.pow(1+monthlyInterest,numberOfPayments))/
                (Math.pow(1+monthlyInterest,numberOfPayments)-1);

    }
    public static double readInput (String prompt,double min, double max){
        Scanner input = new Scanner(System.in);
        double value;

        while(true){
            System.out.print(prompt );
            value = input.nextFloat();
            if(value>= min && value<= max) {
                break;
            }
            System.out.println("Please enter a value between " + min + " and " + max + ".");
        }
        return value;

    }
    public static double calculateRemaining(int amount ,float interest,byte years,short numberOfPaymentMade){

        float numberOfPayments = years * MONTH_IN_YEAR;
        float monthlyInterest = interest / PERCENT / MONTH_IN_YEAR;
        return amount * (Math.pow(1+monthlyInterest,numberOfPayments)-Math.pow(1+monthlyInterest,numberOfPaymentMade))
        / (Math.pow(1+monthlyInterest,numberOfPayments)-1);

    }

}