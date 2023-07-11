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
import java.awt.event.InputEvent;
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
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import com.formdev.flatlaf.FlatIntelliJLaf;

import raven.fancyicon.FancyIcon;
import raven.message.MessageDialog;
import raven.switchbutton.SwitchButton;
import raven.textfield.PasswordField;
import raven.textfield.TextField;
import raven.toast.Notifications;

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
	static Color defaultColor = new Color(0x282a2b);
	static Color blackM = new Color(0x282a2b);
	static Color goldM = new Color(0xa4973f);
	static Color blueM = new Color(0x091727);
	static Color redM = new Color(0x781f19);
	static Color greenM = new Color(0x09443c);
	static Color lightC = new Color(236, 236, 236);
	static Border border = new LineBorder(Color.white, 2);
	static Border workM = new LineBorder(Color.yellow, 3);
	private URL enter = getClass().getResource("images/enter.png");
	private ImageIcon enterI = new ImageIcon(enter);
	private URL passShowP = getClass().getResource("images/passhow.png");
	private ImageIcon passShowI = new ImageIcon(passShowP);
	private URL icon = getClass().getResource("images/icon/cedros1.png");
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
	private URL updateP = getClass().getResource("images/menubar/update.png");
	private ImageIcon updateI = new ImageIcon(updateP);
	private URL englP = getClass().getResource("images/eng.png");
	private URL esplP = getClass().getResource("images/esp.png");
	private URL frlP = getClass().getResource("images/france.png");
	private URL porlP = getClass().getResource("images/por.png");
	static String dayN = new SimpleDateFormat("dd").format(Calendar.getInstance().getTime());
	static String monthN = new SimpleDateFormat("M").format(Calendar.getInstance().getTime());
	javax.swing.Timer timer;
	int order = 0, wordL = 0;

	static String appVersion = "8.6";
	static JLabel lastChange = new JLabel();
	private static int language;

	String currentpath = System.getProperty("user.dir");
	File tempFile0 = new File(currentpath + "\\data");
	File newFile = new File(tempFile0, "conf.dll");
	static String conf[] = new String[11];

	public static void main(String[] args) {
		FlatIntelliJLaf.setup();
		new First();
	}

	First() {
		// Dimension
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth() - 100;
		int height = (int) screenSize.getHeight() - 100;

		Notifications.getInstance().setJFrame(this);// PREPARE NOTIFICATION
		FancyIcon icon1 = new FancyIcon();
		timeToClose();// TIMER TO END THE DAY

		// Open Conf
		tempFile0.mkdir();
		BufferedReader dataOpened = null;
		String line = "";
		int z = 0;

		// Check if a conf is exist
		try {// OPEN CONF
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
		confNull();
		if (conf[0] == null || !newFile.exists()) {
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
				savedF.write("0" + System.lineSeparator());// theme
				savedF.close();
			} catch (Exception e1) {
				System.out.println("catch");
			}
			confFrame(conf, height, icon1);
		}

		// LANGUAGE
		if (conf[7] == null || conf[7].equals("0"))
			language = 0;
		else if (conf[7].equals("1"))
			language = 1;
		else if (conf[7].equals("2"))
			language = 2;
		else
			language = 3;
		lastChange.setText((language == 0 ? "ÚLTIMA ACTUALIZACIÓN: "
				: language == 1 ? "ÚLTIMA ATUALIZAÇÃO: " : language == 2 ? "LAST UPDATE: " : "DERNIÈRE MISE À JOUR: ")
				+ "07:30:00");
		myBirthday(language);// my birthday norification
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setAlwaysOnTop(false);
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		// theme
		JLabel blackL = new JLabel(new ImageIcon(getClass().getResource("images/black.jpg"))),
				redL = new JLabel(new ImageIcon(getClass().getResource("images/red.jpg"))),
				greenL = new JLabel(new ImageIcon(getClass().getResource("images/green.jpg"))),
				blueL = new JLabel(new ImageIcon(getClass().getResource("images/blue.jpg"))),
				goldL = new JLabel(new ImageIcon(getClass().getResource("images/gold.jpg")));
		if (conf[10] == null || conf[10].equalsIgnoreCase("0") || conf[10].equalsIgnoreCase("null"))
			this.setContentPane(blackL);
		else if (conf[10].equalsIgnoreCase("1"))
			this.setContentPane(redL);
		else if (conf[10].equalsIgnoreCase("2"))
			this.setContentPane(greenL);
		else if (conf[10].equalsIgnoreCase("3"))
			this.setContentPane(blueL);
		else
			this.setContentPane(goldL);

		// Logo
		URL url;
		iconI = new ImageIcon(getScaledImage(iconI.getImage(), 50, 50));
		if (conf[0] == null || conf[0].equals("0")) {
			this.setTitle("CEDROS " + appVersion);
			url = getClass().getResource("images/icon/cedros1.png");
		} else {
			url = getClass().getResource("images/icon/cedros2.png");
			this.setTitle("CEDROS " + appVersion);
		}
		this.setIconImage(new ImageIcon(getClass().getResource("images/icon/cedrosI.png")).getImage());

		// Stuff
		JButton settingL = new JButton();
		ImageIcon photo = new ImageIcon(url);
		JLabel inputText = new JLabel();
		JLabel userText = new JLabel();
		PasswordField passTF = new PasswordField();
		TextField usarioName = new TextField();
		JButton showHide = new JButton();
		JLabel descTienda = new JLabel();

		// part left
		String intro = language == 0 ? "<html><div style=\"text-align: left;\">" + "<h3>BIENVENIDO A<</h3><h1>"
				+ "CEDROS" + " FREE SHOP</h1>"
				+ "<h3>AQUÍ PUEDES HACER LA CAJA MEJOR QUE NUNCA,<br> CON OPCIÓN A RESUMEN TODO</h3></div>"
				+ "<div style=\"text-align: left;\">" + "<h2><br>TIENE:</h2>"
				+ "<h3> - HACER LA CAJA POR REALES Y PESOS</h3>" + "<h3> - EXPORTAR EL RESUMEN DEL DÍA, MES Y AÑO</h3>"
				+ "<h3> - DAR EL CAMBIO A CUALQUIER VENTA SEGUN 3 MÉTODOS</h3>"
				+ "<h3> - GUARDAR LO QUE SEPARAMOS Y PROTEGERLO</h3>"
				+ "<h3> - MUCHOS OPCIONES PARA FACILITAR EL CALCULO</h3>" + "<h3> - Y MUCHO MAS .....</h3>" + "</div>"
				+ "<div style=\"text-align: right;\">" + "<h4>MhmdSAbdlh</h4></div></html>"// spanish
				: language == 1 ? "<html><div style=\"text-align: left;\">" + "<h3>BEM-VINDO A<</h3><h1>" + "CEDROS"
						+ " FREE SHOP</h1>"
						+ "<h3>AQUI VOCÊ PODE FAZER A CAIXA MELHOR DO QUE NUNCA,<br> COM OPÇÃO DE RESUMIR TUDO</h3></div>"
						+ "<div style=\"text-align: left;\">" + "<h2><br>TEM:</h2>"
						+ "<h3> - FAÇA A CAIXA PARA REAIS E PESOS</h3>"
						+ "<h3> - EXPORTAR RESUMO DE DIA, MÊS E ANO</h3>"
						+ "<h3> - DÊ TROCO EM QUALQUER VENDA DE ACORDO COM 3 MÉTODOS</h3>"
						+ "<h3> - SALVAR O QUE SEPARAMOS E PROTEGER</h3>"
						+ "<h3> - MUITAS OPÇÕES PARA FACILITAR O CÁLCULO</h3>" + "<h3> - E MUITO MAIS .....</h3>"
						+ "</div>" + "<div style=\"text-align: right;\">" + "<h4>MhmdSAbdlh</h4></div></html>"// portugues
						: language == 2 ? "<html><div style=\"text-align: left;\">" + "<h3>WELCOME TO<</h3><h1>"
								+ "CEDROS" + " FREE SHOP</h1>"
								+ "<h3>HERE YOU CAN MAKE THE BOX BETTER THAN EVER,<br> WITH OPTION TO SUMMARIZE EVERYTHING</h3></div>"
								+ "<div style=\"text-align: left;\">" + "<h2><br>IT HAS:</h2>"
								+ "<h3> - MAKE THE BOX FOR REALS AND PESOS</h3>"
								+ "<h3> - EXPORT SUMMARY OF DAY, MONTH AND YEAR</h3>"
								+ "<h3> - GIVE CHANGE TO ANY SALE ACCORDING TO 3 METHODS</h3>"
								+ "<h3> - SAVE WHAT WE SEPARATE AND PROTECT IT</h3>"
								+ "<h3> - MANY OPTIONS TO FACILITATE THE CALCULATION</h3>"
								+ "<h3> - AND MUCH MORE .....</h3>" + "</div>" + "<div style=\"text-align: right;\">"
								+ "<h4>MhmdSAbdlh</h4></div></html>"// english
								: "<html><div style=\"text-align: left;\">" + "<h3>BIENVENUE À<</h3><h1>" + "CEDROS"
										+ " FREE SHOP</h1>"
										+ "<h3>ICI, VOUS POUVEZ RENDRE LA BOÎTE MEILLEURE QUE JAMAIS,<br> AVEC L'OPTION DE TOUT RÉSUMER</h3></div>"
										+ "<div style=\"text-align: left;\">" + "<h2><br>VOUS AVEZ :</h2>"
										+ "<h3> - FAITES LA BOÎTE POUR LES RÉELS ET LES PESOS</h3>"
										+ "<h3> - RÉSUMÉ DES EXPORTATIONS DU JOUR, DU MOIS ET DE L'ANNÉE</h3>"
										+ "<h3> - RENDRE LA CHANGE À TOUTE VENTE SELON 3 MÉTHODES</h3>"
										+ "<h3> - CONSERVEZ CE QUE NOUS SÉPARONS ET PROTÉGEZ-LE</h3>"
										+ "<h3> - DE NOMBREUSES OPTIONS POUR FACILITER LE CALCUL</h3>"
										+ "<h3> - ET BEAUCOUP PLUS .....</h3>" + "</div>"
										+ "<div style=\"text-align: right;\">" + "<h4>MhmdSAbdlh</h4></div></html>";
		icon1.start();
		icon1.setBounds(this.getWidth() / 2 - height / 6, (this.getHeight() - height / 3) / 2, height / 3, height / 3);
		icon1.setImage(photo);
		this.add(icon1);

		descTienda.setBounds(50, 0, width / 2, height);
		descTienda.setText(intro);
		descTienda.setFont(new Font("Segoe Script", Font.BOLD, 25));
		descTienda.setForeground(Color.white);
		this.add(descTienda);

		// part right
		settingL.setContentAreaFilled(false);
		settingL.setBorderPainted(false);
		settingL.setBounds(width - 115, 20, 75, 75);
		settingI = new ImageIcon(getScaledImage(settingI.getImage(), 75, 75));
		settingL.setIcon(settingI);
		settingL.addActionListener(e -> confFrame(conf, height, icon1));

		userText.setBounds(this.getWidth() / 2, height / 5, this.getWidth() / 2, 40);
		userText.setHorizontalAlignment(0);
		userText.setFont(new Font("Impact", Font.ITALIC, 20));
		userText.setForeground(lightC);
		this.add(userText);
		usarioName.setBounds(this.getWidth() * 3 / 4 - 100, height / 5 + 60, 200, 50);
		usarioName.setHorizontalAlignment(0);
		usarioName.setText("");
		ArrayList<String> users = new ArrayList<>();
		users.add("mhmdsabdlh");
		users.add("cedros");
		AutoComplete userAC = new AutoComplete(usarioName, users);
		usarioName.getDocument().addDocumentListener(userAC);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				usarioName.requestFocus();
			}
		});
		usarioName.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyCode() == KeyEvent.VK_C) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0))
					confFrame(conf, height, icon1);
			}
		});
		this.add(usarioName);

		inputText.setBounds(this.getWidth() / 2, height / 2, this.getWidth() / 2, 40);
		inputText.setHorizontalAlignment(0);
		inputText.setFont(new Font("Impact", Font.ITALIC, 20));
		inputText.setForeground(lightC);
		passTF.setBounds(3 * this.getWidth() / 4 - 150, height / 2 + 60, 300, 50);
		passTF.setToolTipText("PASSWORD");
		passTF.setHorizontalAlignment(0);

		passShowI = new ImageIcon(getScaledImage(passShowI.getImage(), 50, 50));
		showHide.setContentAreaFilled(false);
		showHide.setBorderPainted(false);
		showHide.setBounds(passTF.getX() + passTF.getWidth() - 55, height / 2 + 60, 50, 50);
		showHide.setIcon(passShowI);
		btnStyle(showHide);
		showHide.addActionListener(e -> {
			if (showStatus == 0) {
				passTF.setEchoChar((char) 0);
				showStatus = 1;
			} else {
				passTF.setEchoChar('•');
				showStatus = 0;
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
				if ((e.getKeyCode() == KeyEvent.VK_C) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0))
					confFrame(conf, height, icon1);
			}
		});

		// cierre de caja
		JButton login = new JButton();
		login.setIcon(new ImageIcon(getScaledImage(enterI.getImage(), 100, 100)));
		login.setBounds(passTF.getX() + passTF.getWidth() / 2 - 50, height * 5 / 7, 100, 100);
		login.setOpaque(false);
		login.setContentAreaFilled(false);
		login.setBorderPainted(false);
		login.addActionListener(e -> {
			boolean hoy = String.valueOf(passTF.getPassword())
					.equals(new SimpleDateFormat("hh").format(Calendar.getInstance().getTime())
							+ new SimpleDateFormat("mm").format(Calendar.getInstance().getTime()));
			boolean hoy2 = String.valueOf(passTF.getPassword())
					.equals(new SimpleDateFormat("HH").format(Calendar.getInstance().getTime())
							+ new SimpleDateFormat("mm").format(Calendar.getInstance().getTime()));
			boolean cond1 = usarioName.getText().equalsIgnoreCase("MhmdSAbdlh");
			boolean cedrosUser = ((conf[0].equalsIgnoreCase("0") || conf[0].equalsIgnoreCase("1"))
					&& String.valueOf(passTF.getPassword()).equals("Teoria2019"));
			if (!users.contains(usarioName.getText().toLowerCase()))
				Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.CENTER, 1000,
						language == 0 ? "USUARIO NO ENCONTRADO"
								: language == 1 ? "USUÁRIO NÃO ENCONTRADO"
										: language == 2 ? "USER NOT FOUND" : "UTILISATEUR NON TROUVÉ");
			else if ((cond1 && (cedrosUser || hoy || hoy2))) {
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
					Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.BOTTOM_CENTER,
							10000, "ALI GHTAYMI = ZOOMBIE!!!");
				else if (String.valueOf(passTF.getPassword()).equalsIgnoreCase(""))
					Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.CENTER, 1000,
							language == 0 ? "NECESITAS PONER UNA SEÑA"
									: language == 1 ? "VOCÊ PRECISA COLOCAR UMA SENHA"
											: language == 2 ? "YOU NEED TO PUT IN A PASSWORD"
													: "VOUS DEVEZ METTRE UN MOT DE PASSE");
				else
					Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.CENTER, 1000,
							idiomaString(language)[2]);
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
		JMenuItem updateCheck = new JMenuItem();
		JMenuItem introM = new JMenuItem("INTRO");
		introM.setIcon(new ImageIcon(getScaledImage(introI.getImage(), 35, 35)));
		option.setIcon(new ImageIcon(getScaledImage(confI.getImage(), 35, 35)));
		creator.addActionListener(e -> JOptionPane.showMessageDialog(null, idiomaString(language)[3], "MhmdSAbdlh", 1));
		creator.setIcon(new ImageIcon(getScaledImage(creatorI.getImage(), 35, 35)));
		about.addActionListener(e -> JOptionPane.showMessageDialog(null, idiomaString(language)[4], "CEDROS", 1));
		about.setIcon(new ImageIcon(getScaledImage(aboutI.getImage(), 35, 35)));
		option.addActionListener(e -> confFrame(conf, height, icon1));
		introM.addActionListener(e -> introFrame());
		exit.addActionListener(e -> System.exit(0));
		exit.setIcon(new ImageIcon(getScaledImage(exitI.getImage(), 35, 35)));
		updateCheck.addActionListener(e -> {
			try {
				if (updateAvailable().equalsIgnoreCase(appVersion))
					Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.CENTER, 1000,
							language == 0 ? "NO HAY ACTUALIZACION"
									: language == 1 ? "NÃO HÁ ATUALIZAÇÃO"
											: language == 2 ? "THERE IS NO UPDATE" : "IL N'Y A PAS DE MISE À JOUR");
			} catch (IOException e1) {
			}
		});
		updateCheck.setIcon(new ImageIcon(getScaledImage(updateI.getImage(), 35, 35)));
		file.add(option);
		file.add(introM);
		file.add(updateCheck);
		file.add(creator);
		file.add(about);
		file.add(exit);
		mb.add(file);

		// Add to frame
		this.setJMenuBar(mb);
		this.add(settingL);
		this.add(icon1);
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
		if (conf[9] == null || conf[9].equalsIgnoreCase("null")
				|| (!conf[9].equals("true") && !conf[9].equals(dayN + "," + monthN))) {
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
		textLang(inputText, userText, file, exit, creator, about, option, language, updateCheck);

		try {
			updateAvailable();
		} catch (IOException e1) {
			Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.CENTER, 1000,
					"ERROR: " + e1);
		}
	}

	// UPDATE THE APP
	private String updateAvailable() throws IOException {
		// VERSION DOWNLOAD
		URL url = new URL("https://pastebin.com/raw/fzgi60tx");
		File verFile = new File(tempFile0, "version.dll");
		saveFileFromWeb(url, verFile);

		// version open
		String verAv = "";
		try (BufferedReader verBR = new BufferedReader(new FileReader(verFile))) {
			String lVers = "";
			if ((lVers = verBR.readLine()) != null)
				verAv = lVers.toString();
			verBR.close();
		} catch (Exception e) {
			Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.CENTER, 1000,
					"ERROR WHILE OPEN THE VERSION NUBER!");
		}
		if (!verAv.equals(appVersion)) {
			MessageDialog obj = new MessageDialog(this);
			obj.showMessage(language == 0 ? ("¿ACTUALIZAR A " + verAv + "?")
					: language == 1 ? ("ATUALIZAR PARA " + verAv + "?")
							: language == 2 ? ("UPDATE TO " + verAv + "?") : "MISE À JOUR VERS " + verAv + "?");
			if (obj.getMessageType() == MessageDialog.MessageType.OK) {
				URL cedrosURL = new URL(
						"https://github.com/MhmdSAbdlh/cedros/releases/download/v" + verAv + "/Cedros.exe");
				File cedFile = new File(currentpath, "cedros.exe");
				File ced2File = new File(currentpath, "cedros.exe.temp");
				// Rename the file
				cedFile.renameTo(ced2File);
				Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.CENTER, 3000,
						language == 0 ? ("ACTUALIZACIÓN EN CURSO, ESPERE UN SEGUNDO...")
								: language == 1 ? ("ATUALIZAÇÃO EM ANDAMENTO, AGUARDE UM SEGUNDO...")
										: language == 2 ? ("UPDATE IN PROGRESS, WAIT A SECONDS...")
												: "MISE À JOUR EN COURS, ATTENDEZ UNE SECONDE...");
				saveFileFromWeb(cedrosURL, cedFile);
				System.exit(0);
			}
		}
		return verAv;
	}

	// download the file from internet(url) to the des(location)
	public void saveFileFromWeb(URL url, File location) {
		File file = location; // 1. Choose the destination file
		if (file != null) {
			// 2. Create parent folder structure
			File folder = file.getParentFile();
			if (!folder.exists()) {
				folder.mkdirs();
			}
			InputStream in = null;
			FileOutputStream out = null;
			try {
				// 3. Initialise streams
				in = url.openStream();
				out = new FileOutputStream(file);
				// 4. Transfer data
				byte[] buffer = new byte[2048];
				int bytesRead;
				try {
					while ((bytesRead = in.read(buffer)) > 0) {
						out.write(buffer, 0, bytesRead);
					}
				} catch (IOException e) {
					Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.CENTER, 5000,
							"ERROR " + e);
				}
			} catch (IOException e) {
				Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.CENTER, 1000,
						"ERROR: " + e);
			} finally {
				// 5. close streams
				if (in != null) {
					try {
						in.close();
					} catch (IOException e) {
						/* ignore */ }
				}
				if (out != null) {
					try {
						out.close();
					} catch (IOException e) {
						/* ignore */ }
				}
			}
		}
	}

	// Notification when its time to end the day
	static void timeToClose() {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, 60000,
						language == 0 ? "YA ES CASI LA HORA DE CERRAR!\n\n" + "HAZ LA CAJA!"
								: language == 1 ? "ESTÁ QUASE NA HORA DE FECHAR\n" + "FAÇA A CAIXA!"
										: language == 2 ? "IT'S ALMOST CLOSING TIME\n" + "MAKE THE CASH!"
												: "C'EST PRESQUE L'HEURE DE LA FERMETURE\n" + "FAIRE LA BOÎTE!");
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

	// Notification when its my cumple
	static void myBirthday(int lang) {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				Notifications.getInstance().show(Notifications.Type.BIRTHDAY, Notifications.Location.CENTER, 86400000,
						language == 0 ? "ES MI CUMPLEAÑOS!\n" + "DESÉAME UN FELIZ AÑO :)"
								: language == 1 ? "É MEU ANIVERSÁRIO\nME DESEJE UM FELIZ ANO :)"
										: language == 2 ? "IT'S MY BIRTHDAY\nWISH ME A HAPPY YEAR :)"
												: "C'EST MON ANNIVERSAIRE\nSOUHAITE-MOI UNE BONNE ANNEE :)");
			}
		};
		Calendar date = Calendar.getInstance();
		Calendar date1 = Calendar.getInstance();
		date.set(Calendar.MONTH, 8);
		date.set(Calendar.DAY_OF_MONTH, 15);
		if (date1.getTime().getDate() != 15 || date1.getTime().getMonth() != 8)
			timer.cancel();
		else
			timer.schedule(task, date.getTime());
	}

	private void textLang(JLabel inputText, JLabel userText, JMenu file, JMenuItem exit, JMenuItem creator,
			JMenuItem about, JMenuItem option, int idioma, JMenuItem updateCheck) {
		if (idioma == 0) {
			inputText.setText("CONTRASEÑA");
			userText.setText("USARIO");
			// menu
			file.setText("AYUDA");
			exit.setText("SALIR");
			creator.setText("SOBRE EL CREADOR");
			about.setText("SOBRE EL APLICATIVO");
			option.setText("CONFIGURACIÓN");
			updateCheck.setText("BUSCAR ACTUALIZACION");
		} else if (idioma == 1) {
			inputText.setText("SENHA");
			userText.setText("USUÁRIO");
			// menu
			file.setText("AJUDA");
			exit.setText("SAIR");
			creator.setText("SOBRE O CRIADOR");
			about.setText("SOBRE O APLICATIVO");
			option.setText("CONFIGURAÇÃO");
			updateCheck.setText("VERIFIQUE ATUALIZAÇÕES");
		} else if (idioma == 2) {
			inputText.setText("PASSWORD");
			userText.setText("USER");
			// menu
			file.setText("HELP");
			exit.setText("EXIT");
			creator.setText("ABOUT THE CREATOR");
			option.setText("SETTINGS");
			about.setText("ABOUT THE APP");
			updateCheck.setText("CHECK FOR UPDATE");
		} else {
			inputText.setText("MOT DE PASSE");
			userText.setText("UTILISATEUR");
			// menu
			file.setText("AIDER");
			exit.setText("SORTIE");
			creator.setText("À PROPOS DU CRÉATEUR");
			about.setText("À PROPOS DE L'APPLICATION");
			option.setText("CONFIGURATION");
			updateCheck.setText("VÉRIFIER LA MISE À JOUR");
		}
	}

	private String[] idiomaString(int idioma) {
		String[] espanol = { "Mostrar", "Ocultar", // pass hide show0
				"Contraseña Incorrecta.\nPista: Contraseña de la tienda", // PASS WRONG 1
				"Crédito y Diseñado por MhmdSAbdlh ©"// creator 2
				,
				"ESTA APLICACIÓN ESTÁ DISEÑADA PARA CEDROS FREE SHOP.\r\n"
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
				, "TEMA"// THEME16
		};
		String[] portugues = { "Mostrar", "Esconder", // pass hide show
				"Senha incorreta.\nDica: Senha da loja!", "Crédito e Desenhado por MhmdSAbdlh ©"// creator
				,
				"ESTE APLICATIVO FOI PROJETADO PARA O FREE SHOP DE CEDROS.\r\n"
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
				, "TEMA"// THEME16
		};
		String[] english = { "Show", "Hide", // pass hide show
				"Wrong password.\nHint: Store's password!", "Created and designed by MhmdSAbdlh ©"// creator
				,
				"THIS APP IS DESIGNED FOR CEDROS FREE SHOP.\r\n"
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
				, "THEME"// THEME16
		};
		String[] french = { "Montrer", "Masquer", // passer masquer afficher
				"Mot de passe incorrect.\nAstuce : Mot de passe du magasin !", "Créé et conçu par MhmdSAbdlh ©"// créateur
				,
				"CETTE APPLICATION EST CONÇUE POUR LA BOUTIQUE GRATUITE CEDROS.\r\n"
						+ "A UN CADRE POUR FERMER LA BOÎTE EN REALS ET PESOS.\r\n"
						+ "IL EXISTE UN CADRE POUR CALCULER LE CHANGEMENT POUR UNE VENTE, À LA FOIS EN BRL ET EN PESOS.\r\n"
						+ "SAVOIR COMBIEN CELA SERA LE LENDEMAIN.\r\n" + "3 MÉTHODES POUR RENDRE LA CHANGE.\r\n"
						+ "VA TOUT CHANGER SELON L'ICÔNE SÉLECTIONNÉ.\r\n" + "\r\n" + "MOHAMAD ABDALLAH ABBASS ©"// à
																													// propos
				, "CONFIGURATION" // titre de la conf
				, "ICÔNE" // icône
				, "PREMIÈRE IMAGE"// PREMIÈRE IMAGE
				, "LANGUE"// LANGUE
				, "RACCOURCI TOUCHE"// RACCOURCI TOUCHE
				, "AUTO-SAUVER"// ENREGISTREMENT AUTO
				, "DEFAUT"// PAR DEFAUT
				, "SAUVER"// ENREGISTRER
				, "OUI"// OUI
				, "NON"// NON
				, "ÊTES-VOUS SÛR DE VOULOIR FERMER ?"// exit 14
				, "QUITTER"// quitter
				, "THÈME"// THEME16
		};
		if (idioma == 0)
			return espanol;
		else if (idioma == 1)
			return portugues;
		else if (idioma == 2)
			return english;
		else
			return french;
	}

	private void confFrame(String[] conf, int height, FancyIcon icon1) {
		JFrame temp = new JFrame();
		temp.setTitle(idiomaString(language)[5]);
		temp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		temp.setAlwaysOnTop(false);
		temp.setSize(650, 650);
		temp.setLocationRelativeTo(null);
		temp.setResizable(false);
		temp.setLayout(null);
		temp.getContentPane().setBackground(grisD);

		DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
		dlcr.setHorizontalAlignment(SwingConstants.CENTER);
		// Op1 icon
		JLabel op1 = new JLabel(idiomaString(language)[6]);
		op1.setBounds(50, 20, 150, 50);
		op1.setFont(myFont);
		URL cedros1 = getClass().getResource("images/icon/cedros1.png");
		URL cedros2 = getClass().getResource("images/icon/cedros2.png");
		ImageIcon iconImages[] = new ImageIcon[2];
		iconImages[0] = new ImageIcon(getScaledImage(new ImageIcon(cedros1).getImage(), 50, 50));
		iconImages[1] = new ImageIcon(getScaledImage(new ImageIcon(cedros2).getImage(), 50, 50));
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
				icon1.setImage(iconImages[op1C.getSelectedIndex()]);
				icon1.setBounds(icon1.getX(), 50, height / 3, height / 3);
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
		ImageIcon iconImages2[] = new ImageIcon[4];
		iconImages2[0] = new ImageIcon(getScaledImage(new ImageIcon(esplP).getImage(), 180, 50));
		iconImages2[1] = new ImageIcon(getScaledImage(new ImageIcon(porlP).getImage(), 180, 50));
		iconImages2[2] = new ImageIcon(getScaledImage(new ImageIcon(englP).getImage(), 180, 50));
		iconImages2[3] = new ImageIcon(getScaledImage(new ImageIcon(frlP).getImage(), 180, 50));
		JComboBox<ImageIcon> lang = new JComboBox<>(iconImages2);
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

		// op3 theme
		JLabel themeColor = new JLabel(idiomaString(language)[17]);
		themeColor.setBounds(50, 230, 200, 50);
		themeColor.setFont(myFont);
		ImageIcon themeIcon[] = new ImageIcon[5];
		themeIcon[0] = new ImageIcon(getClass().getResource("images/menubar/black.png"));
		themeIcon[1] = new ImageIcon(getClass().getResource("images/menubar/red.png"));
		themeIcon[2] = new ImageIcon(getClass().getResource("images/menubar/green.png"));
		themeIcon[3] = new ImageIcon(getClass().getResource("images/menubar/blue.png"));
		themeIcon[4] = new ImageIcon(getClass().getResource("images/menubar/gold.png"));
		JComboBox<ImageIcon> themeCombo = new JComboBox<>(themeIcon);
		themeCombo.setRenderer(dlcr);
		themeCombo.setBounds(355, 230, 200, 50);
		themeCombo.setBackground(lightC);
		themeCombo.setForeground(blueD);
		themeCombo.setFont(myFontS);
		if (conf[10] != null && isNumeric(conf[10]))
			themeCombo.setSelectedIndex(Integer.valueOf(conf[10]));
		themeCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				themeCombo.setSelectedIndex(themeCombo.getSelectedIndex());
			}
		});

		// OPTION 4 DISABLE KEYBOARD SHORTCUT
		JLabel op3 = new JLabel(idiomaString(language)[9]);
		op3.setBounds(50, 300, 250, 40);
		op3.setFont(myFont);
		SwitchButton btn1 = new SwitchButton();
		if (conf[2] == null || !conf[2].equals("true")) {
			btn1.setOn(true);
		} else {
			btn1.setOn(false);
		}
		btn1.setBounds(415, 300, 80, 40);
		btn1.setSwitchColor(blueM);
		btn1.setRound(999);

		// OPTION 5 AUTOSAVE
		JLabel op5 = new JLabel(idiomaString(language)[10]);
		op5.setBounds(50, 370, 200, 40);
		op5.setFont(myFont);
		SwitchButton btn2 = new SwitchButton();
		if (conf[4] == null || !conf[4].equals("true")) {
			btn2.setOn(true);
		} else {
			btn2.setOn(false);
		}
		btn2.setBounds(415, 370, 80, 40);
		btn2.setSwitchColor(redM);
		btn2.setRound(999);

		// OPTION 6 INTRO
		JLabel opIntro = new JLabel("INTRO");
		opIntro.setBounds(50, 440, 200, 40);
		opIntro.setFont(myFont);
		SwitchButton btn3 = new SwitchButton();
		if (conf[9] == null || !conf[9].equals("true") || conf[9].equals(dayN + "," + monthN)) {
			btn3.setOn(true);
		} else {
			btn3.setOn(false);
		}
		btn3.setBounds(415, 440, 80, 40);
		btn3.setSwitchColor(greenM);
		btn3.setRound(999);

		// Bottom line
		JButton defSet = new JButton(idiomaString(language)[11]);
		defSet.setBounds(120, 500, 200, 50);
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
				btn1.setOn(false);
				btn2.setOn(false);
				btn3.setOn(false);
				op3C.setSelectedIndex(1);
				lang.setSelectedIndex(0);
				themeCombo.setSelectedIndex(0);
			}
		});

		// SAVE
		JButton save = new JButton(idiomaString(language)[12]);
		save.setBounds(400, 500, 150, 50);
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
					savedF.write(!btn1.isOn() + System.lineSeparator());// key shortcut
					savedF.write((conf[3].equals("null") ? 0 : conf[3]) + System.lineSeparator());// res
					savedF.write(!btn2.isOn() + System.lineSeparator());// auto save
					savedF.write(op3C.getSelectedIndex() + System.lineSeparator());// first frame
					savedF.write((conf[6].equals("null") ? 1 : conf[6]) + System.lineSeparator());// speed
					savedF.write(lang.getSelectedIndex() + System.lineSeparator());// lang
					savedF.write((conf[8].equals("null") ? 0 : conf[8]) + System.lineSeparator());// speed
					savedF.write((conf[9].equals("null") ? "1,1" : btn3.isOn() ? dayN + "," + monthN : "true")
							+ System.lineSeparator());// intro
					savedF.write(themeCombo.getSelectedIndex() + System.lineSeparator());// theme
					savedCorrectly(language);
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
			@Override
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyCode() == KeyEvent.VK_ESCAPE)
					temp.dispose();
			}
		});

		// Escape to close
		op1C.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyCode() == KeyEvent.VK_ESCAPE)
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
		temp.add(themeColor);
		temp.add(themeCombo);
		temp.add(btn1);
		temp.add(op5);
		temp.add(op6);
		temp.add(op3C);
		temp.add(defSet);
		temp.add(btn2);
		temp.add(opIntro);
		temp.add(btn3);
		temp.add(save);
		temp.setVisible(true);
	}

	private void confNull() {
		if (conf[0] == null || conf[0].equalsIgnoreCase("null"))
			conf[0] = "0";
		if (conf[1] == null || conf[1].equalsIgnoreCase("null"))
			conf[1] = "0";
		if (conf[2] == null || conf[2].equalsIgnoreCase("null"))
			conf[2] = "false";
		if (conf[3] == null || conf[3].equalsIgnoreCase("null"))
			conf[3] = "0";
		if (conf[4] == null || conf[4].equalsIgnoreCase("null"))
			conf[4] = "false";
		if (conf[5] == null || conf[5].equalsIgnoreCase("null"))
			conf[5] = "0";
		if (conf[6] == null || conf[6].equalsIgnoreCase("null"))
			conf[6] = "0";
		if (conf[7] == null || conf[7].equalsIgnoreCase("null"))
			conf[7] = "0";
		if (conf[8] == null || conf[8].equalsIgnoreCase("null"))
			conf[8] = "0";
		if (conf[9] == null || conf[9].equalsIgnoreCase("null"))
			conf[9] = "0";
		if (conf[10] == null || conf[10].equalsIgnoreCase("null"))
			conf[10] = "0";

	}

	// Style of the buttons
	static void btnStyle(JButton btn) {
		btn.setBorder(border);
		btn.setBackground(lightC);
		btn.setForeground(defaultColor);
		btn.setFocusable(false);
		btn.setHorizontalAlignment(0);
		btn.setFont(myFont);
	}

	static void labelStyle(JLabel label) {
		label.setBorder(border);
		label.setBackground(lightC);
		label.setForeground(defaultColor);
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
			} else if (Character.isWhitespace(chars[i]) || chars[i] == '.' || chars[i] == '\'') {
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
		introL.setForeground(defaultColor);
		introL.setOpaque(false);
		introL.addKeyListener(new KeyAdapter() {// Escape to close
			@Override
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
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
		Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, 1000,
				language == 0 ? "SALVADO CON ÉXITO"
						: language == 1 ? "SALVO COM SUCESSO"
								: language == 2 ? "SAVED SUCCESSFULLY" : "ENREGISTRÉ AVEC SUCCÈS");

	}

	// Auto-complete words for gastos and agregados
	static ArrayList<String> gastosYagregados() {
		ArrayList<String> keywords = new ArrayList<>(61);
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

	@Override
	public void windowOpened(WindowEvent e) {
		initComp.requestFocus();
		e.getWindow().removeWindowListener(this);
	}
}
