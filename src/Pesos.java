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
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
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
public class Pesos extends JFrame {
	// Fotos
	private URL u2000 = getClass().getResource("images/p2000.jpg");
	private ImageIcon i2000 = new ImageIcon(u2000);
	private URL u1000 = getClass().getResource("images/p1000.jpg");
	private ImageIcon i1000 = new ImageIcon(u1000);
	private URL u500 = getClass().getResource("images/p500.jpg");
	private ImageIcon i500 = new ImageIcon(u500);
	private URL u200 = getClass().getResource("images/p200.jpg");
	private ImageIcon i200 = new ImageIcon(u200);
	private URL u100 = getClass().getResource("images/p100.jpg");
	private ImageIcon i100 = new ImageIcon(u100);
	private URL u50 = getClass().getResource("images/p50.jpg");
	private ImageIcon i50 = new ImageIcon(u50);
	private URL u20 = getClass().getResource("images/p20.jpg");
	private ImageIcon i20 = new ImageIcon(u20);
	private URL u10 = getClass().getResource("images/p10.jpg");
	private ImageIcon i10 = new ImageIcon(u10);
	private URL u5 = getClass().getResource("images/p5.jpg");
	private ImageIcon i5 = new ImageIcon(u5);
	private URL u2 = getClass().getResource("images/p2.jpg");
	private ImageIcon i2 = new ImageIcon(u2);
	private URL u1 = getClass().getResource("images/p1.jpg");
	private ImageIcon i1 = new ImageIcon(u1);
	private URL uclear = getClass().getResource("images/clear.png");
	private ImageIcon clear = new ImageIcon(uclear);
	private URL reales = getClass().getResource("images/reales.png");
	private ImageIcon realesI = new ImageIcon(reales);
	private URL notas = getClass().getResource("images/notas.png");
	private ImageIcon notasI = new ImageIcon(notas);
	private URL nextD = getClass().getResource("images/nextd.png");
	private ImageIcon nextDI = new ImageIcon(nextD);
	private URL symPhoto = getClass().getResource("images/sum.png");
	private ImageIcon sumI = new ImageIcon(symPhoto);
	private URL expP = getClass().getResource("images/save.png");
	private ImageIcon expI = new ImageIcon(expP);

	// Define Parameter
	static JTextField details[][] = new JTextField[6][20];// Numbers of notes
	static JTextField initialDay = new JTextField("0");// How much begin the day
	static JTextField agregadoTable[] = new JTextField[16];// Added to cash detailed
	static JTextField gastosTable[] = new JTextField[16];// Spend of the day detailed
	static JTextField gTable[] = new JTextField[16];
	static JTextField aTable[] = new JTextField[16];
	static JTextField panelCnum[] = new JTextField[11];
	static JLabel total[] = new JLabel[9];// Total of every column
	static JLabel boletoN[] = new JLabel[6]; // B1,2,3,4,5
	static JLabel summaryT[] = new JLabel[9];// Summary table
	static JLabel gastos = new JLabel("G A S T O S");// Spend of the day TITLE
	static JLabel agregado = new JLabel("A G R E G A D O");// Added to cash title
	JLabel panelFoto[] = new JLabel[11];// Photo row
	static JLabel[] diffResult = new JLabel[2];// calculate the difference
	static JLabel restTmrw = new JLabel();// rest for tomorrow
	static int totalCol = 0, totalVenta = 0, totalO = 0;
	static int gastosT = 0, agregadoT = 0;
	static int restN, totalCaja = 0, nbOf500 = 0;
	int width, height, language;
	static int colorX = 0, order = 0, speedValue, wordsN, wordL, effChooser;
	boolean status = false;
	Timer timer;
	String conf[] = new String[8];

	JLabel date = new JLabel();// date of the day
	String monthS, dayN, dayS, yearS;

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

	Pesos() {
		// Notification when its time to end the day
		long delay = ChronoUnit.MILLIS.between(LocalTime.now(), LocalTime.of(17, 30, 00));
		if (delay < -60000)
			delay = -delay;
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		scheduler.schedule(First.itsAlmostTime(), delay, TimeUnit.MILLISECONDS);

		// Buttons
		JMenuItem hideBtn = new JMenuItem("LOS BOTONES");
		JMenuItem noHide = new JMenuItem("NADA");
		JMenuItem hideDate = new JMenuItem("LA FECHA");
		JMenuItem hideAll = new JMenuItem("TODO");
		JButton clearEverthing = new JButton();
		JButton faturaBtn = new JButton();// FATURA BUTTON
		JButton realesF = new JButton();
		JButton newDay = new JButton("<html><center>Se Quedará<br>Para Mañana</center></html>");// REST
		JMenuItem novo = new JMenuItem("NOVO DIA");
		JMenuItem resoD = new JMenuItem("ÓPTIMO");
		JButton aggPanel = new JButton("↑MÁS↓");
		JButton gastosPanel = new JButton("↑MÁS↓");

		// Frame
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int) screenSize.getWidth();
		height = (int) screenSize.getHeight();
		this.setTitle("CIERRE DE CAJA - $");
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

		// Open Conf
		URL url;
		BufferedReader dataOpened = null;
		String line = "";
		int z = 0;
		try {
			dataOpened = new BufferedReader(new FileReader(new File("conf.txt")));
			while ((line = dataOpened.readLine()) != null) {
				conf[z] = line.toString();
				z++;
			}
			dataOpened.close();
		} catch (Exception e) {
		}
		// Speed
		if (conf[6] == null || conf[6].equals("1"))
			speedValue = 700;
		else if (conf[6].equals("0"))
			speedValue = 1000;
		else
			speedValue = 500;
		// Icon
		if (conf[0] == null || conf[0].equals("0")) {
			url = getClass().getResource("images/icon/cedros0.png");
			restTmrw.show();
		} else if (conf[0].equals("1")) {
			url = getClass().getResource("images/icon/cedros1.png");
			restTmrw.show();
		} else if (conf[0].equals("2")) {
			url = getClass().getResource("images/icon/cedros2.png");
			restTmrw.show();
		} else {
			url = getClass().getResource("images/icon/narjes.png");
			restTmrw.hide();
		}
		this.setIconImage(new ImageIcon(url).getImage());
		// Hide and show BUTTONS
		if (conf[1] == null || conf[1].equals("0")) {// show all
			noHide.setEnabled(false);
			hideDate.setEnabled(true);
			hideBtn.setEnabled(true);
			hideAll.setEnabled(true);
			realesF.show();
			clearEverthing.show();
			faturaBtn.show();
			novo.show();
			date.show();
		} else if (conf[1].equals("1")) {// hide date
			noHide.setEnabled(true);
			hideDate.setEnabled(false);
			hideBtn.setEnabled(true);
			hideAll.setEnabled(true);
			realesF.show();
			clearEverthing.show();
			faturaBtn.show();
			novo.show();
			date.hide();
		} else if (conf[1].equals("2")) {// hide btn
			noHide.setEnabled(true);
			hideDate.setEnabled(true);
			hideBtn.setEnabled(false);
			hideAll.setEnabled(true);
			hideBtn(faturaBtn, realesF, newDay, clearEverthing, hideBtn);
			date.show();
		} else {// hide all
			noHide.setEnabled(true);
			hideDate.setEnabled(true);
			hideBtn.setEnabled(true);
			hideAll.setEnabled(false);
			hideBtn(faturaBtn, realesF, newDay, clearEverthing, hideBtn);
			date.hide();
		}
		// LANGUAGE
		if (conf[7] == null || conf[7].equals("0"))
			language = 0;
		else
			language = 1;
		if (language == 0) {
			monthS = new SimpleDateFormat("MMMM", new Locale("es")).format(Calendar.getInstance().getTime())
					.toUpperCase();
			dayN = new SimpleDateFormat("dd", new Locale("es")).format(Calendar.getInstance().getTime());
			dayS = new SimpleDateFormat("EEEE", new Locale("es")).format(Calendar.getInstance().getTime())
					.toUpperCase();
			yearS = new SimpleDateFormat("YYYY", new Locale("es")).format(Calendar.getInstance().getTime());
		} else {
			monthS = new SimpleDateFormat("MMMM", new Locale("pt")).format(Calendar.getInstance().getTime())
					.toUpperCase();
			dayN = new SimpleDateFormat("dd", new Locale("pt")).format(Calendar.getInstance().getTime());
			dayS = new SimpleDateFormat("EEEE", new Locale("pt")).format(Calendar.getInstance().getTime())
					.toUpperCase();
			yearS = new SimpleDateFormat("YYYY", new Locale("pt")).format(Calendar.getInstance().getTime());
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
				if (details[i][j].getText().equals(""))
					temp += 0;
				if (conf[2] == null || conf[2].equals("false"))
					tableFocus(i, j, this, newDay, faturaBtn, realesF, clearEverthing, hideBtn, resoD, gastosPanel,
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
		initialDay.setBackground(First.lightC);
		initialDay.setForeground(Color.black);
		initialDay.setCaretColor(First.darkC);
		if (conf[2] == null || conf[2].equals("false"))
			iniFocus(newDay, faturaBtn, realesF, clearEverthing, hideBtn, resoD, gastosPanel, aggPanel);
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
			if (i < 4) {
				textFieldStyle(gastosTable[i]);
				gastosTable[i].setBackground(First.redD);
				gastosTable[i].setForeground(Color.white);
				if (conf[2] == null || conf[2].equals("false"))
					gasFocus(i, this, newDay, faturaBtn, realesF, clearEverthing, hideBtn, resoD, gastosPanel,
							aggPanel);
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
					gasFocus(i, this, newDay, faturaBtn, realesF, clearEverthing, hideBtn, resoD, gastosPanel,
							aggPanel);
				this.add(gastosTable[i]);
			}
		}
		First.btnStyle(gastosPanel);
		gastosPanel.setBackground(redT);
		gastosPanel.setForeground(First.lightC);
		gastosPanel.addActionListener(e -> {
			gastosFrame(keywords, faturaBtn, realesF, newDay, clearEverthing, resoD, gastosPanel);
		});
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
			if (i < 4) {
				textFieldStyle(agregadoTable[i]);
				agregadoTable[i].setBackground(First.greenD);
				agregadoTable[i].setForeground(Color.white);
				if (conf[2] == null || conf[2].equals("false"))
					aggFocus(i, this, newDay, faturaBtn, realesF, clearEverthing, hideBtn, resoD, gastosPanel,
							aggPanel);
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
					aggFocus(i, this, newDay, faturaBtn, realesF, clearEverthing, hideBtn, resoD, gastosPanel,
							aggPanel);
				this.add(agregadoTable[i]);
			}
		}
		First.btnStyle(aggPanel);
		aggPanel.setBackground(greenT);
		aggPanel.setForeground(First.lightC);
		aggPanel.addActionListener(e -> {
			aggFrame(keywords, faturaBtn, realesF, newDay, clearEverthing, resoD, gastosPanel);
		});
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

