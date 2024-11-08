public class MortgageCalculator {

    final static byte MONTH_IN_YEAR = 12;
    final static byte PERCENT = 100;

   private int amount;
   private float interest;
   private byte years;

    public MortgageCalculator(int amount, float interest, byte years) {
        this.amount = amount;
        this.interest = interest;
        this.years = years;
    }

    public double [] getRemainingPayments(){
        double [] remainings= new double[getNumberOfPayments()];
        for (short month = 1; month < getNumberOfPayments(); month ++)
            remainings [month-1] = calculateRemaining(month);
              return remainings;
    }

    public  double calculateMortgage(){

        float numberOfPayments = getNumberOfPayments();
        float monthlyInterest = getMonthlyInterest();

        return amount *(monthlyInterest * Math.pow(1+monthlyInterest,numberOfPayments))/
                (Math.pow(1+monthlyInterest,numberOfPayments)-1);

    }

    private float getMonthlyInterest() {
        return interest / PERCENT / MONTH_IN_YEAR;
    }

    private int getNumberOfPayments() {
        return years * MONTH_IN_YEAR;
    }

    public  double calculateRemaining( short numberOfPaymentMade){

        float numberOfPayments = getNumberOfPayments();
        float monthlyInterest = getMonthlyInterest();
        return amount * (Math.pow(1+monthlyInterest,numberOfPayments)-Math.pow(1+monthlyInterest,numberOfPaymentMade))
        / (Math.pow(1+monthlyInterest,numberOfPayments)-1);

    }

}

