public class Loan {
    private double anualinterest;
    private int numberOfYears;
    private double loanAmount;
    private java.util.Date loanDate;

    // Default constructor
    public Loan() {
        this(1.5, 1, 1000);
    }

    // Constructor that takes in parameters to initialize
    public Loan(double anualinterest, int numberOfYears, double loanAmount){
        this.anualinterest = anualinterest;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        loanDate = new java.util.Date();
    }

    public double getAnualinterest(){
        return anualinterest;
    }

    public int getNumberOfYears(){
        return numberOfYears;
    }

    public double getLoanAmount(){
        return loanAmount;
    }

    java.util.Date getLoanDate() {
        return loanDate;
    }

    public void SetAnualInterest(double anualinterest){
        this.anualinterest = anualinterest;
    }

    public void SetNumberOfYears(int NumberOfYears){
        this.numberOfYears = NumberOfYears;
    }

    public void setLoanAmount(double LoanAmount){
        this.loanAmount = LoanAmount;
    }

    public double getMonthlyIntereset(){
        double monthlyintereset = anualinterest /1200;
        double monthlyPayment = loanAmount * monthlyintereset /
                (1 - (Math.pow(1/(1+monthlyintereset), numberOfYears*12)));
        return monthlyPayment;
    }

}
