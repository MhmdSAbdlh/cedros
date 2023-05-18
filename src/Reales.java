/*
 CTRL + / Folding enabled or disable using toggle switch
Ctrl + * : expands code block After folding is enabled, The below command works
Collapse All -> Ctrl + Shift + / (Numpad Divide)
Expand All -> Ctrl + Shift + * (Numpad Multiply)

Ctrl + Shift + F : clean code
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.plaf.metal.MetalToggleButtonUI;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

@SuppressWarnings("serial")
public class Reales extends JFrame {

	// Foto
	private URL u1000 = getClass().getResource("images/1000.png");
	private ImageIcon i1000 = new ImageIcon(u1000);
	private URL uS100 = getClass().getResource("images/s100.png");
	private ImageIcon iS100 = new ImageIcon(uS100);
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
	private URL uclear = getClass().getResource("images/clear.png");
	private ImageIcon clear = new ImageIcon(uclear);
	private URL pesos = getClass().getResource("images/pesos.png");
	private ImageIcon pesosI = new ImageIcon(pesos);
	private URL notas = getClass().getResource("images/notas.png");
	private ImageIcon notasI = new ImageIcon(notas);
	private URL symPhoto = getClass().getResource("images/sum.png");
	private ImageIcon sumI = new ImageIcon(symPhoto);
	private URL expP = getClass().getResource("images/save.png");
	private ImageIcon expI = new ImageIcon(expP);
	private URL pixP = getClass().getResource("images/pix.png");
	private ImageIcon pixI = new ImageIcon(pixP);
	// menubar
	private URL aboutP = getClass().getResource("images/menubar/about.png");
	private ImageIcon aboutI = new ImageIcon(aboutP);
	private URL calcP = getClass().getResource("images/menubar/calc.png");
	private ImageIcon calcI = new ImageIcon(calcP);
	private URL clearP = getClass().getResource("images/menubar/clear.png");
	private ImageIcon clearI = new ImageIcon(clearP);
	private URL creatorP = getClass().getResource("images/menubar/creator.png");
	private ImageIcon creatorI = new ImageIcon(creatorP);
	private URL exitP = getClass().getResource("images/menubar/exit.png");
	private ImageIcon exitI = new ImageIcon(exitP);
	private URL firstP = getClass().getResource("images/menubar/first.png");
	private ImageIcon firstI = new ImageIcon(firstP);
	private URL hideP = getClass().getResource("images/menubar/hide.png");
	private ImageIcon hideI = new ImageIcon(hideP);
	private URL invoiceP = getClass().getResource("images/menubar/invoice.png");
	private ImageIcon invoiceI = new ImageIcon(invoiceP);
	private URL keyboardP = getClass().getResource("images/menubar/keyboard.png");
	private ImageIcon keyboardI = new ImageIcon(keyboardP);
	private URL largeP = getClass().getResource("images/menubar/large.png");
	private ImageIcon largeI = new ImageIcon(largeP);
	private URL medP = getClass().getResource("images/menubar/med.png");
	private ImageIcon medI = new ImageIcon(medP);
	private URL moneyP = getClass().getResource("images/menubar/money.png");
	private ImageIcon moneyI = new ImageIcon(moneyP);
	private URL newdayP = getClass().getResource("images/menubar/newday.png");
	private ImageIcon newdayI = new ImageIcon(newdayP);
	private URL saveP = getClass().getResource("images/menubar/save.png");
	private ImageIcon saveI = new ImageIcon(saveP);
	private URL screenshotP = getClass().getResource("images/menubar/screenshot.png");
	private ImageIcon screenshotI = new ImageIcon(screenshotP);
	private URL settingP = getClass().getResource("images/menubar/setting.png");
	private ImageIcon settingI = new ImageIcon(settingP);
	private URL smallP = getClass().getResource("images/menubar/small.png");
	private ImageIcon smallI = new ImageIcon(smallP);
	private URL speedP = getClass().getResource("images/menubar/speed.png");
	private ImageIcon speedI = new ImageIcon(speedP);
	private URL summaryP = getClass().getResource("images/menubar/summary.png");
	private ImageIcon summaryI = new ImageIcon(summaryP);
	private URL summP = getClass().getResource("images/menubar/sum.png");
	private ImageIcon summI = new ImageIcon(summP);
	private URL themeP = getClass().getResource("images/menubar/theme.png");
	private ImageIcon themeI = new ImageIcon(themeP);
	private URL xsmallP = getClass().getResource("images/menubar/xsmall.png");
	private ImageIcon xsmallI = new ImageIcon(xsmallP);
	private URL optimalP = getClass().getResource("images/menubar/optimal.png");
	private ImageIcon optimalI = new ImageIcon(optimalP);
	private URL slowP = getClass().getResource("images/menubar/slow.png");
	private ImageIcon slowI = new ImageIcon(slowP);
	private URL normalP = getClass().getResource("images/menubar/normal.png");
	private ImageIcon normalI = new ImageIcon(normalP);
	private URL fastP = getClass().getResource("images/menubar/fast.png");
	private ImageIcon fastI = new ImageIcon(fastP);
	private URL effect1P = getClass().getResource("images/menubar/effect1.png");
	private ImageIcon effect1I = new ImageIcon(effect1P);
	private URL effect2P = getClass().getResource("images/menubar/effect2.png");
	private ImageIcon effect2I = new ImageIcon(effect2P);
	private URL effect3P = getClass().getResource("images/menubar/effect3.png");
	private ImageIcon effect3I = new ImageIcon(effect3P);
	private URL engP = getClass().getResource("images/menubar/eng.png");
	private ImageIcon engI = new ImageIcon(engP);
	private URL espP = getClass().getResource("images/menubar/esp.png");
	private ImageIcon espI = new ImageIcon(espP);
	private URL defaultP = getClass().getResource("images/menubar/default.png");
	private ImageIcon defaultI = new ImageIcon(defaultP);
	private URL porP = getClass().getResource("images/menubar/por.png");
	private ImageIcon porI = new ImageIcon(porP);
	private URL showP = getClass().getResource("images/menubar/show.png");
	private ImageIcon showI = new ImageIcon(showP);
	private URL buttonP = getClass().getResource("images/menubar/button.png");
	private ImageIcon buttonI = new ImageIcon(buttonP);
	private URL dateP = getClass().getResource("images/menubar/date.png");
	private ImageIcon dateI = new ImageIcon(dateP);
	private URL allP = getClass().getResource("images/menubar/all.png");
	private ImageIcon allI = new ImageIcon(allP);
	private URL memP = getClass().getResource("images/menubar/mem.png");
	private ImageIcon memI = new ImageIcon(memP);
	private URL sepP = getClass().getResource("images/menubar/sep.png");
	private ImageIcon sepI = new ImageIcon(sepP);
	private URL avgP = getClass().getResource("images/menubar/avg.png");
	private ImageIcon avgI = new ImageIcon(avgP);
	// months
	private URL monthP[] = new URL[12];
	private ImageIcon monthI[] = new ImageIcon[12];
	private URL monthPI = getClass().getResource("images/menubar/month/month.png");
	private ImageIcon monthIM = new ImageIcon(monthPI);
	static File screenSound = new File("src/sound/screenshot.wav");

	// Define Parameter
	static JTextField initialDay = new JTextField("0");// How much begin the day
	static JTextField agregadoTable[] = new JTextField[16];// Added to cash detailed
	static JTextField gastosTable[] = new JTextField[16];// Spend of the day detailed
	static JTextField panelCnum[] = new JTextField[11];
	static JTextField details[][] = new JTextField[6][20];// Numbers of notes
	static JTextField gTable[] = new JTextField[16];
	static JTextField aTable[] = new JTextField[16];
	static JButton aggBtn[] = new JButton[2];// Combine the set of 1000 and 100
	static JLabel total[] = new JLabel[9];// Total of every column
	static JLabel boletoN[] = new JLabel[6]; // B1,2,3,4,5
	static JLabel summaryT[] = new JLabel[9];// Summary table
	static JLabel gastos = new JLabel("G A S T O S");// Spend of the day TITLE
	static JLabel agregado = new JLabel("A G R E G A D O");// Added to cash title
	static JLabel panelFoto[] = new JLabel[11];// Photo row
	static JLabel[] diffResult = new JLabel[2];// calculate the difference
	static JLabel restTmrw = new JLabel();// rest for tomorrow
	JLabel plusSymbol = new JLabel("+");
	// Define values
	static int totalCol = 0, totalVenta = 0, totalO = 0;
	static int gastosT = 0, agregadoT = 0, pix = 0;
	static int restN, totalCaja = 0, nbOf20 = 0;
	int width, height, language;
	static int colorX = 0, order = 0, speedValue, wordsN, wordL, effChooser, colorBW = 254;
	boolean status = false;
	Timer timer;
	String conf[] = new String[10];
	JLabel date = new JLabel();// date of the day
	Date currentDate;
	String monthS, dayN, dayS, yearS;

	String currentpath = System.getProperty("user.dir");
	File tempFile0 = new File(currentpath + "\\data");
	File newFile = new File(tempFile0, "conf.dll");

	Reales() {
		for (int i = 0; i < 12; i++) {
			monthP[i] = getClass().getResource("images/menubar/month/" + (i + 1) + ".png");
			monthI[i] = new ImageIcon(monthP[i]);
		}
		// Open Conf
		tempFile0.mkdir();
		BufferedReader dataOpened = null;
		String line = "";
		int z = 0;
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
		} // icon
		if (conf[0] == null || !conf[0].equals("3"))
			this.setIconImage(new ImageIcon(getClass().getResource("images/icon/cedrosI.png")).getImage());
		else
			this.setIconImage(new ImageIcon(getClass().getResource("images/icon/narjesI.png")).getImage());
		// LANGUAGE
		if (conf[7] == null || conf[7].equals("0"))
			language = 0;
		else if (conf[7].equals("1"))
			language = 1;
		else
			language = 2;
		dateLang(language);

		// Buttons
		JMenuItem hideBtn = new JMenuItem();
		JMenuItem noHide = new JMenuItem();
		JMenuItem hideDate = new JMenuItem();
		JMenuItem hideAll = new JMenuItem();
		JButton clearEverthing = new JButton();
		JButton pesosF = new JButton();
		JButton notasF = new JButton();// FATURA BUTTON
		JButton newDay = new JButton();// REST
		JMenuItem resoD = new JMenuItem();
		JButton aggPanel = new JButton();
		JButton gastosPanel = new JButton();

		// Frame
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int) screenSize.getWidth();
		height = (int) screenSize.getHeight();
		this.setTitle(idiomaString(language)[27]);
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
		this.setLayout(null);
		this.setResizable(false);
		this.getContentPane().setBackground(First.darkC);

		// BUTTONS
		if (conf[1] == null || conf[1].equals("0")) {// show all
			noHide.setEnabled(false);
			hideDate.setEnabled(true);
			hideBtn.setEnabled(true);
			hideAll.setEnabled(true);
			pesosF.show();
			clearEverthing.show();
			notasF.show();
			date.show();
		} else if (conf[1].equals("1")) {// hide date
			noHide.setEnabled(true);
			hideDate.setEnabled(false);
			hideBtn.setEnabled(true);
			hideAll.setEnabled(true);
			pesosF.show();
			clearEverthing.show();
			notasF.show();
			date.hide();
		} else if (conf[1].equals("2")) {// hide btn
			noHide.setEnabled(true);
			hideDate.setEnabled(true);
			hideBtn.setEnabled(false);
			hideAll.setEnabled(true);
			hideBtn(notasF, pesosF, newDay, clearEverthing, hideBtn);
			date.show();
		} else {// hide all
			noHide.setEnabled(true);
			hideDate.setEnabled(true);
			hideBtn.setEnabled(true);
			hideAll.setEnabled(false);
			hideBtn(notasF, pesosF, newDay, clearEverthing, hideBtn);
			date.hide();
		}

		// Panel 1
		int temp;
		for (int i = 0; i < 6; i++) {
			temp = 0;
			boletoN[i] = new JLabel("B" + (i + 1));
			boletoN[i].setForeground(First.darkC);
			boletoN[i].setBorder(new LineBorder(First.grisD, 2));
			boletoN[i].setHorizontalAlignment(0);
			boletoN[i].setOpaque(true);
			this.add(boletoN[i]);
			for (int j = 0; j < 20; j++) {
				details[i][j] = new JTextField("");
				textFieldStyle(details[i][j]);
				if (details[i][j].getText().equals("")) {
					temp += 0;
				}
				if (conf[2] == null || conf[2].equals("false"))
					tableFocus(i, j, this, newDay, notasF, pesosF, clearEverthing, hideBtn, resoD, gastosPanel,
							aggPanel);
				this.add(details[i][j]);
			}
			total[i] = new JLabel("");
			First.labelStyle(total[i]);
			total[i].setBorder(new LineBorder(First.grisD, 2));
			total[i].setText(temp + "");
			this.add(total[i]);
		}
		total[6] = new JLabel("0");
		First.labelStyle(total[6]);
		total[6].setBackground(Color.black);
		total[6].setForeground(Color.white);
		this.add(total[6]);
		total[8] = new JLabel("Total");
		First.labelStyle(total[8]);
		total[8].setBackground(Color.white);
		total[8].setForeground(Color.black);
		this.add(total[8]);

		// Panel 2
		date.setText(" " + dayS + ", " + dayN + "-" + monthS + "-" + yearS);
		date.setForeground(First.lightC);
		date.setFont(First.myFont);
		this.add(date);

		for (int i = 0; i < 5; i++) {
			summaryT[i] = new JLabel();
			First.labelStyle(summaryT[i]);
			switch (i) {
			case 0:
				summaryT[i].setText("Inicio");
				break;
			case 1:
				summaryT[i].setText("Gastos");
				break;
			case 2:
				summaryT[i].setText("Agregado");
				break;
			case 3:
				summaryT[i].setText("Ventas");
				break;
			case 4:
				summaryT[i].setText("Total");
				break;
			default:
				break;
			}
			this.add(summaryT[i]);
		}
		summaryT[0].setBackground(First.grisD);
		summaryT[0].setForeground(Color.black);
		summaryT[1].setBackground(First.redD);
		summaryT[1].setForeground(Color.white);
		summaryT[2].setBackground(First.greenD);
		summaryT[2].setForeground(Color.white);
		summaryT[3].setBackground(First.blueD);
		summaryT[3].setForeground(Color.white);
		summaryT[4].setBackground(Color.black);
		summaryT[4].setForeground(Color.white);
		textFieldStyle(initialDay);
		initialDay.setCaretColor(First.darkC);
		initialDay.setBackground(First.lightC);
		initialDay.setForeground(Color.black);
		if (conf[2] == null || conf[2].equals("false"))
			iniFocus(newDay, notasF, pesosF, clearEverthing, hideBtn, resoD, gastosPanel, aggPanel);
		this.add(initialDay);
		for (int i = 5; i < 9; i++) {
			summaryT[i] = new JLabel("0");
			summaryT[i].setForeground(First.lightC);
			summaryT[i].setBorder(First.border);
			summaryT[i].setFocusable(false);
			summaryT[i].setOpaque(true);
			summaryT[i].setHorizontalAlignment(0);
			this.add(summaryT[i]);
		}
		summaryT[5].setBackground(First.redC);
		summaryT[6].setBackground(First.greenC);
		summaryT[7].setBackground(First.blueC);
		summaryT[8].setBackground(new Color(80, 80, 80));

		// Panel 3 : gastos and agg
		First.labelStyle(gastos);
		Color redT = new Color(107, 35, 35);
		gastos.setBackground(redT);
		gastos.setForeground(Color.white);
		this.add(gastos);
		ArrayList<String> keywords = gastosYagregados();
		for (int i = 0; i < 8; i++) {
			gastosTable[i] = new JTextField();
			gTable[i] = new JTextField();
			// Autocomplete
			AutoComplete autoComplete = new AutoComplete(gastosTable[i], keywords);
			gastosTable[i].getDocument().addDocumentListener(autoComplete);
			autoComplete = new AutoComplete(gTable[i], keywords);
			gTable[i].getDocument().addDocumentListener(autoComplete);
			if (i < 4) {
				textFieldStyle(gastosTable[i]);
				gastosTable[i].setBackground(First.redD);
				gastosTable[i].setForeground(Color.white);
				if (conf[2] == null || conf[2].equals("false"))
					gasFocus(i, this, newDay, notasF, pesosF, clearEverthing, hideBtn, resoD, gastosPanel, aggPanel);
				this.add(gastosTable[i]);
			}
		}
		for (int i = 8; i < 16; i++) {
			gastosTable[i] = new JTextField();
			gTable[i] = new JTextField();
			if (i < 12) {
				textFieldStyle(gastosTable[i]);
				gastosTable[i].setBackground(First.redC);
				gastosTable[i].setForeground(Color.white);
				if (conf[2] == null || conf[2].equals("false"))
					gasFocus(i, this, newDay, notasF, pesosF, clearEverthing, hideBtn, resoD, gastosPanel, aggPanel);
				this.add(gastosTable[i]);
			}
		}
		First.btnStyle(gastosPanel);
		gastosPanel.setBackground(redT);
		gastosPanel.setForeground(First.lightC);
		gastosPanel.addActionListener(
				e -> gastosFrame(keywords, notasF, pesosF, newDay, clearEverthing, resoD, gastosPanel));
		gastosPanel.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				gastosPanel.setBackground(redT);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				gastosPanel.setBackground(First.redC);
			}

		});
		this.add(gastosPanel);
		// Agg
		First.labelStyle(agregado);
		Color greenT = new Color(30, 84, 25);
		agregado.setBackground(greenT);
		agregado.setForeground(Color.white);
		this.add(agregado);
		for (int i = 0; i < 8; i++) {
			aTable[i] = new JTextField();
			agregadoTable[i] = new JTextField();
			// Autocomplete
			AutoComplete autoComplete = new AutoComplete(agregadoTable[i], keywords);
			agregadoTable[i].getDocument().addDocumentListener(autoComplete);
			autoComplete = new AutoComplete(aTable[i], keywords);
			aTable[i].getDocument().addDocumentListener(autoComplete);
			if (i < 4) {
				textFieldStyle(agregadoTable[i]);
				agregadoTable[i].setBackground(First.greenD);
				agregadoTable[i].setForeground(Color.white);
				if (conf[2] == null || conf[2].equals("false"))
					aggFocus(i, this, newDay, notasF, pesosF, clearEverthing, hideBtn, resoD, gastosPanel, aggPanel);
				this.add(agregadoTable[i]);
			}
		}
		for (int i = 8; i < 16; i++) {
			aTable[i] = new JTextField();
			agregadoTable[i] = new JTextField();
			if (i < 12) {
				textFieldStyle(agregadoTable[i]);
				agregadoTable[i].setBackground(First.greenC);
				agregadoTable[i].setForeground(Color.white);
				if (conf[2] == null || conf[2].equals("false"))
					aggFocus(i, this, newDay, notasF, pesosF, clearEverthing, hideBtn, resoD, gastosPanel, aggPanel);
				this.add(agregadoTable[i]);
			}
		}
		First.btnStyle(aggPanel);
		aggPanel.setBackground(greenT);
		aggPanel.setForeground(First.lightC);
		aggPanel.addActionListener(e -> aggFrame(keywords, notasF, pesosF, newDay, clearEverthing, resoD, gastosPanel));
		aggPanel.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				aggPanel.setBackground(greenT);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				aggPanel.setBackground(First.greenC);
			}

		});
		this.add(aggPanel);

		// Panel 4 Caja detailed
		for (int i = 0; i < 11; i++) {
			panelFoto[i] = new JLabel();
			First.labelStyle(panelFoto[i]);
			this.add(panelFoto[i]);
		}
		for (int i = 0; i < 11; i++) {
			panelCnum[i] = new JTextField("0");
			textFieldStyle(panelCnum[i]);
			panelCnum[i].setCaretColor(First.darkC);
			panelCnum[i].setForeground(First.darkC);
			panelCnum[i].setBackground(First.lightC);
			if (conf[2] == null || conf[2].equals("false"))
				cajaFocus(i, this, newDay, notasF, pesosF, clearEverthing, hideBtn, resoD, gastosPanel, aggPanel);
			this.add(panelCnum[i]);
		}
		plusSymbol.setForeground(First.lightC);
		panelFoto[10].setBackground(Color.white);
		panelCnum[10].setBackground(Color.black);
		panelCnum[10].setForeground(First.lightC);
		panelCnum[10].setCaretColor(First.lightC);
		this.add(plusSymbol);
		total[7] = new JLabel("TOTAL");// Total Label
		First.labelStyle(total[7]);
		total[7].setBackground(Color.black);
		total[7].setForeground(Color.white);
		this.add(total[7]);
		aggBtn[0] = new JButton();// ADD SET 1000
		First.btnStyle(aggBtn[0]);
		aggBtn[0].setBackground(new Color(0x6fa39f));
		aggBtn[0].setForeground(Color.white);
		aggBtn[0].hide();
		aggBtn[0].addActionListener(e -> addSetMil());
		this.add(aggBtn[0]);
		aggBtn[1] = new JButton();// ADD SET 100
		First.btnStyle(aggBtn[1]);
		aggBtn[1].setBackground(new Color(0xd7841c));
		aggBtn[1].setForeground(Color.white);
		aggBtn[1].hide();
		aggBtn[1].addActionListener(e -> addSetHun());
		this.add(aggBtn[1]);

		// Panel 5
		diffResult[0] = new JLabel("Diferencia");// DIFFERENCE
		First.labelStyle(diffResult[0]);
		diffResult[0].setBackground(Color.black);
		diffResult[0].setForeground(First.lightC);
		this.add(diffResult[0]);
		diffResult[1] = new JLabel("No Hay Diferencia");
		First.labelStyle(diffResult[1]);
		this.add(diffResult[1]);
		First.btnStyle(newDay);
		newDay.setBackground(First.blueC);
		newDay.setForeground(First.lightC);
		newDay.addActionListener(e -> newDay());
		newDay.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				newDay.setBackground(First.blueC);
				newDay.setForeground(First.lightC);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				newDay.setBackground(First.blueD);
				newDay.setForeground(First.lightC);
			}
		});
		restTmrw.setText("R$0");
		First.labelStyle(restTmrw);
		this.add(restTmrw);
		notasF.setFocusable(true);
		notasF.setOpaque(false);
		notasF.setContentAreaFilled(false);
		notasF.setBorderPainted(false);
		notasF.addActionListener(e -> {
			saveProgress();
			FaturaR.totalC.setText("0");
			FaturaR.total.setText("0");
			this.dispose();
			new FaturaR();
		});
		this.add(notasF);
		pesosF.setFocusable(true);
		pesosF.setOpaque(false);
		pesosF.setContentAreaFilled(false);
		pesosF.setBorderPainted(false);
		pesosF.addActionListener(e -> {
			saveProgress();
			new Pesos();
			this.dispose();
		});
		this.add(pesosF);
		clearEverthing.setOpaque(false);
		clearEverthing.setContentAreaFilled(false);
		clearEverthing.setBorderPainted(false);
		clearEverthing.addActionListener(e -> clearAll());
		this.add(newDay);
		this.add(clearEverthing);
		JButton magic = new JButton();
		magic.addActionListener(e -> sumF());

		// MenuBar
		JMenuBar mb = new JMenuBar();
		// FILE
		JMenu file = new JMenu("ARCHIVO");
		JMenuItem novo = new JMenuItem("NOVO DIA");
		JMenuItem clear = new JMenuItem("BORRAR TODO");
		JMenuItem calc = new JMenuItem("ASUMAR");
		JMenuItem save = new JMenuItem("SALVAR");
		JMenuItem screenShot = new JMenuItem("CAPTURA DE PANTALLA");
		JMenuItem option = new JMenuItem("CONFIGURACIÓN");
		JMenuItem exit = new JMenuItem("SALIR");
		novo.addActionListener(e -> newDay());
		calc.addActionListener(e -> sumF());
		clear.addActionListener(e -> clearAll());
		save.addActionListener(e -> saveProgress());
		screenShot.addActionListener(e -> {
			colorBW = 254;
			ActionListener letterByLetter = new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					Reales.this.getContentPane().setBackground(new Color(colorBW, colorBW, colorBW));
					if (colorBW > 40)// Details fade in
						colorBW -= 3;
					else {
						colorBW = 40;
						Reales.this.getContentPane().setBackground(new Color(colorBW, colorBW, colorBW));
						timer.stop();
					}
				}
			};

			timer = new Timer(1, letterByLetter);
			timer.start();
			screenShooter();
			JOptionPane opt = new JOptionPane(idiomaString(language)[25], JOptionPane.NO_OPTION);
			final JDialog dlg = opt.createDialog("SALVO");
			new Thread(new Runnable() {
				public void run() {
					try {
						Thread.sleep(1000);
						dlg.dispose();
					} catch (Throwable th) {
						JOptionPane opt = new JOptionPane(
								language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
								JOptionPane.ERROR_MESSAGE);
						opt.show();
					}
				}
			}).start();
			dlg.setVisible(true);
			try {// sounds
				AudioInputStream audioStream = AudioSystem.getAudioInputStream(Reales.screenSound);
				Clip clip = AudioSystem.getClip();
				clip.open(audioStream);
				clip.start();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
				JOptionPane opt2 = new JOptionPane(
						language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
						JOptionPane.ERROR_MESSAGE);
				opt2.show();
			}
		});
		option.addActionListener(
				e -> confFrame(conf, notasF, pesosF, newDay, clearEverthing, hideBtn, resoD, gastosPanel, aggPanel));
		exit.addActionListener(e -> System.exit(0));
		file.add(novo);
		file.add(calc);
		file.add(clear);
		file.add(save);
		file.add(screenShot);
		file.add(option);
		file.add(exit);
		// GO TO
		JMenu goTo = new JMenu("IR A");
		JMenuItem pesos = new JMenuItem("PESOS");
		JMenuItem fatura = new JMenuItem("FATURA");
		JMenuItem firstFrame = new JMenuItem("PRIMER CUADRO");
		pesos.addActionListener(e -> {
			saveProgress();
			new Pesos();
			this.dispose();
		});
		fatura.addActionListener(e -> {
			saveProgress();
			FaturaR.totalC.setText("0");
			FaturaR.total.setText("0");
			this.dispose();
			new FaturaR();
		});
		firstFrame.addActionListener(e -> {
			this.dispose();
			new First();
		});
		goTo.add(firstFrame);
		goTo.add(pesos);
		goTo.add(fatura);
		// RESOLTION
		JMenu reso = new JMenu("RESOLUCIÓN");
		JSeparator sep = new JSeparator();
		JMenuItem reso1 = new JMenuItem("GRANDE");
		JMenuItem reso2 = new JMenuItem("MEDIO");
		JMenuItem reso3 = new JMenuItem("PEQUENA");
		JMenuItem reso4 = new JMenuItem("X-PEQUENA");
		reso.add(resoD);
		reso.add(sep);
		reso.add(reso4);
		reso.add(reso3);
		reso.add(reso2);
		reso.add(reso1);
		resolutionActionListener(clearEverthing, pesosF, notasF, newDay, resoD, aggPanel, gastosPanel, reso1, reso2,
				reso3, reso4);
		// extra
		JMenu extraM = new JMenu("EXTRA");
		JMenuItem oldYears = new JMenuItem(idiomaString(language)[31]);
		JMenu monthAvg = new JMenu(idiomaString(language)[36]);
		JMenu monthOtherLang = new JMenu(idiomaString(language)[37]);
		JMenuItem monthSelected[] = new JMenuItem[13];
		JSeparator monthSeparator = new JSeparator();
		JMenuItem separadosM = new JMenuItem(idiomaString(language)[35]);
		// SUMMARY
		JMenu summary = new JMenu();
		JMenuItem sumV = new JMenuItem();
		JMenu effectChooser = new JMenu();
		JMenuItem sumV1 = new JMenuItem();
		JMenuItem sumV2 = new JMenuItem();
		JMenuItem sumV3 = new JMenuItem();
		JMenu exMenu = new JMenu();
		JSeparator sep3 = new JSeparator();
		JMenu exMenuD = new JMenu(idiomaString(language)[37]);
		JMenuItem exMenuR = new JMenuItem(language == 0 ? "ESPAÑOL" : language == 1 ? "PORTUGUÊS" : "ENGLISH");
		JMenuItem exMenuS = new JMenuItem("ESPAÑOL");
		JMenuItem exMenuP = new JMenuItem("PORTUGUÊS");
		JMenuItem exMenuE = new JMenuItem("ENGLISH");
		JMenu speedChooser = new JMenu();
		JMenuItem speed1 = new JMenuItem();
		JMenuItem speed2 = new JMenuItem();
		JMenuItem speed3 = new JMenuItem();
		oldYears.addActionListener(e -> memoryFrame());
		// month selected
		monthSelected[0] = new JMenuItem(getMonthForInt(Integer.valueOf(First.monthN) - 1));
		monthSelected[0].addActionListener(e -> monthAvgFrame(Integer.valueOf(First.monthN)));
		for (int i = 1; i < 13; i++)
			monthSelected[i] = new JMenuItem(getMonthForInt(i - 1));
		monthSelected[1].addActionListener(e -> monthAvgFrame(1));
		monthSelected[2].addActionListener(e -> monthAvgFrame(2));
		monthSelected[3].addActionListener(e -> monthAvgFrame(3));
		monthSelected[4].addActionListener(e -> monthAvgFrame(4));
		monthSelected[5].addActionListener(e -> monthAvgFrame(5));
		monthSelected[6].addActionListener(e -> monthAvgFrame(6));
		monthSelected[7].addActionListener(e -> monthAvgFrame(7));
		monthSelected[8].addActionListener(e -> monthAvgFrame(8));
		monthSelected[9].addActionListener(e -> monthAvgFrame(9));
		monthSelected[10].addActionListener(e -> monthAvgFrame(10));
		monthSelected[11].addActionListener(e -> monthAvgFrame(11));
		monthSelected[12].addActionListener(e -> monthAvgFrame(12));
		for (int i = 1; i < 13; i++)
			if (i > Integer.valueOf(First.monthN) - 1)
				monthSelected[i].hide();
		separadosM.addActionListener(e -> {
			String hoy = Calendar.getInstance().getTime().getHours() + ""
					+ Calendar.getInstance().getTime().getMinutes();
			JPasswordField pwd = new JPasswordField(10);
			Object[] obj = { "", pwd };
			Object stringArray[] = { "OK", "NO" };
			int action = JOptionPane.showOptionDialog(null, pwd, idiomaString(language)[32], JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, memI, stringArray, obj);
			if (action != 0)
				JOptionPane.showMessageDialog(null, idiomaString(language)[33]);// cancel
			else {
				String pass = new String(pwd.getPassword());
				while (!pass.equals(hoy)) {
					action = JOptionPane.showOptionDialog(null, pwd, idiomaString(language)[32],
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, memI, stringArray, obj);
					pass = new String(pwd.getPassword());
					if (action != 0) {
						JOptionPane.showMessageDialog(null, idiomaString(language)[33]);// cancel
						break;
					}
				}
				if (pass.equals(hoy)) {
					separadosFrame();
				}
			}
		});
		sumV.addActionListener(e -> summaryFrame());
		/* effect choose default conf */
		if (conf[8] == null || conf[8].equals("0")) {
			effChooser = 0;
			sumV1.setEnabled(false);
			sumV2.setEnabled(true);
			sumV3.setEnabled(true);
		} else if (conf[8].equals("1")) {
			effChooser = 1;
			sumV1.setEnabled(true);
			sumV2.setEnabled(false);
			sumV3.setEnabled(true);
		} else {
			effChooser = 2;
			sumV1.setEnabled(true);
			sumV2.setEnabled(true);
			sumV3.setEnabled(false);
		}
		summaryActionListener(sumV1, sumV2, sumV3);
		/* effect choose default conf */
		/* speed default conf */
		if (conf[6] == null || conf[6].equals("1")) {
			speed1.setEnabled(true);
			speed2.setEnabled(false);
			speed3.setEnabled(true);
		} else if (conf[6].equals("0")) {
			speed1.setEnabled(false);
			speed2.setEnabled(true);
			speed3.setEnabled(true);
		} else {
			speed1.setEnabled(true);
			speed2.setEnabled(true);
			speed3.setEnabled(false);
		}
		speedActionListener(speed1, speed2, speed3);
		/* speed default conf */
		monthAvg.add(monthSelected[0]);
		monthAvg.add(monthSeparator);
		if (Integer.valueOf(First.monthN) != 0)
			monthAvg.add(monthOtherLang);
		for (int i = 1; i < 13; i++)
			monthOtherLang.add(monthSelected[i]);
		exMenuR.addActionListener(e -> exBtn(language));
		exMenuS.addActionListener(e -> exBtn(0));
		exMenuP.addActionListener(e -> exBtn(1));
		exMenuE.addActionListener(e -> exBtn(2));
		exMenu.add(exMenuR);
		exMenu.add(sep3);
		exMenu.add(exMenuD);
		exMenuD.add(exMenuS);
		exMenuD.add(exMenuP);
		exMenuD.add(exMenuE);
		if (language == 0)
			exMenuS.hide();
		else if (language == 1)
			exMenuP.hide();
		else if (language == 2)
			exMenuE.hide();
		speedChooser.add(speed1);
		speedChooser.add(speed2);
		speedChooser.add(speed3);
		effectChooser.add(sumV1);
		effectChooser.add(sumV2);
		effectChooser.add(sumV3);
		summary.add(sumV);
		summary.add(effectChooser);
		summary.add(speedChooser);
		summary.add(exMenu);
		extraM.add(summary);
		extraM.add(monthAvg);
		extraM.add(oldYears);
		extraM.add(separadosM);
		// HELP
		JMenu help = new JMenu("AYUDA");
		JMenu hideMenu = new JMenu("ESCONDER");
		JMenuItem keyShortcut = new JMenuItem(idiomaString(language)[1]);
		JMenuItem creator = new JMenuItem("SOBRE EL CREADOR");
		JMenuItem about = new JMenuItem("SOBRE EL APLICATIVO");
		hideActionListener(hideBtn, noHide, hideDate, hideAll, clearEverthing, pesosF, notasF, newDay);
		if (conf[2] == null || conf[2].equals("false"))
			keyShortcut.addActionListener(
					e -> JOptionPane.showMessageDialog(null, idiomaString(language)[0], idiomaString(language)[1], 1));
		else
			keyShortcut.hide();
		creator.addActionListener(
				e -> JOptionPane.showMessageDialog(null, idiomaString(language)[2], idiomaString(language)[28], 1));
		about.addActionListener(
				e -> JOptionPane.showMessageDialog(null, idiomaString(language)[3], "CEDROS/NARJES", 1));
		hideMenu.add(noHide);
		hideMenu.add(hideDate);
		hideMenu.add(hideBtn);
		hideMenu.add(hideAll);
		help.add(hideMenu);
		help.add(keyShortcut);
		help.add(creator);
		help.add(about);
		// Image Icon
		novo.setIcon(new ImageIcon(getScaledImage(newdayI.getImage(), 35, 35)));
		screenShot.setIcon(new ImageIcon(getScaledImage(screenshotI.getImage(), 35, 35)));
		save.setIcon(new ImageIcon(getScaledImage(saveI.getImage(), 35, 35)));
		clear.setIcon(new ImageIcon(getScaledImage(clearI.getImage(), 35, 35)));
		calc.setIcon(new ImageIcon(getScaledImage(calcI.getImage(), 35, 35)));
		option.setIcon(new ImageIcon(getScaledImage(settingI.getImage(), 35, 35)));
		exit.setIcon(new ImageIcon(getScaledImage(exitI.getImage(), 35, 35)));

		firstFrame.setIcon(new ImageIcon(getScaledImage(firstI.getImage(), 35, 35)));
		pesos.setIcon(new ImageIcon(getScaledImage(moneyI.getImage(), 35, 35)));
		fatura.setIcon(new ImageIcon(getScaledImage(invoiceI.getImage(), 35, 35)));

		resoD.setIcon(new ImageIcon(getScaledImage(optimalI.getImage(), 35, 35)));
		reso4.setIcon(new ImageIcon(getScaledImage(xsmallI.getImage(), 35, 35)));
		reso3.setIcon(new ImageIcon(getScaledImage(smallI.getImage(), 35, 35)));
		reso2.setIcon(new ImageIcon(getScaledImage(medI.getImage(), 35, 35)));
		reso1.setIcon(new ImageIcon(getScaledImage(largeI.getImage(), 35, 35)));

		oldYears.setIcon(new ImageIcon(getScaledImage(memI.getImage(), 35, 35)));
		monthAvg.setIcon(new ImageIcon(getScaledImage(avgI.getImage(), 35, 35)));
		monthOtherLang.setIcon(new ImageIcon(getScaledImage(monthIM.getImage(), 35, 35)));
		monthSelected[0]
				.setIcon(new ImageIcon(getScaledImage(monthI[Integer.valueOf(First.monthN) - 1].getImage(), 35, 35)));
		for (int i = 1; i < 12; i++)
			monthSelected[i].setIcon(new ImageIcon(getScaledImage(monthI[i - 1].getImage(), 35, 35)));
		separadosM.setIcon(new ImageIcon(getScaledImage(sepI.getImage(), 35, 35)));

		summary.setIcon(new ImageIcon(getScaledImage(summaryI.getImage(), 35, 35)));
		sumV.setIcon(new ImageIcon(getScaledImage(summI.getImage(), 35, 35)));
		effectChooser.setIcon(new ImageIcon(getScaledImage(themeI.getImage(), 35, 35)));
		speedChooser.setIcon(new ImageIcon(getScaledImage(speedI.getImage(), 35, 35)));
		exMenu.setIcon(new ImageIcon(getScaledImage(saveI.getImage(), 35, 35)));
		if (language == 0)
			exMenuR.setIcon(new ImageIcon(getScaledImage(espI.getImage(), 35, 35)));
		else if (language == 1)
			exMenuR.setIcon(new ImageIcon(getScaledImage(porI.getImage(), 35, 35)));
		else
			exMenuR.setIcon(new ImageIcon(getScaledImage(engI.getImage(), 35, 35)));
		exMenuD.setIcon(new ImageIcon(getScaledImage(defaultI.getImage(), 35, 35)));
		exMenuS.setIcon(new ImageIcon(getScaledImage(espI.getImage(), 35, 35)));
		exMenuP.setIcon(new ImageIcon(getScaledImage(porI.getImage(), 35, 35)));
		exMenuE.setIcon(new ImageIcon(getScaledImage(engI.getImage(), 35, 35)));
		sumV1.setIcon(new ImageIcon(getScaledImage(effect1I.getImage(), 35, 35)));
		sumV2.setIcon(new ImageIcon(getScaledImage(effect2I.getImage(), 35, 35)));
		sumV3.setIcon(new ImageIcon(getScaledImage(effect3I.getImage(), 35, 35)));
		speed1.setIcon(new ImageIcon(getScaledImage(slowI.getImage(), 35, 35)));
		speed2.setIcon(new ImageIcon(getScaledImage(normalI.getImage(), 35, 35)));
		speed3.setIcon(new ImageIcon(getScaledImage(fastI.getImage(), 35, 35)));

		hideMenu.setIcon(new ImageIcon(getScaledImage(hideI.getImage(), 35, 35)));
		noHide.setIcon(new ImageIcon(getScaledImage(showI.getImage(), 35, 35)));
		hideDate.setIcon(new ImageIcon(getScaledImage(dateI.getImage(), 35, 35)));
		hideBtn.setIcon(new ImageIcon(getScaledImage(buttonI.getImage(), 35, 35)));
		hideAll.setIcon(new ImageIcon(getScaledImage(allI.getImage(), 35, 35)));
		keyShortcut.setIcon(new ImageIcon(getScaledImage(keyboardI.getImage(), 35, 35)));
		creator.setIcon(new ImageIcon(getScaledImage(creatorI.getImage(), 35, 35)));
		about.setIcon(new ImageIcon(getScaledImage(aboutI.getImage(), 35, 35)));

		// ADD TO MENUBAR
		mb.add(file);
		mb.add(goTo);
		mb.add(reso);
		mb.add(extraM);
		mb.add(help);
		this.setJMenuBar(mb);

		// Frame Run
		openProgress();
		sumF();
		// Open to the last value
		int k = 0, l = 0;
		schiffe_loop: while (k < 6) {
			l = 0;
			while (l < 20) {
				if (details[k][l].getText().isBlank()) {
					break schiffe_loop;
				}
				l++;
			}
			k++;
		}
		if (k == 6 && l == 20)
			k = l = 0;
		InitialFocusSetter.setInitialFocus(this, details[k][l]);
		this.getRootPane().setDefaultButton(magic);
		this.setVisible(true);

		// Resolution
		if (conf[3] == null || conf[3].equals("0")) {
			opResolution(clearEverthing, pesosF, notasF, newDay, resoD, reso4, reso3, reso2, reso1, aggPanel,
					gastosPanel);
		} else if (conf[3].equals("1"))
			resXP(resoD, reso4, reso3, reso2, reso1, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel);
		else if (conf[3].equals("2"))
			resP(resoD, reso4, reso3, reso2, reso1, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel);
		else if (conf[3].equals("3"))
			resM(resoD, reso4, reso3, reso2, reso1, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel);
		else
			resG(resoD, reso4, reso3, reso2, reso1, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel);

		// LANGUAGE
		idiomaTexts(language, hideBtn, noHide, hideDate, hideAll, notasF, newDay, resoD, aggPanel, gastosPanel, file,
				novo, clear, calc, save, screenShot, option, exit, summary, sumV, effectChooser, sumV1, sumV2, sumV3,
				exMenu, speedChooser, speed1, speed2, speed3, goTo, pesos, fatura, firstFrame, reso, reso1, reso2,
				reso3, reso4, help, hideMenu, keyShortcut, creator, about);

		currentDate = new Date(Integer.valueOf(dayN), Integer.valueOf(First.monthN), 2023);

		// Close popup
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				Object[] options = { idiomaString(language)[11], idiomaString(language)[12],
						idiomaString(language)[15] };
				int selectedOption = JOptionPane.showOptionDialog(null, idiomaString(language)[13],
						idiomaString(language)[14], JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
						options, options[0]);
				if (selectedOption == JOptionPane.YES_OPTION)
					System.exit(0);
				else if (selectedOption == 1) {
					// Do Nothing
				} else if (selectedOption == 2) {
					exBtn(language);
					// save what will rest for tmrw
					BufferedReader data23 = null;
					String l23 = "";
					tempFile0.mkdir();
					File temp23 = new File(tempFile0 + "\\extra");
					temp23.mkdir();
					File file23 = new File(temp23, yearS + ".dll");
					ArrayList<String> con23 = new ArrayList<String>();
					try {
						data23 = new BufferedReader(new FileReader(file23));
						while ((l23 = data23.readLine()) != null) {
							con23.add(l23.toString());
						}
						data23.close();
					} catch (Exception e) {
						JOptionPane opt = new JOptionPane(
								language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
								JOptionPane.ERROR_MESSAGE);
						opt.show();
					}
					try {
						FileWriter save23 = new FileWriter(file23);
						for (int i = 0; i < con23.size(); i++)
							save23.write(con23.get(i) + System.lineSeparator());
						save23.write((pix + totalVenta) + System.lineSeparator());// icon
						save23.close();
					} catch (Exception e2) {
						JOptionPane opt = new JOptionPane(
								language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
								JOptionPane.ERROR_MESSAGE);
						opt.show();
					}
					for (int i = 0; i < 6; i++)
						for (int j = 0; j < 20; j++)
							details[i][j].setText("");
					initialDay.setText(restN + "");
					for (int i = 0; i < 16; i++) {
						gastosTable[i].setText("");
						agregadoTable[i].setText("");
						gTable[i].setText("");
						aTable[i].setText("");
					}
					for (int i = 0; i < 5; i++)
						panelCnum[i].setText("");
					panelCnum[5].setText("" + nbOf20);
					panelCnum[10].setText("");// pix
					sumF();
					System.exit(0);
				}
			}
		});
	}

	private void monthAvgFrame(int month) {
		JFrame extraF = new JFrame(idiomaString(language)[36]);
		extraF.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		extraF.setAlwaysOnTop(false);
		extraF.setSize(650, 550);
		extraF.setLocationRelativeTo(null);
		extraF.setResizable(false);
		extraF.setLayout(null);
		extraF.getContentPane().setBackground(First.lightC);
		// Background
		JLabel bg = new JLabel(sumI);
		bg.setBounds(0, 0, 650, 550);
		extraF.add(bg);
		// LABEL
		Date date = new Date(Integer.valueOf(dayN), month, Integer.valueOf(yearS));
		int total22[] = date.totalOfMes22();
		double avgM22 = (double) total22[0] / total22[1];
		int total23[] = date.totalOfMes();
		double avgM = (double) total23[0] / total23[1];
		JTextPane sumItem = new JTextPane();
		StyledDocument doc = sumItem.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		sumItem.setBounds(30, 130, 590, 550);
		sumItem.setFont(new Font("Tahoma", Font.BOLD, 18));
		sumItem.setEditable(false);
		sumItem.setCaretColor(First.lightC);
		sumItem.setOpaque(false);
		sumItem.addKeyListener(new KeyAdapter() {// Escape to close
			@SuppressWarnings("static-access")
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyCode() == ke.VK_ESCAPE) {
					wordL = 0;
					timer.stop();
					extraF.dispose();
				}
			}
		});

		ActionListener letterByLetter = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (language == 0) {
					char[] wordT = ("*EN " + getMonthForInt(month - 1) + " 2022 VENDISTE EN TOTAL R$"
							+ String.format("%,d\n", total22[0]) + "\nCON UN PROMEDIO DE R$"
							+ String.format("%,.2f", avgM22) + "\n\n\n*EN " + getMonthForInt(month - 1)
							+ " DE ESTE AÑO VENDISTE EN TOTAL R$" + String.format("%,d\n", total23[0])
							+ "\nCON UN PROMEDIO DE R$" + String.format("%,.2f", avgM) + "\n\n\n*SE PARECE QUE VENDIMOS"
							+ "\nUN PROMEDIO R$"
							+ (avgM < avgM22 ? String.format("%,.2f", avgM22 - avgM) + " MENOS DEL AÑO PASADO"
									: String.format("%,.2f", avgM - avgM22) + " MÁS DEL AÑO PASADO"))
							.toCharArray();
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText() + wordT[wordL++]);
					else {
						timer.stop();
						wordL = 0;
					}
				} else if (language == 1) {
					char[] wordT = ("*EM " + getMonthForInt(month - 1) + " 2022 VOCÊ VENDEU NO TOTAL R$"
							+ String.format("%,d\n", total22[0]) + "\nCOM MÉDIA DE R$" + String.format("%,.2f", avgM22)
							+ "\n\n\n*EM " + getMonthForInt(month - 1) + " NESSE ANO VOCÊ VENDEU NO TOTAL R$"
							+ String.format("%,d\n", total23[0]) + "\nCOM MÉDIA DE R$" + String.format("%,.2f", avgM)
							+ "\n\n\n*PARECE QUE VENDEMOS" + "\nUM MÉDIO R$"
							+ (avgM < avgM22 ? String.format("%,.2f", avgM22 - avgM) + " MENOS QUE O ANO PASSADO"
									: String.format("%,.2f", avgM - avgM22) + " MAIS QUE O ANO PASSADO"))
							.toCharArray();
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText() + wordT[wordL++]);
					else {
						timer.stop();
						wordL = 0;
					}
				} else {
					char[] wordT = ("*IN " + getMonthForInt(month - 1) + " 2022 YOU SOLD IN TOTAL R$"
							+ String.format("%,d\n", total22[0]) + "\nWITH AN AVERAGE OF R$"
							+ String.format("%,.2f", avgM22) + "\n\n\n*IN " + getMonthForInt(month - 1)
							+ " OF THIS YEAR YOU SOLD IN TOTAL R$" + String.format("%,d\n", total23[0])
							+ "\nWITH AN AVERAGE OF R$" + String.format("%,.2f", avgM) + "\n\n\n*IT LOOKS LIKE WE SOLD"
							+ "\nAN AVERAGE OF R$"
							+ (avgM < avgM22 ? String.format("%,.2f", avgM22 - avgM) + " LESS THAN LAST YEAR"
									: String.format("%,.2f", avgM - avgM22) + " MORE THAN LAST YEAR"))
							.toCharArray();
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText() + wordT[wordL++]);
					else {
						timer.stop();
						wordL = 0;
					}
				}
			}
		};
		timer = new Timer(50, letterByLetter);
		timer.start();
		// export at the end of the month
		exMonthFrame(month);

		// If close stop the timer
		extraF.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				try {
					wordL = 0;
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

		extraF.add(sumItem);
		extraF.setIconImage(avgI.getImage());
		extraF.setVisible(true);
	}

	// export at the end of the month
	private void exMonthFrame(int month) {
		Date date = new Date(Integer.valueOf(dayN), month, Integer.valueOf(yearS));
		int total22[] = date.totalOfMes22();
		double avgM22 = (double) total22[0] / total22[1];
		int total23[] = date.totalOfMes();
		double avgM = (double) total23[0] / total23[1];
		if (month != Integer.valueOf(First.monthN)
				|| (month == Integer.valueOf(First.monthN) && Integer.valueOf(dayN) == date.maxDays())) {
			try {
				tempFile0.mkdir();
				File tempFile1 = new File(tempFile0 + "\\" + yearS);
				tempFile1.mkdir();
				File tempFile2 = new File(tempFile1 + "\\" + getMonthForInt(month - 1));
				tempFile2.mkdir();
				File newFile = new File(tempFile2, "SUMMARY - " + getMonthForInt(month - 1) + ".txt");
				FileWriter savedF = new FileWriter(newFile);
				String[] espSumm = {
						System.lineSeparator() + "*EN 2022 VENDISTE EN TOTAL R$" + String.format("%,d\n", total22[0])
								+ "\n*EL PROMEDIO ES R$" + String.format("%,.2f", avgM22)
								+ "\n\n\n*ESTE AÑO VENDISTE EN TOTAL R$" + String.format("%,d\n", total23[0])
								+ "\n*EL PROMEDIO ES R$" + String.format("%,.2f", avgM)
								+ "\n\n\n*SE PARECE QUE VENDIMOS UN PROMEDIO R$"
								+ (avgM < avgM22 ? String.format("%,.2f", avgM22 - avgM) + " MENOS DEL AÑO PASADO"
										: String.format("%,.2f", avgM - avgM22) + " MÁS DEL AÑO PASADO")
								+ System.lineSeparator(), // 1
						System.lineSeparator() + "*GRACIAS Y HASTA MAÑANA :)", // 2
				};
				String[] porSumm = {
						System.lineSeparator() + "*EM 2022 VOCÊ VENDEU NO TOTAL R$" + String.format("%,d\n", total22[0])
								+ "\n*O MÉDIA É R$" + String.format("%,.2f", avgM22)
								+ "\n\n\n*NESSE ANO VOCÊ VENDEU NO TOTAL R$" + String.format("%,d\n", total23[0])
								+ "\n*O MÉDIA É R$" + String.format("%,.2f", avgM)
								+ "\n\n\n*PARECE QUE VENDEMOS UM MÉDIO R$"
								+ (avgM < avgM22 ? String.format("%,.2f", avgM22 - avgM) + " MENOS QUE O ANO PASSADO"
										: String.format("%,.2f", avgM - avgM22) + " MAIS QUE O ANO PASSADO")
								+ System.lineSeparator(), // 1
						System.lineSeparator() + "*OBRIGADO E ATÉ AMANHÃ :)"// 2
				};
				String[] engSumm = {
						System.lineSeparator() + "*IN 2022 YOU SOLD IN TOTAL R$" + String.format("%,d\n", total22[0])
								+ "\n*THE AVERAGE OF SALES IS R$" + String.format("%,.2f", avgM22)
								+ "\n\n\n*IN THIS YEAR YOU SOLD IN TOTAL R$" + String.format("%,d\n", total23[0])
								+ "\n*THE AVERAGE OF SALES IS R$" + String.format("%,.2f", avgM)
								+ "\n\n\n*IT LOOKS LIKE WE SOLD AN AVERAGE OF R$"
								+ (avgM < avgM22 ? String.format("%,.2f", avgM22 - avgM) + " LESS THAN LAST YEAR"
										: String.format("%,.2f", avgM - avgM22) + " MORE THAN LAST YEAR")
								+ System.lineSeparator(), // 1
						System.lineSeparator() + "*THANKS AND SEE YOU TOMORROW :)" // 17
				};
				savedF.write(titleName()
						+ (language == 0
								? " - COMPARACIÓN ENTRE ESTE AÑO Y EL AÑO PASADO DEL MES " + getMonthForInt(month - 1)
										+ ":"
								: language == 1
										? " - COMPARAÇÃO ENTRE ESTE ANO E O ANO PASSADO DO MÊS "
												+ getMonthForInt(month - 1) + ":"
										: " - COMPARISON BETWEEN THIS YEAR AND LAST YEAR FOR MONTH OF ")
						+ getMonthForInt(month - 1) + ":" + System.lineSeparator() + System.lineSeparator());
				savedF.write(language == 0 ? espSumm[0]
						: language == 1 ? porSumm[0] : engSumm[0] + System.lineSeparator() + System.lineSeparator());
				savedF.write(
						language == 0 ? espSumm[1] : language == 1 ? porSumm[1] : engSumm[1] + System.lineSeparator());

				savedF.close();
			} catch (Exception e2) {
				JOptionPane opt = new JOptionPane(
						language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
						JOptionPane.ERROR_MESSAGE);
				opt.show();
			}
		}
	}

	// SEPARADOS FRAME
	private void separadosFrame() {
		JFrame extraF = new JFrame(idiomaString(language)[35]);
		extraF.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		extraF.setAlwaysOnTop(false);
		extraF.setSize(415, 285);
		extraF.setLocationRelativeTo(null);
		extraF.setResizable(false);
		extraF.setLayout(null);
		extraF.getContentPane().setBackground(First.lightC);

		JTextField[][] sepLabel = new JTextField[5][2];
		JLabel titleSep[] = new JLabel[2];
		KeyAdapter kA = new KeyAdapter() {// Escape to close
			@SuppressWarnings("static-access")
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyCode() == ke.VK_ESCAPE) {
					// save the results
					try {
						tempFile0.mkdir();
						File tempFile1 = new File(tempFile0 + "\\extra");
						tempFile1.mkdir();
						File sepFile = new File(tempFile1, "SEP" + ".dll");
						FileWriter savedF = new FileWriter(sepFile);
						for (int i = 0; i < 5; i++)
							for (int j = 0; j < 2; j++)
								savedF.write(sepLabel[i][j].getText() + System.lineSeparator());
						savedF.close();
					} catch (Exception e2) {
						JOptionPane opt = new JOptionPane(
								language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
								JOptionPane.ERROR_MESSAGE);
						opt.show();
					}
					extraF.dispose();
				}
			}
		};
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 2; j++) {
				if (i == 0) {
					titleSep[j] = new JLabel();
					titleSep[j].setBounds(0 + 199 * j, 0, 200, 50);
					titleSep[j].setFont(new Font("Tahoma", Font.BOLD, 20));
					titleSep[j].setForeground(First.lightC);
					titleSep[j].setBackground(First.blueD);
					titleSep[j].setOpaque(true);
					titleSep[j].setHorizontalAlignment(0);
					titleSep[j].setBorder(new LineBorder(First.darkC, 2));
					extraF.add(titleSep[j]);
				}
				sepLabel[i][j] = new JTextField();
				sepLabel[i][j].addKeyListener(kA);
				sepLabel[i][j].setBounds(0 + 199 * j, 50 + 39 * i, 200, 40);
				sepLabel[i][j].setFont(new Font("Tahoma", Font.BOLD, 18));
				sepLabel[i][j].setForeground(First.lightC);
				sepLabel[i][j].setBackground(First.blueC);
				sepLabel[i][j].setBorder(new LineBorder(First.darkC, 2));
				sepLabel[i][j].setHorizontalAlignment(0);
				extraF.add(sepLabel[i][j]);
			}
		titleSep[0].setText("SEPARADO");
		titleSep[1].setText("FECHA");

		// OPEN CONF
		BufferedReader sepOpened = null;
		String sepLine = "";
		int sepInt = 0;
		String sepData[] = new String[11];
		tempFile0.mkdir();
		File tempFile1 = new File(tempFile0 + "\\extra");
		tempFile1.mkdir();
		File sepFile = new File(tempFile1, "SEP" + ".dll");
		try {
			sepOpened = new BufferedReader(new FileReader(sepFile));
			while ((sepLine = sepOpened.readLine()) != null) {
				sepData[sepInt] = sepLine.toString();
				sepInt++;
			}
			sepOpened.close();
		} catch (Exception e) {
			JOptionPane opt = new JOptionPane(
					language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
					JOptionPane.ERROR_MESSAGE);
			opt.show();
		}
		sepInt = 0;
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 2; j++)
				sepLabel[i][j].setText(sepData[sepInt++]);

		// If close stop the timer
		extraF.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				try {
					// save the results
					try {
						tempFile0.mkdir();
						File tempFile1 = new File(tempFile0 + "\\extra");
						tempFile1.mkdir();
						File sepFile = new File(tempFile1, "SEP" + ".dll");
						FileWriter savedF = new FileWriter(sepFile);
						for (int i = 0; i < 5; i++)
							for (int j = 0; j < 2; j++)
								savedF.write(sepLabel[i][j].getText() + System.lineSeparator());
						savedF.close();
					} catch (Exception e2) {
						JOptionPane opt = new JOptionPane(
								language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
								JOptionPane.ERROR_MESSAGE);
						opt.show();
					}
					Runtime.getRuntime().exec("taskkill /f /im java.exe");
				} catch (IOException e4) {
					JOptionPane opt = new JOptionPane(
							language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
							JOptionPane.ERROR_MESSAGE);
					opt.show();
				}
			}
		});
		extraF.setIconImage(sepI.getImage());
		extraF.setVisible(true);
	}

	private void memoryFrame() {
		JFrame extraF = new JFrame(idiomaString(language)[31]);
		extraF.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		extraF.setAlwaysOnTop(false);
		extraF.setSize(650, 550);
		extraF.setLocationRelativeTo(null);
		extraF.setResizable(false);
		extraF.setLayout(null);
		extraF.getContentPane().setBackground(First.lightC);
		// Background
		JLabel bg = new JLabel(sumI);
		bg.setBounds(0, 0, 650, 550);
		extraF.add(bg);
		// LABEL
		int value22 = Integer.valueOf(vend2022(Integer.valueOf(dayN + "" + First.monthN)));
		JTextPane sumItem = new JTextPane();
		StyledDocument doc = sumItem.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		sumItem.setBounds(30, 130, 590, 550);
		sumItem.setFont(new Font("Tahoma", Font.BOLD, 18));
		sumItem.setEditable(false);
		sumItem.setCaretColor(First.lightC);
		sumItem.setOpaque(false);
		sumItem.addKeyListener(new KeyAdapter() {// Escape to close
			@SuppressWarnings("static-access")
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyCode() == ke.VK_ESCAPE) {
					wordL = 0;
					timer.stop();
					extraF.dispose();
				}
			}
		});

		ActionListener letterByLetter = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (language == 0) {
					char[] wordT = ("*EN ESTE DÍA EN " + dayN + "-" + monthS + "-2022,\n\nLO QUE ES UN "
							+ whatDay(Integer.valueOf(dayN), Integer.valueOf(First.monthN), 0) + ", VENDISTE R$"
							+ value22 + " EN TOTAL\n\n\n*HOY, " + dayS + " VENDISTE POR AHORA R$" + (pix + totalVenta)
							+ "\n\n\n*SE PARECE QUE VENDIMOS R$"
							+ (value22 > (pix + totalVenta)
									? (value22 - (pix + totalVenta) + " MENOS QUE EL AÑO PASADO")
									: ((pix + totalVenta) - value22 + " MÁS QUE EL AÑO PASADO"))
							+ (value22 == 0 ? ""
									: "\n\nCORRESPONDIENTE A UN " + (value22 > (pix + totalVenta)
											? "DISMINUIR DE " + (value22 - (pix + totalVenta)) * 100 / value22

											: "AUMENTAR DE " + ((pix + totalVenta) - value22) * 100 / value22))
							+ "%").toCharArray();
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText() + wordT[wordL++]);
					else {
						timer.stop();
						wordL = 0;
					}
				} else if (language == 1) {
					char[] wordT = ("*NESTE DIA EM " + dayN + "-" + monthS + "-2022,\n\nO QUE É UM "
							+ whatDay(Integer.valueOf(dayN), Integer.valueOf(First.monthN), 1) + ", VOCÊ VENDEU R$"
							+ value22 + " EM TOTAL\n\n\n*HOJE, " + dayS + " VENDEU POR AGORA R$" + (pix + totalVenta)
							+ "\n\n\n*PARECE QUE VENDEMOS R$"
							+ (value22 > (pix + totalVenta) ? (value22 - (pix + totalVenta) + " MENOS QUE ANO PASSADO")
									: ((pix + totalVenta) - value22 + " MAIS QUE ANO PASSADO"))
							+ (value22 == 0 ? ""
									: "\n\nCORRESPONDENTE A UM " + (value22 > (pix + totalVenta)
											? "DIMINUIÇÃO DO " + (value22 - (pix + totalVenta)) * 100 / value22

											: "AUMENTO DO " + ((pix + totalVenta) - value22) * 100 / value22))
							+ "%").toCharArray();
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText() + wordT[wordL++]);
					else {
						timer.stop();
						wordL = 0;
					}
				} else {
					char[] wordT = ("*ON THIS DAY IN " + dayN + "-" + monthS + "-2022,\n\nTHAT IS A "
							+ whatDay(Integer.valueOf(dayN), Integer.valueOf(First.monthN), 2) + ", YOU SOLD R$"
							+ value22 + " IN TOTAL\n\n\n*TODAY, " + dayS + " YOU SOLD FOR NOW R$" + (pix + totalVenta)
							+ "\n\n\n*IT SEEMS WE SOLD R$"
							+ (value22 > (pix + totalVenta) ? (value22 - (pix + totalVenta) + " LESS THAN LAST YEAR")
									: ((pix + totalVenta) - value22 + " MORE THAN LAST YEAR"))
							+ (value22 == 0 ? ""
									: "\n\nCORRESPONDING TO " + (value22 > (pix + totalVenta)
											? "A DECREASE OF " + (value22 - (pix + totalVenta)) * 100 / value22

											: "AN INCREASE OF " + ((pix + totalVenta) - value22) * 100 / value22))
							+ "%").toCharArray();
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText() + wordT[wordL++]);
					else {
						timer.stop();
						wordL = 0;
					}
				}
			}
		};
		timer = new Timer(50, letterByLetter);
		timer.start();
		// If close stop the timer
		extraF.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				try {
					wordL = 0;
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

		extraF.add(sumItem);
		extraF.setIconImage(memI.getImage());
		extraF.setVisible(true);
	}

	String whatDay(int d, int m, int lang) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, d);
		calendar.set(Calendar.MONTH, m - 1);
		calendar.set(Calendar.YEAR, 2022);
		String day = "";

		if (lang == 0)
			switch (calendar.getTime().getDay()) {
			case 1: {
				day = "LUNES";
				break;
			}
			case 2: {
				day = "MARTES";
				break;
			}
			case 3: {
				day = "MIÉRCOLES";
				break;
			}
			case 4: {
				day = "JUEVES";
				break;
			}
			case 5: {
				day = "VIERNES";
				break;
			}
			case 6: {
				day = "SÁBADO";
				break;
			}
			case 0: {
				day = "DOMINGO";
				break;
			}
			default: {
				break;
			}
			}
		else if (lang == 1)
			switch (calendar.getTime().getDay()) {
			case 1: {
				day = "SEGUNDA-FEIRA";
				break;
			}
			case 2: {
				day = "TERÇA-FEIRA";
				break;
			}
			case 3: {
				day = "QUARTA-FEIRA";
				break;
			}
			case 4: {
				day = "QUINTA-FEIRA";
				break;
			}
			case 5: {
				day = "SEXTA-FEIRA";
				break;
			}
			case 6: {
				day = "SÁBADO";
				break;
			}
			case 0: {
				day = "DOMINGO";
				break;
			}
			default: {
				break;
			}
			}
		else
			switch (calendar.getTime().getDay()) {
			case 1: {
				day = "MONDAY";
				break;
			}
			case 2: {
				day = "TUESDAY";
				break;
			}
			case 3: {
				day = "WEDNESDAY";
				break;
			}
			case 4: {
				day = "THURSDAY";
				break;
			}
			case 5: {
				day = "FRIDAY";
				break;
			}
			case 6: {
				day = "SATURDAY";
				break;
			}
			case 0: {
				day = "SUNDAY";
				break;
			}
			default: {
				break;
			}
			}
		return day;
	}

	private String vend2022(int d) {
		Date date = new Date(1, 1, 2022);
		String date22[] = new String[366];
		String appV;
		if (conf[0] == null || !conf[0].equals("3"))
			appV = "2022C.dll";
		else
			appV = "2022N.dll";
		for (int i = 0; i < 366; i++) {
			date22[i] = date.d + "" + date.m;
			date = date.addDays(1);
		}
		String value22[] = new String[366];
		try {
			BufferedReader dataOpened = new BufferedReader(
					new InputStreamReader(this.getClass().getResourceAsStream("/extra/" + appV)));
			String line = "";
			int z = 0;
			while ((line = dataOpened.readLine()) != null) {
				value22[z] = line.toString();
				z++;
			}
			dataOpened.close();
		} catch (Exception e) {
			JOptionPane opt = new JOptionPane(
					language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
					JOptionPane.ERROR_MESSAGE);
			opt.show();
		}
		int numero = 0;
		for (int i = 0; i < 366; i++) {
			if (Integer.valueOf(date22[i]) == d) {
				numero = i;
				break;
			}
		}
		return value22[numero];
	}

	private void screenShooter() {
		BufferedImage img = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
		this.paint(img.getGraphics());
		File tempFile1 = new File(tempFile0 + "\\" + yearS);
		tempFile1.mkdir();
		File tempFile2 = new File(tempFile1 + "\\" + monthS);
		tempFile2.mkdir();
		File tempFile3 = new File(tempFile2 + "\\IMG");
		tempFile3.mkdir();
		File newFile = new File(tempFile3, "R$ " + dayN + "-" + monthS + "-" + yearS + ".png");
		try {
			ImageIO.write(img, "png", newFile);
		} catch (IOException e) {
			JOptionPane opt = new JOptionPane(
					language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
					JOptionPane.ERROR_MESSAGE);
			opt.show();
		}
	}

	// Know the app title
	private String titleName() {
		if (conf[0] == null || !conf[0].equals("3"))
			return "CEDROS";
		else
			return "NARJES";
	}

	// Frame summary of the day
	private void summaryFrame() {
		JFrame sum = new JFrame();
		if (language == 0)
			sum.setTitle("SUMARIO");
		else if (language == 1)
			sum.setTitle("SUMÁRIO");
		else
			sum.setTitle("SUMMARY");
		sum.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		sum.setAlwaysOnTop(false);
		sum.setSize(650, 550);
		sum.setLocationRelativeTo(null);
		sum.setResizable(false);
		sum.setLayout(null);
		sum.getContentPane().setBackground(First.lightC);
		// Background
		JLabel bg = new JLabel(sumI);
		bg.setBounds(0, 0, 650, 550);
		sum.add(bg);
		// export btn
		JButton expBtn = new JButton();
		expBtn.setIcon(expI);
		expBtn.setContentAreaFilled(false);
		expBtn.setBorderPainted(false);
		expBtn.setBounds(300, 300, 50, 50);
		expBtn.setVisible(false);
		expBtn.addActionListener(e -> exBtn(language));
		sum.add(expBtn);
		// LABEL
		JTextPane sumItem = new JTextPane();
		StyledDocument doc = sumItem.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		sumItem.setBounds(0, 200, 650, 550);
		sumItem.setFont(new Font("Tahoma", Font.BOLD, 18));
		sumItem.setEditable(false);
		sumItem.setCaretColor(First.lightC);
		sumItem.setOpaque(false);
		sumItem.addKeyListener(new KeyAdapter() {// Escape to close
			@SuppressWarnings("static-access")
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyCode() == ke.VK_ESCAPE) {
					timer.stop();
					sum.dispose();
				}
			}
		});
		// TIMER
		order = 0;
		wordsN = 0;
		wordL = 0;
		colorX = 0;
		status = true;
		String[] espSumm = { "USTED NO VENDIÓ NADA", // 0
				"USTED VENDIÓ UNA VENTA SOLO QUE VALE R$" + totalVenta, // 1
				"USTED VENDIÓ R$" + totalVenta + "\n\nDIVIDIENDO EN " + nbVentas() + " VENTAS\n\n"
						+ "CON UN PROMEDIO DE R$" + (nbVentas() == 0 ? 0 : totalVenta / nbVentas()) + " POR VENTA", // 2
				"NO TIENES GASTOS!", // 3
				"TIENES EN TOTAL UN GASTO QUE VALE R$" + gastosT + "\n\n" + "DETALLADO COMO:\n" + gastosDetalles(), // 4
				"TIENES EN TOTAL R$" + gastosT + " COMO GASTOS\n\n" + "DIVIDIDO POR " + nbGastos() + " COSAS\n\n"
						+ "CON UN PROMEDIO DE R$" + (nbGastos() == 0 ? 0 : gastosT / nbGastos()) + "\n\n"
						+ "DETALLADO COMO:\n" + gastosDetalles(), // 5
				"NO TIENES AGREGADOS!", // 6
				"TIENES EN TOTAL UN AGREGADO QUE VALE R$" + agregadoT + "\n\n" + "DETALLADO COMO:\n"
						+ agregadoDetalles(), // 7
				"TIENES EN TOTAL $" + agregadoT + " COMO AGREGADOS\n\n" + "DIVIDIDO POR " + nbAgregados() + " COSAS\n\n"
						+ "CON UN PROMEDIO DE $" + (nbAgregados() == 0 ? 0 : agregadoT / nbAgregados()) + "\n\n"
						+ "DETALLADO COMO:\n" + agregadoDetalles(), // 8
				"PARA RESUMIR\n\n" + "EMPEZAMOS EL DÍA CON R$" + initialDay.getText() + "\n\nY VENDIMOS R$" + totalVenta
						+ "\n\nY GASTO R$" + gastosT + "\n\nQUE TERMINARÁ CON R$" + totalO + " EN TOTAL"
						+ "\n\nCON UN R$" + panelCnum[10].getText() + " COMO PIX", // 9
				"PARA RESUMIR\n\n" + "EMPEZAMOS EL DÍA CON R$" + initialDay.getText() + "\n\nY VENDIMOS R$" + totalVenta
						+ "\n\nY GASTO R$" + gastosT + "\n\nQUE TERMINARÁ CON R$" + totalO + " EN TOTAL", // 10
				"PARA RESUMIR\n\n" + "EMPEZAMOS EL DÍA CON R$" + initialDay.getText() + "\n\nY VENDIMOS R$" + totalVenta
						+ "\n\nY GASTO R$" + gastosT + "\n\nY AGREGÓ R$" + agregadoT + "\n\nQUE TERMINARÁ CON R$"
						+ totalO + " EN TOTAL" + "\n\nCON UN R$" + panelCnum[10].getText() + " COMO PIX", // 11
				"PARA RESUMIR\n\n" + "EMPEZAMOS EL DÍA CON R$" + initialDay.getText() + "\n\nY VENDIMOS R$" + totalVenta
						+ "\n\nY GASTO R$" + gastosT + "\n\nY AGREGÓ R$" + agregadoT + "\n\nQUE TERMINARÁ CON R$"
						+ totalO + " EN TOTAL", // 12
				"LA CAJA DIO BIEN\n\n" + "NO HAY DIFERENCIA\n\n" + ":)", // 13
				"LA CAJA NO DIO BIEN\n\n" + "PARECE QUE " + diffResult[1].getText().toUpperCase()
						+ "\n\nREVISA LOS BOLETOS Y LA CAJA", // 14
				"QUEDARÁ PARA MAÑANA APROXIMADAMENTE\n\nR$" + restN, // 15
				"TOQUE EL BOTÓN PARA EXPORTAR EL RESULTADO"// 16
		};
		String[] porSumm = { "VOCÊ NÃO VENDEU NADA", // 0
				"VOCÊ VENDEU UMA VENDA SÓ QUE VALE R$" + totalVenta, // 1
				"VOCÊ VENDEU R$" + totalVenta + "\n\nDIVIDINDO EM " + nbVentas() + " VENDAS\n\n" + "COM MÉDIA DE R$"
						+ (nbVentas() == 0 ? 0 : totalVenta / nbVentas()) + " À VENDA", // 2
				"VOCÊ NÃO TEM GASTOS!", // 3
				"VOCÊ TEM NO TOTAL UM GASTO NO VALOR DE R$" + gastosT + "\n\n" + "DETALHADO COMO:\n" + gastosDetalles(), // 4
				"VOCÊ TEM NO TOTAL R$" + gastosT + " COMO GASTOS\n\n" + "DIVIDIDO POR " + nbGastos() + " COISAS\n\n"
						+ "COM MÉDIA DE R$" + (nbGastos() == 0 ? 0 : gastosT / nbGastos()) + "\n\n"
						+ "DETALHADO COMO:\n" + gastosDetalles(), // 5
				"VOCÊ NÃO TEM AGREGADOS!", // 6
				"VOCÊ TEM NO TOTAL UM AGREGADO NO VALOR DE R$" + agregadoT + "\n\n" + "DETALHADO COMO:\n"
						+ agregadoDetalles(), // 7
				"VOCÊ TEM NO TOTAL R$" + agregadoT + " COMO AGREGADOS\n\n" + "DIVIDIDO POR " + nbAgregados()
						+ " COISAS\n\n" + "COM MÉDIA DE R$" + (nbAgregados() == 0 ? 0 : agregadoT / nbAgregados())
						+ "\n\n" + "DETALHADO COMO:\n" + agregadoDetalles(), // 8
				"PARA RESUMIR\n\n" + "COMEÇAMOS O DIA COM R$" + initialDay.getText() + "\n\nE VENDEMOS R$" + totalVenta
						+ "\n\nE GASTO R$" + gastosT + "\n\nQUE VAI ACABAR EM R$" + totalO + " EM TOTAL"
						+ "\n\nCOM UM R$" + panelCnum[10].getText() + " COMO PIX", // 9
				"PARA RESUMIR\n\n" + "COMEÇAMOS O DIA COM R$" + initialDay.getText() + "\n\nE VENDEMOS R$" + totalVenta
						+ "\n\nE GASTO R$" + gastosT + "\n\nQUE VAI ACABAR EM R$" + totalO + " EM TOTAL", // 10
				"PARA RESUMIR\n\n" + "COMEÇAMOS O DIA COM R$" + initialDay.getText() + "\n\nE VENDEMOS R$" + totalVenta
						+ "\n\nE GASTO R$" + gastosT + "\n\nE ADICIONO R$" + agregadoT + "\n\nQUE VAI ACABAR EM R$"
						+ totalO + " EM TOTAL" + "\n\nCOM UM R$" + panelCnum[10].getText() + " COMO PIX", // 11
				"PARA RESUMIR\n\n" + "COMEÇAMOS O DIA COM R$" + initialDay.getText() + "\n\nE VENDEMOS R$" + totalVenta
						+ "\n\nE GASTO R$" + gastosT + "\n\nE ADICIONO R$" + agregadoT + "\n\nQUE VAI ACABAR EM R$"
						+ totalO + " EM TOTAL", // 12
				"A CAIXA DEU BEM\n\n" + "NÃO HÁ DIFERENÇA\n\n" + ":)", // 13
				"A CAIXA NÃO DEU BEM\n\n" + "PARECE QUE " + diffResult[1].getText().toUpperCase()
						+ "\n\nCONFIRA OS INGRESSOS E A CAIXA", // 14
				"FICARÁ PARA AMANHÃ APROXIMADAMENTE\n\nR$" + restN, // 15
				"TOQUE NO BOTÃO PARA EXPORTAR O RESULTADO"// 16
		};
		String[] engSumm = { "YOU DIDN'T SELL ANYTHING", // 0
				"YOU SELL ONE SALE ONLY WORTH R$" + totalVenta, // 1
				"YOU SELL R$" + totalVenta + "\n\nDIVIDING INTO " + nbVentas() + " SALES\n\n" + "WITH AVERAGE R$"
						+ (nbVentas() == 0 ? 0 : totalVenta / nbVentas()) + " FOR SALE", // 2
				"YOU HAVE NO EXPENSES!", // 3
				"YOU HAVE IN TOTAL A SPENT WORTH R$" + gastosT + "\n\n" + "DETAILED LIKE:\n" + gastosDetalles(), // 4
				"YOU HAVE A TOTAL R$" + gastosT + " AS EXPENSES\n\n" + "DIVIDED BY " + nbGastos() + " THINGS\n\n"
						+ "WITH AVERAGE OF R$" + (nbGastos() == 0 ? 0 : gastosT / nbGastos()) + "\n\n"
						+ "DETAILED AS:\n" + gastosDetalles(), // 5
				"YOU HAVE NO AGGREGATE!", // 6
				"YOU HAVE IN TOTAL AN AGGREGATE WORTH R$" + agregadoT + "\n\n" + "DETAILED LIKE:\n"
						+ agregadoDetalles(), // 7
				"YOU HAVE IN TOTAL A R$" + agregadoT + " AS AGGREGATES\n\n" + "DIVIDED BY " + nbAgregados()
						+ " THINGS\n\n" + "WITH AVERAGE OF R$" + (nbAgregados() == 0 ? 0 : agregadoT / nbAgregados())
						+ "\n\n" + "DETAILED AS:\n" + agregadoDetalles(), // 8
				"TO SUMMARIZE\n\n" + "WE START THE DAY WITH R$" + initialDay.getText() + "\n\nAND WE SELL R$"
						+ totalVenta + "\n\nAND WE SPENT R$" + gastosT + "\n\nWHAT WILL END IN R$" + totalO
						+ " IN TOTAL" + "\n\nWITH R$" + panelCnum[10].getText() + " AS PIX", // 9
				"TO SUMMARIZE\n\n" + "WE START THE DAY WITH R$" + initialDay.getText() + "\n\nAND WE SELL R$"
						+ totalVenta + "\n\nAND WE SPENT R$" + gastosT + "\n\nWHAT WILL END IN R$" + totalO
						+ " IN TOTAL", // 10
				"TO SUMMARIZE\n\n" + "WE START THE DAY WITH R$" + initialDay.getText() + "\n\nAND WE SELL R$"
						+ totalVenta + "\n\nAND WE SPENT R$" + gastosT + "\n\nAND WE ADD R$" + agregadoT
						+ "\n\nWHAT WILL END IN R$" + totalO + " IN TOTAL" + "\n\nWITH R$" + panelCnum[10].getText()
						+ " AS PIX", // 11
				"TO SUMMARIZE\n\n" + "WE START THE DAY WITH R$" + initialDay.getText() + "\n\nAND WE SELL R$"
						+ totalVenta + "\n\nAND WE SPENT R$" + gastosT + "\n\nAND WE ADD R$" + agregadoT
						+ "\n\nWHAT WILL END IN R$" + totalO + " IN TOTAL", // 12
				"THE CASH DID WELL\n\n" + "NO DIFFERENCE\n\n" + ":)", // 13
				"THE CASH DIDN'T FIT\n\n" + "LOOKS LIKE THERE ARE " + diffResult[1].getText().toUpperCase()
						+ "\n\nRE-CHECK THE TICKETS AND THE BOX", // 14
				"WILL BE OUT TOMORROW APPROXIMATELY\n\nR$" + restN, // 15
				"TOUCH THE BUTTON TO EXPORT THE RESULT"// 16
		};

		ActionListener fadeTimer = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sumItem.setForeground(new Color(0, 0, 0, colorX));
				switch (order) {
				case 0: {// details start
					if (totalVenta == 0) {
						sumItem.setText(language == 0 ? espSumm[0] : language == 1 ? porSumm[0] : engSumm[0]);
						sumItem.setBounds(0, 240, 650, 550);
					} else {
						if (nbVentas() == 1) {
							sumItem.setText(language == 0 ? espSumm[1] : language == 1 ? porSumm[1] : engSumm[1]);
							sumItem.setBounds(0, 240, 650, 550);
						} else {
							sumItem.setText(language == 0 ? espSumm[2] : language == 1 ? porSumm[2] : engSumm[2]);
							sumItem.setBounds(0, 200, 650, 550);
						}
					}
					if (colorX < 254 && status)// Details fade in
						colorX++;
					else {
						status = false;
						if (colorX > 0)// Details fade out
							colorX -= 2;
						else
							order++;
					}
					break;
				}
				case 1: {// gastos start
					if (gastosT == 0) {
						sumItem.setBounds(0, 240, 650, 550);
						sumItem.setText(language == 0 ? espSumm[3] : language == 1 ? porSumm[3] : engSumm[3]);
					} else {
						if (nbGastos() == 1) {
							sumItem.setText(language == 0 ? espSumm[4] : language == 1 ? porSumm[4] : engSumm[4]);
							sumItem.setBounds(0, 220, 650, 550);
						} else {
							sumItem.setText(language == 0 ? espSumm[5] : language == 1 ? porSumm[5] : engSumm[5]);
							sumItem.setBounds(0, 120, 650, 550);
						}
					}
					if (colorX < 254 && !status)// gastos fade in
						colorX++;
					else {
						status = true;
						if (colorX > 0)// gastos fade out
							colorX -= 2;
						else
							order++;
					}
					break;
				}
				case 2: {// agg start
					if (agregadoT == 0) {
						sumItem.setText(language == 0 ? espSumm[6] : language == 1 ? porSumm[6] : engSumm[6]);
						sumItem.setBounds(0, 240, 650, 550);
					} else {
						if (nbAgregados() == 1) {
							sumItem.setText(language == 0 ? espSumm[7] : language == 1 ? porSumm[7] : engSumm[7]);
							sumItem.setBounds(0, 220, 650, 550);
						} else {
							sumItem.setText(language == 0 ? espSumm[8] : language == 1 ? porSumm[8] : engSumm[8]);
							sumItem.setBounds(0, 120, 650, 550);
						}
					}
					if (colorX < 254 && status)// agg fade in
						colorX++;
					else {
						status = false;
						if (colorX > 0)// agg fade out
							colorX -= 2;
						else
							order++;
					}
					break;
				}
				case 3: {// SUMMARY start
					sumItem.setBounds(0, 100, 650, 550);
					if (agregadoT == 0)
						if (Integer.valueOf(panelCnum[10].getText()) > 0)
							sumItem.setText(language == 0 ? espSumm[9] : language == 1 ? porSumm[9] : engSumm[9]);
						else
							sumItem.setText(language == 0 ? espSumm[10] : language == 1 ? porSumm[10] : engSumm[10]);
					else if (Integer.valueOf(panelCnum[10].getText()) > 0)
						sumItem.setText(language == 0 ? espSumm[11] : language == 1 ? porSumm[11] : engSumm[11]);
					else
						sumItem.setText(language == 0 ? espSumm[12] : language == 1 ? porSumm[12] : engSumm[12]);
					if (colorX < 254 && !status)// summ fade in
						colorX++;
					else {
						status = true;
						if (colorX > 0)// agg fade out
							colorX -= 2;
						else
							order++;
					}
					break;
				}
				case 4: {// diferrence
					sumItem.setBounds(0, 200, 650, 550);
					if (totalO == totalCaja)
						sumItem.setText(language == 0 ? espSumm[13] : language == 1 ? porSumm[13] : engSumm[13]);
					else
						sumItem.setText(language == 0 ? espSumm[14] : language == 1 ? porSumm[14] : engSumm[14]);
					// diferrence fade in
					if (colorX < 254 && status)
						colorX += 2;
					else {
						status = false;
						if (colorX > 0)// diferrence fade out
							colorX -= 2;
						else
							order++;
					}
					break;
				}
				case 5: {// remain for tmrw
					sumItem.setBounds(0, 220, 650, 550);
					sumItem.setText(language == 0 ? espSumm[15] : language == 1 ? porSumm[15] : engSumm[15]);
					if (colorX < 254 && !status)// remain fade in
						colorX += 2;
					else {
						status = true;
						if (colorX > 0)// remain fade out
							colorX -= 2;
						else
							order++;
					}
					break;
				}
				case 6: {// export button
					sumItem.setBounds(0, 200, 650, 550);
					sumItem.setText(language == 0 ? espSumm[16] : language == 1 ? porSumm[16] : engSumm[16]);
					if (colorX < 254)// export label fade in
						colorX += 2;
					else {
						expBtn.setVisible(true);
						timer.stop();
					}
					break;
				}
				default:
					break;
				}
			}
		};
		ActionListener wordByWord = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				switch (order) {
				case 0: {// details start
					if (totalVenta == 0) {// if ventas = 0
						String[] wordT = language == 0 ? espSumm[0].split(" ")
								: language == 1 ? porSumm[0].split(" ") : engSumm[0].split(" ");
						sumItem.setBounds(0, 240, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					} else if (nbVentas() == 1) {// if = 1
						String[] wordT = language == 0 ? espSumm[1].split(" ")
								: language == 1 ? porSumm[1].split(" ") : engSumm[1].split(" ");
						sumItem.setBounds(0, 220, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					} else {// if >1
						String[] wordT = language == 0 ? espSumm[2].split(" ")
								: language == 1 ? porSumm[2].split(" ") : engSumm[2].split(" ");
						sumItem.setBounds(0, 200, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					}
					break;
				}
				case 1: {// gastos start
					if (gastosT == 0) {
						String[] wordT = language == 0 ? espSumm[3].split(" ")
								: language == 1 ? porSumm[3].split(" ") : engSumm[3].split(" ");
						sumItem.setBounds(0, 240, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					} else if (nbGastos() == 1) {
						String[] wordT = language == 0 ? espSumm[4].split(" ")
								: language == 1 ? porSumm[4].split(" ") : engSumm[4].split(" ");
						sumItem.setBounds(0, 200, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					} else {
						String[] wordT = language == 0 ? espSumm[5].split(" ")
								: language == 1 ? porSumm[5].split(" ") : engSumm[5].split(" ");
						sumItem.setBounds(0, 120, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					}
					break;
				}
				case 2: {// agg start
					if (agregadoT == 0) {
						String[] wordT = language == 0 ? espSumm[6].split(" ")
								: language == 1 ? porSumm[6].split(" ") : engSumm[6].split(" ");
						sumItem.setBounds(0, 240, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					} else if (nbAgregados() == 1) {
						String[] wordT = language == 0 ? espSumm[7].split(" ")
								: language == 1 ? porSumm[7].split(" ") : engSumm[7].split(" ");
						sumItem.setBounds(0, 200, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					} else {
						String[] wordT = language == 0 ? espSumm[8].split(" ")
								: language == 1 ? porSumm[8].split(" ") : engSumm[8].split(" ");
						sumItem.setBounds(0, 120, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					}
					break;
				}
				case 3: {// SUMMARY start
					if (agregadoT == 0)
						if (Integer.valueOf(panelCnum[10].getText()) > 0) {
							sumItem.setBounds(0, 120, 650, 550);
							String[] wordT = language == 0 ? espSumm[9].split(" ")
									: language == 1 ? porSumm[9].split(" ") : engSumm[9].split(" ");
							if (wordL < wordT.length)
								sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
							else {
								if (wordL < wordT.length + 3) {
									wordL++;
								} else {
									order++;
									wordL = 0;
									sumItem.setText("");
								}
							}
						} else {
							sumItem.setBounds(0, 140, 650, 550);
							String[] wordT = language == 0 ? espSumm[10].split(" ")
									: language == 1 ? porSumm[10].split(" ") : engSumm[10].split(" ");
							if (wordL < wordT.length)
								sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
							else {
								if (wordL < wordT.length + 3) {
									wordL++;
								} else {
									order++;
									wordL = 0;
									sumItem.setText("");
								}
							}
						}
					else if (Integer.valueOf(panelCnum[10].getText()) > 0) {
						sumItem.setBounds(0, 100, 650, 550);
						String[] wordT = language == 0 ? espSumm[11].split(" ")
								: language == 1 ? porSumm[11].split(" ") : engSumm[11].split(" ");
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					} else {
						sumItem.setBounds(0, 120, 650, 550);
						String[] wordT = language == 0 ? espSumm[12].split(" ")
								: language == 1 ? porSumm[12].split(" ") : engSumm[12].split(" ");
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					}
					break;
				}
				case 4: {// diferrence start
					if (totalO == totalCaja) {
						String[] wordT = language == 0 ? espSumm[13].split(" ")
								: language == 1 ? porSumm[13].split(" ") : engSumm[13].split(" ");
						sumItem.setBounds(0, 220, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					} else {
						String[] wordT = language == 0 ? espSumm[14].split(" ")
								: language == 1 ? porSumm[14].split(" ") : engSumm[14].split(" ");
						sumItem.setBounds(0, 200, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					}
					break;
				}
				case 5: {// remain for tmrw
					String[] wordT = language == 0 ? espSumm[15].split(" ")
							: language == 1 ? porSumm[15].split(" ") : engSumm[15].split(" ");
					sumItem.setBounds(0, 220, 650, 550);
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 6: {// export button
					String[] wordT = language == 0 ? espSumm[16].split(" ")
							: language == 1 ? porSumm[16].split(" ") : engSumm[16].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						order++;
						expBtn.setVisible(true);
						timer.stop();
					}
					break;
				}
				default:
					timer.stop();
					break;
				}
			}
		};
		ActionListener letterByLetter = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				switch (order) {
				case 0: {// details start
					if (totalVenta == 0) {
						char[] wordT = language == 0 ? espSumm[0].toCharArray()
								: language == 1 ? porSumm[0].toCharArray() : engSumm[0].toCharArray();
						sumItem.setBounds(0, 240, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText() + wordT[wordL++]);
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					} else if (nbVentas() == 1) {
						char[] wordT = language == 0 ? espSumm[1].toCharArray()
								: language == 1 ? porSumm[1].toCharArray() : engSumm[1].toCharArray();
						sumItem.setBounds(0, 240, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText() + wordT[wordL++]);
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					} else {
						char[] wordT = language == 0 ? espSumm[2].toCharArray()
								: language == 1 ? porSumm[2].toCharArray() : engSumm[2].toCharArray();
						sumItem.setBounds(0, 200, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText() + wordT[wordL++]);
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					}
					break;
				}
				case 1: {// gastos start
					if (gastosT == 0) {
						char[] wordT = language == 0 ? espSumm[3].toCharArray()
								: language == 1 ? porSumm[3].toCharArray() : engSumm[3].toCharArray();
						sumItem.setBounds(0, 240, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText() + wordT[wordL++]);
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					} else if (nbGastos() == 1) {
						char[] wordT = language == 0 ? espSumm[4].toCharArray()
								: language == 1 ? porSumm[4].toCharArray() : engSumm[4].toCharArray();
						sumItem.setBounds(0, 200, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText() + (wordT[wordL++]));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					} else {
						char[] wordT = language == 0 ? espSumm[5].toCharArray()
								: language == 1 ? porSumm[5].toCharArray() : engSumm[5].toCharArray();
						sumItem.setBounds(0, 120, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText() + (wordT[wordL++]));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					}
					break;
				}
				case 2: {// agg start
					if (agregadoT == 0) {
						char[] wordT = language == 0 ? espSumm[6].toCharArray()
								: language == 1 ? porSumm[6].toCharArray() : engSumm[6].toCharArray();
						sumItem.setBounds(0, 240, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText() + (wordT[wordL++]));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					} else if (nbAgregados() == 1) {
						char[] wordT = language == 0 ? espSumm[7].toCharArray()
								: language == 1 ? porSumm[7].toCharArray() : engSumm[7].toCharArray();
						sumItem.setBounds(0, 200, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText() + (wordT[wordL++]));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					} else {
						char[] wordT = language == 0 ? espSumm[8].toCharArray()
								: language == 1 ? porSumm[8].toCharArray() : engSumm[8].toCharArray();
						sumItem.setBounds(0, 120, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText() + (wordT[wordL++]));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					}
					break;
				}
				case 3: {// SUMMARY start
					if (agregadoT == 0)
						if (Integer.valueOf(panelCnum[10].getText()) > 0) {
							sumItem.setBounds(0, 120, 650, 550);
							char[] wordT = language == 0 ? espSumm[9].toCharArray()
									: language == 1 ? porSumm[9].toCharArray() : engSumm[9].toCharArray();
							if (wordL < wordT.length)
								sumItem.setText(sumItem.getText() + (wordT[wordL++]));
							else {
								if (wordL < wordT.length + 3) {
									wordL++;
								} else {
									order++;
									wordL = 0;
									sumItem.setText("");
								}
							}
						} else {
							sumItem.setBounds(0, 140, 650, 550);
							char[] wordT = language == 0 ? espSumm[10].toCharArray()
									: language == 1 ? porSumm[10].toCharArray() : engSumm[10].toCharArray();
							if (wordL < wordT.length)
								sumItem.setText(sumItem.getText() + (wordT[wordL++]));
							else {
								if (wordL < wordT.length + 3) {
									wordL++;
								} else {
									order++;
									wordL = 0;
									sumItem.setText("");
								}
								;
							}
						}
					else if (Integer.valueOf(panelCnum[10].getText()) > 0) {
						sumItem.setBounds(0, 100, 650, 550);
						char[] wordT = language == 0 ? espSumm[11].toCharArray()
								: language == 1 ? porSumm[11].toCharArray() : engSumm[11].toCharArray();
						if (wordL < wordT.length) {
							sumItem.setText(sumItem.getText() + (wordT[wordL++]));
						} else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					} else {
						sumItem.setBounds(0, 120, 650, 550);
						char[] wordT = language == 0 ? espSumm[12].toCharArray()
								: language == 1 ? porSumm[12].toCharArray() : engSumm[12].toCharArray();
						if (wordL < wordT.length) {
							sumItem.setText(sumItem.getText() + (wordT[wordL++]));
						} else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					}
					break;
				}
				case 4: {// diferrence start
					if (totalO == totalCaja) {
						char[] wordT = language == 0 ? espSumm[13].toCharArray()
								: language == 1 ? porSumm[13].toCharArray() : engSumm[13].toCharArray();
						sumItem.setBounds(0, 200, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText() + (wordT[wordL++]));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					} else {
						char[] wordT = language == 0 ? espSumm[14].toCharArray()
								: language == 1 ? porSumm[14].toCharArray() : engSumm[14].toCharArray();
						sumItem.setBounds(0, 200, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText() + (wordT[wordL++]));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					}
					break;
				}
				case 5: {// remain for tmrw
					char[] wordT = language == 0 ? espSumm[15].toCharArray()
							: language == 1 ? porSumm[15].toCharArray() : engSumm[15].toCharArray();
					sumItem.setBounds(0, 220, 650, 550);
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText() + (wordT[wordL++]));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 6: {// export button
					char[] wordT = language == 0 ? espSumm[16].toCharArray()
							: language == 1 ? porSumm[16].toCharArray() : engSumm[16].toCharArray();
					sumItem.setBounds(0, 200, 650, 550);
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText() + (wordT[wordL++]));
					else {
						order++;
						wordL = 0;
						expBtn.setVisible(true);
						timer.stop();
					}
					break;
				}
				default:
					timer.stop();
					break;
				}
			}
		};

		if (effChooser == 0) {
			// Speed
			if (conf[6] == null || conf[6].equals("1"))
				speedValue = 15;
			else if (conf[6].equals("0"))
				speedValue = 20;
			else
				speedValue = 1;
			timer = new Timer(speedValue, fadeTimer);
		} else if (effChooser == 1) {
			// Speed
			if (conf[6] == null || conf[6].equals("1"))
				speedValue = 400;
			else if (conf[6].equals("0"))
				speedValue = 500;
			else
				speedValue = 300;
			timer = new Timer(speedValue, wordByWord);
		} else {
			// Speed
			if (conf[6] == null || conf[6].equals("1"))
				speedValue = 150;
			else if (conf[6].equals("0"))
				speedValue = 300;
			else
				speedValue = 50;
			timer = new Timer(speedValue, letterByLetter);
		}
		timer.start();

		// If close stop the timer
		sum.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				try {
					colorX = 0;
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

		sum.add(sumItem);
		sum.setIconImage(summI.getImage());
		sum.setVisible(true);
	}

	// Save the summary of the day
	private void exBtn(int lang) {
		dateLang(lang);
		int value22 = Integer.valueOf(vend2022(Integer.valueOf(dayN + "" + First.monthN)));
		try {
			tempFile0.mkdir();
			File tempFile1 = new File(tempFile0 + "\\" + yearS);
			tempFile1.mkdir();
			File tempFile2 = new File(tempFile1 + "\\" + monthS);
			tempFile2.mkdir();
			File newFile = new File(tempFile2, "R$ " + dayN + "-" + First.monthN + " (" + dayS + ").txt");
			FileWriter savedF = new FileWriter(newFile);
			String[] espSumm = { "*VENTAS:\nUSTED NO VENDIÓ NADA" + System.lineSeparator(), // 0
					"*VENTAS:\nUSTED VENDIÓ UNA VENTA SOLO QUE VALE R$" + totalVenta + System.lineSeparator(), // 1
					"*VENTAS:\nUSTED VENDIÓ R$" + totalVenta + ", DIVIDIENDO EN " + nbVentas() + " VENTAS, "
							+ "CON UN PROMEDIO DE R$" + (nbVentas() == 0 ? 0 : totalVenta / nbVentas()) + " POR VENTA"
							+ System.lineSeparator(), // 2
					System.lineSeparator() + "*GASTOS:\nNO TIENES GASTOS!" + System.lineSeparator(), // 3
					System.lineSeparator() + "*GASTOS:\nTIENES EN TOTAL UN GASTO QUE VALE R$" + gastosT + "\n"
							+ "DETALLADO COMO:\n" + gastosDetalles(), // 4
					System.lineSeparator() + "*GASTOS:\nTIENES EN TOTAL R$" + gastosT + " COMO GASTOS, "
							+ "DIVIDIDO POR " + nbGastos() + " COSAS, " + "CON UN PROMEDIO DE R$"
							+ (nbGastos() == 0 ? 0 : gastosT / nbGastos()) + "\n" + "DETALLADO COMO:\n"
							+ gastosDetalles(), // 5
					System.lineSeparator() + "*AGREGADOS:\nTIENES EN TOTAL UN AGREGADO QUE VALE R$" + agregadoT + "\n"
							+ "DETALLADO COMO:\n" + agregadoDetalles(), // 7
					System.lineSeparator() + "*AGREGADOS:\nTIENES EN TOTAL $" + agregadoT + " COMO AGREGADOS, "
							+ "DIVIDIDO POR " + nbAgregados() + " COSAS, " + "CON UN PROMEDIO DE $"
							+ (nbAgregados() == 0 ? 0 : agregadoT / nbAgregados()) + "\n" + "DETALLADO COMO:\n"
							+ agregadoDetalles(), // 8
					System.lineSeparator() + "*PARA RESUMIR:\n" + "EMPEZAMOS EL DÍA CON R$" + initialDay.getText()
							+ "\nVENDIMOS R$" + totalVenta + "\nGASTO R$" + gastosT + "\nQUE TERMINARÁ CON R$" + totalO
							+ " EN TOTAL" + "\nCON UN R$" + panelCnum[10].getText() + " COMO PIX"
							+ System.lineSeparator(), // 9
					System.lineSeparator() + "*PARA RESUMIR:\n" + "EMPEZAMOS EL DÍA CON R$" + initialDay.getText()
							+ "\nVENDIMOS R$" + totalVenta + "\nGASTO R$" + gastosT + "\nQUE TERMINARÁ CON R$" + totalO
							+ " EN TOTAL" + System.lineSeparator(), // 10
					System.lineSeparator() + "*PARA RESUMIR:\n" + "EMPEZAMOS EL DÍA CON R$" + initialDay.getText()
							+ "\nVENDIMOS R$" + totalVenta + "\nGASTO R$" + gastosT + "\nAGREGÓ R$" + agregadoT
							+ "\nQUE TERMINARÁ CON R$" + totalO + " EN TOTAL" + "\nCON UN R$" + panelCnum[10].getText()
							+ " COMO PIX" + System.lineSeparator(), // 11
					System.lineSeparator() + "*PARA RESUMIR:\n" + "EMPEZAMOS EL DÍA CON R$" + initialDay.getText()
							+ "\nVENDIMOS R$" + totalVenta + "\nGASTO R$" + gastosT + "\nAGREGÓ R$" + agregadoT
							+ "\nQUE TERMINARÁ CON R$" + totalO + " EN TOTAL" + System.lineSeparator(), // 12
					System.lineSeparator() + "*LA CAJA DIO BIEN, NO HAY DIFERENCIA" + System.lineSeparator(), // 13
					System.lineSeparator() + "*LA CAJA NO DIO BIEN, PARECE QUE " + diffResult[1].getText().toUpperCase()
							+ System.lineSeparator(), // 14
					System.lineSeparator() + "*QUEDARÁ PARA MAÑANA APROXIMADAMENTE R$" + restN + System.lineSeparator(), // 15
					System.lineSeparator() + "*RECUERDOS DE HOY:\nEN ESTE DÍA EN " + "2022, LO QUE ES UN "
							+ whatDay(Integer.valueOf(dayN), Integer.valueOf(First.monthN), 0) + ", VENDISTE R$"
							+ value22 + " EN TOTAL\nHOY, " + dayS + " VENDISTE POR AHORA R$" + (pix + totalVenta)
							+ "\nSE PARECE QUE VENDIMOS R$"
							+ (value22 > (pix + totalVenta)
									? (value22 - (pix + totalVenta) + " MENOS QUE EL AÑO PASADO")
									: ((pix + totalVenta) - value22 + " MÁS QUE EL AÑO PASADO"))
							+ (value22 == 0 ? ""
									: ", CORRESPONDIENTE A UN %" + (value22 > (pix + totalVenta)
											? (value22 - (pix + totalVenta)) * 100 / value22
													+ " DISMINUIR DEL AÑO PASADO"
											: ((pix + totalVenta) - value22) * 100 / value22
													+ " AUMENTAR DEL AÑO PASADO"))
							+ System.lineSeparator(), // 16
					System.lineSeparator() + "*GRACIAS Y HASTA MAÑANA :)", // 17
			};
			String[] porSumm = { "*VENDAS:\nVOCÊ NÃO VENDEU NADA" + System.lineSeparator(), // 0
					"*VENDAS:\nVOCÊ VENDEU UMA VENDA SÓ QUE VALE R$" + totalVenta + System.lineSeparator(), // 1
					"*VENDAS:\nVOCÊ VENDEU R$" + totalVenta + ", DIVIDINDO EM " + nbVentas() + " VENDAS, "
							+ "COM MÉDIA DE R$" + (nbVentas() == 0 ? 0 : totalVenta / nbVentas()) + " À VENDA"
							+ System.lineSeparator(), // 2
					System.lineSeparator() + "*GASTOS:\nVOCÊ NÃO TEM GASTOS!" + System.lineSeparator(), // 3
					System.lineSeparator() + "*GASTOS:\nVOCÊ TEM NO TOTAL UM GASTO NO VALOR DE R$" + gastosT + "\n"
							+ "DETALHADO COMO:\n" + gastosDetalles(), // 4
					System.lineSeparator() + "*GASTOS:\nVOCÊ TEM NO TOTAL R$" + gastosT + " COMO GASTOS, "
							+ "DIVIDIDO POR " + nbGastos() + " COISAS, " + "COM MÉDIA DE R$"
							+ (nbGastos() == 0 ? 0 : gastosT / nbGastos()) + "\n" + "DETALHADO COMO:\n"
							+ gastosDetalles(), // 5
					System.lineSeparator() + "*AGREGADOS:\nVOCÊ TEM NO TOTAL UM AGREGADO NO VALOR DE R$" + agregadoT
							+ "\n" + "DETALHADO COMO:\n" + agregadoDetalles(), // 6
					System.lineSeparator() + "*AGREGADOS:\nVOCÊ TEM NO TOTAL R$" + agregadoT + " COMO AGREGADOS, "
							+ "DIVIDIDO POR " + nbAgregados() + " COISAS, " + "COM MÉDIA DE R$"
							+ (nbAgregados() == 0 ? 0 : agregadoT / nbAgregados()) + "\n" + "DETALHADO COMO:\n"
							+ agregadoDetalles() + System.lineSeparator(), // 7
					System.lineSeparator() + "*PARA RESUMIR:\n" + "COMEÇAMOS O DIA COM R$" + initialDay.getText()
							+ "\nVENDEMOS R$" + totalVenta + "\nGASTO R$" + gastosT + "\nQUE VAI ACABAR EM R$" + totalO
							+ " EM TOTAL" + "\nCOM UM R$" + panelCnum[10].getText() + " COMO PIX"
							+ System.lineSeparator(), // 8
					System.lineSeparator() + "*PARA RESUMIR:\n" + "COMEÇAMOS O DIA COM R$" + initialDay.getText()
							+ "\nVENDEMOS R$" + totalVenta + "\nGASTO R$" + gastosT + "\nQUE VAI ACABAR EM R$" + totalO
							+ " EM TOTAL" + System.lineSeparator(), // 9
					System.lineSeparator() + "*PARA RESUMIR:\n" + "COMEÇAMOS O DIA COM R$" + initialDay.getText()
							+ "\nVENDEMOS R$" + totalVenta + "\nGASTO R$" + gastosT + "\nADICIONO R$" + agregadoT
							+ "\nQUE VAI ACABAR EM R$" + totalO + " EM TOTAL" + "\nCOM UM R$" + panelCnum[10].getText()
							+ " COMO PIX" + System.lineSeparator(), // 10
					System.lineSeparator() + "*PARA RESUMIR:\n" + "COMEÇAMOS O DIA COM R$" + initialDay.getText()
							+ "\nVENDEMOS R$" + totalVenta + "\nGASTO R$" + gastosT + "\nADICIONO R$" + agregadoT
							+ "\nQUE VAI ACABAR EM R$" + totalO + " EM TOTAL" + System.lineSeparator(), // 11
					System.lineSeparator() + "*A CAIXA DEU BEM, " + "NÃO HÁ DIFERENÇA" + System.lineSeparator(), // 12
					System.lineSeparator() + "*A CAIXA NÃO DEU BEM, " + "PARECE QUE "
							+ diffResult[1].getText().toUpperCase() + System.lineSeparator(), // 13
					System.lineSeparator() + "*FICARÁ PARA AMANHÃ APROXIMADAMENTE R$" + restN + System.lineSeparator(), // 14
					System.lineSeparator() + "*MEMÓRIAS DE HOJE:\nNESTE DIA EM " + "2022, O QUE É UM "
							+ whatDay(Integer.valueOf(dayN), Integer.valueOf(First.monthN), 1) + ", VENDEU R$" + value22
							+ " EM TOTAL\nHOJE, " + dayS + " VENDEU POR AGORA R$" + (pix + totalVenta)
							+ "\nPARECE QUE VENDEMOS R$"
							+ (value22 > (pix + totalVenta) ? (value22 - (pix + totalVenta) + " MENOS QUE ANO PASSADO")
									: ((pix + totalVenta) - value22 + " MAIS QUE ANO PASSADO"))
							+ (value22 == 0 ? ""
									: ", CORRESPONDENTE A %" + (value22 > (pix + totalVenta)
											? (value22 - (pix + totalVenta)) * 100 / value22
													+ " DIMINUIÇÃO DO ANO PASSADO"
											: ((pix + totalVenta) - value22) * 100 / value22
													+ " AUMENTO EM RELAÇÃO AO ANO PASSADO"))
							+ System.lineSeparator(), // 16
					System.lineSeparator() + "*OBRIGADO E ATÉ AMANHÃ :)"// 15
			};
			String[] engSumm = { "*SALES:\nYOU DIDN'T SELL ANYTHING" + System.lineSeparator(), // 0
					"*SALES:\nYOU SELL ONE SALE ONLY WORTH R$" + totalVenta + System.lineSeparator(), // 1
					"*SALES:\nYOU SELL R$" + totalVenta + ", DIVIDING INTO " + nbVentas() + " SALES, "
							+ "WITH AVERAGE R$" + (nbVentas() == 0 ? 0 : totalVenta / nbVentas())
							+ System.lineSeparator(), // 2
					System.lineSeparator() + "*EXPENSES:\nYOU HAVE NO EXPENSES!" + System.lineSeparator(), // 3
					System.lineSeparator() + "*EXPENSES:\nYOU HAVE IN TOTAL A SPENT WORTH R$" + gastosT + "\n"
							+ "DETAILED LIKE:\n" + gastosDetalles(), // 4
					System.lineSeparator() + "*EXPENSES:\nYOU HAVE A TOTAL R$" + gastosT + " AS EXPENSES, "
							+ "DIVIDED BY " + nbGastos() + " THINGS, " + "WITH AVERAGE OF R$"
							+ (nbGastos() == 0 ? 0 : gastosT / nbGastos()) + "\n" + "DETAILED AS:\n" + gastosDetalles(), // 5
					System.lineSeparator() + "*AGGREGATES:\nYOU HAVE IN TOTAL AN AGGREGATE WORTH R$" + agregadoT + "\n"
							+ "DETAILED LIKE:\n" + agregadoDetalles(), // 6
					System.lineSeparator() + "*AGGREGATES:\nYOU HAVE A TOTAL R$" + agregadoT + " AS AGGREGATES, "
							+ "DIVIDED BY " + nbAgregados() + " THINGS, " + "WITH AVERAGE OF R$"
							+ (nbAgregados() == 0 ? 0 : agregadoT / nbAgregados()) + "\n" + "DETAILED AS:\n"
							+ agregadoDetalles(), // 7
					System.lineSeparator() + "*TO SUMMARIZE:\n" + "WE START THE DAY WITH R$" + initialDay.getText()
							+ "\nSELL R$" + totalVenta + "\nSPENT R$" + gastosT + "\nWHAT WILL END IN R$" + totalO
							+ " IN TOTAL" + "\nWITH ONE R$" + panelCnum[10].getText() + " AS PIX"
							+ System.lineSeparator(), // 8
					System.lineSeparator() + "*TO SUMMARIZE:\n" + "WE START THE DAY WITH R$" + initialDay.getText()
							+ "\nSELL R$" + totalVenta + "\nSPENT R$" + gastosT + "\nWHAT WILL END IN R$" + totalO
							+ " IN TOTAL" + System.lineSeparator(), // 9
					System.lineSeparator() + "*TO SUMMARIZE:\n" + "WE START THE DAY WITH R$" + initialDay.getText()
							+ "\nSELL R$" + totalVenta + "\nSPENT R$" + gastosT + "\nADD R$" + agregadoT
							+ "\nWHAT WILL END IN R$" + totalO + " IN TOTAL" + "\nWITH R$" + panelCnum[10].getText()
							+ " AS PIX" + System.lineSeparator(), // 10
					System.lineSeparator() + "*TO SUMMARIZE:\n" + "WE START THE DAY WITH R$" + initialDay.getText()
							+ "\nSELL R$" + totalVenta + "\nSPENT R$" + gastosT + "\nADD R$" + agregadoT
							+ "\nWHAT WILL END IN R$" + totalO + " IN TOTAL" + System.lineSeparator(), // 11
					System.lineSeparator() + "*THE CASH DID WELL, " + "NO DIFFERENCE" + System.lineSeparator(), // 12
					System.lineSeparator() + "*THE CASH DIDN'T FIT, " + "LOOKS LIKE "
							+ diffResult[1].getText().toUpperCase() + System.lineSeparator(), // 13
					System.lineSeparator() + "*WILL BE OUT TOMORROW APPROXIMATELY R$" + restN + System.lineSeparator(), // 14
					System.lineSeparator() + "*MEMORIES OF TODAY:\nON THIS DAY IN " + "2022, THAT IS A "
							+ whatDay(Integer.valueOf(dayN), Integer.valueOf(First.monthN), 2) + ", YOU SOLD R$"
							+ value22 + " IN TOTAL\nTODAY, " + dayS + " YOU SOLD FOR NOW R$" + (pix + totalVenta)
							+ "\nIT SEEMS WE SOLD R$"
							+ (value22 > (pix + totalVenta) ? (value22 - (pix + totalVenta) + " LESS THAN LAST YEAR")
									: ((pix + totalVenta) - value22 + " MORE THAN LAST YEAR"))
							+ (value22 == 0 ? ""
									: ", CORRESPONDING TO A %" + (value22 > (pix + totalVenta)
											? (value22 - (pix + totalVenta)) * 100 / value22
													+ " DECREASE FROM LAST YEAR"
											: ((pix + totalVenta) - value22) * 100 / value22
													+ " INCREASE FROM LAST YEAR"))
							+ System.lineSeparator(), // 16
					System.lineSeparator() + "*THANKS AND SEE YOU TOMORROW :)" // 17
			};
			savedF.write(titleName()
					+ (lang == 0 ? " - SUMARIO POR EL DIA "
							: lang == 1 ? " - SUMÁRIO DO DIA " : " - SUMMARY OF THE DAY ")
					+ dayS + " " + dayN + "-" + monthS + "-" + yearS + System.lineSeparator() + System.lineSeparator());
			if ((pix + totalVenta) == 0)
				savedF.write(lang == 0 ? espSumm[0] : lang == 1 ? porSumm[0] : engSumm[0]);
			else if (nbVentas() == 1)
				savedF.write(lang == 0 ? espSumm[1] : lang == 1 ? porSumm[1] : engSumm[1]);
			else
				savedF.write(lang == 0 ? espSumm[2] : lang == 1 ? porSumm[2] : engSumm[2]);
			if (gastosT == 0)// GASTOS SAVE
				savedF.write(lang == 0 ? espSumm[3] : lang == 1 ? porSumm[3] : engSumm[3]);
			else if (nbGastos() == 1)
				savedF.write(lang == 0 ? espSumm[4] : lang == 1 ? porSumm[4] : engSumm[4]);
			else
				savedF.write(lang == 0 ? espSumm[5] : lang == 1 ? porSumm[5] : engSumm[5]);
			if (nbAgregados() != 0) { // AGG SAVE if 1
				if (nbAgregados() == 1)
					savedF.write(lang == 0 ? espSumm[6] : lang == 1 ? porSumm[6] : engSumm[6]);
				else
					savedF.write(lang == 0 ? espSumm[7] : lang == 1 ? porSumm[7] : engSumm[7]);
				if (Integer.valueOf(panelCnum[10].getText()) > 0)
					savedF.write(lang == 0 ? espSumm[10] : lang == 1 ? porSumm[10] : engSumm[10]);
				else
					savedF.write(lang == 0 ? espSumm[11] : lang == 1 ? porSumm[11] : engSumm[11]);
			} else if (Integer.valueOf(panelCnum[10].getText()) > 0)
				savedF.write(lang == 0 ? espSumm[8] : lang == 1 ? porSumm[8] : engSumm[8]);
			else
				savedF.write(lang == 0 ? espSumm[9] : lang == 1 ? porSumm[9] : engSumm[9]);
			if (totalO == totalCaja)
				savedF.write(lang == 0 ? espSumm[12] : lang == 1 ? porSumm[12] : engSumm[12]);
			else
				savedF.write(lang == 0 ? espSumm[13] : lang == 1 ? porSumm[13] : engSumm[13]);
			savedF.write(lang == 0 ? espSumm[14] : lang == 1 ? porSumm[14] : engSumm[14]);
			savedF.write(lang == 0 ? espSumm[15] : lang == 1 ? porSumm[15] : engSumm[15]);
			savedF.write(lang == 0 ? espSumm[16] : lang == 1 ? porSumm[16] : engSumm[16]);
			savedF.close();
			JOptionPane opt = new JOptionPane(idiomaString(lang)[26], JOptionPane.NO_OPTION);
			final JDialog dlg = opt.createDialog("SALVO");
			new Thread(new Runnable() {
				public void run() {
					try {
						Thread.sleep(1000);
						dlg.dispose();

					} catch (Throwable th) {
						JOptionPane opt = new JOptionPane(
								language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
								JOptionPane.ERROR_MESSAGE);
						opt.show();
					}
				}
			}).start();
			dlg.setVisible(true);
		} catch (Exception e2) {
			JOptionPane opt = new JOptionPane(
					lang == 0 ? "ERROR, NO SALVO!" : lang == 1 ? "ERROR, NAO SALVO!" : "ERROR",
					JOptionPane.ERROR_MESSAGE);
			opt.show();
		}

		// export at the end of the month
		exMonthFrame(Integer.valueOf(First.monthN));

		if (language == lang)
			screenShooter();
	}

	// Configuration tab
	private void confFrame(String[] conf, JButton notasF, JButton pesosF, JButton newDay, JButton clearEverthing,
			JMenuItem hideBtn, JMenuItem resoD, JButton gastosPanel, JButton aggPanel) {
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
		dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		// Op1 icon
		JLabel op1 = new JLabel(idiomaString(language)[5]);
		op1.setBounds(50, 20, 150, 50);
		op1.setFont(First.myFont);
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
		op1C.setBounds(420, 20, 70, 50);
		if (conf[0] != null)
			if (!conf[0].equalsIgnoreCase("null"))
				op1C.setSelectedIndex(Integer.valueOf(conf[0]));
		op1C.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				op1C.setSelectedIndex(op1C.getSelectedIndex());
			}
		});

		// op3 language
		JLabel op2 = new JLabel(idiomaString(language)[6]);
		op2.setBounds(50, 90, 200, 40);
		op2.setFont(First.myFont);
		String lan[] = { "ESPAÑOL", "PORTUGUÊS", "ENGLISH" };
		JComboBox<String> lang = new JComboBox<>(lan);
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

		// OPTION 2 DISABLE KEYBOARD SHORTCUT
		JLabel op3 = new JLabel(idiomaString(language)[1]);
		op3.setBounds(50, 160, 260, 40);
		op3.setFont(First.myFont);
		JToggleButton btnsHideShow2 = new JToggleButton();
		if (conf[2] == null || conf[2].equals("false")) {
			btnsHideShow2.setText(idiomaString(language)[11]);
		} else {
			btnsHideShow2.setText(idiomaString(language)[12]);
			btnsHideShow2.setSelected(true);
		}
		btnsHideShow2.setBounds(415, 160, 80, 40);
		btnsHideShow2.setFont(First.myFont);
		btnsHideShow2.setBorder(First.border);
		btnsHideShow2.setBackground(First.greenC);
		btnsHideShow2.setForeground(First.lightC);
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
				btnsHideShow2.setBackground(First.greenC);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnsHideShow2.setBackground(First.greenD);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnsHideShow2.setUI(new MetalToggleButtonUI() {
			@Override
			protected Color getSelectColor() {
				return First.redC;
			}
		});
		btnsHideShow2.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					btnsHideShow2.setText(idiomaString(language)[12]);
				else
					btnsHideShow2.setText(idiomaString(language)[11]);
			}
		});

		// OPTION 5 AUTOSAVE
		JLabel op5 = new JLabel(idiomaString(language)[8]);
		op5.setBounds(50, 230, 200, 40);
		op5.setFont(First.myFont);
		JToggleButton btnsHideShow3 = new JToggleButton();
		if (conf[4] == null || conf[4].equals("false")) {
			btnsHideShow3.setText(idiomaString(language)[11]);
		} else {
			btnsHideShow3.setText(idiomaString(language)[12]);
			btnsHideShow3.setSelected(true);
		}
		btnsHideShow3.setBounds(415, 230, 80, 40);
		btnsHideShow3.setFont(First.myFont);
		btnsHideShow3.setBorder(First.border);
		btnsHideShow3.setBackground(First.greenC);
		btnsHideShow3.setForeground(First.lightC);
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
				btnsHideShow3.setBackground(First.greenC);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnsHideShow3.setBackground(First.greenD);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnsHideShow3.setUI(new MetalToggleButtonUI() {
			@Override
			protected Color getSelectColor() {
				return First.redC;
			}
		});
		btnsHideShow3.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					btnsHideShow3.setText(idiomaString(language)[12]);
				else
					btnsHideShow3.setText(idiomaString(language)[11]);
			}
		});

		// Bottom line
		JButton defSet = new JButton(idiomaString(language)[9]);
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
				Reales.this.setIconImage(iconImages[0].getImage());// icon
				conf[1] = "0";// btn hide
				btnsHideShow2.setText(idiomaString(language)[11]);// key shortcut
				btnsHideShow2.setSelected(false);// key shortcut
				conf[3] = "0";// res
