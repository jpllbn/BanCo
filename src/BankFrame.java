import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankFrame extends JFrame {
    private JTextField accountField;
    private JTextField nameField;
    private JTextField balanceField;
    private JButton depositButton;
    private JButton withdrawButton;
    private BankAccount account;

    public BankFrame() {
        account = new BankAccount(123, "John Paul", 0.00);
        JLabel accountLabel = new JLabel("Account Number:");
        JLabel nameLabel = new JLabel("Name:");
        JLabel balanceLabel = new JLabel("Balance:");

        accountField = new JTextField(5);
        nameField = new JTextField(15);
        balanceField = new JTextField(5);

        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");

        JPanel inputPanel = new JPanel();
        inputPanel.add(accountLabel);
        inputPanel.add(accountField);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(balanceLabel);
        inputPanel.add(balanceField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);

        getContentPane().add(inputPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deposit();
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                withdraw();
            }
        });

        setTitle("BanCo - Welcome John Paul");
        setSize(600, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        updateFields();
    }

    private void deposit() {
        double amount = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter deposit amount:"));
        if (account.deposit(amount)) {
            JOptionPane.showMessageDialog(this, "Deposit successful.");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid deposit amount.");
        }
        updateFields();
    }

    private void withdraw() {
        double amount = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter withdraw amount:"));
        if (account.withdraw(amount)) {
            JOptionPane.showMessageDialog(this, "Withdraw successful.");
        } else {
            JOptionPane.showMessageDialog(this, "Insufficient balance.");
        }
        updateFields();
    }

    private void updateFields() {
        accountField.setText(String.valueOf(account.getAccountNumber()));
        nameField.setText(account.getName());
        balanceField.setText(String.valueOf(account.getBalance()));
    }

    public static void main(String[] args) {
        new BankFrame();
    }
}