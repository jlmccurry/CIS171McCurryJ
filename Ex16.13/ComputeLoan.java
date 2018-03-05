package ex1613;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.scene.layout.Pane;
import static jdk.nashorn.internal.objects.NativeMath.round;
  
public class ComputeLoan extends Pane{

    private double numYears;
    private double interest;
    private double monthlyInterest;
    private double addedInterest;
    private double payment;
    private double loanAmt;
    private List<String> interestList = new ArrayList<String>();
    private List<String> addedInterestList = new ArrayList<String>();
    private List<String> paymentList = new ArrayList<String>();
    private List<String> loanAmtList = new ArrayList<String>();

        public ComputeLoan(){
        }
        
        //Compute the loan monthly interest, payment, and total amount payed
        public void ComputeLoan(double loanAmt, double numYears){
            this.loanAmt = loanAmt;
            this.numYears = numYears;
            this.interest = interest;
            DecimalFormat df = new DecimalFormat("#.00");
            while(interest >= 5 && interest <= 8){
                monthlyInterest = interest / 1200;
                payment = (loanAmt * monthlyInterest / (1 - 1 / Math.pow(1 + monthlyInterest, numYears * 12)));
                paymentList.add(Double.toString(loanAmt * monthlyInterest / (1 - 1 / Math.pow(1 + monthlyInterest, numYears * 12))));
                interestList.add(Double.toString(interest));
                interest = interest + .125;
                addedInterestList.add(Double.toString(payment * numYears * 12));
            }
        }
        
        //Next 3 methods get an index of a list, trim it to 2 decimal places, and return a string
        public String getPaymentList(int i){
            this.paymentList = paymentList;
            String output = paymentList.get(i);
            double trim = Double.parseDouble(output);
            String fixed = String.format("%.2f", trim);
            return fixed;
        }
        
        public String getInterestList(int i){
            this.interestList = interestList;
            String output = interestList.get(i);
            double trim = Double.parseDouble(output);
            String fixed = String.format("%.2f", trim);
            return fixed;
        }
        
        public String getAddedInterestList(int i){
            this.addedInterestList = addedInterestList;
            String output = addedInterestList.get(i);
            double trim = Double.parseDouble(output);
            String fixed = String.format("%.2f", trim);
            return fixed;
        }
        
        public List<String> getPaymentList(){
            return paymentList;
        }
        
        public List<String> getInterestList(){
            return interestList;
        }
        
        public List<String> getAddedInterestList(){
            return addedInterestList;
        }
        
        public double getInterest(){
            this.interest = interest;
            return interest;
        }
        
        public void setInterest(double interest){
            this.interest = interest;
        }

}