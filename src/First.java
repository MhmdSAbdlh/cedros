import java.awt.*;
import java.awt.Window;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.MetalToggleButtonUI;

@SuppressWarnings("serial")
public class First extends JFrame {
	int showStatus = 0;
	static Font myFont = new Font("Tahoma", Font.BOLD, 21);
	static Font myFontS = new Font("Tahoma", Font.BOLD, 17);
	// Colores
	static Color redC = new Color(254, 74, 74);
	static Color redD = new Color(161, 48, 48);
	static Color greenD = new Color(56, 161, 48);
	static Color greenC = new Color(74, 220, 63);
	static Color grisD = new Color(212, 212, 212);
	static Color blueD = new Color(48, 107, 161);
	static Color blueC = new Color(70, 156, 235);
	static Color darkC = new Color(40, 40, 43);
	static Color lightC = new Color(236, 236, 236);
	static Border border = new LineBorder(Color.white, 2);
	private URL enter = getClass().getResource("images/enter.png");
	private ImageIcon enterI = new ImageIcon(enter);
	private URL icon = getClass().getResource("images/icon/icon.png");
	private ImageIcon iconI = new ImageIcon(icon);
	private URL setting = getClass().getResource("images/setting.png");
	private ImageIcon settingI = new ImageIcon(setting);

	public static void main(String[] args) {
		new First();
	}