		// Panel 4
		for (int i = 0; i < 11; i++) {
			panelFoto[i] = new JLabel();
			First.labelStyle(panelFoto[i]);
			this.add(panelFoto[i]);
		}
		// Caja detailed
		for (int i = 0; i < 11; i++) {
			panelCnum[i] = new JTextField("0");
			textFieldStyle(panelCnum[i]);
			panelCnum[i].setForeground(First.darkC);
			panelCnum[i].setBackground(First.lightC);
			panelCnum[i].setCaretColor(First.darkC);
			if (conf[2] == null || conf[2].equals("false"))
				cajaFocus(i, this, newDay, faturaBtn, realesF, clearEverthing, hideBtn, resoD, gastosPanel, aggPanel);
			this.add(panelCnum[i]);
		}
		total[7] = new JLabel("TOTAL");// Total Label
		First.labelStyle(total[7]);
		total[7].setBackground(Color.black);
		total[7].setForeground(Color.white);
		this.add(total[7]);

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
		restTmrw.setText("$0");
		First.labelStyle(restTmrw);
		this.add(restTmrw);
		faturaBtn.setFocusable(true);
		faturaBtn.setOpaque(false);
		faturaBtn.setContentAreaFilled(false);
		faturaBtn.setBorderPainted(false);
		faturaBtn.addActionListener(e -> {
			saveProgress();
			FaturaP.totalC.setText("0");
			FaturaP.total.setText("0");
			this.dispose();
			new FaturaP();
		});
		this.add(faturaBtn);
		realesF.setFocusable(true);
		realesF.setOpaque(false);
		realesF.setContentAreaFilled(false);
		realesF.setBorderPainted(false);
		realesF.addActionListener(e -> {
			saveProgress();
			new Reales();
			this.dispose();
		});
		this.add(realesF);
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
		JMenuItem calc = new JMenuItem("ASUMAR");
		JMenuItem clear = new JMenuItem("BORRAR TODO");
		JMenuItem save = new JMenuItem("SALVAR");
		JMenuItem option = new JMenuItem("CONFIGURACIÓN");
		JMenuItem screenShot = new JMenuItem("CAPTURA DE PANTALLA");
		JMenuItem exit = new JMenuItem("SALIR");
		novo.addActionListener(e -> newDay());
		calc.addActionListener(e -> sumF());
		clear.addActionListener(e -> clearAll());
		save.addActionListener(e -> saveProgress());
		screenShot.addActionListener(e -> screenShooter());
		option.addActionListener(e -> confFrame(conf, faturaBtn, realesF, newDay, clearEverthing, hideBtn, resoD,
				gastosPanel, aggPanel));
		exit.addActionListener(e -> System.exit(0));
		file.add(novo);
		file.add(calc);
		file.add(clear);
		file.add(save);
		file.add(screenShot);
		file.add(option);
		file.add(exit);
		// SUMMARY
		JMenu summary = new JMenu("SUMARIO");
		JMenuItem sumV = new JMenuItem("VISTA PREVIA DEL RESUMEN");
		JMenu effectChooser = new JMenu("ELIGE TU EFECTO");
		JMenuItem sumV1 = new JMenuItem("FUNDIDO ENTRADA/FUERA");
		JMenuItem sumV2 = new JMenuItem("APARECE PALABRA POR PALABRA");
		JMenuItem sumV3 = new JMenuItem("APARECE LETRA POR LETRA");
		JMenuItem exMenu = new JMenuItem("GUARDAR RESUMEN");
		JMenu speedChooser = new JMenu("VELOCIDAD DE ANIMACIÓN");
		JMenuItem speed1 = new JMenuItem("LENTO");
		JMenuItem speed2 = new JMenuItem("MEDIANO");
		JMenuItem speed3 = new JMenuItem("RÁPIDO");
		sumV.addActionListener(e -> summaryFrame());
		sumV1.setEnabled(false);
		sumV2.setEnabled(true);
		sumV3.setEnabled(true);
		sumV1.addActionListener(e -> {
			effChooser = 0;
			sumV1.setEnabled(false);
			sumV2.setEnabled(true);
			sumV3.setEnabled(true);
		});
		sumV2.addActionListener(e -> {
			effChooser = 1;
			sumV1.setEnabled(true);
			sumV2.setEnabled(false);
			sumV3.setEnabled(true);
		});
		sumV3.addActionListener(e -> {
			effChooser = 2;
			sumV1.setEnabled(true);
			sumV2.setEnabled(true);
			sumV3.setEnabled(false);
		});
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
		speed1.addActionListener(e -> {
			conf[6] = "0";
			try {
				FileWriter savedF = new FileWriter("conf.txt");
				savedF.write(conf[0] + System.lineSeparator());
				savedF.write(conf[1] + System.lineSeparator());
				savedF.write(conf[2] + System.lineSeparator());
				savedF.write(conf[3] + System.lineSeparator());
				savedF.write(conf[4] + System.lineSeparator());
				savedF.write(conf[5] + System.lineSeparator());
				savedF.write(0 + System.lineSeparator());
				savedF.write(conf[7] + System.lineSeparator());// lan
				savedF.close();
			} catch (Exception e2) {
			}
			speed1.setEnabled(false);
			speed2.setEnabled(true);
			speed3.setEnabled(true);
		});
		speed2.addActionListener(e -> {
			conf[6] = "1";
			try {
				FileWriter savedF = new FileWriter("conf.txt");
				savedF.write(conf[0] + System.lineSeparator());
				savedF.write(conf[1] + System.lineSeparator());
				savedF.write(conf[2] + System.lineSeparator());
				savedF.write(conf[3] + System.lineSeparator());
				savedF.write(conf[4] + System.lineSeparator());
				savedF.write(conf[5] + System.lineSeparator());
				savedF.write(1 + System.lineSeparator());
				savedF.write(conf[7] + System.lineSeparator());// lan
				savedF.close();
			} catch (Exception e2) {
			}
			speed1.setEnabled(true);
			speed2.setEnabled(false);
			speed3.setEnabled(true);
		});
		speed3.addActionListener(e -> {
			conf[6] = "2";
			try {
				FileWriter savedF = new FileWriter("conf.txt");
				savedF.write(conf[0] + System.lineSeparator());
				savedF.write(conf[1] + System.lineSeparator());
				savedF.write(conf[2] + System.lineSeparator());
				savedF.write(conf[3] + System.lineSeparator());
				savedF.write(conf[4] + System.lineSeparator());
				savedF.write(conf[5] + System.lineSeparator());
				savedF.write(2 + System.lineSeparator());
				savedF.write(conf[7] + System.lineSeparator());// lan
				savedF.close();
			} catch (Exception e2) {
			}
			speed1.setEnabled(true);
			speed2.setEnabled(true);
			speed3.setEnabled(false);
		});
		exMenu.addActionListener(e -> exBtn());
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
		// goto
		JMenu goTo = new JMenu("IR A");
		JMenuItem reales = new JMenuItem("REALES");
		JMenuItem fatura = new JMenuItem("FATURA");
		JMenuItem firstFrame = new JMenuItem("PRIMER CUADRO");
		reales.addActionListener(e -> {
			saveProgress();
			new Reales();
			this.dispose();
		});
		fatura.addActionListener(e -> {
			saveProgress();
			FaturaP.totalC.setText("0");
			FaturaP.total.setText("0");
			this.dispose();
			new FaturaP();
		});
		firstFrame.addActionListener(e -> {
			this.dispose();
			new First();
		});
		goTo.add(firstFrame);
		goTo.add(reales);
		goTo.add(fatura);
		// res
		JMenu reso = new JMenu("RESOLUCIÓN");
		JSeparator sep = new JSeparator();
		JMenuItem reso1 = new JMenuItem("GRANDE");
		JMenuItem reso2 = new JMenuItem("MEDIO");
		JMenuItem reso3 = new JMenuItem("PEQUENA");
		JMenuItem reso4 = new JMenuItem("X-PEQUENA");
		resoD.addActionListener(e -> {
			resFun(clearEverthing, faturaBtn, realesF, newDay, resoD, aggPanel, gastosPanel);
			try {
				FileWriter savedF = new FileWriter("conf.txt");
				savedF.write(conf[0] + System.lineSeparator());
				savedF.write(conf[1] + System.lineSeparator());
				savedF.write(conf[2] + System.lineSeparator());
				savedF.write(0 + System.lineSeparator());
				savedF.write(conf[4] + System.lineSeparator());
				savedF.write(conf[5] + System.lineSeparator());
				savedF.write(conf[6] + System.lineSeparator());
				savedF.write(conf[7] + System.lineSeparator());// lan
				savedF.close();
			} catch (Exception e2) {
			}
		});
		reso1.addActionListener(e -> {
			resG(resoD, realesF, faturaBtn, newDay, clearEverthing, gastosPanel, aggPanel);
			try {
				FileWriter savedF = new FileWriter("conf.txt");
				savedF.write(conf[0] + System.lineSeparator());
				savedF.write(conf[1] + System.lineSeparator());
				savedF.write(conf[2] + System.lineSeparator());
				savedF.write(4 + System.lineSeparator());
				savedF.write(conf[4] + System.lineSeparator());
				savedF.write(conf[5] + System.lineSeparator());
				savedF.write(conf[6] + System.lineSeparator());
				savedF.write(conf[7] + System.lineSeparator());// lan
				savedF.close();
			} catch (Exception e2) {
			}
		});
		reso2.addActionListener(e -> {
			resM(resoD, realesF, faturaBtn, newDay, clearEverthing, gastosPanel, aggPanel);
			try {
				FileWriter savedF = new FileWriter("conf.txt");
				savedF.write(conf[0] + System.lineSeparator());
				savedF.write(conf[1] + System.lineSeparator());
				savedF.write(conf[2] + System.lineSeparator());
				savedF.write(3 + System.lineSeparator());
				savedF.write(conf[4] + System.lineSeparator());
				savedF.write(conf[5] + System.lineSeparator());
				savedF.write(conf[6] + System.lineSeparator());
				savedF.write(conf[7] + System.lineSeparator());// lan
				savedF.close();
			} catch (Exception e2) {
			}
		});
		reso3.addActionListener(e -> {
			resP(resoD, realesF, faturaBtn, newDay, clearEverthing, gastosPanel, aggPanel);
			try {
				FileWriter savedF = new FileWriter("conf.txt");
				savedF.write(conf[0] + System.lineSeparator());
				savedF.write(conf[1] + System.lineSeparator());
				savedF.write(conf[2] + System.lineSeparator());
				savedF.write(2 + System.lineSeparator());
				savedF.write(conf[4] + System.lineSeparator());
				savedF.write(conf[5] + System.lineSeparator());
				savedF.write(conf[6] + System.lineSeparator());
				savedF.write(conf[7] + System.lineSeparator());// lan
				savedF.close();
			} catch (Exception e2) {
			}
		});
		reso4.addActionListener(e -> {
			resXP(resoD, realesF, faturaBtn, newDay, clearEverthing, gastosPanel, aggPanel);
			try {
				FileWriter savedF = new FileWriter("conf.txt");
				savedF.write(conf[0] + System.lineSeparator());
				savedF.write(conf[1] + System.lineSeparator());
				savedF.write(conf[2] + System.lineSeparator());
				savedF.write(1 + System.lineSeparator());
				savedF.write(conf[4] + System.lineSeparator());
				savedF.write(conf[5] + System.lineSeparator());
				savedF.write(conf[6] + System.lineSeparator());
				savedF.write(conf[7] + System.lineSeparator());// lan
				savedF.close();
			} catch (Exception e2) {
			}
		});
		reso.add(resoD);
		reso.add(sep);
		reso.add(reso4);
		reso.add(reso3);
		reso.add(reso2);
		reso.add(reso1);
		// help
		JMenu help = new JMenu("AYUDA");
		JMenu hideMenu = new JMenu("ESCONDER");
		JMenuItem keyShortcut = new JMenuItem(idiomaString(language)[1]);
		JMenuItem creator = new JMenuItem("SOBRE EL CREADOR");
		JMenuItem about = new JMenuItem("SOBRE EL APLICATIVO");
		noHide.addActionListener(e -> {
			conf[1] = "0";
			noHide.setEnabled(false);
			hideDate.setEnabled(true);
			hideBtn.setEnabled(true);
			hideAll.setEnabled(true);
			try {
				FileWriter savedF = new FileWriter("conf.txt");
				savedF.write(conf[0] + System.lineSeparator());
				savedF.write(0 + System.lineSeparator());
				savedF.write(conf[2] + System.lineSeparator());
				savedF.write(conf[3] + System.lineSeparator());
				savedF.write(conf[4] + System.lineSeparator());
				savedF.write(conf[5] + System.lineSeparator());
				savedF.write(conf[6] + System.lineSeparator());
				savedF.write(conf[7] + System.lineSeparator());// lan
				savedF.close();
			} catch (Exception e2) {
			}
			realesF.show();
			clearEverthing.show();
			faturaBtn.show();
			hideBtn.setText("ESCONDER LOS BOTONES");
			if (conf[0] == null && conf[0].equals("3"))
				newDay.show();
			date.show();
		});
		hideDate.addActionListener(e -> {
			conf[1] = "1";
			noHide.setEnabled(true);
			hideDate.setEnabled(false);
			hideBtn.setEnabled(true);
			hideAll.setEnabled(true);
			try {
				FileWriter savedF = new FileWriter("conf.txt");
				savedF.write(conf[0] + System.lineSeparator());
				savedF.write(1 + System.lineSeparator());
				savedF.write(conf[2] + System.lineSeparator());
				savedF.write(conf[3] + System.lineSeparator());
				savedF.write(conf[4] + System.lineSeparator());
				savedF.write(conf[5] + System.lineSeparator());
				savedF.write(conf[6] + System.lineSeparator());
				savedF.write(conf[7] + System.lineSeparator());// lan
				savedF.close();
			} catch (Exception e2) {
			}
			date.hide();
			realesF.show();
			clearEverthing.show();
			faturaBtn.show();
			hideBtn.setText("ESCONDER LOS BOTONES");
			if (conf[0] == null && conf[0].equals("3"))
				newDay.show();
		});
		hideBtn.addActionListener(e -> {
			conf[1] = "2";
			noHide.setEnabled(true);
			hideDate.setEnabled(true);
			hideBtn.setEnabled(false);
			hideAll.setEnabled(true);
			try {
				FileWriter savedF = new FileWriter("conf.txt");
				savedF.write(conf[0] + System.lineSeparator());
				savedF.write(2 + System.lineSeparator());
				savedF.write(conf[2] + System.lineSeparator());
				savedF.write(conf[3] + System.lineSeparator());
				savedF.write(conf[4] + System.lineSeparator());
				savedF.write(conf[5] + System.lineSeparator());
				savedF.write(conf[6] + System.lineSeparator());
				savedF.write(conf[7] + System.lineSeparator());// lan
				savedF.close();
			} catch (Exception e2) {
			}
			hideBtn(faturaBtn, realesF, newDay, clearEverthing, hideBtn);
			date.show();
		});
		hideAll.addActionListener(e -> {
			conf[1] = "3";
			noHide.setEnabled(true);
			hideDate.setEnabled(true);
			hideBtn.setEnabled(true);
			hideAll.setEnabled(false);
			try {
				FileWriter savedF = new FileWriter("conf.txt");
				savedF.write(conf[0] + System.lineSeparator());
				savedF.write(3 + System.lineSeparator());
				savedF.write(conf[2] + System.lineSeparator());
				savedF.write(conf[3] + System.lineSeparator());
				savedF.write(conf[4] + System.lineSeparator());
				savedF.write(conf[5] + System.lineSeparator());
				savedF.write(conf[6] + System.lineSeparator());
				savedF.write(conf[7] + System.lineSeparator());// lan
				savedF.close();
			} catch (Exception e2) {
			}
			hideBtn(faturaBtn, realesF, newDay, clearEverthing, hideBtn);
			date.hide();
		});

