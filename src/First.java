import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;

@SuppressWarnings("serial")
public class First extends JFrame {
	int showStatus = 0;
	static Font myFont = new Font("Tahoma", Font.BOLD, 21);
	static Font myFontS = new Font("Tahoma", Font.BOLD, 17);
	static Color darkC = new Color(40, 40, 43);
	static Color lightC = new Color(236, 236, 236);
	static Border border = new LineBorder(Color.white, 2);
	private URL enter = getClass().getResource("images/enter.png");
	private ImageIcon enterI = new ImageIcon(enter);

	public static void main(String[] args) {
		new First();
	}

	First() {
		// Dimension
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth() - 100;
		int height = (int) screenSize.getHeight() - 100;
		// remove button focus border
		UIDefaults defaults = UIManager.getLookAndFeelDefaults();
		defaults.put("Button.focus", new ColorUIResource(new Color(0, 0, 0, 0)));
		// Frame and panel
		this.setTitle("CEDROS");
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setAlwaysOnTop(false);
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		this.getContentPane().setBackground(darkC);
		this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/icon.png")).getImage());
		// Close popup
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				Object[] options = { "Si", "No" };
				int selectedOption = JOptionPane.showOptionDialog(null, "¿Seguro que quieres salir?", "SALIR",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if (selectedOption == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});

		// Logo
		URL url = getClass().getResource("images/icon.png");
		ImageIcon icon = new ImageIcon(url);
		JLabel photo = new JLabel(icon);
		photo.setBounds((width - width / 3) / 2, 0, width / 3, height / 2);

		// Stuff
		JLabel inputText = new JLabel("Escribe la contraseña");
		inputText.setBounds(0, height / 4, width, height / 2);
		inputText.setHorizontalAlignment(0);
		inputText.setFont(myFont);
		inputText.setForeground(lightC);
		JPasswordField passTF = new JPasswordField();
		passTF.setBounds((width - width / 3) / 2, height * 3 / 5, width / 3, 50);
		textFieldStyle(passTF);
		JButton showHide = new JButton("Mostrar");
		showHide.setBounds((width - width / 3) / 2 + passTF.getWidth(), height * 3 / 5, 100, 50);
		btnStyle(showHide);
		showHide.addActionListener(e -> {
			if (showStatus == 0) {
				passTF.setEchoChar((char) 0);
				showStatus = 1;
				showHide.setText("Ocultar");
			} else {
				passTF.setEchoChar('*');
				showStatus = 0;
				showHide.setText("Mostrar");
			}
		});
		// cierre de caja
		JButton login = new JButton();
		login.setIcon(new ImageIcon(getScaledImage(enterI.getImage(), 100, 100)));
		login.setBounds((width - 100) / 2, height * 5 / 7, 100, 100);
		login.setOpaque(false);
		login.setContentAreaFilled(false);
		login.setBorderPainted(false);
		login.addActionListener(e -> {
			if (String.valueOf(passTF.getPassword()).equals("Teoria2019")
					|| String.valueOf(passTF.getPassword()).equals("")) {
				passTF.setText("");
				this.dispose();
				new Reales();
			} else {
				JOptionPane.showMessageDialog(null,
						"<html><div style=color:red>Contraseña Incorrecta.</div><div style=color:blue>Pista: Contraseña de la tienda!</div></html>",
						"Atencion", JOptionPane.ERROR_MESSAGE);
				passTF.selectAll();
			}
		});

		// MenuBar
		JMenuBar mb = new JMenuBar();
		JMenu file = new JMenu("AYUDA");
		JMenuItem exit = new JMenuItem("SALIR");
		JMenuItem about = new JMenuItem("SOBRE EL APLICATIVO");
		about.addActionListener(
				e -> JOptionPane.showMessageDialog(null, "Crédito y Diseñado por MhmdSAbdlh ©", "SOBRE MI", 1));
		exit.addActionListener(e -> System.exit(0));
		file.add(about);
		file.add(exit);
		mb.add(file);

		// Add to frame
		this.setJMenuBar(mb);
		this.add(photo);
		this.add(login);
		this.add(showHide);
		this.add(passTF);
		this.add(inputText);
		this.getRootPane().setDefaultButton(login);
		this.setVisible(true);
	}

	// Style of the buttons
	static void btnStyle(JButton btn) {
		btn.setBorder(border);
		btn.setBackground(lightC);
		btn.setForeground(darkC);
		btn.setFocusable(false);
		btn.setHorizontalAlignment(0);
		btn.setFont(myFont);
	}

	// Style of textField
	private static void textFieldStyle(JTextField tf) {
		tf.setBackground(new Color(73, 113, 116));
		tf.setForeground(darkC);
		tf.setFont(myFont);
		tf.setBorder(border);
		tf.setHorizontalAlignment(0);
		tf.setCaretColor(lightC);
	}

	static void labelStyle(JLabel label) {
		label.setBorder(border);
		label.setBackground(lightC);
		label.setForeground(darkC);
		label.setFocusable(false);
		label.setHorizontalAlignment(0);
		label.setOpaque(true);
		label.setFont(myFont);
	}

	private Image getScaledImage(Image srcImg, int w, int h) {
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(srcImg, 0, 0, w, h, null);
		g2.dispose();

		return resizedImg;
	}

}

class InitialFocusSetter {
	public static void setInitialFocus(Window w, Component c) {
		w.addWindowListener(new FocusSetter(c));
	}
}

class FocusSetter extends WindowAdapter {
	Component initComp;

	FocusSetter(Component c) {
		initComp = c;
	}

	public void windowOpened(WindowEvent e) {
		initComp.requestFocus();
		e.getWindow().removeWindowListener(this);
	}
}