	First() {
		// Open Conf
		BufferedReader dataOpened = null;
		String line = "";
		int z = 0;
		String conf[] = new String[4];
		try {
			dataOpened = new BufferedReader(new FileReader(new File("conf.txt")));
			while ((line = dataOpened.readLine()) != null) {
				conf[z] = line.toString();
				z++;
			}
			dataOpened.close();
		} catch (Exception e) {
		}

		// Dimension
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth() - 100;
		int height = (int) screenSize.getHeight() - 100;
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setAlwaysOnTop(false);
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		this.getContentPane().setBackground(darkC);

		// Logo
		URL url;
		iconI = new ImageIcon(getScaledImage(iconI.getImage(), 50, 50));
		if (conf[0] == null || conf[0].equals("0")) {
			this.setTitle("CEDROS");
			url = getClass().getResource("images/icon/icon.png");
		} else if (conf[0].equals("1")) {
			url = getClass().getResource("images/icon/cedros.png");
			this.setTitle("CEDROS");
		} else {
			url = getClass().getResource("images/icon/narjes.png");
			this.setTitle("NARJES");
		}
		this.setIconImage(new ImageIcon(url).getImage());

		// Stuff
		JButton settingL = new JButton();
		ImageIcon photo = new ImageIcon(url);
		JLabel photoLabel = new JLabel();
		JLabel inputText = new JLabel("Escribe la contraseña");
		JPasswordField passTF = new JPasswordField();
		JButton showHide = new JButton("Mostrar");
		settingL.setContentAreaFilled(false);
		settingL.setBorderPainted(false);
		settingL.setBounds(width - 115, 20, 75, 75);
		settingI = new ImageIcon(getScaledImage(settingI.getImage(), 75, 75));
		settingL.setIcon(settingI);
		settingL.addActionListener(e -> confFrame(conf, height, photoLabel));
		photo = new ImageIcon(getScaledImage(photo.getImage(), height / 3, height / 3));
		photoLabel.setBounds((width - height / 3) / 2, 50, height / 3, height / 3);
		photoLabel.setIcon(photo);
		inputText.setBounds(0, height / 4, width, height / 2);
		inputText.setHorizontalAlignment(0);
		inputText.setFont(myFont);
		inputText.setForeground(lightC);
		passTF.setBounds((width - width / 3) / 2, height * 3 / 5, width / 3, 50);
		textFieldStyle(passTF);
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
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				passTF.requestFocus();
			}
		});
		passTF.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyCode() == KeyEvent.VK_O) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0))
					confFrame(conf, height, photoLabel);

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
		JMenuItem option = new JMenuItem("CONFIGURACIÓN");
		about.addActionListener(
				e -> JOptionPane.showMessageDialog(null, "Crédito y Diseñado por MhmdSAbdlh ©", "SOBRE MI", 1));
		option.addActionListener(e -> confFrame(conf, height, photoLabel));
		exit.addActionListener(e -> System.exit(0));
		file.add(option);
		file.add(about);
		file.add(exit);
		mb.add(file);

		// Add to frame
		this.setJMenuBar(mb);
		this.add(settingL);
		this.add(photoLabel);
		this.add(login);
		this.add(showHide);
		this.add(passTF);
		this.add(inputText);
		this.getRootPane().setDefaultButton(login);
		this.setVisible(true);

		// remove button focus border
		UIDefaults defaults = UIManager.getLookAndFeelDefaults();
		defaults.put("Button.focus", new ColorUIResource(new Color(0, 0, 0, 0)));

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

		// Disable btn color
		defaults.put("Button.disabledText", new ColorUIResource(Color.white));
		defaults.put("textInactiveText", UIManager.get("Button.disabledText"));

	}

	private void confFrame(String[] conf, int height, JLabel photoLabel) {
		JFrame temp = new JFrame();
		temp.setTitle("CONFIGURACIÓN");
		temp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		temp.setAlwaysOnTop(false);
		temp.setSize(500, 500);
		temp.setLocationRelativeTo(null);
		temp.setResizable(false);
		temp.setLayout(null);
		temp.getContentPane().setBackground(lightC);
		// Stuff
		JLabel op1 = new JLabel("ICONO");
		op1.setBounds(50, 20, 150, 80);
		op1.setFont(myFont);
		URL cedros1 = getClass().getResource("images/icon/icon.png");
		URL cedros2 = getClass().getResource("images/icon/cedros.png");
		URL narjes = getClass().getResource("images/icon/narjes.png");
		ImageIcon iconImages[] = new ImageIcon[3];
		iconImages[0] = new ImageIcon(cedros1);
		iconImages[1] = new ImageIcon(cedros2);
		iconImages[2] = new ImageIcon(narjes);
		iconImages[0] = new ImageIcon(getScaledImage(iconImages[0].getImage(), 50, 50));
		iconImages[1] = new ImageIcon(getScaledImage(iconImages[1].getImage(), 50, 50));
		iconImages[2] = new ImageIcon(getScaledImage(iconImages[2].getImage(), 50, 50));
		JComboBox<ImageIcon> op1C = new JComboBox<>(iconImages);
		op1C.setBounds(320, 20, 80, 80);
		if (conf[0] != null)
			op1C.setSelectedIndex(Integer.valueOf(conf[0]));
		op1C.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				iconImages[0] = new ImageIcon(
						getScaledImage(new ImageIcon(cedros1).getImage(), height / 3, height / 3));
				iconImages[1] = new ImageIcon(
						getScaledImage(new ImageIcon(cedros2).getImage(), height / 3, height / 3));
				iconImages[2] = new ImageIcon(getScaledImage(new ImageIcon(narjes).getImage(), height / 3, height / 3));
				photoLabel.setIcon(iconImages[op1C.getSelectedIndex()]);
				First.this.setIconImage(iconImages[op1C.getSelectedIndex()].getImage());
				if (op1C.getSelectedIndex() == 2)
					First.this.setTitle("NARJES");
				else
					First.this.setTitle("CEDROS");
				op1C.setSelectedIndex(op1C.getSelectedIndex());
			}
		});
		// OPTION 2 BUTTONS HIDE
		JLabel op2 = new JLabel("BOTONES");
		op2.setBounds(50, 120, 150, 50);
		op2.setFont(myFont);
		JToggleButton btnsHideShow = new JToggleButton();
		if (conf[1] == null || conf[1].equals("false")) {
			btnsHideShow.setText("SI");
		} else {
			btnsHideShow.setText("NO");
			btnsHideShow.setSelected(true);
		}
		btnsHideShow.setBounds(320, 120, 80, 50);
		btnsHideShow.setFont(myFont);
		btnsHideShow.setBorder(border);
		btnsHideShow.setBackground(greenC);
		btnsHideShow.setForeground(lightC);
		btnsHideShow.setFocusable(false);
		btnsHideShow.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnsHideShow.setBackground(greenC);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnsHideShow.setBackground(greenD);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnsHideShow.setUI(new MetalToggleButtonUI() {
			@Override
			protected Color getSelectColor() {
				return redC;
			}
		});
		btnsHideShow.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					btnsHideShow.setText("NO");
				else
					btnsHideShow.setText("SI");
			}
		});
		// OPTION 3 DISABLE KEYBOARD SHORTCUT
		JLabel op3 = new JLabel("ATAJO DE TECLADO");
		op3.setBounds(50, 190, 250, 50);
		op3.setFont(myFont);
		JToggleButton btnsHideShow2 = new JToggleButton();
		if (conf[2] == null || conf[2].equals("false")) {
			btnsHideShow2.setText("SI");
		} else {
			btnsHideShow2.setText("NO");
			btnsHideShow2.setSelected(true);
		}
		btnsHideShow2.setBounds(320, 190, 80, 50);
		btnsHideShow2.setFont(myFont);
		btnsHideShow2.setBorder(border);
		btnsHideShow2.setBackground(greenC);
		btnsHideShow2.setForeground(lightC);
		btnsHideShow2.setFocusable(false);
		btnsHideShow2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnsHideShow2.setBackground(greenC);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnsHideShow2.setBackground(greenD);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnsHideShow2.setUI(new MetalToggleButtonUI() {
			@Override
			protected Color getSelectColor() {
				return redC;
			}
		});
		btnsHideShow2.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					btnsHideShow2.setText("NO");
				else
					btnsHideShow2.setText("SI");
			}
		});

		// OPTION 4 CHANGE RESOLUTION
		JLabel op4 = new JLabel("RESOLUCIÓN");
		op4.setBounds(50, 260, 250, 50);
		op4.setFont(myFont);
		String res[] = { "OPTIMAL", "X-P", "P", "M", "G" };
		JComboBox<String> op2C = new JComboBox<>(res);
		op2C.setBounds(280, 260, 140, 50);
		op2C.setFont(myFont);
		op2C.setBackground(blueC);
		op2C.setForeground(darkC);
		if (conf[3] != null)
			op2C.setSelectedIndex(Integer.valueOf(conf[3]));
		op2C.addActionListener(e -> op2C.setSelectedIndex(op2C.getSelectedIndex()));

		// SAVE
		JButton save = new JButton("Save");
		save.setBounds(200, 400, 100, 50);
		btnStyle(save);
		save.setBackground(darkC);
		save.setForeground(lightC);
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					FileWriter savedF = new FileWriter("conf.txt");
					savedF.write(op1C.getSelectedIndex() + System.lineSeparator());
					savedF.write(btnsHideShow.isSelected() + System.lineSeparator());
					savedF.write(btnsHideShow2.isSelected() + System.lineSeparator());
					savedF.write(op2C.getSelectedIndex() + System.lineSeparator());
					savedF.close();
				} catch (Exception e2) {
				}
				temp.dispose();
			}
		});

		// Escape to close
		op1C.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("static-access")
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyCode() == ke.VK_ESCAPE)
					temp.dispose();
			}
		});

		// Finalize
		temp.setIconImage(iconImages[0].getImage());
		temp.add(op1);
		temp.add(op1C);
		temp.add(op2);
		temp.add(op3);
		temp.add(btnsHideShow);
		temp.add(btnsHideShow2);
		temp.add(op2C);
		temp.add(op4);
		temp.add(save);
		temp.setVisible(true);
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

	// Check the input text if it is a number

	static boolean isNumeric(String number) {
		try {
			Integer.parseInt(number);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	// String to titlecase

	static String capitalizeString(String string) {
		char[] chars = string.toLowerCase().toCharArray();
		boolean found = false;
		for (int i = 0; i < chars.length; i++) {
			if (!found && Character.isLetter(chars[i])) {
				chars[i] = Character.toUpperCase(chars[i]);
				found = true;
			} else if (Character.isWhitespace(chars[i]) || chars[i] == '.' || chars[i] == '\'') { // You can add other
																									// chars here
				found = false;
			}
		}
		return String.valueOf(chars);
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