		if (conf[2] == null || conf[2].equals("false"))
			keyShortcut.addActionListener(
					e -> JOptionPane.showMessageDialog(null, idiomaString(language)[0], idiomaString(language)[1], 1));
		else
			keyShortcut.hide();
		creator.addActionListener(e -> JOptionPane.showMessageDialog(null, idiomaString(language)[2], "SOBRE MI", 1));
		about.addActionListener(
				e -> JOptionPane.showMessageDialog(null, idiomaString(language)[3], "CEDROS/NARJES", 1));

		hideBtn.addActionListener(e -> hideBtn(faturaBtn, realesF, newDay, clearEverthing, hideBtn));
		hideMenu.add(noHide);
		hideMenu.add(hideDate);
		hideMenu.add(hideBtn);
		hideMenu.add(hideAll);
		help.add(hideMenu);
		help.add(keyShortcut);
		help.add(creator);
		help.add(about);
		mb.add(file);
		mb.add(summary);
		mb.add(goTo);
		mb.add(reso);
		mb.add(help);
		this.setJMenuBar(mb);

		// Go to write new numbers
		openProgress();
		int k = 0, l = 0;
		schiffe_loop: while (k < 5) {
			l = 0;
			while (l < 15) {
				if (details[k][l].getText().isBlank()) {
					break schiffe_loop;
				}
				l++;
			}
			k++;
		}
		if (k == 5 && l == 15)
			k = l = 0;
		InitialFocusSetter.setInitialFocus(this, details[k][l]);

		// Frame Run
		sumF();
		this.getRootPane().setDefaultButton(newDay);
		this.setVisible(true);

		// Resolution
		if (conf[3] == null || conf[3].equals("0")) {
			resFun(clearEverthing, faturaBtn, realesF, newDay, resoD, aggPanel, gastosPanel);
		} else if (conf[3].equals("1"))
			resXP(resoD, realesF, faturaBtn, newDay, clearEverthing, gastosPanel, aggPanel);
		else if (conf[3].equals("2"))
			resP(resoD, realesF, faturaBtn, newDay, clearEverthing, gastosPanel, aggPanel);
		else if (conf[3].equals("3"))
			resM(resoD, realesF, faturaBtn, newDay, clearEverthing, gastosPanel, aggPanel);
		else
			resG(resoD, realesF, faturaBtn, newDay, clearEverthing, gastosPanel, aggPanel);

		// LANGUAGE
		idiomaTexts(language, hideBtn, noHide, hideDate, hideAll, faturaBtn, newDay, resoD, aggPanel, gastosPanel, file,
				novo, clear, calc, save, option, exit, summary, sumV, effectChooser, sumV1, sumV2, sumV3, exMenu,
				speedChooser, speed1, speed2, speed3, goTo, fatura, firstFrame, reso, reso1, reso2, reso3, reso4, help,
				hideMenu, keyShortcut, creator, about);