//				opResolution(clearEverthing, pesosF, notasF, newDay, resoD, aggPanel, gastosPanel);// res
				btnsHideShow3.setText(idiomaString(language)[11]);// autosave
				btnsHideShow3.setSelected(false);// autosave
				conf[6] = "1";// speed
				lang.setSelectedIndex(0);// lan
				conf[8] = "0";// eff
			}
		});
		// SAVE
		JButton save = new JButton(idiomaString(language)[10]);
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
					savedF.write(btnsHideShow2.isSelected() + System.lineSeparator());// key shortcut
					savedF.write((conf[3].equals("null") ? 0 : conf[3]) + System.lineSeparator());// res
					savedF.write(btnsHideShow3.isSelected() + System.lineSeparator());// autosave
					savedF.write((conf[5].equals("null") ? 0 : conf[5]) + System.lineSeparator());// first frame to open
					savedF.write((conf[6].equals("null") ? 0 : conf[6]) + System.lineSeparator());// speed
					savedF.write(lang.getSelectedIndex() + System.lineSeparator());// lan
					savedF.write((conf[8].equals("null") ? 0 : conf[8]) + System.lineSeparator());// effchooser
					savedF.write((conf[9].equals("null") ? "1,1" : conf[9]) + System.lineSeparator());// intro
					savedF.close();
				} catch (Exception e2) {
					JOptionPane opt = new JOptionPane(
							language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
							JOptionPane.ERROR_MESSAGE);
					opt.show();
				}
				temp.dispose();
				Reales.this.dispose();
				new Reales();
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
		temp.add(btnsHideShow3);
		temp.add(defSet);
		temp.add(save);
		temp.setVisible(true);
	}

	// Hide/show the buttons
	private void hideBtn(JButton notasF, JButton pesosF, JButton newDay, JButton clearEverthing, JMenuItem hideBtn) {
		pesosF.hide();
		clearEverthing.hide();
		notasF.hide();
	}

	// Clear all
	private void clearAll() {
		int op = JOptionPane.showConfirmDialog(null, idiomaString(language)[18], idiomaString(language)[19],
				JOptionPane.OK_CANCEL_OPTION);
		if (op == 0) {
			for (int i = 0; i < 6; i++)
				for (int j = 0; j < 20; j++)
					details[i][j].setText("");
			initialDay.setText("");
			for (int i = 0; i < 16; i++) {
				gastosTable[i].setText("");
				agregadoTable[i].setText("");
				gTable[i].setText("");
				aTable[i].setText("");
			}
			for (int i = 0; i < 11; i++)
				panelCnum[i].setText("");
			sumF();
		}
	}

	// NEW DAY
	private void newDay() {
		int op = JOptionPane.showConfirmDialog(null, idiomaString(language)[16], idiomaString(language)[17],
				JOptionPane.OK_CANCEL_OPTION);
		if (op == 0) {
			exBtn(language);
			// save what will rest for tmrw
			BufferedReader data23 = null;
			String l23 = "";
			tempFile0.mkdir();
			File temp23 = new File(tempFile0 + "\\extra");
			temp23.mkdir();
			File file23 = new File(temp23, yearS + ".dll");
			ArrayList<String> con23 = new ArrayList<String>();
			try {
				data23 = new BufferedReader(new FileReader(file23));
				while ((l23 = data23.readLine()) != null) {
					con23.add(l23.toString());
				}
				data23.close();
			} catch (Exception e) {
				JOptionPane opt = new JOptionPane(
						language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
						JOptionPane.ERROR_MESSAGE);
				opt.show();
			}
			try {
				FileWriter save23 = new FileWriter(file23);
				for (int i = 0; i < con23.size(); i++)
					save23.write(con23.get(i) + System.lineSeparator());
				save23.write((pix + totalVenta) + System.lineSeparator());// icon
				save23.close();
			} catch (Exception e2) {
				JOptionPane opt = new JOptionPane(
						language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
						JOptionPane.ERROR_MESSAGE);
				opt.show();
			}
			// cajas values
			for (int i = 0; i < 6; i++)// table detail
				for (int j = 0; j < 20; j++)
					details[i][j].setText("");
			initialDay.setText(restN + "");
			for (int i = 0; i < 16; i++) {// gastos nad agregados
				gastosTable[i].setText("");
				agregadoTable[i].setText("");
				gTable[i].setText("");
				aTable[i].setText("");
			}
			for (int i = 0; i < 5; i++)// set of 1000 -> 50
				panelCnum[i].setText("");
			panelCnum[5].setText("" + nbOf20);// if there are more than 200 menos 20
			panelCnum[10].setText("");// pix
			sumF();
		}
	}

	// saveProgress
	private static void saveProgress() {
		try {
			String currentpath = System.getProperty("user.dir");
			File tempFile0 = new File(currentpath + "\\data");
			tempFile0.mkdir();
			File newFile = new File(tempFile0, "cedros.dll");
			FileWriter savedF = new FileWriter(newFile);
			for (int i = 0; i < 6; i++)
				for (int j = 0; j < 20; j++)
					savedF.write(details[i][j].getText() + System.lineSeparator());
			savedF.write(initialDay.getText() + System.lineSeparator());
			for (int i = 0; i < 16; i++)
				savedF.write(gastosTable[i].getText() + System.lineSeparator());
			for (int i = 0; i < 16; i++)
				savedF.write(agregadoTable[i].getText() + System.lineSeparator());
			for (int i = 0; i < 11; i++)
				savedF.write(panelCnum[i].getText() + System.lineSeparator());
			savedF.close();
		} catch (Exception e) {
		}
	}

	// Open Progress
	private void openProgress() {
		BufferedReader dataOpened = null;
		String line = "";
		int z = 0;
		String numbers[] = new String[165];
		tempFile0.mkdir();
		File newFile = new File(tempFile0, "cedros.dll");
		try {
			dataOpened = new BufferedReader(new FileReader(newFile));
			while ((line = dataOpened.readLine()) != null) {
				numbers[z] = line.toString();
				z++;
			}
			z = 0;
			for (int i = 0; i < 6; i++)
				for (int k = 0; k < 20; k++) {
					details[i][k].setText(numbers[z]);
					z++;
				}
			initialDay.setText(numbers[z]);
			z++;
			for (int i = 0; i < 16; i++) {
				gTable[i].setText(numbers[z]);
				gastosTable[i].setText(numbers[z]);
				z++;
			}
			for (int i = 0; i < 16; i++) {
				aTable[i].setText(numbers[z]);
				agregadoTable[i].setText(numbers[z]);
				z++;
			}
			for (int i = 0; i < 11; i++) {
				panelCnum[i].setText(numbers[z]);
				z++;
			}
			dataOpened.close();
		} catch (Exception e) {
			JOptionPane opt = new JOptionPane(
					language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
					JOptionPane.ERROR_MESSAGE);
			opt.show();
		}
	}

	// Calculate everything
	private void sumF() {
		for (int i = 0; i < 4; i++) {
			gTable[i].setText(gastosTable[i].getText());
			aTable[i].setText(agregadoTable[i].getText());
		}
		for (int i = 8; i < 12; i++) {
			gTable[i].setText(gastosTable[i].getText());
			aTable[i].setText(agregadoTable[i].getText());
		}
		if (conf[4] == null || conf[4].equals("false"))
			saveProgress();
		for (int i = 0; i < 11; i++)// Caja empty values 0
			if (!First.isNumeric(panelCnum[i].getText())
					|| (First.isNumeric(panelCnum[i].getText()) && Integer.valueOf(panelCnum[i].getText()) < 0))
				panelCnum[i].setText(0 + "");
		if (!First.isNumeric(initialDay.getText())
				|| (First.isNumeric(initialDay.getText()) && Integer.valueOf(initialDay.getText()) < 0))// initial of //
																										// // the day 0
			initialDay.setText(0 + "");
		for (int i = 8; i < 16; i++)// spent 0
			if (!First.isNumeric(gastosTable[i].getText())
					|| (First.isNumeric(gastosTable[i].getText()) && Integer.valueOf(gastosTable[i].getText()) < 0))
				gastosTable[i].setText("");
		for (int i = 8; i < 16; i++)// added 0
			if (!First.isNumeric(agregadoTable[i].getText())
					|| (First.isNumeric(agregadoTable[i].getText()) && Integer.valueOf(agregadoTable[i].getText()) < 0))
				agregadoTable[i].setText("");
		for (int i = 0; i < 8; i++) {// TitleCase gastos and agg
			gastosTable[i].setText(First.capitalizeString(gastosTable[i].getText()));
			gTable[i].setText(First.capitalizeString(gTable[i].getText()));
			agregadoTable[i].setText(First.capitalizeString(agregadoTable[i].getText()));
			aTable[i].setText(First.capitalizeString(aTable[i].getText()));
		}
		// Add set of 1000
		int numMil = Integer.valueOf(panelCnum[2].getText()) * 200 + Integer.valueOf(panelCnum[3].getText()) * 100
				+ Integer.valueOf(panelCnum[4].getText()) * 50;
		int counter = 0;
		if (Integer.valueOf(panelCnum[4].getText()) == 0)
			while (numMil >= 1000) {
				numMil -= 1000;
				counter++;
			}
		else
			while (numMil > 1000) {
				numMil -= 1000;
				counter++;
			}
		if (counter > 0) {
			aggBtn[0].show();
			aggBtn[0].setText(idiomaString(language)[20] + counter);
		} else
			aggBtn[0].hide();
		// Add set of 100
		int numHund = Integer.valueOf(panelCnum[5].getText()) * 20;
		counter = 0;
		while (numHund > 100) {
			numHund -= 100;
			counter++;
		}
		if (counter > 0) {
			aggBtn[1].show();
			aggBtn[1].setText(idiomaString(language)[20] + counter);
		} else
			aggBtn[1].hide();
		// Calculate the totals
		totalVenta = 0;
		for (int i = 0; i < 6; i++) {
			totalCol = 0;
			for (int j = 0; j < 20; j++) {
				if (!First.isNumeric(details[i][j].getText())
						|| (First.isNumeric(details[i][j].getText()) && Integer.valueOf(details[i][j].getText()) < 0)) {
					details[i][j].setText("");
					totalCol += 0;
				} else
					totalCol += Integer.valueOf(details[i][j].getText());
			}
			total[i].setText(totalCol + "");
			totalVenta += Integer.valueOf(total[i].getText());
		}
		total[6].setText("R$" + totalVenta);
		// Calculate total of spent
		gastosT = ((gastosTable[8].getText().equals("") ? 0 : Integer.valueOf(gastosTable[8].getText()))
				+ (gastosTable[9].getText().equals("") ? 0 : Integer.valueOf(gastosTable[9].getText()))
				+ (gastosTable[10].getText().equals("") ? 0 : Integer.valueOf(gastosTable[10].getText()))
				+ (gastosTable[11].getText().equals("") ? 0 : Integer.valueOf(gastosTable[11].getText()))
				+ (gastosTable[12].getText().equals("") ? 0 : Integer.valueOf(gastosTable[12].getText()))
				+ (gastosTable[13].getText().equals("") ? 0 : Integer.valueOf(gastosTable[13].getText()))
				+ (gastosTable[14].getText().equals("") ? 0 : Integer.valueOf(gastosTable[14].getText()))
				+ (gastosTable[15].getText().equals("") ? 0 : Integer.valueOf(gastosTable[15].getText())));
		summaryT[5].setText("" + gastosT);
		// Calculate total of added
		agregadoT = ((agregadoTable[8].getText().equals("") ? 0 : Integer.valueOf(agregadoTable[8].getText()))
				+ (agregadoTable[9].getText().equals("") ? 0 : Integer.valueOf(agregadoTable[9].getText()))
				+ (agregadoTable[10].getText().equals("") ? 0 : Integer.valueOf(agregadoTable[10].getText()))
				+ (agregadoTable[11].getText().equals("") ? 0 : Integer.valueOf(agregadoTable[11].getText()))
				+ (agregadoTable[12].getText().equals("") ? 0 : Integer.valueOf(agregadoTable[12].getText()))
				+ (agregadoTable[13].getText().equals("") ? 0 : Integer.valueOf(agregadoTable[13].getText()))
				+ (agregadoTable[14].getText().equals("") ? 0 : Integer.valueOf(agregadoTable[14].getText()))
				+ (agregadoTable[15].getText().equals("") ? 0 : Integer.valueOf(agregadoTable[15].getText())));
		summaryT[6].setText("" + agregadoT);
		summaryT[7].setText("" + totalVenta);// Total of sells
		// Calculate total
		totalO = ((initialDay.getText().equals("") ? 0 : Integer.valueOf(initialDay.getText())) - gastosT + agregadoT
				+ totalVenta);
		summaryT[8].setText("" + totalO);
		// Calculate total of caja
		totalCaja = ((panelCnum[0].getText().equals("") ? 0 : Integer.valueOf(panelCnum[0].getText()) * 1000)
				+ (panelCnum[1].getText().equals("") ? 0 : Integer.valueOf(panelCnum[1].getText()) * 100)
				+ (panelCnum[2].getText().equals("") ? 0 : Integer.valueOf(panelCnum[2].getText()) * 200)
				+ (panelCnum[3].getText().equals("") ? 0 : Integer.valueOf(panelCnum[3].getText()) * 100)
				+ (panelCnum[4].getText().equals("") ? 0 : Integer.valueOf(panelCnum[4].getText()) * 50)
				+ (panelCnum[5].getText().equals("") ? 0 : Integer.valueOf(panelCnum[5].getText()) * 20)
				+ (panelCnum[6].getText().equals("") ? 0 : Integer.valueOf(panelCnum[6].getText()) * 10)
				+ (panelCnum[7].getText().equals("") ? 0 : Integer.valueOf(panelCnum[7].getText()) * 5)
				+ (panelCnum[8].getText().equals("") ? 0 : Integer.valueOf(panelCnum[8].getText()) * 2)
				+ (panelCnum[9].getText().equals("") ? 0 : Integer.valueOf(panelCnum[9].getText()) * 1));
		total[7].setText("R$" + totalCaja);
		pix = panelCnum[10].getText().equals("") ? 0 : Integer.valueOf(panelCnum[10].getText());
		// Calculate the diferencia
		if (totalCaja == totalO) {
			diffResult[1].setText(idiomaString(language)[21]);
			diffResult[1].setBackground(First.greenD);
			diffResult[1].setForeground(Color.white);
		} else {
			if (totalCaja > totalO) {
				diffResult[1].setText(idiomaString(language)[22] + (totalCaja - totalO));
				diffResult[1].setBackground(Color.orange);
				diffResult[1].setForeground(Color.black);
			} else {
				diffResult[1].setText(idiomaString(language)[23] + (totalO - totalCaja));
				diffResult[1].setBackground(First.redD);
				diffResult[1].setForeground(Color.white);
			}
		}
		// Calculate the restTmrw
		restN = totalCaja - Integer.valueOf(panelCnum[0].getText()) * 1000
				- Integer.valueOf(panelCnum[1].getText()) * 100 - Integer.valueOf(panelCnum[2].getText()) * 200
				- Integer.valueOf(panelCnum[3].getText()) * 100 - Integer.valueOf(panelCnum[4].getText()) * 50;
		nbOf20 = Integer.valueOf(panelCnum[5].getText());
		if (!dayS.equals("VIERNES") && !dayS.equals("FRIDAY") && !dayS.equals("SEXTA-FEIRA"))
			while (restN > 200 && nbOf20 > 1) {
				restN -= 20;
				nbOf20--;
			}
		restTmrw.setText("R$" + restN);
		restTmrw.setForeground(Color.black);
		restTmrw.setBackground(First.lightC);
	}

	// Resolution X-small
	private void resXP(JMenuItem resoD, JMenuItem resoXP, JMenuItem resoP, JMenuItem resoM, JMenuItem resoG,
			JButton notasF, JButton pesosF, JButton newDay, JButton clearEverthing, JButton gastosPanel,
			JButton aggPanel) {
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
		else if (this.getWidth() == 1000)
			resoD.setEnabled(false);
		else
			resoD.setEnabled(true);
		First.myFont = new Font("Tahoma", Font.BOLD, 16);
		First.myFontS = new Font("Tahoma", Font.BOLD, 12);
		for (int i = 0; i < 6; i++) {
			boletoN[i].setBounds(30 + i * 55, 25, 55, 30);
			boletoN[i].setFont(First.myFont);
			total[i].setBounds(30 + i * 55, 500, 55, 24);
			total[i].setFont(First.myFont);
			for (int j = 0; j < 20; j++) {
				details[i][j].setFont(First.myFontS);
				details[i][j].setBounds(30 + i * 55, 55 + j * 22, 55, 22);
			}
		}
		total[6].setBounds(390, 500, 80, 25);
		total[8].setBounds(390, 475, 80, 25);
		total[6].setFont(First.myFont);
		total[8].setFont(First.myFont);
		initialDay.setBounds(520, 50, 70, 30);
		initialDay.setFont(First.myFont);
		date.setFont(First.myFont);
		date.setBounds(500, 10, 305, 25);
		for (int i = 0; i < 5; i++) {
			summaryT[i].setBounds(420, 50 + i * 30, 100, 30);
			summaryT[i].setFont(First.myFont);
		}
		for (int i = 5; i < 9; i++) {
			summaryT[i].setBounds(520, 50 + (i - 4) * 30, 70, 30);
			summaryT[i].setFont(First.myFont);
		}
		gastosPanel.setBounds(620, 200, 150, 20);
		gastosPanel.setFont(First.myFont);
		gastos.setBounds(620, 50, 150, 30);
		gastos.setFont(First.myFont);
		aggPanel.setBounds(800, 200, 150, 20);
		aggPanel.setFont(First.myFont);
		agregado.setBounds(800, 50, 150, 30);
		agregado.setFont(First.myFont);
		for (int i = 0; i < 4; i++) {
			gastosTable[i].setBounds(620, 80 + 30 * i, 100, 30);
			agregadoTable[i].setBounds(800, 80 + 30 * i, 100, 30);
			gastosTable[i].setFont(First.myFontS);
			agregadoTable[i].setFont(First.myFontS);
		}
		for (int i = 8; i < 12; i++) {
			gastosTable[i].setBounds(720, 80 + 30 * (i - 8), 50, 30);
			gastosTable[i].setFont(First.myFontS);
			agregadoTable[i].setBounds(900, 80 + 30 * (i - 8), 50, 30);
			agregadoTable[i].setFont(First.myFontS);
		}
		for (int i = 0; i < 10; i++) {
			panelFoto[i].setBounds(400 + 50 * i, 260, 50, 40);
			panelCnum[i].setBounds(400 + 50 * i, 300, 50, 40);
			panelCnum[i].setFont(First.myFont);
			switch (i) {
			case 0:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i1000.getImage(), 50, 40)));
				break;
			case 1:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(iS100.getImage(), 50, 40)));
				break;
			case 2:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i200.getImage(), 50, 40)));
				break;
			case 3:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i100.getImage(), 50, 40)));
				break;
			case 4:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i50.getImage(), 50, 40)));
				break;
			case 5:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i20.getImage(), 50, 40)));
				break;
			case 6:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 50, 40)));
				break;
			case 7:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 50, 40)));
				break;
			case 8:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 50, 40)));
				break;
			case 9:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 50, 40)));
				break;
			default:
				break;
			}
		}
		plusSymbol.setBounds(900, 275, 50, 50);
		plusSymbol.setFont(First.myFont);
		panelFoto[10].setIcon(new ImageIcon(getScaledImage(pixI.getImage(), 45, 35)));
		panelFoto[10].setBounds(915, 260, 50, 40);
		panelCnum[10].setBounds(915, 300, 50, 40);
		panelCnum[10].setFont(First.myFont);
		aggBtn[0].setBounds(400, 240, 50, 20);
		aggBtn[1].setBounds(450, 240, 50, 20);
		total[7].setBounds(400, 340, 500, 40);
		diffResult[0].setBounds(500, 430, 150, 35);
		diffResult[1].setBounds(500, 464, 150, 35);
		newDay.setBounds(750, 430, 150, 45);
		restTmrw.setBounds(750, 474, 150, 30);
		notasF.setBounds(920, 440, 50, 50);
		pesosF.setBounds(675, 440, 50, 50);
		clearEverthing.setBounds(405, 405, 50, 50);
		aggBtn[0].setFont(First.myFontS);
		aggBtn[1].setFont(First.myFontS);
		total[7].setFont(First.myFont);
		diffResult[0].setFont(First.myFont);
		diffResult[1].setFont(First.myFont);
		restTmrw.setFont(First.myFont);
		newDay.setFont(First.myFont);
		notasF.setIcon(new ImageIcon(getScaledImage(notasI.getImage(), 50, 50)));
		pesosF.setIcon(new ImageIcon(getScaledImage(pesosI.getImage(), 50, 50)));
		clearEverthing.setIcon(new ImageIcon(getScaledImage(clear.getImage(), 50, 50)));
	}

	// Resolution small
	private void resP(JMenuItem resoD, JMenuItem resoXP, JMenuItem resoP, JMenuItem resoM, JMenuItem resoG,
			JButton notasF, JButton pesosF, JButton newDay, JButton clearEverthing, JButton gastosPanel,
			JButton aggPanel) {
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
		else if (this.getWidth() == 1000)
			resoD.setEnabled(false);
		else
			resoD.setEnabled(true);
		First.myFont = new Font("Tahoma", Font.BOLD, 18);
		First.myFontS = new Font("Tahoma", Font.BOLD, 15);
		for (int i = 0; i < 6; i++) {
			boletoN[i].setBounds(30 + i * 70, 25, 70, 30);
			boletoN[i].setFont(First.myFont);
			total[i].setBounds(30 + i * 70, 585, 70, 29);
			total[i].setFont(First.myFont);
			for (int j = 0; j < 20; j++) {
				details[i][j].setBounds(30 + i * 70, 55 + j * 26, 70, 26);
				details[i][j].setFont(First.myFontS);
			}
		}
		total[6].setBounds(475, 578, 88, 35);
		total[8].setBounds(475, 548, 88, 30);
		initialDay.setBounds(640, 50, 80, 40);
		total[6].setFont(First.myFont);
		initialDay.setFont(First.myFont);
		total[8].setFont(First.myFont);
		date.setFont(First.myFont);
		date.setBounds(650, 10, 320, 30);
		for (int i = 0; i < 5; i++) {
			summaryT[i].setBounds(520, 50 + i * 40, 120, 40);
			summaryT[i].setFont(First.myFont);
		}
		for (int i = 5; i < 9; i++) {
			summaryT[i].setBounds(640, 50 + (i - 4) * 40, 80, 40);
			summaryT[i].setFont(First.myFont);
		}
		gastosPanel.setBounds(780, 250, 210, 30);
		gastosPanel.setFont(First.myFont);
		gastos.setBounds(780, 50, 210, 40);
		gastos.setFont(First.myFont);
		aggPanel.setBounds(1030, 250, 210, 30);
		aggPanel.setFont(First.myFont);
		agregado.setBounds(1030, 50, 210, 40);
		agregado.setFont(First.myFont);
		for (int i = 0; i < 4; i++) {
			gastosTable[i].setBounds(780, 90 + 40 * i, 150, 40);
			agregadoTable[i].setBounds(1030, 90 + 40 * i, 150, 40);
			gastosTable[i].setFont(First.myFont);
			agregadoTable[i].setFont(First.myFont);
		}
		for (int i = 8; i < 12; i++) {
			gastosTable[i].setBounds(930, 90 + 40 * (i - 8), 60, 40);
			gastosTable[i].setFont(First.myFontS);
			agregadoTable[i].setBounds(1180, 90 + 40 * (i - 8), 60, 40);
			agregadoTable[i].setFont(First.myFontS);
		}
		for (int i = 0; i < 10; i++) {
			panelFoto[i].setBounds(580 + 60 * i, 320, 60, 40);
			panelCnum[i].setBounds(580 + 60 * i, 360, 60, 40);
			panelCnum[i].setFont(First.myFont);
			switch (i) {
			case 0:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i1000.getImage(), 60, 40)));
				break;
			case 1:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(iS100.getImage(), 60, 40)));
				break;
			case 2:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i200.getImage(), 60, 40)));
				break;
			case 3:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i100.getImage(), 60, 40)));
				break;
			case 4:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i50.getImage(), 60, 40)));
				break;
			case 5:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i20.getImage(), 60, 40)));
				break;
			case 6:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 60, 40)));
				break;
			case 7:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 60, 40)));
				break;
			case 8:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 60, 40)));
				break;
			case 9:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 60, 40)));
				break;
			default:
				break;
			}
		}
		plusSymbol.setBounds(1182, 335, 50, 50);
		plusSymbol.setFont(First.myFont);
		panelFoto[10].setIcon(new ImageIcon(getScaledImage(pixI.getImage(), 55, 35)));
		panelFoto[10].setBounds(1200, 320, 60, 40);
		panelCnum[10].setBounds(1200, 360, 60, 40);
		panelCnum[10].setFont(First.myFont);
		aggBtn[0].setBounds(580, 300, 60, 20);
		aggBtn[1].setBounds(640, 300, 60, 20);
		total[7].setBounds(580, 400, 600, 40);
		diffResult[0].setBounds(620, 490, 200, 45);
		diffResult[1].setBounds(620, 534, 200, 45);
		newDay.setBounds(950, 490, 210, 55);
		restTmrw.setBounds(950, 544, 210, 35);
		notasF.setBounds(1190, 510, 60, 60);
		pesosF.setBounds(855, 510, 60, 60);
		clearEverthing.setBounds(490, 470, 60, 60);
		aggBtn[0].setFont(First.myFontS);
		aggBtn[1].setFont(First.myFontS);
		total[7].setFont(First.myFont);
		diffResult[0].setFont(First.myFont);
		diffResult[1].setFont(First.myFont);
		restTmrw.setFont(First.myFont);
		newDay.setFont(First.myFont);
		notasF.setIcon(new ImageIcon(getScaledImage(notasI.getImage(), 60, 60)));
		pesosF.setIcon(new ImageIcon(getScaledImage(pesosI.getImage(), 60, 60)));
		clearEverthing.setIcon(new ImageIcon(getScaledImage(clear.getImage(), 60, 60)));
	}

	// Resolution meduim
	private void resM(JMenuItem resoD, JMenuItem resoXP, JMenuItem resoP, JMenuItem resoM, JMenuItem resoG,
			JButton notasF, JButton pesosF, JButton newDay, JButton clearEverthing, JButton gastosPanel,
			JButton aggPanel) {
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
		else if (this.getWidth() == 1000)
			resoD.setEnabled(false);
		else
			resoD.setEnabled(true);
		First.myFont = new Font("Tahoma", Font.BOLD, 21);
		First.myFontS = new Font("Tahoma", Font.BOLD, 17);
		for (int i = 0; i < 6; i++) {
			boletoN[i].setBounds(30 + i * 80, 25, 80, 30);
			boletoN[i].setFont(First.myFont);
			total[i].setBounds(30 + i * 80, 685, 80, 32);
			total[i].setFont(First.myFont);
			for (int j = 0; j < 20; j++) {
				details[i][j].setBounds(30 + i * 80, 55 + j * 31, 80, 31);
				details[i][j].setFont(First.myFontS);
			}
		}
		total[6].setBounds(540, 678, 100, 35);
		total[8].setBounds(540, 648, 100, 30);
		total[6].setFont(First.myFont);
		initialDay.setFont(First.myFont);
		total[8].setFont(First.myFont);
		date.setFont(First.myFont);
		date.setBounds(700, 10, 360, 30);
		for (int i = 0; i < 5; i++) {
			summaryT[i].setFont(First.myFont);
			summaryT[i].setBounds(570, 50 + i * 50, 140, 50);
		}
		initialDay.setBounds(710, 50, 90, 50);
		for (int i = 5; i < 9; i++) {
			summaryT[i].setFont(First.myFont);
			summaryT[i].setBounds(710, 50 + (i - 4) * 50, 90, 50);
		}
		gastosPanel.setBounds(870, 300, 230, 35);
		gastosPanel.setFont(First.myFont);
		gastos.setBounds(870, 50, 230, 50);
		gastos.setFont(First.myFont);
		aggPanel.setBounds(1170, 300, 230, 35);
		aggPanel.setFont(First.myFont);
		agregado.setBounds(1170, 50, 230, 50);
		agregado.setFont(First.myFont);
		for (int i = 0; i < 4; i++) {
			gastosTable[i].setBounds(870, 100 + 50 * i, 160, 50);
			gastosTable[i].setFont(First.myFont);
			agregadoTable[i].setBounds(1170, 100 + 50 * i, 160, 50);
			agregadoTable[i].setFont(First.myFont);
		}
		for (int i = 8; i < 12; i++) {
			gastosTable[i].setBounds(1030, 100 + 50 * (i - 8), 70, 50);
			gastosTable[i].setFont(First.myFontS);
			agregadoTable[i].setBounds(1330, 100 + 50 * (i - 8), 70, 50);
			agregadoTable[i].setFont(First.myFontS);
		}
		// Caja
		for (int i = 0; i < 10; i++) {
			panelFoto[i].setBounds(640 + 70 * i, 380, 70, 50);
			panelCnum[i].setBounds(640 + 70 * i, 430, 70, 50);
			panelCnum[i].setFont(First.myFont);
			switch (i) {
			case 0:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i1000.getImage(), 70, 50)));
				break;
			case 1:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(iS100.getImage(), 70, 50)));
				break;
			case 2:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i200.getImage(), 70, 50)));
				break;
			case 3:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i100.getImage(), 70, 50)));
				break;
			case 4:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i50.getImage(), 70, 50)));
				break;
			case 5:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i20.getImage(), 70, 50)));
				break;
			case 6:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 70, 50)));
				break;
			case 7:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 70, 50)));
				break;
			case 8:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 70, 50)));
				break;
			case 9:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 70, 50)));
				break;
			default:
				break;
			}
		}
		plusSymbol.setBounds(1341, 405, 50, 50);
		plusSymbol.setFont(First.myFont);
		panelFoto[10].setIcon(new ImageIcon(getScaledImage(pixI.getImage(), 65, 45)));
		panelFoto[10].setBounds(1360, 380, 70, 50);
		panelCnum[10].setBounds(1360, 430, 70, 50);
		panelCnum[10].setFont(First.myFont);
		aggBtn[0].setBounds(640, 351, 70, 30);
		aggBtn[1].setBounds(710, 351, 70, 30);
		total[7].setBounds(640, 480, 700, 50);
		diffResult[0].setBounds(680, 570, 250, 55);
		diffResult[1].setBounds(680, 624, 250, 55);
		newDay.setBounds(1070, 570, 250, 65);
		restTmrw.setBounds(1070, 634, 250, 45);
		notasF.setBounds(1360, 580, 80, 80);
		pesosF.setBounds(960, 590, 70, 70);
		clearEverthing.setBounds(560, 550, 70, 70);
		aggBtn[0].setFont(First.myFontS);
		aggBtn[1].setFont(First.myFontS);
		total[7].setFont(First.myFont);
		diffResult[0].setFont(First.myFont);
		diffResult[1].setFont(First.myFont);
		restTmrw.setFont(First.myFont);
		newDay.setFont(First.myFont);
		notasF.setIcon(new ImageIcon(getScaledImage(notasI.getImage(), 80, 80)));
		pesosF.setIcon(new ImageIcon(getScaledImage(pesosI.getImage(), 70, 70)));
		clearEverthing.setIcon(new ImageIcon(getScaledImage(clear.getImage(), 70, 70)));
	}

	// Resolution large
	private void resG(JMenuItem resoD, JMenuItem resoXP, JMenuItem resoP, JMenuItem resoM, JMenuItem resoG,
			JButton notasF, JButton pesosF, JButton newDay, JButton clearEverthing, JButton gastosPanel,
			JButton aggPanel) {
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
		else if (this.getWidth() == 1000)
			resoD.setEnabled(false);
		else
			resoD.setEnabled(true);

		First.myFont = new Font("Tahoma", Font.BOLD, 24);
		First.myFontS = new Font("Tahoma", Font.BOLD, 20);
		for (int i = 0; i < 6; i++) {
			boletoN[i].setBounds(30 + i * 90, 30, 90, 40);
			boletoN[i].setFont(First.myFontS);
			total[i].setBounds(30 + i * 90, 860, 90, 40);
			total[i].setFont(First.myFontS);
			for (int j = 0; j < 20; j++) {
				details[i][j].setBounds(30 + i * 90, 65 + j * 39, 90, 39);
				details[i][j].setFont(First.myFontS);
			}
		}
		total[6].setBounds(610, 845, 125, 45);
		total[8].setBounds(610, 805, 125, 40);
		total[6].setFont(First.myFont);
		initialDay.setFont(First.myFont);
		total[8].setFont(First.myFont);
		date.setFont(First.myFont);
		date.setBounds(900, 10, 400, 30);
		for (int i = 0; i < 5; i++) {
			summaryT[i].setBounds(700, 50 + i * 60, 160, 60);
			summaryT[i].setFont(First.myFont);
		}
		initialDay.setBounds(860, 50, 110, 60);
		for (int i = 5; i < 9; i++) {
			summaryT[i].setBounds(860, 50 + (i - 4) * 60, 110, 60);
			summaryT[i].setFont(First.myFont);
		}
		gastosPanel.setBounds(1100, 350, 270, 50);
		gastosPanel.setFont(First.myFont);
		gastos.setBounds(1100, 50, 270, 60);
		gastos.setFont(First.myFont);
		aggPanel.setBounds(1500, 350, 270, 50);
		aggPanel.setFont(First.myFont);
		agregado.setBounds(1500, 50, 270, 60);
		agregado.setFont(First.myFont);
		for (int i = 0; i < 4; i++) {
			gastosTable[i].setBounds(1100, 110 + 60 * i, 180, 60);
			agregadoTable[i].setBounds(1500, 110 + 60 * i, 180, 60);
			gastosTable[i].setFont(First.myFontS);
			agregadoTable[i].setFont(First.myFontS);
		}
		for (int i = 8; i < 12; i++) {
			gastosTable[i].setBounds(1280, 110 + 60 * (i - 8), 90, 60);
			gastosTable[i].setFont(First.myFontS);
			agregadoTable[i].setBounds(1680, 110 + 60 * (i - 8), 90, 60);
			agregadoTable[i].setFont(First.myFontS);
		}
		for (int i = 0; i < 10; i++) {
			panelFoto[i].setBounds(800 + 80 * i, 470, 80, 60);
			panelCnum[i].setBounds(800 + 80 * i, 530, 80, 60);
			panelCnum[i].setFont(First.myFont);
			switch (i) {
			case 0:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i1000.getImage(), 80, 60)));
				break;
			case 1:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(iS100.getImage(), 80, 60)));
				break;
			case 2:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i200.getImage(), 80, 60)));
				break;
			case 3:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i100.getImage(), 80, 60)));
				break;
			case 4:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i50.getImage(), 80, 60)));
				break;
			case 5:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i20.getImage(), 80, 60)));
				break;
			case 6:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 80, 60)));
				break;
			case 7:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 80, 60)));
				break;
			case 8:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 80, 60)));
				break;
			case 9:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 80, 60)));
				break;
			default:
				break;
			}
		}
		plusSymbol.setBounds(1602, 480, 80, 80);
		plusSymbol.setFont(First.myFont);
		panelFoto[10].setIcon(new ImageIcon(getScaledImage(pixI.getImage(), 75, 55)));
		panelFoto[10].setBounds(1620, 470, 80, 60);
		panelCnum[10].setBounds(1620, 530, 80, 60);
		panelCnum[10].setFont(First.myFont);
		total[7].setBounds(800, 590, 800, 60);
		aggBtn[0].setBounds(800, 432, 80, 40);
		aggBtn[1].setBounds(880, 432, 80, 40);
		diffResult[0].setBounds(850, 700, 250, 65);
		diffResult[1].setBounds(850, 764, 250, 65);
		newDay.setBounds(1270, 700, 300, 75);
		restTmrw.setBounds(1270, 774, 300, 55);
		notasF.setBounds(1650, 700, 100, 100);
		pesosF.setBounds(1140, 730, 80, 80);
		clearEverthing.setBounds(640, 690, 80, 80);
		aggBtn[0].setFont(First.myFontS);
		aggBtn[1].setFont(First.myFontS);
		total[7].setFont(First.myFont);
		diffResult[0].setFont(First.myFont);
		diffResult[1].setFont(First.myFont);
		restTmrw.setFont(First.myFontS);
		newDay.setFont(First.myFont);
		notasF.setIcon(new ImageIcon(getScaledImage(notasI.getImage(), 100, 100)));
		pesosF.setIcon(new ImageIcon(getScaledImage(pesosI.getImage(), 80, 80)));
		clearEverthing.setIcon(new ImageIcon(getScaledImage(clear.getImage(), 80, 80)));
	}

	private void idiomaTexts(int idioma, JMenuItem hideBtn, JMenuItem noHide, JMenuItem hideDate, JMenuItem hideAll,
			JButton notasF, JButton newDay, JMenuItem resoD, JButton aggPanel, JButton gastosPanel, JMenu file,
			JMenuItem novo, JMenuItem clear, JMenuItem calc, JMenuItem save, JMenuItem screenShot, JMenuItem option,
			JMenuItem exit, JMenu summary, JMenuItem sumV, JMenu effectChooser, JMenuItem sumV1, JMenuItem sumV2,
			JMenuItem sumV3, JMenuItem exMenu, JMenu speedChooser, JMenuItem speed1, JMenuItem speed2, JMenuItem speed3,
			JMenu goTo, JMenuItem pesos, JMenuItem fatura, JMenuItem firstFrame, JMenu reso, JMenuItem reso1,
			JMenuItem reso2, JMenuItem reso3, JMenuItem reso4, JMenu help, JMenu hideMenu, JMenuItem keyShortcut,
			JMenuItem creator, JMenuItem about) {
		if (idioma == 0) {
			gastos.setText("G A S T O S");// Spend of the day TITLE
			agregado.setText("A G R E G A D O");// Added to cash title
			hideBtn.setText("LOS BOTONES");
			noHide.setText("NADA");
			hideDate.setText("LA FECHA");
			hideAll.setText("TODO");
			newDay.setText("<html><center>Se Quedará<br>Para Mañana</center></html>");// REST
			resoD.setText("ÓPTIMO");
			aggPanel.setText("↑MÁS↓");
			gastosPanel.setText("↑MÁS↓");
			summaryT[0].setText("Inicio");
			summaryT[1].setText("Gastos");
			summaryT[2].setText("Agregado");
			summaryT[3].setText("Ventas");
			summaryT[4].setText("Total");

			diffResult[0].setText("Diferencia");
			file.setText("ARCHIVO");
			novo.setText("NUEVO DÍA");
			clear.setText("BORRAR TODO");
			calc.setText("ASUMAR");
			save.setText("SALVAR");
			screenShot.setText("CAPTURA DE PANTALLA");
			option.setText("CONFIGURACIÓN");
			exit.setText("SALIR");

			summary.setText("SUMARIO");
			sumV.setText("VISTA PREVIA DEL RESUMEN");
			effectChooser.setText("ELIGE TU EFECTO");
			sumV1.setText("APARIENCIA GRADUAL");
			sumV2.setText("APARECE PALABRA POR PALABRA");
			sumV3.setText("APARECE LETRA POR LETRA");
			exMenu.setText("GUARDAR RESUMEN");
			speedChooser.setText("VELOCIDAD DE ANIMACIÓN");
			speed1.setText("LENTO");
			speed2.setText("MEDIANO");
			speed3.setText("RÁPIDO");

			goTo.setText("IR A");
			pesos.setText("PESOS");
			fatura.setText("FACTURA");
			firstFrame.setText("PRIMER CUADRO");
			reso.setText("RESOLUCIÓN");
			reso1.setText("GRANDE");
			reso2.setText("MEDIO");
			reso3.setText("PEQUENA");
			reso4.setText("X-PEQUENA");
			help.setText("AYUDA");
			hideMenu.setText("ESCONDER");
			keyShortcut.setText("ATAJOS DE TECLADO");
			creator.setText("SOBRE EL CREADOR");
			about.setText("SOBRE EL APLICATIVO");
		} else if (idioma == 1) {
			gastos.setText("G A S T O S");// Spend of the day TITLE
			agregado.setText("A G R E G A D O");// Added to cash title
			hideBtn.setText("OS BOTÕES");
			noHide.setText("NADA");
			hideDate.setText("DATA");
			hideAll.setText("TUDO");
			newDay.setText("<html><center>Vai Ficar<br>Para Amanhã</center></html>");// REST
			resoD.setText("ÓTIMO");
			aggPanel.setText("↑MAIS↓");
			gastosPanel.setText("↑MAIS↓");
			summaryT[0].setText("Início");
			summaryT[1].setText("Gastos");
			summaryT[2].setText("Agregado");
			summaryT[3].setText("Vendas");
			summaryT[4].setText("Total");

			diffResult[0].setText("Diferença");
			file.setText("ARQUIVO");
			novo.setText("NOVO DIA");
			clear.setText("LIMPAR TUDO");
			calc.setText("ASSUMIR");
			save.setText("SALVAR");
			screenShot.setText("CAPTURA DE TELA");
			option.setText("CONFIGURAÇÃO");
			exit.setText("SAIR");

			summary.setText("SUMÁRIO");
			sumV.setText("VISUALIZAÇÃO DO RESUMO");
			effectChooser.setText("ESCOLHA SEU EFEITO");
			sumV1.setText("APARECIMENTO GRADUAL");
			sumV2.setText("APARECE PALAVRA POR PALAVRA");
			sumV3.setText("APARECE LETRA POR LETRA");
			exMenu.setText("SALVAR RESUMO");
			speedChooser.setText("VELOCIDADE DA ANIMAÇÃO");
			speed1.setText("LENTO");
			speed2.setText("MÉDIO");
			speed3.setText("RÁPIDO");

			goTo.setText("VAI");
			pesos.setText("PESOS");
			fatura.setText("FATURA");
			firstFrame.setText("PRIMEIRA TELA");
			reso.setText("RESOLUÇÃO");
			reso1.setText("GRANDE");
			reso2.setText("MEDIO");
			reso3.setText("PEQUENA");
			reso4.setText("X-PEQUENA");
			help.setText("AJUDA");
			hideMenu.setText("ESCONDER");
			keyShortcut.setText("ATALHOS DO TECLADO");
			creator.setText("SOBRE O CRIADOR");
			about.setText("SOBRE O APLICATIVO");
		} else {
			gastos.setText("B I L L S");// Spend of the day TITLE
			agregado.setText("A G G R E G A T E S");// Added to cash title
			hideBtn.setText("BUTTONS");
			noHide.setText("NOTHING");
			hideDate.setText("DATE");
			hideAll.setText("ALL");
			newDay.setText("<html><center>Will stay<br>For tomorrow</center></html>");// REST
			resoD.setText("OPTIMAL");
			aggPanel.setText("↑MORE↓");
			gastosPanel.setText("↑MORE↓");
			summaryT[0].setText("Initial");
			summaryT[1].setText("Bills");
			summaryT[2].setText("Aggregates");
			summaryT[3].setText("Sales");
			summaryT[4].setText("Total");

			diffResult[0].setText("Difference");
			file.setText("FILE");
			novo.setText("NEW DAY");
			clear.setText("CLEAN ALL");
			calc.setText("ASSUME");
			save.setText("SAVE");
			screenShot.setText("SCREENSHOT");
			option.setText("SETTINGS");
			exit.setText("EXIT");

			summary.setText("SUMMARY");
			sumV.setText("SUMMARY VIEWING");
			effectChooser.setText("CHOOSE YOUR EFFECT");
			sumV1.setText("FADING");
			sumV2.setText("APPEAR WORD BY WORD");
			sumV3.setText("APPEAR LETTER BY LETTER");
			exMenu.setText("SAVE SUMMARY");
			speedChooser.setText("ANIMATION SPEED");
			speed1.setText("SLOW");
			speed2.setText("MEDIUM");
			speed3.setText("FAST");

			goTo.setText("GO");
			pesos.setText("PESOS");
			fatura.setText("INVOICE");
			firstFrame.setText("FIRST FRAME");
			reso.setText("RESOLUTION");
			reso1.setText("LARGE");
			reso2.setText("MEDIUM");
			reso3.setText("SMALL");
			reso4.setText("X-SMALL");
			help.setText("HELP");
			hideMenu.setText("HIDE");
			keyShortcut.setText("KEY SHORTCUT");
			creator.setText("ABOUT THE CREATOR");
			about.setText("ABOUT THE APP");
		}
	}

	private String[] idiomaString(int idioma) {
		String[] espanol = { "• CTRL + S → ir la fatura.\n" + "• CTRL + P → ir al pesos.\n"
				+ "• CTRL + B → borrar todo.\n" + "• CTRL + N → prepárate para el día siguiente.\n"
				+ "• FLECHAS → subir, abajo, derecha e izquierda.\n" + "• CTRL + D → ir al detalles.\n"
				+ "• CTRL + I → ir al inicio.\n" + "• CTRL + G → ir al gastos.\n" + "• CTRL + A → ir al agregado.\n"
				+ "• CTRL + T → ir a la caja.\n" + "• CTRL + E → ir al ultimo numero.\n"
				+ "• CTRL + M → mas un 100 o de 1000 si posible.\n" + "• CTRL + C → abrir el configuración."// 0
				, "ATAJOS DE TECLADO" // key shortcut 1
				, "Crédito y Diseñado por MhmdSAbdlh ©"// creator 2
				,
				"ESTA APLICACIÓN ESTÁ DISEÑADA PARA CEDROS Y NARJES FREE SHOP.\r\n"
						+ "TIENE MARCO PARA CERRAR LA CAJA TANTO EN REALES COMO PESOS.\r\n"
						+ "TIENE UN MARCO PARA CALCULAR EL TROCO DE UNA VENTA TANTO EN REALES COMO PESOS.\r\n"
						+ "SABE CÓMO QUEDARÁ PARA EL PRÓXIMO DÍA.\r\n" + "3 MÉTODOS PARA DAR EL CAMBIO.\r\n"
						+ "CAMBIARÁ TODO SEGÚN EL ICONO SELECCIONADO.\r\n" + "\r\n" + "MOHAMAD ABDALLAH ABBASS ©"// about4
				, "CONFIGURACIÓN"// conf title 4
				, "ICONO"// icon 5
				, "IDIOMA"// LANGUAGE 6
				, "xxx"// 7
				, "AUTOGUARDAR"// AUTO SAVE 8
				, "POR DEFECTO"// DEFAULT 9
				, "GUARDAR"// SAVE 10
				, "SI"// YES 11
				, "NO"// NO 12
				, "¿Seguro que quieres salir?"// exit 13
				, "SALIR"// exit 14
				, "Si /Nuevo Dia"// new day 15
				, "¿QUIERES EMPEZAR NUEVO DIA?"// new day 16
				, "NUEVO DIA" // new day 17
				, "¿QUIERES BORRAR TODO?"// clear 18
				, "BORRAR TODO" // clear 19
				, "Más "// mas 20
				, "<html><center>No Hay Diferencia</html>"// diif 21
				, "Sobró R$" // sobro 22
				, "Faltó R$" // falta 23
				, "NO HAY NADA PARA ARMAR!"// nada mas 24
				, "LA CAPTURA DE PANTALLA SE TOMA CON ÉXITO", // SCREENSJOT 25
				"SALVADO CON ÉXITO, GRACIAS" // SAVE 26
				, "CIERRE DE CAJA - R$" // TITLE 27
				, "SOBRE MI"// about me 28
				, "GASTOS"// 29
				, "AGREGADOS"// 30
				, "RECUERDOS DE HOY"// 31,
				, "Introducir contraseña"// 32
				, "Cancelar, tecla X o escape seleccionada"// 33
				, "¡Contraseña incorrecta, inténtalo de nuevo!"// 34
				, "SEPARADOS 🔒"// 35
				, "PROMEDIO DEL MES"// 36
				, "OTROS"// 37
		};
		String[] portugues = { "• CTRL + S → ir para a fatura.\n" + "• CTRL + P → ir para os pesos.\n"
				+ "• CTRL + B → excluir tudo.\n" + "• CTRL + N → prepare-se para o dia seguinte.\n"
				+ "• SETAS → cima, baixo, esquerda e direita.\n" + "• CTRL + D → ir para detalhes.\n"
				+ "• CTRL + I → ir para o início.\n" + "• CTRL + G → ir para as despesas.\n"
				+ "• CTRL + A → ir para agregar.\n" + "• CTRL + T → ir para finalizar a compra.\n"
				+ "• CTRL + E → ir para o último número.\n" + "• CTRL + M → mais 100 ou 1000 se possível.\n"
				+ "• CTRL + C → abrir configurações."// atalho de tecla 1
				, "ATALHOS DE TECLAS" // tecla de atalho 2
				, "Crédito e Desenhado por MhmdSAbdlh ©"// creator 3
				,
				"ESTE APLICATIVO FOI DESENVOLVIDO PARA O FREE SHOP DE CEDROS E NARJES.\r\n"
						+ "TEM MOLDURA PARA FECHAR A CAIXA TANTO EM REAIS QUANTO EM PESOS.\r\n"
						+ "TEM UM QUADRO PARA CALCULAR O TROCO DE UMA VENDA TANTO EM REAIS QUANTO EM PESOS.\r\n"
						+ "SAIBA COMO SERÁ PARA O DIA SEGUINTE.\r\n" + "3 MÉTODOS PARA FAZER A MUDANÇA.\r\n"
						+ "MUDARÁ TUDO DE ACORDO COM O ÍCONE SELECIONADO.\r\n" + "\r\n" + "MOHAMAD ABDALLAH ABBASS ©" // 4
				, "CONFIGURAÇÃO"// conf title 5
				, "ÍCONE"// icon 6
				, "LINGUAGEM"// LANGUAGE 7
				, "xxx"// xxx 8
				, "AUTO-SALVAR"// AUTO SAVE 9
				, "POR PADRÃO"// DEFAULT 10
				, "SALVAR"// SAVE 11
				, "SIM"// YES 12
				, "NÃO"// NO 13
				, "Tem certeza que quer sair?"// exit 14
				, "SAIR"// exit15
				, "Sim / Novo Dia"// new day 16
				, "VOCÊ QUER COMEÇAR UM NOVO DIA?"// new day 17
				, "NOVO DIA" // new day 18
				, "VOCÊ QUER APAGAR TUDO?"// clear 19
				, "LIMPAR TUDO" // clear20
				, "Mais "// mas 21
				, "<html><center>Não há diferença</html>"// diif 22
				, "Sobra R$" // sobro 23
				, "Faltou R$" // falta 24
				, "NÃO HÁ NADA PARA MONTAR!"// nada mas 25
				, "A CAPTURA DE TELA FOI REALIZADA COM SUCESSO", "SALVO COM SUCESSO, OBRIGADO"// SCREENSJOT 25
				, "FECHAMENTO DE CAIXA - R$" // SAVE 26
				, "SOBRE MIM"// about me 28
				, "GASTOS"// 29
				, "AGREGADOS"// 30
				, "MEMÓRIAS DE HOJE"// 31
				, "Digite a senha" // 32
				, "Cancelar, X ou tecla de escape selecionada"// 33
				, "Senha incorreta, tente novamente!"// 34
				, "SEPARADAS 🔒"// 35
				, "MÉDIA DO MÊS"// 36
				, "OUTROS"// 37
		};
		String[] english = {
				"• CTRL + S → go to invoice.\n" + "• CTRL + P → go to the pesos.\n" + "• CTRL + B → delete all.\n"
						+ "• CTRL + N → get ready for the next day.\n" + "• arrows → up, down, left and right.\n"
						+ "• CTRL + D → go to details.\n" + "• CTRL + I → go to the beginning.\n"
						+ "• CTRL + G → go to expenses.\n" + "• CTRL + A → go to aggregate.\n"
						+ "• CTRL + T → go to checkout.\n" + "• CTRL + E → go to the last number.\n"
						+ "• CTRL + M → add set of 100 or 1000 if possible.\n" + "• CTRL + C → open settings."// 0
				, "KEY SHORTCUTS" // tecla de atalho 1
				, "Credit and Designed by MhmdSAbdlh ©"// creator 2
				,
				"THIS APP IS DESIGNED FOR CEDROS AND NARJES FREE SHOP.\r\n"
						+ "HAS A FRAME TO CLOSE THE BOX IN REALS AND PESOS.\r\n"
						+ "THERE IS A FRAME TO CALCULATE THE CHANGE FOR A SALE, BOTH IN BRL AND IN PESOS.\r\n"
						+ "KNOW HOW MUCH IT WILL BE FOR THE NEXT DAY.\r\n" + "3 METHODS OF GIVING CHANGE.\r\n"
						+ "WILL CHANGE EVERYTHING ACCORDING TO THE SELECTED ICON.\r\n" + "\r\n"
						+ "MOHAMAD ABDALLAH ABBASS ©"// about3
				, "CONFIGURATION"// conf title4
				, "ICON"// icon5
				, "LANGUAGE"// FIRST FRAME6
				, "KEY SHORTCUT"// KEY SHORTCUT7
				, "AUTO SAVE"// AUTO SAVE8
				, "DEFAULT"// DEFAULT 9
				, "SAVE"// SAVE 11
				, "YES"// YES 12
				, "NO"// NO 13
				, "Are you sure you want to leave?"// exit 14
				, "EXIT"// exit15
				, "YES /NEW DAY"// new day 16
				, "DO YOU WANT TO START A NEW DAY?"// new day 17
				, "NEW DAY" // new day 18
				, "DO YOU WANT TO DELETE EVERYTHING?"// clear 19
				, "DELETE EVERYTHING" // clear20
				, "MORE "// mas 21
				, "<html><center>There is no difference</html>"// diif 22
				, "More R$" // sobro 23
				, "Missed R$" // falta 24
				, "THERE IS NOTHING TO ASSEMBLE!"// nada mas 25
				, "THE SCREENSHOT IS TAKING SUCCESSFULY"// SCREENSJOT 25
				, "SUCCESSFULLY SAVED, THANK YOU" // SAVE 26
				, "CASH CLOSING - R$"// TITLE 27
				, "ABOUT ME"// about me 28
				, "BILLS"// 29
				, "AGGREGATES"// 30
				, "MEMORIES OF TODAY"// 31
				, "Enter Password"// 32
				, "Cancel, X or escape key selected"// 33
				, "Wrong password, try again!"// 34
				, "SEPARATED 🔒"// 35
				, "AVERAGE OF THE MONTH"// 36
				, "OTHERS"// 37
		};
		if (idioma == 0)
			return espanol;
		else if (idioma == 1)
			return portugues;
		else
			return english;
	}

	// Add a set of 1000
	private void addSetMil() {
		int numMil = Integer.valueOf(panelCnum[2].getText()) * 200 + Integer.valueOf(panelCnum[3].getText()) * 100
				+ Integer.valueOf(panelCnum[4].getText()) * 50;
		int counter = 0;
		int temp1 = 0, temp2 = 0;
		if (Integer.valueOf(panelCnum[4].getText()) == 0)
			while (numMil >= 1000) {
				numMil -= 1000;
				counter++;
			}
		else
			while (numMil > 1000) {
				numMil -= 1000;
				counter++;
			}
		panelCnum[0].setText(Integer.valueOf(panelCnum[0].getText()) + counter + "");
		while (counter > 0) {
			if (Integer.valueOf(panelCnum[2].getText()) >= 5)
				panelCnum[2].setText(Integer.valueOf(panelCnum[2].getText()) - 5 + "");
			else {
				temp1 = Integer.valueOf(panelCnum[2].getText());
				panelCnum[2].setText(0 + "");
				if (Integer.valueOf(panelCnum[3].getText()) + temp1 * 2 >= 10)
					panelCnum[3].setText((Integer.valueOf(panelCnum[3].getText()) + temp1 * 2) - 10 + "");
				else {
					temp2 = Integer.valueOf(panelCnum[3].getText());
					panelCnum[3].setText("0");
					panelCnum[4].setText((Integer.valueOf(panelCnum[4].getText()) - 2 * (10 - 2 * temp1 - temp2)) + "");
				}
			}
			counter--;
		}
		aggBtn[0].hide();
	}

	// Add a set of 100
	private void addSetHun() {
		int numHun = Integer.valueOf(panelCnum[5].getText()) * 20;
		int counter = 0;
		while (numHun > 100) {
			numHun -= 100;
			counter++;
		}
		panelCnum[1].setText(Integer.valueOf(panelCnum[1].getText()) + counter + "");
		panelCnum[5].setText(Integer.valueOf(panelCnum[5].getText()) - 5 * counter + "");
		aggBtn[1].hide();
	}

	// Key listener for the table
	private void tableFocus(int i, int j, JFrame frame, JButton newDay, JButton notasF, JButton pesosF,
			JButton clearEverthing, JMenuItem hideBtn, JMenuItem resoD, JButton gastosPanel, JButton aggPanel) {
		details[i][j].addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// GO TO Notas
				if ((e.getKeyCode() == KeyEvent.VK_S) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					saveProgress();
					frame.dispose();
					FaturaR.totalC.setText("0");
					FaturaR.total.setText("0");
					new FaturaR();
				} else
				// GO TO Pesos
				if ((e.getKeyCode() == KeyEvent.VK_P) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					saveProgress();
					frame.dispose();
					new Pesos();
				} // Conf
				else if ((e.getKeyCode() == KeyEvent.VK_C) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					confFrame(conf, notasF, pesosF, newDay, clearEverthing, hideBtn, resoD, gastosPanel, aggPanel);
				} else// Clear
				if ((e.getKeyCode() == KeyEvent.VK_B) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					clearAll();
				} else// new day
				if ((e.getKeyCode() == KeyEvent.VK_N) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					newDay();
				} else// Direction
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (i < 5) {
						details[i][j].setNextFocusableComponent(details[i + 1][j]);
						details[i][j].nextFocus();
					} else {
						if (j != 19) {
							details[i][j].setNextFocusableComponent(details[0][j + 1]);
							details[i][j].nextFocus();
						} else {
							details[i][j].setNextFocusableComponent(details[0][0]);
							details[i][j].nextFocus();
						}
					}
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (i > 0) {
						details[i][j].setNextFocusableComponent(details[i - 1][j]);
						details[i][j].nextFocus();
					} else {
						if (j != 0) {
							details[i][j].setNextFocusableComponent(details[5][j - 1]);
							details[i][j].nextFocus();
						} else {
							details[i][j].setNextFocusableComponent(details[5][19]);
							details[i][j].nextFocus();
						}
					}
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (j > 0) {
						details[i][j].setNextFocusableComponent(details[i][j - 1]);
						details[i][j].nextFocus();
					} else {
						if (i != 0) {
							details[i][j].setNextFocusableComponent(details[i - 1][19]);
							details[i][j].nextFocus();
						} else {
							details[i][j].setNextFocusableComponent(details[5][19]);
							details[i][j].nextFocus();
						}
					}
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					if (j < 19) {
						details[i][j].setNextFocusableComponent(details[i][j + 1]);
						details[i][j].nextFocus();
					} else {
						if (i != 5) {
							details[i][j].setNextFocusableComponent(details[i + 1][0]);
							details[i][j].nextFocus();
						} else {
							details[i][j].setNextFocusableComponent(details[0][0]);
							details[i][j].nextFocus();
						}
					}
				} else// GO TO INITIAL
				if ((e.getKeyCode() == KeyEvent.VK_I) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					details[i][j].setNextFocusableComponent(initialDay);
					details[i][j].nextFocus();
				} else// GO TO GASTOS
				if ((e.getKeyCode() == KeyEvent.VK_G) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					details[i][j].setNextFocusableComponent(gastosTable[0]);
					details[i][j].nextFocus();
				} else// GO TO AGGREG
				if ((e.getKeyCode() == KeyEvent.VK_A) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					details[i][j].setNextFocusableComponent(agregadoTable[0]);
					details[i][j].nextFocus();
				} else// GO TO TROCO
				if ((e.getKeyCode() == KeyEvent.VK_T) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					details[i][j].setNextFocusableComponent(panelCnum[3]);
					details[i][j].nextFocus();
				} else// |Go to the last one
				if ((e.getKeyCode() == KeyEvent.VK_E) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					int k = 0, l = 0;
					schiffe_loop: while (k < 6) {
						l = 0;
						while (l < 20) {
							if (details[k][l].getText().isBlank()) {
								break schiffe_loop;
							}
							l++;
						}
						k++;
					}
					if (k == 6 && l == 20)
						k = l = 0;
					details[i][j].setNextFocusableComponent(details[k][l]);
					details[i][j].nextFocus();
				} else // M for add set 100 and 1000
				if ((e.getKeyCode() == KeyEvent.VK_M) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0))
					addSetKey();
			}
		});
	}

	// Key listener for the initial
	private void iniFocus(JButton newDay, JButton notasF, JButton pesosF, JButton clearEverthing, JMenuItem hideBtn,
			JMenuItem resoD, JButton gastosPanel, JButton aggPanel) {
		initialDay.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyCode() == KeyEvent.VK_B) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {// Clear
					clearAll();
				} // Conf
				else if ((e.getKeyCode() == KeyEvent.VK_C) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					confFrame(conf, notasF, pesosF, newDay, clearEverthing, hideBtn, resoD, gastosPanel, aggPanel);
				} else// new day
				if ((e.getKeyCode() == KeyEvent.VK_N) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					newDay();
				} else // GO TO GASTOS
				if ((e.getKeyCode() == KeyEvent.VK_G) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					initialDay.setNextFocusableComponent(gastosTable[0]);
					initialDay.nextFocus();
				} else // GO TO AGG
				if ((e.getKeyCode() == KeyEvent.VK_A) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					initialDay.setNextFocusableComponent(agregadoTable[0]);
					initialDay.nextFocus();
				} else // GO TO Details
				if ((e.getKeyCode() == KeyEvent.VK_D) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					initialDay.setNextFocusableComponent(details[0][0]);
					initialDay.nextFocus();
				} else // GO TO Troco
				if ((e.getKeyCode() == KeyEvent.VK_T) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					initialDay.setNextFocusableComponent(panelCnum[3]);
					initialDay.nextFocus();
				} else // M for add set 100 and 1000
				if ((e.getKeyCode() == KeyEvent.VK_M) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0))
					if (aggBtn[0].isShowing() && aggBtn[1].isShowing()) {
						addSetMil();
						addSetHun();
					} else if (aggBtn[0].isShowing())
						addSetMil();
					else if (aggBtn[1].isShowing())
						addSetHun();
					else
						addSetKey();
			}
		});
	}

	// Key listener for the ADDITION
	private void aggFocus(int i, JFrame frame, JButton newDay, JButton notasF, JButton pesosF, JButton clearEverthing,
			JMenuItem hideBtn, JMenuItem resoD, JButton gastosPanel, JButton aggPanel) {
		agregadoTable[i].addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// GO TO Notas
				if ((e.getKeyCode() == KeyEvent.VK_S) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					saveProgress();
					FaturaR.totalC.setText("0");
					FaturaR.total.setText("0");
					frame.dispose();
					new FaturaR();
				} else // GO TO Pesos
				if ((e.getKeyCode() == KeyEvent.VK_P) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					saveProgress();
					frame.dispose();
					new Pesos();
				} // Conf
				else if ((e.getKeyCode() == KeyEvent.VK_C) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					confFrame(conf, notasF, pesosF, newDay, clearEverthing, hideBtn, resoD, gastosPanel, aggPanel);
				} else// Clear
				if ((e.getKeyCode() == KeyEvent.VK_B) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					clearAll();
				} else// new day
				if ((e.getKeyCode() == KeyEvent.VK_N) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					newDay();
				} else// GO TO INITIAL
				if ((e.getKeyCode() == KeyEvent.VK_I) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					agregadoTable[i].setNextFocusableComponent(initialDay);
					agregadoTable[i].nextFocus();
				} else// GO TO GASTOS
				if ((e.getKeyCode() == KeyEvent.VK_G) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					agregadoTable[i].setNextFocusableComponent(gastosTable[0]);
					agregadoTable[i].nextFocus();
				} else// GO TO Details
				if ((e.getKeyCode() == KeyEvent.VK_D) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					agregadoTable[i].setNextFocusableComponent(details[0][0]);
					agregadoTable[i].nextFocus();
				} else// GO TO Troco
				if ((e.getKeyCode() == KeyEvent.VK_T) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					agregadoTable[i].setNextFocusableComponent(panelCnum[3]);
					agregadoTable[i].nextFocus();
				} else// Direction
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (i > 0 && i < 4 || i > 8 && i < 12) {
						agregadoTable[i].setNextFocusableComponent(agregadoTable[i - 1]);
						agregadoTable[i].nextFocus();
					} else if (i == 0) {
						agregadoTable[i].setNextFocusableComponent(agregadoTable[11]);
						agregadoTable[i].nextFocus();
					} else if (i == 8) {
						agregadoTable[i].setNextFocusableComponent(agregadoTable[3]);
						agregadoTable[i].nextFocus();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					if (i < 3 || i > 7 && i < 11) {
						agregadoTable[i].setNextFocusableComponent(agregadoTable[i + 1]);
						agregadoTable[i].nextFocus();
					} else if (i == 3) {
						agregadoTable[i].setNextFocusableComponent(agregadoTable[8]);
						agregadoTable[i].nextFocus();
					} else if (i == 11) {
						agregadoTable[i].setNextFocusableComponent(agregadoTable[0]);
						agregadoTable[i].nextFocus();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (i != 11) {
						if (i < 8) {
							agregadoTable[i].setNextFocusableComponent(agregadoTable[i + 8]);
							agregadoTable[i].nextFocus();
						} else {
							agregadoTable[i].setNextFocusableComponent(agregadoTable[i - 7]);
							agregadoTable[i].nextFocus();
						}
					} else {
						agregadoTable[i].setNextFocusableComponent(agregadoTable[0]);
						agregadoTable[i].nextFocus();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (i != 0) {
						if (i < 8) {
							agregadoTable[i].setNextFocusableComponent(agregadoTable[i + 7]);
							agregadoTable[i].nextFocus();
						} else {
							agregadoTable[i].setNextFocusableComponent(agregadoTable[i - 8]);
							agregadoTable[i].nextFocus();
						}
					} else {
						agregadoTable[i].setNextFocusableComponent(agregadoTable[11]);
						agregadoTable[i].nextFocus();
					}
				} else// |Go to the last one
				if ((e.getKeyCode() == KeyEvent.VK_E) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					int k = 0;
					while (k < 3) {
						if (agregadoTable[k].getText().isBlank())
							break;
						k++;
					}
					if (k == 3)
						k = 0;
					agregadoTable[i].setNextFocusableComponent(agregadoTable[k]);
					agregadoTable[i].nextFocus();
				} else // M for add set 100 and 1000
				if ((e.getKeyCode() == KeyEvent.VK_M) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0))
					if (aggBtn[0].isShowing() && aggBtn[1].isShowing()) {
						addSetMil();
						addSetHun();
					} else if (aggBtn[0].isShowing())
						addSetMil();
					else if (aggBtn[1].isShowing())
						addSetHun();
					else
						addSetKey();
			}
		});
	}

	// Key listener for the SPENT
	private void gasFocus(int i, JFrame frame, JButton newDay, JButton notasF, JButton pesosF, JButton clearEverthing,
			JMenuItem hideBtn, JMenuItem resoD, JButton gastosPanel, JButton aggPanel) {
		gastosTable[i].addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// GO TO Notas
				if ((e.getKeyCode() == KeyEvent.VK_S) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					saveProgress();
					FaturaR.totalC.setText("0");
					FaturaR.total.setText("0");
					frame.dispose();
					new FaturaR();
				} else// GO TO Pesos
				if ((e.getKeyCode() == KeyEvent.VK_P) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					saveProgress();
					frame.dispose();
					new Pesos();
				} // Conf
				else if ((e.getKeyCode() == KeyEvent.VK_C) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					confFrame(conf, notasF, pesosF, newDay, clearEverthing, hideBtn, resoD, gastosPanel, aggPanel);
				} else// Clear
				if ((e.getKeyCode() == KeyEvent.VK_B) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					clearAll();
				} else
				// new day
				if ((e.getKeyCode() == KeyEvent.VK_N) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					newDay();
				} else// GO TO INITIAL
				if ((e.getKeyCode() == KeyEvent.VK_I) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					gastosTable[i].setNextFocusableComponent(initialDay);
					gastosTable[i].nextFocus();
				} else// GO TO AGG
				if ((e.getKeyCode() == KeyEvent.VK_A) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					gastosTable[i].setNextFocusableComponent(agregadoTable[0]);
					gastosTable[i].nextFocus();
				} else// GO TO Details
				if ((e.getKeyCode() == KeyEvent.VK_D) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					gastosTable[i].setNextFocusableComponent(details[0][0]);
					gastosTable[i].nextFocus();
				} else// GO TO Troco
				if ((e.getKeyCode() == KeyEvent.VK_T) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					gastosTable[i].setNextFocusableComponent(panelCnum[3]);
					gastosTable[i].nextFocus();
				} else// Direction
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (i > 0 && i < 4 || i > 8 && i < 12) {
						gastosTable[i].setNextFocusableComponent(gastosTable[i - 1]);
						gastosTable[i].nextFocus();
					} else if (i == 0) {
						gastosTable[i].setNextFocusableComponent(gastosTable[11]);
						gastosTable[i].nextFocus();
					} else if (i == 8) {
						gastosTable[i].setNextFocusableComponent(gastosTable[3]);
						gastosTable[i].nextFocus();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					if (i < 3 || i > 7 && i < 11) {
						gastosTable[i].setNextFocusableComponent(gastosTable[i + 1]);
						gastosTable[i].nextFocus();
					} else if (i == 3) {
						gastosTable[i].setNextFocusableComponent(gastosTable[8]);
						gastosTable[i].nextFocus();
					} else if (i == 11) {
						gastosTable[i].setNextFocusableComponent(gastosTable[0]);
						gastosTable[i].nextFocus();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (i != 11) {
						if (i < 8) {
							gastosTable[i].setNextFocusableComponent(gastosTable[i + 8]);
							gastosTable[i].nextFocus();
						} else {
							gastosTable[i].setNextFocusableComponent(gastosTable[i - 7]);
							gastosTable[i].nextFocus();
						}
					} else {
						gastosTable[i].setNextFocusableComponent(gastosTable[0]);
						gastosTable[i].nextFocus();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (i != 0) {
						if (i < 8) {
							gastosTable[i].setNextFocusableComponent(gastosTable[i + 7]);
							gastosTable[i].nextFocus();
						} else {
							gastosTable[i].setNextFocusableComponent(gastosTable[i - 8]);
							gastosTable[i].nextFocus();
						}
					} else {
						gastosTable[i].setNextFocusableComponent(gastosTable[11]);
						gastosTable[i].nextFocus();
					}
				} else// |Go to the last one
				if ((e.getKeyCode() == KeyEvent.VK_E) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					int k = 0;
					while (k < 3) {
						if (gastosTable[k].getText().isBlank())
							break;
						k++;
					}
					if (k == 3)
						k = 0;
					gastosTable[i].setNextFocusableComponent(gastosTable[k]);
					gastosTable[i].nextFocus();
				} else // M for add set 100 and 1000
				if ((e.getKeyCode() == KeyEvent.VK_M) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0))
					if (aggBtn[0].isShowing() && aggBtn[1].isShowing()) {
						addSetMil();
						addSetHun();
					} else if (aggBtn[0].isShowing())
						addSetMil();
					else if (aggBtn[1].isShowing())
						addSetHun();
					else
						addSetKey();
			}
		});
	}

	// Key listener for the CASH
	private void cajaFocus(int i, JFrame frame, JButton newDay, JButton notasF, JButton pesosF, JButton clearEverthing,
			JMenuItem hideBtn, JMenuItem resoD, JButton gastosPanel, JButton aggPanel) {
		panelCnum[i].addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// GO TO Notas
				if ((e.getKeyCode() == KeyEvent.VK_S) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					saveProgress();
					FaturaR.totalC.setText("0");
					FaturaR.total.setText("0");
					frame.dispose();
					new FaturaR();
				} else // GO TO Pesos
				if ((e.getKeyCode() == KeyEvent.VK_P) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					saveProgress();
					frame.dispose();
					new Pesos();
				} // Conf
				else if ((e.getKeyCode() == KeyEvent.VK_C) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					confFrame(conf, notasF, pesosF, newDay, clearEverthing, hideBtn, resoD, gastosPanel, aggPanel);
				} else // Clear
				if ((e.getKeyCode() == KeyEvent.VK_B) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					clearAll();
				} else// new day
				if ((e.getKeyCode() == KeyEvent.VK_N) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					newDay();
				} else // GO TO INITIAL
				if ((e.getKeyCode() == KeyEvent.VK_I) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					panelCnum[i].setNextFocusableComponent(initialDay);
					panelCnum[i].nextFocus();
				} else // GO TO AGG
				if ((e.getKeyCode() == KeyEvent.VK_A) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					panelCnum[i].setNextFocusableComponent(agregadoTable[0]);
					panelCnum[i].nextFocus();
				} else// GO TO Details
				if ((e.getKeyCode() == KeyEvent.VK_D) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					panelCnum[i].setNextFocusableComponent(details[0][0]);
					panelCnum[i].nextFocus();
				} else// GO TO Gastos
				if ((e.getKeyCode() == KeyEvent.VK_G) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					panelCnum[i].setNextFocusableComponent(gastosTable[0]);
					panelCnum[i].nextFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (i < 9) {
						panelCnum[i].setNextFocusableComponent(panelCnum[i + 1]);
						panelCnum[i].nextFocus();
					} else {
						panelCnum[i].setNextFocusableComponent(panelCnum[0]);
						panelCnum[i].nextFocus();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT)
					if (i > 0) {
						panelCnum[i].setNextFocusableComponent(panelCnum[i - 1]);
						panelCnum[i].nextFocus();
					} else {
						panelCnum[i].setNextFocusableComponent(panelCnum[9]);
						panelCnum[i].nextFocus();
					}
				else // M for add set 100 and 1000
				if ((e.getKeyCode() == KeyEvent.VK_M) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0))
					if (aggBtn[0].isShowing() && aggBtn[1].isShowing()) {
						addSetMil();
						addSetHun();
					} else if (aggBtn[0].isShowing())
						addSetMil();
					else if (aggBtn[1].isShowing())
						addSetHun();
					else
						addSetKey();
			}
		});
	}

	// Style of textField
	private void textFieldStyle(JTextField tf) {
		tf.setBackground(First.darkC);
		tf.setForeground(First.lightC);
		tf.setFont(First.myFont);
		tf.setBorder(First.border);
		tf.setHorizontalAlignment(0);
		tf.setCaretColor(First.lightC);
		tf.addFocusListener(textFocus);
	}

	// Detailling the agregados
	private String agregadoDetalles() {
		String aggString = "";
		int num = 1;
		for (int i = 8; i < 16; i++)
			if (First.isNumeric(agregadoTable[i].getText())) {
				aggString += num + "- "
						+ (agregadoTable[i - 8].getText().isBlank() ? "XXX" : agregadoTable[i - 8].getText()) + " -> R$"
						+ agregadoTable[i].getText() + "\n";
				num++;
			}
		return aggString;
	}

	// Calculate the nbrs of agregados
	private int nbAgregados() {
		int agregado = 0;
		for (int i = 8; i < 16; i++)
			if (First.isNumeric(agregadoTable[i].getText()))
				agregado++;
		return agregado;
	}

	// Detailling the gastos
	private String gastosDetalles() {
		String gasString = "";
		int num = 1;
		for (int i = 8; i < 16; i++)
			if (First.isNumeric(gastosTable[i].getText())) {
				gasString += num + "- "
						+ (gastosTable[i - 8].getText().isBlank() ? "XXX" : gastosTable[i - 8].getText()) + " -> R$"
						+ gastosTable[i].getText() + "\n";
				num++;
			}
		return gasString;
	}

	// Calculate the nbrs of gastos
	private int nbGastos() {
		int gastos = 0;
		for (int i = 8; i < 16; i++)
			if (First.isNumeric(gastosTable[i].getText()))
				gastos++;
		return gastos;
	}

	// Calculate the nbrs of ventas
	private int nbVentas() {
		int ventas = 0;
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 20; j++)
				if (First.isNumeric(details[i][j].getText()))
					ventas++;
		return ventas;
	}

	// Optimal resolution
	private void opResolution(JButton clearEverthing, JButton pesosF, JButton notasF, JButton newDay, JMenuItem resoD,
			JMenuItem resoXP, JMenuItem resoP, JMenuItem resoM, JMenuItem resoG, JButton aggPanel,
			JButton gastosPanel) {
		if (width > 1800 && height > 1000)
			resG(resoD, resoXP, resoP, resoM, resoG, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel);
		else if (width > 1500 && height > 700)
			resM(resoD, resoXP, resoP, resoM, resoG, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel);
		else if (width > 1300 && height > 700)
			resP(resoD, resoXP, resoP, resoM, resoG, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel);
		else
			resXP(resoD, resoXP, resoP, resoM, resoG, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel);
	}

	// Gastos frame if there is more than 4
	private void gastosFrame(ArrayList<String> keywords, JButton notasF, JButton pesosF, JButton newDay,
			JButton clearEverthing, JMenuItem resoD, JButton gastosPanel) {
		JFrame gastosFrame = new JFrame();
		gastosFrame.setTitle(idiomaString(language)[29]);
		gastosFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		gastosFrame.setAlwaysOnTop(false);
		gastosFrame.setSize(300, 403);
		gastosFrame.setLocationRelativeTo(null);
		gastosFrame.setResizable(false);
		gastosFrame.setLayout(null);
		gastosFrame.getContentPane().setBackground(First.redC);
		gastosFrame.setIconImage(notasI.getImage());
		for (int i = 0; i < 16; i++) {
			textFieldStyle(gTable[i]);
			if (i < 8) {
				gTable[i].setBounds(2, 2 + 45 * i, 140, 45);
				gTable[i].setBackground(First.redD);
			} else {
				gTable[i].setBounds(142, 2 + 45 * (i - 8), 140, 45);
				gTable[i].setBackground(First.redC);
			}
			gTable[i].removeFocusListener(textFocus);
			gTable[i].setForeground(Color.white);
			gTable[i].addKeyListener(new KeyAdapter() {// Escape to close
				@SuppressWarnings("static-access")
				public void keyPressed(KeyEvent ke) {
					if (ke.getKeyCode() == ke.VK_ESCAPE) {
						for (int i = 0; i < 16; i++)
							gastosTable[i].setText(gTable[i].getText());
						sumF();
						gastosFrame.dispose();
					}
				}
			});
			gTable[i].addFocusListener(new FocusListener() {

				@Override
				public void focusLost(FocusEvent e) {
					for (int i = 0; i < 16; i++) // TitleCase gastos and agg
						gTable[i].setText(First.capitalizeString(gTable[i].getText()));
				}

				@Override
				public void focusGained(FocusEvent e) {
					((JTextField) e.getSource()).selectAll();
				}
			});
			gastosFrame.add(gTable[i]);
		}
		// Close popup
		gastosFrame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				for (int i = 0; i < 16; i++)
					gastosTable[i].setText(gTable[i].getText());
				sumF();
			}
		});
		gastosFrame.setVisible(true);
	}

	// Agregados frame if there is more than 4
	private void aggFrame(ArrayList<String> keywords, JButton notasF, JButton pesosF, JButton newDay,
			JButton clearEverthing, JMenuItem resoD, JButton gastosPanel) {
		JFrame aggFrame = new JFrame();
		aggFrame.setTitle(idiomaString(language)[30]);
		aggFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		aggFrame.setAlwaysOnTop(false);
		aggFrame.setSize(300, 403);
		aggFrame.setLocationRelativeTo(null);
		aggFrame.setResizable(false);
		aggFrame.setLayout(null);
		aggFrame.getContentPane().setBackground(First.greenC);
		aggFrame.setIconImage(notasI.getImage());
		for (int i = 0; i < 16; i++) {
			textFieldStyle(aTable[i]);
			if (i < 8) {
				aTable[i].setBounds(2, 2 + 45 * i, 140, 45);
				aTable[i].setBackground(First.greenD);
			} else {
				aTable[i].setBounds(142, 2 + 45 * (i - 8), 140, 45); // Add focus listener
				aTable[i].setBackground(First.greenC);
			}
			aTable[i].removeFocusListener(textFocus);
			aTable[i].setForeground(Color.white);
			aTable[i].addKeyListener(new KeyAdapter() {// Escape to close
				@SuppressWarnings("static-access")
				public void keyPressed(KeyEvent ke) {
					if (ke.getKeyCode() == ke.VK_ESCAPE) {
						for (int i = 0; i < 16; i++)
							agregadoTable[i].setText(aTable[i].getText());
						sumF();
						aggFrame.dispose();
					}
				}
			});
			aTable[i].addFocusListener(new FocusListener() {

				@Override
				public void focusLost(FocusEvent e) {
					for (int i = 0; i < 16; i++) // TitleCase gastos and agg
						aTable[i].setText(First.capitalizeString(aTable[i].getText()));
				}

				@Override
				public void focusGained(FocusEvent e) {
					((JTextField) e.getSource()).selectAll();
				}
			});
			aggFrame.add(aTable[i]);
		}
		// Close popup
		aggFrame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				for (int i = 0; i < 16; i++)
					agregadoTable[i].setText(aTable[i].getText());
				sumF();
			}
		});
		aggFrame.setVisible(true);
	}

	// Add set if available
	private void addSetKey() {
		if (aggBtn[0].isShowing() && aggBtn[1].isShowing()) {
			addSetMil();
			addSetHun();
		} else if (aggBtn[0].isShowing())
			addSetMil();
		else if (aggBtn[1].isShowing())
			addSetHun();
		else {
			JOptionPane opt = new JOptionPane(idiomaString(language)[24], JOptionPane.ERROR_MESSAGE);
			final JDialog dlg = opt.createDialog("Error");
			new Thread(new Runnable() {
				public void run() {
					try {
						Thread.sleep(2000);
						dlg.dispose();

					} catch (Throwable th) {
						JOptionPane opt = new JOptionPane(
								language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
								JOptionPane.ERROR_MESSAGE);
						opt.show();
					}
				}
			}).start();
			dlg.setVisible(true);
		}
	}

	// Resize the image w/o cropping
	private Image getScaledImage(Image srcImg, int w, int h) {
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(srcImg, 0, 0, w, h, null);
		g2.dispose();

		return resizedImg;
	}

	private String getMonthForInt(int num) {
		String[] eng = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		String[] esp = { "enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre",
				"octubre", "noviembre", "diciembre" };
		String[] por = { "janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho", "agosto", "setembro",
				"Outubro", "Novembro", "Dezembro" };
		if (language == 0)
			return esp[num].toUpperCase();
		else if (language == 1)
			return por[num].toUpperCase();
		else
			return eng[num].toUpperCase();
	}

	private void dateLang(int lang) {
		if (lang == 0) {
			monthS = new SimpleDateFormat("MMMM", new Locale("es")).format(Calendar.getInstance().getTime())
					.toUpperCase();
			dayN = new SimpleDateFormat("dd", new Locale("es")).format(Calendar.getInstance().getTime());
			dayS = new SimpleDateFormat("EEEE", new Locale("es")).format(Calendar.getInstance().getTime())
					.toUpperCase();
			yearS = new SimpleDateFormat("YYYY", new Locale("es")).format(Calendar.getInstance().getTime());
		} else if (lang == 1) {
			monthS = new SimpleDateFormat("MMMM", new Locale("pt")).format(Calendar.getInstance().getTime())
					.toUpperCase();
			dayN = new SimpleDateFormat("dd", new Locale("pt")).format(Calendar.getInstance().getTime());
			dayS = new SimpleDateFormat("EEEE", new Locale("pt")).format(Calendar.getInstance().getTime())
					.toUpperCase();
			yearS = new SimpleDateFormat("YYYY", new Locale("pt")).format(Calendar.getInstance().getTime());
		} else {
			monthS = new SimpleDateFormat("MMMM", new Locale("en")).format(Calendar.getInstance().getTime())
					.toUpperCase();
			dayN = new SimpleDateFormat("dd", new Locale("en")).format(Calendar.getInstance().getTime());
			dayS = new SimpleDateFormat("EEEE", new Locale("en")).format(Calendar.getInstance().getTime())
					.toUpperCase();
			yearS = new SimpleDateFormat("YYYY", new Locale("en")).format(Calendar.getInstance().getTime());
		}
	}

	private void resolutionActionListener(JButton clearEverthing, JButton pesosF, JButton notasF, JButton newDay,
			JMenuItem resoD, JButton aggPanel, JButton gastosPanel, JMenuItem reso1, JMenuItem reso2, JMenuItem reso3,
			JMenuItem reso4) {
		resoD.addActionListener(e -> {
			conf[3] = "0";
			opResolution(clearEverthing, pesosF, notasF, newDay, resoD, reso4, reso3, reso2, reso1, aggPanel,
					gastosPanel);
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
			resG(resoD, reso4, reso3, reso2, reso1, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel);
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
			resM(resoD, reso4, reso3, reso2, reso1, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel);
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
			resP(resoD, reso4, reso3, reso2, reso1, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel);
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
			resXP(resoD, reso4, reso3, reso2, reso1, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel);
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
				savedF.close();
			} catch (Exception e2) {
				JOptionPane opt = new JOptionPane(
						language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
						JOptionPane.ERROR_MESSAGE);
				opt.show();
			}
		});
	}

	private void summaryActionListener(JMenuItem sumV1, JMenuItem sumV2, JMenuItem sumV3) {
		sumV1.addActionListener(e -> {
			effChooser = 0;
			sumV1.setEnabled(false);
			sumV2.setEnabled(true);
			sumV3.setEnabled(true);
			conf[8] = "0";
			try {
				FileWriter savedF = new FileWriter(newFile);
				savedF.write((conf[0].equals("null") ? 0 : conf[0]) + System.lineSeparator());
				savedF.write((conf[1].equals("null") ? 0 : conf[1]) + System.lineSeparator());
				savedF.write((conf[2].equals("null") ? "false" : conf[2]) + System.lineSeparator());
				savedF.write((conf[3].equals("null") ? 0 : conf[3]) + System.lineSeparator());
				savedF.write((conf[4].equals("null") ? "false" : conf[4]) + System.lineSeparator());
				savedF.write((conf[5].equals("null") ? 0 : conf[5]) + System.lineSeparator());
				savedF.write((conf[6].equals("null") ? 0 : conf[6]) + System.lineSeparator());// speed
				savedF.write((conf[7].equals("null") ? 0 : conf[7]) + System.lineSeparator());// lan
				savedF.write(0 + System.lineSeparator());// effect chooser
				savedF.write((conf[9].equals("null") ? "1,1" : conf[9]) + System.lineSeparator());// intro
				savedF.close();
			} catch (Exception e2) {
				JOptionPane opt = new JOptionPane(
						language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
						JOptionPane.ERROR_MESSAGE);
				opt.show();
			}
		});
		sumV2.addActionListener(e -> {
			effChooser = 1;
			sumV1.setEnabled(true);
			sumV2.setEnabled(false);
			sumV3.setEnabled(true);
			conf[8] = "1";
			try {
				FileWriter savedF = new FileWriter(newFile);
				savedF.write((conf[0].equals("null") ? 0 : conf[0]) + System.lineSeparator());
				savedF.write((conf[1].equals("null") ? 0 : conf[1]) + System.lineSeparator());
				savedF.write((conf[2].equals("null") ? "false" : conf[2]) + System.lineSeparator());
				savedF.write((conf[3].equals("null") ? 0 : conf[3]) + System.lineSeparator());
				savedF.write((conf[4].equals("null") ? "false" : conf[4]) + System.lineSeparator());
				savedF.write((conf[5].equals("null") ? 0 : conf[5]) + System.lineSeparator());
				savedF.write((conf[6].equals("null") ? 0 : conf[6]) + System.lineSeparator());// speed
				savedF.write((conf[7].equals("null") ? 0 : conf[7]) + System.lineSeparator());// lan
				savedF.write(1 + System.lineSeparator());// effect chooser
				savedF.write((conf[9].equals("null") ? "1,1" : conf[9]) + System.lineSeparator());// intro
				savedF.close();
			} catch (Exception e2) {
				JOptionPane opt = new JOptionPane(
						language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
						JOptionPane.ERROR_MESSAGE);
				opt.show();
			}
		});
		sumV3.addActionListener(e -> {
			effChooser = 2;
			sumV1.setEnabled(true);
			sumV2.setEnabled(true);
			sumV3.setEnabled(false);
			conf[8] = "2";
			try {
				FileWriter savedF = new FileWriter(newFile);
				savedF.write((conf[0].equals("null") ? 0 : conf[0]) + System.lineSeparator());
				savedF.write((conf[1].equals("null") ? 0 : conf[1]) + System.lineSeparator());
				savedF.write((conf[2].equals("null") ? "false" : conf[2]) + System.lineSeparator());
				savedF.write((conf[3].equals("null") ? 0 : conf[3]) + System.lineSeparator());
				savedF.write((conf[4].equals("null") ? "false" : conf[4]) + System.lineSeparator());
				savedF.write((conf[5].equals("null") ? 0 : conf[5]) + System.lineSeparator());
				savedF.write((conf[6].equals("null") ? 0 : conf[6]) + System.lineSeparator());// speed
				savedF.write((conf[7].equals("null") ? 0 : conf[7]) + System.lineSeparator());// lan
				savedF.write(2 + System.lineSeparator());// effect chooser
				savedF.write((conf[9].equals("null") ? "1,1" : conf[9]) + System.lineSeparator());// intro
				savedF.close();
			} catch (Exception e2) {
				JOptionPane opt = new JOptionPane(
						language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
						JOptionPane.ERROR_MESSAGE);
				opt.show();
			}
		});
	}

	private void speedActionListener(JMenuItem speed1, JMenuItem speed2, JMenuItem speed3) {
		speed1.addActionListener(e -> {
			conf[6] = "0";
			try {
				FileWriter savedF = new FileWriter(newFile);
				savedF.write((conf[0].equals("null") ? 0 : conf[0]) + System.lineSeparator());
				savedF.write((conf[1].equals("null") ? 0 : conf[1]) + System.lineSeparator());
				savedF.write((conf[2].equals("null") ? "false" : conf[2]) + System.lineSeparator());
				savedF.write((conf[3].equals("null") ? 0 : conf[3]) + System.lineSeparator());
				savedF.write((conf[4].equals("null") ? "false" : conf[4]) + System.lineSeparator());
				savedF.write((conf[5].equals("null") ? 0 : conf[5]) + System.lineSeparator());
				savedF.write(0 + System.lineSeparator());// speed
				savedF.write((conf[7].equals("null") ? 0 : conf[7]) + System.lineSeparator());// lan
				savedF.write((conf[8].equals("null") ? 0 : conf[8]) + System.lineSeparator());// effchooser
				savedF.write((conf[9].equals("null") ? "1,1" : conf[9]) + System.lineSeparator());// intro
				savedF.close();
			} catch (Exception e2) {
				JOptionPane opt = new JOptionPane(
						language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
						JOptionPane.ERROR_MESSAGE);
				opt.show();
			}
			speed1.setEnabled(false);
			speed2.setEnabled(true);
			speed3.setEnabled(true);
		});
		speed2.addActionListener(e -> {
			conf[6] = "1";
			try {
				FileWriter savedF = new FileWriter(newFile);
				savedF.write((conf[0].equals("null") ? 0 : conf[0]) + System.lineSeparator());
				savedF.write((conf[1].equals("null") ? 0 : conf[1]) + System.lineSeparator());
				savedF.write((conf[2].equals("null") ? "false" : conf[2]) + System.lineSeparator());
				savedF.write((conf[3].equals("null") ? 0 : conf[3]) + System.lineSeparator());
				savedF.write((conf[4].equals("null") ? "false" : conf[4]) + System.lineSeparator());
				savedF.write((conf[5].equals("null") ? 0 : conf[5]) + System.lineSeparator());
				savedF.write(1 + System.lineSeparator());
				savedF.write((conf[7].equals("null") ? 0 : conf[7]) + System.lineSeparator());// lan
				savedF.write((conf[8].equals("null") ? 0 : conf[8]) + System.lineSeparator());// effchooser
				savedF.write((conf[9].equals("null") ? "1,1" : conf[9]) + System.lineSeparator());// intro
				savedF.close();
			} catch (Exception e2) {
				JOptionPane opt = new JOptionPane(
						language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
						JOptionPane.ERROR_MESSAGE);
				opt.show();
			}
			speed1.setEnabled(true);
			speed2.setEnabled(false);
			speed3.setEnabled(true);
		});
		speed3.addActionListener(e -> {
			conf[6] = "2";
			try {
				FileWriter savedF = new FileWriter(newFile);
				savedF.write((conf[0].equals("null") ? 0 : conf[0]) + System.lineSeparator());
				savedF.write((conf[1].equals("null") ? 0 : conf[1]) + System.lineSeparator());
				savedF.write((conf[2].equals("null") ? "false" : conf[2]) + System.lineSeparator());
				savedF.write((conf[3].equals("null") ? 0 : conf[3]) + System.lineSeparator());
				savedF.write((conf[4].equals("null") ? "false" : conf[4]) + System.lineSeparator());
				savedF.write((conf[5].equals("null") ? 0 : conf[5]) + System.lineSeparator());
				savedF.write(2 + System.lineSeparator());
				savedF.write((conf[7].equals("null") ? 0 : conf[7]) + System.lineSeparator());// lan
				savedF.write((conf[8].equals("null") ? 0 : conf[8]) + System.lineSeparator());// effchooser
				savedF.write((conf[9].equals("null") ? "1,1" : conf[9]) + System.lineSeparator());// intro
				savedF.close();
			} catch (Exception e2) {
				JOptionPane opt = new JOptionPane(
						language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
						JOptionPane.ERROR_MESSAGE);
				opt.show();
			}
			speed1.setEnabled(true);
			speed2.setEnabled(true);
			speed3.setEnabled(false);
		});
	}

	private void hideActionListener(JMenuItem hideBtn, JMenuItem noHide, JMenuItem hideDate, JMenuItem hideAll,
			JButton clearEverthing, JButton pesosF, JButton notasF, JButton newDay) {
		noHide.addActionListener(e -> {
			conf[1] = "0";
			noHide.setEnabled(false);
			hideDate.setEnabled(true);
			hideBtn.setEnabled(true);
			hideAll.setEnabled(true);
			try {
				FileWriter savedF = new FileWriter(newFile);
				savedF.write((conf[0].equals("null") ? 0 : conf[0]) + System.lineSeparator());
				savedF.write(0 + System.lineSeparator());
				savedF.write((conf[2].equals("null") ? "false" : conf[2]) + System.lineSeparator());
				savedF.write((conf[3].equals("null") ? 0 : conf[3]) + System.lineSeparator());
				savedF.write((conf[4].equals("null") ? "false" : conf[4]) + System.lineSeparator());
				savedF.write((conf[5].equals("null") ? 0 : conf[5]) + System.lineSeparator());
				savedF.write((conf[6].equals("null") ? 0 : conf[6]) + System.lineSeparator());
				savedF.write((conf[7].equals("null") ? 0 : conf[7]) + System.lineSeparator());// lan
				savedF.write((conf[8].equals("null") ? 0 : conf[8]) + System.lineSeparator());// effchooser
				savedF.write((conf[9].equals("null") ? "1,1" : conf[9]) + System.lineSeparator());// intro
				savedF.close();
			} catch (Exception e2) {
				JOptionPane opt = new JOptionPane(
						language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
						JOptionPane.ERROR_MESSAGE);
				opt.show();
			}
			pesosF.show();
			clearEverthing.show();
			notasF.show();
			date.show();
		});
		hideDate.addActionListener(e -> {
			conf[1] = "1";
			noHide.setEnabled(true);
			hideDate.setEnabled(false);
			hideBtn.setEnabled(true);
			hideAll.setEnabled(true);
			try {
				FileWriter savedF = new FileWriter(newFile);
				savedF.write((conf[0].equals("null") ? 0 : conf[0]) + System.lineSeparator());
				savedF.write(1 + System.lineSeparator());
				savedF.write((conf[2].equals("null") ? "false" : conf[2]) + System.lineSeparator());
				savedF.write((conf[3].equals("null") ? 0 : conf[3]) + System.lineSeparator());
				savedF.write((conf[4].equals("null") ? "false" : conf[4]) + System.lineSeparator());
				savedF.write((conf[5].equals("null") ? 0 : conf[5]) + System.lineSeparator());
				savedF.write((conf[6].equals("null") ? 0 : conf[6]) + System.lineSeparator());
				savedF.write((conf[7].equals("null") ? 0 : conf[7]) + System.lineSeparator());// lan
				savedF.write((conf[8].equals("null") ? 0 : conf[8]) + System.lineSeparator());// effchooser
				savedF.write((conf[9].equals("null") ? "1,1" : conf[9]) + System.lineSeparator());// intro
				savedF.close();
			} catch (Exception e2) {
				JOptionPane opt = new JOptionPane(
						language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
						JOptionPane.ERROR_MESSAGE);
				opt.show();
			}
			date.hide();
			pesosF.show();
			clearEverthing.show();
			notasF.show();
		});
		hideBtn.addActionListener(e -> {
			conf[1] = "2";
			noHide.setEnabled(true);
			hideDate.setEnabled(true);
			hideBtn.setEnabled(false);
			hideAll.setEnabled(true);
			try {
				FileWriter savedF = new FileWriter(newFile);
				savedF.write((conf[0].equals("null") ? 0 : conf[0]) + System.lineSeparator());
				savedF.write(2 + System.lineSeparator());
				savedF.write((conf[2].equals("null") ? "false" : conf[2]) + System.lineSeparator());
				savedF.write((conf[3].equals("null") ? 0 : conf[3]) + System.lineSeparator());
				savedF.write((conf[4].equals("null") ? "false" : conf[4]) + System.lineSeparator());
				savedF.write((conf[5].equals("null") ? 0 : conf[5]) + System.lineSeparator());
				savedF.write((conf[6].equals("null") ? 0 : conf[6]) + System.lineSeparator());
				savedF.write((conf[7].equals("null") ? 0 : conf[7]) + System.lineSeparator());// lan
				savedF.write((conf[8].equals("null") ? 0 : conf[8]) + System.lineSeparator());// effchooser
				savedF.write((conf[9].equals("null") ? "1,1" : conf[9]) + System.lineSeparator());// intro
				savedF.close();
			} catch (Exception e2) {
				JOptionPane opt = new JOptionPane(
						language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
						JOptionPane.ERROR_MESSAGE);
				opt.show();
			}
			hideBtn(notasF, pesosF, newDay, clearEverthing, hideBtn);
			date.show();
		});
		hideAll.addActionListener(e -> {
			conf[1] = "3";
			noHide.setEnabled(true);
			hideDate.setEnabled(true);
			hideBtn.setEnabled(true);
			hideAll.setEnabled(false);
			try {
				FileWriter savedF = new FileWriter(newFile);
				savedF.write((conf[0].equals("null") ? 0 : conf[0]) + System.lineSeparator());
				savedF.write(3 + System.lineSeparator());
				savedF.write((conf[2].equals("null") ? "false" : conf[2]) + System.lineSeparator());
				savedF.write((conf[3].equals("null") ? 0 : conf[3]) + System.lineSeparator());
				savedF.write((conf[4].equals("null") ? "false" : conf[4]) + System.lineSeparator());
				savedF.write((conf[5].equals("null") ? 0 : conf[5]) + System.lineSeparator());
				savedF.write((conf[6].equals("null") ? 0 : conf[6]) + System.lineSeparator());
				savedF.write((conf[7].equals("null") ? 0 : conf[7]) + System.lineSeparator());// lan
				savedF.write((conf[8].equals("null") ? 0 : conf[8]) + System.lineSeparator());// effchooser
				savedF.write((conf[9].equals("null") ? "1,1" : conf[9]) + System.lineSeparator());// intro
				savedF.close();
			} catch (Exception e2) {
				JOptionPane opt = new JOptionPane(
						language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
						JOptionPane.ERROR_MESSAGE);
				opt.show();
			}
			hideBtn(notasF, pesosF, newDay, clearEverthing, hideBtn);
			date.hide();
		});
	}

	// Auto-complete words for gastos and agregados
	private ArrayList<String> gastosYagregados() {
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

	FocusListener textFocus = new FocusListener() {

		@Override
		public void focusGained(FocusEvent e) {
			((JTextField) e.getSource()).selectAll();
		}

		@Override
		public void focusLost(FocusEvent e) {
			sumF();
		}
	};

}
