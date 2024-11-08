import java.text.NumberFormat;

public class MortgageReport {

    private   MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator){
        this.calculator =calculator;
    }



    public void  PrintMortgage() {
        double mortgage = calculator.calculateMortgage();
        String MortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("Mortgage");
        System.out.println("-------------");
        System.out.println("Monthly Payment : " + MortgageFormatted);
    }

    public void  printPaymentRemaining() {
        System.out.println();
        System.out.println("Remaining : " + calculator.getRemainingPayments().length + " months");
        System.out.println("-------------");

        for(double remaining: calculator.getRemainingPayments())

            System.out.println("Remaining:  "+NumberFormat.getCurrencyInstance().format(remaining));


    }
    }

