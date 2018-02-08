/*
You are going to create a tip calculator program.
You will have the user enter the cost of items, and keep entering items until the user enters 0.
At that point, you will display the total cost, taxes (assume 2.5 percent or .025), total with taxes, and recommend a 17.5% tip.
Display appropriately for currency, with dollar signs and rounding to two decimal places.
 */

package com.company;

import java.text.NumberFormat;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // -------------- Declare/initialize variables -----------
        double subTotal = 0;//----------- variable for the sum of amounts entered -------------
        double numberEntered;// ---------- input from user, summed into subTotal ---------
        double salesTax;// ------ Sales tax 2.5% --------------
        double suggestedTip;// ------- 17.5% based on subTotal only, not total with taxes -------
        Scanner input = new Scanner(System.in);// -------------Initialize input ---------------
        do{
            System.out.print("Enter a price (<0> to end): $ ");
            numberEntered = input.nextDouble();
            subTotal = numberEntered + subTotal;
            salesTax = subTotal * 0.025;
            suggestedTip = subTotal * 0.175;
        }while(numberEntered != 0);

        NumberFormat nf = NumberFormat.getNumberInstance();// -------- formatter for currency display ----
        nf.setGroupingUsed(true);// ------------- grouping for commas -----------
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        // ---------- display data --------------
        System.out.println("\nTotal cost: $ " + nf.format(subTotal));
        System.out.println("Sales tax of 2.5% on $ " + nf.format(subTotal) + ": $ " + nf.format(salesTax));
        System.out.println("Suggested tip 17.5% (does not include sales tax): $ " + nf.format(suggestedTip));
        System.out.println("Amount with taxes: $ " + nf.format(subTotal + salesTax));
        System.out.println("Note that the taxes are not included in suggested tip");
        System.out.println("Total amount with suggested tip: $ "
                + nf.format(subTotal + suggestedTip));
        // ----totalOut = nf.format(totalAmountDue);


    }
}
