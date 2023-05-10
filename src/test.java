import java.util.Scanner;
import java.text.DecimalFormat;
import java.math.BigDecimal;
public class test {

        public static double[][] calculateAmortization(double principal, double interestRate, int loanTerm, double monthlyPayment) {
            DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

            // Convert interest rate to decimal and calculate monthly interest rate
            double monthlyInterestRate = interestRate / 100 / 12;

            // Calculate number of payments
            int numberOfPayments = loanTerm * 12;

            System.out.println("Loan Amount: $" + decimalFormat.format(principal));
            System.out.println("Interest Rate: " + decimalFormat.format(interestRate) + "%");
            System.out.println("Loan Term: " + loanTerm + " years");
            System.out.println("Monthly Payment: $" + decimalFormat.format(monthlyPayment));
            System.out.println("------------------------------------------");

            // Create an array to store the amortization schedule
            double[][] amortizationSchedule = new double[numberOfPayments][4];
            // Columns: Payment Number, Principal Payment, Interest Payment, Remaining Balance

            // Calculate amortization schedule
            double remainingBalance = principal;

            for (int paymentNumber = 1; paymentNumber <= numberOfPayments; paymentNumber++) {
                double interestPayment = remainingBalance * monthlyInterestRate;
                double principalPayment = monthlyPayment - interestPayment;

                remainingBalance -= principalPayment;

                // Store the values in the amortization schedule array
                amortizationSchedule[paymentNumber - 1][0] = paymentNumber;
                amortizationSchedule[paymentNumber - 1][1] = principalPayment;
                amortizationSchedule[paymentNumber - 1][2] = interestPayment;
                amortizationSchedule[paymentNumber - 1][3] = remainingBalance;
            }

            return amortizationSchedule;
        }

        public static void main(String[] args) {
            DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

            // Example usage
            double[][] amortizationSchedule = calculateAmortization(100000, 5.5, 30, 567.79);

            // Print the amortization schedule array
            for (int i = 0; i < amortizationSchedule.length; i++) {
                System.out.println(amortizationSchedule[i][0] + "\t\t$" +
                        decimalFormat.format(amortizationSchedule[i][1]) + "\t$" +
                        decimalFormat.format(amortizationSchedule[i][2]) + "\t$" +
                        decimalFormat.format(amortizationSchedule[i][3]));
            }
        }
    }
