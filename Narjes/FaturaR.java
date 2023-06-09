import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import java.util.Random;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import raven.switchbutton.SwitchButton;

@SuppressWarnings("serial")
public class FaturaR extends JFrame {
	static Color blueD = new Color(0, 32, 96);
	static Color blueC = new Color(155, 194, 230);
	static Color greenD = new Color(30, 90, 20);
	static Color greenC = new Color(170, 230, 150);
	static Color redD = new Color(190, 0, 0);
	static Color redC = new Color(250, 110, 110);
	static Color violetD = new Color(0x393646);
	static Color violetC = new Color(0x6D5D6E);
	static Color turD = new Color(0x245953);
	static Color turC = new Color(0x408E91);
	static Color cajaD = new Color(0x263A29);
	static Color cajaC = new Color(0x41644A);
	private URL u200 = getClass().getResource("images/200.jpg");
	private ImageIcon i200 = new ImageIcon(u200);
	private URL u100 = getClass().getResource("images/100.jpg");
	private ImageIcon i100 = new ImageIcon(u100);
	private URL u50 = getClass().getResource("images/50.jpg");
	private ImageIcon i50 = new ImageIcon(u50);
	private URL u20 = getClass().getResource("images/20.jpg");
	private ImageIcon i20 = new ImageIcon(u20);
	private URL u10 = getClass().getResource("images/10.jpg");
	private ImageIcon i10 = new ImageIcon(u10);
	private URL u5 = getClass().getResource("images/5.jpg");
	private ImageIcon i5 = new ImageIcon(u5);
	private URL u2 = getClass().getResource("images/2.jpg");
	private ImageIcon i2 = new ImageIcon(u2);
	private URL u1 = getClass().getResource("images/1.jpg");
	private ImageIcon i1 = new ImageIcon(u1);
	private URL main = getClass().getResource("images/home2.png");
	private ImageIcon mainIcon = new ImageIcon(main);
	private URL clearP = getClass().getResource("images/clear.png");
	private ImageIcon clearI = new ImageIcon(clearP);
	private URL englP = getClass().getResource("images/eng.png");
	private URL esplP = getClass().getResource("images/esp.png");
	private URL frlP = getClass().getResource("images/france.png");
	private URL porlP = getClass().getResource("images/por.png");
	// menubar
	private URL aboutP = getClass().getResource("images/menubar/about.png");
	private ImageIcon aboutI = new ImageIcon(aboutP);
	private URL calcP = getClass().getResource("images/menubar/calc.png");
	private ImageIcon calcI = new ImageIcon(calcP);
	private URL clearmbP = getClass().getResource("images/menubar/clear.png");
	private ImageIcon clearmbI = new ImageIcon(clearmbP);
	private URL creatorP = getClass().getResource("images/menubar/creator.png");
	private ImageIcon creatorI = new ImageIcon(creatorP);
	private URL exitP = getClass().getResource("images/menubar/exit.png");
	private ImageIcon exitI = new ImageIcon(exitP);
	private URL hideP = getClass().getResource("images/menubar/hide.png");
	private ImageIcon hideI = new ImageIcon(hideP);
	private URL largeP = getClass().getResource("images/menubar/large.png");
	private ImageIcon largeI = new ImageIcon(largeP);
	private URL medP = getClass().getResource("images/menubar/med.png");
	private ImageIcon medI = new ImageIcon(medP);
	private URL moneyP = getClass().getResource("images/menubar/money.png");
	private ImageIcon moneyI = new ImageIcon(moneyP);
	private URL settingP = getClass().getResource("images/menubar/setting.png");
	private ImageIcon settingI = new ImageIcon(settingP);
	private URL smallP = getClass().getResource("images/menubar/small.png");
	private ImageIcon smallI = new ImageIcon(smallP);
	private URL xsmallP = getClass().getResource("images/menubar/xsmall.png");
	private ImageIcon xsmallI = new ImageIcon(xsmallP);
	private URL optimalP = getClass().getResource("images/menubar/optimal.png");
	private ImageIcon optimalI = new ImageIcon(optimalP);
	private URL keyboardP = getClass().getResource("images/menubar/keyboard.png");
	private ImageIcon keyboardI = new ImageIcon(keyboardP);
	private URL printerP = getClass().getResource("images/menubar/printer.png");
	private ImageIcon printerI = new ImageIcon(printerP);
	int width, height;

	// Def
	static JTextField details[][] = new JTextField[10][3];
	static JLabel detailsR[] = new JLabel[10];
	static JLabel total = new JLabel("TOTAL");
	static JLabel cambio[] = new JLabel[6];
	static JLabel[][] cajaTroco = new JLabel[2][7];
	static JLabel[] trocoC = new JLabel[8];
	static JFormattedTextField[] trocoCT = new JFormattedTextField[8];
	static JLabel[][] troco = new JLabel[2][7];
	static JLabel[][] troco2 = new JLabel[2][7];
	static JLabel[][] troco3 = new JLabel[2][7];
	static String numbers[] = new String[165];
	static JLabel totalC = new JLabel("TOTAL");
	JLabel cambioC = new JLabel();
	JLabel title[] = new JLabel[4];
	JLabel caja = new JLabel();
	static int totalFatura = 0, totalCV = 0, trocoV = 0, language = 0;
	String currentpath = System.getProperty("user.dir");
	File tempFile0 = new File(currentpath + "\\data");
	File newFile = new File(tempFile0, "conf.dll");
	String timeH = new SimpleDateFormat("HH").format(Calendar.getInstance().getTime());
	String timeM = new SimpleDateFormat("mm").format(Calendar.getInstance().getTime());
	String timeS = new SimpleDateFormat("ss").format(Calendar.getInstance().getTime());
	private int nFatura = 146365;

