import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.MetalToggleButtonUI;

@SuppressWarnings("serial")
public class First extends JFrame {
	int showStatus = 0;
	static Font myFont = new Font("Tahoma", Font.BOLD, 21);
	static Font myFontS = new Font("Tahoma", Font.BOLD, 17);
	static Font myFontXS = new Font("Tahoma", Font.ITALIC, 15);
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
	static Border workM = new LineBorder(Color.yellow, 3);
	private URL enter = getClass().getResource("images/enter.png");
	private ImageIcon enterI = new ImageIcon(enter);
	private URL icon = getClass().getResource("images/icon/cedros0.png");
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
		String conf[] = new String[7];
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
			url = getClass().getResource("images/icon/cedros0.png");
		} else if (conf[0].equals("1")) {
			url = getClass().getResource("images/icon/cedros1.png");
			this.setTitle("CEDROS");
		} else if (conf[0].equals("2")) {
			url = getClass().getResource("images/icon/cedros2.png");
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
			}

			@Override
			public void keyReleased(KeyEvent e) {
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
				if (conf[5] == null || conf[5].equals("null") || conf[5].equals("0"))
					new Reales();
				else if (conf[5].equals("1"))
					new Pesos();
				else if (conf[5].equals("2"))
					new FaturaR();
				else
					new FaturaP();
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
		JMenuItem creator = new JMenuItem("SOBRE EL CREADOR");
		JMenuItem about = new JMenuItem("SOBRE EL APLICATIVO");
		JMenuItem option = new JMenuItem("CONFIGURACIÓN");
		creator.addActionListener(
				e -> JOptionPane.showMessageDialog(null, "Crédito y Diseñado por MhmdSAbdlh ©", "SOBRE MI", 1));
		about.addActionListener(e -> JOptionPane.showMessageDialog(null,
				"ESTA APLICACIÓN ESTÁ DISEÑADA PARA CEDROS Y NARJES FREE SHOP.\r\n"
						+ "TIENE MARCO PARA CERRAR LA CAJA TANTO EN REALES COMO PESOS.\r\n"
						+ "TIENE UN MARCO PARA CALCULAR EL TROCO DE UNA VENTA TANTO EN REALES COMO PESOS.\r\n"
						+ "SABE CÓMO QUEDARÁ PARA EL PRÓXIMO DÍA.\r\n" + "3 MÉTODOS PARA DAR EL CAMBIO.\r\n"
						+ "CAMBIARÁ TODO SEGÚN EL ICONO SELECCIONADO.\r\n" + "\r\n" + "MOHAMAD ABDALLAH ABBASS ©",
				"CEDROS/NARJES", 1));
		option.addActionListener(e -> confFrame(conf, height, photoLabel));
		exit.addActionListener(e -> System.exit(0));
		file.add(option);
		file.add(creator);
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
		temp.setSize(650, 550);
		temp.setLocationRelativeTo(null);
		temp.setResizable(false);
		temp.setLayout(null);
		temp.getContentPane().setBackground(grisD);
		//
		DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
		dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		// Op1 icon
		JLabel op1 = new JLabel("ICONO");
		op1.setBounds(50, 20, 150, 50);
		op1.setFont(myFont);
		URL cedros1 = getClass().getResource("images/icon/cedros0.png");
		URL cedros2 = getClass().getResource("images/icon/cedros1.png");
		URL cedros3 = getClass().getResource("images/icon/cedros2.png");
		URL narjes = getClass().getResource("images/icon/narjes.png");
		ImageIcon iconImages[] = new ImageIcon[4];
		iconImages[0] = new ImageIcon(getScaledImage(new ImageIcon(cedros1).getImage(), 50, 50));
		iconImages[1] = new ImageIcon(getScaledImage(new ImageIcon(cedros2).getImage(), 50, 50));
		iconImages[2] = new ImageIcon(getScaledImage(new ImageIcon(cedros3).getImage(), 50, 50));
		iconImages[3] = new ImageIcon(getScaledImage(new ImageIcon(narjes).getImage(), 50, 50));
		JComboBox<ImageIcon> op1C = new JComboBox<>(iconImages);
		op1C.setRenderer(dlcr);
		op1C.setBorder(new EmptyBorder(0, 0, 0, 0));
		op1C.setBounds(420, 20, 70, 50);
		op1C.setBackground(lightC);
		if (conf[0] != null && isNumeric(conf[0]))
			op1C.setSelectedIndex(Integer.valueOf(conf[0]));
		op1C.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				iconImages[0] = new ImageIcon(
						getScaledImage(new ImageIcon(cedros1).getImage(), height / 3, height / 3));
				iconImages[1] = new ImageIcon(
						getScaledImage(new ImageIcon(cedros2).getImage(), height / 3, height / 3));
				iconImages[2] = new ImageIcon(
						getScaledImage(new ImageIcon(cedros3).getImage(), 2 * height / 3, height / 3));
				iconImages[3] = new ImageIcon(getScaledImage(new ImageIcon(narjes).getImage(), height / 3, height / 3));
				photoLabel.setIcon(iconImages[op1C.getSelectedIndex()]);
				if (op1C.getSelectedIndex() == 2)
					photoLabel.setBounds(photoLabel.getX(), 50, 2 * height / 3, height / 3);
				else
					photoLabel.setBounds(photoLabel.getX(), 50, height / 3, height / 3);
				First.this.setIconImage(iconImages[op1C.getSelectedIndex()].getImage());
				if (op1C.getSelectedIndex() == 3)
					First.this.setTitle("NARJES");
				else
					First.this.setTitle("CEDROS");
				op1C.setSelectedIndex(op1C.getSelectedIndex());
			}
		});
		// OPTION 2 BUTTONS HIDE
		JLabel op2 = new JLabel("ESCONDER");
		op2.setBounds(50, 90, 150, 40);
		op2.setFont(myFont);
		String hOp[] = { "NADA", "LA FECHA", "LA FECHA Y LOS BOTONES" };
		JComboBox<String> btnsHideShow = new JComboBox<String>(hOp);
		btnsHideShow.setRenderer(dlcr);
		if (conf[1] != null && isNumeric(conf[1]))
			btnsHideShow.setSelectedIndex(Integer.valueOf(conf[1]));
		btnsHideShow.setBounds(305, 90, 300, 40);
		btnsHideShow.setFont(First.myFontS);
		btnsHideShow.setBackground(lightC);
		btnsHideShow.setForeground(blueD);
		btnsHideShow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				op1C.setSelectedIndex(op1C.getSelectedIndex());
			}
		});

		// OPTION 3 CHANGE RESOLUTION
		JLabel op4 = new JLabel("RESOLUCIÓN");
		op4.setBounds(50, 160, 250, 40);
		op4.setFont(myFont);
		String res[] = { "OPTIMAL", "X-P", "P", "M", "G" };
		JComboBox<String> op2C = new JComboBox<>(res);
		op2C.setRenderer(dlcr);
		op2C.setBounds(365, 160, 180, 40);
		op2C.setFont(First.myFontS);
		op2C.setBackground(lightC);
		op2C.setForeground(blueD);
		if (conf[3] != null && isNumeric(conf[3]))
			op2C.setSelectedIndex(Integer.valueOf(conf[3]));
		op2C.addActionListener(e -> op2C.setSelectedIndex(op2C.getSelectedIndex()));

		// op4 default tab
		JLabel op6 = new JLabel("PRIMER CUADRO");
		op6.setBounds(50, 230, 280, 40);
		op6.setFont(myFont);
		String opDT[] = { "REALES", "PESOS", "FATURA R", "FATURA P" };
		JComboBox<String> op3C = new JComboBox<>(opDT);
		op3C.setRenderer(dlcr);
		op3C.setBounds(365, 230, 180, 40);
		op3C.setBackground(lightC);
		op3C.setForeground(blueD);
		op3C.setFont(myFontS);
		if (conf[5] != null && isNumeric(conf[5]))
			op3C.setSelectedIndex(Integer.valueOf(conf[5]));
		op3C.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				op3C.setSelectedIndex(op3C.getSelectedIndex());
			}
		});
		// OPTION 5 DISABLE KEYBOARD SHORTCUT
		JLabel op3 = new JLabel("ATAJO DE TECLADO");
		op3.setBounds(50, 300, 250, 40);
		op3.setFont(myFont);
		JToggleButton btnsHideShow2 = new JToggleButton();
		if (conf[2] == null || !conf[2].equals("true")) {
			btnsHideShow2.setText("SI");
		} else {
			btnsHideShow2.setText("NO");
			btnsHideShow2.setSelected(true);
		}
		btnsHideShow2.setBounds(415, 300, 80, 40);
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

		// OPTION 6 AUTOSAVE
		JLabel op5 = new JLabel("AUTOGUARDAR");
		op5.setBounds(50, 370, 200, 40);
		op5.setFont(myFont);
		JToggleButton btnsHideShow3 = new JToggleButton();
		if (conf[4] == null || !conf[4].equals("true")) {
			btnsHideShow3.setText("SI");
		} else {
			btnsHideShow3.setText("NO");
			btnsHideShow3.setSelected(true);
		}
		btnsHideShow3.setBounds(415, 370, 80, 40);
		btnsHideShow3.setFont(myFont);
		btnsHideShow3.setBorder(border);
		btnsHideShow3.setBackground(greenC);
		btnsHideShow3.setForeground(lightC);
		btnsHideShow3.setFocusable(false);
		btnsHideShow3.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnsHideShow3.setBackground(greenC);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnsHideShow3.setBackground(greenD);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnsHideShow3.setUI(new MetalToggleButtonUI() {
			@Override
			protected Color getSelectColor() {
				return redC;
			}
		});
		btnsHideShow3.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					btnsHideShow3.setText("NO");
				else
					btnsHideShow3.setText("SI");
			}
		});

		// Bottom line
		JButton defSet = new JButton("POR DEFECTO");
		defSet.setBounds(120, 440, 200, 50);
		First.btnStyle(defSet);
		defSet.setBackground(redC);
		defSet.setForeground(Color.white);
		defSet.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				defSet.setBackground(redC);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				defSet.setBackground(redD);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		defSet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				op1C.setSelectedIndex(0);
				First.this.setIconImage(iconImages[0].getImage());
				btnsHideShow.setSelectedIndex(0);
				btnsHideShow2.setText("SI");
				btnsHideShow2.setSelected(false);
				op2C.setSelectedIndex(0);
				btnsHideShow3.setText("SI");
				btnsHideShow3.setSelected(false);
				op3C.setSelectedIndex(0);
			}
		});

		// SAVE
		JButton save = new JButton("GUARDAR");
		save.setBounds(400, 440, 150, 50);
		btnStyle(save);
		save.setBackground(blueC);
		save.setForeground(lightC);
		save.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				save.setBackground(blueC);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				save.setBackground(blueD);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					FileWriter savedF = new FileWriter("conf.txt");
					savedF.write(op1C.getSelectedIndex() + System.lineSeparator());
					savedF.write(btnsHideShow.getSelectedIndex() + System.lineSeparator());
					savedF.write(btnsHideShow2.isSelected() + System.lineSeparator());
					savedF.write(op2C.getSelectedIndex() + System.lineSeparator());
					savedF.write(btnsHideShow3.isSelected() + System.lineSeparator());
					savedF.write(op3C.getSelectedIndex() + System.lineSeparator());
					savedF.write(conf[6] + System.lineSeparator());
					savedF.close();
				} catch (Exception e2) {
				}
				temp.dispose();

				First.this.dispose();
				new First();
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
		temp.add(op5);
		temp.add(op6);
		temp.add(op3C);
		temp.add(defSet);
		temp.add(btnsHideShow3);
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
