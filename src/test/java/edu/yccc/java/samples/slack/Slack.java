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

/***
 * Maven is a tool, which defines how your .java files will get compiled to
 * .class files and then packaged into .jar files. Jar is a package file format
 * typically used to aggregate many Java class files into one file to distribute
 * application software or libraries on the Java platform.
 * 
 * @author Vince
 *
 */

public class Slack {

	private JFrame frmSlackMessenger;
	// Creating an instance of SlackService object. It will inherit all of the
	// methods from SlackService class.
	private SlackService ss = new SlackService();
	private String userName = "Vince";

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
		frmSlackMessenger.setIconImage(Toolkit.getDefaultToolkit().getImage("Slack_Icon.png"));
		frmSlackMessenger.setTitle("Slack Messenger");
		frmSlackMessenger.setBounds(100, 100, 800, 326);
		frmSlackMessenger.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSlackMessenger.getContentPane().setLayout(null);

		JRadioButton rdbtnMessageSlack = new JRadioButton("Message #slack_test");
		rdbtnMessageSlack.setBounds(33, 42, 243, 35);
		frmSlackMessenger.getContentPane().add(rdbtnMessageSlack);

		JRadioButton rdbtnMessageGeneral = new JRadioButton("Message #general");
		rdbtnMessageGeneral.setBounds(272, 42, 225, 35);
		frmSlackMessenger.getContentPane().add(rdbtnMessageGeneral);

		JRadioButton rdbtnMessageMike = new JRadioButton("Message Mike");
		rdbtnMessageMike.setBounds(497, 42, 201, 35);
		frmSlackMessenger.getContentPane().add(rdbtnMessageMike);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(21, 180, 422, 54);
		frmSlackMessenger.getContentPane().add(textArea);
		// Creating group for the radio buttons.
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnMessageGeneral);
		group.add(rdbtnMessageSlack);
		group.add(rdbtnMessageMike);

		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnMessageGeneral.isSelected()) {
					ss.sendMessage("#general", userName, textArea.getText());
					textArea.setText(null);
					group.clearSelection();
				}
				if (rdbtnMessageSlack.isSelected()) {
					ss.sendMessage("#slack_test", userName, textArea.getText());
					textArea.setText(null);
					group.clearSelection();
				}
				if (rdbtnMessageMike.isSelected()) {
					ss.sendMessage("U795A112Q", userName, textArea.getText());
					textArea.setText(null);
					group.clearSelection();
				}
			}
		});
		btnSend.setBounds(493, 180, 168, 54);
		frmSlackMessenger.getContentPane().add(btnSend);
	}
}