	FaturaR() {
		// Open Conf
		BufferedReader dataOpened = null;
		String line = "";
		int tempC = 0;
		String conf[] = new String[11];
		try {
			dataOpened = new BufferedReader(new FileReader(newFile));
			while ((line = dataOpened.readLine()) != null) {
				conf[tempC] = line.toString();
				tempC++;
			}
			dataOpened.close();
		} catch (Exception e) {
			JOptionPane opt = new JOptionPane(
					language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
					JOptionPane.ERROR_MESSAGE);
			opt.show();
		}
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
		// LANGUAGE
		if (conf[7] == null || conf[7].equals("0"))
			language = 0;
		else if (conf[7].equals("1"))
			language = 1;
		else if (conf[7].equals("2"))
			language = 2;
		else
			language = 3;
		// icon
		this.setIconImage(new ImageIcon(getClass().getResource("images/icon/narjesI.png")).getImage());

		// Btns
		JButton cambioN = new JButton(idiomaString(language)[22]);
		JButton cambioN2 = new JButton(idiomaString(language)[23]);
		JButton cambioN3 = new JButton(idiomaString(language)[24]);
		JButton calculate = new JButton();
		JButton mainF = new JButton();
		JButton clearB = new JButton();
		JMenuItem hideBtn = new JMenuItem();

		// hide btns
		if (conf[1] == null || conf[1].equals("0") || conf[1].equals("1")) {
			mainF.show();
			clearB.show();
			hideBtn.setText(idiomaString(language)[26]);
		} else {
			mainF.hide();
			clearB.hide();
			hideBtn.setText(idiomaString(language)[27]);
		}

		// Frame
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int) screenSize.getWidth();
		height = (int) screenSize.getHeight();
		this.setTitle(idiomaString(language)[25]);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setAlwaysOnTop(false);
		if (width > 1800 && height > 1000)
			this.setSize(1820, 980);
		else if (width > 1500 && height > 700)
			this.setSize(1500, 800);
		else if (width > 1300 && height > 700)
			this.setSize(1300, 700);
		else
			this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);

		// Open values of cash
		dataOpened = null;
		line = "";
		int z = 0;
		tempFile0.mkdir();
		File newFile2 = new File(tempFile0, "narjes.dll");
		try {
			dataOpened = new BufferedReader(new FileReader(newFile2));
			while ((line = dataOpened.readLine()) != null) {
				numbers[z] = line.toString();
				z++;
			}
			dataOpened.close();
		} catch (Exception e) {
			JOptionPane opt = new JOptionPane(
					language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
					JOptionPane.ERROR_MESSAGE);
			opt.show();
		}

		// Invoice detailed
		for (int i = 0; i < 4; i++) {
			title[i] = new JLabel();
			title[i].setForeground(blueC);
			title[i].setBackground(blueD);
			title[i].setHorizontalAlignment(0);
			title[i].setBorder(First.border);
			title[i].setOpaque(true);
			this.add(title[i]);
		}
		title[0].setText(idiomaString(language)[15]);
		title[1].setText(idiomaString(language)[16]);
		title[2].setText(idiomaString(language)[17]);
		title[3].setText(idiomaString(language)[18]);
		ArrayList<String> keywords = listMercadoria();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 3; j++) {
				details[i][j] = new JTextField();
				textFieldStyle(details[i][j]);
				if (conf[2] == null || conf[2].equals("false"))
					tableFocus(i, j, this, mainF, clearB, hideBtn);
				this.add(details[i][j]);
			}
			// Autocomplete
			AutoComplete autoComplete = new AutoComplete(details[i][1], keywords);
			details[i][1].getDocument().addDocumentListener(autoComplete);
			details[i][1].addFocusListener(new FocusListener() {

				@Override
				public void focusLost(FocusEvent e) {
					for (int i = 0; i < 10; i++) // TitleCase gastos and agg
						details[i][1].setText(First.capitalizeString(details[i][1].getText()));
				}

				@Override
				public void focusGained(FocusEvent e) {
				}
			});
		}
		InitialFocusSetter.setInitialFocus(this, details[0][0]);
		for (int i = 0; i < 10; i++) {
			detailsR[i] = new JLabel();
			detailsR[i].setForeground(blueD);
			detailsR[i].setBackground(blueC);
			detailsR[i].setHorizontalAlignment(0);
			detailsR[i].setBorder(First.border);
			detailsR[i].setOpaque(true);
			this.add(detailsR[i]);
		}
		total.setForeground(blueC);
		total.setBackground(blueD);
		total.setHorizontalAlignment(0);
		total.setBorder(First.border);
		total.setOpaque(true);
		this.add(total);

		// Caja
		caja.setText(idiomaString(language)[19]);
		caja.setHorizontalAlignment(0);
		caja.setBorder(First.border);
		caja.setForeground(Color.white);
		caja.setBackground(cajaD);
		caja.setOpaque(true);
		this.add(caja);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 7; j++) {
				cajaTroco[i][j] = new JLabel();
				if (i == 1)
					cajaTroco[i][j].setText("0");
				cajaTroco[i][j].setHorizontalAlignment(0);
				cajaTroco[i][j].setBorder(First.border);
				cajaTroco[i][j].setOpaque(true);
				cajaTroco[i][j].setBackground(cajaC);
				cajaTroco[i][j].setForeground(Color.white);
				this.add(cajaTroco[i][j]);
			}

		// Cliente
		cambioC.setText(idiomaString(language)[20]);
		cambioC.setBorder(First.border);
		cambioC.setForeground(blueC);
		cambioC.setBackground(blueD);
		cambioC.setHorizontalAlignment(0);
		cambioC.setOpaque(true);
		this.add(cambioC);
		for (int i = 0; i < 8; i++) {
			trocoC[i] = new JLabel();
			trocoC[i].setHorizontalAlignment(0);
			trocoC[i].setBorder(First.border);
			trocoC[i].setOpaque(true);
			this.add(trocoC[i]);
			trocoCT[i] = new JFormattedTextField("0");
			formatedTextFieldStyle(trocoCT[i], cambioN, cambioN2, cambioN3);
			if (conf[2] == null || conf[2].equals("false"))
				clienteFocus(i, this, mainF, clearB, hideBtn);
			this.add(trocoCT[i]);
		}
		totalC.setBorder(First.border);
		totalC.setForeground(blueC);
		totalC.setBackground(blueD);
		totalC.setHorizontalAlignment(0);
		totalC.setOpaque(true);
		this.add(totalC);

		// Cliente troco
		for (int i = 0; i < 6; i++) {
			cambio[i] = new JLabel();
			if (i < 3) {
				cambio[i].setForeground(greenC);
				cambio[i].setBackground(greenD);
			} else {
				cambio[i].setForeground(greenD);
				cambio[i].setBackground(greenC);
			}
			cambio[i].setHorizontalAlignment(0);
			cambio[i].setBorder(First.border);
			cambio[i].setOpaque(true);
			this.add(cambio[i]);
		}
		cambio[0].setText(idiomaString(language)[20]);
		cambio[1].setText("TOTAL");
		cambio[2].setText(idiomaString(language)[21]);

		// 1ST CAMBIO
		cambioN.setBorder(First.border);
		cambioN.setForeground(First.lightC);
		cambioN.setBackground(redD);
		cambioN.setFocusable(false);
		cambioN.addActionListener(e -> {
			if (cambioN.getBackground() != redD) {
				cambioF();
				cambioN.setText(idiomaString(language)[22]);
				cambioN2.setText(idiomaString(language)[23]);
				cambioN3.setText(idiomaString(language)[24]);
				cambioN.setBackground(redD);
				cambioN2.setBackground(violetD);
				cambioN3.setBackground(turD);
				cambioN.setBorder(First.border);
				cambioN2.setBorder(First.border);
				cambioN3.setBorder(First.border);
				cambioN.setBackground(redD);
				cambioN2.setBackground(violetD);
				cambioN3.setBackground(turD);
			}
		});
		this.add(cambioN);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 7; j++) {
				troco[i][j] = new JLabel();
				if (i == 1)
					troco[i][j].setText("0");
				troco[i][j].setHorizontalAlignment(0);
				troco[i][j].setBorder(First.border);
				troco[i][j].setBackground(redC);
				troco[i][j].setForeground(Color.white);
				troco[i][j].setOpaque(true);
				this.add(troco[i][j]);
			}

		// 2ND CAMBIO
		cambioN2.setBackground(violetD);
		cambioN2.setBorder(First.border);
		cambioN2.setForeground(First.lightC);
		cambioN2.setBackground(violetD);
		cambioN2.setFocusable(false);
		cambioN2.addActionListener(e -> {
			if (cambioN2.getBackground() != violetD) {
				cambioF2();
				cambioN.setText(idiomaString(language)[22]);
				cambioN2.setText(idiomaString(language)[23]);
				cambioN3.setText(idiomaString(language)[24]);
				cambioN.setBackground(redD);
				cambioN2.setBackground(violetD);
				cambioN3.setBackground(turD);
				cambioN.setBorder(First.border);
				cambioN2.setBorder(First.border);
				cambioN3.setBorder(First.border);
				cambioN.setBackground(redD);
				cambioN2.setBackground(violetD);
				cambioN3.setBackground(turD);
			}
		});
		this.add(cambioN2);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 7; j++) {
				troco2[i][j] = new JLabel();
				if (i == 1)
					troco2[i][j].setText("0");
				troco2[i][j].setHorizontalAlignment(0);
				troco2[i][j].setBorder(First.border);
				troco2[i][j].setOpaque(true);
				troco2[i][j].setBackground(violetC);
				troco2[i][j].setForeground(Color.white);
				this.add(troco2[i][j]);
			}

		// 3RD CAMBIO
		cambioN3.setBackground(turD);
		cambioN3.setBorder(First.border);
		cambioN3.setForeground(First.lightC);
		cambioN3.setBackground(turD);
		cambioN3.setFocusable(false);
		cambioN3.addActionListener(e -> {
			if (cambioN3.getBackground() != turD) {
				cambioF3();
				cambioN.setText(idiomaString(language)[22]);
				cambioN2.setText(idiomaString(language)[23]);
				cambioN3.setText(idiomaString(language)[24]);
				cambioN.setBackground(redD);
				cambioN2.setBackground(violetD);
				cambioN3.setBackground(turD);
				cambioN.setBorder(First.border);
				cambioN2.setBorder(First.border);
				cambioN3.setBorder(First.border);
				cambioN.setBackground(redD);
				cambioN2.setBackground(violetD);
				cambioN3.setBackground(turD);
			}
		});
		this.add(cambioN3);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 7; j++) {
				troco3[i][j] = new JLabel();
				if (i == 1)
					troco3[i][j].setText("0");
				troco3[i][j].setHorizontalAlignment(0);
				troco3[i][j].setBorder(First.border);
				troco3[i][j].setOpaque(true);
				troco3[i][j].setBackground(turC);
				troco3[i][j].setForeground(Color.white);
				this.add(troco3[i][j]);
			}

		// Button
		mainF.setFocusable(true);
		mainF.setOpaque(false);
		mainF.setContentAreaFilled(false);
		mainF.setBorderPainted(false);
		mainF.addActionListener(e -> {
			this.dispose();
			new Reales();
		});
		this.add(mainF);
		clearB.setFocusable(true);
		clearB.setOpaque(false);
		clearB.setContentAreaFilled(false);
		clearB.setBorderPainted(false);
		clearB.addActionListener(e -> clearAll(cambioN, cambioN2, cambioN3));
		this.add(clearB);
		calculate.addActionListener(e -> calTodo(cambioN, cambioN2, cambioN3));
		this.add(calculate);

		// Put the valores in the caja
		cajaTroco[1][4].setText("" + (Integer.valueOf(numbers[158]) + Integer.valueOf(numbers[154]) * 5));
		z = 156;
		for (int i = 0; i < 7; i++) {
			if (i != 2)
				cajaTroco[1][6 - i].setText(numbers[z]);
			z++;
		}

		// MenuBar
		JMenuBar mb = new JMenuBar();
		JMenu file = new JMenu(idiomaString(language)[28]);
		JMenu goTo = new JMenu();
		JMenu help = new JMenu();
		JMenuItem clear = new JMenuItem(idiomaString(language)[14]);
		JMenuItem calc = new JMenuItem();
		JMenuItem expFatura = new JMenuItem(idiomaString(language)[29]);
		JMenuItem option = new JMenuItem(idiomaString(language)[4]);
		JMenuItem exit = new JMenuItem(idiomaString(language)[13]);
		JMenuItem reales = new JMenuItem("REALES");
		JMenuItem keyShortcut = new JMenuItem(idiomaString(language)[1]);
		JMenuItem creator = new JMenuItem();
		JMenuItem about = new JMenuItem();
		JMenu reso = new JMenu();
		JMenuItem resoD = new JMenuItem();
		JSeparator sep = new JSeparator();
		JMenuItem reso1 = new JMenuItem();
		JMenuItem reso2 = new JMenuItem();
		JMenuItem reso3 = new JMenuItem();
		JMenuItem reso4 = new JMenuItem();
		calc.addActionListener(e -> calTodo(cambioN, cambioN2, cambioN3));
		expFatura.addActionListener(e -> writeFatura());
		clear.addActionListener(e -> clearAll(cambioN, cambioN2, cambioN3));
		option.addActionListener(e -> confFrame(conf, mainF, clearB, hideBtn, resoD, cambioN, cambioN2, cambioN3));
		exit.addActionListener(e -> System.exit(0));
		reales.addActionListener(e -> {
			new Reales();
			this.dispose();
		});
		if (conf[2] == null || conf[2].equals("false"))
			keyShortcut.addActionListener(
					e -> JOptionPane.showMessageDialog(null, idiomaString(language)[0], idiomaString(language)[1], 1));
		else
			keyShortcut.hide();
		hideBtn.addActionListener(e -> hideBtns(mainF, clearB, hideBtn));
		creator.addActionListener(e -> JOptionPane.showMessageDialog(null, idiomaString(language)[2], "MhmdSAbdlh", 1));
		about.addActionListener(e -> JOptionPane.showMessageDialog(null, idiomaString(language)[3], "NARJES", 1));
		reso.add(resoD);
		reso.add(sep);
		reso.add(reso4);
		reso.add(reso3);
		reso.add(reso2);
		reso.add(reso1);
		resoD.addActionListener(e -> {
			conf[3] = "0";
			opResolution(mainF, clearB, resoD, reso4, reso3, reso2, reso1, cambioN, cambioN2, cambioN3);
			try {
				FileWriter savedF = new FileWriter(newFile);
				savedF.write((conf[0].equals("null") ? 0 : conf[0]) + System.lineSeparator());
				savedF.write((conf[1].equals("null") ? 0 : conf[1]) + System.lineSeparator());
				savedF.write((conf[2].equals("null") ? "false" : conf[2]) + System.lineSeparator());
				savedF.write(0 + System.lineSeparator());
				savedF.write((conf[4].equals("null") ? "false" : conf[4]) + System.lineSeparator());
				savedF.write((conf[5].equals("null") ? 0 : conf[5]) + System.lineSeparator());
				savedF.write((conf[6].equals("null") ? 0 : conf[6]) + System.lineSeparator());
				savedF.write((conf[7].equals("null") ? 0 : conf[7]) + System.lineSeparator());// lan
				savedF.write((conf[8].equals("null") ? 0 : conf[8]) + System.lineSeparator());// effchooser
				savedF.write((conf[9].equals("null") ? "1,1" : conf[9]) + System.lineSeparator());// intro
				savedF.write((conf[10].equals("null") ? "1,1" : conf[10]) + System.lineSeparator());// theme
				savedF.close();
			} catch (Exception e2) {
				JOptionPane opt = new JOptionPane(
						language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
						JOptionPane.ERROR_MESSAGE);
				opt.show();
			}
		});
		reso1.addActionListener(e -> {
			conf[3] = "4";
			resG(resoD, reso4, reso3, reso2, reso1, cambioN, cambioN2, mainF, cambioN3, clearB);
			try {
				FileWriter savedF = new FileWriter(newFile);
				savedF.write((conf[0].equals("null") ? 0 : conf[0]) + System.lineSeparator());
				savedF.write((conf[1].equals("null") ? 0 : conf[1]) + System.lineSeparator());
				savedF.write((conf[2].equals("null") ? "false" : conf[2]) + System.lineSeparator());
				savedF.write(4 + System.lineSeparator());
				savedF.write((conf[4].equals("null") ? "false" : conf[4]) + System.lineSeparator());
				savedF.write((conf[5].equals("null") ? 0 : conf[5]) + System.lineSeparator());
				savedF.write((conf[6].equals("null") ? 0 : conf[6]) + System.lineSeparator());
				savedF.write((conf[7].equals("null") ? 0 : conf[7]) + System.lineSeparator());// lan
				savedF.write((conf[8].equals("null") ? 0 : conf[8]) + System.lineSeparator());// effchooser
				savedF.write((conf[9].equals("null") ? "1,1" : conf[9]) + System.lineSeparator());// intro
				savedF.write((conf[10].equals("null") ? "1,1" : conf[10]) + System.lineSeparator());// theme
				savedF.close();
			} catch (Exception e2) {
				JOptionPane opt = new JOptionPane(
						language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
						JOptionPane.ERROR_MESSAGE);
				opt.show();
			}
		});
		reso2.addActionListener(e -> {
			conf[3] = "3";
			resM(resoD, reso4, reso3, reso2, reso1, cambioN, cambioN2, mainF, cambioN3, clearB);
			try {
				FileWriter savedF = new FileWriter(newFile);
				savedF.write((conf[0].equals("null") ? 0 : conf[0]) + System.lineSeparator());
				savedF.write((conf[1].equals("null") ? 0 : conf[1]) + System.lineSeparator());
				savedF.write((conf[2].equals("null") ? "false" : conf[2]) + System.lineSeparator());
				savedF.write(3 + System.lineSeparator());
				savedF.write((conf[4].equals("null") ? "false" : conf[4]) + System.lineSeparator());
				savedF.write((conf[5].equals("null") ? 0 : conf[5]) + System.lineSeparator());
				savedF.write((conf[6].equals("null") ? 0 : conf[6]) + System.lineSeparator());
				savedF.write((conf[7].equals("null") ? 0 : conf[7]) + System.lineSeparator());// lan
				savedF.write((conf[8].equals("null") ? 0 : conf[8]) + System.lineSeparator());// effchooser
				savedF.write((conf[9].equals("null") ? "1,1" : conf[9]) + System.lineSeparator());// intro
				savedF.write((conf[10].equals("null") ? "1,1" : conf[10]) + System.lineSeparator());// theme
				savedF.close();
			} catch (Exception e2) {
				JOptionPane opt = new JOptionPane(
						language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
						JOptionPane.ERROR_MESSAGE);
				opt.show();
			}
		});
		reso3.addActionListener(e -> {
			conf[3] = "2";
			resP(resoD, reso4, reso3, reso2, reso1, cambioN, cambioN2, mainF, cambioN3, clearB);
			try {
				FileWriter savedF = new FileWriter(newFile);
				savedF.write((conf[0].equals("null") ? 0 : conf[0]) + System.lineSeparator());
				savedF.write((conf[1].equals("null") ? 0 : conf[1]) + System.lineSeparator());
				savedF.write((conf[2].equals("null") ? "false" : conf[2]) + System.lineSeparator());
				savedF.write(2 + System.lineSeparator());
				savedF.write((conf[4].equals("null") ? "false" : conf[4]) + System.lineSeparator());
				savedF.write((conf[5].equals("null") ? 0 : conf[5]) + System.lineSeparator());
				savedF.write((conf[6].equals("null") ? 0 : conf[6]) + System.lineSeparator());
				savedF.write((conf[7].equals("null") ? 0 : conf[7]) + System.lineSeparator());// lan
				savedF.write((conf[8].equals("null") ? 0 : conf[8]) + System.lineSeparator());// effchooser
				savedF.write((conf[9].equals("null") ? "1,1" : conf[9]) + System.lineSeparator());// intro
				savedF.write((conf[10].equals("null") ? "1,1" : conf[10]) + System.lineSeparator());// theme
				savedF.close();
			} catch (Exception e2) {
				JOptionPane opt = new JOptionPane(
						language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
						JOptionPane.ERROR_MESSAGE);
				opt.show();
			}
		});
		reso4.addActionListener(e -> {
			conf[3] = "1";
			resXP(resoD, reso4, reso3, reso2, reso1, cambioN, cambioN2, mainF, cambioN3, clearB);
			try {
				FileWriter savedF = new FileWriter(newFile);
				savedF.write((conf[0].equals("null") ? 0 : conf[0]) + System.lineSeparator());
				savedF.write((conf[1].equals("null") ? 0 : conf[1]) + System.lineSeparator());
				savedF.write((conf[2].equals("null") ? "false" : conf[2]) + System.lineSeparator());
				savedF.write(1 + System.lineSeparator());
				savedF.write((conf[4].equals("null") ? "false" : conf[4]) + System.lineSeparator());
				savedF.write((conf[5].equals("null") ? 0 : conf[5]) + System.lineSeparator());
				savedF.write((conf[6].equals("null") ? 0 : conf[6]) + System.lineSeparator());
				savedF.write((conf[7].equals("null") ? 0 : conf[7]) + System.lineSeparator());// lan
				savedF.write((conf[8].equals("null") ? 0 : conf[8]) + System.lineSeparator());// effchooser
				savedF.write((conf[9].equals("null") ? "1,1" : conf[9]) + System.lineSeparator());// intro
				savedF.write((conf[10].equals("null") ? "1,1" : conf[10]) + System.lineSeparator());// theme
				savedF.close();
			} catch (Exception e2) {
				JOptionPane opt = new JOptionPane(
						language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
						JOptionPane.ERROR_MESSAGE);
				opt.show();
			}
		});
		file.add(calc);
		file.add(expFatura);
		file.add(clear);
		file.add(option);
		file.add(exit);
		goTo.add(reales);
		help.add(keyShortcut);
		help.add(hideBtn);
		help.add(creator);
		help.add(about);
		mb.add(file);
		mb.add(goTo);
		mb.add(reso);
		mb.add(help);
		this.setJMenuBar(mb);
		// Image Icon
		clear.setIcon(new ImageIcon(getScaledImage(clearmbI.getImage(), 35, 35)));
		calc.setIcon(new ImageIcon(getScaledImage(calcI.getImage(), 35, 35)));
		expFatura.setIcon(new ImageIcon(getScaledImage(printerI.getImage(), 35, 35)));
		option.setIcon(new ImageIcon(getScaledImage(settingI.getImage(), 35, 35)));
		exit.setIcon(new ImageIcon(getScaledImage(exitI.getImage(), 35, 35)));
		reales.setIcon(new ImageIcon(getScaledImage(moneyI.getImage(), 35, 35)));
		resoD.setIcon(new ImageIcon(getScaledImage(optimalI.getImage(), 35, 35)));
		reso4.setIcon(new ImageIcon(getScaledImage(xsmallI.getImage(), 35, 35)));
		reso3.setIcon(new ImageIcon(getScaledImage(smallI.getImage(), 35, 35)));
		reso2.setIcon(new ImageIcon(getScaledImage(medI.getImage(), 35, 35)));
		reso1.setIcon(new ImageIcon(getScaledImage(largeI.getImage(), 35, 35)));
		hideBtn.setIcon(new ImageIcon(getScaledImage(hideI.getImage(), 35, 35)));
		keyShortcut.setIcon(new ImageIcon(getScaledImage(keyboardI.getImage(), 35, 35)));
		creator.setIcon(new ImageIcon(getScaledImage(creatorI.getImage(), 35, 35)));
		about.setIcon(new ImageIcon(getScaledImage(aboutI.getImage(), 35, 35)));

		// Frame start
		this.getRootPane().setDefaultButton(calculate);
		this.setVisible(true);

		// Resolution
		if (conf[3] == null || conf[3].equals("0"))
			opResolution(mainF, clearB, resoD, reso4, reso3, reso2, reso1, cambioN, cambioN2, cambioN3);
		else if (conf[3].equals("1"))
			resXP(resoD, reso4, reso3, reso2, reso1, cambioN, cambioN2, mainF, cambioN3, clearB);
		else if (conf[3].equals("2"))
			resP(resoD, reso4, reso3, reso2, reso1, cambioN, cambioN2, mainF, cambioN3, clearB);
		else if (conf[3].equals("3"))
			resM(resoD, reso4, reso3, reso2, reso1, cambioN, cambioN2, mainF, cambioN3, clearB);
		else
			resG(resoD, reso4, reso3, reso2, reso1, cambioN, cambioN2, mainF, cambioN3, clearB);

		// language
		idiomaTexts(language, resoD, file, clear, calc, option, goTo, reales, reso, reso1, reso2, reso3, reso4, help,
				creator, about);

		// Close popup
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				Object[] options = { idiomaString(language)[10], idiomaString(language)[11] };
				int selectedOption = JOptionPane.showOptionDialog(null, idiomaString(language)[12],
						idiomaString(language)[13], JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
						options, options[0]);
				if (selectedOption == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
	}

	public String[] login() {
		String[] logininformation = new String[3];

		JPanel panel = new JPanel(new BorderLayout(5, 5));

		JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
		label.add(new JLabel(language == 0 ? "Nombre" : language == 1 ? "Nome" : language == 2 ? "Name" : "Nom",
				SwingConstants.RIGHT));
		label.add(new JLabel("DNI", SwingConstants.RIGHT));
		label.add(
				new JLabel(language == 0 ? "Moneda" : language == 1 ? "Moeda" : language == 2 ? "Currency" : "Monnaie",
						SwingConstants.RIGHT));
		panel.add(label, BorderLayout.WEST);

		JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
		JTextField username = new JTextField();
		controls.add(username);
		JTextField password = new JTextField();
		controls.add(password);
		String s1[] = { "USD", "R$" };
		JComboBox<String> lang = new JComboBox<>(s1);
		controls.add(lang);
		panel.add(controls, BorderLayout.CENTER);

		JOptionPane.showMessageDialog(null, panel, "login", JOptionPane.QUESTION_MESSAGE);

		logininformation[0] = username.getText();
		logininformation[1] = password.getText();
		logininformation[2] = lang.getSelectedItem() + "";
		return logininformation;
	}

	private void writeFatura() {
		String account[] = login();
		account[0] = account[0].toUpperCase();
		try {
			tempFile0.mkdir();
			File tempFile1 = new File(tempFile0 + "\\Faturas");
			tempFile1.mkdir();
			File faturaFile = new File(tempFile1, nFatura + ".html");
			while (faturaFile.exists()) {
				faturaFile = new File(tempFile1, ++nFatura + ".html");
			}
			Random rand = new Random();
			int randN[] = new int[10];
			for (int i = 0; i < 10; i++)
				randN[i] = rand.nextInt(1000000);
			FileWriter savedF = new FileWriter(faturaFile);
			savedF.write("<!DOCTYPE html>" + System.lineSeparator() + "<html lang=\"en\">" + System.lineSeparator());// def
			savedF.write("<head>" + System.lineSeparator() + " <!-- basic -->" + System.lineSeparator()// header
					+ " <meta charset=\"utf-8\">" + System.lineSeparator()
					+ " <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">" + System.lineSeparator()
					+ " <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
					+ System.lineSeparator() + " <!-- mobile metas -->" + System.lineSeparator()
					+ " <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
					+ System.lineSeparator() + " <meta name=\"viewport\" content=\"initial-scale=1, maximum-scale=1\">"
					+ System.lineSeparator() + " <!-- site metas -->" + System.lineSeparator() + " <title></title>"
					+ System.lineSeparator() + " <meta name=\"keywords\" content=\"\">" + System.lineSeparator()
					+ " <meta name=\"description\" content=\"\">" + System.lineSeparator()
					+ " <meta name=\"author\" content=\"\">" + System.lineSeparator() + "<style>"
					+ System.lineSeparator() + "div {" + System.lineSeparator() + "  white-space: pre; "
					+ System.lineSeparator() + "  font-family: 'Raleway', sans-serif;" + System.lineSeparator()
					+ "  font-size: 16px;" + System.lineSeparator() + "}" + System.lineSeparator() + "</style>"
					+ System.lineSeparator() + "   </head>" + System.lineSeparator());

			savedF.write("<body>" + System.lineSeparator() + "<div>		     		RUT: 216547290011"// intro company
					+ System.lineSeparator() + "Abbas Chaachouh Mohamad" + System.lineSeparator()
					+ "NARJES DUTY FREE FREESHOP" + System.lineSeparator() + "33 Orientales 1170"
					+ System.lineSeparator() + "Rivera			Tel.:46221965" + System.lineSeparator()
					+ System.lineSeparator() + "Tipo Documento:	<b>e-Ticket</b>" + System.lineSeparator()
					+ "Nro.Documento:	<b>A	" + nFatura + "</b>" + System.lineSeparator()
					+ "Forma Pago:	<b>	Contado</b>" + System.lineSeparator() + "Fecha:		<b>	" + First.dayN + "/"
					+ First.monthN + "/2023</b>  " + timeH + ":" + timeM + ":" + timeS + System.lineSeparator()
					+ System.lineSeparator() + "</div>" + System.lineSeparator() + "<div style=\""
					+ System.lineSeparator() + "  width: 100%;" + System.lineSeparator() + "  text-align: center;"
					+ System.lineSeparator() + "  font-size: 2em;" + System.lineSeparator() + "  font-weight: 100;"
					+ System.lineSeparator() + "  color: black;" + System.lineSeparator() + "  box-sizing: border-box;"
					+ System.lineSeparator() + "  border: 2px solid black;\"><b>Consumo Final</b></div>");

			savedF.write(System.lineSeparator() + "<div>" + System.lineSeparator() + "			DNI	" + account[1]
					+ System.lineSeparator() + "  Nom:	" + account[0] + System.lineSeparator() + "  Dir.: 	BRASIL"
					+ System.lineSeparator() + "		BRASIL" + System.lineSeparator());

			savedF.write(
					"<b>_____________________________________" + System.lineSeparator() + "" + System.lineSeparator()
							+ "  Moneda: " + account[2] + "</b>" + System.lineSeparator() + System.lineSeparator());
			for (int i = 0; i < 10; i++) {// the sells with prices
				if (!details[i][1].getText().isEmpty() && !details[i][0].getText().isEmpty()
						&& !details[i][2].getText().isEmpty())
					if (account[2].equals("USD"))
						savedF.write(randN[i] + "  " + details[i][1].getText() + System.lineSeparator()
								+ details[i][0].getText() + " Un    X (	 " + Float.valueOf(details[i][2].getText()) / 5
								+ "  	- 0.00 % ) 	   " + Float.valueOf(detailsR[i].getText()) / 5
								+ System.lineSeparator());
					else
						savedF.write(randN[i] + "  " + details[i][1].getText() + System.lineSeparator()
								+ details[i][0].getText() + " Un    X (	 " + details[i][2].getText()
								+ "  	- 0.00 % ) 	  	" + detailsR[i].getText() + System.lineSeparator());
			}
			if (account[2].equals("USD"))
				savedF.write(System.lineSeparator() + "______________________________________</div>"
						+ "<div style=\"text-align: center;\"><b>Total USD		" + (float) totalFatura / 5
						+ System.lineSeparator() + System.lineSeparator());
			else
				savedF.write(System.lineSeparator() + "______________________________________</div>"
						+ "<div style=\"text-align: center;\"><b>Total R$		" + totalFatura + System.lineSeparator()
						+ System.lineSeparator());
			// total sells
			savedF.write("_______________ADENDA________________</b></div>" + System.lineSeparator()
					+ System.lineSeparator() + "<div>" + System.lineSeparator() + "Cajera :1" + System.lineSeparator()
					+ "<b>Nro. Trans   Fecha	  Hora	 Caja</b>" + System.lineSeparator()
					+ "------------------------------------------------------------------" + System.lineSeparator()
					+ "5,837      " + First.dayN + "/" + First.monthN + "/2023   " + timeH + ":" + timeM + "	    1"
					+ System.lineSeparator() + System.lineSeparator() + "</div>" + System.lineSeparator()
					+ "<div style=\"text-align: center;\"><b>___________FIN ADENDA____________" + System.lineSeparator()
					+ System.lineSeparator() + "GRACIAS</b>" + System.lineSeparator() + "</div>"
					+ System.lineSeparator() + "   </body>" + System.lineSeparator() + System.lineSeparator()
					+ "</html>");
			savedF.close();
			First.savedCorrectly(language);
			Desktop desktop = Desktop.getDesktop();
			if (faturaFile.exists())
				try {
					desktop.open(faturaFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
		} catch (Exception e2) {
			JOptionPane opt = new JOptionPane(language == 0 ? "ERROR, NO SALVO!" : "ERROR, NAO SALVO!",
					JOptionPane.ERROR_MESSAGE);
			opt.show();
		}
	}

	private void confFrame(String[] conf, JButton realesF, JButton clearEverthing, JMenuItem hideBtn, JMenuItem resoD,
			JButton cambioN, JButton cambioN2, JButton cambioN3) {
		JFrame temp = new JFrame();
		temp.setTitle(idiomaString(language)[4]);
		temp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		temp.setAlwaysOnTop(false);
		temp.setSize(650, 550);
		temp.setLocationRelativeTo(null);
		temp.setResizable(false);
		temp.setLayout(null);
		temp.getContentPane().setBackground(First.grisD);
		//
		DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
		dlcr.setHorizontalAlignment(SwingConstants.CENTER);
		// Op1 icon
		JLabel op1 = new JLabel(idiomaString(language)[5]);
		op1.setBounds(50, 20, 150, 50);
		op1.setFont(First.myFont);
		URL cedros1 = getClass().getResource("images/icon/narjes1.png");
		URL cedros2 = getClass().getResource("images/icon/narjes2.png");
		ImageIcon iconImages[] = new ImageIcon[2];
		iconImages[0] = new ImageIcon(getScaledImage(new ImageIcon(cedros1).getImage(), 50, 50));
		iconImages[1] = new ImageIcon(getScaledImage(new ImageIcon(cedros2).getImage(), 50, 50));
		JComboBox<ImageIcon> op1C = new JComboBox<>(iconImages);
		op1C.setRenderer(dlcr);
		op1C.setBounds(420, 20, 70, 50);
		if (conf[0] != null)
			op1C.setSelectedIndex(Integer.valueOf(conf[0]));
		op1C.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				op1C.setSelectedIndex(op1C.getSelectedIndex());
			}
		});

		// op2 language
		JLabel op2 = new JLabel(idiomaString(language)[6]);
		op2.setBounds(50, 90, 200, 40);
		op2.setFont(First.myFont);
		ImageIcon iconImages2[] = new ImageIcon[4];
		iconImages2[0] = new ImageIcon(getScaledImage(new ImageIcon(esplP).getImage(), 180, 50));
		iconImages2[1] = new ImageIcon(getScaledImage(new ImageIcon(porlP).getImage(), 180, 50));
		iconImages2[2] = new ImageIcon(getScaledImage(new ImageIcon(englP).getImage(), 180, 50));
		iconImages2[3] = new ImageIcon(getScaledImage(new ImageIcon(frlP).getImage(), 180, 50));
		JComboBox<ImageIcon> lang = new JComboBox<>(iconImages2);
		lang.setRenderer(dlcr);
		lang.setBounds(355, 90, 200, 40);
		lang.setBackground(First.lightC);
		lang.setForeground(First.blueD);
		lang.setFont(First.myFontS);
		if (conf[7] != null && First.isNumeric(conf[7]))
			lang.setSelectedIndex(Integer.valueOf(conf[7]));
		lang.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lang.setSelectedIndex(lang.getSelectedIndex());
			}
		});

		// op3 theme
		JLabel themeColor = new JLabel(idiomaString(language)[30]);
		themeColor.setBounds(50, 160, 200, 50);
		themeColor.setFont(First.myFont);
		ImageIcon themeIcon[] = new ImageIcon[5];
		themeIcon[0] = new ImageIcon(getClass().getResource("images/menubar/black.png"));
		themeIcon[1] = new ImageIcon(getClass().getResource("images/menubar/red.png"));
		themeIcon[2] = new ImageIcon(getClass().getResource("images/menubar/green.png"));
		themeIcon[3] = new ImageIcon(getClass().getResource("images/menubar/blue.png"));
		themeIcon[4] = new ImageIcon(getClass().getResource("images/menubar/gold.png"));
		JComboBox<ImageIcon> themeCombo = new JComboBox<>(themeIcon);
		themeCombo.setRenderer(dlcr);
		themeCombo.setBounds(355, 160, 200, 50);
		themeCombo.setBackground(First.lightC);
		themeCombo.setForeground(First.blueD);
		themeCombo.setFont(First.myFontS);
		if (conf[10] != null && First.isNumeric(conf[10]))
			themeCombo.setSelectedIndex(Integer.valueOf(conf[10]));
		themeCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				themeCombo.setSelectedIndex(themeCombo.getSelectedIndex());
			}
		});

		// OPTION 2 DISABLE KEYBOARD SHORTCUT
		JLabel op3 = new JLabel(idiomaString(language)[1]);
		op3.setBounds(50, 230, 260, 40);
		op3.setFont(First.myFont);
		SwitchButton btn1 = new SwitchButton();
		if (conf[2] == null || !conf[2].equals("true")) {
			btn1.setOn(true);
		} else {
			btn1.setOn(false);
		}
		btn1.setBounds(415, 230, 80, 40);
		btn1.setSwitchColor(First.blueM);
		btn1.setRound(999);

		// OPTION 5 AUTOSAVE
		JLabel op5 = new JLabel(idiomaString(language)[7]);
		op5.setBounds(50, 300, 200, 40);
		op5.setFont(First.myFont);
		SwitchButton btn2 = new SwitchButton();
		if (conf[4] == null || !conf[4].equals("true")) {
			btn2.setOn(true);
		} else {
			btn2.setOn(false);
		}
		btn2.setBounds(415, 300, 80, 40);
		btn2.setSwitchColor(First.redM);
		btn2.setRound(999);

		// bottom line
		JButton defSet = new JButton(idiomaString(language)[8]);
		defSet.setBounds(120, 440, 200, 50);
		First.btnStyle(defSet);
		defSet.setBackground(First.redC);
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
				defSet.setBackground(First.redC);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				defSet.setBackground(First.redD);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		defSet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				op1C.setSelectedIndex(0);// icon
				FaturaR.this.setIconImage(iconImages[0].getImage());// icon
				conf[1] = "0";// btn hide
				btn1.setOn(false);// auto save
				btn2.setOn(false); // key shortcut
				conf[3] = "0";// res
				conf[6] = "1";// speed
				lang.setSelectedIndex(0);// lan
				conf[8] = "0";// eff
				themeCombo.setSelectedIndex(0);
			}
		});
		// SAVE
		JButton save = new JButton(idiomaString(language)[9]);
		save.setBounds(400, 440, 150, 50);
		First.btnStyle(save);
		save.setBackground(First.blueC);
		save.setForeground(First.lightC);
		save.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				save.setBackground(First.blueC);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				save.setBackground(First.blueD);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					FileWriter savedF = new FileWriter(newFile);
					savedF.write(op1C.getSelectedIndex() + System.lineSeparator());// icon
					savedF.write((conf[1].equals("null") ? 0 : conf[1]) + System.lineSeparator());// btn hide
					savedF.write(!btn1.isOn() + System.lineSeparator());// key shortcut
					savedF.write((conf[3].equals("null") ? 0 : conf[3]) + System.lineSeparator());// res
					savedF.write(!btn2.isOn() + System.lineSeparator());// key shortcut
					savedF.write((conf[5].equals("null") ? 0 : conf[5]) + System.lineSeparator());// FIRST OPEN
					savedF.write((conf[6].equals("null") ? 1 : conf[6]) + System.lineSeparator());// SPEED
					savedF.write(lang.getSelectedIndex() + System.lineSeparator());// lan
					savedF.write((conf[8].equals("null") ? 0 : conf[8]) + System.lineSeparator());// effchooser
					savedF.write((conf[9].equals("null") ? "1,1" : conf[9]) + System.lineSeparator());// intro
					savedF.write(themeCombo.getSelectedIndex() + System.lineSeparator());// theme
					First.savedCorrectly(language);
					savedF.close();
				} catch (Exception e2) {
					JOptionPane opt = new JOptionPane(
							language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
							JOptionPane.ERROR_MESSAGE);
					opt.show();
				}
				temp.dispose();
				FaturaR.this.dispose();
				new FaturaR();
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
		temp.add(btn2);
		temp.add(defSet);
		temp.add(save);
		temp.setVisible(true);
	}

	private void opResolution(JButton realesF, JButton clearEverthing, JMenuItem resoD, JMenuItem resoXP,
			JMenuItem resoP, JMenuItem resoM, JMenuItem resoG, JButton cambioN, JButton cambioN2, JButton cambioN3) {
		if (width > 1800 && height > 1000)
			resG(resoD, resoXP, resoP, resoM, resoG, cambioN, cambioN2, realesF, cambioN3, clearEverthing);
		else if (width > 1500 && height > 700)
			resM(resoD, resoXP, resoP, resoM, resoG, cambioN, cambioN2, realesF, cambioN3, clearEverthing);
		else if (width > 1300 && height > 700)
			resP(resoD, resoXP, resoP, resoM, resoG, cambioN, cambioN2, realesF, cambioN3, clearEverthing);
		else
			resXP(resoD, resoXP, resoP, resoM, resoG, cambioN, cambioN2, realesF, cambioN3, clearEverthing);
	}

	private void clearAll(JButton cambioN, JButton cambioN2, JButton cambioN3) {
		for (int i = 0; i < 7; i++)
			trocoCT[i].setText("0");
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 3; j++)
				details[i][j].setText("");
		for (int i = 0; i < 9; i++)
			detailsR[i].setText("");
		calTodo(cambioN, cambioN2, cambioN3);
		cambioN.setText(idiomaString(language)[22]);
		cambioN2.setText(idiomaString(language)[23]);
		cambioN3.setText(idiomaString(language)[24]);
		cambioN.setBackground(redD);
		cambioN2.setBackground(violetD);
		cambioN3.setBackground(turD);
	}

	// Hide the button
	private void hideBtns(JButton mainF, JButton clearB, JMenuItem hideBtn) {
		if (mainF.isShowing()) {
			mainF.hide();
			clearB.hide();
			hideBtn.setText(idiomaString(language)[27]);
		} else {
			mainF.show();
			clearB.show();
			hideBtn.setText(idiomaString(language)[26]);
		}
	}

	// Focus for the fatura
	private void tableFocus(int i, int j, JFrame frame, JButton mainF, JButton clearB, JMenuItem hideBtn) {
		details[i][j].addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// Hide
				if ((e.getKeyCode() == KeyEvent.VK_O) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0))
					hideBtns(mainF, clearB, hideBtn);
				// GO TO Main
				else if ((e.getKeyCode() == KeyEvent.VK_S) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0)) {
					frame.dispose();
					new Reales();
				} else if ((e.getKeyCode() == KeyEvent.VK_SHIFT)) {
					details[i][j].setNextFocusableComponent(trocoCT[0]);
					details[i][j].nextFocus();
				} else if ((e.getKeyCode() == KeyEvent.VK_I) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0))
					writeFatura();
				else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (j < 2) {
						details[i][j].setNextFocusableComponent(details[i][j + 1]);
						details[i][j].nextFocus();
					} else {
						if (i < 9) {
							details[i][j].setNextFocusableComponent(details[i + 1][0]);
							details[i][j].nextFocus();
						} else {
							details[i][j].setNextFocusableComponent(details[0][0]);
							details[i][j].nextFocus();
						}
					}

				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (j > 0) {
						details[i][j].setNextFocusableComponent(details[i][j - 1]);
						details[i][j].nextFocus();
					} else {
						if (i > 0) {
							details[i][j].setNextFocusableComponent(details[i - 1][2]);
							details[i][j].nextFocus();
						} else {
							details[i][j].setNextFocusableComponent(details[9][2]);
							details[i][j].nextFocus();
						}
					}
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (i > 0) {
						details[i][j].setNextFocusableComponent(details[i - 1][j]);
						details[i][j].nextFocus();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					if (i < 9) {
						details[i][j].setNextFocusableComponent(details[i + 1][j]);
						details[i][j].nextFocus();
					}
				}
			}
		});
	}

	// Focus for the cleinte
	private void clienteFocus(int i, JFrame frame, JButton mainF, JButton clearB, JMenuItem hideBtn) {
		trocoCT[i].addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// Hide
				if ((e.getKeyCode() == KeyEvent.VK_O) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0))
					hideBtns(mainF, clearB, hideBtn);
				// GO TO Main
				else if ((e.getKeyCode() == KeyEvent.VK_S) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0)) {
					frame.dispose();
					new Reales();
				} else if ((e.getKeyCode() == KeyEvent.VK_SHIFT)) {
					trocoCT[i].setNextFocusableComponent(details[0][0]);
					trocoCT[i].nextFocus();
				} else if ((e.getKeyCode() == KeyEvent.VK_I) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0))
					writeFatura();
				else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (i < 7) {
						trocoCT[i].setNextFocusableComponent(trocoCT[i + 1]);
						trocoCT[i].nextFocus();
					} else {
						trocoCT[i].setNextFocusableComponent(trocoCT[0]);
						trocoCT[i].nextFocus();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT)
					if (i > 0) {
						trocoCT[i].setNextFocusableComponent(trocoCT[i - 1]);
						trocoCT[i].nextFocus();
					} else {
						trocoCT[i].setNextFocusableComponent(trocoCT[7]);
						trocoCT[i].nextFocus();
					}
			}
		});
	}

	// Method 1 work
	private void cambioF() {
		for (int i = 0; i < 7; i++)
			cajaTroco[1][i].setText(Integer.valueOf(cajaTroco[1][i].getText()) - Integer.valueOf(troco[1][i].getText())
					+ Integer.valueOf(trocoCT[i].getText()) + "");
		saveProgress();
	}

	// Method 2 work
	private void cambioF2() {
		for (int i = 0; i < 7; i++)
			cajaTroco[1][i].setText(Integer.valueOf(cajaTroco[1][i].getText()) - Integer.valueOf(troco2[1][i].getText())
					+ Integer.valueOf(trocoCT[i].getText()) + "");
		saveProgress();
	}

	// Method 3 work
	private void cambioF3() {
		for (int i = 0; i < 7; i++)
			cajaTroco[1][i].setText(Integer.valueOf(cajaTroco[1][i].getText()) - Integer.valueOf(troco3[1][i].getText())
					+ Integer.valueOf(trocoCT[i].getText()) + "");
		saveProgress();
	}

	// Calc everything
	private void calTodo(JButton cambioN, JButton cambioN2, JButton cambioN3) {
		totalFatura = 0;
		for (int i = 0; i < 10; i++) // if input wrong make it 0
			if (!details[i][0].getText().isBlank() && !details[i][2].getText().isBlank()
					&& First.isNumeric(details[i][0].getText()) && First.isNumeric(details[i][2].getText())) {
				detailsR[i].setText(
						Integer.valueOf(details[i][0].getText()) * Integer.valueOf(details[i][2].getText()) + "");
				totalFatura += Integer.valueOf(detailsR[i].getText());
			}
		for (int i = 0; i < 8; i++)// if input wrong make it 0
			if (!First.isNumeric(trocoCT[i].getText()))
				trocoCT[i].setText("0");
		total.setText("R$ " + totalFatura);// total for the invoice
		totalCV = Integer.valueOf(trocoCT[0].getText()) + Integer.valueOf(trocoCT[1].getText()) * 2
				+ Integer.valueOf(trocoCT[2].getText()) * 5 + Integer.valueOf(trocoCT[3].getText()) * 10
				+ Integer.valueOf(trocoCT[4].getText()) * 20 + Integer.valueOf(trocoCT[5].getText()) * 50
				+ Integer.valueOf(trocoCT[6].getText()) * 100 + Integer.valueOf(trocoCT[7].getText()) * 200;
		totalC.setText("R$ " + totalCV);// total for the cliente
		cambio[3].setText("R$ " + totalFatura);
		cambio[5].setText("R$ " + totalCV);
		trocoV = totalCV - totalFatura;// troco
		if (totalCV < totalFatura)
			cambio[4].setText("-R$ " + (totalFatura - totalCV));
		else
			cambio[4].setText("R$ " + (totalCV - totalFatura));
		// Trocos
		if (trocoV >= 0) {
			// Smart
			int trocoRest = trocoV;
			int nbOf100 = Integer.valueOf(cajaTroco[1][6].getText()),
					nbOf50 = Integer.valueOf(cajaTroco[1][5].getText()),
					nbOf20 = Integer.valueOf(cajaTroco[1][4].getText()),
					nbOf10 = Integer.valueOf(cajaTroco[1][3].getText()),
					nbOf5 = Integer.valueOf(cajaTroco[1][2].getText()),
					nbOf2 = Integer.valueOf(cajaTroco[1][1].getText()),
					nbOf1 = Integer.valueOf(cajaTroco[1][0].getText());
			// 100
			if (trocoRest > 100)
				if (((trocoRest / 10) & 1) == 1 && nbOf10 == 0 && nbOf20 * 20 >= (trocoRest - 50) && trocoRest < 150) {
					if (nbOf50 > 0) {
						nbOf50--;
						trocoRest -= 50;
					}
				} else {
					if (nbOf100 > 0) {
						nbOf100--;
						trocoRest -= 100;
					}
				}
			// 10,20,50
			if (((trocoRest / 10) & 1) == 0 && nbOf10 == 0 && nbOf20 * 20 >= trocoRest)// we dont have 10
				while (trocoRest >= 20 && nbOf20 > 0) {
					nbOf20--;
					trocoRest -= 20;
				}
			else {// normal
				while (trocoRest >= 50 && nbOf50 > 0) {
					nbOf50--;
					trocoRest -= 50;
				}
				while (trocoRest >= 20 && nbOf20 > 0) {
					nbOf20--;
					trocoRest -= 20;
				}
				while (trocoRest >= 10 && nbOf10 > 0) {
					nbOf10--;
					trocoRest -= 10;
				}
			}
			// 1,2,5
			if ((trocoRest & 1) == 0 && nbOf1 == 0)// we dont have 1
				while (trocoRest >= 2 && nbOf2 > 0) {
					nbOf2--;
					trocoRest -= 2;
				}
			else {// normal
				while (trocoRest >= 5 && nbOf5 > 0) {
					nbOf5--;
					trocoRest -= 5;
				}
				while (trocoRest >= 2 && nbOf2 > 0) {
					nbOf2--;
					trocoRest -= 2;
				}
				while (trocoRest >= 1 && nbOf1 > 0) {
					nbOf1--;
					trocoRest--;
				}
			}
			// Method 1
			if (trocoRest == 0) {// smart
				troco[1][6].setText(Integer.valueOf(cajaTroco[1][6].getText()) - nbOf100 + "");
				troco[1][5].setText(Integer.valueOf(cajaTroco[1][5].getText()) - nbOf50 + "");
				troco[1][4].setText(Integer.valueOf(cajaTroco[1][4].getText()) - nbOf20 + "");
				troco[1][3].setText(Integer.valueOf(cajaTroco[1][3].getText()) - nbOf10 + "");
				troco[1][2].setText(Integer.valueOf(cajaTroco[1][2].getText()) - nbOf5 + "");
				troco[1][1].setText(Integer.valueOf(cajaTroco[1][1].getText()) - nbOf2 + "");
				troco[1][0].setText(Integer.valueOf(cajaTroco[1][0].getText()) - nbOf1 + "");
				cambioN.setText("√");
			} else {
				methodeReservo();
				if (Integer.valueOf(troco[1][0].getText()) <= Integer.valueOf((cajaTroco[1][0].getText()))
						&& Integer.valueOf(troco[1][1].getText()) <= Integer.valueOf((cajaTroco[1][1].getText()))
						&& Integer.valueOf(troco[1][2].getText()) <= Integer.valueOf((cajaTroco[1][2].getText()))
						&& Integer.valueOf(troco[1][3].getText()) <= Integer.valueOf((cajaTroco[1][3].getText()))
						&& Integer.valueOf(troco[1][4].getText()) <= Integer.valueOf((cajaTroco[1][4].getText()))
						&& Integer.valueOf(troco[1][5].getText()) <= Integer.valueOf((cajaTroco[1][5].getText()))
						&& Integer.valueOf(troco[1][6].getText()) <= Integer.valueOf((cajaTroco[1][6].getText())))
					cambioN.setText("√");
				else
					cambioN.setText("X");
			}
			// Method 2
			methodPopular();
			if (Integer.valueOf(troco2[1][0].getText()) <= Integer.valueOf((cajaTroco[1][0].getText()))
					&& Integer.valueOf(troco2[1][1].getText()) <= Integer.valueOf((cajaTroco[1][1].getText()))
					&& Integer.valueOf(troco2[1][2].getText()) <= Integer.valueOf((cajaTroco[1][2].getText()))
					&& Integer.valueOf(troco2[1][3].getText()) <= Integer.valueOf((cajaTroco[1][3].getText()))
					&& Integer.valueOf(troco2[1][4].getText()) <= Integer.valueOf((cajaTroco[1][4].getText()))
					&& Integer.valueOf(troco2[1][5].getText()) <= Integer.valueOf((cajaTroco[1][5].getText()))
					&& Integer.valueOf(troco2[1][6].getText()) <= Integer.valueOf((cajaTroco[1][6].getText())))
				cambioN2.setText("√");
			else
				cambioN2.setText("X");
			// Method 3
			methodBasico();
			if (Integer.valueOf(troco3[1][0].getText()) <= Integer.valueOf((cajaTroco[1][0].getText()))
					&& Integer.valueOf(troco3[1][1].getText()) <= Integer.valueOf((cajaTroco[1][1].getText()))
					&& Integer.valueOf(troco3[1][2].getText()) <= Integer.valueOf((cajaTroco[1][2].getText()))
					&& Integer.valueOf(troco3[1][3].getText()) <= Integer.valueOf((cajaTroco[1][3].getText()))
					&& Integer.valueOf(troco3[1][4].getText()) <= Integer.valueOf((cajaTroco[1][4].getText()))
					&& Integer.valueOf(troco3[1][5].getText()) <= Integer.valueOf((cajaTroco[1][5].getText()))
					&& Integer.valueOf(troco3[1][6].getText()) <= Integer.valueOf((cajaTroco[1][6].getText())))
				cambioN3.setText("√");
			else
				cambioN3.setText("X");
		} else

		{
			troco[1][6].setText("!");
			troco[1][5].setText("!");
			troco[1][4].setText("!");
			troco[1][3].setText("!");
			troco[1][2].setText("!");
			troco[1][1].setText("!");
			troco[1][0].setText("!");
			troco2[1][6].setText("!");
			troco2[1][5].setText("!");
			troco2[1][4].setText("!");
			troco2[1][3].setText("!");
			troco2[1][2].setText("!");
			troco2[1][1].setText("!");
			troco2[1][0].setText("!");
			troco3[1][6].setText("!");
			troco3[1][5].setText("!");
			troco3[1][4].setText("!");
			troco3[1][3].setText("!");
			troco3[1][2].setText("!");
			troco3[1][1].setText("!");
			troco3[1][0].setText("!");
			cambioN.setText("X");
			cambioN2.setText("X");
			cambioN3.setText("X");
		}
		if (cambioN.getText().equals("√")) {
			cambioN.setBackground(redC);
			cambioN.setBorder(First.workM);
		} else {
			cambioN.setBackground(redD);
			cambioN.setBorder(First.border);
		}
		if (cambioN2.getText().equals("√")) {
			cambioN2.setBackground(violetC);
			cambioN2.setBorder(First.workM);
		} else {
			cambioN2.setBackground(violetD);
			cambioN2.setBorder(First.border);
		}
		if (cambioN3.getText().equals("√")) {
			cambioN3.setBackground(turC);
			cambioN3.setBorder(First.workM);
		} else {
			cambioN3.setBackground(turD);
			cambioN3.setBorder(First.border);
		}
	}

	private void methodeReservo() {
		troco[1][6].setText((trocoV / 100) + "");// 100
		// Por 10,20,50
		switch ((trocoV - (trocoV / 100) * 100) / 10) {
		case 0: {
			troco[1][5].setText("0");
			troco[1][4].setText("0");
			troco[1][3].setText("0");
			break;
		}
		case 1: {
			troco[1][5].setText("0");
			troco[1][4].setText("0");
			troco[1][3].setText("1");
			break;
		}
		case 2: {
			troco[1][5].setText("0");
			troco[1][4].setText("0");
			troco[1][3].setText("2");
			break;
		}
		case 3: {
			troco[1][5].setText("0");
			troco[1][4].setText("0");
			troco[1][3].setText("3");
			break;
		}
		case 4: {
			troco[1][5].setText("0");
			troco[1][4].setText("0");
			troco[1][3].setText("4");
			break;
		}
		case 5: {
			troco[1][5].setText("0");
			troco[1][4].setText("1");
			troco[1][3].setText("3");
			break;
		}
		case 6: {
			troco[1][5].setText("0");
			troco[1][4].setText("2");
			troco[1][3].setText("2");
			break;
		}
		case 7: {
			troco[1][5].setText("1");
			troco[1][4].setText("0");
			troco[1][3].setText("2");
			break;
		}
		case 8: {
			troco[1][5].setText("1");
			troco[1][4].setText("0");
			troco[1][3].setText("3");
			break;
		}
		case 9: {
			troco[1][5].setText("1");
			troco[1][4].setText("1");
			troco[1][3].setText("2");
			break;
		}
		}
		// Por 1,2,5
		switch ((trocoV - (trocoV / 10) * 10)) {
		case 0: {
			troco[1][2].setText("0");
			troco[1][1].setText("0");
			troco[1][0].setText("0");
			break;
		}
		case 1: {
			troco[1][2].setText("0");
			troco[1][1].setText("0");
			troco[1][0].setText("1");
			break;
		}
		case 2: {
			troco[1][2].setText("0");
			troco[1][1].setText("0");
			troco[1][0].setText("2");
			break;
		}
		case 3: {
			troco[1][2].setText("0");
			troco[1][1].setText("0");
			troco[1][0].setText("3");
			break;
		}
		case 4: {
			troco[1][2].setText("0");
			troco[1][1].setText("0");
			troco[1][0].setText("4");
			break;
		}
		case 5: {
			troco[1][2].setText("0");
			troco[1][1].setText("1");
			troco[1][0].setText("3");
			break;
		}
		case 6: {
			troco[1][2].setText("0");
			troco[1][1].setText("2");
			troco[1][0].setText("2");
			break;
		}
		case 7: {
			troco[1][2].setText("1");
			troco[1][1].setText("0");
			troco[1][0].setText("2");
			break;
		}
		case 8: {
			troco[1][2].setText("1");
			troco[1][1].setText("0");
			troco[1][0].setText("3");
			break;
		}
		case 9: {
			troco[1][2].setText("1");
			troco[1][1].setText("1");
			troco[1][0].setText("2");
			break;
		}
		}
	}

	private void methodBasico() {
		troco3[1][6].setText((trocoV / 100) + "");// 100
		// Por 10,20,50
		switch ((trocoV - (trocoV / 100) * 100) / 10) {
		case 0: {
			troco3[1][5].setText("0");
			troco3[1][4].setText("0");
			troco3[1][3].setText("0");
			break;
		}
		case 1: {
			troco3[1][5].setText("0");
			troco3[1][4].setText("0");
			troco3[1][3].setText("1");
			break;
		}
		case 2: {
			troco3[1][5].setText("0");
			troco3[1][4].setText("1");
			troco3[1][3].setText("0");
			break;
		}
		case 3: {
			troco3[1][5].setText("0");
			troco3[1][4].setText("1");
			troco3[1][3].setText("1");
			break;
		}
		case 4: {
			troco3[1][5].setText("0");
			troco3[1][4].setText("1");
			troco3[1][3].setText("2");
			break;
		}
		case 5: {
			troco3[1][5].setText("0");
			troco3[1][4].setText("2");
			troco3[1][3].setText("1");
			break;
		}
		case 6: {
			troco3[1][5].setText("0");
			troco3[1][4].setText("3");
			troco3[1][3].setText("0");
			break;
		}
		case 7: {
			troco3[1][5].setText("0");
			troco3[1][4].setText("3");
			troco3[1][3].setText("1");
			break;
		}
		case 8: {
			troco3[1][5].setText("0");
			troco3[1][4].setText("4");
			troco3[1][3].setText("0");
			break;
		}
		case 9: {
			troco3[1][5].setText("0");
			troco3[1][4].setText("4");
			troco3[1][3].setText("1");
			break;
		}
		}
		// Por 1,2,5
		switch ((trocoV - (trocoV / 10) * 10)) {
		case 0: {
			troco3[1][2].setText("0");
			troco3[1][1].setText("0");
			troco3[1][0].setText("0");
			break;
		}
		case 1: {
			troco3[1][2].setText("0");
			troco3[1][1].setText("0");
			troco3[1][0].setText("1");
			break;
		}
		case 2: {
			troco3[1][2].setText("0");
			troco3[1][1].setText("1");
			troco3[1][0].setText("0");
			break;
		}
		case 3: {
			troco3[1][2].setText("0");
			troco3[1][1].setText("1");
			troco3[1][0].setText("1");
			break;
		}
		case 4: {
			troco3[1][2].setText("0");
			troco3[1][1].setText("1");
			troco3[1][0].setText("2");
			break;
		}
		case 5: {
			troco3[1][2].setText("0");
			troco3[1][1].setText("2");
			troco3[1][0].setText("1");
			break;
		}
		case 6: {
			troco3[1][2].setText("0");
			troco3[1][1].setText("3");
			troco3[1][0].setText("0");
			break;
		}
		case 7: {
			troco3[1][2].setText("0");
			troco3[1][1].setText("3");
			troco3[1][0].setText("1");
			break;
		}
		case 8: {
			troco3[1][2].setText("0");
			troco3[1][1].setText("4");
			troco3[1][0].setText("0");
			break;
		}
		case 9: {
			troco3[1][2].setText("0");
			troco3[1][1].setText("4");
			troco3[1][0].setText("1");
			break;
		}
		}
	}

	private void methodPopular() {
		troco2[1][6].setText((trocoV / 100) + "");// 100
		// Por 10,20,50
		switch ((trocoV - (trocoV / 100) * 100) / 10) {
		case 0: {
			troco2[1][5].setText("0");
			troco2[1][4].setText("0");
			troco2[1][3].setText("0");
			break;
		}
		case 1: {
			troco2[1][5].setText("0");
			troco2[1][4].setText("0");
			troco2[1][3].setText("1");
			break;
		}
		case 2: {
			troco2[1][5].setText("0");
			troco2[1][4].setText("1");
			troco2[1][3].setText("0");
			break;
		}
		case 3: {
			troco2[1][5].setText("0");
			troco2[1][4].setText("1");
			troco2[1][3].setText("1");
			break;
		}
		case 4: {
			troco2[1][5].setText("0");
			troco2[1][4].setText("2");
			troco2[1][3].setText("0");
			break;
		}
		case 5: {
			troco2[1][5].setText("1");
			troco2[1][4].setText("0");
			troco2[1][3].setText("0");
			break;
		}
		case 6: {
			troco2[1][5].setText("1");
			troco2[1][4].setText("0");
			troco2[1][3].setText("1");
			break;
		}
		case 7: {
			troco2[1][5].setText("1");
			troco2[1][4].setText("1");
			troco2[1][3].setText("0");
			break;
		}
		case 8: {
			troco2[1][5].setText("1");
			troco2[1][4].setText("1");
			troco2[1][3].setText("1");
			break;
		}
		case 9: {
			troco2[1][5].setText("1");
			troco2[1][4].setText("2");
			troco2[1][3].setText("0");
			break;
		}
		}
		// Por 1,2,5
		switch ((trocoV - (trocoV / 10) * 10)) {
		case 0: {
			troco2[1][2].setText("0");
			troco2[1][1].setText("0");
			troco2[1][0].setText("0");
			break;
		}
		case 1: {
			troco2[1][2].setText("0");
			troco2[1][1].setText("0");
			troco2[1][0].setText("1");
			break;
		}
		case 2: {
			troco2[1][2].setText("0");
			troco2[1][1].setText("1");
			troco2[1][0].setText("0");
			break;
		}
		case 3: {
			troco2[1][2].setText("0");
			troco2[1][1].setText("1");
			troco2[1][0].setText("1");
			break;
		}
		case 4: {
			troco2[1][2].setText("0");
			troco2[1][1].setText("2");
			troco2[1][0].setText("0");
			break;
		}
		case 5: {
			troco2[1][2].setText("1");
			troco2[1][1].setText("0");
			troco2[1][0].setText("0");
			break;
		}
		case 6: {
			troco2[1][2].setText("1");
			troco2[1][1].setText("0");
			troco2[1][0].setText("1");
			break;
		}
		case 7: {
			troco2[1][2].setText("1");
			troco2[1][1].setText("1");
			troco2[1][0].setText("0");
			break;
		}
		case 8: {
			troco2[1][2].setText("1");
			troco2[1][1].setText("1");
			troco2[1][0].setText("1");
			break;
		}
		case 9: {
			troco2[1][2].setText("1");
			troco2[1][1].setText("2");
			troco2[1][0].setText("0");
			break;
		}
		}
	}

	// Add a set of 100
	private static int setCounter(int nbTwenty) {
		int numHun = nbTwenty * 20;
		int counter = 0;
		while (numHun > 100) {
			numHun -= 100;
			counter++;
		}
		return counter;
	}

	// SAVE NEW VALUE
	private static void saveProgress() {
		String temp = totalFatura + "";
		int z = 0;
		int nbOf100 = 0, nbOf20 = Integer.valueOf(cajaTroco[1][4].getText());
		if (nbOf20 > 5) {
			nbOf100 = setCounter(nbOf20);
			nbOf20 -= nbOf100 * 5;
		} else
			nbOf100 = 0;
		String currentpath = System.getProperty("user.dir");
		File tempFile0 = new File(currentpath + "\\data");
		tempFile0.mkdir();
		File newFile = new File(tempFile0, "narjes.dll");
		try {
			FileWriter savedF = new FileWriter(newFile);
			int i = 0;
			while (i < 120) {// Ventas + total
				if ((numbers[i].isBlank() || Integer.valueOf(numbers[i]) == 0 || !First.isNumeric(numbers[i]))
						&& Integer.valueOf(temp) != 0 && !totalC.getText().isBlank()) {
					savedF.write(temp + System.lineSeparator());
					temp = "0";
					i++;
				} else {
					savedF.write(numbers[i] + System.lineSeparator());
					i++;
				}
			} // Initial value
			savedF.write(numbers[i] + System.lineSeparator());
			i++;
			z = i + 16;
			while (i < z) {// gastos
				savedF.write(numbers[i] + System.lineSeparator());
				i++;
			}
			z = i + 16;
			while (i < z) {// agregados
				savedF.write(numbers[i] + System.lineSeparator());
				i++;
			}
			savedF.write(numbers[i] + System.lineSeparator());// set of 1000
			i++;
			savedF.write(nbOf100 + System.lineSeparator());// set of 100
			i++;// valor of 200 in the cash + that the cliente paid
			if (!First.isNumeric(trocoCT[7].getText()))
				trocoCT[7].setText("0");
			int nb200 = Integer.valueOf(numbers[i]) + Integer.valueOf(trocoCT[7].getText());
			savedF.write(nb200 + System.lineSeparator());
			i++;
			z = i + 7;
			while (i < z) {// Valores from 1 to 100
				if (i == (z - 5)) {
					savedF.write(nbOf20 + System.lineSeparator());
				} else
					savedF.write(cajaTroco[1][z - i - 1].getText() + System.lineSeparator());
				i++;
			}
			savedF.write(numbers[i]);// pix save
			savedF.close();
			First.savedCorrectly(language);
		} catch (Exception e) {
			JOptionPane opt = new JOptionPane(
					language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
					JOptionPane.ERROR_MESSAGE);
			opt.show();
		}
	}

	// Style of textField
	private void textFieldStyle(JTextField tf) {
		tf.setBackground(blueC);
		tf.setForeground(blueD);
		tf.setFont(First.myFont);
		tf.setBorder(First.border);
		tf.setHorizontalAlignment(0);
		tf.setCaretColor(First.defaultColor);
		tf.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				String str = tf.getText();
				tf.setText(str);
				tf.selectAll();
			}

			@Override
			public void focusLost(FocusEvent e) {
				totalFatura = 0;
				for (int i = 0; i < 10; i++) {// if input wrong make it 0
					if (!details[i][0].getText().isBlank() && !details[i][2].getText().isBlank()
							&& First.isNumeric(details[i][0].getText()) && First.isNumeric(details[i][2].getText())) {
						detailsR[i].setText(
								Integer.valueOf(details[i][0].getText()) * Integer.valueOf(details[i][2].getText())
										+ "");
						totalFatura += Integer.valueOf(detailsR[i].getText());
					} else
						detailsR[i].setText("");
				}
				total.setText("R$ " + totalFatura);// total for the invoice
			}
		});

	}

	// Style of formattedTextField
	private void formatedTextFieldStyle(JFormattedTextField tf, JButton cambioN, JButton cambioN2, JButton cambioN3) {
		tf.setBackground(blueC);
		tf.setForeground(blueD);
		tf.setFont(First.myFont);
		tf.setBorder(First.border);
		tf.setHorizontalAlignment(0);
		tf.setCaretColor(First.defaultColor);
		tf.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				String str = tf.getText();
				tf.setText(str);
				tf.selectAll();
			}

			@Override
			public void focusLost(FocusEvent e) {
				calTodo(cambioN, cambioN2, cambioN3);
			}
		});

	}

	private void resXP(JMenuItem resoD, JMenuItem resoXP, JMenuItem resoP, JMenuItem resoM, JMenuItem resoG,
			JButton cambioN, JButton cambioN2, JButton mainF, JButton cambioN3, JButton clearB) {
		// dimensions
		this.setSize(1000, 600);
		resoXP.setEnabled(false);
		resoP.setEnabled(true);
		resoM.setEnabled(true);
		resoG.setEnabled(true);
		if (width >= 1800)
			if (this.getWidth() == 1820)
				resoD.setEnabled(false);
			else
				resoD.setEnabled(true);
		else if (width >= 1500)
			if (this.getWidth() == 1500)
				resoD.setEnabled(false);
			else
				resoD.setEnabled(true);
		else if (width >= 1300)
			if (this.getWidth() == 1300)
				resoD.setEnabled(false);
			else
				resoD.setEnabled(true);
		else if (width >= 500)
			if (this.getWidth() == 1000)
				resoD.setEnabled(false);
			else
				resoD.setEnabled(true);
		First.myFont = new Font("Tahoma", Font.BOLD, 16);
		First.myFontS = new Font("Tahoma", Font.BOLD, 12);

		// invoice
		for (int i = 0; i < 4; i++)
			title[i].setFont(First.myFont);
		title[0].setBounds(40, 40, 50, 35);
		title[1].setBounds(89, 40, 140, 35);
		title[2].setBounds(228, 40, 60, 35);
		title[3].setBounds(287, 40, 100, 35);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 3; j++)
				details[i][j].setFont(First.myFontS);
			details[i][0].setBounds(40, 74 + i * 30, 50, 30);
			details[i][1].setBounds(89, 74 + i * 30, 140, 30);
			details[i][2].setBounds(228, 74 + i * 30, 60, 30);
		}
		for (int i = 0; i < 10; i++) {
			detailsR[i].setBounds(287, 74 + i * 30, 100, 30);
			detailsR[i].setFont(First.myFontS);
		}
		total.setFont(First.myFont);
		total.setBounds(287, 372, 100, 32);

		// caja
		caja.setBounds(20, 450, 80, 70);
		caja.setFont(First.myFont);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 7; j++) {
				cajaTroco[i][j].setBounds(100 + 49 * j, 450 + 35 * i, 50, 35);
				cajaTroco[i][j].setFont(First.myFont);
				if (i == 0) {
					switch (j) {
					case 0:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 50, 35)));
						break;
					case 1:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 50, 35)));
						break;
					case 2:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 50, 35)));
						break;
					case 3:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 50, 35)));
						break;
					case 4:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i20.getImage(), 50, 35)));
						break;
					case 5:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i50.getImage(), 50, 35)));
						break;
					case 6:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i100.getImage(), 50, 35)));
						break;
					default:
						break;
					}
				}
			}

		// cambio for cliente
		cambioC.setBounds(430, 52, 353, 50);
		cambioC.setFont(First.myFont);
		for (int i = 0; i < 8; i++) {
			trocoC[i].setBounds(430 + 44 * i, 99, 45, 35);
			switch (i) {
			case 0:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 45, 35)));
				break;
			case 1:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 45, 35)));
				break;
			case 2:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 45, 35)));
				break;
			case 3:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 45, 35)));
				break;
			case 4:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i20.getImage(), 45, 35)));
				break;
			case 5:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i50.getImage(), 45, 35)));
				break;
			case 6:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i100.getImage(), 45, 35)));
				break;
			case 7:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i200.getImage(), 45, 35)));
				break;
			default:
				break;
			}
			trocoCT[i].setFont(First.myFont);
			trocoCT[i].setBounds(430 + 44 * i, 133, 45, 35);
		}
		totalC.setBounds(430, 166, 353, 40);
		totalC.setFont(First.myFont);

		// troco panel
		for (int i = 0; i < 6; i++) {
			cambio[i].setFont(First.myFont);
			if (i < 3)
				cambio[i].setBounds(800, 90 + 34 * i, 80, 35);
		}
		cambio[3].setBounds(880, 124, 80, 35);
		cambio[4].setBounds(880, 158, 80, 35);
		cambio[5].setBounds(880, 90, 80, 35);

		// cambio 1
		cambioN.setBounds(480, 250, 100, 70);
		cambioN.setFont(First.myFont);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 7; j++) {
				troco[i][j].setBounds(580 + 44 * j, 250 + i * 35, 45, 35);
				if (i == 0) {
					switch (j) {
					case 0:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 45, 35)));
						break;
					case 1:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 45, 35)));
						break;
					case 2:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 45, 35)));
						break;
					case 3:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 45, 35)));
						break;
					case 4:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i20.getImage(), 45, 35)));
						break;
					case 5:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i50.getImage(), 45, 35)));
						break;
					case 6:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i100.getImage(), 45, 35)));
						break;
					default:
						break;
					}
				} else
					troco[i][j].setText("0");
				troco[i][j].setFont(First.myFont);
			}

		// cambio 2
		cambioN2.setBounds(480, 350, 100, 70);
		cambioN2.setFont(First.myFont);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 7; j++) {
				troco2[i][j].setBounds(580 + 44 * j, 350 + i * 35, 45, 35);
				if (i == 0) {
					switch (j) {
					case 0:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 45, 35)));
						break;
					case 1:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 45, 35)));
						break;
					case 2:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 45, 35)));
						break;
					case 3:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 45, 35)));
						break;
					case 4:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i20.getImage(), 45, 35)));
						break;
					case 5:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i50.getImage(), 45, 35)));
						break;
					case 6:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i100.getImage(), 45, 35)));
						break;
					default:
						break;
					}
				}
				troco2[i][j].setFont(First.myFont);
			}

		// cambio 3
		cambioN3.setBounds(480, 450, 100, 70);
		cambioN3.setFont(First.myFont);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 7; j++) {
				troco3[i][j].setBounds(580 + 44 * j, 450 + i * 35, 45, 35);
				if (i == 0) {
					switch (j) {
					case 0:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 45, 35)));
						break;
					case 1:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 45, 35)));
						break;
					case 2:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 45, 35)));
						break;
					case 3:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 45, 35)));
						break;
					case 4:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i20.getImage(), 45, 35)));
						break;
					case 5:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i50.getImage(), 45, 35)));
						break;
					case 6:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i100.getImage(), 45, 35)));
						break;
					default:
						break;
					}
				}
				troco3[i][j].setFont(First.myFont);
			}
		mainF.setBounds(910, 400, 55, 55);
		mainF.setIcon(new ImageIcon(getScaledImage(mainIcon.getImage(), 55, 55)));
		clearB.setBounds(910, 300, 55, 55);
		clearB.setIcon(new ImageIcon(getScaledImage(clearI.getImage(), 55, 55)));

	}

	private void resP(JMenuItem resoD, JMenuItem resoXP, JMenuItem resoP, JMenuItem resoM, JMenuItem resoG,
			JButton cambioN, JButton cambioN2, JButton mainF, JButton cambioN3, JButton clearB) {
		// dimensions
		this.setSize(1300, 700);
		resoXP.setEnabled(true);
		resoP.setEnabled(false);
		resoM.setEnabled(true);
		resoG.setEnabled(true);
		if (width >= 1800)
			if (this.getWidth() == 1820)
				resoD.setEnabled(false);
			else
				resoD.setEnabled(true);
		else if (width >= 1500)
			if (this.getWidth() == 1500)
				resoD.setEnabled(false);
			else
				resoD.setEnabled(true);
		else if (width >= 1300)
			if (this.getWidth() == 1300)
				resoD.setEnabled(false);
			else
				resoD.setEnabled(true);
		else if (width >= 500)
			if (this.getWidth() == 1000)
				resoD.setEnabled(false);
			else
				resoD.setEnabled(true);
		First.myFont = new Font("Tahoma", Font.BOLD, 17);
		First.myFontS = new Font("Tahoma", Font.BOLD, 14);

		// invoice
		for (int i = 0; i < 4; i++)
			title[i].setFont(First.myFont);
		title[0].setBounds(40, 40, 60, 40);
		title[1].setBounds(98, 40, 180, 40);
		title[2].setBounds(276, 40, 75, 40);
		title[3].setBounds(349, 40, 100, 40);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 3; j++)
				details[i][j].setFont(First.myFont);
			details[i][0].setBounds(40, 80 + i * 35, 60, 35);
			details[i][1].setBounds(98, 80 + i * 35, 180, 35);
			details[i][2].setBounds(276, 80 + i * 35, 75, 35);
		}
		for (int i = 0; i < 10; i++) {
			detailsR[i].setBounds(349, 80 + i * 35, 100, 35);
			detailsR[i].setFont(First.myFont);
		}
		total.setFont(First.myFont);
		total.setBounds(344, 428, 100, 40);

		// caja
		caja.setBounds(20, 520, 65, 79);
		caja.setFont(First.myFont);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 7; j++) {
				cajaTroco[i][j].setBounds(85 + 59 * j, 520 + 39 * i, 60, 40);
				cajaTroco[i][j].setFont(First.myFont);
				if (i == 0) {
					switch (j) {
					case 0:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 60, 40)));
						break;
					case 1:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 60, 40)));
						break;
					case 2:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 60, 40)));
						break;
					case 3:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 60, 40)));
						break;
					case 4:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i20.getImage(), 60, 40)));
						break;
					case 5:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i50.getImage(), 60, 40)));
						break;
					case 6:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i100.getImage(), 60, 40)));
						break;
					default:
						break;
					}
				}
			}

		// cambio for cliente
		cambioC.setBounds(510, 52, 473, 50);
		cambioC.setFont(First.myFont);
		for (int i = 0; i < 8; i++) {
			trocoC[i].setBounds(510 + 59 * i, 100, 60, 40);
			switch (i) {
			case 0:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 60, 40)));
				break;
			case 1:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 60, 40)));
				break;
			case 2:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 60, 40)));
				break;
			case 3:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 60, 40)));
				break;
			case 4:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i20.getImage(), 60, 40)));
				break;
			case 5:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i50.getImage(), 60, 40)));
				break;
			case 6:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i100.getImage(), 60, 40)));
				break;
			case 7:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i200.getImage(), 60, 40)));
				break;
			default:
				break;
			}
			trocoCT[i].setFont(First.myFont);
			trocoCT[i].setBounds(510 + 59 * i, 140, 60, 40);
		}
		totalC.setBounds(510, 178, 473, 40);
		totalC.setFont(First.myFont);

		// troco panel
		for (int i = 0; i < 6; i++) {
			cambio[i].setFont(First.myFont);
			if (i < 3)
				cambio[i].setBounds(1020, 70 + 40 * i, 100, 40);
		}
		cambio[3].setBounds(1120, 110, 140, 40);
		cambio[4].setBounds(1120, 150, 140, 40);
		cambio[5].setBounds(1120, 70, 140, 40);

		// cambio 1
		cambioN.setBounds(580, 270, 100, 79);
		cambioN.setFont(First.myFont);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 7; j++) {
				troco[i][j].setBounds(680 + 59 * j, 270 + 39 * i, 60, 40);
				if (i == 0) {
					switch (j) {
					case 0:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 60, 40)));
						break;
					case 1:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 60, 40)));
						break;
					case 2:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 60, 40)));
						break;
					case 3:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 60, 40)));
						break;
					case 4:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i20.getImage(), 60, 40)));
						break;
					case 5:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i50.getImage(), 60, 40)));
						break;
					case 6:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i100.getImage(), 60, 40)));
						break;
					default:
						break;
					}
				} else
					troco[i][j].setText("0");
				troco[i][j].setFont(First.myFont);
			}

		// cambio 2
		cambioN2.setBounds(580, 400, 100, 79);
		cambioN2.setFont(First.myFont);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 7; j++) {
				troco2[i][j].setBounds(680 + 59 * j, 400 + 39 * i, 60, 40);
				if (i == 0) {
					switch (j) {
					case 0:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 60, 40)));
						break;
					case 1:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 60, 40)));
						break;
					case 2:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 60, 40)));
						break;
					case 3:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 60, 40)));
						break;
					case 4:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i20.getImage(), 60, 40)));
						break;
					case 5:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i50.getImage(), 60, 40)));
						break;
					case 6:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i100.getImage(), 60, 40)));
						break;
					default:
						break;
					}
				}
				troco2[i][j].setFont(First.myFont);
			}

		// cambio 3
		cambioN3.setBounds(580, 530, 100, 79);
		cambioN3.setFont(First.myFont);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 7; j++) {
				troco3[i][j].setBounds(680 + 59 * j, 530 + 39 * i, 60, 40);
				if (i == 0) {
					switch (j) {
					case 0:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 60, 40)));
						break;
					case 1:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 60, 40)));
						break;
					case 2:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 60, 40)));
						break;
					case 3:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 60, 40)));
						break;
					case 4:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i20.getImage(), 60, 40)));
						break;
					case 5:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i50.getImage(), 60, 40)));
						break;
					case 6:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i100.getImage(), 60, 40)));
						break;
					default:
						break;
					}
				}
				troco3[i][j].setFont(First.myFont);
			}
		mainF.setBounds(1150, 430, 70, 70);
		mainF.setIcon(new ImageIcon(getScaledImage(mainIcon.getImage(), 70, 70)));
		clearB.setBounds(1150, 300, 70, 70);
		clearB.setIcon(new ImageIcon(getScaledImage(clearI.getImage(), 70, 70)));
	}

	private void resM(JMenuItem resoD, JMenuItem resoXP, JMenuItem resoP, JMenuItem resoM, JMenuItem resoG,
			JButton cambioN, JButton cambioN2, JButton mainF, JButton cambioN3, JButton clearB) {
		// dimensions
		this.setSize(1500, 800);
		resoXP.setEnabled(true);
		resoP.setEnabled(true);
		resoM.setEnabled(false);
		resoG.setEnabled(true);
		if (width >= 1800)
			if (this.getWidth() == 1820)
				resoD.setEnabled(false);
			else
				resoD.setEnabled(true);
		else if (width >= 1500)
			if (this.getWidth() == 1500)
				resoD.setEnabled(false);
			else
				resoD.setEnabled(true);
		else if (width >= 1300)
			if (this.getWidth() == 1300)
				resoD.setEnabled(false);
			else
				resoD.setEnabled(true);
		else if (width >= 500)
			if (this.getWidth() == 1000)
				resoD.setEnabled(false);
			else
				resoD.setEnabled(true);
		First.myFont = new Font("Tahoma", Font.BOLD, 21);
		First.myFontS = new Font("Tahoma", Font.BOLD, 17);

		// invoice
		for (int i = 0; i < 4; i++)
			title[i].setFont(First.myFont);
		title[0].setBounds(40, 40, 70, 50);
		title[1].setBounds(108, 40, 200, 50);
		title[2].setBounds(306, 40, 90, 50);
		title[3].setBounds(394, 40, 120, 50);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 3; j++)
				details[i][j].setFont(First.myFont);
			details[i][0].setBounds(40, 90 + i * 40, 70, 40);
			details[i][1].setBounds(108, 90 + i * 40, 200, 40);
			details[i][2].setBounds(306, 90 + i * 40, 90, 40);
		}

		for (int i = 0; i < 10; i++) {
			detailsR[i].setBounds(394, 90 + i * 40, 120, 40);
			detailsR[i].setFont(First.myFont);
		}
		total.setFont(First.myFont);
		total.setBounds(394, 489, 120, 45);

		// caja
		caja.setBounds(20, 580, 75, 99);
		caja.setFont(First.myFont);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 7; j++) {
				cajaTroco[i][j].setBounds(95 + 69 * j, 580 + 49 * i, 70, 50);
				cajaTroco[i][j].setFont(First.myFont);
				if (i == 0) {
					switch (j) {
					case 0:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 70, 50)));
						break;
					case 1:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 70, 50)));
						break;
					case 2:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 70, 50)));
						break;
					case 3:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 70, 50)));
						break;
					case 4:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i20.getImage(), 70, 50)));
						break;
					case 5:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i50.getImage(), 70, 50)));
						break;
					case 6:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i100.getImage(), 70, 50)));
						break;
					default:
						break;
					}
				}
			}

		// cambio for cliente
		cambioC.setBounds(590, 52, 553, 60);
		cambioC.setFont(First.myFont);
		for (int i = 0; i < 8; i++) {
			trocoC[i].setBounds(590 + 69 * i, 110, 70, 50);
			switch (i) {
			case 0:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 70, 50)));
				break;
			case 1:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 70, 50)));
				break;
			case 2:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 70, 50)));
				break;
			case 3:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 70, 50)));
				break;
			case 4:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i20.getImage(), 70, 50)));
				break;
			case 5:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i50.getImage(), 70, 50)));
				break;
			case 6:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i100.getImage(), 70, 50)));
				break;
			case 7:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i200.getImage(), 70, 50)));
				break;
			default:
				break;
			}
			trocoCT[i].setFont(First.myFont);
			trocoCT[i].setBounds(590 + 69 * i, 160, 70, 50);
		}
		totalC.setBounds(590, 208, 553, 50);
		totalC.setFont(First.myFont);

		// troco panel
		for (int i = 0; i < 6; i++) {
			cambio[i].setFont(First.myFont);
			if (i < 3)
				cambio[i].setBounds(1180, 80 + 50 * i, 110, 50);
		}
		cambio[3].setBounds(1289, 130, 150, 50);
		cambio[4].setBounds(1289, 180, 150, 50);
		cambio[5].setBounds(1289, 80, 150, 50);

		// cambio 1
		cambioN.setBounds(622, 320, 120, 99);
		cambioN.setFont(First.myFont);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 7; j++) {
				troco[i][j].setBounds(740 + 69 * j, 320 + 49 * i, 70, 50);
				if (i == 0) {
					switch (j) {
					case 0:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 70, 50)));
						break;
					case 1:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 70, 50)));
						break;
					case 2:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 70, 50)));
						break;
					case 3:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 70, 50)));
						break;
					case 4:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i20.getImage(), 70, 50)));
						break;
					case 5:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i50.getImage(), 70, 50)));
						break;
					case 6:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i100.getImage(), 70, 50)));
						break;
					default:
						break;
					}
				}
				troco[i][j].setFont(First.myFont);
			}

		// cambio 2
		cambioN2.setBounds(622, 450, 120, 99);
		cambioN2.setFont(First.myFont);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 7; j++) {
				troco2[i][j].setBounds(740 + 69 * j, 450 + 49 * i, 70, 50);
				if (i == 0) {
					switch (j) {
					case 0:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 70, 50)));
						break;
					case 1:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 70, 50)));
						break;
					case 2:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 70, 50)));
						break;
					case 3:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 70, 50)));
						break;
					case 4:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i20.getImage(), 70, 50)));
						break;
					case 5:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i50.getImage(), 70, 50)));
						break;
					case 6:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i100.getImage(), 70, 50)));
						break;
					default:
						break;
					}
				}
				troco2[i][j].setFont(First.myFont);
			}

		// cambio 3
		cambioN3.setBounds(622, 580, 120, 99);
		cambioN3.setFont(First.myFont);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 7; j++) {
				troco3[i][j].setBounds(740 + 69 * j, 580 + 49 * i, 70, 50);
				if (i == 0) {
					switch (j) {
					case 0:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 70, 50)));
						break;
					case 1:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 70, 50)));
						break;
					case 2:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 70, 50)));
						break;
					case 3:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 70, 50)));
						break;
					case 4:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i20.getImage(), 70, 50)));
						break;
					case 5:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i50.getImage(), 70, 50)));
						break;
					case 6:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i100.getImage(), 70, 50)));
						break;
					default:
						break;
					}
				}
				troco3[i][j].setFont(First.myFont);
			}
		mainF.setBounds(1300, 530, 70, 70);
		mainF.setIcon(new ImageIcon(getScaledImage(mainIcon.getImage(), 70, 70)));
		clearB.setBounds(1300, 380, 70, 70);
		clearB.setIcon(new ImageIcon(getScaledImage(clearI.getImage(), 70, 70)));
	}

	private void resG(JMenuItem resoD, JMenuItem resoXP, JMenuItem resoP, JMenuItem resoM, JMenuItem resoG,
			JButton cambioN, JButton cambioN2, JButton mainF, JButton cambioN3, JButton clearB) {
		// dimensions
		this.setSize(1820, 980);
		resoXP.setEnabled(true);
		resoP.setEnabled(true);
		resoM.setEnabled(true);
		resoG.setEnabled(false);
		if (width >= 1800)
			if (this.getWidth() == 1820)
				resoD.setEnabled(false);
			else
				resoD.setEnabled(true);
		else if (width >= 1500)
			if (this.getWidth() == 1500)
				resoD.setEnabled(false);
			else
				resoD.setEnabled(true);
		else if (width >= 1300)
			if (this.getWidth() == 1300)
				resoD.setEnabled(false);
			else
				resoD.setEnabled(true);
		else if (width >= 500)
			if (this.getWidth() == 1000)
				resoD.setEnabled(false);
			else
				resoD.setEnabled(true);
		First.myFont = new Font("Tahoma", Font.BOLD, 24);
		First.myFontS = new Font("Tahoma", Font.BOLD, 20);

		// invoice
		for (int i = 0; i < 4; i++)
			title[i].setFont(First.myFont);
		title[0].setBounds(40, 40, 100, 50);
		title[1].setBounds(139, 40, 270, 50);
		title[2].setBounds(408, 40, 110, 50);
		title[3].setBounds(517, 40, 140, 50);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 3; j++)
				details[i][j].setFont(First.myFont);
			details[i][0].setBounds(40, 89 + i * 50, 100, 50);
			details[i][1].setBounds(139, 89 + i * 50, 270, 50);
			details[i][2].setBounds(408, 89 + i * 50, 110, 50);
		}
		for (int i = 0; i < 10; i++) {
			detailsR[i].setBounds(517, 89 + i * 50, 140, 50);
			detailsR[i].setFont(First.myFont);
		}
		total.setFont(First.myFont);
		total.setBounds(517, 588, 140, 55);

		// caja
		caja.setBounds(20, 710, 100, 119);
		caja.setFont(First.myFont);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 7; j++) {
				cajaTroco[i][j].setBounds(120 + 79 * j, 710 + 59 * i, 80, 60);
				cajaTroco[i][j].setFont(First.myFont);
				if (i == 0) {
					switch (j) {
					case 0:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 80, 60)));
						break;
					case 1:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 80, 60)));
						break;
					case 2:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 80, 60)));
						break;
					case 3:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 80, 60)));
						break;
					case 4:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i20.getImage(), 80, 60)));
						break;
					case 5:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i50.getImage(), 80, 60)));
						break;
					case 6:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i100.getImage(), 80, 60)));
						break;
					default:
						break;
					}
				}
			}

		// cambio for cliente
		cambioC.setBounds(750, 52, 633, 70);
		cambioC.setFont(First.myFont);
		for (int i = 0; i < 8; i++) {
			trocoC[i].setBounds(750 + 79 * i, 120, 80, 60);
			switch (i) {
			case 0:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 80, 60)));
				break;
			case 1:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 80, 60)));
				break;
			case 2:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 80, 60)));
				break;
			case 3:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 80, 60)));
				break;
			case 4:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i20.getImage(), 80, 60)));
				break;
			case 5:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i50.getImage(), 80, 60)));
				break;
			case 6:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i100.getImage(), 80, 60)));
				break;
			case 7:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i200.getImage(), 80, 60)));
				break;
			default:
				break;
			}
			trocoCT[i].setFont(First.myFont);
			trocoCT[i].setBounds(750 + 79 * i, 180, 80, 60);
		}
		totalC.setBounds(750, 238, 633, 60);
		totalC.setFont(First.myFont);

		// troco panel
		for (int i = 0; i < 6; i++) {
			cambio[i].setFont(First.myFont);
			if (i < 3)
				cambio[i].setBounds(1450, 90 + 60 * i, 130, 60);
		}
		cambio[3].setBounds(1578, 150, 170, 60);
		cambio[4].setBounds(1578, 210, 170, 60);
		cambio[5].setBounds(1578, 90, 170, 60);

		// cambio 1
		cambioN.setBounds(750, 370, 140, 119);
		cambioN.setFont(First.myFont);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 7; j++) {
				troco[i][j].setBounds(890 + 79 * j, 370 + 59 * i, 80, 60);
				if (i == 0) {
					switch (j) {
					case 0:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 80, 60)));
						break;
					case 1:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 80, 60)));
						break;
					case 2:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 80, 60)));
						break;
					case 3:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 80, 60)));
						break;
					case 4:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i20.getImage(), 80, 60)));
						break;
					case 5:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i50.getImage(), 80, 60)));
						break;
					case 6:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i100.getImage(), 80, 60)));
						break;
					default:
						break;
					}
				} else
					troco[i][j].setText("0");
				troco[i][j].setFont(First.myFont);
			}

		// cambio 2
		cambioN2.setBounds(750, 550, 142, 119);
		cambioN2.setFont(First.myFont);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 7; j++) {
				troco2[i][j].setBounds(890 + 79 * j, 550 + 59 * i, 80, 60);
				if (i == 0) {
					switch (j) {
					case 0:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 80, 60)));
						break;
					case 1:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 80, 60)));
						break;
					case 2:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 80, 60)));
						break;
					case 3:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 80, 60)));
						break;
					case 4:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i20.getImage(), 80, 60)));
						break;
					case 5:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i50.getImage(), 80, 60)));
						break;
					case 6:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i100.getImage(), 80, 60)));
						break;
					default:
						break;
					}
				}
				troco2[i][j].setFont(First.myFont);
			}

		// cambio 3
		cambioN3.setBounds(750, 730, 142, 119);
		cambioN3.setFont(First.myFont);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 7; j++) {
				troco3[i][j].setBounds(890 + 79 * j, 730 + 59 * i, 80, 60);
				if (i == 0) {
					switch (j) {
					case 0:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 80, 60)));
						break;
					case 1:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 80, 60)));
						break;
					case 2:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 80, 60)));
						break;
					case 3:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 80, 60)));
						break;
					case 4:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i20.getImage(), 80, 60)));
						break;
					case 5:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i50.getImage(), 80, 60)));
						break;
					case 6:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i100.getImage(), 80, 60)));
						break;
					default:
						break;
					}
				}
				troco3[i][j].setFont(First.myFont);
			}
		mainF.setBounds(1600, 650, 80, 80);
		mainF.setIcon(new ImageIcon(getScaledImage(mainIcon.getImage(), 80, 80)));
		clearB.setBounds(1600, 450, 80, 80);
		clearB.setIcon(new ImageIcon(getScaledImage(clearI.getImage(), 80, 80)));

	}

	private void idiomaTexts(int idioma, JMenuItem resoD, JMenu file, JMenuItem clear, JMenuItem calc, JMenuItem option,
			JMenu goTo, JMenuItem pesos, JMenu reso, JMenuItem reso1, JMenuItem reso2, JMenuItem reso3, JMenuItem reso4,
			JMenu help, JMenuItem creator, JMenuItem about) {
		if (idioma == 0) {
			resoD.setText("ÓPTIMO");
			file.setText("ARCHIVO");
			clear.setText("BORRAR TODO");
			calc.setText("ASUMAR");
			option.setText("CONFIGURACIÓN");
			goTo.setText("IR A");
			pesos.setText("REALES");
			reso.setText("RESOLUCIÓN");
			reso1.setText("GRANDE");
			reso2.setText("MEDIO");
			reso3.setText("PEQUENA");
			reso4.setText("X-PEQUENA");
			help.setText("AYUDA");
			creator.setText("SOBRE EL CREADOR");
			about.setText("SOBRE EL APLICATIVO");
		} else if (idioma == 1) {
			resoD.setText("ÓTIMO");
			file.setText("ARQUIVO");
			clear.setText("LIMPAR TUDO");
			calc.setText("ASSUMIR");
			option.setText("CONFIGURAÇÃO");
			goTo.setText("VAI");
			pesos.setText("REALES");
			reso.setText("RESOLUÇÃO");
			reso1.setText("GRANDE");
			reso2.setText("MEDIO");
			reso3.setText("PEQUENA");
			reso4.setText("X-PEQUENA");
			help.setText("AJUDA");
			creator.setText("SOBRE O CRIADOR");
			about.setText("SOBRE O APLICATIVO");
		} else if (idioma == 2) {
			resoD.setText("OPTIMAL");
			file.setText("FILE");
			clear.setText("CLEAN ALL");
			calc.setText("ASSUME");
			option.setText("CONFIGURATION");
			goTo.setText("GO");
			pesos.setText("REALES");
			reso.setText("RESOLUTION");
			reso1.setText("LARGE");
			reso2.setText("MEDIUM");
			reso3.setText("SMALL");
			reso4.setText("X-SMALL");
			help.setText("HELP");
			creator.setText("ABOUT THE CREATOR");
			about.setText("ABOUT THE APP");
		} else {
			resoD.setText("OPTIMAL");
			file.setText("FICHIER");
			clear.setText("NETTOIE TOUT");
			calc.setText("ASSUMER");
			option.setText("CONFIGURATION");
			goTo.setText("ALLER");
			pesos.setText("REALES");
			reso.setText("RÉSOLUTION");
			reso1.setText("GRAND");
			reso2.setText("MOYEN");
			reso3.setText("PETIT");
			reso4.setText("X-PETIT");
			help.setText("AIDER");
			creator.setText("À PROPOS DU CRÉATEUR");
			about.setText("À PROPOS DE L'APPLICATION");
		}
	}

	private String[] idiomaString(int idioma) {
		String[] espanol = { "• CTRL + S → ir la reales.\n" + "• CTRL + O → esconder los botones.\n"
				+ "• SHIFT → cambiar entre las dos tablas.\n" + "• FLECHAS → subir, abajo, derecha e izquierda.\n"
				+ "• CTRL + C → abrir el configuración."// key shortcut 0
				, "ATAJOS DE TECLADO" // key shortcut 1
				, "Crédito y Diseñado por MhmdSAbdlh ©"// creator 2
				,
				"ESTA APLICACIÓN ESTÁ DISEÑADA PARA NARJES FREE SHOP.\r\n"
						+ "TIENE MARCO PARA CERRAR LA CAJA TANTO EN REALES COMO PESOS.\r\n"
						+ "TIENE UN MARCO PARA CALCULAR EL TROCO DE UNA VENTA TANTO EN REALES COMO PESOS.\r\n"
						+ "SABE CÓMO QUEDARÁ PARA EL PRÓXIMO DÍA.\r\n" + "3 MÉTODOS PARA DAR EL CAMBIO.\r\n"
						+ "CAMBIARÁ TODO SEGÚN EL ICONO SELECCIONADO.\r\n" + "\r\n" + "MOHAMAD ABDALLAH ABBASS ©"// about4
				, "CONFIGURACIÓN"// conf title 4
				, "ICONO"// icon 5
				, "IDIOMA"// LANGUAGE 6
				, "AUTOGUARDAR"// AUTO SAVE 7
				, "POR DEFECTO"// DEFAULT 8
				, "GUARDAR"// SAVE 9
				, "SI"// YES 10
				, "NO"// NO 11
				, "¿Seguro que quieres salir?"// exit 12
				, "SALIR"// exit 13
				, "BORRAR TODO" // clear 14
				, "CANT"// CANTIDAD 15
				, "DETALLE"// deta 16
				, "P/U"// p/u 17
				, "IMPORTE"// mer 18
				, "CAJA"// cash 19
				, "CLIENTE"// cl 20
				, "TROCÓ"// change 21
				, "<html><center>" + "MÉTODO" + "<br>" + "SMART" + "</center></html>"// exit 22
				, "<html><center>" + "MÉTODO" + "<br>" + "POPULAR" + "</center></html>"// exit 23
				, "<html><center>" + "MÉTODO" + "<br>" + "BÁSICO" + "</center></html>"// exit 24
				, "FACTURA - R$"// 25
				, "ESCONDER LOS BOTONES"// 26
				, "MOSTRAR LOS BOTONES"// 27
				, "ARCHIVO"// 28
				, "IMPRÍMELO"// 29
				, "TEMA"// THEME16
		};
		String[] portugues = { "• CTRL + S → ir para o real.\n" + "• CTRL + O → ocultar os botões.\n"
				+ "• SHIFT → alternar entre as duas tabelas.\n" + "• SETAS → cima, baixo, direita e esquerda.\n",
				"ATALHOS DE TECLAS" // tecla de atalho 2
				, "Crédito e Desenhado por MhmdSAbdlh ©"// creator 3
				,
				"ESTE APLICATIVO FOI DESENVOLVIDO PARA O FREE SHOP DE NARJES.\r\n"
						+ "TEM MOLDURA PARA FECHAR A CAIXA TANTO EM REAIS QUANTO EM PESOS.\r\n"
						+ "TEM UM QUADRO PARA CALCULAR O TROCO DE UMA VENDA TANTO EM REAIS QUANTO EM PESOS.\r\n"
						+ "SAIBA COMO SERÁ PARA O DIA SEGUINTE.\r\n" + "3 MÉTODOS PARA FAZER A MUDANÇA.\r\n"
						+ "MUDARÁ TUDO DE ACORDO COM O ÍCONE SELECIONADO.\r\n" + "\r\n" + "MOHAMAD ABDALLAH ABBASS ©" // 4
				, "CONFIGURAÇÃO"// conf title 5
				, "ÍCONE"// icon 6
				, "LINGUAGEM"// LANGUAGE 7
				, "AUTO-SALVAR"// AUTO SAVE 8
				, "POR PADRÃO"// DEFAULT 9
				, "SALVAR"// SAVE 10
				, "SIM"// YES 11
				, "NÃO"// NO 12
				, "Tem certeza que quer sair?"// exit 13
				, "SAIR"// exit 14
				, "LIMPAR TUDO" // clear 14
				, "CANT"// CANTIDAD 16
				, "DETALHE"// DETAILS 17
				, "P/U"// P/U 18
				, "VALOR"// VALUE 19
				, "CAIXA"// CASH 20
				, "CLIENTE"// CL 21
				, "TROCÓ"// CHANGE 22
				, "<html><center>" + "MÉTODO" + "<br>" + "SMART" + "</center></html>"// S M 23
				, "<html><center>" + "MÉTODO" + "<br>" + "POPULAR" + "</center></html>"// P M 24
				, "<html><center>" + "MÉTODO" + "<br>" + "BÁSICO" + "</center></html>"// B M 25
				, "FATURA - R$"// 25
				, "ESCONDE OS BOTÕES"// 26
				, "MOSTRAR OS BOTÕES"// 27
				, "ARCHIVO"// 28
				, "IMPRIMA"// 28
				, "TEMA"// THEME16
		};
		String[] english = {
				"• CTRL + S → go to real.\n" + "• CTRL + O → hide buttons.\n"
						+ "• SHIFT → switch between the two tables.\n" + "• ARROWS → up, down, right and left.\n",
				"KEY SHORTCUTS" // tecla de atalho 2
				, "Credit and Designed by MhmdSAbdlh ©"// creator 3
				,
				"THIS APP IS DESIGNED FOR NARJES FREE SHOP.\r\n"
						+ "HAS A FRAME TO CLOSE THE BOX IN REALS AND PESOS.\r\n"
						+ "THERE IS A FRAME TO CALCULATE THE CHANGE FOR A SALE, BOTH IN BRL AND IN PESOS.\r\n"
						+ "KNOW HOW MUCH IT WILL BE FOR THE NEXT DAY.\r\n" + "3 METHODS OF GIVING CHANGE.\r\n"
						+ "WILL CHANGE EVERYTHING ACCORDING TO THE SELECTED ICON.\r\n" + "\r\n"
						+ "MOHAMAD ABDALLAH ABBASS ©"// about
				, "SETTINGS"// conf title 5
				, "ICON"// icon 6
				, "LANGUAGE"// LANGUAGE 7
				, "AUTO-SAVE"// AUTO SAVE 8
				, "DEFAULT"// DEFAULT 9
				, "SAVE"// SAVE 10
				, "YES"// YES 11
				, "NO"// NO 12
				, "Are you sure you want to leave?"// exit 13
				, "EXIT"// exit 14
				, "CLEAN ALL" // clear 14
				, "QNT"// CANTIDAD 16
				, "DETAIL"// DETAILS 17
				, "P/U"// P/U 18
				, "VALUE"// VALUE 19
				, "CASH"// CASH 20
				, "CLIENT"// CL 21
				, "CHANGE"// CHANGE 22
				, "<html><center>" + "METHOD" + "<br>" + "SMART" + "</center></html>"// S M 23
				, "<html><center>" + "METHOD" + "<br>" + "POPULAR" + "</center></html>"// P M 24
				, "<html><center>" + "METHOD" + "<br>" + "BASIC" + "</center></html>"// B M 25
				, "INVOICE - R$"// 25
				, "HIDE THE BUTTONS"// 26
				, "SHOW THE BUTTONS"// 27
				, "FILE"// 28
				, "PRINT IT"// 28
				, "THEME"// THEME16
		};
		String[] french = {
				"• CTRL + S → aller au réel.\n" + "• CTRL + O → masquer les boutons.\n"
						+ "• MAJ → basculer entre les deux tableaux.\n" + "• FLECHES → haut, bas, droite et gauche.\n",
				"KEY RACCOURCIS" // tecla de atalho 2
				, "Crédit et conçu par MhmdSAbdlh ©" // créateur 3
				,
				"CETTE APPLICATION EST CONÇUE POUR LA BOUTIQUE GRATUITE NARJES.\r\n"
						+ "A UN CADRE POUR FERMER LA BOÎTE EN REALS ET PESOS.\r\n"
						+ "IL EXISTE UN CADRE POUR CALCULER LE CHANGEMENT POUR UNE VENTE, À LA FOIS EN BRL ET EN PESOS.\r\n"
						+ "SAVOIR COMBIEN CELA SERA LE LENDEMAIN.\r\n" + "3 MÉTHODES POUR RENDRE LA CHANGE.\r\n"
						+ "VA TOUT CHANGER SELON L'ICÔNE SÉLECTIONNÉ.\r\n" + "\r\n" + "MOHAMAD ABDALLAH ABBASS ©"// à
																													// propos
				, "PARAMÈTRES" // conf titre 5
				, "ICÔNE"// icône 6
				, "LANGUE"// LANGUE 7
				, "AUTO-SAUVER"// ENREGISTREMENT AUTO 8
				, "DEFAUT"// DEFAUT 9
				, "SAUVER"// ENREGISTRER 10
				, "OUI"// OUI 11
				, "NON"// NON 12
				, "Êtes-vous sûr de vouloir partir ?"// sortie 13
				, "SORTIE"// sortie 14
				, "TOUT NETTOYER" // effacer 14
				, "QNT"// CANTIDAD 16
				, "DÉTAIL"// DÉTAILS 17
				, "P/U"// P/U 18
				, "VALEUR"// VALEUR 19
				, "CASH"// CASH 20
				, "CLIENT"// CL 21
				, "CHANGER"// CHANGER 22
				, "<html><center>" + "METHODE" + "<br>" + "SMART" + "</center></html>"// S M 23
				, "<html><center>" + "MÉTHODE" + "<br>" + "POP" + "</center></html>"// P M 24
				, "<html><center>" + "METHODE" + "<br>" + "BASIQUE" + "</center></html>"// B M 25
				, "FACTURE - R$"// 25
				, "MASQUER LES BOUTONS"// 26
				, "AFFICHER LES BOUTONS"// 27
				, "FICHIER"// 28
				, "IMPRIMER"// 28
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

	private Image getScaledImage(Image srcImg, int w, int h) {
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(srcImg, 0, 0, w, h, null);
		g2.dispose();

		return resizedImg;
	}

	// Auto
	private ArrayList<String> listMercadoria() {
		ArrayList<String> keywords = new ArrayList<>(61);
		keywords.add("frazada");
		keywords.add("cobertor");
		keywords.add("jarra");
		keywords.add("alfombra");
		keywords.add("tapete");
		keywords.add("trilho");
		keywords.add("jogo trilho");
		keywords.add("juego lfombra");
		keywords.add("tapete do banho");
		keywords.add("alfombra de bano");
		keywords.add("linterna");
		keywords.add("lanterna");
		keywords.add("martillo");
		keywords.add("conj nino");
		keywords.add("kit cocina");
		keywords.add("f5");
		keywords.add("f6");
		keywords.add("toallas");
		keywords.add("frutera");
		keywords.add("saco LA");
		keywords.add("labatida");
		keywords.add("campera");
		keywords.add("milano");
		keywords.add("chaqueta");
		keywords.add("soft fem");
		keywords.add("soft mas");
		keywords.add("chapinha");
		keywords.add("azucarera");
		keywords.add("bombonera");
		keywords.add("caixa do som");
		keywords.add("caja de son");
		keywords.add("mk167");
		keywords.add("mk168");
		keywords.add("mk169");
		keywords.add("mk410");
		keywords.add("mk412");
		keywords.add("mk416");
		keywords.add("mk4105");
		keywords.add("mk4101");
		keywords.add("cobredom");
		keywords.add("dz media");
		keywords.add("vaso termico");
		keywords.add("sarten");
		keywords.add("kit vaso");
		keywords.add("balanza");
		keywords.add("balanza 40kg");
		keywords.add("telefono");
		keywords.add("reloj");
		keywords.add("auto control");
		keywords.add("caneta");
		keywords.add("lapicera");
		keywords.add("xbox");
		keywords.add("mando xbox");
		keywords.add("auriculares");
		keywords.add("fone");
		keywords.add("a7");
		return keywords;
	}

}
