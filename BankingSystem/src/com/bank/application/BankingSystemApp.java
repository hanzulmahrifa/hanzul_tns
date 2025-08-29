package com.bank.application;



import com.bank.entities.Customer;

import com.bank.entities.Account;

import com.bank.entities.Transaction;

import com.bank.entities.Beneficiary;

import com.bank.services.BankingService;

import com.bank.services.BankingServiceImple;



import java.util.List;

import java.util.Scanner;



public class BankingSystemApp {



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankingService service = new BankingServiceImple();

        Boolean running = true;



        while (running) {

            System.out.println("\nBanking System");

            System.out.println("1. Add Customers");

            System.out.println("2. Add Accounts");

            System.out.println("3. Add Beneficiary");

            System.out.println("4. Add Transaction");

            System.out.println("5. Find Customer by Id");

            System.out.println("6. List all Accounts of specific Customer");

            System.out.println("7. List all transactions of specific Account");

            System.out.println("8. List all beneficiaries of specific customer");

            System.out.println("9. Exit");

            System.out.print("Enter your choice : ");

            int choice = sc.nextInt();



            switch (choice) {

                case 1:

                    System.out.print("Enter Customer Id: ");

                    int cid = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Name: ");

                    String cname = sc.nextLine();

                    System.out.print("Address: ");

                    String caddress = sc.nextLine();

                    System.out.print("Contact No.: ");

                    String ccontact = sc.nextLine();

                    Customer customer = new Customer(cid, cname, caddress, ccontact);

                    service.addCustomer(customer);

                    break;



                case 2:

                    System.out.print("Enter Account Id: ");

                    int aid = sc.nextInt();

                    System.out.print("Enter Customer Id: ");

                    int ac_cid = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Account Type (Saving/Current): ");

                    String atype = sc.nextLine();

                    System.out.print("Balance: ");

                    double bal = sc.nextDouble();

                    Account account = new Account(aid, ac_cid, atype, bal);

                    service.addAccount(account);

                    break;



                case 3:

                    System.out.print("Enter Beneficiary Id: ");

                    int bid = sc.nextInt();

                    System.out.print("Enter Customer Id: ");

                    int bc_cid = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Beneficiary Name: ");

                    String bname = sc.nextLine();

                    System.out.print("Beneficiary Account No.: ");

                    String baccno = sc.nextLine();

                    System.out.print("Beneficiary Bank Details: ");

                    String bdetails = sc.nextLine();

                    Beneficiary beneficiary = new Beneficiary(bid, bc_cid, bname, baccno, bdetails);

                    service.addBeneficiary(beneficiary);

                    break;



                case 4:

                    System.out.print("Enter Transaction Id: ");

                    int tid = sc.nextInt();

                    System.out.print("Enter Account Id: ");

                    int taid = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Type (Deposit/Withdrawal): ");

                    String ttype = sc.nextLine();

                    System.out.print("Amount: ");

                    double tamt = sc.nextDouble();

                    Transaction transaction = new Transaction(tid, taid, ttype, tamt);

                    service.addTransaction(transaction);

                    break;



                case 5:

                    System.out.print("Enter Customer Id: ");

                    int fcid = sc.nextInt();

                    Customer found = service.findCustomerById(fcid);

                    if (found != null) {

                        System.out.println(found);

                    } else {

                        System.out.println("Customer not found.");

                    }

                    break;



                case 6:

                    System.out.print("Enter Customer Id: ");

                    int ccid = sc.nextInt();

                    List<Account> accounts = service.getAccountsByCustomerId(ccid);

                    if (accounts.isEmpty()) {

                        System.out.println("No accounts found for this customer.");

                    } else {

                        for (Account a : accounts) {

                            System.out.println(a);

                        }

                    }

                    break;



                case 7:

                    System.out.print("Enter Account Id: ");

                    int ta_id = sc.nextInt();

                    List<Transaction> transactions = service.getTransactionsByAccountId(ta_id);

                    if (transactions.isEmpty()) {

                        System.out.println("No transactions found for this account.");

                    } else {

                        for (Transaction t : transactions) {

                            System.out.println(t);

                        }

                    }

                    break;



                case 8:

                    System.out.print("Enter Customer Id: ");

                    int bc_id = sc.nextInt();

                    List<Beneficiary> beneficiaries = service.getBeneficiariesByCustomerId(bc_id);

                    if (beneficiaries.isEmpty()) {

                        System.out.println("No beneficiaries found for this customer.");

                    } else {

                        for (Beneficiary b : beneficiaries) {

                            System.out.println(b);

                        }

                    }

                    break;



                case 9:

                    running = false;

                    System.out.println("Thank you!");

                    break;



                default:

                    System.out.println("Invalid choice.");

            }

        }

        sc.close();

    }

}