package edu.yccc.java.samples.slack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Slack {

	private JFrame frmSlackMessenger;
	private SlackService ss = new SlackService();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Slack window = new Slack();
					window.frmSlackMessenger.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Slack() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSlackMessenger = new JFrame();
		frmSlackMessenger
				.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\velik\\Desktop\\Slack_Icon.png"));
		frmSlackMessenger.setTitle("Slack Messenger");
		frmSlackMessenger.setBounds(100, 100, 800, 326);
		frmSlackMessenger.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSlackMessenger.getContentPane().setLayout(null);

		JRadioButton rdbtnMessageSlack = new JRadioButton("Message #slack_test");
		rdbtnMessageSlack.setBounds(33, 42, 243, 35);
		frmSlackMessenger.getContentPane().add(rdbtnMessageSlack);

		JRadioButton rdbtnMessageGeneral = new JRadioButton("Message #general");
		rdbtnMessageGeneral.setBounds(272, 42, 234, 35);
		frmSlackMessenger.getContentPane().add(rdbtnMessageGeneral);

		JRadioButton rdbtnMessageVince = new JRadioButton("Message Vince");
		rdbtnMessageVince.setBounds(497, 42, 201, 35);
		frmSlackMessenger.getContentPane().add(rdbtnMessageVince);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(21, 180, 422, 54);
		frmSlackMessenger.getContentPane().add(textArea);
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnMessageGeneral);
		group.add(rdbtnMessageSlack);
		group.add(rdbtnMessageVince);

		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnMessageGeneral.isSelected()) {
					ss.sendMessage("#general", "Vince", textArea.getText());
					textArea.setText(null);
					group.clearSelection();
				}
				if (rdbtnMessageSlack.isSelected()) {
					ss.sendMessage("#slack_test", "Vince", textArea.getText());
					textArea.setText(null);
					group.clearSelection();
				}
				if (rdbtnMessageVince.isSelected()) {
					ss.sendMessage("@Vince", "Vince", textArea.getText());
					textArea.setText(null);
					group.clearSelection();
				}

			}
		});
		btnSend.setBounds(493, 180, 168, 54);
		frmSlackMessenger.getContentPane().add(btnSend);

	}
}
