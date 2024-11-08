public class Main {

    public static void main(String[] args) {

        int loanAmount =  (int) Console.readInput("How much do you want to Loan:",1000,100_000_000);
        float interestRate= (float) Console.readInput("Annual Interest Rate:",1,30);
        byte years = (byte) Console.readInput("Period(Years): ",1,30);

        MortgageCalculator calculator = new MortgageCalculator(loanAmount,interestRate,years);
        MortgageReport report = new MortgageReport(calculator);

         report.PrintMortgage();
         report.printPaymentRemaining();


    }

}