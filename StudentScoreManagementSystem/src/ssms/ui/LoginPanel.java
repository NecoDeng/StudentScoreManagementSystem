package ssms.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ssms.dal.daoImp.UserDaoImpl;

public class LoginPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private JTextField txt_account;
	private JPasswordField txt_password;
	
	
	public JTextField getTxt_account() {
		return txt_account;
	}

	public JPasswordField getTxt_password() {
		return txt_password;
	}

	
	/**
	 * Constructor.
	 */
	public LoginPanel() {
		// TODO Auto-generated constructor stub
		super();
		initPanel();
	}

	/**
	 * Initialize Panel.
	 */
	public void initPanel() {
		setBackground(Color.cyan);
		setPreferredSize(new Dimension(400, 300));
		setLayout(null);
		
		//title		
		JLabel label_title = new JLabel("Login ... ");
		label_title.setBounds(100, 30, 200, 50);
		add(label_title);				
		
		//account field.
		JLabel label_account = new JLabel("ÕË  ºÅ");		
		txt_account = new JTextField(15);
		//password field.
		JLabel label_passworld = new JLabel("ÃÜ  Âë");
		txt_password = new JPasswordField(15);
				
		//set account and password bounds.
		txt_account.setBounds(140, 100, 180, 20);
		label_account.setBounds(70, 100, 60, 20);		
		txt_password.setBounds(140, 150, 180, 20);
		label_passworld.setBounds(70, 150, 60, 20);		
		
		//add account and password into current panel.
		add(txt_account);
		add(txt_password);
		add(label_account);
		add(label_passworld);		
		
		//init the buttons
		JButton btn_login = new JButton("µÇ  Â¼");
		JButton btn_signIn = new JButton("×¢  ²á");
		
		//set the buttons bounds
		btn_login.setBounds(220, 200, 100, 25);
		btn_signIn.setBounds(70, 200, 100, 25);
		
		//set the actionListeners.
		btn_login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 String account=txt_account.getText();
			     @SuppressWarnings("deprecation")
			     String password=txt_password.getText();
			     if (account.isEmpty() || password.isEmpty()) {
			    	 JOptionPane.showMessageDialog(getParent(), "ÕËºÅ»òÃÜÂë²»ÄÜÎª¿Õ", "µÇÂ¼ÌáÊ¾", JOptionPane.INFORMATION_MESSAGE);
			    	 return;
			     }
			     UserDaoImpl userDaoImpl=new UserDaoImpl();			     
			     if(userDaoImpl.certifyUser(account, password)) {
			    	 System.out.println("µÇÂ½³É¹¦£¡£¡£¡£¡");
			    	 LoginFrame loginFrame = (LoginFrame) getParent().getParent().getParent().getParent();
			    	 if (loginFrame != null) loginFrame.dispose();
			    	 new MainFrame();
			    	 return;
			     }
				 JOptionPane.showMessageDialog(getParent(), "ÕËºÅ»òÃÜÂë²»Æ¥Åä£¬µÇÂ¼Ê§°Ü", "µÇÂ¼ÌáÊ¾", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		btn_signIn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LoginFrame loginFrame = (LoginFrame) getParent().getParent().getParent().getParent();
				if (loginFrame != null) loginFrame.dispose();
				new SignInFrame();
			}
		});
		
		
		add(btn_login);
		add(btn_signIn);
	}

}
