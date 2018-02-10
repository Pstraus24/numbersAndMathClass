/*
You are going to create a tip calculator program.
You will have the user enter the cost of items, and keep entering items until the user enters 0.
At that point, you will display the total cost, taxes (assume 2.5 percent or .025), total with taxes, and recommend a 17.5% tip.
Display appropriately for currency, with dollar signs and rounding to two decimal places.
 */

package com.company;

import java.text.NumberFormat;

import java.util.Scanner;
import java.text.DecimalFormat;


public class Main {

    public static void main(String[] args) {

        // -------------- Declare/initialize variables -----------
        double subTotal = 0;//----------- variable for the sum of amounts entered -------------
        double numberEntered;// ---------- input from user, summed into subTotal ---------
        Scanner input = new Scanner(System.in);// -------------Initialize input ---------------
        // -------------- Prompt for values, exit on 0 ----------------------
        do {
            System.out.print("Enter a price (<0> to end): $ ");
            numberEntered = input.nextDouble();
            subTotal = numberEntered + subTotal;
        } while (numberEntered != 0);

        usingNumberFormat(subTotal);// ------------ calculate and format using Number Format
        usingBigDecimal(subTotal);


    }

        private static void usingNumberFormat(double userNumber) {
            double salesTax = userNumber * 0.025;
            double suggestedTip = userNumber * 0.175;

            //NumberFormat nf = NumberFormat.getNumberInstance();// -------- formatter for currency display ----
            NumberFormat nf = NumberFormat.getCurrencyInstance();// -------- formatter for currency display ----


            nf.setGroupingUsed(true);// ------------- grouping for commas -----------
            nf.setMinimumFractionDigits(2);
            nf.setMaximumFractionDigits(2);
            // ---------- display data --------------

            System.out.println("\nUSING CURRENCY FORMAT");
            //System.out.println("Total cost: $ " + nf.format(userNumber));
            System.out.println("Total cost: " + nf.format(userNumber));
            //System.out.println("Sales tax of 2.5% on $ " + nf.format(userNumber) + ": $ " + nf.format(salesTax));
            System.out.println("Sales tax of 2.5% on " + nf.format(userNumber) + " is " + nf.format(salesTax));
            //System.out.println("Sales tax of 2.5% on $ " + nf.format(userNumber) + " is " + nf.format(salesTax));
            System.out.println("Suggested tip 17.5% (does not include sales tax): " + nf.format(suggestedTip));
            //System.out.println("Suggested tip 17.5% (does not include sales tax): $ " + nf.format(suggestedTip));
            System.out.println("Amount with taxes: " + nf.format(userNumber + salesTax));
            //System.out.println("Amount with taxes: $ " + nf.format(userNumber + salesTax));
            System.out.println("Note that the taxes are not included in suggested tip");
            System.out.println("Total amount with suggested tip: "
                    + nf.format(userNumber + suggestedTip + salesTax));
            //System.out.println("Total amount with suggested tip: $ " + nf.format(userNumber + suggestedTip + salesTax));

    }
        private static void usingBigDecimal(double userNumber) {


            DecimalFormat priceFormatter = new DecimalFormat("$#0.00"); //setting the format
            String salesTax = priceFormatter.format(userNumber * 0.025); //rounded operation
            String suggestedTip = priceFormatter.format(userNumber * 0.175);
            String totalPrice = priceFormatter.format(userNumber + (userNumber * 0.025));
            String totalWithTips = priceFormatter.format(userNumber + (userNumber * 0.175) + (userNumber * 0.025));
            System.out.println("\nUSING BigDecimal");
            System.out.println("Total cost: " + userNumber);
            System.out.println("Sales Tax of 2.5% on " + userNumber + " is " + salesTax);
            System.out.println("Suggested tip 17.5% (does not include sales tax): " + suggestedTip);
            System.out.println("Total with taxes: " + totalPrice);
            System.out.println("Total with tax and tip: " + totalWithTips);


    }
}
