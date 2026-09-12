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

                while (running) {

                    String acctNum = JOptionPane.showInputDialog("Account Number");

                    while (acctNum.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Enter account number");
                        acctNum = JOptionPane.showInputDialog("Account Number");
                        System.out.println(acctNum);
                    }

                         BankAccount result1 = BankSystem.findAccounts((acctNum));

                            if (result1 == null) {
                                String acctName = JOptionPane.showInputDialog("Account Name");

                                while (acctName.isEmpty()) {
                                    JOptionPane.showMessageDialog(frame, "Account name");
                                    acctName = JOptionPane.showInputDialog("Account name");
                                    System.out.println(acctName);
                                }

                                    String balanceInput = JOptionPane.showInputDialog("Account Balance");

                                    while (balanceInput.isEmpty()) {
                                        JOptionPane.showMessageDialog(frame, "Enter Account Balance");
                                        balanceInput = JOptionPane.showInputDialog("Account balance");
                                        System.out.println(balanceInput);
                                    }

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
                                                    JOptionPane.showMessageDialog(frame, "Invalid option");
                                                    break;
                                }
                            }
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
                    JOptionPane.showMessageDialog(frame, accounts);

                }
            });

            JButton findAcc = new JButton("Find Account");
            frame.add(findAcc);
            findAcc.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String findAccNumber = JOptionPane.showInputDialog("Enter Account Number");

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