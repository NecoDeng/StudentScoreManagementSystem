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
import ssms.entity.User;

/**
 * @author VULCAN
 *	 
 * @Project StudentScoreManagementSystem
 *
 * @CreateTime 2019年12月26日 下午10:55:44
 * 
 */
public class SignInPanel extends JPanel{
	
	private JTextField txt_account;
	private JPasswordField txt_password;
	private JTextField txt_username;
	
	public JTextField getTxt_account() {
		return txt_account;
	}


	public JPasswordField getTxt_password() {
		return txt_password;
	}


	public JTextField getTxt_username() {
		return txt_username;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor.
	 */
	public SignInPanel() {
		// TODO Auto-generated constructor stub
		super();
		initPanel();
	}
	
	
	/**
	 * Initialize Panel.
	 */
	public void initPanel() {
		setBackground(Color.cyan);
		setPreferredSize(new Dimension(450, 350));
		setLayout(null);
		
		//title		
		JLabel label_title = new JLabel("SIGN IN ... ");
		label_title.setBounds(150, 15, 200, 50);
		add(label_title);
				
		//account field.
		JLabel label_account = new JLabel("账号");		
		txt_account = new JTextField(15);
		//password field.
		JLabel label_passworld = new JLabel("密码");
		txt_password = new JPasswordField(15);
				
		JLabel label_name = new JLabel("姓名");
		txt_username = new JTextField(15);			
		
		//set account and password bounds.
		txt_account.setBounds(150, 70, 180, 20);
		label_account.setBounds(70, 70, 80, 20);		
		txt_password.setBounds(150, 120, 180, 20);
		label_passworld.setBounds(70, 120, 80, 20);				
		
		label_name.setBounds(70, 170, 80, 20);
		txt_username.setBounds(150, 170, 180, 20);
				
		JButton btn_cancel = new JButton("取消");
		JButton btn_confirm = new JButton("确认");
		btn_confirm.setBounds(100, 220, 100, 20);
		btn_cancel.setBounds(250, 220, 100, 20);
		btn_cancel.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SignInFrame signInFrame = (SignInFrame) getParent().getParent().getParent().getParent();
				signInFrame.dispose();
				new LoginFrame();				
			}
		});
		
		btn_confirm.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String account = txt_account.getText();
				@SuppressWarnings("deprecation")
				String password = txt_password.getText();
				String userName = txt_username.getText();
				if(account.isEmpty() || password.isEmpty() || userName.isEmpty()) {
					JOptionPane.showMessageDialog(getParent(), "账号、密码以及姓名不能为空", "注册提示", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				User user = new User(account, password, userName);
				UserDaoImpl userDaoImp = new UserDaoImpl();
				if(userDaoImp.addUser(user)) {
					JOptionPane.showMessageDialog(getParent(), "用户" + userName + "注册成功\n" + "账号为：" + account, "注册提示", JOptionPane.INFORMATION_MESSAGE);
					SignInFrame signInFrame = (SignInFrame) getParent().getParent().getParent().getParent();
					signInFrame.dispose();
					new LoginFrame();		
					return;
				} 
				System.out.println("用户注册失败");
			}
		});
		
		//add account and password into current panel.
		add(label_account);
		add(label_passworld);		
		add(label_name);		
		add(txt_account);
		add(txt_password);
		add(txt_username);
		add(btn_confirm);
		add(btn_cancel);
	}

}
