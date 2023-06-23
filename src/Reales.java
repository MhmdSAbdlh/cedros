/*
 CTRL + / Folding enabled or disable using toggle switch
Ctrl + * : expands code block After folding is enabled, The below command works
Collapse All -> Ctrl + Shift + / (Numpad Divide)
Expand All -> Ctrl + Shift + * (Numpad Multiply)

Ctrl + Shift + F : clean code
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.border.EmptyBorder;
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
	private URL frP = getClass().getResource("images/menubar/france.png");
	private ImageIcon frI = new ImageIcon(frP);
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
	private URL monthlyP = getClass().getResource("images/menubar/month.png");
	private ImageIcon monthlyI = new ImageIcon(monthlyP);
	private URL yearP = getClass().getResource("images/menubar/year.png");
	private ImageIcon yearI = new ImageIcon(yearP);
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
	// Define values
	static int totalCol = 0, totalVenta = 0, totalO = 0;
	static int gastosT = 0, agregadoT = 0, pix = 0;
	static int restN, totalCaja = 0, nbOf20 = 0;
	int width, height, language;
	static int colorX = 0, order = 0, speedValue, wordsN, wordL, effChooser, colorBW = 254;
	boolean status = false;
	Timer timer;
	String conf[] = new String[10];
	// date
	JLabel dateLabel = new JLabel();
	DateModified currentDate;
	String dayN = new SimpleDateFormat("dd").format(Calendar.getInstance().getTime());
	String yearS = new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime());
	String monthS, dayS, lastChanged;
	int dayReturned = 1, monthReturned = 1, value22;
	int sameDayAvg, dailyAvg, monthlyAvg, dailyAvg22;
	ArrayList<String> con23 = new ArrayList<String>();
	ArrayList<String> con22 = new ArrayList<String>();
	JLabel lastChange = new JLabel();

	String currentpath = System.getProperty("user.dir");
	File tempFile0 = new File(currentpath + "\\data");
	File newFile = new File(tempFile0, "conf.dll");
	Encryption encrypt = new Encryption();
	String sepData[] = new String[11];

	Reales() {
		// month foto
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
		else if (conf[7].equals("2"))
			language = 2;
		else
			language = 3;
		// date according to lang
		dateLang(language);
		currentDate = new DateModified(Integer.valueOf(dayN), Integer.valueOf(First.monthN), Integer.valueOf(yearS));
		value22 = Integer.valueOf(vend2022(Integer.valueOf(dayN + "" + First.monthN)));
		try {// open the data for 2023
			File extraFolder = new File(tempFile0 + "\\extra");
			File extraFile = new File(extraFolder, "2023.dll");
			BufferedReader data23 = new BufferedReader(new FileReader(extraFile));
			String ln23 = "";
			while ((ln23 = data23.readLine()) != null) {
				con23.add(ln23.toString());
			}
			data23.close();
		} catch (Exception e) {
			JOptionPane opt = new JOptionPane("ERROR!", JOptionPane.ERROR_MESSAGE);
			opt.show();
		}
		sameDayAvg = avgSellOfDay(currentDate);
		dailyAvg = dailyAvg();
		monthlyAvg = monTotalAverage(currentDate.m)[1] == 0 ? 0
				: monTotalAverage(currentDate.m)[0] / monTotalAverage(currentDate.m)[1];

		try {// open the data for 2022
			String appV;
			if (conf[0] == null || !conf[0].equals("3"))
				appV = "2022C.dll";
			else
				appV = "2022N.dll";
			BufferedReader data22 = new BufferedReader(
					new InputStreamReader(this.getClass().getResourceAsStream("/extra/" + appV)));
			String ln23 = "";
			while ((ln23 = data22.readLine()) != null) {
				con22.add(ln23.toString());
			}
			data22.close();
		} catch (Exception e) {
			JOptionPane opt = new JOptionPane("ERROR!", JOptionPane.ERROR_MESSAGE);
			opt.show();
		}

		// daily average
		int var = 0, counter = 0, nbOfDays = 0;
		while (var < con22.size()) {
			if (First.isNumeric(con22.get(var))) {
				counter += Integer.valueOf(con22.get(var));
				nbOfDays++;
			}
			var++;
		}
		dailyAvg22 = counter / nbOfDays;

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
		JButton aggPanel = new JButton(idiomaString(language)[41]);
		JButton gastosPanel = new JButton(idiomaString(language)[41]);
		JButton pixMore = new JButton();

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
			dateLabel.show();
		} else if (conf[1].equals("1")) {// hide date
			noHide.setEnabled(true);
			hideDate.setEnabled(false);
			hideBtn.setEnabled(true);
			hideAll.setEnabled(true);
			pesosF.show();
			clearEverthing.show();
			notasF.show();
			dateLabel.hide();
		} else if (conf[1].equals("2")) {// hide btn
			noHide.setEnabled(true);
			hideDate.setEnabled(true);
			hideBtn.setEnabled(false);
			hideAll.setEnabled(true);
			hideBtn(notasF, pesosF, newDay, clearEverthing, hideBtn);
			dateLabel.show();
		} else {// hide all
			noHide.setEnabled(true);
			hideDate.setEnabled(true);
			hideBtn.setEnabled(true);
			hideAll.setEnabled(false);
			hideBtn(notasF, pesosF, newDay, clearEverthing, hideBtn);
			dateLabel.hide();
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
		dateLabel.setText(" " + dayS + ", " + dayN + "-" + monthS + "-" + yearS);
		dateLabel.setForeground(First.lightC);
		dateLabel.setFont(First.myFont);
		this.add(dateLabel);

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
		ArrayList<String> keywords = First.gastosYagregados();
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
		panelFoto[10].setBackground(Color.DARK_GRAY);
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
		// pix btn
		pixMore.setText(idiomaString(language)[41]);
		First.btnStyle(pixMore);
		pixMore.setBackground(First.darkC);
		pixMore.setForeground(First.lightC);
		pixMore.addActionListener(e -> pixFrame());
		pixMore.addMouseListener(new MouseListener() {
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
				pixMore.setBackground(First.darkC);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				pixMore.setBackground(Color.black);
			}

		});
		this.add(pixMore);

		// Panel 5 DIFFERENCE
		diffResult[0] = new JLabel("Diferencia");
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
		lastChange.setText((language == 0 ? "ÚLTIMA ACTUALIZACIÓN: "
				: language == 1 ? "ÚLTIMA ATUALIZAÇÃO: " : language == 2 ? "LAST UPDATE: " : "DERNIÈRE MISE À JOUR: ")
				+ "07:30:00");
		lastChange.setForeground(First.lightC);
		lastChange.setFont(First.myFontXS);
		this.add(lastChange);

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
		save.addActionListener(e -> {
			saveProgress();
			First.savedCorrectly(language);
		});
		screenShot.addActionListener(e -> {
			fadeEffect(Reales.this, 40);
			screenShooter();
			First.savedCorrectly(language);
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
				reso3, reso4, pixMore);
		// extra
		JMenu extraM = new JMenu("EXTRA");
		JMenuItem oldYears = new JMenuItem(idiomaString(language)[31]);
		JMenu monthAvg = new JMenu(idiomaString(language)[36]);
		JMenu monthOtherLang = new JMenu(idiomaString(language)[37]);
		JMenuItem yearSumm = new JMenuItem(idiomaString(language)[40]);
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
		JMenuItem exMenuR = new JMenuItem(
				language == 0 ? "ESPAÑOL" : language == 1 ? "PORTUGUÊS" : language == 2 ? "ENGLISH" : "FRENCH");
		JMenuItem exMenuS = new JMenuItem("ESPAÑOL");
		JMenuItem exMenuP = new JMenuItem("PORTUGUÊS");
		JMenuItem exMenuE = new JMenuItem("ENGLISH");
		JMenuItem exMenuF = new JMenuItem("FRENCH");
		JMenu speedChooser = new JMenu();
		JMenuItem speed1 = new JMenuItem();
		JMenuItem speed2 = new JMenuItem();
		JMenuItem speed3 = new JMenuItem();
		oldYears.addActionListener(e -> memoryFrame());
		// month selected
		monthSelected[0] = new JMenuItem(currentDate.getMonthForInt(Integer.valueOf(First.monthN) - 1, language));
		monthSelected[0].addActionListener(e -> monthAvgFrame(Integer.valueOf(First.monthN)));
		for (int i = 1; i < 13; i++)
			monthSelected[i] = new JMenuItem(currentDate.getMonthForInt(i - 1, language));
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
			JPasswordField pwd = new JPasswordField(10);
			Object[] obj = { "", pwd };
			Object stringArray[] = { "OK", "NO" };
			int action = JOptionPane.showOptionDialog(null, pwd, idiomaString(language)[32], JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, memI, stringArray, obj);
			if (action != 0)
				JOptionPane.showMessageDialog(null, idiomaString(language)[33]);// cancel
			else {
				String hoy = new SimpleDateFormat("hh").format(Calendar.getInstance().getTime())
						+ new SimpleDateFormat("mm").format(Calendar.getInstance().getTime());
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
		yearSumm.addActionListener(e -> yearSumFram());
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
		exMenuF.addActionListener(e -> exBtn(3));
		exMenu.add(exMenuR);
		exMenu.add(sep3);
		exMenu.add(exMenuD);
		exMenuD.add(exMenuS);
		exMenuD.add(exMenuP);
		exMenuD.add(exMenuE);
		exMenuD.add(exMenuF);
		if (language == 0)
			exMenuS.hide();
		else if (language == 1)
			exMenuP.hide();
		else if (language == 2)
			exMenuE.hide();
		else
			exMenuF.hide();
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
		extraM.add(yearSumm);
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
		monthAvg.setIcon(new ImageIcon(getScaledImage(monthlyI.getImage(), 35, 35)));
		yearSumm.setIcon(new ImageIcon(getScaledImage(yearI.getImage(), 35, 35)));
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
		else if (language == 2)
			exMenuR.setIcon(new ImageIcon(getScaledImage(engI.getImage(), 35, 35)));
		else
			exMenuR.setIcon(new ImageIcon(getScaledImage(frI.getImage(), 35, 35)));
		exMenuD.setIcon(new ImageIcon(getScaledImage(defaultI.getImage(), 35, 35)));
		exMenuS.setIcon(new ImageIcon(getScaledImage(espI.getImage(), 35, 35)));
		exMenuP.setIcon(new ImageIcon(getScaledImage(porI.getImage(), 35, 35)));
		exMenuE.setIcon(new ImageIcon(getScaledImage(engI.getImage(), 35, 35)));
		exMenuF.setIcon(new ImageIcon(getScaledImage(frI.getImage(), 35, 35)));
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
					gastosPanel, pixMore);
		} else if (conf[3].equals("1"))
			resXP(resoD, reso4, reso3, reso2, reso1, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel,
					pixMore);
		else if (conf[3].equals("2"))
			resP(resoD, reso4, reso3, reso2, reso1, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel,
					pixMore);
		else if (conf[3].equals("3"))
			resM(resoD, reso4, reso3, reso2, reso1, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel,
					pixMore);
		else
			resG(resoD, reso4, reso3, reso2, reso1, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel,
					pixMore);

		// import sep
		importSep();

		// disable memory frame in 29/feb
		if (currentDate.d == 29 && currentDate.m == 2) {
			oldYears.setEnabled(false);
			oldYears.setText(language == 0 ? "BLOQUEO HOY!"
					: language == 1 ? "BLOQUEO HOJE!" : language == 2 ? "DISABLED TODAY!" : "HANDICAPÉ AUJOURD'HUI !");
		}

		// LANGUAGE
		idiomaTexts(language, hideBtn, noHide, hideDate, hideAll, notasF, newDay, resoD, aggPanel, gastosPanel, file,
				novo, clear, calc, save, screenShot, option, exit, summary, sumV, effectChooser, sumV1, sumV2, sumV3,
				exMenu, speedChooser, speed1, speed2, speed3, goTo, pesos, fatura, firstFrame, reso, reso1, reso2,
				reso3, reso4, help, hideMenu, keyShortcut, creator, about);

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
					if (currentDate.d != 29 || currentDate.m != 2)
						currentDate.saveTotal23(totalVenta);
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

	// year frame
	private void yearSumFram() {
		JFrame extraF = new JFrame(idiomaString(language)[40]);
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
		// btns
		JButton expBtn = new JButton();
		expBtn.setIcon(expI);
		expBtn.setContentAreaFilled(false);
		expBtn.setBorderPainted(false);
		expBtn.setBounds(140, 430, 50, 50);
		expBtn.setVisible(false);
		expBtn.addActionListener(e -> exYearFrame());
		extraF.add(expBtn);
		// LABEL
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

		int temp[] = yearMaxMin();
		int maxDIndex = currentDate.dayFromIndex(temp[2]);
		String maxDayString = dayName(new DateModified(maxDIndex, monthFromIndex(temp[2]), 2023), language);
		int minDIndex = currentDate.dayFromIndex(temp[3]);
		String minDayString = dayName(new DateModified(minDIndex, monthFromIndex(temp[3]), 2023), language);
		String[] avgOfMonths = monthsText(Integer.valueOf(First.monthN));
		int daysAvg[] = new int[7];
		double daysPerc[] = new double[7];
		// days avg
		daysAvg[0] = avgSellOfDay(new DateModified(2, 1, 2023));
		daysAvg[1] = avgSellOfDay(new DateModified(3, 1, 2023));
		daysAvg[2] = avgSellOfDay(new DateModified(4, 1, 2023));
		daysAvg[3] = avgSellOfDay(new DateModified(5, 1, 2023));
		daysAvg[4] = avgSellOfDay(new DateModified(6, 1, 2023));
		daysAvg[5] = avgSellOfDay(new DateModified(7, 1, 2023));
		daysAvg[6] = avgSellOfDay(new DateModified(8, 1, 2023));
		daysPerc[0] = (double) daysAvg[0] * 100
				/ (daysAvg[0] + daysAvg[1] + daysAvg[2] + daysAvg[3] + daysAvg[4] + daysAvg[5] + daysAvg[6]);
		daysPerc[1] = (double) daysAvg[1] * 100
				/ (daysAvg[0] + daysAvg[1] + daysAvg[2] + daysAvg[3] + daysAvg[4] + daysAvg[5] + daysAvg[6]);
		daysPerc[2] = (double) daysAvg[2] * 100
				/ (daysAvg[0] + daysAvg[1] + daysAvg[2] + daysAvg[3] + daysAvg[4] + daysAvg[5] + daysAvg[6]);
		daysPerc[3] = (double) daysAvg[3] * 100
				/ (daysAvg[0] + daysAvg[1] + daysAvg[2] + daysAvg[3] + daysAvg[4] + daysAvg[5] + daysAvg[6]);
		daysPerc[4] = (double) daysAvg[4] * 100
				/ (daysAvg[0] + daysAvg[1] + daysAvg[2] + daysAvg[3] + daysAvg[4] + daysAvg[5] + daysAvg[6]);
		daysPerc[5] = (double) daysAvg[5] * 100
				/ (daysAvg[0] + daysAvg[1] + daysAvg[2] + daysAvg[3] + daysAvg[4] + daysAvg[5] + daysAvg[6]);
		daysPerc[6] = (double) daysAvg[6] * 100
				/ (daysAvg[0] + daysAvg[1] + daysAvg[2] + daysAvg[3] + daysAvg[4] + daysAvg[5] + daysAvg[6]);
		for (int i = 0; i < 7; i++) {
			daysPerc[i] = Math.round(daysPerc[i] * 100);
			daysPerc[i] = daysPerc[i] / 100;
		}
		sumItem.addKeyListener(new KeyAdapter() {// Escape to close
			@SuppressWarnings("static-access")
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyCode() == ke.VK_ESCAPE) {
					wordL = 0;
					order = 0;
					timer.stop();
					extraF.dispose();
				}
			}
		});
		String[] espSumm = {
				"*ESTE AÑO\n\nVENDIMOS POR AHORA UN PROMEDIO DE R$" + dailyAvg + "\n\n\n"
						+ "*EL AÑO PASADO\n\nVENDIMOS UN PROMEDIO DE R$" + dailyAvg22 + "\n\n\n"
						+ "*SE PARECE QUE VENDIMOS\n\nR$"
						+ (dailyAvg > dailyAvg22
								? (dailyAvg - dailyAvg22) + " MÁS QUE EL AÑO PASADO ( ⬆ "
										+ 100 * (dailyAvg - dailyAvg22) / dailyAvg22 + "%)"
								: (dailyAvg22 - dailyAvg) + " MENOS QUE EL AÑO PASADO ( ⬇ "
										+ 100 * (dailyAvg22 - dailyAvg) / dailyAvg22 + "%)"), // 0
				"*EL MEJOR DÍA DE ESTE AÑO ES " + maxDayString + " " + maxDIndex + "-"
						+ currentDate.getMonthForInt(monthFromIndex(temp[2]) - 1, 0) + "\n\nLO QUE VENDIMOS R$"
						+ temp[0] + "\n\n\n" + "*EL PEOR DÍA DE ESTE AÑO ES " + minDayString + " " + minDIndex + "-"
						+ currentDate.getMonthForInt(monthFromIndex(temp[3]) - 1, 0) + "\n\nLO QUE VENDIMOS R$"
						+ temp[1], // 1
				avgOfMonths[0] + "\n" + avgOfMonths[1] + "\n" + avgOfMonths[2] + "\n" + avgOfMonths[3] + "\n"
						+ avgOfMonths[4] + "\n" + avgOfMonths[5], // 2
				"\n" + avgOfMonths[6] + "\n" + avgOfMonths[7] + "\n" + avgOfMonths[8] + "\n" + avgOfMonths[9] + "\n"
						+ avgOfMonths[10] + "\n" + avgOfMonths[11], // 3 months
				"*EL MEJOR MES DEL AÑO FUE " + currentDate.getMonthForInt(Integer.valueOf(avgOfMonths[14]), 0) + "\n\n"
						+ "LO QUE VENDIMOS UN PROMEDIO DE R$" + avgOfMonths[12] + "\n\n\n" + "*EL PEOR MES DEL AÑO FUE "
						+ currentDate.getMonthForInt(Integer.valueOf(avgOfMonths[15]), 0) + "\n\n"
						+ "LO QUE VENDIMOS UN PROMEDIO DE R$" + avgOfMonths[13], // 4 MAX AND MIN FOR THE MONTH
				"*LA MEDIA SEGÚN EL DÍA SON:\n\nLUNES -> R$" + daysAvg[0] + " (%" + daysPerc[0] + ")\n\nMARTES -> R$"
						+ daysAvg[1] + " (%" + daysPerc[1] + ")\n\nMIÉRCOLES -> R$" + daysAvg[2] + " (%" + daysPerc[2]
						+ ")\n\nJUEVES -> R$" + daysAvg[3] + " (%" + daysPerc[3] + ")\n\nVIERNES -> R$" + daysAvg[4]
						+ " (%" + daysPerc[4] + ")\n\nSÁBADO -> R$" + daysAvg[5] + " (%" + daysPerc[5]
						+ ")\n\nDOMINGO -> R$" + daysAvg[6] + " (%" + daysPerc[6] + ")"// 5
		};
		String[] porSumm = {
				"*ESTE ANO\n\nVENDEMOS POR AGORA UMA MÉDIA DE R$" + dailyAvg + "\n\n\n"
						+ "*ANO PASSADO\n\nVENDEMOS EM MÉDIA DE R$" + dailyAvg22 + "\n\n\n"
						+ "*PARECE QUE VENDEMOS\n\nR$"
						+ (dailyAvg > dailyAvg22
								? (dailyAvg - dailyAvg22) + " MAIS QUE ANO PASSADO ( ⬆ "
										+ 100 * (dailyAvg - dailyAvg22) / dailyAvg22 + "%)"
								: (dailyAvg22 - dailyAvg) + " MENOS QUE ANO PASSADO ( ⬇ "
										+ 100 * (dailyAvg22 - dailyAvg) / dailyAvg22 + "%)"), // 0
				"*O MELHOR DIA DESTE ANO É " + maxDayString + " " + maxDIndex + "-"
						+ currentDate.getMonthForInt(monthFromIndex(temp[2]) - 1, 1) + "\n\nO QUE VENDEMOS R$" + temp[0]
						+ "\n\n\n" + "*O PIOR DIA DO ANO É " + minDayString + " " + minDIndex + "-"
						+ currentDate.getMonthForInt(monthFromIndex(temp[3]) - 1, 1) + "\n\nO QUE VENDEMOS R$"
						+ temp[1], // 1
				avgOfMonths[0] + "\n" + avgOfMonths[1] + "\n" + avgOfMonths[2] + "\n" + avgOfMonths[3] + "\n"
						+ avgOfMonths[4] + "\n" + avgOfMonths[5], // 2
				avgOfMonths[6] + "\n" + avgOfMonths[7] + "\n" + avgOfMonths[8] + "\n" + avgOfMonths[9] + "\n"
						+ avgOfMonths[10] + "\n" + avgOfMonths[11], // 3
				"*O MELHOR MÊS DO ANO FOI " + currentDate.getMonthForInt(Integer.valueOf(avgOfMonths[14]), 1) + "\n\n"
						+ "O QUE VENDEMOS EM MÉDIA R$" + avgOfMonths[12] + "\n\n\n" + "*O PIOR MÊS DO ANO FOI "
						+ currentDate.getMonthForInt(Integer.valueOf(avgOfMonths[15]), 1) + "\n\n"
						+ "O QUE VENDEMOS EM MÉDIA R$" + avgOfMonths[13], // 4 MAX AND MIN FOR THE MONTH
				"*A MÉDIA DE ACORDO COM O DIA SÃO:\n\nSEGUNDA-FEIRA -> R$" + daysAvg[0] + " (%" + daysPerc[0]
						+ ")\n\nTERÇA-FEIRA -> R$" + daysAvg[1] + " (%" + daysPerc[1] + ")\n\nQUARTA-FEIRA -> R$"
						+ daysAvg[2] + " (%" + daysPerc[2] + ")\n\nQUINTA-FEIRA -> R$" + daysAvg[3] + " (%"
						+ daysPerc[3] + ")\n\nSEXTA-FEIRA -> R$" + daysAvg[4] + " (%" + daysPerc[4]
						+ ")\n\nSÁBADO -> R$" + daysAvg[5] + " (%" + daysPerc[5] + ")\n\nDOMINGO -> R$" + daysAvg[6]
						+ " (%" + daysPerc[6] + ")"// 5
		};
		String[] engSumm = {
				"*THIS YEAR\n\nWE SOLD FOR NOW AN AVERAGE OF R$" + dailyAvg + "\n\n\n"
						+ "*LAST YEAR\n\nWE SOLD AN AVERAGE OF R$" + dailyAvg22 + "\n\n\n"
						+ "*IT LOOKS LIKE WE SOLD\n\nR$"
						+ (dailyAvg > dailyAvg22
								? (dailyAvg - dailyAvg22) + " MORE THAN LAST YEAR ( ⬆ "
										+ 100 * (dailyAvg - dailyAvg22) / dailyAvg22 + "%)"
								: (dailyAvg22 - dailyAvg) + " LESS THAN LAST YEAR ( ⬇ "
										+ 100 * (dailyAvg22 - dailyAvg) / dailyAvg22 + "%)"), // 0
				"*THE BEST DAY OF THIS YEAR IS " + maxDayString + " " + maxDIndex + "-"
						+ currentDate.getMonthForInt(monthFromIndex(temp[2]) - 1, 2) + "\n\nWHAT WE SOLD R$" + temp[0]
						+ "\n\n\n" + "*THE WORST DAY OF THIS YEAR IS " + minDayString + " " + minDIndex + "-"
						+ currentDate.getMonthForInt(monthFromIndex(temp[3]) - 1, 2) + "\n\nWHAT WE SOLD R$" + temp[1], // 1
				avgOfMonths[0] + "\n" + avgOfMonths[1] + "\n" + avgOfMonths[2] + "\n" + avgOfMonths[3] + "\n"
						+ avgOfMonths[4] + "\n" + avgOfMonths[5], // 2
				avgOfMonths[6] + "\n" + avgOfMonths[7] + "\n" + avgOfMonths[8] + "\n" + avgOfMonths[9] + "\n"
						+ avgOfMonths[10] + "\n" + avgOfMonths[11], // 3
				"*THE BEST MONTH OF THE YEAR WAS " + currentDate.getMonthForInt(Integer.valueOf(avgOfMonths[14]), 2)
						+ "\n\n" + "WHAT WE SOLD AN AVERAGE OF R$" + avgOfMonths[12] + "\n\n\n"
						+ "*THE WORST MONTH OF THE YEAR WAS "
						+ currentDate.getMonthForInt(Integer.valueOf(avgOfMonths[15]), 2) + "\n\n"
						+ "WHAT WE SOLD AN AVERAGE OF R$" + avgOfMonths[13], // 4 MAX AND MIN FOR THE MONTH
				"*THE AVERAGE ACCORDING TO THE DAY ARE:\n\nMONDAY -> R$" + daysAvg[0] + " (%" + daysPerc[0]
						+ ")\n\nTUESDAY -> R$" + daysAvg[1] + " (%" + daysPerc[1] + ")\n\nWEDNESDAY -> R$" + daysAvg[2]
						+ " (%" + daysPerc[2] + ")\n\nTHURSDAY -> R$" + daysAvg[3] + " (%" + daysPerc[3]
						+ ")\n\nFRIDAY -> R$" + daysAvg[4] + " (%" + daysPerc[4] + ")\n\nSATURDAY -> R$" + daysAvg[5]
						+ " (%" + daysPerc[5] + ")\n\nSUNDAY -> R$" + daysAvg[6] + " (%" + daysPerc[6] + ")"// 5
		};
		String[] frSumm = {
				"*CETTE ANNÉE\n\nNOUS AVONS VENDU POUR L'INSTANT UNE MOYENNE DE R$" + dailyAvg + "\n\n\n"
						+ "*L'ANNÉE DERNIÈRE\n\nNOUS AVONS VENDU UNE MOYENNE DE R$" + dailyAvg22 + "\n\n\n"
						+ "*IL SEMBLE QUE NOUS AVONS VENDU\n\nR$"
						+ (dailyAvg > dailyAvg22
								? (dailyAvg - dailyAvg22) + " PLUS QUE L'AN DERNIER ( ⬆ "
										+ 100 * (dailyAvg - dailyAvg22) / dailyAvg22 + "%)"
								: (dailyAvg22 - dailyAvg) + " MOINS QUE L'AN DERNIER ( ⬇ "
										+ 100 * (dailyAvg22 - dailyAvg) / dailyAvg22 + "%)"), // 0
				"* LE MEILLEUR JOUR DE CETTE ANNÉE EST " + maxDayString + " " + maxDIndex + "-"
						+ currentDate.getMonthForInt(monthFromIndex(temp[2]) - 1, 3) + "\n\nCE QUE NOUS AVONS VENDU R$"
						+ temp[0] + "\n\n\n" + "* LE PIRE JOUR DE CETTE ANNÉE EST " + minDayString + " " + minDIndex
						+ "-" + currentDate.getMonthForInt(monthFromIndex(temp[3]) - 1, 3)
						+ "\n\nCE QUE NOUS AVONS VENDU R$" + temp[1], // 1
				avgOfMonths[0] + "\n" + avgOfMonths[1] + "\n" + avgOfMonths[2] + "\n" + avgOfMonths[3] + "\n"
						+ avgOfMonths[4] + "\n" + avgOfMonths[5], // 2
				avgOfMonths[6] + "\n" + avgOfMonths[7] + "\n" + avgOfMonths[8] + "\n" + avgOfMonths[9] + "\n"
						+ avgOfMonths[10] + "\n" + avgOfMonths[11], // 3
				"* LE MEILLEUR MOIS DE L'ANNÉE A ÉTÉ " + currentDate.getMonthForInt(Integer.valueOf(avgOfMonths[14]), 3)
						+ "\n\n" + "CE QUE NOUS AVONS VENDU EN MOYENNE DE R$" + avgOfMonths[12] + "\n\n\n"
						+ "* LE PIRE MOIS DE L'ANNÉE A ÉTÉ "
						+ currentDate.getMonthForInt(Integer.valueOf(avgOfMonths[15]), 3) + "\n\n"
						+ "CE QUE NOUS AVONS VENDU EN MOYENNE DE R$" + avgOfMonths[13], // 4 MAX ET MIN POUR LE MOIS
				"*LA MOYENNE SELON LE JOUR EST :\n\nLUNDI -> R$" + daysAvg[0] + " (%" + daysPerc[0] + ")\n\nMARDI -> R$"
						+ daysAvg[1] + " (%" + daysPerc[1] + ")\n\nMERCREDI -> R$" + daysAvg[2] + " (%" + daysPerc[2]
						+ ")\n\nJEUDI -> R$" + daysAvg[3] + " (%" + daysPerc[3] + ")\n\nVENDREDI -> R$" + daysAvg[4]
						+ " (%" + daysPerc[4] + ")\n\nSAMEDI -> R$" + daysAvg[5] + " (%" + daysPerc[5]
						+ ")\n\nDIMANCHE -> R$" + daysAvg[6] + " (%" + daysPerc[6] + ")"// 5
		};
		ActionListener letterByLetter = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				switch (order) {
				case 0: {
					char[] wordT = (language == 0 ? espSumm[0]
							: language == 1 ? porSumm[0] : language == 2 ? engSumm[0] : frSumm[0]).toCharArray();
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText() + wordT[wordL++]);
					else {
						if (wordL < wordT.length + 15) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 1: {
					sumItem.setBounds(30, 170, 590, 550);
					char[] wordT = (language == 0 ? espSumm[1]
							: language == 1 ? porSumm[1] : language == 2 ? engSumm[1] : frSumm[1]).toCharArray();
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText() + wordT[wordL++]);
					else {
						if (wordL < wordT.length + 15) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 2: {
					sumItem.setBounds(30, 170, 590, 550);
					char[] wordT = (language == 0 ? espSumm[2]
							: language == 1 ? porSumm[2] : language == 2 ? engSumm[2] : frSumm[2]).toCharArray();
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText() + wordT[wordL++]);
					else {
						if (wordL < wordT.length + 15) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 3: {
					sumItem.setBounds(30, 170, 590, 550);
					char[] wordT = (language == 0 ? espSumm[3]
							: language == 1 ? porSumm[3] : language == 2 ? engSumm[3] : frSumm[3]).toCharArray();
					if (String.valueOf(wordT).isBlank()) {
						order++;
						wordL = 0;
						sumItem.setText("");
					}
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText() + wordT[wordL++]);
					else {
						if (wordL < wordT.length + 15) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 4: {
					sumItem.setBounds(30, 170, 590, 550);
					char[] wordT = (language == 0 ? espSumm[4]
							: language == 1 ? porSumm[4] : language == 2 ? engSumm[4] : frSumm[4]).toCharArray();
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText() + wordT[wordL++]);
					else {
						if (wordL < wordT.length + 15) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 5: {
					sumItem.setBounds(30, 120, 590, 550);
					char[] wordT = (language == 0 ? espSumm[5]
							: language == 1 ? porSumm[5] : language == 2 ? engSumm[5] : frSumm[5]).toCharArray();
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText() + wordT[wordL++]);
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
		timer = new Timer(50, letterByLetter);
		timer.start();

		// If close stop the timer
		extraF.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
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

		extraF.add(sumItem);
		extraF.setIconImage(monthlyI.getImage());
		extraF.setVisible(true);
	}

	// Month compare frame
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
		// btns
		JButton expBtn = new JButton();
		expBtn.setIcon(expI);
		expBtn.setContentAreaFilled(false);
		expBtn.setBorderPainted(false);
		expBtn.setBounds(150, 430, 50, 50);
		expBtn.setVisible(false);
		expBtn.addActionListener(e -> exMonthFrame(month));
		extraF.add(expBtn);
		// LABEL
		DateModified dateFromMonth = new DateModified(Integer.valueOf(dayN), month, Integer.valueOf(yearS));
		int[] optMonth = maxMinMes(month);
		int max = optMonth[0], min = optMonth[1];
		int maxDIndex = optMonth[2] - dateFromMonth.index();
		String maxDayString = dayName(new DateModified(maxDIndex, month, 2023), language);
		int minDIndex = optMonth[3] - dateFromMonth.index();
		String minDayString = dayName(new DateModified(minDIndex, month, 2023), language);
		int total22[] = totalOfMes(dateFromMonth.m, 2022);
		int avgM22 = total22[1] == 0 ? 0 : total22[0] / total22[1];
		int total23[] = totalOfMes(month, 2023);
		int avgM = total23[1] == 0 ? 0 : total23[0] / total23[1];
		int daysAvg[] = new int[7];
		double daysPerc[] = new double[7];
		String[] avgOfMonths = monthsText(month);
		JTextPane sumItem = new JTextPane();
		StyledDocument doc = sumItem.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		sumItem.setBounds(30, 120, 590, 550);
		sumItem.setFont(new Font("Tahoma", Font.BOLD, 18));
		sumItem.setEditable(false);
		sumItem.setCaretColor(First.lightC);
		sumItem.setOpaque(false);
		if (avgOfMonths == null) {
			avgOfMonths = new String[15];
			for (int i = 0; i < 12; i++)
				avgOfMonths[i] = "";
			avgOfMonths[12] = "0";
			avgOfMonths[13] = "0";
		}
		// days avg
		daysAvg[0] = avgSpeDayAccMonth("Monday", month);
		daysAvg[1] = avgSpeDayAccMonth("Tuesday", month);
		daysAvg[2] = avgSpeDayAccMonth("Wednesday", month);
		daysAvg[3] = avgSpeDayAccMonth("Thursday", month);
		daysAvg[4] = avgSpeDayAccMonth("Friday", month);
		daysAvg[5] = avgSpeDayAccMonth("Saturday", month);
		daysAvg[6] = avgSpeDayAccMonth("Sunday", month);
		daysPerc[0] = (double) daysAvg[0] * 100
				/ (daysAvg[0] + daysAvg[1] + daysAvg[2] + daysAvg[3] + daysAvg[4] + daysAvg[5] + daysAvg[6]);
		daysPerc[1] = (double) daysAvg[1] * 100
				/ (daysAvg[0] + daysAvg[1] + daysAvg[2] + daysAvg[3] + daysAvg[4] + daysAvg[5] + daysAvg[6]);
		daysPerc[2] = (double) daysAvg[2] * 100
				/ (daysAvg[0] + daysAvg[1] + daysAvg[2] + daysAvg[3] + daysAvg[4] + daysAvg[5] + daysAvg[6]);
		daysPerc[3] = (double) daysAvg[3] * 100
				/ (daysAvg[0] + daysAvg[1] + daysAvg[2] + daysAvg[3] + daysAvg[4] + daysAvg[5] + daysAvg[6]);
		daysPerc[4] = (double) daysAvg[4] * 100
				/ (daysAvg[0] + daysAvg[1] + daysAvg[2] + daysAvg[3] + daysAvg[4] + daysAvg[5] + daysAvg[6]);
		daysPerc[5] = (double) daysAvg[5] * 100
				/ (daysAvg[0] + daysAvg[1] + daysAvg[2] + daysAvg[3] + daysAvg[4] + daysAvg[5] + daysAvg[6]);
		daysPerc[6] = (double) daysAvg[6] * 100
				/ (daysAvg[0] + daysAvg[1] + daysAvg[2] + daysAvg[3] + daysAvg[4] + daysAvg[5] + daysAvg[6]);
		for (int i = 0; i < 7; i++) {
			daysPerc[i] = Math.round(daysPerc[i] * 100);
			daysPerc[i] = daysPerc[i] / 100;
		}
		sumItem.addKeyListener(new KeyAdapter() {// Escape to close
			@SuppressWarnings("static-access")
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyCode() == ke.VK_ESCAPE) {
					wordL = 0;
					order = 0;
					timer.stop();
					extraF.dispose();
				}
			}
		});
		String[] espSumm = {
				"*EN " + currentDate.getMonthForInt(month - 1, 0) + " 2022 VENDISTE EN TOTAL R$" + total22[0]
						+ "\n(PROMEDIO = R$" + avgM22 + ")\n\n\n*EN " + currentDate.getMonthForInt(month - 1, 0)
						+ " DE ESTE AÑO VENDISTE EN TOTAL R$" + total23[0] + "\n(PROMEDIO = R$" + avgM
						+ ")\n\n\n*SE PARECE QUE VENDIMOS" + "\nUN PROMEDIO R$"
						+ (avgM < avgM22 ? avgM22 - avgM + " MENOS DEL AÑO PASADO"
								: avgM - avgM22 + " MÁS DEL AÑO PASADO"), // 0-2022-2023
				"*EL PEOR DÍA EN " + currentDate.getMonthForInt(month - 1, 0) + " ES UN " + minDayString + " "
						+ minDIndex + "-" + month + "\n\nLO QUE VENDIMOS R$" + min + "\n\n\n*EL MEJOR DÍA EN "
						+ currentDate.getMonthForInt(month - 1, 0) + " ES UN " + maxDayString + " " + maxDIndex + "-"
						+ month + "\n\nLO QUE VENDIMOS R$" + max, // 1 minimo y maximo del mes
				"*LA MEDIA SEGÚN EL DÍA SON:\n\nLUNES -> R$" + daysAvg[0] + " (%" + daysPerc[0] + ")\n\nMARTES -> R$"
						+ daysAvg[1] + " (%" + daysPerc[1] + ")\n\nMIÉRCOLES -> R$" + daysAvg[2] + " (%" + daysPerc[2]
						+ ")\n\nJUEVES -> R$" + daysAvg[3] + " (%" + daysPerc[3] + ")\n\nVIERNES -> R$" + daysAvg[4]
						+ " (%" + daysPerc[4] + ")\n\nSÁBADO -> R$" + daysAvg[5] + " (%" + daysPerc[5]
						+ ")\n\nDOMINGO -> R$" + daysAvg[6] + " (%" + daysPerc[6] + ")", // 2 DAVG
				avgOfMonths[0] + "\n" + avgOfMonths[1] + "\n" + avgOfMonths[2] + "\n" + avgOfMonths[3] + "\n"
						+ avgOfMonths[4] + "\n" + avgOfMonths[5], // 3 AVG MONTHS 1
				"\n" + avgOfMonths[6] + "\n" + avgOfMonths[7] + "\n" + avgOfMonths[8] + "\n" + avgOfMonths[9] + "\n"
						+ avgOfMonths[10] + "\n" + avgOfMonths[11], // 4 AVG MONTHS 2
				"*SE PARECE QUE EN ESTE MES\n\n\nVENDIMOS "
						+ (avgM <= Integer.valueOf(avgOfMonths[13]) ? "MENOS QUE TODOS LOS MESES ANTERIORES"
								: avgM >= Integer.valueOf(avgOfMonths[12]) ? "MÁS QUE TODOS LOS MESES ANTERIORES"
										: "MÁS QUE UNOS MESES Y MENOS QUE OTROS")// 5 compare mnths
		};
		String[] porSumm = {
				("*EM " + currentDate.getMonthForInt(month - 1, 1) + " 2022 VOCÊ VENDEU NO TOTAL R$" + total22[0]
						+ "\n(MÉDIA = R$" + avgM22 + ")\n\n\n*EM " + currentDate.getMonthForInt(month - 1, 1)
						+ " NESSE ANO VOCÊ VENDEU NO TOTAL R$" + total23[0] + "\n(MÉDIA = R$" + avgM
						+ ")\n\n\n*PARECE QUE VENDEMOS" + "\nUM MÉDIO R$"
						+ (avgM < avgM22 ? avgM22 - avgM + " MENOS QUE O ANO PASSADO"
								: avgM - avgM22 + " MAIS QUE O ANO PASSADO")), // 0
				"*O PIOR DIA EM " + currentDate.getMonthForInt(month - 1, 1) + " É UM " + minDayString + " " + minDIndex
						+ "-" + month + "\n\nO QUE VENDEMOS R$" + min + "\n\n\n*O MELHOR DIA EM "
						+ currentDate.getMonthForInt(month - 1, 1) + " É UM " + maxDayString + " " + maxDIndex + "-"
						+ month + "\n\nO QUE VENDEMOS R$" + max, // 1 minimo y maximo del mes
				"*A MÉDIA DE ACORDO COM O DIA SÃO:\n\nSEGUNDA-FEIRA -> R$" + daysAvg[0] + " (%" + daysPerc[0]
						+ ")\n\nTERÇA-FEIRA -> R$" + daysAvg[1] + " (%" + daysPerc[1] + ")\n\nQUARTA-FEIRA -> R$"
						+ daysAvg[2] + " (%" + daysPerc[2] + ")\n\nQUINTA-FEIRA -> R$" + daysAvg[3] + " (%"
						+ daysPerc[3] + ")\n\nSEXTA-FEIRA -> R$" + daysAvg[4] + " (%" + daysPerc[4]
						+ ")\n\nSÁBADO -> R$" + daysAvg[5] + " (%" + daysPerc[5] + ")\n\nDOMINGO -> R$" + daysAvg[6]
						+ " (%" + daysPerc[6] + ")", // 5
				avgOfMonths[0] + "\n" + avgOfMonths[1] + "\n" + avgOfMonths[2] + "\n" + avgOfMonths[3] + "\n"
						+ avgOfMonths[4] + "\n" + avgOfMonths[5], // 1
				avgOfMonths[6] + "\n" + avgOfMonths[7] + "\n" + avgOfMonths[8] + "\n" + avgOfMonths[9] + "\n"
						+ avgOfMonths[10] + "\n" + avgOfMonths[11], // 2
				"*PARECE QUE EM NESSE MÊS\n\n\nVENDEMOS "
						+ (avgM <= Integer.valueOf(avgOfMonths[13]) ? "MENOS DO QUE TODOS OS MESES ANTERIORES"
								: avgM >= Integer.valueOf(avgOfMonths[12]) ? "MAIS DO QUE TODOS OS MESES ANTERIORES"
										: "MAIS QUE ALGUNS MESES E MENOS QUE OUTROS") // 3
		};
		String[] engSumm = {
				("*IN " + currentDate.getMonthForInt(month - 1, 2) + " 2022 YOU SOLD IN TOTAL R$" + total22[0]
						+ "\n(AVERAGE = R$" + avgM22 + ")\n\n\n*IN " + currentDate.getMonthForInt(month - 1, 2)
						+ " OF THIS YEAR YOU SOLD IN TOTAL R$" + total23[0] + "\n(AVERAGE = R$" + avgM
						+ ")\n\n\n*IT LOOKS LIKE WE SOLD" + "\nAN AVERAGE OF R$"
						+ (avgM < avgM22 ? avgM22 - avgM + " LESS THAN LAST YEAR"
								: avgM - avgM22 + " MORE THAN LAST YEAR")), // 0
				"*THE WORST DAY IN " + currentDate.getMonthForInt(month - 1, 2) + " IT'S A " + minDayString + " "
						+ minDIndex + "-" + month + "\n\nWHAT WE SOLD R$" + min + "\n\n\n*THE BEST DAY IN "
						+ currentDate.getMonthForInt(month - 1, 2) + " IT'S A " + maxDayString + " " + maxDIndex + "-"
						+ month + "\n\nWHAT WE SOLD R$" + max, // 1 minimo y maximo del mes
				"*THE AVERAGE ACCORDING TO THE DAY ARE:\n\nMONDAY -> R$" + daysAvg[0] + " (%" + daysPerc[0]
						+ ")\n\nTUESDAY -> R$" + daysAvg[1] + " (%" + daysPerc[1] + ")\n\nWEDNESDAY -> R$" + daysAvg[2]
						+ " (%" + daysPerc[2] + ")\n\nTHURSDAY -> R$" + daysAvg[3] + " (%" + daysPerc[3]
						+ ")\n\nFRIDAY -> R$" + daysAvg[4] + " (%" + daysPerc[4] + ")\n\nSATURDAY -> R$" + daysAvg[5]
						+ " (%" + daysPerc[5] + ")\n\nSUNDAY -> R$" + daysAvg[6] + " (%" + daysPerc[6] + ")", // 5
				avgOfMonths[0] + "\n" + avgOfMonths[1] + "\n" + avgOfMonths[2] + "\n" + avgOfMonths[3] + "\n"
						+ avgOfMonths[4] + "\n" + avgOfMonths[5], // 2
				avgOfMonths[6] + "\n" + avgOfMonths[7] + "\n" + avgOfMonths[8] + "\n" + avgOfMonths[9] + "\n"
						+ avgOfMonths[10] + "\n" + avgOfMonths[11], // 3
				"*IT SEEMS THAT IN THIS MONTH\n\n\nWE SOLD "
						+ (avgM <= Integer.valueOf(avgOfMonths[13]) ? "LESS THAN ALL PREVIOUS MONTHS"
								: avgM >= Integer.valueOf(avgOfMonths[12]) ? "MORE THAN ALL PREVIOUS MONTHS"
										: "MORE THAN SOME MONTHS AND LESS THAN OTHERS") // 4
		};
		String[] frSumm = {
				("*EN " + currentDate.getMonthForInt(month - 1, 3) + " 2022 VOUS AVEZ VENDU AU TOTAL R$" + total22[0]
						+ "\n(MOYENNE = R$" + avgM22 + ")\n\n\n*EN " + currentDate.getMonthForInt(month - 1, 3)
						+ " DE CETTE ANNÉE, VOUS AVEZ VENDU AU TOTAL R$" + total23[0] + "\n(MOYENNE = R$" + avgM
						+ ")\n\n\n*IL SEMBLE QUE NOUS AVONS VENDU" + "\nUNE MOYENNE DE R$"
						+ (avgM < avgM22 ? avgM22 - avgM + " MOINS QUE L'AN DERNIER"
								: avgM - avgM22 + " PLUS QUE L'AN DERNIER")), // 0
				"* LE PIRE JOUR EN " + currentDate.getMonthForInt(month - 1, 3) + " C'EST UN " + minDayString + " "
						+ minDIndex + "-" + month + "\n\nCE QUE NOUS AVONS VENDU R$" + min
						+ "\n\n\n*LE MEILLEUR JOUR EN " + currentDate.getMonthForInt(month - 1, 3) + " C'EST UN "
						+ maxDayString + " " + maxDIndex + "-" + month + "\n\nCE QUE NOUS AVONS VENDU R$" + max, // 1
				"*LA MOYENNE SELON LE JOUR EST :\n\nLUNDI -> R$" + daysAvg[0] + " (%" + daysPerc[0] + ")\n\nMARDI -> R$"
						+ daysAvg[1] + " (%" + daysPerc[1] + ")\n\nMERCREDI -> R$" + daysAvg[2] + " (%" + daysPerc[2]
						+ ")\n\nJEUDI -> R$" + daysAvg[3] + " (%" + daysPerc[3] + ")\n\nVENDREDI -> R$" + daysAvg[4]
						+ " (%" + daysPerc[4] + ")\n\nSAMEDI -> R$" + daysAvg[5] + " (%" + daysPerc[5]
						+ ")\n\nDIMANCHE -> R$" + daysAvg[6] + " (%" + daysPerc[6] + ")", // 5
				avgOfMonths[0] + "\n" + avgOfMonths[1] + "\n" + avgOfMonths[2] + "\n" + avgOfMonths[3] + "\n"
						+ avgOfMonths[4] + "\n" + avgOfMonths[5], // 2
				avgOfMonths[6] + "\n" + avgOfMonths[7] + "\n" + avgOfMonths[8] + "\n" + avgOfMonths[9] + "\n"
						+ avgOfMonths[10] + "\n" + avgOfMonths[11], // 3
				"*IL SEMBLE QUE CE MOIS\n\n\nNOUS AVONS VENDU "
						+ (avgM <= Integer.valueOf(avgOfMonths[13]) ? "MOINS QUE TOUS LES MOIS PRÉCÉDENTS"
								: avgM >= Integer.valueOf(avgOfMonths[12]) ? "PLUS QUE TOUS LES MOIS PRÉCÉDENTS"
										: "PLUS QUE CERTAINS MOIS ET MOINS QUE D'AUTRES") // 4
		};
		ActionListener letterByLetter = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				switch (order) {
				case 0: {// COMPARE 2022 AND 2023
					sumItem.setBounds(30, 150, 590, 550);
					char[] wordT = (language == 0 ? espSumm[0]
							: language == 1 ? porSumm[0] : language == 2 ? engSumm[0] : frSumm[0]).toCharArray();
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText() + wordT[wordL++]);
					else {
						if (wordL < wordT.length + 15) {
							wordL++;
						} else {
							String[] avgTempo = monthsText(month);
							if (avgTempo == null)
								break;
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 1: {// BEST AND WORST DAY
					sumItem.setBounds(30, 170, 590, 550);
					char[] wordT = (language == 0 ? espSumm[1]
							: language == 1 ? porSumm[1] : language == 2 ? engSumm[1] : frSumm[1]).toCharArray();
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText() + wordT[wordL++]);
					else {
						if (wordL < wordT.length + 15) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 2: {// AVG FOR EACH DAY
					sumItem.setBounds(30, 120, 590, 550);
					char[] wordT = (language == 0 ? espSumm[2]
							: language == 1 ? porSumm[2] : language == 2 ? engSumm[2] : frSumm[2]).toCharArray();
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText() + wordT[wordL++]);
					else {
						if (wordL < wordT.length + 15) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 3: {// MONTHS JAN -> JUNE
					sumItem.setBounds(30, 150, 590, 550);
					char[] wordT = (language == 0 ? espSumm[3]
							: language == 1 ? porSumm[3] : language == 2 ? engSumm[3] : frSumm[3]).toCharArray();
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText() + wordT[wordL++]);
					else {
						if (wordL < wordT.length + 15) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 4: {// MONTHS JULY -> DEC
					sumItem.setBounds(30, 150, 590, 550);
					char[] wordT = (language == 0 ? espSumm[4]
							: language == 1 ? porSumm[4] : language == 2 ? engSumm[4] : frSumm[4]).toCharArray();
					if (String.valueOf(wordT).isBlank()) {
						order++;
						wordL = 0;
						sumItem.setText("");
					}
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText() + wordT[wordL++]);
					else {
						if (wordL < wordT.length + 15) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 5: {// COMPARE MONTHS
					sumItem.setBounds(30, 170, 590, 550);
					char[] wordT = (language == 0 ? espSumm[5]
							: language == 1 ? porSumm[5] : language == 2 ? engSumm[5] : frSumm[5]).toCharArray();
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText() + wordT[wordL++]);
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
		timer = new Timer(50, letterByLetter);
		timer.start();

		// If close stop the timer
		extraF.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
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

		extraF.add(sumItem);
		extraF.setIconImage(monthlyI.getImage());
		extraF.setVisible(true);
	}

	// The ammount of money we separate with the date
	private void separadosFrame() {
		importSep();
		// frame
		JFrame extraF = new JFrame(idiomaString(language)[35]);
		extraF.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		extraF.setAlwaysOnTop(false);
		extraF.setSize(415, 325);
		extraF.setLocationRelativeTo(null);
		extraF.setResizable(false);
		extraF.setLayout(null);
		extraF.getContentPane().setBackground(First.lightC);

		JTextField[][] sepLabel = new JTextField[5][2];
		JLabel titleSep[] = new JLabel[2];
		JButton btns[] = new JButton[5];
		JLabel totalSep = new JLabel("T O T A L");
		ImageIcon btnIcon = new ImageIcon(getScaledImage(dateI.getImage(), 40, 40));
		KeyAdapter kA = new KeyAdapter() {// Escape to close
			@SuppressWarnings("static-access")
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyCode() == ke.VK_ESCAPE) {
					try {
						tempFile0.mkdir();
						File tempFile1 = new File(tempFile0 + "\\extra");
						tempFile1.mkdir();
						File sepFile = new File(tempFile1, "SEP" + ".dll");
						FileWriter savedF = new FileWriter(sepFile);
						for (int i = 0; i < 5; i++)
							for (int j = 0; j < 2; j++)// save it encrypted
								savedF.write(encrypt.encrypt(sepLabel[i][j].getText()) + System.lineSeparator());
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
		for (int i = 0; i < 5; i++) {
			btns[i] = new JButton(btnIcon);
			btns[i].setContentAreaFilled(false);
			btns[i].setBorderPainted(false);
			btns[i].addKeyListener(kA);
			btns[i].setBounds(360, 50 + 39 * i, 40, 40);
			extraF.add(btns[i]);
		}
		btns[0].addActionListener(e -> sepPanel(sepLabel, 0));
		btns[1].addActionListener(e -> sepPanel(sepLabel, 1));
		btns[2].addActionListener(e -> sepPanel(sepLabel, 2));
		btns[3].addActionListener(e -> sepPanel(sepLabel, 3));
		btns[4].addActionListener(e -> sepPanel(sepLabel, 4));
		int k = 0;
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
				sepLabel[i][j] = new JTextField(sepData[k++]);
				sepLabel[i][j].addKeyListener(kA);
				sepLabel[i][j].setBounds(0 + 199 * j, 50 + 39 * i, 200, 40);
				sepLabel[i][j].setFont(new Font("Tahoma", Font.BOLD, 18));
				sepLabel[i][j].setForeground(First.lightC);
				sepLabel[i][j].setBackground(First.blueC);
				sepLabel[i][j].setBorder(new LineBorder(First.darkC, 2));
				sepLabel[i][j].setHorizontalAlignment(0);
				sepLabel[i][j].addFocusListener(new FocusListener() {

					@Override
					public void focusLost(FocusEvent e) {
						totalSep.setText((First.isNumeric(sepLabel[0][0].getText())
								? Integer.valueOf(sepLabel[0][0].getText())
								: 0)
								+ (First.isNumeric(sepLabel[1][0].getText()) ? Integer.valueOf(sepLabel[1][0].getText())
										: 0)
								+ (First.isNumeric(sepLabel[2][0].getText()) ? Integer.valueOf(sepLabel[2][0].getText())
										: 0)
								+ (First.isNumeric(sepLabel[3][0].getText()) ? Integer.valueOf(sepLabel[3][0].getText())
										: 0)
								+ (First.isNumeric(sepLabel[4][0].getText()) ? Integer.valueOf(sepLabel[4][0].getText())
										: 0)
								+ "");
					}

					@Override
					public void focusGained(FocusEvent e) {
					}
				});
				extraF.add(sepLabel[i][j]);
			}
		totalSep.setText((First.isNumeric(sepLabel[0][0].getText()) ? Integer.valueOf(sepLabel[0][0].getText()) : 0)
				+ (First.isNumeric(sepLabel[1][0].getText()) ? Integer.valueOf(sepLabel[1][0].getText()) : 0)
				+ (First.isNumeric(sepLabel[2][0].getText()) ? Integer.valueOf(sepLabel[2][0].getText()) : 0)
				+ (First.isNumeric(sepLabel[3][0].getText()) ? Integer.valueOf(sepLabel[3][0].getText()) : 0)
				+ (First.isNumeric(sepLabel[4][0].getText()) ? Integer.valueOf(sepLabel[4][0].getText()) : 0) + "");
		totalSep.setBounds(0, 246, 400, 40);
		totalSep.setFont(new Font("Tahoma", Font.BOLD, 22));
		totalSep.setForeground(First.lightC);
		totalSep.setBackground(First.blueD);
		totalSep.setOpaque(true);
		totalSep.setHorizontalAlignment(0);
		totalSep.setBorder(new LineBorder(First.darkC, 2));
		extraF.add(totalSep);
		titleSep[0].setText(idiomaString(language)[38]);
		titleSep[1].setText(idiomaString(language)[39]);

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
								savedF.write(encrypt.encrypt(sepLabel[i][j].getText()) + System.lineSeparator());
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

	// What we sold one year before today
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
		order = 0;
		wordL = 0;
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
					order = 0;
					timer.stop();
					extraF.dispose();
				}
			}
		});
		String[] espSumm = {
				("*EN " + dayN + "-" + monthS + "-2022,\n\nLO QUE ES UN "
						+ dayName(new DateModified(Integer.valueOf(dayN), Integer.valueOf(First.monthN), 2022), 0)
						+ ", VENDISTE R$" + value22 + " EN TOTAL\n\n\n*HOY, " + dayS + " VENDISTE POR AHORA R$"
						+ totalVenta + "\n\n\n*SE PARECE QUE VENDIMOS R$"
						+ (value22 > totalVenta ? (value22 - totalVenta + " MENOS QUE EL AÑO PASADO")
								: (totalVenta - value22 + " MÁS QUE EL AÑO PASADO"))
						+ (value22 == 0 ? ""
								: "\n\nCORRESPONDIENTE A UN " + (value22 > totalVenta
										? "DISMINUIR DE " + (value22 == 0 ? 0 : (value22 - totalVenta) * 100 / value22)

										: "AUMENTAR DE " + (value22 == 0 ? 0 : (totalVenta - value22) * 100 / value22)))
						+ "%"), // 0
				"*HOY, VENDEMOS EN TOTAL R$" + totalVenta + "\n\n\n*ESTE AÑO VENDIMOS UN PROMEDIO DIARIO DE R$"
						+ dailyAvg + "\n\n\n*UN PROMEDIO DE LOS " + dayName(currentDate, 0) + " R$" + sameDayAvg
						+ "\n\n\n*UN PROMEDIO MENSUAL DE "
						+ currentDate.getMonthForInt(Integer.valueOf(First.monthN) - 1, 0) + " R$" + monthlyAvg, // 1
				"*SE PARECE QUE VENDIMOS\n\nR$"
						+ (sameDayAvg > totalVenta
								? sameDayAvg - totalVenta + " MENOS QUE EL PROMEDIO DE LOS " + dayName(currentDate, 0)
										+ " ⬇ " + (sameDayAvg == 0 ? 0 : 100 * (sameDayAvg - totalVenta) / sameDayAvg)
								: (totalVenta - sameDayAvg + " MÁS QUE EL PROMEDIO DE LOS " + dayName(currentDate, 0))
										+ " ⬆ " + (sameDayAvg == 0 ? 0 : 100 * (-sameDayAvg + totalVenta) / sameDayAvg))
						+ "%\n\nR$"
						+ (dailyAvg > totalVenta
								? dailyAvg - totalVenta + " MENOS QUE EL PROMEDIO DIARIO" + " ⬇ "
										+ (dailyAvg == 0 ? 0 : 100 * (dailyAvg - totalVenta) / dailyAvg)
								: (totalVenta - dailyAvg + " MÁS QUE EL PROMEDIO DIARIO")
										+ " ⬆ " + (dailyAvg == 0 ? 0 : 100 * (-dailyAvg + totalVenta) / dailyAvg))
						+ "%\n\nR$"
						+ (monthlyAvg > totalVenta
								? monthlyAvg - totalVenta + " MENOS QUE PROMEDIO MENSUAL DE "
										+ currentDate.getMonthForInt(Integer.valueOf(First.monthN) - 1, 0) + " ⬇ "
										+ (monthlyAvg == 0 ? 0 : 100 * (monthlyAvg - totalVenta) / monthlyAvg)
								: (totalVenta - monthlyAvg + " MÁS QUE EL PPROMEDIO MENSUAL DE "
										+ currentDate.getMonthForInt(Integer.valueOf(First.monthN) - 1, 0) + " ⬆ "
										+ (monthlyAvg == 0 ? 0 : 100 * (-monthlyAvg + totalVenta) / monthlyAvg)))
						+ "%"// 2
		};
		String[] porSumm = {
				"*EM " + dayN + "-" + monthS + "-2022,\n\nO QUE É UM "
						+ dayName(new DateModified(Integer.valueOf(dayN), Integer.valueOf(First.monthN), 2022), 1)
						+ ", VOCÊ VENDEU R$" + value22 + " EM TOTAL\n\n\n*HOJE, " + dayS + " VENDEU POR AGORA R$"
						+ totalVenta + "\n\n\n*PARECE QUE VENDEMOS R$"
						+ (value22 > totalVenta ? (value22 - totalVenta + " MENOS QUE ANO PASSADO")
								: (totalVenta - value22 + " MAIS QUE ANO PASSADO"))
						+ (value22 == 0 ? ""
								: "\n\nCORRESPONDENTE A UM " + (value22 > totalVenta
										? "DIMINUIÇÃO DO " + (value22 == 0 ? 0 : (value22 - totalVenta) * 100 / value22)
										: "AUMENTO DO " + (value22 == 0 ? 0 : (totalVenta - value22) * 100 / value22)))
						+ "%", // 0
				"*HOJE, VENDEMOS NO TOTAL R$" + totalVenta + "\n\n\n*ESTE ANO VENDEMOS UM MÉDIA DIÁRIA DO R$" + dailyAvg
						+ "\n\n\n*EM MÉDIA DO " + dayName(currentDate, 1) + " R$" + sameDayAvg
						+ "\n\n\n*EM MÉDIA MENSAL DO "
						+ currentDate.getMonthForInt(Integer.valueOf(First.monthN) - 1, 1) + " R$" + monthlyAvg, // 1
				"*PARECE QUE VENDEMOS\n\nR$"
						+ (sameDayAvg > totalVenta
								? sameDayAvg - totalVenta + " MENOS QUE A MÉDIA DE OS " + dayName(currentDate, 1)
										+ " ⬇ " + (sameDayAvg == 0 ? 0 : 100 * (sameDayAvg - totalVenta) / sameDayAvg)
								: totalVenta - sameDayAvg + " MAIS QUE A MÉDIA DE OS " + (dayName(currentDate, 1))
										+ " ⬆ " + (sameDayAvg == 0 ? 0 : 100 * (-sameDayAvg + totalVenta) / sameDayAvg))
						+ "%\n\nR$"
						+ (dailyAvg > totalVenta
								? dailyAvg - totalVenta + " MENOS QUE A MÉDIA DIÁRIA" + " ⬇ "
										+ (dailyAvg == 0 ? 0 : 100 * (dailyAvg - totalVenta) / dailyAvg)
								: totalVenta - dailyAvg + " MAIS QUE A MÉDIA DIÁRIA" + " ⬆ "
										+ (dailyAvg == 0 ? 0 : 100 * (-dailyAvg + totalVenta) / dailyAvg))
						+ "%\n\nR$"
						+ (monthlyAvg > totalVenta
								? monthlyAvg - totalVenta + " MENOS QUE A MÉDIA MENSAL "
										+ currentDate.getMonthForInt(Integer.valueOf(First.monthN) - 1, 1) + " ⬇ "
										+ (monthlyAvg == 0 ? 0 : 100 * (monthlyAvg - totalVenta) / monthlyAvg)
								: (totalVenta - monthlyAvg + " MAIS QUE A MÉDIA MENSAL "
										+ currentDate.getMonthForInt(Integer.valueOf(First.monthN) - 1, 1) + " ⬆ "
										+ (monthlyAvg == 0 ? 0 : 100 * (-monthlyAvg + totalVenta) / monthlyAvg)))
						+ "%"// 2
		};
		String[] engSumm = {
				"*ON " + dayN + "-" + monthS + "-2022,\n\nWHICH IS A "
						+ dayName(new DateModified(Integer.valueOf(dayN), Integer.valueOf(First.monthN), 2022), 2)
						+ ", YOU SOLD R$" + value22 + " IN TOTAL\n\n\n*TODAY, " + dayS + " YOU SOLD FOR NOW R$"
						+ totalVenta + "\n\n\n*IT SEEMS WE SOLD R$"
						+ (value22 > totalVenta ? (value22 - totalVenta + " LESS THAN LAST YEAR")
								: (totalVenta - value22 + " MORE THAN LAST YEAR"))
						+ (value22 == 0 ? ""
								: "\n\nCORRESPONDING TO " + (value22 > totalVenta
										? "A DECREASE OF " + (value22 == 0 ? 0 : (value22 - totalVenta) * 100 / value22)

										: "AN INCREASE OF "
												+ (value22 == 0 ? 0 : (totalVenta - value22) * 100 / value22)))
						+ "%", // 0
				"*TODAY, WE SOLD IN TOTAL R$" + totalVenta + "\n\n\n*THIS YEAR WE SOLD A DAILY AVERAGE OF R$" + dailyAvg
						+ "\n\n\n*AN AVERAGE OF THE " + dayName(currentDate, 2) + " R$" + sameDayAvg
						+ "\n\n\n*A MONTHLY AVERAGE OF "
						+ currentDate.getMonthForInt(Integer.valueOf(First.monthN) - 1, 2) + " R$" + monthlyAvg, // 1
				"*IT LOOKS LIKE WE SOLD\n\nR$"
						+ (sameDayAvg > totalVenta
								? sameDayAvg - totalVenta + " LESS THAN THE AVERAGE OF THE " + dayName(currentDate, 2)
										+ " ⬇ " + (sameDayAvg == 0 ? 0 : 100 * (sameDayAvg - totalVenta) / sameDayAvg)
								: (totalVenta - sameDayAvg + " MORE THAN THE AVERAGE OF THE " + dayName(currentDate, 2)
										+ " ⬆ "
										+ (sameDayAvg == 0 ? 0 : 100 * (-sameDayAvg + totalVenta) / sameDayAvg)))
						+ "%\n\nR$"
						+ (dailyAvg > totalVenta
								? dailyAvg - totalVenta + " LESS THAN THE DAILY AVERAGE" + " ⬇ "
										+ (dailyAvg == 0 ? 0 : 100 * (dailyAvg - totalVenta) / dailyAvg)
								: (totalVenta - dailyAvg + " MORE THAN THE DAILY AVERAGE" + " ⬆ "
										+ (dailyAvg == 0 ? 0 : 100 * (-dailyAvg + totalVenta) / dailyAvg)))
						+ "%\n\nR$"
						+ (monthlyAvg > totalVenta
								? monthlyAvg - totalVenta + " LESS THAN THE MONTHLY AVERAGE OF "
										+ currentDate.getMonthForInt(Integer.valueOf(First.monthN) - 1, 2) + " ⬇ "
										+ (monthlyAvg == 0 ? 0 : 100 * (monthlyAvg - totalVenta) / monthlyAvg)
								: (totalVenta - monthlyAvg + " MORE THAN THE MONTHLY AVERAGE OF "
										+ currentDate.getMonthForInt(Integer.valueOf(First.monthN) - 1, 2) + " ⬆ "
										+ (monthlyAvg == 0 ? 0 : 100 * (-monthlyAvg + totalVenta) / monthlyAvg)))
						+ "%"// 2
		};
		String[] frSumm = { "*EN " + dayN + "-" + monthS + "-2022,\n\nQUI EST UN "
				+ dayName(new DateModified(Integer.valueOf(dayN), Integer.valueOf(First.monthN), 2022), 3)
				+ ", VOUS AVEZ VENDU R$" + value22 + " EN TOTAL\n\n\n*AUJOURD'HUI, " + dayS
				+ " VOUS AVEZ VENDU POUR MAINTENANT R$" + totalVenta + "\n\n\n*IL SEMBLE QUE NOUS AVONS VENDU R$"
				+ (value22 > totalVenta ? (value22 - totalVenta + " MOINS QUE L'ANNÉE DERNIÈRE")
						: (totalVenta - value22 + " PLUS QUE L'AN DERNIER"))
				+ (value22 == 0 ? ""
						: "\n\nCORRESPOND À " + (value22 > totalVenta
								? "UNE DIMINUTION DE " + (value22 == 0 ? 0 : (value22 - totalVenta) * 100 / value22)
								: "UNE AUGMENTATION DE" + (value22 == 0 ? 0 : (totalVenta - value22) * 100 / value22)))
				+ "%", // 0
				"*AUJOURD'HUI, NOUS AVONS VENDU AU TOTAL R$" + totalVenta
						+ "\n\n\n*CETTE ANNÉE, NOUS AVONS VENDU UNE MOYENNE QUOTIDIENNE DE R$" + dailyAvg
						+ "\n\n\n*UNE MOYENNE DES " + dayName(currentDate, 3) + " R$" + sameDayAvg
						+ "\n\n\n*UNE monthlyAvg DE " + currentDate.getMonthForInt(Integer.valueOf(First.monthN) - 1, 3)
						+ " R$" + monthlyAvg, // 1
				"*IL SEMBLE QUE NOUS AVONS VENDU\n\nR$"
						+ (sameDayAvg > totalVenta ? sameDayAvg
								- totalVenta + " MOINS QUE LA MOYENNE DES " + dayName(currentDate, 3) + " ⬇ "
								+ (sameDayAvg == 0 ? 0 : 100 * (sameDayAvg - totalVenta) / sameDayAvg)
								: (totalVenta - sameDayAvg + " PLUS QUE LA MOYENNE DES " + dayName(currentDate, 3)
										+ " ⬆ "
										+ (sameDayAvg == 0 ? 0 : 100 * (-sameDayAvg + totalVenta) / sameDayAvg)))
						+ "%\n\nR$"
						+ (dailyAvg > totalVenta
								? dailyAvg - totalVenta + " MOINS QUE LA MOYENNE QUOTIDIENNE" + " ⬇ "
										+ (dailyAvg == 0 ? 0 : 100 * (dailyAvg - totalVenta) / dailyAvg)
								: (totalVenta - dailyAvg + " PLUS QUE LA MOYENNE QUOTIDIENNE" + " ⬆ "
										+ (dailyAvg == 0 ? 0 : 100 * (-dailyAvg + totalVenta) / dailyAvg)))
						+ "%\n\nR$"
						+ (monthlyAvg > totalVenta
								? monthlyAvg - totalVenta + " MOINS QUE LA monthlyAvg DE "
										+ currentDate.getMonthForInt(Integer.valueOf(First.monthN) - 1, 2) + " ⬇ "
										+ (monthlyAvg == 0 ? 0 : 100 * (monthlyAvg - totalVenta) / monthlyAvg)
								: (totalVenta - monthlyAvg + " PLUS QUE LA monthlyAvg DE "
										+ currentDate.getMonthForInt(Integer.valueOf(First.monthN) - 1, 2) + " ⬆ "
										+ (monthlyAvg == 0 ? 0 : 100 * (-monthlyAvg + totalVenta) / monthlyAvg)))
						+ "%"// 2
		};

		ActionListener letterByLetter = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				switch (order) {
				case 0: {
					char[] wordT = (language == 0 ? espSumm[0]
							: language == 1 ? porSumm[0] : language == 2 ? engSumm[0] : frSumm[0]).toCharArray();
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText() + wordT[wordL++]);
					else {
						if (wordL < wordT.length + 15) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 1: {
					sumItem.setBounds(30, 150, 590, 550);
					char[] wordT = (language == 0 ? espSumm[1]
							: language == 1 ? porSumm[1] : language == 2 ? engSumm[1] : frSumm[1]).toCharArray();
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText() + wordT[wordL++]);
					else {
						if (wordL < wordT.length + 15) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 2: {
					sumItem.setBounds(30, 150, 590, 550);
					char[] wordT = (language == 0 ? espSumm[2]
							: language == 1 ? porSumm[2] : language == 2 ? engSumm[2] : frSumm[2]).toCharArray();
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText() + wordT[wordL++]);
					else {
						order++;
						wordL = 0;
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
		timer = new Timer(50, letterByLetter);
		timer.start();
		// If close stop the timer
		extraF.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				try {
					order = 0;
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

	// Frame summary of the day
	private void summaryFrame() {
		JFrame sum = new JFrame();
		if (language == 0)
			sum.setTitle("SUMARIO");
		else if (language == 1)
			sum.setTitle("SUMÁRIO");
		else if (language == 2)
			sum.setTitle("SUMMARY");
		else
			sum.setTitle("SOMMAIRE");
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
					colorX = 0;
					order = 0;
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
						+ "\n\nY GASTO R$" + gastosT + "\n\nQUE TERMINARÁ CON R$" + totalO + " EN TOTAL", // 9
				"PARA RESUMIR\n\n" + "EMPEZAMOS EL DÍA CON R$" + initialDay.getText() + "\n\nY VENDIMOS R$" + totalVenta
						+ "\n\nY GASTO R$" + gastosT + "\n\nY AGREGÓ R$" + agregadoT + "\n\nQUE TERMINARÁ CON R$"
						+ totalO + " EN TOTAL", // 10
				"LA CAJA DIO BIEN\n\n" + "NO HAY DIFERENCIA\n\n" + ":)", // 11
				"LA CAJA NO DIO BIEN\n\n" + "PARECE QUE " + diffResult[1].getText().toUpperCase()
						+ "\n\nREVISA LOS BOLETOS Y LA CAJA", // 12
				"QUEDARÁ PARA MAÑANA APROXIMADAMENTE\n\nR$" + restN, // 13
				"TOQUE EL BOTÓN PARA EXPORTAR EL RESULTADO"// 14
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
						+ "\n\nE GASTO R$" + gastosT + "\n\nQUE VAI ACABAR EM R$" + totalO + " EM TOTAL", // 9
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
						+ " IN TOTAL", // 9
				"TO SUMMARIZE\n\n" + "WE START THE DAY WITH R$" + initialDay.getText() + "\n\nAND WE SELL R$"
						+ totalVenta + "\n\nAND WE SPENT R$" + gastosT + "\n\nAND WE ADD R$" + agregadoT
						+ "\n\nWHAT WILL END IN R$" + totalO + " IN TOTAL", // 12
				"THE CASH DID WELL\n\n" + "NO DIFFERENCE\n\n" + ":)", // 13
				"THE CASH DIDN'T FIT\n\n" + "LOOKS LIKE THERE ARE " + diffResult[1].getText().toUpperCase()
						+ "\n\nRE-CHECK THE TICKETS AND THE BOX", // 14
				"WILL BE OUT TOMORROW APPROXIMATELY\n\nR$" + restN, // 15
				"TOUCH THE BUTTON TO EXPORT THE RESULT"// 16
		};
		String[] frSumm = { "VOUS N'AVEZ RIEN VENDU", // 0
				"VOUS VENDEZ UNE SEULE VENTE D'UNE VALEUR R$" + totalVenta, // 1
				" VOUS VENDEZ R$ " + totalVenta + " \n\nDIVISER EN " + nbVentas() + " VENTES\n\n " + " AVEC MOYENNE R$ "
						+ (nbVentas() == 0 ? 0 : totalVenta / nbVentas()) + " A VENDRE", // 2
				"VOUS N'AVEZ PAS DE DÉPENSES !", // 3
				"VOUS AVEZ DÉPENSÉ AU TOTAL R$" + gastosT + "\n\n" + "DÉTAILLÉ COMME :\n" + gastosDetalles(), // 4
				"VOUS AVEZ UN TOTAL R$" + gastosT + " COMME DÉPENSES\n\n" + "DIVISÉ PAR " + nbGastos() + " CHOSES\n\n"
						+ "AVEC MOYENNE DE R$" + (nbGastos() == 0 ? 0 : gastosT / nbGastos()) + "\n\n"
						+ "DÉTAILLÉ COMME :\n" + gastosDetalles(), // 5
				"VOUS N'AVEZ PAS D'AGRÉGAT !", // 6
				"VOUS AVEZ AU TOTAL UNE VALEUR GLOBALE DE R$" + agregadoT + "\n\n" + "DÉTAILLÉ COMME :\n"
						+ agregadoDetalles(), // 7
				"VOUS AVEZ AU TOTAL UN R$" + agregadoT + " COMME AGRÉGATS\n\n" + "DIVISÉ PAR " + nbAgregados()
						+ " CHOSES\n\n" + "AVEC MOYENNE DE R$" + (nbAgregados() == 0 ? 0 : agregadoT / nbAgregados())
						+ "\n\n" + "DÉTAILLÉ COMME :\n" + agregadoDetalles(), // 8
				"POUR RÉSUMER\n\n" + "NOUS COMMENÇONS LA JOURNÉE AVEC R$" + initialDay.getText()
						+ "\n\nET NOUS VENDONS R$" + totalVenta + "\n\nET NOUS AVONS DÉPENSÉ R$" + gastosT
						+ "\n\nCE QUI SE TERMINERA EN R$" + totalO + " AU TOTAL ", // 9
				"POUR RÉSUMER\n\n" + "NOUS COMMENÇONS LA JOURNÉE AVEC R$" + initialDay.getText()
						+ "\n\nET NOUS VENDONS R$" + totalVenta + "\n\nET NOUS AVONS DÉPENSÉ R$" + gastosT
						+ "\n\nET NOUS AJOUTONS R$" + agregadoT + "\n\nCE QUI SE TERMINERA EN R$" + totalO
						+ " AU TOTAL", // 12
				"LE CASH A BIEN FAIT\n\n" + "PAS DE DIFFÉRENCE\n\n" + ":)", // 13
				"L'ARGENT N'A PAS CONVENU\n\n" + "SEMBLE COMME IL Y EN A" + diffResult[1].getText().toUpperCase()
						+ "\n\nREVÉRIFIEZ LES BILLETS ET LA BOÎTE", // 14
				"SERA DEHORS DEMAIN ENVIRON\n\nR$" + restN, // 15
				"TOUCHEZ LE BOUTON POUR EXPORTER LE RÉSULTAT"// 16
		};

		ActionListener fadeTimer = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sumItem.setForeground(new Color(0, 0, 0, colorX));
				switch (order) {
				case 0: {// details start
					if (totalVenta == 0) {
						sumItem.setText(language == 0 ? espSumm[0]
								: language == 1 ? porSumm[0] : language == 2 ? engSumm[0] : frSumm[0]);
						sumItem.setBounds(0, 240, 650, 550);
					} else {
						if (nbVentas() == 1) {
							sumItem.setText(language == 0 ? espSumm[1]
									: language == 1 ? porSumm[1] : language == 2 ? engSumm[1] : frSumm[1]);
							sumItem.setBounds(0, 240, 650, 550);
						} else {
							sumItem.setText(language == 0 ? espSumm[2]
									: language == 1 ? porSumm[2] : language == 2 ? engSumm[2] : frSumm[2]);
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
						sumItem.setText(language == 0 ? espSumm[3]
								: language == 1 ? porSumm[3] : language == 2 ? engSumm[3] : frSumm[3]);
					} else {
						if (nbGastos() == 1) {
							sumItem.setText(language == 0 ? espSumm[4]
									: language == 1 ? porSumm[4] : language == 2 ? engSumm[4] : frSumm[4]);
							sumItem.setBounds(0, 220, 650, 550);
						} else {
							sumItem.setText(language == 0 ? espSumm[5]
									: language == 1 ? porSumm[5] : language == 2 ? engSumm[5] : frSumm[5]);
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
						sumItem.setText(language == 0 ? espSumm[6]
								: language == 1 ? porSumm[6] : language == 2 ? engSumm[6] : frSumm[6]);
						sumItem.setBounds(0, 240, 650, 550);
					} else {
						if (nbAgregados() == 1) {
							sumItem.setText(language == 0 ? espSumm[7]
									: language == 1 ? porSumm[7] : language == 2 ? engSumm[7] : frSumm[7]);
							sumItem.setBounds(0, 220, 650, 550);
						} else {
							sumItem.setText(language == 0 ? espSumm[8]
									: language == 1 ? porSumm[8] : language == 2 ? engSumm[8] : frSumm[8]);
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
						sumItem.setText(language == 0 ? espSumm[9]
								: language == 1 ? porSumm[9] : language == 2 ? engSumm[9] : frSumm[9]);
					else
						sumItem.setText(language == 0 ? espSumm[10]
								: language == 1 ? porSumm[10] : language == 2 ? engSumm[10] : frSumm[10]);
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
						sumItem.setText(language == 0 ? espSumm[11]
								: language == 1 ? porSumm[11] : language == 2 ? engSumm[11] : frSumm[11]);
					else
						sumItem.setText(language == 0 ? espSumm[12]
								: language == 1 ? porSumm[12] : language == 2 ? engSumm[12] : frSumm[12]);
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
					sumItem.setText(language == 0 ? espSumm[13]
							: language == 1 ? porSumm[13] : language == 2 ? engSumm[13] : frSumm[13]);
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
					sumItem.setText(language == 0 ? espSumm[14]
							: language == 1 ? porSumm[14] : language == 2 ? engSumm[14] : frSumm[14]);
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
								: language == 1 ? porSumm[0].split(" ")
										: language == 2 ? engSumm[0].split(" ") : frSumm[0].split(" ");
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
								: language == 1 ? porSumm[1].split(" ")
										: language == 2 ? engSumm[1].split(" ") : frSumm[1].split(" ");
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
								: language == 1 ? porSumm[2].split(" ")
										: language == 2 ? engSumm[2].split(" ") : frSumm[2].split(" ");
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
								: language == 1 ? porSumm[3].split(" ")
										: language == 2 ? engSumm[3].split(" ") : frSumm[3].split(" ");
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
								: language == 1 ? porSumm[4].split(" ")
										: language == 2 ? engSumm[4].split(" ") : frSumm[4].split(" ");
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
								: language == 1 ? porSumm[5].split(" ")
										: language == 2 ? engSumm[5].split(" ") : frSumm[5].split(" ");
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
								: language == 1 ? porSumm[6].split(" ")
										: language == 2 ? engSumm[6].split(" ") : frSumm[6].split(" ");
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
								: language == 1 ? porSumm[7].split(" ")
										: language == 2 ? engSumm[7].split(" ") : frSumm[7].split(" ");
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
								: language == 1 ? porSumm[8].split(" ")
										: language == 2 ? engSumm[8].split(" ") : frSumm[8].split(" ");
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
					if (agregadoT == 0) {
						sumItem.setBounds(0, 140, 650, 550);
						String[] wordT = language == 0 ? espSumm[9].split(" ")
								: language == 1 ? porSumm[9].split(" ")
										: language == 2 ? engSumm[9].split(" ") : frSumm[9].split(" ");
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
						String[] wordT = language == 0 ? espSumm[10].split(" ")
								: language == 1 ? porSumm[10].split(" ")
										: language == 2 ? engSumm[10].split(" ") : frSumm[10].split(" ");
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
						String[] wordT = language == 0 ? espSumm[11].split(" ")
								: language == 1 ? porSumm[11].split(" ")
										: language == 2 ? engSumm[11].split(" ") : frSumm[11].split(" ");
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
						String[] wordT = language == 0 ? espSumm[12].split(" ")
								: language == 1 ? porSumm[12].split(" ")
										: language == 2 ? engSumm[12].split(" ") : frSumm[12].split(" ");
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
					String[] wordT = language == 0 ? espSumm[13].split(" ")
							: language == 1 ? porSumm[13].split(" ")
									: language == 2 ? engSumm[13].split(" ") : frSumm[13].split(" ");
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
					String[] wordT = language == 0 ? espSumm[14].split(" ")
							: language == 1 ? porSumm[14].split(" ")
									: language == 2 ? engSumm[14].split(" ") : frSumm[14].split(" ");
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
								: language == 1 ? porSumm[0].toCharArray()
										: language == 2 ? engSumm[0].toCharArray() : frSumm[0].toCharArray();
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
								: language == 1 ? porSumm[1].toCharArray()
										: language == 2 ? engSumm[1].toCharArray() : frSumm[1].toCharArray();
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
								: language == 1 ? porSumm[2].toCharArray()
										: language == 2 ? engSumm[2].toCharArray() : frSumm[2].toCharArray();
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
								: language == 1 ? porSumm[3].toCharArray()
										: language == 2 ? engSumm[3].toCharArray() : frSumm[3].toCharArray();
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
								: language == 1 ? porSumm[4].toCharArray()
										: language == 2 ? engSumm[4].toCharArray() : frSumm[4].toCharArray();
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
								: language == 1 ? porSumm[5].toCharArray()
										: language == 2 ? engSumm[5].toCharArray() : frSumm[5].toCharArray();
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
								: language == 1 ? porSumm[6].toCharArray()
										: language == 2 ? engSumm[6].toCharArray() : frSumm[6].toCharArray();
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
								: language == 1 ? porSumm[7].toCharArray()
										: language == 2 ? engSumm[7].toCharArray() : frSumm[7].toCharArray();
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
								: language == 1 ? porSumm[8].toCharArray()
										: language == 2 ? engSumm[8].toCharArray() : frSumm[8].toCharArray();
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
					if (agregadoT == 0) {
						sumItem.setBounds(0, 140, 650, 550);
						char[] wordT = language == 0 ? espSumm[9].toCharArray()
								: language == 1 ? porSumm[9].toCharArray()
										: language == 2 ? engSumm[9].toCharArray() : frSumm[9].toCharArray();
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
					} else {
						sumItem.setBounds(0, 120, 650, 550);
						char[] wordT = language == 0 ? espSumm[10].toCharArray()
								: language == 1 ? porSumm[10].toCharArray()
										: language == 2 ? engSumm[10].toCharArray() : frSumm[10].toCharArray();
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
						char[] wordT = language == 0 ? espSumm[11].toCharArray()
								: language == 1 ? porSumm[11].toCharArray()
										: language == 2 ? engSumm[11].toCharArray() : frSumm[11].toCharArray();
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
						char[] wordT = language == 0 ? espSumm[12].toCharArray()
								: language == 1 ? porSumm[12].toCharArray()
										: language == 2 ? engSumm[12].toCharArray() : frSumm[12].toCharArray();
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
					char[] wordT = language == 0 ? espSumm[13].toCharArray()
							: language == 1 ? porSumm[13].toCharArray()
									: language == 2 ? engSumm[13].toCharArray() : frSumm[13].toCharArray();
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
					char[] wordT = language == 0 ? espSumm[14].toCharArray()
							: language == 1 ? porSumm[14].toCharArray()
									: language == 2 ? engSumm[14].toCharArray() : frSumm[14].toCharArray();
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
		try {
			tempFile0.mkdir();
			File tempFile1 = new File(tempFile0 + "\\" + yearS);
			tempFile1.mkdir();
			File tempFile2 = new File(tempFile1 + "\\" + currentDate.m + "-" + monthS);
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
							+ "DETALLADO COMO:\n" + agregadoDetalles(), // 6
					System.lineSeparator() + "*AGREGADOS:\nTIENES EN TOTAL $" + agregadoT + " COMO AGREGADOS, "
							+ "DIVIDIDO POR " + nbAgregados() + " COSAS, " + "CON UN PROMEDIO DE $"
							+ (nbAgregados() == 0 ? 0 : agregadoT / nbAgregados()) + "\n" + "DETALLADO COMO:\n"
							+ agregadoDetalles(), // 7
					System.lineSeparator() + "*PARA RESUMIR:\n" + "EMPEZAMOS EL DÍA CON R$" + initialDay.getText()
							+ "\nVENDIMOS R$" + totalVenta + "\nGASTO R$" + gastosT + "\nQUE TERMINARÁ CON R$" + totalO
							+ " EN TOTAL" + System.lineSeparator(), // 9
					System.lineSeparator() + "*PARA RESUMIR:\n" + "EMPEZAMOS EL DÍA CON R$" + initialDay.getText()
							+ "\nVENDIMOS R$" + totalVenta + "\nGASTO R$" + gastosT + "\nAGREGÓ R$" + agregadoT
							+ "\nQUE TERMINARÁ CON R$" + totalO + " EN TOTAL" + System.lineSeparator(), // 11
					System.lineSeparator() + "*LA CAJA DIO BIEN, NO HAY DIFERENCIA" + System.lineSeparator(), // 12
					System.lineSeparator() + "*LA CAJA NO DIO BIEN, PARECE QUE " + diffResult[1].getText().toUpperCase()
							+ System.lineSeparator(), // 13
					System.lineSeparator() + "*QUEDARÁ PARA MAÑANA APROXIMADAMENTE R$" + restN + System.lineSeparator(), // 14
					System.lineSeparator() + "*RECUERDOS DE HOY:\nEN " + dayN + "-" + monthS + "-2022, LO QUE ES UN "
							+ dayName(new DateModified(Integer.valueOf(dayN), Integer.valueOf(First.monthN), 2022), 0)
							+ ", VENDISTE R$" + value22 + " EN TOTAL\nHOY, " + dayS + " VENDISTE R$" + totalVenta
							+ "\nSE PARECE QUE VENDIMOS R$"
							+ (value22 > totalVenta ? (value22 - totalVenta + " MENOS QUE EL AÑO PASADO")
									: (totalVenta - value22 + " MÁS QUE EL AÑO PASADO"))
							+ (value22 == 0 ? ""
									: ", CORRESPONDIENTE A UN " + (value22 > totalVenta
											? "DISMINUIR DE "
													+ (value22 == 0 ? 0 : (value22 - totalVenta) * 100 / value22)
											: "AUMENTAR DE "
													+ (value22 == 0 ? 0 : (totalVenta - value22) * 100 / value22)))
							+ "%" + System.lineSeparator(), // 15
					System.lineSeparator() + "HOY, VENDEMOS EN TOTAL R$" + totalVenta
							+ "\nESTE AÑO VENDIMOS UN PROMEDIO DIARIO DE R$" + dailyAvg + "\nUN PROMEDIO DE LOS "
							+ dayName(currentDate, 0) + " R$" + sameDayAvg + "\nUN PROMEDIO MENSUAL DE "
							+ currentDate.getMonthForInt(Integer.valueOf(First.monthN) - 1, 0) + " R$" + monthlyAvg
							+ System.lineSeparator(), // 16
					System.lineSeparator() + "SE PARECE QUE VENDIMOS\nR$" + (sameDayAvg > totalVenta
							? sameDayAvg - totalVenta + " MENOS QUE EL PROMEDIO DE LOS " + dayName(currentDate, 0)
									+ " ⬇ " + (sameDayAvg == 0 ? 0 : 100 * (sameDayAvg - totalVenta) / sameDayAvg)
							: (totalVenta - sameDayAvg + " MÁS QUE EL PROMEDIO DE LOS " + dayName(currentDate, 0))
									+ " ⬆ " + (sameDayAvg == 0 ? 0 : 100 * (-sameDayAvg + totalVenta) / sameDayAvg))
							+ "%\nR$"
							+ (dailyAvg > totalVenta
									? dailyAvg - totalVenta + " MENOS QUE EL PROMEDIO DIARIO" + " ⬇ "
											+ (dailyAvg == 0 ? 0 : 100 * (dailyAvg - totalVenta) / dailyAvg)
									: (totalVenta - dailyAvg + " MÁS QUE EL PROMEDIO DIARIO")
											+ " ⬆ " + (dailyAvg == 0 ? 0 : 100 * (-dailyAvg + totalVenta) / dailyAvg))
							+ "%\nR$"
							+ (monthlyAvg > totalVenta
									? monthlyAvg - totalVenta + " MENOS QUE PROMEDIO MENSUAL DE "
											+ currentDate.getMonthForInt(Integer.valueOf(First.monthN) - 1, 0) + " ⬇ "
											+ (monthlyAvg == 0 ? 0 : 100 * (monthlyAvg - totalVenta) / monthlyAvg)
									: (totalVenta - monthlyAvg + " MÁS QUE EL PPROMEDIO MENSUAL DE "
											+ currentDate.getMonthForInt(Integer.valueOf(First.monthN) - 1, 0) + " ⬆ "
											+ (monthlyAvg == 0 ? 0 : 100 * (-monthlyAvg + totalVenta) / monthlyAvg)))
							+ "%" + System.lineSeparator(), // 17
					System.lineSeparator() + "*GRACIAS Y HASTA MAÑANA :)", // 18
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
							+ " EM TOTAL" + System.lineSeparator(), // 9
					System.lineSeparator() + "*PARA RESUMIR:\n" + "COMEÇAMOS O DIA COM R$" + initialDay.getText()
							+ "\nVENDEMOS R$" + totalVenta + "\nGASTO R$" + gastosT + "\nADICIONO R$" + agregadoT
							+ "\nQUE VAI ACABAR EM R$" + totalO + " EM TOTAL" + System.lineSeparator(), // 11
					System.lineSeparator() + "*A CAIXA DEU BEM, " + "NÃO HÁ DIFERENÇA" + System.lineSeparator(), // 12
					System.lineSeparator() + "*A CAIXA NÃO DEU BEM, " + "PARECE QUE "
							+ diffResult[1].getText().toUpperCase() + System.lineSeparator(), // 13
					System.lineSeparator() + "*FICARÁ PARA AMANHÃ APROXIMADAMENTE R$" + restN + System.lineSeparator(), // 14
					System.lineSeparator() + "*MEMÓRIAS DE HOJE:\nEM " + dayN + "-" + monthS + "-2022, O QUE É UM "
							+ dayName(new DateModified(Integer.valueOf(dayN), Integer.valueOf(First.monthN), 2022), 1)
							+ ", VOCÊ VENDEU R$" + value22 + " EM TOTAL\nHOJE, " + dayS + " VENDEU R$" + totalVenta
							+ "\nPARECE QUE VENDEMOS R$"
							+ (value22 > totalVenta ? (value22 - totalVenta + " MENOS QUE ANO PASSADO")
									: (totalVenta - value22 + " MAIS QUE ANO PASSADO"))
							+ (value22 == 0 ? ""
									: ", CORRESPONDENTE A UM " + (value22 > totalVenta
											? "DIMINUIÇÃO DO "
													+ (value22 == 0 ? 0 : (value22 - totalVenta) * 100 / value22)
											: "AUMENTO DO "
													+ (value22 == 0 ? 0 : (totalVenta - value22) * 100 / value22)))
							+ "%" + System.lineSeparator(), // 15
					System.lineSeparator() + "HOJE, VENDEMOS NO TOTAL R$" + totalVenta
							+ "\nESTE ANO VENDEMOS UM MÉDIA DIÁRIA DO R$" + dailyAvg + "\nEM MÉDIA DO "
							+ dayName(currentDate, 1) + " R$" + sameDayAvg + "\nEM MÉDIA MENSAL DO "
							+ currentDate.getMonthForInt(Integer.valueOf(First.monthN) - 1, 1) + " R$" + monthlyAvg
							+ System.lineSeparator(), // 16
					System.lineSeparator() + "PARECE QUE VENDEMOS\nR$" + (sameDayAvg > totalVenta
							? sameDayAvg - totalVenta + " MENOS QUE A MÉDIA DE OS " + dayName(currentDate, 1) + " ⬇ "
									+ (sameDayAvg == 0 ? 0 : 100 * (sameDayAvg - totalVenta) / sameDayAvg)
							: totalVenta - sameDayAvg + " MAIS QUE A MÉDIA DE OS " + (dayName(currentDate, 1)) + " ⬆ "
									+ (sameDayAvg == 0 ? 0 : 100 * (-sameDayAvg + totalVenta) / sameDayAvg))
							+ "%\nR$"
							+ (dailyAvg > totalVenta
									? dailyAvg - totalVenta + " MENOS QUE A MÉDIA DIÁRIA" + " ⬇ "
											+ (dailyAvg == 0 ? 0 : 100 * (dailyAvg - totalVenta) / dailyAvg)
									: totalVenta - dailyAvg + " MAIS QUE A MÉDIA DIÁRIA" + " ⬆ "
											+ (dailyAvg == 0 ? 0 : 100 * (-dailyAvg + totalVenta) / dailyAvg))
							+ "%\nR$"
							+ (monthlyAvg > totalVenta
									? monthlyAvg - totalVenta + " MENOS QUE A MÉDIA MENSAL "
											+ currentDate.getMonthForInt(Integer.valueOf(First.monthN) - 1, 1) + " ⬇ "
											+ (monthlyAvg == 0 ? 0 : 100 * (monthlyAvg - totalVenta) / monthlyAvg)
									: (totalVenta - monthlyAvg + " MAIS QUE A MÉDIA MENSAL "
											+ currentDate.getMonthForInt(Integer.valueOf(First.monthN) - 1, 1) + " ⬆ "
											+ (monthlyAvg == 0 ? 0 : 100 * (-monthlyAvg + totalVenta) / monthlyAvg)))
							+ "%" + System.lineSeparator(),
					System.lineSeparator() + "*OBRIGADO E ATÉ AMANHÃ :)"// 18
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
							+ " IN TOTAL" + System.lineSeparator(), // 8
					System.lineSeparator() + "*TO SUMMARIZE:\n" + "WE START THE DAY WITH R$" + initialDay.getText()
							+ "\nSELL R$" + totalVenta + "\nSPENT R$" + gastosT + "\nADD R$" + agregadoT
							+ "\nWHAT WILL END IN R$" + totalO + " IN TOTAL" + System.lineSeparator(), // 9
					System.lineSeparator() + "*THE CASH DID WELL, " + "NO DIFFERENCE" + System.lineSeparator(), // 10
					System.lineSeparator() + "*THE CASH DIDN'T FIT, " + "LOOKS LIKE "
							+ diffResult[1].getText().toUpperCase() + System.lineSeparator(), // 11
					System.lineSeparator() + "*WILL BE OUT TOMORROW APPROXIMATELY R$" + restN + System.lineSeparator(), // 12
					System.lineSeparator() + "*MEMORIES OF TODAY:\nON " + dayN + "-" + monthS + "-2022, WHICH IS A "
							+ dayName(new DateModified(Integer.valueOf(dayN), Integer.valueOf(First.monthN), 2022), 2)
							+ ", YOU SOLD R$" + value22 + " IN TOTAL\nTODAY, " + dayS + " YOU SOLD R$" + totalVenta
							+ "\nIT SEEMS WE SOLD R$"
							+ (value22 > totalVenta ? (value22 - totalVenta + " LESS THAN LAST YEAR")
									: (totalVenta - value22 + " MORE THAN LAST YEAR"))
							+ (value22 == 0 ? ""
									: ", CORRESPONDING TO " + (value22 > totalVenta
											? "A DECREASE OF "
													+ (value22 == 0 ? 0 : (value22 - totalVenta) * 100 / value22)
											: "AN INCREASE OF "
													+ (value22 == 0 ? 0 : totalVenta - value22) * 100 / value22))
							+ "%" + System.lineSeparator(), // 13
					System.lineSeparator() + "TODAY, WE SOLD IN TOTAL R$" + totalVenta
							+ "\nTHIS YEAR WE SOLD A DAILY AVERAGE OF R$" + dailyAvg + "\nAN AVERAGE OF THE "
							+ dayName(currentDate, 2) + " R$" + sameDayAvg + "\nA MONTHLY AVERAGE OF "
							+ currentDate.getMonthForInt(Integer.valueOf(First.monthN) - 1, 2) + " R$" + monthlyAvg
							+ System.lineSeparator(), // 14
					System.lineSeparator() + "IT LOOKS LIKE WE SOLD\nR$" + (sameDayAvg > totalVenta
							? sameDayAvg - totalVenta + " LESS THAN THE AVERAGE OF THE " + dayName(currentDate, 2)
									+ " ⬇ " + (sameDayAvg == 0 ? 0 : 100 * (sameDayAvg - totalVenta) / sameDayAvg)
							: (totalVenta - sameDayAvg + " MORE THAN THE AVERAGE OF THE " + dayName(currentDate, 2)
									+ " ⬆ " + (sameDayAvg == 0 ? 0 : 100 * (-sameDayAvg + totalVenta) / sameDayAvg)))
							+ "%\nR$"
							+ (dailyAvg > totalVenta
									? dailyAvg - totalVenta + " LESS THAN THE DAILY AVERAGE" + " ⬇ "
											+ (dailyAvg == 0 ? 0 : 100 * (dailyAvg - totalVenta) / dailyAvg)
									: (totalVenta - dailyAvg + " MORE THAN THE DAILY AVERAGE" + " ⬆ "
											+ (dailyAvg == 0 ? 0 : 100 * (-dailyAvg + totalVenta) / dailyAvg)))
							+ "%\nR$"
							+ (monthlyAvg > totalVenta
									? monthlyAvg - totalVenta + " LESS THAN THE MONTHLY AVERAGE OF "
											+ currentDate.getMonthForInt(Integer.valueOf(First.monthN) - 1, 2) + " ⬇ "
											+ (monthlyAvg == 0 ? 0 : 100 * (monthlyAvg - totalVenta) / monthlyAvg)
									: (totalVenta - monthlyAvg + " MORE THAN THE MONTHLY AVERAGE OF "
											+ currentDate.getMonthForInt(Integer.valueOf(First.monthN) - 1, 2) + " ⬆ "
											+ (monthlyAvg == 0 ? 0 : 100 * (-monthlyAvg + totalVenta) / monthlyAvg)))
							+ "%" + System.lineSeparator(), // 15
					System.lineSeparator() + "*THANKS AND SEE YOU TOMORROW :)" // 16
			};
			String[] frSumm = { "*VENTES :\nVOUS N'AVEZ RIEN VENDU" + System.lineSeparator(), // 0
					"*VENTES :\nVOUS VENDEZ UNE SEULE VENTE D'UNE VALEUR R$" + totalVenta + System.lineSeparator(), // 1
					"*VENTES :\nVOUS VENDEZ R$" + totalVenta + ", SE DIVISANT EN " + nbVentas() + " VENTES, "
							+ "AVEC R$ MOYEN" + (nbVentas() == 0 ? 0 : totalVenta / nbVentas())
							+ System.lineSeparator(), // 2
					System.lineSeparator() + "*COÛTS :\nVOUS N'AVEZ PAS DE COÛTS !" + System.lineSeparator(), // 3
					System.lineSeparator() + "*COÛTS :\nVOUS AVEZ DÉPENSÉ AU TOTAL R$" + gastosT + "\n"
							+ "COMME DÉTAILLÉ :\n" + gastosDetalles(), // 4
					System.lineSeparator() + "*COÛTS :\nVOUS AVEZ UN TOTAL R$" + gastosT + " COMME COÛTS, "
							+ "DIVISÉ PAR " + nbGastos() + " CHOSES, " + "AVEC MOYENNE DE R$"
							+ (nbGastos() == 0 ? 0 : gastosT / nbGastos()) + "\n" + "DÉTAILLÉ COMME:\n"
							+ gastosDetalles(), // 5
					System.lineSeparator() + "*AGRÉGATS :\nVOUS AVEZ AU TOTAL UNE VALEUR AGRÉGÉE R$" + agregadoT + "\n"
							+ "DETAILED LIKE :\n" + agregadoDetalles(), // 6
					System.lineSeparator() + "*AGRÉGATS :\nVOUS AVEZ UN TOTAL R$" + agregadoT + " COMME AGRÉGATS, "
							+ "DIVISE PAR " + nbAgregados() + " CHOSES, " + "AVEC MOYENNE DE R$"
							+ (nbAgregados() == 0 ? 0 : agregadoT / nbAgregados()) + "\n" + "DÉTAILLÉ COMME:\n"
							+ agregadoDetalles(), // 7
					System.lineSeparator() + "*POUR RÉSUMER :\n" + "NOUS COMMENÇONS LA JOURNÉE AVEC R$"
							+ initialDay.getText() + "\nVENDRE R$" + totalVenta + "\nDÉPENSER R$" + gastosT
							+ "\nCE QUI SE TERMINERA EN R$" + totalO + " AU TOTAL" + System.lineSeparator(), // 8
					System.lineSeparator() + "*POUR RÉSUMER :\n" + "NOUS COMMENÇONS LA JOURNÉE AVEC R$"
							+ initialDay.getText() + "\nVENDRE R$" + totalVenta + "\nDÉPENSER R$" + gastosT
							+ "\nAJOUTER R$" + agregadoT + "\nCE QUI SE TERMINERA EN R$" + totalO + " AU TOTAL"
							+ System.lineSeparator(), // 9
					System.lineSeparator() + "*L'ARGENT A BIEN FAIT, " + "PAS DE DIFFERENCE" + System.lineSeparator(), // 10
					System.lineSeparator() + "*L'ARGENT N'A PAS CONVENU," + "RESSEMBLE À"
							+ diffResult[1].getText().toUpperCase() + System.lineSeparator(), // 11
					System.lineSeparator() + "*SERA DISPONIBLE DEMAIN ENVIRON R$" + restN + System.lineSeparator(), // 12
					System.lineSeparator() + "*MÉMOIRES D'AUJOURD'HUI :\nON " + dayN + "-" + monthS
							+ "-2022, QUI EST UN "
							+ dayName(new DateModified(Integer.valueOf(dayN), Integer.valueOf(First.monthN), 2022), 3)
							+ ", VOUS AVEZ VENDU R$" + value22 + " AU TOTAL\nAUJOURD'HUI, " + dayS
							+ " VOUS AVEZ VENDU R$" + totalVenta + "\nIL SEMBLE QUE NOUS AVONS VENDU R$"
							+ (value22 > totalVenta ? (value22 - totalVenta + " MOINS QUE L'ANNÉE DERNIÈRE")
									: (totalVenta - value22 + " PLUS QUE L'AN DERNIER"))
							+ (value22 == 0 ? ""
									: ", CORRESPONDANT A " + (value22 > totalVenta
											? "UNE BAISSE DE "
													+ (value22 == 0 ? 0 : (value22 - totalVenta) * 100 / value22)
											: "UNE AUGMENTATION DE "
													+ (value22 == 0 ? 0 : totalVenta - value22) * 100 / value22))
							+ "%" + System.lineSeparator(), // 13
					System.lineSeparator() + "AUJOURD'HUI, NOUS AVONS VENDU AU TOTAL R$" + totalVenta
							+ "\nCETTE ANNÉE, NOUS AVONS VENDU UNE MOYENNE QUOTIDIENNE DE R$" + dailyAvg
							+ "\nUNE MOYENNE DU " + dayName(currentDate, 3) + " R$" + sameDayAvg
							+ "\nUNE MOYENNE MENSUELLE DE "
							+ currentDate.getMonthForInt(Integer.valueOf(First.monthN) - 1, 3) + " R$" + monthlyAvg
							+ System.lineSeparator(), // 14
					System.lineSeparator() + "IL RESSEMBLE QUE NOUS AVONS VENDU\nR$" + (sameDayAvg > totalVenta
							? sameDayAvg - totalVenta + " MOINS QUE LA MOYENNE DES " + dayName(currentDate, 3) + " ⬇ "
									+ (sameDayAvg == 0 ? 0 : 100 * (sameDayAvg - totalVenta) / sameDayAvg)
							: (totalVenta - sameDayAvg + " PLUS QUE LA MOYENNE DES " + dayName(currentDate, 3) + " ⬆ "
									+ (sameDayAvg == 0 ? 0 : 100 * (-sameDayAvg + totalVenta) / sameDayAvg)))
							+ "%\nR$"
							+ (dailyAvg > totalVenta
									? dailyAvg - totalVenta + " MOINS QUE LA MOYENNE QUOTIDIENNE" + " ⬇ "
											+ (dailyAvg == 0 ? 0 : 100 * (dailyAvg - totalVenta) / dailyAvg)
									: (totalVenta - dailyAvg + " PLUS QUE LA MOYENNE QUOTIDIENNE" + " ⬆ "
											+ (dailyAvg == 0 ? 0 : 100 * (-dailyAvg + totalVenta) / dailyAvg)))
							+ "%\nR$"
							+ (monthlyAvg > totalVenta
									? monthlyAvg - totalVenta + " MOINS QUE LA MOYENNE MENSUELLE DE "
											+ currentDate.getMonthForInt(Integer.valueOf(First.monthN) - 1, 3) + " ⬇ "
											+ (monthlyAvg == 0 ? 0 : 100 * (monthlyAvg - totalVenta) / monthlyAvg)
									: (totalVenta - monthlyAvg + " PLUS QUE LA MOYENNE MENSUELLE DE "
											+ currentDate.getMonthForInt(Integer.valueOf(First.monthN) - 1, 3) + " ⬆ "
											+ (monthlyAvg == 0 ? 0 : 100 * (-monthlyAvg + totalVenta) / monthlyAvg)))
							+ "%" + System.lineSeparator(), // 15
					System.lineSeparator() + "*MERCI ET A DEMAIN :)" // 16
			};
			savedF.write(titleName()
					+ (lang == 0 ? " - SUMARIO POR EL DIA "
							: lang == 1 ? " - SUMÁRIO DO DIA "
									: lang == 2 ? " - SUMMARY OF THE DAY " : " - RÉSUMÉ DE LA JOURNÉE ")
					+ dayS + " " + dayN + "-" + monthS + "-" + yearS + System.lineSeparator() + System.lineSeparator());
			if (totalVenta == 0)
				savedF.write(lang == 0 ? espSumm[0] : lang == 1 ? porSumm[0] : lang == 2 ? engSumm[0] : frSumm[0]);
			else if (nbVentas() == 1)
				savedF.write(lang == 0 ? espSumm[1] : lang == 1 ? porSumm[1] : lang == 2 ? engSumm[1] : frSumm[1]);
			else
				savedF.write(lang == 0 ? espSumm[2] : lang == 1 ? porSumm[2] : lang == 2 ? engSumm[2] : frSumm[2]);
			if (gastosT == 0)// GASTOS SAVE
				savedF.write(lang == 0 ? espSumm[3] : lang == 1 ? porSumm[3] : lang == 2 ? engSumm[3] : frSumm[3]);
			else if (nbGastos() == 1)
				savedF.write(lang == 0 ? espSumm[4] : lang == 1 ? porSumm[4] : lang == 2 ? engSumm[4] : frSumm[4]);
			else
				savedF.write(lang == 0 ? espSumm[5] : lang == 1 ? porSumm[5] : lang == 2 ? engSumm[5] : frSumm[5]);
			if (nbAgregados() != 0) { // AGG SAVE if 1
				if (nbAgregados() == 1)
					savedF.write(lang == 0 ? espSumm[6] : lang == 1 ? porSumm[6] : lang == 2 ? engSumm[6] : frSumm[6]);
				else
					savedF.write(lang == 0 ? espSumm[7] : lang == 1 ? porSumm[7] : lang == 2 ? engSumm[7] : frSumm[7]);
				savedF.write(lang == 0 ? espSumm[9] : lang == 1 ? porSumm[9] : lang == 2 ? engSumm[9] : frSumm[9]);
			} else
				savedF.write(lang == 0 ? espSumm[8] : lang == 1 ? porSumm[8] : lang == 2 ? engSumm[8] : frSumm[8]);
			if (totalO == totalCaja)
				savedF.write(lang == 0 ? espSumm[10] : lang == 1 ? porSumm[10] : lang == 2 ? engSumm[10] : frSumm[10]);
			else
				savedF.write(lang == 0 ? espSumm[11] : lang == 1 ? porSumm[11] : lang == 2 ? engSumm[11] : frSumm[11]);
			savedF.write(lang == 0 ? espSumm[12] : lang == 1 ? porSumm[12] : lang == 2 ? engSumm[12] : frSumm[12]);// resttmrw
			if (currentDate.d == 29 && currentDate.m == 2) {
				savedF.write(lang == 0 ? "*HOY, ES EL 29 DE FEBRERO, NO TENEMOS RECUERDOS POR HOY!"
						: lang == 1 ? "*HOJE, É 29 DE FEVEREIRO, NÃO TEMOS MEMÓRIAS DE HOJE!"
								: lang == 2 ? "IT IS FEBRUARY 29, WE HAVE NO MEMORIES FOR TODAY"
										: "NOUS SOMMES LE 29 FÉVRIER, NOUS N'AVONS AUCUN SOUVENIR POUR AUJOURD'HUI");
			} else {
				savedF.write(lang == 0 ? espSumm[13] : lang == 1 ? porSumm[13] : lang == 2 ? engSumm[13] : frSumm[13]);// mem
				savedF.write(lang == 0 ? espSumm[14] : lang == 1 ? porSumm[14] : lang == 2 ? engSumm[14] : frSumm[14]);// 2
				savedF.write(lang == 0 ? espSumm[15] : lang == 1 ? porSumm[15] : lang == 2 ? engSumm[15] : frSumm[15]);// 3
			}
			savedF.write(lang == 0 ? espSumm[16] : lang == 1 ? porSumm[16] : lang == 2 ? engSumm[16] : frSumm[16]);// thanks
			savedF.close();
			First.savedCorrectly(lang);
		} catch (Exception e2) {
			JOptionPane opt = new JOptionPane(
					lang == 0 ? "ERROR, NO SALVO!" : lang == 1 ? "ERROR, NAO SALVO!" : "ERROR",
					JOptionPane.ERROR_MESSAGE);
			opt.show();
		}

		// export at the end of the month
		if (Integer.valueOf(dayN) == currentDate.maxDays())
			exMonthFrame(Integer.valueOf(First.monthN));

		if (Integer.valueOf(dayN) == 31 && Integer.valueOf(First.monthN) == 12)
			exYearFrame();

		if (language == lang)
			screenShooter();
	}

	// export the month overview
	private void exMonthFrame(int month) {
		DateModified dateFromMonth = new DateModified(Integer.valueOf(dayN), month, Integer.valueOf(yearS));
		int total22[] = totalOfMes(month, 2022);
		int avgM22 = total22[0] == 0 ? 0 : total22[0] / total22[1];
		int total23[] = totalOfMes(month, 2023);
		int avgM = total23[1] == 0 ? 0 : total23[0] / total23[1];
		int[] optMonth = maxMinMes(month);
		int max = optMonth[0], min = optMonth[1];
		int maxDIndex = optMonth[2] - dateFromMonth.index();
		String maxDayString = dayName(new DateModified(maxDIndex, month, 2023), language);
		int minDIndex = optMonth[3] - dateFromMonth.index();
		String minDayString = dayName(new DateModified(minDIndex, month, 2023), language);
		String[] avfOfMonths = monthsText(month);
		int daysAvg[] = new int[7];
		// days avg
		daysAvg[0] = avgSpeDayAccMonth("Monday", month);
		daysAvg[1] = avgSpeDayAccMonth("Tuesday", month);
		daysAvg[2] = avgSpeDayAccMonth("Wednesday", month);
		daysAvg[3] = avgSpeDayAccMonth("Thursday", month);
		daysAvg[4] = avgSpeDayAccMonth("Friday", month);
		daysAvg[5] = avgSpeDayAccMonth("Saturday", month);
		daysAvg[6] = avgSpeDayAccMonth("Sunday", month);
		double daysPerc[] = new double[7];
		daysPerc[0] = (double) daysAvg[0] * 100
				/ (daysAvg[0] + daysAvg[1] + daysAvg[2] + daysAvg[3] + daysAvg[4] + daysAvg[5] + daysAvg[6]);
		daysPerc[1] = (double) daysAvg[1] * 100
				/ (daysAvg[0] + daysAvg[1] + daysAvg[2] + daysAvg[3] + daysAvg[4] + daysAvg[5] + daysAvg[6]);
		daysPerc[2] = (double) daysAvg[2] * 100
				/ (daysAvg[0] + daysAvg[1] + daysAvg[2] + daysAvg[3] + daysAvg[4] + daysAvg[5] + daysAvg[6]);
		daysPerc[3] = (double) daysAvg[3] * 100
				/ (daysAvg[0] + daysAvg[1] + daysAvg[2] + daysAvg[3] + daysAvg[4] + daysAvg[5] + daysAvg[6]);
		daysPerc[4] = (double) daysAvg[4] * 100
				/ (daysAvg[0] + daysAvg[1] + daysAvg[2] + daysAvg[3] + daysAvg[4] + daysAvg[5] + daysAvg[6]);
		daysPerc[5] = (double) daysAvg[5] * 100
				/ (daysAvg[0] + daysAvg[1] + daysAvg[2] + daysAvg[3] + daysAvg[4] + daysAvg[5] + daysAvg[6]);
		daysPerc[6] = (double) daysAvg[6] * 100
				/ (daysAvg[0] + daysAvg[1] + daysAvg[2] + daysAvg[3] + daysAvg[4] + daysAvg[5] + daysAvg[6]);
		for (int i = 0; i < 7; i++) {
			daysPerc[i] = Math.round(daysPerc[i] * 100);
			daysPerc[i] = daysPerc[i] / 100;
		}
		try {
			tempFile0.mkdir();
			File tempFile1 = new File(tempFile0 + "\\" + yearS);
			tempFile1.mkdir();
			File tempFile2 = new File(tempFile1 + "\\" + month + "-" + currentDate.getMonthForInt(month - 1, language));
			tempFile2.mkdir();
			File newFile = new File(tempFile2, "SUMMARY - " + currentDate.getMonthForInt(month - 1, language) + ".txt");
			FileWriter savedF = new FileWriter(newFile);
			String[] espSumm = {
					"\n\n*COMPARACIÓN CON EL AÑO PASADO:\nEN 2022 VENDISTE EN TOTAL R$" + total22[0]
							+ " CON UN PROMEDIO DE R$" + avgM22 + "\nESTE AÑO VENDISTE EN TOTAL R$" + total23[0]
							+ " CON UN PROMEDIO DE R$" + avgM + "\nSE PARECE QUE VENDIMOS UN PROMEDIO R$"
							+ (avgM < avgM22 ? avgM22 - avgM + " MENOS DEL AÑO PASADO"
									: avgM - avgM22 + " MÁS DEL AÑO PASADO"), // 0
					"\n\n*EXTREMOS DEL MES:\nEL PEOR DÍA EN " + currentDate.getMonthForInt(month - 1, 0) + " ES UN "
							+ minDayString + " " + minDIndex + "-" + month + ", LO QUE VENDIMOS R$" + min
							+ "\nEL MEJOR DÍA EN " + currentDate.getMonthForInt(month - 1, 0) + " ES UN " + maxDayString
							+ " " + maxDIndex + "-" + month + ", LO QUE VENDIMOS R$" + max, // 1
					"\n\n*LA MEDIA SEGÚN EL DÍA EN ESTE MES SON:\nLUNES -> R$" + daysAvg[0] + " (%" + daysPerc[0]
							+ ")\nMARTES -> R$" + daysAvg[1] + " (%" + daysPerc[1] + ")\nMIÉRCOLES -> R$" + daysAvg[2]
							+ " (%" + daysPerc[2] + ")\nJUEVES -> R$" + daysAvg[3] + " (%" + daysPerc[3]
							+ ")\nVIERNES -> R$" + daysAvg[4] + " (%" + daysPerc[4] + ")\nSÁBADO -> R$" + daysAvg[5]
							+ " (%" + daysPerc[5] + ")\nDOMINGO -> R$" + daysAvg[6] + " (%" + daysPerc[6] + ")", // 2DAVG
					"\n\n*DIFERENCIA CON MESES ANTERIORES:\n" + avfOfMonths[0] + avfOfMonths[1] + avfOfMonths[2]
							+ avfOfMonths[3] + avfOfMonths[4] + avfOfMonths[5] + avfOfMonths[6] + avfOfMonths[7]
							+ avfOfMonths[8] + avfOfMonths[9] + avfOfMonths[10] + avfOfMonths[11], // 2
					"SE PARECE QUE EN ESTE MES, VENDIMOS "
							+ (avgM <= Integer.valueOf(avfOfMonths[13]) ? "MENOS QUE TODOS LOS MESES ANTERIORES"
									: avgM >= Integer.valueOf(avfOfMonths[12]) ? "MÁS QUE TODOS LOS MESES ANTERIORES"
											: "MÁS QUE UNOS MESES Y MENOS QUE OTROS."), // 3
					"\n\n*GRACIAS Y HASTA MAÑANA :)", // 4
			};
			String[] porSumm = {
					"\n\n*COMPARAÇÃO COM O ANO PASSADO:\nEM 2022 VOCÊ VENDEU NO TOTAL R$" + total22[0]
							+ " COM MÉDIA DO R$" + avgM22 + "\nNESSE ANO VOCÊ VENDEU NO TOTAL R$" + total23[0]
							+ " COM MÉDIA DO R$" + avgM + "\nPARECE QUE VENDEMOS UM MÉDIO R$"
							+ (avgM < avgM22 ? avgM22 - avgM + " MENOS QUE O ANO PASSADO"
									: avgM - avgM22 + " MAIS QUE O ANO PASSADO"), // 0
					"\n\n*EXTREMOS DO MÊS:\nO PIOR DIA EM " + currentDate.getMonthForInt(month - 1, 1) + " É UM "
							+ minDayString + " " + minDIndex + "-" + month + ", O QUE VENDEMOS R$" + min
							+ "\nO MELHOR DIA EM " + currentDate.getMonthForInt(month - 1, 1) + " É UM " + maxDayString
							+ " " + maxDIndex + "-" + month + ", O QUE VENDEMOS R$" + max, // 1
					"\n\n*A MÉDIA DE ACORDO COM O DIA EM ESTE MES SÃO:\nSEGUNDA-FEIRA -> R$" + daysAvg[0] + " (%"
							+ daysPerc[0] + ")\nTERÇA-FEIRA -> R$" + daysAvg[1] + " (%" + daysPerc[1]
							+ ")\nQUARTA-FEIRA -> R$" + daysAvg[2] + " (%" + daysPerc[2] + ")\nQUINTA-FEIRA -> R$"
							+ daysAvg[3] + " (%" + daysPerc[3] + ")\nSEXTA-FEIRA -> R$" + daysAvg[4] + " (%"
							+ daysPerc[4] + ")\nSÁBADO -> R$" + daysAvg[5] + " (%" + daysPerc[5] + ")\nDOMINGO -> R$"
							+ daysAvg[6] + " (%" + daysPerc[6] + ")", // 5
					"\n\n*DIFERENÇA DOS MESES ANTERIORES:\n" + avfOfMonths[0] + avfOfMonths[1] + avfOfMonths[2]
							+ avfOfMonths[3] + avfOfMonths[4] + avfOfMonths[5] + avfOfMonths[6] + avfOfMonths[7]
							+ avfOfMonths[8] + avfOfMonths[9] + avfOfMonths[10] + avfOfMonths[11], // 2
					"PARECE QUE EM NESSE MÊS, VENDEMOS "
							+ (avgM <= Integer.valueOf(avfOfMonths[13]) ? "MENOS DO QUE TODOS OS MESES ANTERIORES"
									: avgM >= Integer.valueOf(avfOfMonths[12]) ? "MAIS DO QUE TODOS OS MESES ANTERIORES"
											: "MAIS QUE ALGUNS MESES E MENOS QUE OUTROS"), // 3
					"\n\n*OBRIGADO E ATÉ AMANHÃ :)"// 2
			};
			String[] engSumm = {
					"\n\n*COMPARISON WITH LAST YEAR:\nIN 2022 YOU SOLD IN TOTAL R$" + total22[0]
							+ " WITH AN AVERAGE OF R$" + avgM22 + "\nIN THIS YEAR YOU SOLD IN TOTAL R$" + total23[0]
							+ " WITH AN AVERAGE OF R$" + avgM + "\nIT LOOKS LIKE WE SOLD AN AVERAGE OF R$"
							+ (avgM < avgM22 ? avgM22 - avgM + " LESS THAN LAST YEAR"
									: avgM - avgM22 + " MORE THAN LAST YEAR"), // 0
					"\n\n*EXTREMES OF THE MONTH:\nTHE WORST DAY IN " + currentDate.getMonthForInt(month - 1, 2)
							+ " IT'S A " + minDayString + " " + minDIndex + "-" + month + ", WHAT WE SOLD R$" + min
							+ "\nTHE BEST DAY IN " + currentDate.getMonthForInt(month - 1, 2) + " IT'S A "
							+ maxDayString + " " + maxDIndex + "-" + month + ", WHAT WE SOLD R$" + max, // 1
					"\n\n*THE AVERAGE ACCORDING TO THE DAY IN THIS MONTH ARE:\nMONDAY -> R$" + daysAvg[0] + " (%"
							+ daysPerc[0] + ")\nTUESDAY -> R$" + daysAvg[1] + " (%" + daysPerc[1] + ")\nWEDNESDAY -> R$"
							+ daysAvg[2] + " (%" + daysPerc[2] + ")\nTHURSDAY -> R$" + daysAvg[3] + " (%" + daysPerc[3]
							+ ")\nFRIDAY -> R$" + daysAvg[4] + " (%" + daysPerc[4] + ")\nSATURDAY -> R$" + daysAvg[5]
							+ " (%" + daysPerc[5] + ")\nSUNDAY -> R$" + daysAvg[6] + " (%" + daysPerc[6] + ")", // 5
					"\n\n*DIFFERENCE FROM PREVIOUS MONTHS:\n" + avfOfMonths[0] + avfOfMonths[1] + avfOfMonths[2]
							+ avfOfMonths[3] + avfOfMonths[4] + avfOfMonths[5] + avfOfMonths[6] + avfOfMonths[7]
							+ avfOfMonths[8] + avfOfMonths[9] + avfOfMonths[10] + avfOfMonths[11], // 2
					"IT SEEMS THAT IN THIS MONTH, WE SOLD "
							+ (avgM <= Integer.valueOf(avfOfMonths[13]) ? "LESS THAN ALL PREVIOUS MONTHS"
									: avgM > Integer.valueOf(avfOfMonths[12]) ? "MORE THAN ALL PREVIOUS MONTHS"
											: "MORE THAN SOME MONTHS AND LESS THAN OTHERS"), // 3
					"\n\n*THANKS AND SEE YOU TOMORROW :)" // 4
			};
			String[] frSumm = {
					"\n\n*COMPARAISON AVEC L'ANNÉE DERNIÈRE :\nEN 2022, VOUS AVEZ VENDU AU TOTAL R$" + total22[0]
							+ " AVEC UNE MOYENNE DE R$" + avgM22 + "\nCETTE ANNÉE, VOUS AVEZ VENDU AU TOTAL R$"
							+ total23[0] + " AVEC UNE MOYENNE DE R$" + avgM
							+ "\nIL SEMBLE COMME NOUS AVONS VENDU UNE MOYENNE DE R$"
							+ (avgM < avgM22 ? avgM22 - avgM + " MOINS QUE L'AN DERNIER"
									: avgM - avgM22 + " PLUS QUE L'AN DERNIER"), // 0
					"\n\n*EXTREMES DU MOIS :\nLE PIRE JOUR DE " + currentDate.getMonthForInt(month - 1, 3)
							+ " C'EST UN " + minDayString + " " + minDIndex + "-" + month
							+ ", CE QUE NOUS AVONS VENDU R$" + min + "\nLE MEILLEUR JOUR EN "
							+ currentDate.getMonthForInt(month - 1, 3) + " C'EST UN " + maxDayString + " " + maxDIndex
							+ "-" + month + ", CE QUE NOUS AVONS VENDU R$" + max, // 1
					"\n\n*LA MOYENNE SELON LE JOUR DE CE MOIS EST :\nLUNDI -> R$" + daysAvg[0] + " (%" + daysPerc[0]
							+ ")\nMARDI -> R$" + daysAvg[1] + " (%" + daysPerc[1] + ")\nMERCREDI -> R$" + daysAvg[2]
							+ " (%" + daysPerc[2] + ")\nJEUDI -> R$" + daysAvg[3] + " (%" + daysPerc[3]
							+ ")\nVENDREDI -> R$" + daysAvg[4] + " (%" + daysPerc[4] + ")\nSAMEDI -> R$" + daysAvg[5]
							+ " (%" + daysPerc[5] + ")\nDIMANCHE -> R$" + daysAvg[6] + " (%" + daysPerc[6] + ")", // 5
					"\n\n*DIFFÉRENCE AVEC LES MOIS PRÉCÉDENTS :\n" + avfOfMonths[0] + avfOfMonths[1] + avfOfMonths[2]
							+ avfOfMonths[3] + avfOfMonths[4] + avfOfMonths[5] + avfOfMonths[6] + avfOfMonths[7]
							+ avfOfMonths[8] + avfOfMonths[9] + avfOfMonths[10] + avfOfMonths[11], // 2
					"IL SEMBLE QUE CE MOIS, NOUS AVONS VENDU "
							+ (avgM <= Integer.valueOf(avfOfMonths[13]) ? "MOINS QUE TOUS LES MOIS PRÉCÉDENTS"
									: avgM > Integer.valueOf(avfOfMonths[12]) ? "PLUS QUE TOUS LES MOIS PRÉCÉDENTS"
											: "PLUS QUE CERTAINS MOIS ET MOINS QUE D'AUTRES"), // 3
					"\n\n*MERCI ET A DEMAIN :)" // 4
			};
			savedF.write(titleName() + (language == 0
					? (" - COMPARACIÓN ENTRE ESTE AÑO Y EL AÑO PASADO DE " + currentDate.getMonthForInt(month - 1, 0))
					: language == 1
							? (" - COMPARAÇÃO ENTRE ESTE ANO E O ANO PASSADO DO "
									+ currentDate.getMonthForInt(month - 1, 1))
							: language == 1
									? (" - COMPARISON BETWEEN THIS YEAR AND LAST YEAR FOR "
											+ currentDate.getMonthForInt(month - 1, 2))
									: (" - COMPARAISON ENTRE CETTE ANNÉE ET L'ANNÉE DERNIÈRE POUR ")
											+ currentDate.getMonthForInt(month - 1, 3)));
			savedF.write(
					language == 0 ? espSumm[0] : language == 1 ? porSumm[0] : language == 2 ? engSumm[0] : frSumm[0]);
			savedF.write(
					language == 0 ? espSumm[1] : language == 1 ? porSumm[1] : language == 2 ? engSumm[1] : frSumm[1]);
			savedF.write(
					language == 0 ? espSumm[2] : language == 1 ? porSumm[2] : language == 2 ? engSumm[2] : frSumm[2]);
			savedF.write(
					language == 0 ? espSumm[3] : language == 1 ? porSumm[3] : language == 2 ? engSumm[3] : frSumm[3]);
			savedF.write(
					language == 0 ? espSumm[4] : language == 1 ? porSumm[4] : language == 2 ? engSumm[4] : frSumm[4]);
			savedF.write(
					language == 0 ? espSumm[5] : language == 1 ? porSumm[5] : language == 2 ? engSumm[5] : frSumm[5]);
			savedF.close();
			First.savedCorrectly(language);
		} catch (Exception e2) {
			JOptionPane opt = new JOptionPane(
					language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
					JOptionPane.ERROR_MESSAGE);
			opt.show();
		}
	}

	// Export the year overview
	private void exYearFrame() {
		dailyAvg = dailyAvg();
		monthlyAvg = monTotalAverage(currentDate.m)[1] == 0 ? 0
				: monTotalAverage(currentDate.m)[0] / monTotalAverage(currentDate.m)[1];
		int temp[] = yearMaxMin();
		int maxDIndex = currentDate.dayFromIndex(temp[2]);
		String maxDayString = dayName(new DateModified(maxDIndex, monthFromIndex(temp[2]), 2023), language);
		int minDIndex = currentDate.dayFromIndex(temp[3]);
		String minDayString = dayName(new DateModified(minDIndex, monthFromIndex(temp[3]), 2023), language);
		String[] avgOfMonths = monthsText(Integer.valueOf(First.monthN));
		int daysAvg[] = new int[7];
		double daysPerc[] = new double[7];
		// days avg
		daysAvg[0] = avgSellOfDay(new DateModified(2, 1, 2023));
		daysAvg[1] = avgSellOfDay(new DateModified(3, 1, 2023));
		daysAvg[2] = avgSellOfDay(new DateModified(4, 1, 2023));
		daysAvg[3] = avgSellOfDay(new DateModified(5, 1, 2023));
		daysAvg[4] = avgSellOfDay(new DateModified(6, 1, 2023));
		daysAvg[5] = avgSellOfDay(new DateModified(7, 1, 2023));
		daysAvg[6] = avgSellOfDay(new DateModified(8, 1, 2023));
		daysPerc[0] = (double) daysAvg[0] * 100
				/ (daysAvg[0] + daysAvg[1] + daysAvg[2] + daysAvg[3] + daysAvg[4] + daysAvg[5] + daysAvg[6]);
		daysPerc[1] = (double) daysAvg[1] * 100
				/ (daysAvg[0] + daysAvg[1] + daysAvg[2] + daysAvg[3] + daysAvg[4] + daysAvg[5] + daysAvg[6]);
		daysPerc[2] = (double) daysAvg[2] * 100
				/ (daysAvg[0] + daysAvg[1] + daysAvg[2] + daysAvg[3] + daysAvg[4] + daysAvg[5] + daysAvg[6]);
		daysPerc[3] = (double) daysAvg[3] * 100
				/ (daysAvg[0] + daysAvg[1] + daysAvg[2] + daysAvg[3] + daysAvg[4] + daysAvg[5] + daysAvg[6]);
		daysPerc[4] = (double) daysAvg[4] * 100
				/ (daysAvg[0] + daysAvg[1] + daysAvg[2] + daysAvg[3] + daysAvg[4] + daysAvg[5] + daysAvg[6]);
		daysPerc[5] = (double) daysAvg[5] * 100
				/ (daysAvg[0] + daysAvg[1] + daysAvg[2] + daysAvg[3] + daysAvg[4] + daysAvg[5] + daysAvg[6]);
		daysPerc[6] = (double) daysAvg[6] * 100
				/ (daysAvg[0] + daysAvg[1] + daysAvg[2] + daysAvg[3] + daysAvg[4] + daysAvg[5] + daysAvg[6]);
		for (int i = 0; i < 7; i++) {
			daysPerc[i] = Math.round(daysPerc[i] * 100);
			daysPerc[i] = daysPerc[i] / 100;
		}
		try {
			tempFile0.mkdir();
			File tempFile1 = new File(tempFile0 + "\\" + yearS);
			tempFile1.mkdir();
			File newFile = new File(tempFile1, "SUMMARY - " + yearS + ".txt");
			FileWriter savedF = new FileWriter(newFile);
			String[] espSumm = {
					"\n\n*COMPARACIÓN CON EL AÑO PASADO:\nESTE AÑO, VENDIMOS UN PROMEDIO DE R$" + dailyAvg
							+ "\nEL AÑO PASADO, VENDIMOS UN PROMEDIO DE R$" + dailyAvg22 + "\nSE PARECE QUE VENDIMOS R$"
							+ (dailyAvg > dailyAvg22
									? (dailyAvg - dailyAvg22) + " MÁS QUE EL AÑO PASADO ( ⬆ "
											+ 100 * (dailyAvg - dailyAvg22) / dailyAvg22 + "%)"
									: (dailyAvg22 - dailyAvg) + " MENOS QUE EL AÑO PASADO ( ⬇ "
											+ 100 * (dailyAvg22 - dailyAvg) / dailyAvg22 + "%)"), // 0
					"\n\n*EXTREMOS DEL MES:\nEL MEJOR DÍA DE ESTE AÑO ES " + maxDayString + " " + maxDIndex + "-"
							+ currentDate.getMonthForInt(monthFromIndex(temp[2]) - 1, 0) + ", LO QUE VENDIMOS R$"
							+ temp[0] + "\nEL PEOR DÍA DE ESTE AÑO ES " + minDayString + " " + minDIndex + "-"
							+ currentDate.getMonthForInt(monthFromIndex(temp[3]) - 1, 0) + ", LO QUE VENDIMOS R$"
							+ temp[1], // 1
					"\n\n*DIFERENCIA CON MESES ANTERIORES:\n" + avgOfMonths[0] + avgOfMonths[1] + avgOfMonths[2]
							+ avgOfMonths[3] + avgOfMonths[4] + avgOfMonths[5], // 2
					avgOfMonths[6] + avgOfMonths[7] + avgOfMonths[8] + avgOfMonths[9] + avgOfMonths[10]
							+ avgOfMonths[11], // 3 months
					"\n*EXTREMOS DEL AÑO:\nEL MEJOR MES DEL AÑO FUE "
							+ currentDate.getMonthForInt(Integer.valueOf(avgOfMonths[14]), 0)
							+ ", LO QUE VENDIMOS UN PROMEDIO DE R$" + avgOfMonths[12] + "\nEL PEOR MES DEL AÑO FUE "
							+ currentDate.getMonthForInt(Integer.valueOf(avgOfMonths[15]), 0)
							+ ", LO QUE VENDIMOS UN PROMEDIO DE R$" + avgOfMonths[13], // 4 MAX AND MIN FOR THE MONTH
					"\n\n*LA MEDIA SEGÚN EL DÍA SON:\nLUNES -> R$" + daysAvg[0] + " (%" + daysPerc[0]
							+ ")\nMARTES -> R$" + daysAvg[1] + " (%" + daysPerc[1] + ")\nMIÉRCOLES -> R$" + daysAvg[2]
							+ " (%" + daysPerc[2] + ")\nJUEVES -> R$" + daysAvg[3] + " (%" + daysPerc[3]
							+ ")\nVIERNES -> R$" + daysAvg[4] + " (%" + daysPerc[4] + ")\nSÁBADO -> R$" + daysAvg[5]
							+ " (%" + daysPerc[5] + ")\nDOMINGO -> R$" + daysAvg[6] + " (%" + daysPerc[6] + ")", // 5
					"\n\n*GRACIAS Y HASTA MAÑANA :)", // 6
			};
			String[] porSumm = {
					"\n\n*COMPARAÇÃO COM O ANO PASSADO:\nESTE ANO, VENDEMOS UMA MÉDIA DE R$" + dailyAvg
							+ "\nANO PASSADO, VENDEMOS EM MÉDIA DE R$" + dailyAvg22 + "\nPARECE QUE VENDEMOS R$"
							+ (dailyAvg > dailyAvg22
									? (dailyAvg - dailyAvg22) + " MAIS QUE ANO PASSADO ( ⬆ "
											+ 100 * (dailyAvg - dailyAvg22) / dailyAvg22 + "%)"
									: (dailyAvg22 - dailyAvg) + " MENOS QUE ANO PASSADO ( ⬇ "
											+ 100 * (dailyAvg22 - dailyAvg) / dailyAvg22 + "%)"), // 0
					"\n\n*EXTREMOS DO MÊS:\nO MELHOR DIA DESTE ANO É " + maxDayString + " " + maxDIndex + "-"
							+ currentDate.getMonthForInt(monthFromIndex(temp[2]) - 1, 1) + ", O QUE VENDEMOS R$"
							+ temp[0] + "\nO PIOR DIA DO ANO É " + minDayString + " " + minDIndex + "-"
							+ currentDate.getMonthForInt(monthFromIndex(temp[3]) - 1, 1) + ", O QUE VENDEMOS R$"
							+ temp[1], // 1
					"\n\n*DIFERENÇA DOS MESES ANTERIORES:\n" + avgOfMonths[0] + avgOfMonths[1] + avgOfMonths[2]
							+ avgOfMonths[3] + avgOfMonths[4] + avgOfMonths[5], // 2
					avgOfMonths[6] + avgOfMonths[7] + avgOfMonths[8] + avgOfMonths[9] + avgOfMonths[10]
							+ avgOfMonths[11], // 3 months
					"\n*EXTREMOS DO ANO:\nO MELHOR MÊS DO ANO FOI "
							+ currentDate.getMonthForInt(Integer.valueOf(avgOfMonths[14]), 1)
							+ ", O QUE VENDEMOS EM MÉDIA R$" + avgOfMonths[12] + "\nO PIOR MÊS DO ANO FOI "
							+ currentDate.getMonthForInt(Integer.valueOf(avgOfMonths[15]), 1)
							+ ", O QUE VENDEMOS EM MÉDIA R$" + avgOfMonths[13], // 4 MAX AND MIN FOR THE MONTH
					"\n\n*A MÉDIA DE ACORDO COM O DIA SÃO:\nSEGUNDA-FEIRA -> R$" + daysAvg[0] + " (%" + daysPerc[0]
							+ ")\nTERÇA-FEIRA -> R$" + daysAvg[1] + " (%" + daysPerc[1] + ")\nQUARTA-FEIRA -> R$"
							+ daysAvg[2] + " (%" + daysPerc[2] + ")\nQUINTA-FEIRA -> R$" + daysAvg[3] + " (%"
							+ daysPerc[3] + ")\nSEXTA-FEIRA -> R$" + daysAvg[4] + " (%" + daysPerc[4]
							+ ")\nSÁBADO -> R$" + daysAvg[5] + " (%" + daysPerc[5] + ")\nDOMINGO -> R$" + daysAvg[6]
							+ " (%" + daysPerc[6] + ")", // 5
					"\n\n*OBRIGADO E ATÉ AMANHÃ :)"// 2
			};
			String[] engSumm = {
					"\n\n*COMPARISON WITH LAST YEAR:\nTHIS YEAR, WE SOLD AN AVERAGE OF R$" + dailyAvg
							+ "\nLAST YEAR, WE SOLD AN AVERAGE OF R$" + dailyAvg22 + "\nIT LOOKS LIKE WE SOLD R$"
							+ (dailyAvg > dailyAvg22
									? (dailyAvg - dailyAvg22) + " MORE THAN LAST YEAR ( ⬆ "
											+ 100 * (dailyAvg - dailyAvg22) / dailyAvg22 + "%)"
									: (dailyAvg22 - dailyAvg) + " LESS THAN LAST YEAR ( ⬇ "
											+ 100 * (dailyAvg22 - dailyAvg) / dailyAvg22 + "%)"), // 0
					"\n\n*EXTREMES OF THE MONTH:\nTHE BEST DAY OF THIS YEAR IS " + maxDayString + " " + maxDIndex + "-"
							+ currentDate.getMonthForInt(monthFromIndex(temp[2]) - 1, 2) + ", WHAT WE SOLD R$" + temp[0]
							+ "\nTHE WORST DAY OF THIS YEAR IS " + minDayString + " " + minDIndex + "-"
							+ currentDate.getMonthForInt(monthFromIndex(temp[3]) - 1, 2) + ", WHAT WE SOLD R$"
							+ temp[1], // 1
					"\n\n*DIFFERENCE FROM PREVIOUS MONTHS:\n" + avgOfMonths[0] + avgOfMonths[1] + avgOfMonths[2]
							+ avgOfMonths[3] + avgOfMonths[4] + avgOfMonths[5], // 2
					avgOfMonths[6] + avgOfMonths[7] + avgOfMonths[8] + avgOfMonths[9] + avgOfMonths[10]
							+ avgOfMonths[11], // 3 months
					"\n*EXTREMES OF THE YEAR\nTHE BEST MONTH OF THE YEAR WAS "
							+ currentDate.getMonthForInt(Integer.valueOf(avgOfMonths[14]), 2)
							+ ", WHAT WE SOLD AN AVERAGE OF R$" + avgOfMonths[12] + "\nTHE WORST MONTH OF THE YEAR WAS "
							+ currentDate.getMonthForInt(Integer.valueOf(avgOfMonths[15]), 2)
							+ ", WHAT WE SOLD AN AVERAGE OF R$" + avgOfMonths[13], // 4 MAX AND MIN FOR THE MONTH
					"\n\n*THE AVERAGE ACCORDING TO THE DAY ARE:\nMONDAY -> R$" + daysAvg[0] + " (%" + daysPerc[0]
							+ ")\nTUESDAY -> R$" + daysAvg[1] + " (%" + daysPerc[1] + ")\nWEDNESDAY -> R$" + daysAvg[2]
							+ " (%" + daysPerc[2] + ")\nTHURSDAY -> R$" + daysAvg[3] + " (%" + daysPerc[3]
							+ ")\nFRIDAY -> R$" + daysAvg[4] + " (%" + daysPerc[4] + ")\nSATURDAY -> R$" + daysAvg[5]
							+ " (%" + daysPerc[5] + ")\nSUNDAY -> R$" + daysAvg[6] + " (%" + daysPerc[6] + ")", // 5
					"\n\n*THANKS AND SEE YOU TOMORROW :)" // 4
			};
			String[] frSumm = {
					"\n\n*COMPARAISON AVEC L'ANNÉE DERNIÈRE :\nCETTE ANNÉE, NOUS AVONS VENDU UNE MOYENNE DE R$"
							+ dailyAvg + "\nL'ANNÉE DERNIÈRE, NOUS AVONS VENDU UNE MOYENNE DE R$" + dailyAvg22
							+ "\nIL SEMBLE QUE NOUS AVONS VENDU R$"
							+ (dailyAvg > dailyAvg22
									? (dailyAvg - dailyAvg22) + " PLUS QUE L'AN DERNIER ( ⬆ "
											+ 100 * (dailyAvg - dailyAvg22) / dailyAvg22 + "%)"
									: (dailyAvg22 - dailyAvg) + " MOINS QUE L'AN DERNIER ( ⬇ "
											+ 100 * (dailyAvg22 - dailyAvg) / dailyAvg22 + "%)"), // 0
					"\n\n*EXTREMES DU MOIS :\nLE MEILLEUR JOUR DE CETTE ANNEE EST " + maxDayString + " " + maxDIndex
							+ "-" + currentDate.getMonthForInt(monthFromIndex(temp[2]) - 1, 3)
							+ ", CE QUE NOUS AVONS VENDU R$" + temp[0] + "\nLE PIRE JOUR DE CETTE ANNÉE EST "
							+ minDayString + " " + minDIndex + "-"
							+ currentDate.getMonthForInt(monthFromIndex(temp[3]) - 1, 3)
							+ ", CE QUE NOUS AVONS VENDU R$" + temp[1], // 1
					"\n\n*DIFFÉRENCE AVEC LES MOIS PRÉCÉDENTS :\n" + avgOfMonths[0] + avgOfMonths[1] + avgOfMonths[2]
							+ avgOfMonths[3] + avgOfMonths[4] + avgOfMonths[5], // 2
					avgOfMonths[6] + avgOfMonths[7] + avgOfMonths[8] + avgOfMonths[9] + avgOfMonths[10]
							+ avgOfMonths[11], // 3 mois
					"\n*EXTREMES DE L'ANNÉE\nLE MEILLEUR MOIS DE L'ANNÉE A ÉTÉ "
							+ currentDate.getMonthForInt(Integer.valueOf(avgOfMonths[14]), 3)
							+ ", CE QUE NOUS AVONS VENDU EN MOYENNE DE R$" + avgOfMonths[12]
							+ "\nLE PIRE MOIS DE L'ANNÉE A ÉTÉ "
							+ currentDate.getMonthForInt(Integer.valueOf(avgOfMonths[15]), 3)
							+ ", CE QUE NOUS AVONS VENDU EN MOYENNE DE R$" + avgOfMonths[13], // 4 MAX ET MIN POUR LE
																								// MOIS
					"\n\n*LA MOYENNE SELON LE JOUR EST :\nLUNDI -> R$" + daysAvg[0] + " (%" + daysPerc[0]
							+ ")\nMARDI -> R$" + daysAvg[1] + " (%" + daysPerc[1] + ")\nMERCREDI -> R$" + daysAvg[2]
							+ " (%" + daysPerc[2] + ")\nJEUDI -> R$" + daysAvg[3] + " (%" + daysPerc[3]
							+ ")\nVENDREDI -> R$" + daysAvg[4] + " (%" + daysPerc[4] + ")\nSAMEDI -> R$" + daysAvg[5]
							+ " (%" + daysPerc[5] + ")\nDIMANCHE -> R$" + daysAvg[6] + " (%" + daysPerc[6] + ")", // 5
					"\n\n*MERCI ET À DEMAIN :)" // 4
			};
			savedF.write(titleName() + (language == 0 ? (" - SUMARIO DE ESTE AÑO")
					: language == 1 ? (" - RESUMO DESTE ANO")
							: language == 2 ? (" - SUMMARY OF THIS YEAR") : " - SOMMAIRE DE CETTE ANNEE"));
			savedF.write(
					language == 0 ? espSumm[0] : language == 1 ? porSumm[0] : language == 2 ? engSumm[0] : frSumm[0]);
			savedF.write(
					language == 0 ? espSumm[1] : language == 1 ? porSumm[1] : language == 2 ? engSumm[1] : frSumm[1]);
			savedF.write(
					language == 0 ? espSumm[2] : language == 1 ? porSumm[2] : language == 2 ? engSumm[2] : frSumm[2]);
			savedF.write(
					language == 0 ? espSumm[3] : language == 1 ? porSumm[3] : language == 2 ? engSumm[3] : frSumm[3]);
			savedF.write(
					(language == 0 ? espSumm[4] : language == 1 ? porSumm[4] : language == 2 ? engSumm[4] : frSumm[4]));
			savedF.write(
					(language == 0 ? espSumm[5] : language == 1 ? porSumm[5] : language == 2 ? engSumm[5] : frSumm[5]));
			savedF.write(
					language == 0 ? espSumm[6] : language == 1 ? porSumm[6] : language == 2 ? engSumm[6] : frSumm[6]);
			savedF.close();
			First.savedCorrectly(language);
		} catch (Exception e2) {
			JOptionPane opt = new JOptionPane(
					language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
					JOptionPane.ERROR_MESSAGE);
			opt.show();
		}
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
		String lan[] = { "ESPAÑOL", "PORTUGUÊS", "ENGLISH", "FRENCH" };
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
			if (currentDate.d != 29 || currentDate.m != 2)
				currentDate.saveTotal23(totalVenta);
			exBtn(language);
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
		int ventaTemp = totalVenta;
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
		// check if we sold something
		if (totalVenta != ventaTemp) {
			lastChanged = (language == 0 ? "ÚLTIMA ACTUALIZACIÓN: "
					: language == 1 ? "ÚLTIMA ATUALIZAÇÃO: "
							: language == 2 ? "LAST UPDATE: " : "DERNIÈRE MISE À JOUR: ")
					+ new SimpleDateFormat("HH").format(Calendar.getInstance().getTime()) + ":"
					+ new SimpleDateFormat("mm").format(Calendar.getInstance().getTime()) + ":"
					+ new SimpleDateFormat("ss").format(Calendar.getInstance().getTime());
		}
		lastChange.setText(lastChanged);
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
				+ (panelCnum[9].getText().equals("") ? 0 : Integer.valueOf(panelCnum[9].getText()) * 1)
				+ (panelCnum[10].getText().equals("") ? 0 : Integer.valueOf(panelCnum[10].getText()) * 1));
		total[7].setText("R$" + totalCaja);
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
				- Integer.valueOf(panelCnum[3].getText()) * 100 - Integer.valueOf(panelCnum[4].getText()) * 50
				- Integer.valueOf(panelCnum[10].getText());
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
			JButton aggPanel, JButton pixMore) {
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
		First.myFontXS = new Font("Tahoma", Font.ITALIC, 10);
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
		dateLabel.setFont(First.myFont);
		dateLabel.setBounds(500, 10, 405, 25);
		lastChange.setFont(First.myFontXS);
		lastChange.setBounds(550, 515, 405, 25);
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
		for (int i = 0; i < 11; i++) {
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
			case 10:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(pixI.getImage(), 50, 40)));
				break;
			default:
				break;
			}
		}
		pixMore.setBounds(900, 241, 50, 20);
		pixMore.setFont(First.myFontS);
		aggBtn[0].setBounds(400, 240, 50, 20);
		aggBtn[1].setBounds(450, 240, 50, 20);
		total[7].setBounds(400, 340, 550, 40);
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
			JButton aggPanel, JButton pixMore) {
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
		First.myFontXS = new Font("Tahoma", Font.ITALIC, 12);
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
		dateLabel.setFont(First.myFont);
		dateLabel.setBounds(650, 10, 320, 30);
		lastChange.setFont(First.myFontXS);
		lastChange.setBounds(700, 610, 405, 30);
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
		for (int i = 0; i < 11; i++) {
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
			case 10:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(pixI.getImage(), 60, 40)));
				break;
			default:
				break;
			}
		}
		pixMore.setBounds(1180, 301, 60, 20);
		pixMore.setFont(First.myFontS);
		aggBtn[0].setBounds(580, 300, 60, 20);
		aggBtn[1].setBounds(640, 300, 60, 20);
		total[7].setBounds(580, 400, 660, 40);
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

	// Resolution medium
	private void resM(JMenuItem resoD, JMenuItem resoXP, JMenuItem resoP, JMenuItem resoM, JMenuItem resoG,
			JButton notasF, JButton pesosF, JButton newDay, JButton clearEverthing, JButton gastosPanel,
			JButton aggPanel, JButton pixMore) {
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
		First.myFontXS = new Font("Tahoma", Font.ITALIC, 14);
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
		dateLabel.setFont(First.myFont);
		dateLabel.setBounds(700, 10, 450, 30);
		lastChange.setFont(First.myFontXS);
		lastChange.setBounds(800, 700, 405, 30);
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
		for (int i = 0; i < 11; i++) {
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
			case 10:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(pixI.getImage(), 70, 50)));
				break;
			default:
				break;
			}
		}
		pixMore.setBounds(1340, 351, 70, 30);
		pixMore.setFont(First.myFontS);
		aggBtn[0].setBounds(640, 351, 70, 30);
		aggBtn[1].setBounds(710, 351, 70, 30);
		total[7].setBounds(640, 480, 770, 50);
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
			JButton aggPanel, JButton pixMore) {
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
		First.myFontXS = new Font("Tahoma", Font.ITALIC, 17);
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
		dateLabel.setFont(First.myFont);
		dateLabel.setBounds(900, 10, 550, 30);
		lastChange.setFont(First.myFontXS);
		lastChange.setBounds(950, 900, 405, 30);
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
		for (int i = 0; i < 11; i++) {
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
			case 10:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(pixI.getImage(), 80, 60)));
				break;
			default:
				break;
			}
		}
		pixMore.setBounds(1600, 431, 80, 40);
		pixMore.setFont(First.myFontS);
		total[7].setBounds(800, 590, 880, 60);
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
		} else if (idioma == 2) {
			gastos.setText("B I L L S");// Spend of the day TITLE
			agregado.setText("A G G R E G A T E S");// Added to cash title
			hideBtn.setText("BUTTONS");
			noHide.setText("NOTHING");
			hideDate.setText("DATE");
			hideAll.setText("ALL");
			newDay.setText("<html><center>Will stay<br>For tomorrow</center></html>");// REST
			resoD.setText("OPTIMAL");
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
		} else {
			gastos.setText("F A C T U R E S");// Spend of the day TITLE
			agregado.setText("A G R É G A T S");// Added to cash title
			hideBtn.setText("BOUTONS");
			noHide.setText("RIEN");
			hideDate.setText("DATE");
			hideAll.setText("TOUTE");
			newDay.setText("<html><center>Restera<br>Pour demain</center></html>");// REST
			resoD.setText("OPTIMAL");
			summaryT[0].setText("Initial");
			summaryT[1].setText("Factures");
			summaryT[2].setText("Agrégats");
			summaryT[3].setText("Ventes");
			summaryT[4].setText("Total");

			diffResult[0].setText("Différence");
			file.setText("FICHER");
			novo.setText("NOUVEAU JOUR");
			clear.setText("NETTOIE TOUT");
			calc.setText("ASSUMER");
			save.setText("SAUVER");
			screenShot.setText("CAPTURE D'ÉCRAN");
			option.setText("PARAMÈTRES");
			exit.setText("SORTIE");

			summary.setText("RÉSUMÉ");
			sumV.setText("VISUALISATION SOMMAIRE");
			effectChooser.setText("CHOISISSEZ VOTRE EFFET");
			sumV1.setText("DÉCOLORATION");
			sumV2.setText("APPARAÎTRE MOT PAR MOT");
			sumV3.setText("APPARAÎTRE LETTRE PAR LETTRE");
			exMenu.setText("ENREGISTRER LE RÉSUMÉ");
			speedChooser.setText("LA VITESSE D'ANIMATION");
			speed1.setText("LENTE");
			speed2.setText("MOYEN");
			speed3.setText("RAPIDE");

			goTo.setText("ALLER");
			pesos.setText("PESOS");
			fatura.setText("FACTURE");
			firstFrame.setText("PREMIER CADRE");
			reso.setText("RÉSOLUTION");
			reso1.setText("GRAND");
			reso2.setText("MOYEN");
			reso3.setText("PETIT");
			reso4.setText("X-PETIT");
			help.setText("AIDER");
			hideMenu.setText("CACHER");
			keyShortcut.setText("RACCOURCI TOUCHE");
			creator.setText("À PROPOS DU CRÉATEUR");
			about.setText("À PROPOS DE L'APPLICATION");
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
				, "REVISIÓN DEL MES"// 36
				, "OTROS"// 37
				, "SEPARADOS"// 38
				, "FECHA"// 39
				, "REVISIÓN DEL AÑO"// 40
				, "MÁS"// 41
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
				, "REVISÃO DO MÊS"// 36
				, "OUTROS"// 37
				, "SEPARADAS"// 38
				, "DATA"// 39
				, "REVISÃO DO ANO" // 40
				, "MAIS"// 41
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
				, "More "// mas 21
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
				, "MONTHLY REVIEW"// 36
				, "OTHERS"// 37
				, "SEPARATED"// 38
				, "DATE"// 39
				, "ANNUAL REVIEW" // 40
				, "MORE"// 41
		};
		String[] french = { "• CTRL + S → aller à la facture.\n" + "• CTRL + P → aller aux pesos.\n"
				+ "• CTRL + B → tout supprimer.\n" + "• CTRL + N → préparez-vous pour le lendemain.\n"
				+ "• flèches → haut, bas, gauche et droite.\n" + "• CTRL + D → aller aux détails.\n"
				+ "• CTRL + I → aller au début.\n" + "• CTRL + G → aller aux dépenses.\n"
				+ "• CTRL + A → aller à l'agrégat.\n" + "• CTRL + T → aller à la caisse.\n"
				+ "• CTRL + E → aller au dernier numéro.\n"
				+ "• CTRL + M → ajouter un ensemble de 100 ou 1000 si possible.\n"
				+ "• CTRL + C → ouvrir les paramètres."// 0
				, "RACCOURCIS TOUCHES" // tecla de atalho 1
				, "Crédit et conçu par MhmdSAbdlh ©"// créateur 2
				,
				"CETTE APPLICATION EST CONÇUE POUR LA BOUTIQUE GRATUITE CEDROS ET NARJES.\r\n"
						+ "A UN CADRE POUR FERMER LA BOÎTE EN REALS ET PESOS.\r\n"
						+ "IL EXISTE UN CADRE POUR CALCULER LE CHANGEMENT POUR UNE VENTE, À LA FOIS EN BRL ET EN PESOS.\r\n"
						+ "SAVOIR COMBIEN CELA SERA LE LENDEMAIN.\r\n" + "3 MÉTHODES POUR RENDRE LA CHANGE.\r\n"
						+ "VA TOUT CHANGER SELON L'ICÔNE SÉLECTIONNÉ.\r\n" + "\r\n" + "MOHAMAD ABDALLAH ABBASS ©"// about3
				, "CONFIGURATION"// titre de la conf4
				, "ICÔNE"// icône5
				, "LANGUE"// PREMIÈRE IMAGE6
				, "RACCOURCI TOUCHE"// RACCOURCI TOUCHE7
				, "AUTO-SAVUVER"// ENREGISTREMENT AUTO8
				, "DEFAUT"// DEFAUT 9
				, "SAVUVER"// ENREGISTRER 11
				, "OUI"// OUI 12
				, "NON"// NON 13
				, "Êtes-vous sûr de vouloir partir ?"// exit 14
				, "QUITTER"// exit15
				, "OUI /NOUVEAU JOUR"// nouveau jour 16
				, "VOULEZ-VOUS COMMENCER UNE NOUVELLE JOURNÉE ?" // nouveau jour 17
				, "NOUVEAU JOUR" // nouveau jour 18
				, "VOULEZ-VOUS TOUT SUPPRIMER ?"// clear 19
				, "TOUT SUPPRIMER" // clear20
				, "Plus " // mas 21
				, "<html><center>Il n'y a pas de différence</html>"// diif 22
				, "Plus de R$" // fin 23
				, "R$ manqué" // falta 24
				, "IL N'Y A RIEN A ASSEMBLER!"// nada mas 25
				, "LA CAPTURE D'ÉCRAN PREND BIEN" // SCREENSJOT 25
				, "SAUVEGARDER AVEC SUCCÈS, MERCI" // ÉCONOMISEZ 26
				, "CASH CLOSING - R$"// TITRE 27
				, "À PROPOS DE MOI"// à propos de moi 28
				, "FACTURES"// 29
				, "GRANULATS"// 30
				, "SOUVENIRS D'AUJOURD'HUI"// 31
				, "Entrez le mot de passe"// 32
				, "Annuler, X ou touche d'échappement sélectionnée"// 33
				, "Mot de passe erroné, réessayez !"// 34
				, "SEPARE 🔒"// 35
				, "REVUE MENSUELLE"// 36
				, "AUTRES"// 37
				, "SÉPARÉ"// 38
				, "DATE"// 39
				, "REVUE ANNUELLE" // 40
				, "PLUS"// 41
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
				} else if (details[i][j].getText().equals("mhmd"))
					separadosFrame();
				// GO TO Pesos
				else if ((e.getKeyCode() == KeyEvent.VK_P) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
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
					if (i < 10) {
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
						panelCnum[i].setNextFocusableComponent(panelCnum[10]);
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
			JMenuItem resoXP, JMenuItem resoP, JMenuItem resoM, JMenuItem resoG, JButton aggPanel, JButton gastosPanel,
			JButton pixMore) {
		if (width > 1800 && height > 1000)
			resG(resoD, resoXP, resoP, resoM, resoG, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel,
					pixMore);
		else if (width > 1500 && height > 700)
			resM(resoD, resoXP, resoP, resoM, resoG, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel,
					pixMore);
		else if (width > 1300 && height > 700)
			resP(resoD, resoXP, resoP, resoM, resoG, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel,
					pixMore);
		else
			resXP(resoD, resoXP, resoP, resoM, resoG, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel,
					pixMore);
	}

	private void pixFrame() {
		JFrame pixFrame = new JFrame();
		pixFrame.setTitle("PIX");
		pixFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pixFrame.setAlwaysOnTop(false);
		pixFrame.setSize(167, 267);
		pixFrame.setLocationRelativeTo(null);
		pixFrame.setResizable(false);
		pixFrame.setLayout(null);
		pixFrame.getContentPane().setBackground(First.darkC);
		pixFrame.setIconImage(pixI.getImage());
		JTextField pixNmb[] = new JTextField[5];
		for (int i = 0; i < 5; i++) {
			pixNmb[i] = new JTextField();
			textFieldStyle(pixNmb[i]);
			pixNmb[i].setBounds(0, 2 + 45 * i, 150, 45);
			pixNmb[i].setBackground(First.darkC);
			pixNmb[i].removeFocusListener(textFocus);
			pixNmb[i].setForeground(First.lightC);
			pixNmb[i].addKeyListener(new KeyAdapter() {// Escape to close
				@SuppressWarnings("static-access")
				public void keyPressed(KeyEvent ke) {
					if (ke.getKeyCode() == ke.VK_ESCAPE) {
						pix = 0;
						for (int i = 0; i < 5; i++)
							if (First.isNumeric(pixNmb[i].getText()))
								pix += Integer.valueOf(pixNmb[i].getText());
						panelCnum[10].setText(pix + "");
						sumF();
						pixFrame.dispose();
					}
				}
			});
			pixFrame.add(pixNmb[i]);
		}
		// Close popup
		pixFrame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				pix = 0;
				for (int i = 0; i < 5; i++)
					if (First.isNumeric(pixNmb[i].getText()))
						pix += Integer.valueOf(pixNmb[i].getText());
				panelCnum[10].setText(pix + "");
				sumF();
			}
		});
		pixFrame.setVisible(true);
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

	// Separated panel
	private void sepPanel(JTextField[][] sepLabel, int i) {
		JFrame panel = new JFrame();
		panel.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		panel.setAlwaysOnTop(false);
		panel.setSize(200, 75);
		panel.setLocationRelativeTo(null);
		panel.setResizable(false);
		panel.setLayout(new FlowLayout());
		panel.getContentPane().setBackground(First.darkC);
		DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
		dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		String[] months = { currentDate.getMonthForInt(0, language), currentDate.getMonthForInt(1, language),
				currentDate.getMonthForInt(2, language), currentDate.getMonthForInt(3, language),
				currentDate.getMonthForInt(4, language), currentDate.getMonthForInt(5, language),
				currentDate.getMonthForInt(6, language), currentDate.getMonthForInt(7, language),
				currentDate.getMonthForInt(8, language), currentDate.getMonthForInt(9, language),
				currentDate.getMonthForInt(10, language), currentDate.getMonthForInt(11, language) };
		JComboBox<String> op1C = new JComboBox<>(months);
		op1C.setRenderer(dlcr);
		op1C.setBorder(new EmptyBorder(0, 0, 0, 0));
		op1C.setBackground(First.lightC);
		op1C.addActionListener(e1 -> monthReturned = op1C.getSelectedIndex() + 1);
		Integer[] integer2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
				25, 26, 27, 28, 29, 30, 31 };
		JComboBox<Integer> op2C = new JComboBox<>(integer2);
		op2C.setRenderer(dlcr);
		op2C.setBorder(new EmptyBorder(0, 0, 0, 0));
		op2C.setBackground(First.lightC);
		op2C.addActionListener(e1 -> dayReturned = op2C.getSelectedIndex() + 1);
		if (sepLabel[i][1] != null && !sepLabel[i][1].getText().isBlank()) {
			String temp = sepLabel[i][1].getText();
			String[] parts = temp.split("-");
			op2C.setSelectedIndex(Integer.valueOf(parts[0]) - 1);
			op1C.setSelectedIndex(Integer.valueOf(parts[1]) - 1);
		}

		panel.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				try {
					sepLabel[i][1].setText(dayReturned + "-" + monthReturned);
					Runtime.getRuntime().exec("taskkill /f /im java.exe");
				} catch (IOException e4) {
					JOptionPane opt = new JOptionPane(
							language == 0 ? "ERROR, NO SALVO!" : language == 1 ? "ERROR, NAO SALVO!" : "ERROR",
							JOptionPane.ERROR_MESSAGE);
					opt.show();
				}
			}
		});

		panel.add(op2C);
		panel.add(op1C);
		panel.setIconImage(sepI.getImage());
		panel.setVisible(true);
	}

	// Import the Separated values
	private void importSep() {
		// separated decrypt
		BufferedReader sepOpened = null;
		String sepLine = "";
		int sepInt = 0;
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
		if (sepData[0] == null)
			while (sepInt < 10) {
				sepData[sepInt] = "";
				sepInt++;
			}
		sepInt = 0;
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 2; j++)
				if (sepData[sepInt].length() > 0)
					sepData[sepInt] = encrypt.decrypt(sepData[sepInt++]);// decrypt the text
	}

	// The date according to the choosing language
	private void dateLang(int lang) {
		if (lang == 0) {
			monthS = new SimpleDateFormat("MMMM", new Locale("es")).format(Calendar.getInstance().getTime())
					.toUpperCase();
			dayS = new SimpleDateFormat("EEEE", new Locale("es")).format(Calendar.getInstance().getTime())
					.toUpperCase();
		} else if (lang == 1) {
			monthS = new SimpleDateFormat("MMMM", new Locale("pt")).format(Calendar.getInstance().getTime())
					.toUpperCase();
			dayS = new SimpleDateFormat("EEEE", new Locale("pt")).format(Calendar.getInstance().getTime())
					.toUpperCase();
		} else if (lang == 2) {
			monthS = new SimpleDateFormat("MMMM", new Locale("en")).format(Calendar.getInstance().getTime())
					.toUpperCase();
			dayS = new SimpleDateFormat("EEEE", new Locale("en")).format(Calendar.getInstance().getTime())
					.toUpperCase();
		} else {
			monthS = new SimpleDateFormat("MMMM", new Locale("fr")).format(Calendar.getInstance().getTime())
					.toUpperCase();
			dayS = new SimpleDateFormat("EEEE", new Locale("fr")).format(Calendar.getInstance().getTime())
					.toUpperCase();
		}
	}

	// fade effect for screenshot
	private void fadeEffect(JFrame frame, int color) {
		ActionListener letterByLetter = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().setBackground(new Color(colorBW, colorBW, colorBW));
				if (colorBW > 0)// Details fade in
					colorBW -= 2;
				else {
					colorBW = color;
					frame.getContentPane().setBackground(new Color(colorBW, colorBW, colorBW));
					timer.stop();
				}
			}
		};

		timer = new Timer(1, letterByLetter);
		timer.start();
	}

	// ScreenShoot the main frame
	private void screenShooter() {
		BufferedImage img = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
		this.paint(img.getGraphics());
		File tempFile1 = new File(tempFile0 + "\\" + yearS);
		tempFile1.mkdir();
		File tempFile2 = new File(tempFile1 + "\\" + First.monthN + "-" + monthS);
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

	// change res action listener
	private void resolutionActionListener(JButton clearEverthing, JButton pesosF, JButton notasF, JButton newDay,
			JMenuItem resoD, JButton aggPanel, JButton gastosPanel, JMenuItem reso1, JMenuItem reso2, JMenuItem reso3,
			JMenuItem reso4, JButton pixMore) {
		resoD.addActionListener(e -> {
			conf[3] = "0";
			opResolution(clearEverthing, pesosF, notasF, newDay, resoD, reso4, reso3, reso2, reso1, aggPanel,
					gastosPanel, pixMore);
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
			resG(resoD, reso4, reso3, reso2, reso1, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel,
					pixMore);
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
			resM(resoD, reso4, reso3, reso2, reso1, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel,
					pixMore);
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
			resP(resoD, reso4, reso3, reso2, reso1, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel,
					pixMore);
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
			resXP(resoD, reso4, reso3, reso2, reso1, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel,
					pixMore);
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

	// summ change action listener
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

	// change speed of animation action listener
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

	// hide btns action listener
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
			dateLabel.show();
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
			dateLabel.hide();
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
			dateLabel.show();
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
			dateLabel.hide();
		});
	}

	// Know the app title
	private String titleName() {
		if (conf[0] == null || !conf[0].equals("3"))
			return "CEDROS";
		else
			return "NARJES";
	}

	// getting the maximum value [0] and the index [1]
	private int[] getMaxValue(int[] array) {
		int index[] = { 0, 0 };
		index[0] = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > index[0]) {
				index[0] = array[i];
				index[1] = i;
			}
		}
		return index;
	}

	// getting the miniumum value [0] and the index [1]
	private int[] getMinValue(int[] array) {
		int index[] = { 0, 0 };
		index[0] = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < index[0]) {
				index[0] = array[i];
				index[1] = i;
			}
		}
		return index;
	}

	// return the max[0] and the min[1] of the year with the index[2][3]
	private int[] yearMaxMin() {
		int[] returned = { 0, 0, 0, 0 };
		int monthToAdd = currentDate.whatMonthsToAdd();
		int maxYear[] = new int[monthToAdd + 1];
		int minYear[] = new int[monthToAdd + 1];
		int maxIndex[] = new int[monthToAdd + 1];
		int minIndex[] = new int[monthToAdd + 1];
		int maxTotal[] = new int[2];
		int minTotal[] = new int[2];
		int optOfMonth[] = new int[4];
		for (int i = 0; i < monthToAdd + 1; i++) {// max, min for every month
			optOfMonth = maxMinMes(i + 1);
			maxYear[i] = optOfMonth[0];
			minYear[i] = optOfMonth[1];
			maxIndex[i] = optOfMonth[2];
			minIndex[i] = optOfMonth[3];
		}
		maxTotal = getMaxValue(maxYear);// max total
		minTotal = getMinValue(minYear);// min total

		returned[0] = maxTotal[0];
		returned[1] = minTotal[0];
		returned[2] = maxIndex[maxTotal[1]] - 1;
		returned[3] = minIndex[minTotal[1]] - 1;
		return returned;
	}

	// return the month number according to the index
	private int monthFromIndex(int index) {
		int indexMonths[] = new int[12];
		int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		indexMonths[0] = 31;
		for (int i = 1; i < 12; i++)
			indexMonths[i] = daysInMonth[i] + indexMonths[i - 1];

		int indexTrue = 0;
		while (indexTrue < 12) {
			if (index < indexMonths[indexTrue])
				break;
			indexTrue++;
		}
		return (indexTrue + 1);
	}

	// The value of the sell one year ago
	private String vend2022(int d) {
		DateModified date = new DateModified(1, 1, 2022);
		String date22[] = new String[366];
		String appV;
		if (First.conf[0] == null || !First.conf[0].equals("3"))
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

	// return the total for month[0], and the quantity of days[1]
	private int[] totalOfMes(int month, int year) {
		DateModified dateM = new DateModified(1, month, year);
		int index = dateM.index();
		int returned[] = { 0, 0 };
		ArrayList<String> totalMes = new ArrayList<String>();
		String line = "";
		if (year == 2023)
			try {// open the data for 2023
				File extraFolder = new File(tempFile0 + "\\extra");
				File extraFile = new File(extraFolder, "2023.dll");
				BufferedReader dataOpened = new BufferedReader(new FileReader(extraFile));
				while ((line = dataOpened.readLine()) != null) {
					totalMes.add(line.toString());
				}
				dataOpened.close();
			} catch (Exception e) {
				JOptionPane opt = new JOptionPane("ERROR!", JOptionPane.ERROR_MESSAGE);
				opt.show();
			}
		else {
			String appV;
			if (conf[0] == null || !conf[0].equals("3"))
				appV = "2022C.dll";
			else
				appV = "2022N.dll";
			try {
				BufferedReader dataOpened = new BufferedReader(
						new InputStreamReader(this.getClass().getResourceAsStream("/extra/" + appV)));
				while ((line = dataOpened.readLine()) != null) {
					totalMes.add(line.toString());
				}
				dataOpened.close();
			} catch (Exception e) {
				JOptionPane opt = new JOptionPane("ERROR!", JOptionPane.ERROR_MESSAGE);
				opt.show();
			}
		}

		for (int i = index; i < index + dateM.maxDays(); i++) {
			if (i < totalMes.size() && First.isNumeric(totalMes.get(i))) {
				returned[0] += Integer.valueOf(totalMes.get(i));
				if (Integer.valueOf(totalMes.get(i)) != 0)
					returned[1]++;
			}
		}
		return returned;
	}

	// function to write the total/average min and max for the anteriours months
	private String[] monthsText(int month) {
		DateModified dateFromMonth = new DateModified(Integer.valueOf(dayN), month, Integer.valueOf(yearS));
		int monthsCount = dateFromMonth.whatMonthsToAdd() + 1;
		int avgOfMonths[] = new int[monthsCount];
		int totalOfMonths[] = new int[monthsCount];
		int indexOfMonth = 0;
		// average of every month
		if (monthsCount == 0)
			return null;
		while (indexOfMonth < monthsCount) {
			avgOfMonths[indexOfMonth] = monTotalAverage(indexOfMonth + 1)[1] == 0 ? 0
					: monTotalAverage(indexOfMonth + 1)[0] / monTotalAverage(indexOfMonth + 1)[1];
			totalOfMonths[indexOfMonth] = monTotalAverage(indexOfMonth + 1)[0];
			indexOfMonth++;
		}
		// max month
		int maxMonth = 0, maxDay = 0;
		maxMonth = getMaxValue(avgOfMonths)[0];
		indexOfMonth = 0;
		while (indexOfMonth < monthsCount) {
			if (maxMonth == avgOfMonths[indexOfMonth])
				break;
			indexOfMonth++;
		}
		maxDay = indexOfMonth;
		// min month
		int minMonth = 0, minDay = 0;
		minMonth = getMinValue(avgOfMonths)[0];
		indexOfMonth = 0;
		while (indexOfMonth < monthsCount) {
			if (minMonth == avgOfMonths[indexOfMonth])
				break;
			indexOfMonth++;
		}
		minDay = indexOfMonth;

		// return the result
		String temp[] = new String[16];
		indexOfMonth = 0;
		while (indexOfMonth < 12) {
			if (indexOfMonth < monthsCount)
				if (language == 0)
					temp[indexOfMonth] = "*EN " + currentDate.getMonthForInt(indexOfMonth, 0) + " VENDISTE R$"
							+ totalOfMonths[indexOfMonth] + " (PROMEDIO = R$" + avgOfMonths[indexOfMonth] + ")\n";
				else if (language == 1)
					temp[indexOfMonth] = "*EM " + currentDate.getMonthForInt(indexOfMonth, 1) + " VENDEU R$"
							+ totalOfMonths[indexOfMonth] + " (MÉDIA = R$" + avgOfMonths[indexOfMonth] + ")\n";
				else if (language == 2)
					temp[indexOfMonth] = "*IN " + currentDate.getMonthForInt(indexOfMonth, 2) + " YOU SOLD R$"
							+ totalOfMonths[indexOfMonth] + " (AVERAGE = R$" + avgOfMonths[indexOfMonth] + ")\n";
				else
					temp[indexOfMonth] = "*EN " + currentDate.getMonthForInt(indexOfMonth, 3) + " TU AS VENDU R$"
							+ totalOfMonths[indexOfMonth] + " (MOYENNE = R$" + avgOfMonths[indexOfMonth] + ")\n";
			else
				temp[indexOfMonth] = "";
			indexOfMonth++;
		} // temp [0] ->[11] total + avg of jan to dec
		temp[12] = "" + maxMonth;// max of all months
		temp[13] = "" + minMonth;// min of all months
		temp[14] = "" + maxDay;// index of max(month-1)
		temp[15] = "" + minDay;// index of min(month-1)
		return temp;
	}

	// the max->[0]and its index->[2] and the min->[1]and its index->[3] for months
	private int[] maxMinMes(int month) {
		DateModified tempDate = new DateModified(1, month, 2023);
		int index = tempDate.index();
		int avgMonth = monTotalAverage(month)[1] == 0 ? 0 : monTotalAverage(month)[0] / monTotalAverage(month)[1];
		int returned[] = { 0, 0, 0, 0 };
		ArrayList<String> totalMes = new ArrayList<String>();
		String line = "";
		try {// open the data for 2023
			File extraFolder = new File(tempFile0 + "\\extra");
			File extraFile = new File(extraFolder, "2023.dll");
			BufferedReader dataOpened = new BufferedReader(new FileReader(extraFile));
			while ((line = dataOpened.readLine()) != null) {
				totalMes.add(line.toString());
			}
			dataOpened.close();
		} catch (Exception e) {
			JOptionPane opt = new JOptionPane("ERROR!", JOptionPane.ERROR_MESSAGE);
			opt.show();
		}
		int[] valuesMes = new int[tempDate.maxDays()];
		int count = 0;
		for (int i = index; i < index + tempDate.maxDays(); i++) {
			if (i < totalMes.size())
				if (First.isNumeric(totalMes.get(i)) && Integer.valueOf(totalMes.get(i)) != 0)
					valuesMes[count] = Integer.valueOf(totalMes.get(i));
				else
					valuesMes[count] = avgMonth;
			else
				valuesMes[count] = avgMonth;
			count++;
		}
		returned[0] = getMaxValue(valuesMes)[0];// max
		returned[1] = getMinValue(valuesMes)[0];// min
		returned[2] = getMaxValue(valuesMes)[1] + index + 1;// maxDay index(day+index month)
		returned[3] = getMinValue(valuesMes)[1] + index + 1;// minday index(day+index month)

		return returned;
	}

	// Day name according to the date(monday,...)
	private String dayName(DateModified d, int lang) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, d.d);
		calendar.set(Calendar.MONTH, d.m - 1);
		calendar.set(Calendar.YEAR, d.y);

		return lang == 0 ? new SimpleDateFormat("EEEEE", new Locale("es")).format(calendar.getTime()).toUpperCase()
				: lang == 1 ? new SimpleDateFormat("EEEE", new Locale("pt")).format(calendar.getTime()).toUpperCase()
						: lang == 2
								? new SimpleDateFormat("EEEEE", new Locale("en")).format(calendar.getTime())
										.toUpperCase()
								: new SimpleDateFormat("EEEEE", new Locale("fr")).format(calendar.getTime())
										.toUpperCase();
	}

	// Average for the selected day
	private int avgSellOfDay(DateModified selectDate) {
		DateModified date2 = new DateModified(1, 1, 2023);
		int i = 0, counter = 0, nbOfDays = 0;
		ArrayList<String> totalMes = new ArrayList<String>();
		String line = "";
		try {// open the data for 2023
			File extraFolder = new File(tempFile0 + "\\extra");
			File extraFile = new File(extraFolder, "2023.dll");
			BufferedReader dataOpened = new BufferedReader(new FileReader(extraFile));
			while ((line = dataOpened.readLine()) != null) {
				totalMes.add(line.toString());
			}
			dataOpened.close();
		} catch (Exception e) {
			JOptionPane opt = new JOptionPane("ERROR!", JOptionPane.ERROR_MESSAGE);
			opt.show();
		}
		while (i < totalMes.size()) {
			if (dayName(selectDate, 0).equals(dayName(date2, 0)))
				if (First.isNumeric(totalMes.get(i))) {
					counter += Integer.valueOf(totalMes.get(i));
					if (Integer.valueOf(totalMes.get(i)) != 0)
						nbOfDays++;
				}
			i++;
			date2.addDays(1);
		}
		return (nbOfDays == 0 ? 0 : counter / nbOfDays);
	}

	// Average for the selected day for the given month
	private int avgSpeDayAccMonth(String day, int month) {
		DateModified date2 = new DateModified(1, month, 2023);
		int i = date2.index(), counter = 0, nbOfDays = 0, maxDays = i + date2.maxDays();
		ArrayList<String> totalMes = new ArrayList<String>();
		String line = "";
		try {// open the data for 2023
			File extraFolder = new File(tempFile0 + "\\extra");
			File extraFile = new File(extraFolder, "2023.dll");
			BufferedReader dataOpened = new BufferedReader(new FileReader(extraFile));
			while ((line = dataOpened.readLine()) != null) {
				totalMes.add(line.toString());
			}
			dataOpened.close();
		} catch (Exception e) {
			JOptionPane opt = new JOptionPane("ERROR!", JOptionPane.ERROR_MESSAGE);
			opt.show();
		}
		while (i < maxDays && i < totalMes.size()) {
			if (day.equalsIgnoreCase(dayName(date2, 2)))
				if (First.isNumeric(totalMes.get(i))) {
					counter += Integer.valueOf(totalMes.get(i));
					if (Integer.valueOf(totalMes.get(i)) != 0)
						nbOfDays++;
				}
			i++;
			date2.addDays(1);
		}
		return (nbOfDays == 0 ? 0 : counter / nbOfDays);
	}

	// Average daily of current year
	private int dailyAvg() {
		int i = 0, counter = 0, nbOfDays = 0;
		ArrayList<String> totalMes = new ArrayList<String>();
		String line = "";
		try {// open the data for 2023
			File extraFolder = new File(tempFile0 + "\\extra");
			File extraFile = new File(extraFolder, "2023.dll");
			BufferedReader dataOpened = new BufferedReader(new FileReader(extraFile));
			while ((line = dataOpened.readLine()) != null) {
				totalMes.add(line.toString());
			}
			dataOpened.close();
		} catch (Exception e) {
			JOptionPane opt = new JOptionPane("ERROR!", JOptionPane.ERROR_MESSAGE);
			opt.show();
		}
		while (i < totalMes.size()) {
			if (First.isNumeric(totalMes.get(i))) {
				counter += Integer.valueOf(totalMes.get(i));
				if (Integer.valueOf(totalMes.get(i)) != 0)
					nbOfDays++;
			}
			i++;
		}
		return (nbOfDays == 0 ? 0 : counter / nbOfDays);
	}

	// total for selected month->[0] and nbofdays->[1]
	private int[] monTotalAverage(int month) {
		DateModified date2 = new DateModified(1, month, 2023);
		ArrayList<String> totalMes = new ArrayList<String>();
		String line = "";
		int index = date2.index(), counter = 0, nbOfDays = 0;
		try {// open the data for 2023
			File extraFolder = new File(tempFile0 + "\\extra");
			File extraFile = new File(extraFolder, "2023.dll");
			BufferedReader dataOpened = new BufferedReader(new FileReader(extraFile));
			while ((line = dataOpened.readLine()) != null) {
				totalMes.add(line.toString());
			}
			dataOpened.close();
		} catch (Exception e) {
			JOptionPane opt = new JOptionPane("ERROR!", JOptionPane.ERROR_MESSAGE);
			opt.show();
		}
		for (int j = index; j < index + date2.maxDays(); j++)
			if (j < totalMes.size() && First.isNumeric(totalMes.get(j))) {
				counter += Integer.valueOf(totalMes.get(j));
				if (Integer.valueOf(totalMes.get(j)) != 0)
					nbOfDays++;
			}
		int[] returned = { counter, nbOfDays };
		return returned;
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
