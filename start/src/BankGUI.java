import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

public class BankGUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Bank System");
        frame.setLayout(new FlowLayout());

        JButton createBtn = new JButton("Create Account");
        frame.add(createBtn);
        createBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane option = new JOptionPane();

                boolean running = true;

                // Enter account number
                String acctNum = JOptionPane.showInputDialog("Account Number");

                // Did the user enter account number?
                // YES - stop the program from running
                if(acctNum == null){
                    running = false;
                }

                // NO - CONTINUE
                while (running) {

                    // is account number empty?
                    // YES - Ask to prompt again
                    while (acctNum.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Enter account number");
                        acctNum = JOptionPane.showInputDialog("Account Number");
                        System.out.println(acctNum);
                    }

                    // NO - Check existing account number
                    BankAccount result1 = BankSystem.findAccounts((acctNum));

                    // Is there an existing account number?
                    // NO - Get account name
                    if (result1 == null) {
                        String acctName = JOptionPane.showInputDialog("Account Name");

                        // Did the user enter account name?

                        // NO - stop the program from running
                        if(acctName == null){
                            running = false;
                        }

                        // YES - CONTINUE

                        // Is the account name empty?
                        // YES - ask to prompt again
                                // Did the user pressed cancel?
                                // NO - check if empty and ask to prompt
                            while (acctName != null && acctName.isEmpty()) {
                                JOptionPane.showMessageDialog(frame, "Account name");
                                acctName = JOptionPane.showInputDialog("Account name");
                                System.out.println(acctName);

                                // YES - stop the program from running
                                if(acctName == null){
                                    running = false;
                                }

                            }

                        // NO - Get account balance
                            if (acctName != null){
                                String balanceInput = JOptionPane.showInputDialog("Account Balance");

                                // Did the user pressed cancel?
                                // YES - stop the program from running
                                if(balanceInput == null){
                                    running = false;
                                }

                                // NO - check if empty and ask to prompt
                                     // Did the user pressed cancel?
                                     // NO - check if empty and ask to prompt
                                while (balanceInput != null && balanceInput.isEmpty()) {
                                    JOptionPane.showMessageDialog(frame, "Enter Account Balance");
                                    balanceInput = JOptionPane.showInputDialog("Account balance");
                                    System.out.println(balanceInput);

                                    // YES - stop the program from running
                                    if (balanceInput == null){
                                        running = false;
                                    }
                                }

                                // does the amount balance have input?
                                // YES - convert it to float
                                if (balanceInput != null){
                                    float acctBal = Float.parseFloat(balanceInput);

                                String[] acctTypes = {
                                        "Savings Account",
                                        "Regular Account",
                                        "Student Account"
                                };

                                if (acctBal > 0) {
                                    int accType = JOptionPane.showOptionDialog(
                                            frame,
                                            "Choose Account type",
                                            "Account type",
                                            JOptionPane.DEFAULT_OPTION,
                                            JOptionPane.QUESTION_MESSAGE,
                                            null,
                                            acctTypes,
                                            acctTypes[0]
                                    );

                                    switch (accType) {
                                        case 0:
                                            BankAccount savingsAcc = new SavingsAccount(acctNum, acctName, acctBal, true);
                                            BankSystem.addAccount(savingsAcc);
                                            System.out.println(savingsAcc);
                                            running = false;

                                            break;
                                        case 1:
                                            BankAccount regularAcc = new BankAccount(acctNum, acctName, acctBal, true);
                                            BankSystem.addAccount(regularAcc);
                                            System.out.println(regularAcc);
                                            running = false;

                                            break;
                                        case 2:
                                            BankAccount studentAcc = new StudentAccount(acctNum, acctName, acctBal, true);
                                            BankSystem.addAccount(studentAcc);
                                            System.out.println(studentAcc);
                                            running = false;

                                            break;
                                        default:
                                            JOptionPane.showMessageDialog(frame, "Choose account type");
                                            break;

                                        }
                                    }
                                }
                            }

                            // YES - there is an existing account, enter to prompt again.
                        }else{
                        JOptionPane.showMessageDialog(frame, "There is an Existing Account");
                        acctNum = JOptionPane.showInputDialog("Enter account number");
                        System.out.println(acctNum);
                        }
                    }
                }
             });

            JButton showAcc = new JButton("Show Account");
            frame.add(showAcc);
            showAcc.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    String accounts = BankSystem.showsAcc();
                    if(accounts == null || accounts.isEmpty()){
                        JOptionPane.showMessageDialog(frame, "No accounts created");
                    }else{
                        JOptionPane.showMessageDialog(frame, accounts);
                    }


                }
            });

            JButton findAcc = new JButton("Find Account");
            frame.add(findAcc);
            findAcc.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    boolean running = true;

                    String findAccNumber = JOptionPane.showInputDialog("Enter Account Number");

                    if(findAccNumber == null){
                        running = false;
                    }

                    while(running){

                        while(findAccNumber.isEmpty()){
                            JOptionPane.showMessageDialog(frame, "Enter Account Number");
                            findAccNumber = JOptionPane.showInputDialog("Enter Account Number");
                            System.out.println(findAccNumber);
                        }

                        BankAccount result1 = (BankSystem.findAccounts(findAccNumber));

                        String showAccs= "";
                        if (result1 != null){
                            result1.toString();
                            showAccs += "Account Number: " + result1.getNumber() + "\n" + "Account Name: " + result1.getName() + "\n" + "Balance: " + result1.getBalance() + "\n" + "Active: " + result1.isActive() + "\n";
                            JOptionPane.showMessageDialog(frame, showAccs);
                        }else{
                            JOptionPane.showMessageDialog(frame, "No Account found");
                        }
                    }

                }
            });

            JButton depositBtn = new JButton("Deposit");
            frame.add(depositBtn);
            depositBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean running = true;

                    String acctNumber = JOptionPane.showInputDialog("Enter Account Number");

                    if(acctNumber == null){
                        running = false;
                    }

                    while(running){

                        while(acctNumber.isEmpty()){
                            JOptionPane.showMessageDialog(frame, "Enter Account Number");
                            acctNumber = JOptionPane.showInputDialog("Enter Account Number");
                            System.out.println(acctNumber);
                        }

                        BankAccount result = BankSystem.findAccounts(acctNumber);

                        if(result != null){
                            String amount = JOptionPane.showInputDialog("Enter amount");

                            while (amount.isEmpty()){
                                JOptionPane.showMessageDialog(frame, "Enter balance");
                                amount = JOptionPane.showInputDialog("Enter balance");
                                System.out.println(amount);
                            }

                            int acctBal = Integer.parseInt(amount);

                            BankSystem.depositToAccount(acctNumber, acctBal);
                        }else{
                            JOptionPane.showMessageDialog(frame, "Account not found");
                        }
                    }




                }
            });

            JButton withdrawBtn = new JButton("Withdraw");
            frame.add(withdrawBtn);
            withdrawBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    boolean running = true;

                    String acctNumber = JOptionPane.showInputDialog("Enter account number");

                    if(acctNumber == null){
                        running = false;
                    }

                    while(running){

                        while(acctNumber.isEmpty()){
                            JOptionPane.showMessageDialog(frame, "Enter account number");
                            acctNumber = JOptionPane.showInputDialog("Enter account number");
                            System.out.println(acctNumber);
                        }

                        BankAccount result = BankSystem.findAccounts(acctNumber);

                        if(result != null){
                            String amount = JOptionPane.showInputDialog("Enter amount");

                            while(amount.isEmpty()){
                                JOptionPane.showMessageDialog(frame, "Enter amount");
                                amount = JOptionPane.showInputDialog("Enter amount");
                                System.out.println(amount);
                            }

                            int acctBal = Integer.parseInt(amount);

                            BankSystem.withdrawFromAccount(acctNumber, acctBal);

                        }else{
                            JOptionPane.showMessageDialog(frame, "No account found");
                        }
                    }


                }
            });




//        JLabel accNumLabel = new JLabel("Account number:");
//        frame.add(accNumLabel);
//
//        JTextField accNumField = new JTextField(10);
//        frame.add(accNumField);
//
//        JLabel accNameLabel = new JLabel("Account name:");
//        frame.add(accNameLabel);
//
//        JTextField accNameField = new JTextField(10);
//        frame.add(accNameField);
//
//        JLabel accBalLabel = new JLabel("Account balance:");
//        frame.add(accBalLabel);
//
//        JTextField accBalField = new JTextField(10);
//        frame.add(accBalField);
//
//        JButton saveBtn = new JButton("Save");
//        frame.add(saveBtn);

        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);


    }

}