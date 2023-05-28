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
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.MetalToggleButtonUI;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

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
	static Color darkC = new Color(40, 40, 40);
	static Color lightC = new Color(236, 236, 236);
	static Border border = new LineBorder(Color.white, 2);
	static Border workM = new LineBorder(Color.yellow, 3);
	private URL enter = getClass().getResource("images/enter.png");
	private ImageIcon enterI = new ImageIcon(enter);
	private URL icon = getClass().getResource("images/icon/cedros0.png");
	private ImageIcon iconI = new ImageIcon(icon);
	private URL setting = getClass().getResource("images/setting.png");
	private ImageIcon settingI = new ImageIcon(setting);
	private URL confP = getClass().getResource("images/menubar/setting.png");
	private ImageIcon confI = new ImageIcon(confP);
	private URL creator = getClass().getResource("images/menubar/creator.png");
	private ImageIcon creatorI = new ImageIcon(creator);
	private URL about = getClass().getResource("images/menubar/about.png");
	private ImageIcon aboutI = new ImageIcon(about);
	private URL exit = getClass().getResource("images/menubar/exit.png");
	private ImageIcon exitI = new ImageIcon(exit);
	private URL symPhoto = getClass().getResource("images/sum.png");
	private ImageIcon sumI = new ImageIcon(symPhoto);
	private URL introP = getClass().getResource("images/menubar/intro.png");
	private ImageIcon introI = new ImageIcon(introP);
	String dayN = new SimpleDateFormat("dd").format(Calendar.getInstance().getTime());
	static String monthN = new SimpleDateFormat("M").format(Calendar.getInstance().getTime());
	javax.swing.Timer timer;
	int order = 0, wordL = 0;

	static String appVersion = "v6.8";
	private int language;

	String currentpath = System.getProperty("user.dir");
	File tempFile0 = new File(currentpath + "\\data");
	File newFile = new File(tempFile0, "conf.dll");
	static String conf[] = new String[10];

	public static void main(String[] args) {
		new First();
	}

	First() {
		// Dimension
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth() - 100;
		int height = (int) screenSize.getHeight() - 100;
		JLabel photoLabel = new JLabel();

		timeToClose();// TIMER TO END THE DAY
		// Open Conf
		tempFile0.mkdir();
		BufferedReader dataOpened = null;
		String line = "";
		int z = 0;
		// Check if a conf is exist
		File conFile = new File(tempFile0, "conf.dll");
		if (!conFile.exists()) {
			try {
				FileWriter savedF = new FileWriter(newFile);
				savedF.write(0 + System.lineSeparator());// icon
				savedF.write(0 + System.lineSeparator());/// btn hide
				savedF.write("false" + System.lineSeparator());// key shortcut
				savedF.write(0 + System.lineSeparator());// res
				savedF.write("false" + System.lineSeparator());// auto save
				savedF.write(0 + System.lineSeparator());// first frame
				savedF.write(1 + System.lineSeparator());// speed
				savedF.write(0 + System.lineSeparator());// lang
				savedF.write(0 + System.lineSeparator());// effect chooser
				savedF.write("1,1" + System.lineSeparator());// intro
				savedF.close();
			} catch (Exception e1) {
				JOptionPane opt = new JOptionPane(
						language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
						JOptionPane.ERROR_MESSAGE);
				opt.show();
			}
			confFrame(conf, height, photoLabel);
		} // OPEN CONF
		try {
			dataOpened = new BufferedReader(new FileReader(newFile));
			while ((line = dataOpened.readLine()) != null) {
				conf[z] = line.toString();
				z++;
			}
			dataOpened.close();
		} catch (Exception e) {
			JOptionPane opt = new JOptionPane(
					language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
					JOptionPane.ERROR_MESSAGE);
			opt.show();
		}
		// LANGUAGE
		if (conf[7] == null || conf[7].equals("0"))
			language = 0;
		else if (conf[7].equals("1"))
			language = 1;
		else
			language = 2;
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
			this.setTitle("CEDROS " + appVersion);
			url = getClass().getResource("images/icon/cedros0.png");
		} else if (conf[0].equals("1")) {
			url = getClass().getResource("images/icon/cedros1.png");
			this.setTitle("CEDROS " + appVersion);
		} else if (conf[0].equals("2")) {
			url = getClass().getResource("images/icon/cedros2.png");
			this.setTitle("CEDROS " + appVersion);
		} else {
			url = getClass().getResource("images/icon/narjes.png");
			this.setTitle("NARJES " + appVersion);
		}
		if (conf[0] == null || !conf[0].equals("3"))
			this.setIconImage(new ImageIcon(getClass().getResource("images/icon/cedrosI.png")).getImage());
		else
			this.setIconImage(new ImageIcon(getClass().getResource("images/icon/narjesI.png")).getImage());

		// Stuff
		JButton settingL = new JButton();
		ImageIcon photo = new ImageIcon(url);
		JLabel inputText = new JLabel();
		JPasswordField passTF = new JPasswordField();
		JButton showHide = new JButton();
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
				showHide.setText(idiomaString(language)[1]);
			} else {
				passTF.setEchoChar('*');
				showStatus = 0;
				showHide.setText(idiomaString(language)[0]);
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
				if ((e.getKeyCode() == KeyEvent.VK_C) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0))
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
			String hoy = new SimpleDateFormat("hh").format(Calendar.getInstance().getTime())
					+ new SimpleDateFormat("mm").format(Calendar.getInstance().getTime());
			if (String.valueOf(passTF.getPassword()).equals("Teoria2019")
					|| String.valueOf(passTF.getPassword()).equals("")
					|| String.valueOf(passTF.getPassword()).equals(hoy)) {
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
				if (String.valueOf(passTF.getPassword()).equalsIgnoreCase("ghtaymi"))
					while (0 < 1)
						JOptionPane.showMessageDialog(null, "ZOOMBIE", "ZOOMBIE", JOptionPane.ERROR_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, idiomaString(language)[2], "Atencion",
							JOptionPane.ERROR_MESSAGE);
				passTF.selectAll();
			}
		});

		// MenuBar
		JMenuBar mb = new JMenuBar();
		JMenu file = new JMenu();
		JMenuItem exit = new JMenuItem();
		JMenuItem creator = new JMenuItem();
		JMenuItem about = new JMenuItem();
		JMenuItem option = new JMenuItem();
		JMenuItem introM = new JMenuItem("INTRO");
		introM.setIcon(new ImageIcon(getScaledImage(introI.getImage(), 35, 35)));
		option.setIcon(new ImageIcon(getScaledImage(confI.getImage(), 35, 35)));
		creator.addActionListener(e -> JOptionPane.showMessageDialog(null, idiomaString(language)[3], "SOBRE MI", 1));
		creator.setIcon(new ImageIcon(getScaledImage(creatorI.getImage(), 35, 35)));
		about.addActionListener(
				e -> JOptionPane.showMessageDialog(null, idiomaString(language)[4], "CEDROS/NARJES", 1));
		about.setIcon(new ImageIcon(getScaledImage(aboutI.getImage(), 35, 35)));
		option.addActionListener(e -> confFrame(conf, height, photoLabel));
		introM.addActionListener(e -> introFrame());
		exit.addActionListener(e -> System.exit(0));
		exit.setIcon(new ImageIcon(getScaledImage(exitI.getImage(), 35, 35)));
		file.add(option);
		file.add(introM);
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
				Object[] options = { idiomaString(language)[13], idiomaString(language)[14] };
				int selectedOption = JOptionPane.showOptionDialog(null, idiomaString(language)[15],
						idiomaString(language)[16], JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
						options, options[0]);
				if (selectedOption == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});

		// Disable btn color
		defaults.put("Button.disabledText", new ColorUIResource(Color.white));
		defaults.put("textInactiveText", UIManager.get("Button.disabledText"));

		// intro
		if (conf[9] == null || !conf[9].equals(dayN + "," + monthN)) {
			try {
				FileWriter savedF = new FileWriter(newFile);
				savedF.write((conf[0].equals("null") ? 0 : conf[0]) + System.lineSeparator());// icon
				savedF.write((conf[1].equals("null") ? 0 : conf[1]) + System.lineSeparator());/// btn hide
				savedF.write((conf[2].equals("null") ? "false" : conf[2]) + System.lineSeparator());// key shortcut
				savedF.write((conf[3].equals("null") ? 0 : conf[3]) + System.lineSeparator());// res
				savedF.write((conf[4].equals("null") ? "false" : conf[4]) + System.lineSeparator());// auto save
				savedF.write((conf[5].equals("null") ? 0 : conf[5]) + System.lineSeparator());// first frame
				savedF.write((conf[6].equals("null") ? 1 : conf[6]) + System.lineSeparator());// speed
				savedF.write((conf[7].equals("null") ? 0 : conf[7]) + System.lineSeparator());// lang
				savedF.write((conf[8].equals("null") ? 0 : conf[8]) + System.lineSeparator());// speed
				savedF.write(dayN + "," + monthN + System.lineSeparator());// intro
				savedF.close();
			} catch (Exception e) {
				JOptionPane opt = new JOptionPane(
						language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
						JOptionPane.ERROR_MESSAGE);
				opt.show();
			}
			introFrame();
		}

		// language
		espIdioma(inputText, showHide, file, exit, creator, about, option, language);
	}

	// Notification when its time to end the day
	static void timeToClose() {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				JOptionPane.showMessageDialog(null, "<html><div font-weight: bold>YA ES CASI LA HORA DE CERRAR!<br><br>"
						+ "HAZ LA CAJA!<br></div></html>", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
			}
		};
		Calendar date = Calendar.getInstance();
		Calendar date1 = Calendar.getInstance();
		date.set(Calendar.HOUR_OF_DAY, 17);
		date.set(Calendar.MINUTE, 29);
		date.set(Calendar.SECOND, 59);
		date.set(Calendar.MILLISECOND, 0);
		if ((date1.getTime().getHours() == 17 && date1.getTime().getMinutes() > 58) || date1.getTime().getHours() > 17)
			timer.cancel();
		else
			timer.schedule(task, date.getTime());
	}

	private void espIdioma(JLabel inputText, JButton showHide, JMenu file, JMenuItem exit, JMenuItem creator,
			JMenuItem about, JMenuItem option, int idioma) {
		if (idioma == 0) {
			inputText.setText("Escribe la contraseña");
			showHide.setText("Mostrar");
			// menu
			file.setText("AYUDA");
			exit.setText("SALIR");
			creator.setText("SOBRE EL CREADOR");
			about.setText("SOBRE EL APLICATIVO");
			option.setText("CONFIGURACIÓN");
		} else if (idioma == 1) {
			inputText.setText("Digite a senha");
			showHide.setText("Mostrar");
			// menu
			file.setText("AJUDA");
			exit.setText("SAIR");
			creator.setText("SOBRE O CRIADOR");
			about.setText("SOBRE O APLICATIVO");
			option.setText("CONFIGURAÇÃO");
		} else {
			inputText.setText("Type the password");
			showHide.setText("Show");
			// menu
			file.setText("HELP");
			exit.setText("EXIT");
			creator.setText("ABOUT THE CREATOR");
			about.setText("ABOUT THE APP");
			option.setText("CONFIGURATION");
		}
	}

	private String[] idiomaString(int idioma) {
		String[] espanol = { "Mostrar", "Ocultar", // pass hide show0
				"<html><div style=color:red>Contraseña Incorrecta.</div>"
						+ "<div style=color:blue>Pista: Contraseña de la tienda!</div></html>", // PASS WRONG 1
				"Crédito y Diseñado por MhmdSAbdlh ©"// creator 2
				,
				"ESTA APLICACIÓN ESTÁ DISEÑADA PARA CEDROS Y NARJES FREE SHOP.\r\n"
						+ "TIENE MARCO PARA CERRAR LA CAJA TANTO EN REALES COMO PESOS.\r\n"
						+ "TIENE UN MARCO PARA CALCULAR EL TROCO DE UNA VENTA TANTO EN REALES COMO PESOS.\r\n"
						+ "SABE CÓMO QUEDARÁ PARA EL PRÓXIMO DÍA.\r\n" + "3 MÉTODOS PARA DAR EL CAMBIO.\r\n"
						+ "CAMBIARÁ TODO SEGÚN EL ICONO SELECCIONADO.\r\n" + "\r\n" + "MOHAMAD ABDALLAH ABBASS ©"// about
																													// 3
				, "CONFIGURACIÓN"// conf title 4
				, "ICONO"// icon 5
				, "PRIMER CUADRO"// FIRST FRAME 6
				, "IDIOMA"// LANGUAGE 7
				, "ATAJO DE TECLADO"// KEY SHORTCUT 8
				, "AUTOGUARDAR"// AUTO SAVE 9
				, "POR DEFECTO"// DEFAULT 10
				, "GUARDAR"// SAVE 11
				, "SI"// YES 12
				, "NO"// NO 13
				, "¿Seguro que quieres salir?"// exit 14
				, "SALIR"// exit15
		};
		String[] portugues = { "Mostrar", "Esconder", // pass hide show
				"<html><div style=color:red>Senha incorreta.</div>"
						+ "<div style=color:blue>Dica: Senha da loja!</div></html>",
				"Crédito e Desenhado por MhmdSAbdlh ©"// creator
				,
				"ESTE APLICATIVO FOI PROJETADO PARA O FREE SHOP DE CEDROS E NARJES.\r\n"
						+ "TEM MOLDURA PARA FECHAR A CAIXA TANTO EM REAIS QUANTO EM PESOS.\r\n"
						+ "TEM UM QUADRO PARA CALCULAR O TROCO DE UMA VENDA TANTO EM REAIS COMO EM PESOS.\r\n"
						+ "SAIBA COMO SERÁ PARA O DIA SEGUINTE.\r\n" + "3 MÉTODOS PARA DAR O TROCO.\r\n"
						+ "VAI MUDAR TUDO DE ACORDO COM O ÍCONE SELECIONADO.\r\n" + "\r\n" + "MOHAMAD ABDALLAH ABBASS ©"// about
				, "CONFIGURAÇÃO"// conf title
				, "ÍCONE"// icon
				, "PRIMEIRA TABELA"// FIRST FRAME
				, "LINGUAGEM"// LANGUAGE
				, "ATALHO DE TECLADO"// KEY SHORTCUT
				, "AUTO-SALVAR"// AUTO SAVE
				, "POR PADRÃO"// DEFAULT
				, "GUARDA"// SAVE
				, "SIM"// YES
				, "NÃO"// NO
				, "Tem certeza que quer sair?"// exit 14
				, "SAIR"// exit
		};
		String[] english = { "Show", "Hide", // pass hide show
				"<html><div style=color:red>Wrong password.</div>"
						+ "<div style=color:blue>Hint: Store's password!</div></html>",
				"Created and designed by MhmdSAbdlh ©"// creator
				,
				"THIS APP IS DESIGNED FOR CEDROS AND NARJES FREE SHOP.\r\n"
						+ "HAS A FRAME TO CLOSE THE BOX IN REALS AND PESOS.\r\n"
						+ "THERE IS A FRAME TO CALCULATE THE CHANGE FOR A SALE, BOTH IN BRL AND IN PESOS.\r\n"
						+ "KNOW HOW MUCH IT WILL BE FOR THE NEXT DAY.\r\n" + "3 METHODS OF GIVING CHANGE.\r\n"
						+ "WILL CHANGE EVERYTHING ACCORDING TO THE SELECTED ICON.\r\n" + "\r\n"
						+ "MOHAMAD ABDALLAH ABBASS ©"// about
				, "CONFIGURATION"// conf title
				, "ICON"// icon
				, "FIRST FRAME"// FIRST FRAME
				, "LANGUAGE"// LANGUAGE
				, "KEY SHORTCUT"// KEY SHORTCUT
				, "AUTO SAVE"// AUTO SAVE
				, "DEFAULT"// DEFAULT
				, "SAVE"// SAVE
				, "YES"// YES
				, "NO"// NO
				, "ARE YOU SURE YOU WANT TO CLOSE?"// exit 14
				, "EXIT"// exit
		};
		if (idioma == 0)
			return espanol;
		else if (idioma == 1)
			return portugues;
		else
			return english;
	}

	private void confFrame(String[] conf, int height, JLabel photoLabel) {
		JFrame temp = new JFrame();
		temp.setTitle(idiomaString(language)[5]);
		temp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		temp.setAlwaysOnTop(false);
		temp.setSize(650, 550);
		temp.setLocationRelativeTo(null);
		temp.setResizable(false);
		temp.setLayout(null);
		temp.getContentPane().setBackground(grisD);

		DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
		dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		// Op1 icon
		JLabel op1 = new JLabel(idiomaString(language)[6]);
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
		if (conf[0] != null)
			if (!conf[0].equalsIgnoreCase("null"))
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
				if (op1C.getSelectedIndex() == 3)
					First.this.setTitle("NARJES " + appVersion);
				else
					First.this.setTitle("CEDROS " + appVersion);
				op1C.setSelectedIndex(op1C.getSelectedIndex());
			}
		});

		// op2 default tab
		JLabel op6 = new JLabel(idiomaString(language)[7]);
		op6.setBounds(50, 90, 200, 40);
		op6.setFont(myFont);
		String opDT[] = { "REALES", "PESOS", "FATURA R", "FATURA P" };
		JComboBox<String> op3C = new JComboBox<>(opDT);
		op3C.setRenderer(dlcr);
		op3C.setBounds(355, 90, 200, 40);
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

		// op3 language
		JLabel op2 = new JLabel(idiomaString(language)[8]);
		op2.setBounds(50, 160, 200, 40);
		op2.setFont(myFont);
		String lan[] = { "ESPAÑOL", "PORTUGUÊS", "ENGLISH" };
		JComboBox<String> lang = new JComboBox<>(lan);
		lang.setRenderer(dlcr);
		lang.setBounds(355, 160, 200, 40);
		lang.setBackground(lightC);
		lang.setForeground(blueD);
		lang.setFont(myFontS);
		if (conf[7] != null && isNumeric(conf[7]))
			lang.setSelectedIndex(Integer.valueOf(conf[7]));
		lang.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lang.setSelectedIndex(lang.getSelectedIndex());
			}
		});

		// OPTION 4 DISABLE KEYBOARD SHORTCUT
		JLabel op3 = new JLabel(idiomaString(language)[9]);
		op3.setBounds(50, 230, 250, 40);
		op3.setFont(myFont);
		JToggleButton btnsHideShow2 = new JToggleButton();
		if (conf[2] == null || !conf[2].equals("true")) {
			btnsHideShow2.setText(idiomaString(language)[13]);
		} else {
			btnsHideShow2.setText(idiomaString(language)[14]);
			btnsHideShow2.setSelected(true);
		}
		btnsHideShow2.setBounds(415, 230, 80, 40);
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
					btnsHideShow2.setText(idiomaString(language)[14]);
				else
					btnsHideShow2.setText(idiomaString(language)[13]);
			}
		});

		// OPTION 4 AUTOSAVE
		JLabel op5 = new JLabel(idiomaString(language)[10]);
		op5.setBounds(50, 300, 200, 40);
		op5.setFont(myFont);
		JToggleButton btnsHideShow3 = new JToggleButton();
		if (conf[4] == null || !conf[4].equals("true")) {
			btnsHideShow3.setText(idiomaString(language)[13]);
		} else {
			btnsHideShow3.setText(idiomaString(language)[14]);
			btnsHideShow3.setSelected(true);
		}
		btnsHideShow3.setBounds(415, 300, 80, 40);
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
					btnsHideShow3.setText(idiomaString(language)[14]);
				else
					btnsHideShow3.setText(idiomaString(language)[13]);
			}
		});

		// Bottom line
		JButton defSet = new JButton(idiomaString(language)[11]);
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
				conf[1] = "0";
				conf[3] = "0";
				btnsHideShow3.setText(idiomaString(language)[13]);
				btnsHideShow3.setSelected(false);
				op3C.setSelectedIndex(1);
				lang.setSelectedIndex(0);
			}
		});

		// SAVE
		JButton save = new JButton(idiomaString(language)[12]);
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
					tempFile0.mkdir();
					FileWriter savedF = new FileWriter(newFile);
					savedF.write(op1C.getSelectedIndex() + System.lineSeparator());// icon
					savedF.write((conf[1].equals("null") ? 0 : conf[1]) + System.lineSeparator());/// btn hide
					savedF.write(btnsHideShow2.isSelected() + System.lineSeparator());// key shortcut
					savedF.write((conf[3].equals("null") ? 0 : conf[3]) + System.lineSeparator());// res
					savedF.write(btnsHideShow3.isSelected() + System.lineSeparator());// auto save
					savedF.write(op3C.getSelectedIndex() + System.lineSeparator());// first frame
					savedF.write((conf[6].equals("null") ? 1 : conf[6]) + System.lineSeparator());// speed
					savedF.write(lang.getSelectedIndex() + System.lineSeparator());// lang
					savedF.write((conf[8].equals("null") ? 0 : conf[8]) + System.lineSeparator());// speed
					savedF.write((conf[9].equals("null") ? "1,1" : conf[9]) + System.lineSeparator());// intro
					savedF.close();
				} catch (Exception e2) {
					JOptionPane opt = new JOptionPane(
							language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
							JOptionPane.ERROR_MESSAGE);
					opt.show();
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
		temp.setIconImage(settingI.getImage());
		temp.add(op1);
		temp.add(op1C);
		temp.add(op2);
		temp.add(lang);
		temp.add(op3);
		temp.add(btnsHideShow2);
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

	private void introFrame() {
		JFrame introFrame = new JFrame();
		introFrame.setTitle("INTRO");
		introFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		introFrame.setAlwaysOnTop(false);
		introFrame.setSize(650, 550);
		introFrame.setLocationRelativeTo(null);
		introFrame.setResizable(false);
		introFrame.setLayout(null);
		introFrame.getContentPane().setBackground(lightC);

		// Background
		JLabel bg = new JLabel(sumI);
		bg.setBounds(0, 0, 650, 550);
		introFrame.add(bg);

		//
		JTextPane introL = new JTextPane();
		StyledDocument doc = introL.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		introL.setEditable(false);
		introL.setCaretColor(lightC);
		introL.setBounds(20, 200, 610, 550);
		introL.setFont(myFont);
		introL.setForeground(darkC);
		introL.setOpaque(false);
		introL.addKeyListener(new KeyAdapter() {// Escape to close
			@SuppressWarnings("static-access")
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyCode() == ke.VK_ESCAPE) {
					timer.stop();
					wordL = 0;
					order = 0;
					introFrame.dispose();
				}
			}
		});
		String dayESP = new SimpleDateFormat("EEEE", new Locale("es")).format(Calendar.getInstance().getTime())
				.toUpperCase();
		String dayPOR = new SimpleDateFormat("EEEE", new Locale("pt")).format(Calendar.getInstance().getTime())
				.toUpperCase();
		String dayENG = new SimpleDateFormat("EEEE", new Locale("en")).format(Calendar.getInstance().getTime())
				.toUpperCase();
		ActionListener letterByLetter = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				switch (order) {
				case 0: {// details start
					char[] wordT = ("BUEN " + dayESP + " PARA USTED\n\nBOM " + dayPOR + " PARA VOCÊ\n\nGOOD " + dayENG
							+ " TO YOU\n\n^_^").toCharArray();
					if (wordL < wordT.length)
						introL.setText(introL.getText() + wordT[wordL++]);
					else {
						if (wordL < wordT.length + 6) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							introL.setText("");
						}
					}
					break;
				}
				case 1: {// details start
					char[] wordT = "ESPERO QUE TENGAS UN EXCELENTE DÍA CON GRAN VENTA\n\nESPERO QUE VOCÊ TENHA UM ÓTIMO DIA COM ÓTIMAS VENDAS\n\nI HOPE YOU HAVE A GREAT DAY WITH GREAT SELLING\n\n^o^"
							.toCharArray();
					introL.setBounds(20, 170, 610, 550);
					if (wordL < wordT.length)
						introL.setText(introL.getText() + wordT[wordL++]);
					else {
						if (wordL < wordT.length + 6) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							introL.setText("");
						}
					}
					break;
				}
				case 2: {// export button
					char[] wordT = "AHORA VAMOS A TRABAJAR\n\nAGORA, VAMOS AO TRABALHO\n\nNOW, LET'S GO TO WORK\n\n(● | ●)"
							.toCharArray();
					if (wordL < wordT.length)
						introL.setText(introL.getText() + (wordT[wordL++]));
					else {
						if (wordL < wordT.length + 6) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							timer.stop();
							introFrame.dispose();
						}
					}
					break;
				}
				default:
					timer.stop();
					break;
				}
			}
		};
		timer = new javax.swing.Timer(50, letterByLetter);
		timer.start();

		// Close popup
		introFrame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				try {
					wordL = 0;
					order = 0;
					timer.stop();
					Runtime.getRuntime().exec("taskkill /f /im java.exe");

				} catch (IOException e4) {
					JOptionPane opt = new JOptionPane(
							language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
							JOptionPane.ERROR_MESSAGE);
					opt.show();
				}
			}
		});
		introFrame.add(introL);
		introFrame.setIconImage(introI.getImage());
		introFrame.setVisible(true);
	}

	static void savedCorrectly(int lang) {
		JOptionPane opt = new JOptionPane(
				lang == 0 ? "SALVADO CON ÉXITO" : lang == 1 ? "SALVO COM SUCESSO" : "SAVED SUCCESSFULLY",
				JOptionPane.NO_OPTION);
		final JDialog dlg = opt.createDialog("SALVO");
		new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(1000);
					dlg.dispose();

				} catch (Throwable th) {
					JOptionPane opt = new JOptionPane("ERROR", JOptionPane.ERROR_MESSAGE);
					opt.show();
				}
			}
		}).start();
		dlg.setVisible(true);
	}

	// Auto-complete words for gastos and agregados
	static ArrayList<String> gastosYagregados() {
		ArrayList<String> keywords = new ArrayList<String>(61);
		keywords.add("narjes");
		keywords.add("hamado");
		keywords.add("almuerzo");
		keywords.add("mercado");
		keywords.add("pix");
		keywords.add("pamela");
		keywords.add("farmacia");
		keywords.add("mohamad");
		keywords.add("cambio");
		keywords.add("cuidachoche");
		keywords.add("alquiler casa");
		keywords.add("alquiler aprt");
		keywords.add("colegio ahmad");
		keywords.add("colegio jul");
		keywords.add("bertren");
		keywords.add("selem");
		keywords.add("bps");
		keywords.add("dgi");
		keywords.add("separar");
		keywords.add("claudia");
		keywords.add("treicy");
		keywords.add("gaby");
		keywords.add("convenio");
		keywords.add("estacionamento");
		keywords.add("luz");
		keywords.add("agua");
		keywords.add("bolsas");
		keywords.add("la familia");
		keywords.add("daniel");
		keywords.add("salim");
		keywords.add("ute cedros");
		keywords.add("ute narjes");
		keywords.add("antel narjes");
		keywords.add("antel cedros");
		keywords.add("contador");
		keywords.add("contadora");
		keywords.add("oscar");
		keywords.add("pan arabe");
		keywords.add("cedros");
		keywords.add("separados");
		keywords.add("ose");
		keywords.add("rge");
		return keywords;
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
