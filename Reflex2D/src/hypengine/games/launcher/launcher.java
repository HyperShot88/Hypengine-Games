package hypengine.games.launcher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import hypengine.games.Reflex2D.*;

public class launcher {
	
	private static int width = 1200;
	private static int height = 800;

	public static void main(String args[]) {
		JFrame frame = new JFrame("Reflex2D Login");
		frame.setSize(300, 245);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel);
		start(panel);

		frame.setVisible(true);
	}

	private static void start(JPanel panel) {
		panel.setLayout(null);
		final JLabel jlbl = new JLabel();

		final JTextField txtField = new JTextField(50);
		txtField.setBounds(60, 10, 170, 25);
		txtField.setText("Username");
		panel.add(txtField);

		final JPasswordField pwdField = new JPasswordField(255);
		pwdField.setBounds(60, 40, 170, 25);
		pwdField.setText("Password");
		panel.add(pwdField);
		
		final JTextField widthField = new JTextField(5);
		widthField.setBounds(60, 70, 170, 25);
		widthField.setText("Width");
		panel.add(widthField);
		
		final JTextField heightField = new JTextField(5);
		heightField.setBounds(60, 100, 170, 25);
		heightField.setText("Height");
		panel.add(heightField);

		JButton btnSubmit = new JButton();
		btnSubmit.setBounds(105, 140, 80, 25);
		btnSubmit.setText("Login");
		btnSubmit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String user = "";
				String pass = "";
				String active = "";
				String pwdChange = "";

				String playerPwd = "";
				String playerName = txtField.getText();
				System.out.println(playerName);

				String url = "jdbc:mysql://johnny.heliohost.org:3306/";
				String dbName = "hachaud3_hypengine";
				String driver = "com.mysql.jdbc.Driver";
				String uname = "hachaud3_java";
				String dbPass = "8Pg4VFBsODIi";

				try {
					width = Integer.parseInt(widthField.getText());
					height = Integer.parseInt(heightField.getText());
					playerPwd = pwdField.getText();
					Class.forName(driver).newInstance();
					Connection con = DriverManager.getConnection(url + dbName,
							uname, dbPass);

					Statement statement = con.createStatement();
					ResultSet resultSet = statement
							.executeQuery("SELECT * FROM reflex WHERE USERNAME='"
									+ playerName + "'");
					if (resultSet.next()) {
						user = resultSet.getString("USERNAME");
						pass = resultSet.getString("PASSWORD");
						active = resultSet.getString("active");
						pwdChange = resultSet.getString("tempwd");

					}

					con.close();
				} catch (NumberFormatException n) {
					jlbl.setText("Incorrect width/height!");
				} catch (SQLException s) {
					s.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}

				try {
					if (playerName.equals(user)) {
						if (!pwdChange.equals("1")) {
							if (!playerPwd.equals(pass)) {
								// wrong password notification
								jlbl.setText("<html><font color=red>Invalid password!</font></html>");
								return;
							}
							Reflex2D reflex = new Reflex2D("Reflex 2D");
							reflex.main(null);
							//System.exit(0);
							//jlbl.setText("<html><font color=red>Correct password!</font></html>");
						} else if (pwdChange.equals("1")) {
							if (!pass.equals(createMD5(playerPwd))) {
								// wrong password notification
								jlbl.setText("<html><font color=red>Invalid password!</font></html>");
								return;
							}
							Reflex2D reflex = new Reflex2D("Reflex 2D");
							reflex.main(null);
							//System.exit(0);
							//jlbl.setText("<html><font color=red>Correct password!</font></html>");
						} else if (!active.equals("1")) {
							// activate email notification
							jlbl.setText("<html><font color=red>Please activate login!</font></html>");
							System.out.println(playerPwd);
							System.out.println(pass);
							return;
						} else if (!pwdChange.equals("1")) {
							// open a dialog box to change password
							return;
						} else {
							// open game & exit
							Reflex2D reflex = new Reflex2D("Reflex 2D", height, width);
							reflex.main(null);
							//System.exit(0);
						}
					} else {
						// wrong username notification
						jlbl.setText("<html><font color=red>Invalid username!</font></html>");
						return;
					}
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
					System.exit(1);
				}

			}
		});
		panel.add(btnSubmit);
		
		jlbl.setHorizontalTextPosition(JLabel.CENTER);
		jlbl.setBounds(90, 170, 100, 25);
		panel.add(jlbl);
	}

	private static String createMD5(String str) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(str.getBytes());
		byte byteData[] = md.digest();

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
					.substring(1));
		}
		return sb.toString();
	}

}
