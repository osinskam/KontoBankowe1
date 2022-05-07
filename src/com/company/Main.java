package com.company;

class Main {
    public static void main(String[] args) {
        SavingsAccount ac01 = new SavingsAccount(5000, 0.01);
        SavingsAccount ac02 = new SavingsAccount(10000, 0.02);

        ac01.deposit(1000);
        ac01.transfer(1000, ac02);

        ac01.withdraw(500);
        ac02.withdraw(500);

        ac01.deposit(ac01.calculateInterest());
        ac02.deposit(ac02.calculateInterest());

        System.out.println(ac01);
        System.out.println(ac02);
    }
}

class BankAccount {
    double balance = 0;

    public BankAccount() {

    }

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void transfer(double amount, BankAccount other) {
        withdraw(amount);
        other.deposit(amount);
    }


    public void withdraw(double amount) {
        if (amount > 0) {
            balance = balance - amount;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
        }
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    public double calculateInterest() {
        return balance * interestRate;
    }

    @Override
    public String toString() {
        return "SavingsAccount [interestRate=" + interestRate + ", balance=" + balance + "]";
    }
}

//koniec