		// Close Popup
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				Object[] options = { idiomaString(language)[11], idiomaString(language)[12],
						idiomaString(language)[15] };
				int selectedOption = JOptionPane.showOptionDialog(null, idiomaString(language)[13],
						idiomaString(language)[14], JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
						options, options[0]);
				if (selectedOption == 0)
					System.exit(0);
				else if (selectedOption == 1) {
					// Do Nothing
				} else if (selectedOption == 2) {
					exBtn();
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
					if (!conf[0].equals("3")) {
						for (int i = 0; i < 2; i++)
							panelCnum[i].setText("");
						panelCnum[2].setText("" + nbOf500);
					}
					sumF();
					System.exit(0);
				}
			}
		});

	}

	private void screenShooter() {
		BufferedImage img = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
		this.paint(img.getGraphics());
		String currentpath = System.getProperty("user.dir");
		File tempFile1 = new File(currentpath + "\\" + yearS);
		tempFile1.mkdir();
		File tempFile2 = new File(tempFile1 + "\\" + monthS);
		tempFile2.mkdir();
		File newFile = new File(tempFile2, "p " + dayN + "-" + monthS + "-" + yearS + ".png");
		try {
			ImageIO.write(img, "png", newFile);
		} catch (IOException e1) {
		}
	}

	
	private void resFun(JButton clearEverthing, JButton faturaBtn, JButton realesF, JButton newDay, JMenuItem resoD,
			JButton aggPanel, JButton gastosPanel) {
		if (width > 1800 && height > 1000)
			resG(resoD, realesF, faturaBtn, newDay, clearEverthing, gastosPanel, aggPanel);
		else if (width > 1500 && height > 700)
			resM(resoD, realesF, faturaBtn, newDay, clearEverthing, gastosPanel, aggPanel);
		else if (width > 1300 && height > 700)
			resP(resoD, realesF, faturaBtn, newDay, clearEverthing, gastosPanel, aggPanel);
		else
			resXP(resoD, realesF, faturaBtn, newDay, clearEverthing, gastosPanel, aggPanel);
	}

	private String titleName() {
		if (conf[0] == null || !conf[0].equals("3"))
			return "CEDROS";
		else
			return "NARJES";
	}

	private void summaryFrame() {
		JFrame sum = new JFrame();
		if (language == 0)
			sum.setTitle("SUMARIO");
		else
			sum.setTitle("SUMÁRIO");
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
		expBtn.addActionListener(e -> exBtn());
		sum.add(expBtn);
		// LABEL
		JTextPane sumItem = new JTextPane();
		StyledDocument doc = sumItem.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		sumItem.setBounds(0, 200, 650, 550);
		sumItem.setFont(First.myFont);
		sumItem.setEditable(false);
		sumItem.setOpaque(false);
		sumItem.setForeground(new Color(0, 0, 0, 255));
		// Timer
		order = 0;
		wordsN = 0;
		wordL = 0;
		colorX = 0;
		status = true;
		String[] espSumm = { "USTED NO VENDIÓ NADA", // 0
				"USTED VENDIÓ UNA VENTA SOLO QUE VALE $" + totalVenta, // 1
				"USTED VENDIÓ $" + totalVenta + "\n\nDIVIDIENDO EN " + nbVentas() + " VENTAS\n\n"
						+ "CON UN PROMEDIO DE $" + (nbVentas() == 0 ? 0 : totalVenta / nbVentas()) + " POR VENTA", // 2
				"NO TIENES GASTOS!", // 3
				"TIENES EN TOTAL UN GASTO QUE VALE $" + gastosT + "\n\n" + "DETALLADO COMO:\n" + gastosDetalles(), // 4
				"TIENES EN TOTAL $" + gastosT + " COMO GASTOS\n\n" + "DIVIDIDO POR " + nbGastos() + " COSAS\n\n"
						+ "CON UN PROMEDIO DE $" + (nbGastos() == 0 ? 0 : gastosT / nbGastos()) + "\n\n"
						+ "DETALLADO COMO:\n" + gastosDetalles(), // 5
				"NO TIENES AGREGADOS!", // 6
				"TIENES EN TOTAL UN AGREGADO QUE VALE $" + agregadoT + "\n\n" + "DETALLADO COMO:\n"
						+ agregadoDetalles(), // 7
				"TIENES EN TOTAL $" + agregadoT + " COMO AGREGADOS\n\n" + "DIVIDIDO POR " + nbAgregados() + " COSAS\n\n"
						+ "CON UN PROMEDIO DE $" + (nbAgregados() == 0 ? 0 : agregadoT / nbAgregados()) + "\n\n"
						+ "DETALLADO COMO:\n" + agregadoDetalles(), // 8
				"PARA RESUMIR\n\n" + "EMPEZAMOS EL DÍA CON $" + initialDay.getText() + "\n\nY VENDIMOS $" + totalVenta
						+ "\n\nY GASTO $" + gastosT + "\n\nQUE TERMINARÁ CON $" + totalO + " EN TOTAL", // 10
				"PARA RESUMIR\n\n" + "EMPEZAMOS EL DÍA CON $" + initialDay.getText() + "\n\nY VENDIMOS $" + totalVenta
						+ "\n\nY GASTO $" + gastosT + "\n\nY AGREGÓ $" + agregadoT + "\n\nQUE TERMINARÁ CON $" + totalO
						+ " EN TOTAL", // 12
				"LA CAJA DIO BIEN\n\n" + "NO HAY DIFERENCIA\n\n" + ":)", // 13
				"LA CAJA NO DIO BIEN\n\n" + "PARECE QUE " + diffResult[1].getText().toUpperCase()
						+ "\n\nREVISA LOS BOLETOS Y LA CAJA", // 14
				"QUEDARÁ PARA MAÑANA APROXIMADAMENTE\n\n$" + restN, // 15
				"TOQUE EL BOTÓN PARA EXPORTAR EL RESULTADO"// 16
		};
		String[] porSumm = { "VOCÊ NÃO VENDEU NADA", // 0
				"VOCÊ VENDEU UMA VENDA SÓ QUE VALE $" + totalVenta, // 1
				"VOCÊ VENDEU $" + totalVenta + "\n\nDIVIDINDO EM " + nbVentas() + " VENDAS\n\n" + "COM MÉDIA DE $"
						+ (nbVentas() == 0 ? 0 : totalVenta / nbVentas()) + " À VENDA", // 2
				"VOCÊ NÃO TEM GASTOS!", // 3
				"VOCÊ TEM NO TOTAL UM GASTO NO VALOR DE $" + gastosT + "\n\n" + "DETALHADO COMO:\n" + gastosDetalles(), // 4
				"VOCÊ TEM NO TOTAL $" + gastosT + " COMO GASTOS\n\n" + "DIVIDIDO POR " + nbGastos() + " COISAS\n\n"
						+ "COM MÉDIA DE $" + (nbGastos() == 0 ? 0 : gastosT / nbGastos()) + "\n\n" + "DETALHADO COMO:\n"
						+ gastosDetalles(), // 5
				"VOCÊ NÃO TEM AGREGADOS!", // 6
				"VOCÊ TEM NO TOTAL UM AGREGADO NO VALOR DE $" + agregadoT + "\n\n" + "DETALHADO COMO:\n"
						+ agregadoDetalles(), // 7
				"VOCÊ TEM NO TOTAL $" + agregadoT + " COMO AGREGADOS\n\n" + "DIVIDIDO POR " + nbAgregados()
						+ " COISAS\n\n" + "COM MÉDIA DE $" + (nbAgregados() == 0 ? 0 : agregadoT / nbAgregados())
						+ "\n\n" + "DETALHADO COMO:\n" + agregadoDetalles(), // 8
				"PARA RESUMIR\n\n" + "COMEÇAMOS O DIA COM $" + initialDay.getText() + "\n\nE VENDEMOS $" + totalVenta
						+ "\n\nE GASTO $" + gastosT + "\n\nQUE VAI ACABAR EM $" + totalO + " EM TOTAL", // 9
				"PARA RESUMIR\n\n" + "COMEÇAMOS O DIA COM $" + initialDay.getText() + "\n\nY VENDEMOS $" + totalVenta
						+ "\n\nE GASTO $" + gastosT + "\n\nE ADICIONO $" + agregadoT + "\n\nQUE VAI ACABAR EM $"
						+ totalO + " EM TOTAL", // 10
				"A CAIXA DEU BEM\n\n" + "NÃO HÁ DIFERENÇA\n\n" + ":)", // 11
				"A CAIXA NÃO DEU BEM\n\n" + "PARECE QUE " + diffResult[1].getText().toUpperCase()
						+ "\n\nCONFIRA OS INGRESSOS E A CAIXA", // 12
				"FICARÁ PARA AMANHÃ APROXIMADAMENTE\n\n$" + restN, // 13
				"TOQUE NO BOTÃO PARA EXPORTAR O RESULTADO"// 14
		};

		ActionListener fadeTimer = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sumItem.setForeground(new Color(0, 0, 0, colorX));
				switch (order) {
				case 0: {// details start
					if (totalVenta == 0) {
						sumItem.setText(language == 0 ? espSumm[0] : porSumm[0]);
						sumItem.setBounds(0, 240, 650, 550);
					} else {
						if (nbVentas() == 1) {
							sumItem.setText(language == 0 ? espSumm[1] : porSumm[1]);
							sumItem.setBounds(0, 240, 650, 550);
						} else {
							sumItem.setText(language == 0 ? espSumm[2] : porSumm[2]);
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
						sumItem.setText(language == 0 ? espSumm[3] : porSumm[3]);
					} else {
						if (nbGastos() == 1) {
							sumItem.setText(language == 0 ? espSumm[4] : porSumm[4]);
							sumItem.setBounds(0, 220, 650, 550);
						} else {
							sumItem.setText(language == 0 ? espSumm[5] : porSumm[5]);
							sumItem.setBounds(0, 140, 650, 550);
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
						sumItem.setText(language == 0 ? espSumm[6] : porSumm[6]);
						sumItem.setBounds(0, 240, 650, 550);
					} else {
						if (nbAgregados() == 1) {
							sumItem.setText(language == 0 ? espSumm[7] : porSumm[7]);
							sumItem.setBounds(0, 220, 650, 550);
						} else {
							sumItem.setText(language == 0 ? espSumm[8] : porSumm[8]);
							sumItem.setBounds(0, 140, 650, 550);
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
						sumItem.setText(language == 0 ? espSumm[9] : porSumm[9]);
					else
						sumItem.setText(language == 0 ? espSumm[10] : porSumm[10]);
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
						sumItem.setText(language == 0 ? espSumm[11] : porSumm[11]);
					else
						sumItem.setText(language == 0 ? espSumm[12] : porSumm[12]);
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
					if (language == 0)
						sumItem.setText(language == 0 ? espSumm[13] : porSumm[13]);
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
					if (language == 0)
						sumItem.setText(language == 0 ? espSumm[14] : porSumm[14]);
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
						String[] wordT = (language == 0 ? espSumm[0].split(" ") : porSumm[0].split(" "));
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
						String[] wordT = language == 0 ? espSumm[1].split(" ") : porSumm[1].split(" ");
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
						String[] wordT = language == 0 ? espSumm[2].split(" ") : porSumm[2].split(" ");
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
						String[] wordT = language == 0 ? espSumm[3].split(" ") : porSumm[3].split(" ");
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
						String[] wordT = language == 0 ? espSumm[4].split(" ") : porSumm[4].split(" ");
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
					} else {
						String[] wordT = language == 0 ? espSumm[5].split(" ") : porSumm[5].split(" ");
						sumItem.setBounds(0, 140, 650, 550);
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
						String[] wordT = language == 0 ? espSumm[6].split(" ") : porSumm[6].split(" ");
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
						String[] wordT = language == 0 ? espSumm[7].split(" ") : porSumm[7].split(" ");
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
						String[] wordT = language == 0 ? espSumm[8].split(" ") : porSumm[8].split(" ");
						sumItem.setBounds(0, 140, 650, 550);
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
						String[] wordT = language == 0 ? espSumm[9].split(" ") : porSumm[9].split(" ");
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
						sumItem.setBounds(0, 100, 650, 550);
						String[] wordT = language == 0 ? espSumm[10].split(" ") : porSumm[10].split(" ");
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
						String[] wordT = language == 0 ? espSumm[11].split(" ") : porSumm[11].split(" ");
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
						String[] wordT = language == 0 ? espSumm[12].split(" ") : porSumm[12].split(" ");
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
					String[] wordT = language == 0 ? espSumm[13].split(" ") : porSumm[13].split(" ");
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
					String[] wordT = language == 0 ? espSumm[14].split(" ") : porSumm[14].split(" ");
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
						char[] wordT = language == 0 ? espSumm[0].toCharArray() : porSumm[0].toCharArray();
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
						char[] wordT = language == 0 ? espSumm[1].toCharArray() : porSumm[1].toCharArray();
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
						char[] wordT = language == 0 ? espSumm[2].toCharArray() : porSumm[2].toCharArray();
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
						char[] wordT = language == 0 ? espSumm[3].toCharArray() : porSumm[3].toCharArray();
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
						char[] wordT = language == 0 ? espSumm[4].toCharArray() : porSumm[4].toCharArray();
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
						char[] wordT = language == 0 ? espSumm[5].toCharArray() : porSumm[5].toCharArray();
						sumItem.setBounds(0, 140, 650, 550);
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
						char[] wordT = language == 0 ? espSumm[6].toCharArray() : porSumm[6].toCharArray();
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
						char[] wordT = language == 0 ? espSumm[7].toCharArray() : porSumm[7].toCharArray();
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
						char[] wordT = language == 0 ? espSumm[8].toCharArray() : porSumm[8].toCharArray();
						sumItem.setBounds(0, 140, 650, 550);
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
						sumItem.setBounds(0, 120, 650, 550);
						char[] wordT = language == 0 ? espSumm[9].toCharArray() : porSumm[9].toCharArray();
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
						sumItem.setBounds(0, 100, 650, 550);
						char[] wordT = language == 0 ? espSumm[10].toCharArray() : porSumm[10].toCharArray();
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
						char[] wordT = language == 0 ? espSumm[11].toCharArray() : porSumm[11].toCharArray();
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
						char[] wordT = language == 0 ? espSumm[12].toCharArray() : porSumm[12].toCharArray();
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
					char[] wordT = language == 0 ? espSumm[13].toCharArray() : porSumm[13].toCharArray();
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
					char[] wordT = language == 0 ? espSumm[14].toCharArray() : porSumm[14].toCharArray();
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
					timer.stop();
					Runtime.getRuntime().exec("taskkill /f /im java.exe");

				} catch (IOException e4) {
				}
			}
		});

		sum.add(sumItem);
		sum.setIconImage(notasI.getImage());
		sum.setVisible(true);
	}

	private void exBtn() {
		try {
			String currentpath = System.getProperty("user.dir");
			File tempFile1 = new File(currentpath + "\\" + yearS);
			File tempFile2 = new File(tempFile1 + "\\" + monthS);
			File newFile = new File(tempFile2, titleName() + " " + dayS + " " + dayN + "-" + "pesos.txt");
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
							+ " EN TOTAL" + System.lineSeparator(), // 9
					System.lineSeparator() + "*PARA RESUMIR:\n" + "EMPEZAMOS EL DÍA CON R$" + initialDay.getText()
							+ "\nVENDIMOS R$" + totalVenta + "\nGASTO R$" + gastosT + "\nAGREGÓ R$" + agregadoT
							+ "\nQUE TERMINARÁ CON R$" + totalO + " EN TOTAL" + System.lineSeparator(), // 10
					System.lineSeparator() + "*LA CAJA DIO BIEN, NO HAY DIFERENCIA" + System.lineSeparator(), // 11
					System.lineSeparator() + "*LA CAJA NO DIO BIEN, PARECE QUE " + diffResult[1].getText().toUpperCase()
							+ System.lineSeparator(), // 12
					System.lineSeparator() + "*QUEDARÁ PARA MAÑANA APROXIMADAMENTE R$" + restN + System.lineSeparator(), // 13
					System.lineSeparator() + "*GRACIAS Y HASTA MAÑANA :) "// 14
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
							+ "\nQUE VAI ACABAR EM R$" + totalO + " EM TOTAL" + System.lineSeparator(), // 10
					System.lineSeparator() + "*A CAIXA DEU BEM, " + "NÃO HÁ DIFERENÇA" + System.lineSeparator(), // 11
					System.lineSeparator() + "*A CAIXA NÃO DEU BEM, " + "PARECE QUE "
							+ diffResult[1].getText().toUpperCase() + System.lineSeparator(), // 12
					System.lineSeparator() + "*FICARÁ PARA AMANHÃ APROXIMADAMENTE R$" + restN + System.lineSeparator(), // 13
					System.lineSeparator() + "*OBRIGADO E ATÉ AMANHÃ :)"// 14
			};
			savedF.write(titleName() + (language == 0 ? " - SUMARIO POR EL DIA " : " - SUMÁRIO DO DIA ") + dayS + " "
					+ dayN + "-" + monthS + "-" + yearS + System.lineSeparator() + System.lineSeparator());
			if (totalVenta == 0)
				savedF.write(language == 0 ? espSumm[0] : porSumm[0]);
			else if (nbVentas() == 1)
				savedF.write(language == 0 ? espSumm[1] : porSumm[1]);
			else
				savedF.write(language == 0 ? espSumm[2] : porSumm[2]);
			if (gastosT == 0)// GASTOS SAVE
				savedF.write(language == 0 ? espSumm[3] : porSumm[3]);
			else if (nbGastos() == 1)
				savedF.write(language == 0 ? espSumm[4] : porSumm[4]);
			else
				savedF.write(language == 0 ? espSumm[5] : porSumm[5]);
			if (nbAgregados() != 0) { // AGG SAVE if 1
				if (nbAgregados() == 1)
					savedF.write(language == 0 ? espSumm[6] : porSumm[6]);
				else
					savedF.write(language == 0 ? espSumm[7] : porSumm[7]);
				savedF.write(language == 0 ? espSumm[9] : porSumm[9]);
			} else
				savedF.write(language == 0 ? espSumm[10] : porSumm[10]);
			if (totalO == totalCaja)
				savedF.write(language == 0 ? espSumm[11] : porSumm[11]);
			else
				savedF.write(language == 0 ? espSumm[12] : porSumm[12]);
			savedF.write(language == 0 ? espSumm[13] : porSumm[13]);
			savedF.close();

			JOptionPane opt = new JOptionPane(
					language == 0 ? "SALVADO CON ÉXITO, GRACIAS" : "SALVO COM SUCESSO, OBRIGADO",
					JOptionPane.INFORMATION_MESSAGE);
			final JDialog dlg = opt.createDialog("success");
			new Thread(new Runnable() {
				public void run() {
					try {
						Thread.sleep(2000);
						dlg.dispose();

					} catch (Throwable th) {
					}
				}
			}).start();
			dlg.setVisible(true);

		} catch (Exception e2) {
			System.out.println("ERROR " + e2);
		}

		 screenShooter();
	}

	private String agregadoDetalles() {
		String aggString = "";
		int num = 1;
		for (int i = 8; i < 16; i++)
			if (First.isNumeric(agregadoTable[i].getText())) {
				aggString += num + "- "
						+ (agregadoTable[i - 8].getText().isBlank() ? "XXX" : agregadoTable[i - 8].getText()) + " -> "
						+ "$" + agregadoTable[i].getText() + "\n";
				num++;
			}
		return aggString;
	}

	private int nbAgregados() {
		int agregado = 0;
		for (int i = 8; i < 16; i++)
			if (First.isNumeric(agregadoTable[i].getText()))
				agregado++;
		return agregado;
	}

	private String gastosDetalles() {
		String gasString = "";
		int num = 1;
		for (int i = 8; i < 16; i++)
			if (First.isNumeric(gastosTable[i].getText())) {
				gasString += num + "- "
						+ (gastosTable[i - 8].getText().isBlank() ? "XXX" : gastosTable[i - 8].getText()) + " -> " + "$"
						+ gastosTable[i].getText() + "\n";
				num++;
			}
		return gasString;
	}

	private int nbGastos() {
		int gastos = 0;
		for (int i = 8; i < 16; i++)
			if (First.isNumeric(gastosTable[i].getText()))
				gastos++;
		return gastos;
	}

	private int nbVentas() {
		int ventas = 0;
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 20; j++)
				if (First.isNumeric(details[i][j].getText()))
					ventas++;
		return ventas;
	}

	private void gastosFrame(ArrayList<String> keywords, JButton notasF, JButton pesosF, JButton newDay,
			JButton clearEverthing, JMenuItem resoD, JButton gastosPanel) {
		JFrame gastosFrame = new JFrame();
		gastosFrame.setTitle("GASTOS");
		gastosFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		gastosFrame.setAlwaysOnTop(false);
		gastosFrame.setSize(300, 403);
		gastosFrame.setLocationRelativeTo(null);
		gastosFrame.setResizable(false);
		gastosFrame.setLayout(null);
		gastosFrame.getContentPane().setBackground(First.redC);

		for (int i = 0; i < 8; i++) {
			// Autocomplete
			AutoComplete autoComplete = new AutoComplete(gTable[i], keywords);
			gTable[i].getDocument().addDocumentListener(autoComplete);
			gTable[i].setBounds(2, 2 + 45 * i, 140, 45);
			textFieldStyle(gTable[i]);
			gTable[i].removeFocusListener(textFocus);
			gTable[i].setBackground(First.redD);
			gTable[i].setForeground(Color.white);
			gastosFrame.add(gTable[i]);
		}
		for (int i = 8; i < 16; i++) {
			gTable[i].setBounds(142, 2 + 45 * (i - 8), 140, 45);
			textFieldStyle(gTable[i]);
			gTable[i].removeFocusListener(textFocus);
			gTable[i].setBackground(First.redC);
			gTable[i].setForeground(Color.white);
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

	private void aggFrame(ArrayList<String> keywords, JButton notasF, JButton pesosF, JButton newDay,
			JButton clearEverthing, JMenuItem resoD, JButton gastosPanel) {
		JFrame aggFrame = new JFrame();
		aggFrame.setTitle("AGREGADOS");
		aggFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		aggFrame.setAlwaysOnTop(false);
		aggFrame.setSize(300, 403);
		aggFrame.setLocationRelativeTo(null);
		aggFrame.setResizable(false);
		aggFrame.setLayout(null);
		aggFrame.getContentPane().setBackground(First.greenC);

		for (int i = 0; i < 8; i++) {
			// Autocomplete
			AutoComplete autoComplete = new AutoComplete(aTable[i], keywords);
			aTable[i].getDocument().addDocumentListener(autoComplete);
			textFieldStyle(aTable[i]);
			aTable[i].removeFocusListener(textFocus);
			aTable[i].setBounds(2, 2 + 45 * i, 140, 45);
			aTable[i].setBackground(First.greenD);
			aTable[i].setForeground(Color.white);
			aggFrame.add(aTable[i]);
		}
		for (int i = 8; i < 16; i++) {
			textFieldStyle(aTable[i]);
			aTable[i].removeFocusListener(textFocus);
			aTable[i].setBounds(142, 2 + 45 * (i - 8), 140, 45);
			aTable[i].setBackground(First.greenC);
			aTable[i].setForeground(Color.white);
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
				Pesos.this.setIconImage(iconImages[op1C.getSelectedIndex()].getImage());
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
		op3.setBounds(50, 160, 250, 40);
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
					btnsHideShow3.setText("NO");
				else
					btnsHideShow3.setText("SI");
			}
		});

		// bottom line
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
				Pesos.this.setIconImage(iconImages[0].getImage());// icon
				conf[1] = "0";// btn hide
				btnsHideShow2.setText(idiomaString(language)[11]);// key shortcut
				btnsHideShow2.setSelected(false);// key shortcut
				conf[3] = "0";// res
				resFun(clearEverthing, pesosF, notasF, newDay, resoD, aggPanel, gastosPanel);// res
				btnsHideShow3.setText(idiomaString(language)[11]);// autosave
				btnsHideShow3.setSelected(false);// autosave
				conf[6] = "1";// speed
				lang.setSelectedIndex(0);// lan
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
					FileWriter savedF = new FileWriter("conf.txt");
					savedF.write(op1C.getSelectedIndex() + System.lineSeparator());// icon
					savedF.write(conf[1] + System.lineSeparator());// btn hide
					savedF.write(btnsHideShow2.isSelected() + System.lineSeparator());// key shortcut
					savedF.write(conf[3] + System.lineSeparator());// res
					savedF.write(btnsHideShow3.isSelected() + System.lineSeparator());// autosave
					savedF.write(conf[5] + System.lineSeparator());// first frame to open
					savedF.write(conf[6] + System.lineSeparator());// speed
					savedF.write(lang.getSelectedIndex() + System.lineSeparator());// lan
					savedF.close();
				} catch (Exception e2) {
				}
				temp.dispose();
				Pesos.this.dispose();
				new Pesos();
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
		temp.add(lang);
		temp.add(op3);
		temp.add(btnsHideShow2);
		temp.add(op5);
		temp.add(btnsHideShow3);
		temp.add(defSet);
		temp.add(save);
		temp.setVisible(true);
	}

	// Clear all funcion
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
			exBtn();
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
			if (conf[0] == null || !conf[0].equals("3")) {
				for (int i = 0; i < 2; i++)
					panelCnum[i].setText("");
				panelCnum[2].setText("" + nbOf500);
			}
			sumF();
		}
	}

	// Hide Btns
	private void hideBtn(JButton notasF, JButton pesosF, JButton newDay, JButton clearEverthing, JMenuItem hideBtn) {
		pesosF.hide();
		clearEverthing.hide();
		notasF.hide();
		if (conf[0] == null && conf[0].equals("3"))
			newDay.hide();
	}

	// saveProgress
	private static void saveProgress() {
		try {
			FileWriter savedF = new FileWriter("cedrosP.txt");
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
		try {
			dataOpened = new BufferedReader(new FileReader(new File("cedrosP.txt")));
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
		total[6].setText("$" + totalVenta);
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
		totalCaja = ((panelCnum[0].getText().equals("") ? 0 : Integer.valueOf(panelCnum[0].getText()) * 2000)
				+ (panelCnum[1].getText().equals("") ? 0 : Integer.valueOf(panelCnum[1].getText()) * 1000)
				+ (panelCnum[2].getText().equals("") ? 0 : Integer.valueOf(panelCnum[2].getText()) * 500)
				+ (panelCnum[3].getText().equals("") ? 0 : Integer.valueOf(panelCnum[3].getText()) * 200)
				+ (panelCnum[4].getText().equals("") ? 0 : Integer.valueOf(panelCnum[4].getText()) * 100)
				+ (panelCnum[5].getText().equals("") ? 0 : Integer.valueOf(panelCnum[5].getText()) * 50)
				+ (panelCnum[6].getText().equals("") ? 0 : Integer.valueOf(panelCnum[6].getText()) * 20)
				+ (panelCnum[7].getText().equals("") ? 0 : Integer.valueOf(panelCnum[7].getText()) * 10)
				+ (panelCnum[8].getText().equals("") ? 0 : Integer.valueOf(panelCnum[8].getText()) * 5)
				+ (panelCnum[9].getText().equals("") ? 0 : Integer.valueOf(panelCnum[9].getText()) * 2)
				+ (panelCnum[10].getText().equals("") ? 0 : Integer.valueOf(panelCnum[10].getText()) * 1));
		total[7].setText("$" + totalCaja);
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
		if (conf[0] == null || !conf[0].equals("3")) {
			restN = totalCaja - Integer.valueOf(panelCnum[0].getText()) * 2000
					- Integer.valueOf(panelCnum[1].getText()) * 1000;
			nbOf500 = Integer.valueOf(panelCnum[2].getText());
			while (restN > 1000 && nbOf500 > 0) {
				restN -= 500;
				nbOf500--;
			}
		} else
			restN = totalCaja;
		restTmrw.setText("$" + restN);
		restTmrw.setForeground(Color.black);
		restTmrw.setBackground(First.lightC);
	}

	// Key listener for the table
	private void tableFocus(int i, int j, JFrame frame, JButton newDay, JButton notasF, JButton pesosF,
			JButton clearEverthing, JMenuItem hideBtn, JMenuItem resoD, JButton gastosPanel, JButton aggPanel) {
		details[i][j].addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// Hide
				if ((e.getKeyCode() == KeyEvent.VK_O) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0))
					hideBtn(notasF, pesosF, newDay, clearEverthing, hideBtn);
				// GO TO Notas
				else if ((e.getKeyCode() == KeyEvent.VK_S) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					saveProgress();
					FaturaP.totalC.setText("0");
					FaturaP.total.setText("0");
					frame.dispose();
					new FaturaP();
				} // GO TO Reales
				else if ((e.getKeyCode() == KeyEvent.VK_R) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					saveProgress();
					frame.dispose();
					new Reales();
				} else// Clear
				if ((e.getKeyCode() == KeyEvent.VK_B) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					clearAll();
				} // Conf
				else if ((e.getKeyCode() == KeyEvent.VK_C) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					confFrame(conf, notasF, pesosF, newDay, clearEverthing, hideBtn, resoD, gastosPanel, aggPanel);
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
					details[i][j].setNextFocusableComponent(panelCnum[0]);
					details[i][j].nextFocus();
				} else// |Go to the last one
				if ((e.getKeyCode() == KeyEvent.VK_E) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					int k = 0, l = 0;
					schiffe_loop: while (k < 5) {
						l = 0;
						while (l < 15) {
							if (details[k][l].getText().isBlank()) {
								break schiffe_loop;
							}
							l++;
						}
						k++;
					}
					if (k == 5 && l == 15)
						k = l = 0;
					details[i][j].setNextFocusableComponent(details[k][l]);
					details[i][j].nextFocus();
				}
			}
		});
	}

	// Key listener for the initial
	private void iniFocus(JButton newDay, JButton notasF, JButton pesosF, JButton clearEverthing, JMenuItem hideBtn,
			JMenuItem resoD, JButton gastosPanel, JButton aggPanel) {
		initialDay.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// Hide
				if ((e.getKeyCode() == KeyEvent.VK_O) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0))
					hideBtn(notasF, pesosF, newDay, clearEverthing, hideBtn);
				else // Clear
				if ((e.getKeyCode() == KeyEvent.VK_B) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					clearAll();
				} else// new day
				if ((e.getKeyCode() == KeyEvent.VK_N) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					newDay();
				} // Conf
				else if ((e.getKeyCode() == KeyEvent.VK_C) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					confFrame(conf, notasF, pesosF, newDay, clearEverthing, hideBtn, resoD, gastosPanel, aggPanel);
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
					initialDay.setNextFocusableComponent(panelCnum[0]);
					initialDay.nextFocus();
				}
			}
		});
	}

	// Key listener for the ADDITION
	private void aggFocus(int i, JFrame frame, JButton newDay, JButton notasF, JButton pesosF, JButton clearEverthing,
			JMenuItem hideBtn, JMenuItem resoD, JButton gastosPanel, JButton aggPanel) {
		agregadoTable[i].addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// Hide
				if ((e.getKeyCode() == KeyEvent.VK_O) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0))
					hideBtn(notasF, pesosF, newDay, clearEverthing, hideBtn);
				// GO TO Notas
				else if ((e.getKeyCode() == KeyEvent.VK_S) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					saveProgress();
					FaturaP.totalC.setText("0");
					FaturaP.total.setText("0");
					frame.dispose();
					new FaturaP();
				} else // GO TO REALES
				if ((e.getKeyCode() == KeyEvent.VK_R) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					saveProgress();
					frame.dispose();
					new Reales();
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
					agregadoTable[i].setNextFocusableComponent(panelCnum[0]);
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
				}
			}
		});
	}

	// Key listener for the SPENT
	private void gasFocus(int i, JFrame frame, JButton newDay, JButton notasF, JButton pesosF, JButton clearEverthing,
			JMenuItem hideBtn, JMenuItem resoD, JButton gastosPanel, JButton aggPanel) {
		gastosTable[i].addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// Hide
				if ((e.getKeyCode() == KeyEvent.VK_O) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0))
					hideBtn(notasF, pesosF, newDay, clearEverthing, hideBtn);
				// GO TO Notas
				else if ((e.getKeyCode() == KeyEvent.VK_S) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					saveProgress();
					FaturaP.totalC.setText("0");
					FaturaP.total.setText("0");
					frame.dispose();
					new FaturaP();
				} else // GO TO REALES
				if ((e.getKeyCode() == KeyEvent.VK_R) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					saveProgress();
					frame.dispose();
					new Reales();
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
					gastosTable[i].setNextFocusableComponent(panelCnum[0]);
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
				}
			}
		});
	}

	// Key listener for the CASH
	private void cajaFocus(int i, JFrame frame, JButton newDay, JButton notasF, JButton pesosF, JButton clearEverthing,
			JMenuItem hideBtn, JMenuItem resoD, JButton gastosPanel, JButton aggPanel) {
		panelCnum[i].addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// Hide
				if ((e.getKeyCode() == KeyEvent.VK_O) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0))
					hideBtn(notasF, pesosF, newDay, clearEverthing, hideBtn);
				// GO TO Notas
				else if ((e.getKeyCode() == KeyEvent.VK_S) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					saveProgress();
					FaturaP.totalC.setText("0");
					FaturaP.total.setText("0");
					frame.dispose();
					new FaturaP();
				} // GO TO Reales
				else if ((e.getKeyCode() == KeyEvent.VK_R) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					saveProgress();
					frame.dispose();
					new Reales();
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
				} else// GO Direction
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
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

	private void resXP(JMenuItem resoD, JButton pesosF, JButton notasF, JButton newDay, JButton clearEverthing,
			JButton gastosPanel, JButton aggPanel) {
		this.setSize(1000, 600);
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
		total[6].setBounds(390, 500, 70, 25);
		total[8].setBounds(390, 475, 70, 25);
		initialDay.setBounds(520, 50, 70, 30);
		total[6].setFont(First.myFont);
		initialDay.setFont(First.myFont);
		total[8].setFont(First.myFont);
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
		for (int i = 0; i < 11; i++) {
			switch (i) {
			case 0:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i2000.getImage(), 50, 40)));
				break;
			case 1:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i1000.getImage(), 50, 40)));
				break;
			case 2:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i500.getImage(), 50, 40)));
				break;
			case 3:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i200.getImage(), 50, 40)));
				break;
			case 4:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i100.getImage(), 50, 40)));
				break;
			case 5:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i50.getImage(), 50, 40)));
				break;
			case 6:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i20.getImage(), 50, 40)));
				break;
			case 7:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 40, 40)));
				break;
			case 8:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 40, 40)));
				break;
			case 9:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 40, 40)));
				break;
			case 10:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 40, 40)));
				break;
			default:
				break;
			}
			if (i < 7) {
				panelFoto[i].setBounds(430 + 50 * i, 250, 50, 40);
				panelCnum[i].setBounds(430 + 50 * i, 290, 50, 40);
			} else {
				panelFoto[i].setBounds(780 + 40 * (i - 7), 250, 40, 40);
				panelCnum[i].setBounds(780 + 40 * (i - 7), 290, 40, 40);
			}
			panelCnum[i].setFont(First.myFont);
		}
		if (conf[0] == null || conf[0].equals("3")) {
			newDay.setOpaque(false);
			newDay.setText("");
			newDay.setIcon(new ImageIcon(getScaledImage(nextDI.getImage(), 50, 50)));
			newDay.setContentAreaFilled(false);
			newDay.setBorderPainted(false);
			newDay.setBounds(790, 430, 50, 50);
		} else
			newDay.setBounds(750, 420, 150, 45);
		total[7].setBounds(430, 330, 510, 40);
		restTmrw.setBounds(750, 464, 150, 25);
		pesosF.setBounds(675, 430, 50, 50);
		diffResult[0].setBounds(500, 420, 150, 35);
		diffResult[1].setBounds(500, 454, 150, 35);
		notasF.setBounds(920, 430, 50, 50);
		clearEverthing.setBounds(405, 405, 50, 50);
		total[7].setFont(First.myFont);
		diffResult[0].setFont(First.myFont);
		diffResult[1].setFont(First.myFont);
		restTmrw.setFont(First.myFont);
		newDay.setFont(First.myFont);
		notasF.setIcon(new ImageIcon(getScaledImage(notasI.getImage(), 50, 50)));
		pesosF.setIcon(new ImageIcon(getScaledImage(realesI.getImage(), 50, 50)));
		clearEverthing.setIcon(new ImageIcon(getScaledImage(clear.getImage(), 50, 50)));
	}

	private void resP(JMenuItem resoD, JButton pesosF, JButton notasF, JButton newDay, JButton clearEverthing,
			JButton gastosPanel, JButton aggPanel) {
		this.setSize(1300, 700);
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
		initialDay.setBounds(670, 50, 80, 40);
		total[6].setFont(First.myFont);
		initialDay.setFont(First.myFont);
		total[8].setFont(First.myFont);
		date.setFont(First.myFont);
		date.setBounds(650, 10, 320, 30);
		for (int i = 0; i < 5; i++) {
			summaryT[i].setBounds(550, 50 + i * 40, 120, 40);
			summaryT[i].setFont(First.myFont);
		}
		for (int i = 5; i < 9; i++) {
			summaryT[i].setBounds(670, 50 + (i - 4) * 40, 80, 40);
			summaryT[i].setFont(First.myFont);
		}
		gastosPanel.setBounds(800, 250, 210, 30);
		gastosPanel.setFont(First.myFont);
		gastos.setBounds(800, 50, 210, 40);
		gastos.setFont(First.myFont);
		aggPanel.setBounds(1050, 250, 210, 30);
		aggPanel.setFont(First.myFont);
		agregado.setBounds(1050, 50, 210, 40);
		agregado.setFont(First.myFont);
		for (int i = 0; i < 4; i++) {
			gastosTable[i].setBounds(800, 90 + 40 * i, 150, 40);
			agregadoTable[i].setBounds(1050, 90 + 40 * i, 150, 40);
			gastosTable[i].setFont(First.myFont);
			agregadoTable[i].setFont(First.myFont);
		}
		for (int i = 8; i < 12; i++) {
			gastosTable[i].setBounds(950, 90 + 40 * (i - 8), 60, 40);
			gastosTable[i].setFont(First.myFontS);
			agregadoTable[i].setBounds(1200, 90 + 40 * (i - 8), 60, 40);
			agregadoTable[i].setFont(First.myFontS);
		}
		for (int i = 0; i < 11; i++) {
			if (i < 7) {
				panelFoto[i].setBounds(580 + 60 * i, 300, 60, 40);
				panelCnum[i].setBounds(580 + 60 * i, 340, 60, 40);
			} else {
				panelFoto[i].setBounds(1000 + 45 * (i - 7), 300, 45, 40);
				panelCnum[i].setBounds(1000 + 45 * (i - 7), 340, 45, 40);
			}
			panelCnum[i].setFont(First.myFont);
			switch (i) {
			case 0:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i2000.getImage(), 60, 40)));
				break;
			case 1:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i1000.getImage(), 60, 40)));
				break;
			case 2:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i500.getImage(), 60, 40)));
				break;
			case 3:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i200.getImage(), 60, 40)));
				break;
			case 4:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i100.getImage(), 60, 40)));
				break;
			case 5:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i50.getImage(), 60, 40)));
				break;
			case 6:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i20.getImage(), 60, 40)));
				break;
			case 7:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 45, 40)));
				break;
			case 8:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 45, 40)));
				break;
			case 9:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 45, 40)));
				break;
			case 10:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 45, 40)));
				break;
			default:
				break;
			}
		}
		if (conf[0] == null || conf[0].equals("3")) {
			newDay.setOpaque(false);
			newDay.setText("");
			newDay.setIcon(new ImageIcon(getScaledImage(nextDI.getImage(), 70, 70)));
			newDay.setContentAreaFilled(false);
			newDay.setBorderPainted(false);
			newDay.setBounds(1000, 490, 70, 70);
		} else {
			newDay.setBounds(950, 480, 210, 55);
		}
		total[7].setBounds(580, 380, 600, 40);
		restTmrw.setBounds(950, 534, 210, 35);
		pesosF.setBounds(855, 500, 60, 60);
		diffResult[0].setBounds(620, 480, 200, 40);
		diffResult[1].setBounds(620, 519, 200, 50);
		notasF.setBounds(1190, 500, 60, 60);
		clearEverthing.setBounds(490, 470, 60, 60);
		total[7].setFont(First.myFont);
		diffResult[0].setFont(First.myFont);
		diffResult[1].setFont(First.myFont);
		restTmrw.setFont(First.myFont);
		newDay.setFont(First.myFont);
		notasF.setIcon(new ImageIcon(getScaledImage(notasI.getImage(), 60, 60)));
		pesosF.setIcon(new ImageIcon(getScaledImage(realesI.getImage(), 60, 60)));
		clearEverthing.setIcon(new ImageIcon(getScaledImage(clear.getImage(), 60, 60)));
	}

	private void resM(JMenuItem resoD, JButton pesosF, JButton notasF, JButton newDay, JButton clearEverthing,
			JButton gastosPanel, JButton aggPanel) {
		this.setSize(1500, 800);
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
		total[6].setBounds(540, 678, 98, 35);
		total[8].setBounds(540, 648, 98, 30);
		initialDay.setBounds(710, 50, 90, 50);
		total[6].setFont(First.myFont);
		initialDay.setFont(First.myFont);
		total[8].setFont(First.myFont);
		date.setFont(First.myFont);
		date.setBounds(700, 10, 360, 30);
		for (int i = 0; i < 5; i++) {
			summaryT[i].setBounds(570, 50 + i * 50, 140, 50);
			summaryT[i].setFont(First.myFont);
		}
		for (int i = 5; i < 9; i++) {
			summaryT[i].setBounds(710, 50 + (i - 4) * 50, 90, 50);
			summaryT[i].setFont(First.myFont);
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
		for (int i = 0; i < 11; i++) {
			if (i < 7) {
				panelFoto[i].setBounds(640 + 70 * i, 380, 70, 50);
				panelCnum[i].setBounds(640 + 70 * i, 430, 70, 50);
			} else {
				panelFoto[i].setBounds(1130 + 55 * (i - 7), 380, 55, 50);
				panelCnum[i].setBounds(1130 + 55 * (i - 7), 430, 55, 50);
			}
			switch (i) {
			case 0:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i2000.getImage(), 70, 50)));
				break;
			case 1:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i1000.getImage(), 70, 50)));
				break;
			case 2:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i500.getImage(), 70, 50)));
				break;
			case 3:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i200.getImage(), 70, 50)));
				break;
			case 4:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i100.getImage(), 70, 50)));
				break;
			case 5:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i50.getImage(), 70, 50)));
				break;
			case 6:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i20.getImage(), 70, 50)));
				break;
			case 7:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 55, 50)));
				break;
			case 8:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 55, 50)));
				break;
			case 9:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 55, 50)));
				break;
			case 10:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 55, 50)));
				break;
			default:
				break;
			}
			panelCnum[i].setFont(First.myFont);
		}
		if (conf[0] == null || conf[0].equals("3")) {
			newDay.setOpaque(false);
			newDay.setText("");
			newDay.setIcon(new ImageIcon(getScaledImage(nextDI.getImage(), 70, 70)));
			newDay.setContentAreaFilled(false);
			newDay.setBorderPainted(false);
			newDay.setBounds(1130, 590, 70, 70);
		} else
			newDay.setBounds(1070, 570, 250, 65);
		total[7].setBounds(640, 480, 710, 50);
		restTmrw.setBounds(1070, 634, 250, 45);
		pesosF.setBounds(960, 590, 70, 70);
		diffResult[0].setBounds(680, 570, 250, 55);
		diffResult[1].setBounds(680, 624, 250, 55);
		notasF.setBounds(1360, 580, 80, 80);
		clearEverthing.setBounds(560, 555, 70, 70);
		total[7].setFont(First.myFont);
		diffResult[0].setFont(First.myFont);
		diffResult[1].setFont(First.myFont);
		restTmrw.setFont(First.myFont);
		newDay.setFont(First.myFont);
		notasF.setIcon(new ImageIcon(getScaledImage(notasI.getImage(), 80, 80)));
		pesosF.setIcon(new ImageIcon(getScaledImage(realesI.getImage(), 70, 70)));
		clearEverthing.setIcon(new ImageIcon(getScaledImage(clear.getImage(), 70, 70)));
	}

	private void resG(JMenuItem resoD, JButton pesosF, JButton notasF, JButton newDay, JButton clearEverthing,
			JButton gastosPanel, JButton aggPanel) {
		this.setSize(1820, 980);
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
		boletoN[5].setFont(First.myFont);
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
		for (int i = 0; i < 11; i++) {
			if (i < 7) {
				panelFoto[i].setBounds(800 + 80 * i, 450, 80, 60);
				panelCnum[i].setBounds(800 + 80 * i, 510, 80, 60);
			} else {
				panelFoto[i].setBounds(1360 + 65 * (i - 7), 450, 65, 60);
				panelCnum[i].setBounds(1360 + 65 * (i - 7), 510, 65, 60);
			}
			switch (i) {
			case 0:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i2000.getImage(), 80, 60)));
				break;
			case 1:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i1000.getImage(), 80, 60)));
				break;
			case 2:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i500.getImage(), 80, 60)));
				break;
			case 3:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i200.getImage(), 80, 60)));
				break;
			case 4:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i100.getImage(), 80, 60)));
				break;
			case 5:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i50.getImage(), 80, 60)));
				break;
			case 6:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i20.getImage(), 80, 60)));
				break;
			case 7:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 65, 60)));
				break;
			case 8:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 65, 60)));
				break;
			case 9:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 65, 60)));
				break;
			case 10:
				panelFoto[i].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 65, 60)));
				break;
			default:
				break;
			}
			panelCnum[i].setFont(First.myFont);
		}
		if (conf[0] == null || conf[0].equals("3")) {
			newDay.setOpaque(false);
			newDay.setText("");
			newDay.setIcon(new ImageIcon(getScaledImage(nextDI.getImage(), 80, 80)));
			newDay.setContentAreaFilled(false);
			newDay.setBorderPainted(false);
			newDay.setBounds(1360, 730, 80, 80);
		} else
			newDay.setBounds(1270, 700, 300, 75);
		total[7].setBounds(800, 570, 820, 60);
		restTmrw.setBounds(1270, 774, 300, 55);
		pesosF.setBounds(1140, 730, 80, 80);
		diffResult[0].setBounds(850, 700, 250, 65);
		diffResult[1].setBounds(850, 764, 250, 65);
		notasF.setBounds(1650, 700, 100, 100);
		clearEverthing.setBounds(640, 690, 80, 80);
		total[7].setFont(First.myFont);
		diffResult[0].setFont(First.myFont);
		diffResult[1].setFont(First.myFont);
		restTmrw.setFont(First.myFont);
		newDay.setFont(First.myFont);
		notasF.setIcon(new ImageIcon(getScaledImage(notasI.getImage(), 100, 100)));
		pesosF.setIcon(new ImageIcon(getScaledImage(realesI.getImage(), 80, 80)));
		clearEverthing.setIcon(new ImageIcon(getScaledImage(clear.getImage(), 80, 80)));
	}

	private void idiomaTexts(int idioma, JMenuItem hideBtn, JMenuItem noHide, JMenuItem hideDate, JMenuItem hideAll,
			JButton notasF, JButton newDay, JMenuItem resoD, JButton aggPanel, JButton gastosPanel, JMenu file,
			JMenuItem novo, JMenuItem clear, JMenuItem calc, JMenuItem save, JMenuItem option, JMenuItem exit,
			JMenu summary, JMenuItem sumV, JMenu effectChooser, JMenuItem sumV1, JMenuItem sumV2, JMenuItem sumV3,
			JMenuItem exMenu, JMenu speedChooser, JMenuItem speed1, JMenuItem speed2, JMenuItem speed3, JMenu goTo,
			JMenuItem fatura, JMenuItem firstFrame, JMenu reso, JMenuItem reso1, JMenuItem reso2, JMenuItem reso3,
			JMenuItem reso4, JMenu help, JMenu hideMenu, JMenuItem keyShortcut, JMenuItem creator, JMenuItem about) {
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
		} else {
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
		}
	}

	private String[] idiomaString(int idioma) {
		String[] espanol = { "• CTRL + S → ir la fatura.\n" + "• CTRL + R → ir al reales.\n"
				+ "• CTRL + B → borrar todo.\n" + "• CTRL + N → prepárate para el día siguiente.\n"
				+ "• FLECHAS → subir, abajo, derecha e izquierda.\n" + "• CTRL + D → ir al detalles.\n"
				+ "• CTRL + I → ir al inicio.\n" + "• CTRL + G → ir al gastos.\n" + "• CTRL + A → ir al agregado.\n"
				+ "• CTRL + T → ir a la caja.\n" + "• CTRL + E → ir al ultimo numero.\n"
				+ "• CTRL + O → esconder los botones.\n" + "• CTRL + C → abrir el configuración."// key shortcut 1
				, "ATAJOS DE TECLADO" // key shortcut 2
				, "Crédito y Diseñado por MhmdSAbdlh ©"// creator 3
				,
				"ESTA APLICACIÓN ESTÁ DISEÑADA PARA CEDROS Y NARJES FREE SHOP.\r\n"
						+ "TIENE MARCO PARA CERRAR LA CAJA TANTO EN REALES COMO PESOS.\r\n"
						+ "TIENE UN MARCO PARA CALCULAR EL TROCO DE UNA VENTA TANTO EN REALES COMO PESOS.\r\n"
						+ "SABE CÓMO QUEDARÁ PARA EL PRÓXIMO DÍA.\r\n" + "3 MÉTODOS PARA DAR EL CAMBIO.\r\n"
						+ "CAMBIARÁ TODO SEGÚN EL ICONO SELECCIONADO.\r\n" + "\r\n" + "MOHAMAD ABDALLAH ABBASS ©"// about4
				, "CONFIGURACIÓN"// conf title 5
				, "ICONO"// icon 6
				, "IDIOMA"// LANGUAGE 7
				, "xxx"// 8
				, "AUTOGUARDAR"// AUTO SAVE 9
				, "POR DEFECTO"// DEFAULT 10
				, "GUARDAR"// SAVE 11
				, "SI"// YES 12
				, "NO"// NO 13
				, "¿Seguro que quieres salir?"// exit 14
				, "SALIR"// exit15
				, "Si /Nuevo Dia"// new day 16
				, "¿QUIERES EMPEZAR NUEVO DIA?"// new day 17
				, "NUEVO DIA" // new day 18
				, "¿QUIERES BORRAR TODO?"// clear 19
				, "BORRAR TODO" // clear20
				, "Más "// mas 21
				, "<html><center>No Hay Diferencia</html>"// diif 22
				, "Sobró R$" // sobro 23
				, "Faltó R$" // falta 24
		};
		String[] portugues = { "• CTRL + S → ir para a fatura.\n" + "• CTRL + R → ir para os reales.\n"
				+ "• CTRL + B → excluir tudo.\n" + "• CTRL + N → prepare-se para o dia seguinte.\n"
				+ "• SETAS → cima, baixo, esquerda e direita.\n" + "• CTRL + D → ir para detalhes.\n"
				+ "• CTRL + I → ir para o início.\n" + "• CTRL + G → ir para as despesas.\n"
				+ "• CTRL + A → ir para agregar.\n" + "• CTRL + T → ir para finalizar a compra.\n"
				+ "• CTRL + E → ir para o último número.\n" + "• CTRL + O → ocultar os botões.\n"
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
		};
		if (idioma == 0)
			return espanol;
		else
			return portugues;
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
		return keywords;
	}
}
