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
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
import javax.swing.JSlider;
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
	static int totalCol = 0, totalVenta = 0, totalO = 0;
	static int gastosT = 0, agregadoT = 0;
	static int restN, totalCaja = 0, nbOf20 = 0;
	int width, height;
	static int colorX = 0, order = 0, speedValue, wordsN, wordL, effChooser;
	boolean status = false;
	Timer timer;
	String conf[] = new String[7];
	JLabel date = new JLabel();// date of the day
	String monthS = new SimpleDateFormat("MMMM").format(Calendar.getInstance().getTime()).toUpperCase();
	String dayN = new SimpleDateFormat("dd").format(Calendar.getInstance().getTime());
	String dayS = new SimpleDateFormat("EEEE").format(Calendar.getInstance().getTime()).toUpperCase();
	String yearS = new SimpleDateFormat("YYYY").format(Calendar.getInstance().getTime());

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

	Reales() {
		// Notification when its time to end the day
		long delay = ChronoUnit.MILLIS.between(LocalTime.now(), LocalTime.of(17, 30, 00));
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		scheduler.schedule(First.itsAlmostTime(), delay, TimeUnit.MILLISECONDS);

		// Buttons
		JMenuItem hideBtn = new JMenuItem("ESCONDER LOS BOTONES");
		JButton clearEverthing = new JButton();
		JButton pesosF = new JButton();
		JButton notasF = new JButton();// FATURA BUTTON
		JButton newDay = new JButton("<html><center>Se Quedará<br>Para Mañana</center></html>");// REST
		JMenuItem resoD = new JMenuItem("ÓPTIMO");
		JButton aggPanel = new JButton("↑MÁS↓");
		JButton gastosPanel = new JButton("↑MÁS↓");

		// Frame
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int) screenSize.getWidth();
		height = (int) screenSize.getHeight();
		this.setTitle("CIERRE DE CAJA - R$");
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
		// Icon
		if (conf[0] == null || conf[0].equals("0")) {
			url = getClass().getResource("images/icon/cedros0.png");
		} else if (conf[0].equals("1")) {
			url = getClass().getResource("images/icon/cedros1.png");
		} else if (conf[0].equals("2")) {
			url = getClass().getResource("images/icon/cedros2.png");
		} else {
			url = getClass().getResource("images/icon/narjes.png");
		}
		this.setIconImage(new ImageIcon(url).getImage());
		// BUTTONS
		if (conf[1] == null || conf[1].equals("0")) {
			pesosF.show();
			clearEverthing.show();
			notasF.show();
			date.show();
			hideBtn.setText("ESCONDER LOS BOTONES");
		} else if (conf[1].equals("1")) {
			pesosF.show();
			clearEverthing.show();
			notasF.show();
			date.hide();
			hideBtn.setText("ESCONDER LOS BOTONES");
		} else {
			pesosF.hide();
			clearEverthing.hide();
			notasF.hide();
			date.hide();
			hideBtn.setText("MONSTRAR LOS BOTONES");
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
		date.setText(" " + dayS + ", " + dayN + "  " + monthS + "  " + yearS);
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
		gastosPanel.addActionListener(e -> {
			gastosFrame(keywords, notasF, pesosF, newDay, clearEverthing, resoD, gastosPanel);
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
		aggPanel.addActionListener(e -> {
			aggFrame(keywords, notasF, pesosF, newDay, clearEverthing, resoD, gastosPanel);
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
		JMenuItem option = new JMenuItem("CONFIGURACIÓN");
		JMenuItem exit = new JMenuItem("SALIR");
		novo.addActionListener(e -> newDay());
		calc.addActionListener(e -> sumF());
		clear.addActionListener(e -> clearAll());
		save.addActionListener(e -> saveProgress());
		option.addActionListener(
				e -> confFrame(conf, notasF, pesosF, newDay, clearEverthing, hideBtn, resoD, gastosPanel, aggPanel));
		exit.addActionListener(e -> System.exit(0));
		file.add(novo);
		file.add(calc);
		file.add(clear);
		file.add(save);
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
		sumV.addActionListener(e -> summaryFrame());
		sumV1.addActionListener(e -> effChooser = 0);
		sumV2.addActionListener(e -> effChooser = 1);
		sumV3.addActionListener(e -> effChooser = 2);
		exMenu.addActionListener(e -> exBtn());
		effectChooser.add(sumV1);
		effectChooser.add(sumV2);
		effectChooser.add(sumV3);
		summary.add(sumV);
		summary.add(exMenu);
		summary.add(effectChooser);
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
		resoD.addActionListener(
				e -> opResolution(clearEverthing, pesosF, notasF, newDay, resoD, aggPanel, gastosPanel));
		reso1.addActionListener(e -> resG(resoD, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel));
		reso2.addActionListener(e -> resM(resoD, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel));
		reso3.addActionListener(e -> resP(resoD, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel));
		reso4.addActionListener(e -> resXP(resoD, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel));
		// HELP
		JMenu help = new JMenu("AYUDA");
		JMenuItem getHelp = new JMenuItem("ATAJOS DE TECLADO");
		JMenuItem creator = new JMenuItem("SOBRE EL CREADOR");
		JMenuItem about = new JMenuItem("SOBRE EL APLICATIVO");
		if (conf[2] == null || conf[2].equals("false"))
			getHelp.addActionListener(e -> JOptionPane.showMessageDialog(null,
					"• CTRL + S → ir la fatura.\n" + "• CTRL + P → ir al pesos.\n" + "• CTRL + B → borrar todo.\n"
							+ "• CTRL + N → prepárate para el día siguiente.\n"
							+ "• FLECHAS → subir, abajo, derecha e izquierda.\n" + "• CTRL + D → ir al detalles.\n"
							+ "• CTRL + I → ir al inicio.\n" + "• CTRL + G → ir al gastos.\n"
							+ "• CTRL + A → ir al agregado.\n" + "• CTRL + T → ir a la caja.\n"
							+ "• CTRL + E → ir al ultimo numero.\n" + "• CTRL + M → mas un 100 o de 1000 si posible.\n"
							+ "• CTRL + O → esconder los botones.\n" + "• CTRL + C → abrir el configuración.",
					"ATAJOS DE TECLADO", 1));
		else
			getHelp.hide();
		hideBtn.addActionListener(e -> hideBtn(notasF, pesosF, newDay, clearEverthing, hideBtn));
		creator.addActionListener(
				e -> JOptionPane.showMessageDialog(null, "Crédito y Diseñado por MhmdSAbdlh ©", "SOBRE MI", 1));
		about.addActionListener(e -> JOptionPane.showMessageDialog(null,
				"ESTA APLICACIÓN ESTÁ DISEÑADA PARA CEDROS Y NARJES FREE SHOP.\r\n"
						+ "TIENE MARCO PARA CERRAR LA CAJA TANTO EN REALES COMO PESOS.\r\n"
						+ "TIENE UN MARCO PARA CALCULAR EL TROCO DE UNA VENTA TANTO EN REALES COMO PESOS.\r\n"
						+ "SABE CÓMO QUEDARÁ PARA EL PRÓXIMO DÍA.\r\n" + "3 MÉTODOS PARA DAR EL CAMBIO.\r\n"
						+ "CAMBIARÁ TODO SEGÚN EL ICONO SELECCIONADO.\r\n" + "\r\n" + "MOHAMAD ABDALLAH ABBASS ©",
				"CEDROS/NARJES", 1));
		help.add(getHelp);
		help.add(hideBtn);
		help.add(creator);
		help.add(about);
		// ADD TO MENUBAR
		mb.add(file);
		mb.add(summary);
		mb.add(goTo);
		mb.add(reso);
		mb.add(help);
		this.setJMenuBar(mb);

		// Frame Run
		openProgress();
		sumF();
		// Open to the last value
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
		this.getRootPane().setDefaultButton(magic);
		this.setVisible(true);

		// Resolution
		if (conf[3] == null || conf[3].equals("0")) {
			opResolution(clearEverthing, pesosF, notasF, newDay, resoD, aggPanel, gastosPanel);
		} else if (conf[3].equals("1"))
			resXP(resoD, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel);
		else if (conf[3].equals("2"))
			resP(resoD, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel);
		else if (conf[3].equals("3"))
			resM(resoD, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel);
		else
			resG(resoD, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel);

		// Automatically add sets of 100 and 1000
		if (aggBtn[0].isShowing() && aggBtn[1].isShowing()) {
			addSetMil();
			addSetHun();
		} else if (aggBtn[0].isShowing())
			addSetMil();
		else if (aggBtn[1].isShowing())
			addSetHun();

		// Close popup
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				Object[] options = { "Si", "No", "Si /Nuevo Dia" };
				int selectedOption = JOptionPane.showOptionDialog(null, "¿Seguro que quieres salir?", "SALIR",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

				if (selectedOption == JOptionPane.YES_OPTION)
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
					for (int i = 0; i < 5; i++)
						panelCnum[i].setText("");
					panelCnum[5].setText("" + nbOf20);
					sumF();
					System.exit(0);
				}
			}
		});
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
		sum.setTitle("SUMARIO");
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
		// TIMER
		order = 0;
		wordsN = 0;
		wordL = 0;
		colorX = 0;
		status = true;
		ActionListener fadeTimer = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sumItem.setForeground(new Color(0, 0, 0, colorX));
				switch (order) {
				case 0: {// details start
					if (totalVenta == 0) {
						sumItem.setText("USTED NO VENDIÓ NADA");
						sumItem.setBounds(0, 240, 650, 550);
					} else {
						if (nbVentas() == 1) {
							sumItem.setText("USTED VENDIÓ UNA VENTA SOLO QUE VALE R$" + totalVenta);
							sumItem.setBounds(0, 240, 650, 550);
						} else {
							sumItem.setText("USTED VENDIÓ R$" + totalVenta + "\n\nDIVIDIENDO EN " + nbVentas()
									+ " VENTAS\n\n" + "CON UN PROMEDIO DE R$" + totalVenta / nbVentas() + " POR VENTA");
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
						sumItem.setText("NO TIENES GASTOS!");
					} else {
						if (nbGastos() == 1) {
							sumItem.setText("TIENES EN TOTAL UN GASTO QUE VALE R$" + gastosT + "\n\n"
									+ "DETALLADO COMO:\n" + gastosDetalles());
							sumItem.setBounds(0, 220, 650, 550);
						} else {
							sumItem.setText("TIENES EN TOTAL R$" + gastosT + " COMO GASTOS\n\n" + "DIVIDIDO POR "
									+ nbGastos() + " COSAS\n\n" + "CON UN PROMEDIO DE R$" + gastosT / nbGastos()
									+ "\n\n" + "DETALLADO COMO:\n" + gastosDetalles());
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
						sumItem.setText("NO TIENES AGREGADOS!");
						sumItem.setBounds(0, 240, 650, 550);
					} else {
						if (nbAgregados() == 1) {
							sumItem.setText("TIENES EN TOTAL UN AGREGADO QUE VALE R$" + agregadoT + "\n\n"
									+ "DETALLADO COMO:\n" + agregadoDetalles());
							sumItem.setBounds(0, 220, 650, 550);
						} else {
							sumItem.setText("TIENES EN TOTAL R$" + agregadoT + " COMO AGREGADOS\n\n" + "DIVIDIDO POR "
									+ nbAgregados() + " COSAS\n\n" + "CON UN PROMEDIO DE R$" + agregadoT / nbAgregados()
									+ "\n\n" + "DETALLADO COMO:\n" + agregadoDetalles());
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
						if (Integer.valueOf(panelCnum[10].getText()) > 0)
							sumItem.setText("PARA RESUMIR\n\n" + "EMPEZAMOS EL DÍA CON R$" + initialDay.getText()
									+ "\n\nY VENDIMOS R$" + totalVenta + "\n\nY GASTO R$" + gastosT
									+ "\n\nQUE TERMINARÁ CON R$" + totalO + " EN TOTAL" + "\n\nCON UN R$"
									+ panelCnum[10].getText() + " COMO PIX");
						else
							sumItem.setText("PARA RESUMIR\n\n" + "EMPEZAMOS EL DÍA CON R$" + initialDay.getText()
									+ "\n\nY VENDIMOS R$" + totalVenta + "\n\nY GASTO R$" + gastosT
									+ "\n\nQUE TERMINARÁ CON R$" + totalO + " EN TOTAL");
					else if (Integer.valueOf(panelCnum[10].getText()) > 0)
						sumItem.setText("PARA RESUMIR\n\n" + "EMPEZAMOS EL DÍA CON R$" + initialDay.getText()
								+ "\n\nY VENDIMOS R$" + totalVenta + "\n\nY GASTO R$" + gastosT + "\n\nY AGREGÓ R$"
								+ agregadoT + "\n\nQUE TERMINARÁ CON R$" + totalO + " EN TOTAL" + "\n\nCON UN R$"
								+ panelCnum[10].getText() + " COMO PIX");
					else
						sumItem.setText("PARA RESUMIR\n\n" + "EMPEZAMOS EL DÍA CON R$" + initialDay.getText()
								+ "\n\nY VENDIMOS R$" + totalVenta + "\n\nY GASTO R$" + gastosT + "\n\nY AGREGÓ R$"
								+ agregadoT + "\n\nQUE TERMINARÁ CON R$" + totalO + " EN TOTAL");
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
						sumItem.setText("LA CAJA DIO BIEN\n\n" + "NO HAY DIFERENCIA\n\n" + ":)");
					else
						sumItem.setText("LA CAJA NO DIO BIEN\n\n" + "PARECE QUE "
								+ diffResult[1].getText().toUpperCase() + "\n\nREVISA LOS BOLETOS Y LA CAJA");
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
					sumItem.setText("QUEDARÁ PARA MAÑANA APROXIMADAMENTE\n\nR$" + restN);
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
					sumItem.setText("TOQUE EL BOTÓN PARA EXPORTAR EL RESULTADO");
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
					if (totalVenta == 0) {
						String[] wordT = { "USTED", " NO", " VENDIÓ", " NADA" };
						sumItem.setBounds(0, 240, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++]));
						else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					} else if (nbVentas() == 1) {
						String[] wordT = { "USTED ", "VENDIÓ", " UNA", " VENTA", " QUE", " VALE", " R$" + totalVenta,
								"", "" };
						sumItem.setBounds(0, 220, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++]));
						else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					} else {
						String[] wordT = { "USTED ", "VENDIÓ", " R$" + totalVenta, "\n\nDIVIDIENDO", " EN ",
								nbVentas() + " VENTAS\n\n", "CON", " UN", " PROMEDIO", " DE",
								" R$" + totalVenta / nbVentas(), " POR", " VENTA", "", "" };
						sumItem.setBounds(0, 200, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++]));
						else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 1: {// gastos start
					if (gastosT == 0) {
						String[] wordT = { "USTED", " NO", " TIENE", " GASTOS!" };
						sumItem.setBounds(0, 240, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++]));
						else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					} else if (nbGastos() == 1) {
						String[] wordT = { "TIENES ", "EN", " TOTAL", " UN", " GASTO", " QUE", " VALE", " R$" + gastosT,
								"\n\nDETALLADO", " COMO:\n", gastosDetalles(), "", "" };
						sumItem.setBounds(0, 220, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++]));
						else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					} else {
						String[] wordT = { "TIENES ", "EN", " TOTAL", " R$" + gastosT, " COMO", " GASTOS\n",
								"\nDIVIDIENDO", " EN ", nbGastos() + " COSAS\n\n", "CON", " UN", " PROMEDIO", " DE",
								" R$" + gastosT / nbGastos(), "\n\n", " DETALLADO", " COMO:\n", gastosDetalles(), "",
								"" };
						sumItem.setBounds(0, 140, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++]));
						else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 2: {// agg start
					if (agregadoT == 0) {
						String[] wordT = { "USTED", " NO", " TIENE", " AGREGADOS!" };
						sumItem.setBounds(0, 240, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++]));
						else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					} else if (nbAgregados() == 1) {
						String[] wordT = { "TIENES ", "EN", " TOTAL", " UN", " AGREGADO", " QUE", " VALE",
								" R$" + agregadoT, "\n\nDETALLADO", " COMO:\n", agregadoDetalles(), "", "" };
						sumItem.setBounds(0, 220, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++]));
						else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					} else {
						String[] wordT = { "TIENES", " EN", " TOTAL", " R$" + agregadoT, " COMO", " AGREGADOS\n\n",
								"DIVIDIDO", " POR " + nbAgregados(), " COSAS\n\n", "CON", " UN", " PROMEDIO", " DE",
								" R$" + agregadoT / nbAgregados() + "\n\n", "DETALLADO", " COMO:\n", agregadoDetalles(),
								"\n", "\n" };
						sumItem.setBounds(0, 140, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++]));
						else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 3: {// SUMMARY start
					if (agregadoT == 0)
						if (Integer.valueOf(panelCnum[10].getText()) > 0) {
							sumItem.setBounds(0, 120, 650, 550);
							String[] wordT = { "PARA ", "RESUMIR\n\n", " EMPEZAMOS", " EL DÍA", " CON",
									" R$" + initialDay.getText(), "\n\nY VENDIMOS", " R$" + totalVenta, "\n\nY GASTO",
									" R$" + gastosT, "\n\nQUE", " TERMINARÁ", " CON", " R$" + totalO, " EN TOTAL",
									"\n\nCON", " UN", " R$" + panelCnum[10].getText(), " COMO", " PIX", "", "" };
							if (wordL < wordT.length)
								sumItem.setText(sumItem.getText().concat(wordT[wordL++]));
							else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						} else {
							sumItem.setBounds(0, 140, 650, 550);
							String[] wordT = { "PARA ", "RESUMIR\n\n", " EMPEZAMOS", " EL DÍA", " CON",
									" R$" + initialDay.getText(), "\n\nY VENDIMOS", " R$" + totalVenta, "\n\nY GASTO",
									" R$" + gastosT, "\n\nQUE", " TERMINARÁ", " CON", " R$" + totalO, " EN TOTAL", "",
									"" };
							if (wordL < wordT.length)
								sumItem.setText(sumItem.getText().concat(wordT[wordL++]));
							else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					else if (Integer.valueOf(panelCnum[10].getText()) > 0) {
						sumItem.setBounds(0, 100, 650, 550);
						String[] wordT = { "PARA ", "RESUMIR\n\n", " EMPEZAMOS", " EL DÍA", " CON",
								" R$" + initialDay.getText(), "\n\nY VENDIMOS", " R$" + totalVenta, "\n\nY GASTO",
								" R$" + gastosT, "\n\nY AGREGÓ", " R$" + agregadoT, "\n\nQUE", " TERMINARÁ", " CON",
								" R$" + totalO, " EN TOTAL", "\n\nCON", " UN", " R$" + panelCnum[10].getText(), " COMO",
								" PIX", "", "" };
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++]));
						else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					} else {
						sumItem.setBounds(0, 120, 650, 550);
						String[] wordT = { "PARA ", "RESUMIR\n\n", " EMPEZAMOS", " EL DÍA", " CON",
								" R$" + initialDay.getText(), "\n\nY VENDIMOS", " R$" + totalVenta, "\n\nY GASTO",
								" R$" + gastosT, "\n\nY AGREGÓ", " R$" + agregadoT, "\n\nQUE", " TERMINARÁ", " CON",
								" R$" + totalO, " EN TOTAL", "", "" };
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++]));
						else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 4: {// diferrence start
					if (totalO == totalCaja) {
						String[] wordT = { "LA", " CAJA", " DIO", " BIEN\n\n", "NO", " HAY", " DIFERENCIA\n\n", ":)" };
						sumItem.setBounds(0, 220, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++]));
						else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					} else {
						String[] wordT = { "LA", " CAJA", " NO", " DIO", " BIEN\n\n", "PARECE",
								" QUE " + diffResult[1].getText().toUpperCase(), "\n\nREVISA", " LOS", " BOLETOS",
								" Y LA", " CAJA", "", "" };
						sumItem.setBounds(0, 200, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++]));
						else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 5: {// remain for tmrw
					String[] wordT = { "QUEDARÁ", " PARA", " MAÑANA", " APROXIMADAMENTE\n\n", "R$" + restN, "", "" };
					sumItem.setBounds(0, 220, 650, 550);
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++]));
					else {
						order++;
						wordL = 0;
						sumItem.setText("");
					}
					break;
				}
				case 6: {// export button
					String[] wordT = { "TOQUE", " EL", " BOTÓN", " PARA", " EXPORTAR", " EL", " RESULTADO" };
					sumItem.setBounds(0, 200, 650, 550);
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++]));
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
						char[] wordT = "USTED NO VENDIÓ NADA\n\n\n\n".toCharArray();
						sumItem.setBounds(0, 240, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText() + wordT[wordL++]);
						else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					} else if (nbVentas() == 1) {
						char[] wordT = ("USTED VENDIÓ UNA VENTA SOLO QUE VALE R$" + totalVenta + "\n\n\n\n")
								.toCharArray();
						sumItem.setBounds(0, 240, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText() + wordT[wordL++]);
						else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					} else {
						char[] wordT = ("USTED VENDIÓ R$" + totalVenta + "\n\nDIVIDIENDO EN " + nbVentas()
								+ " VENTAS\n\n" + "CON UN PROMEDIO DE R$" + totalVenta / nbVentas() + " POR VENTA"
								+ "\n\n\n\n").toCharArray();
						sumItem.setBounds(0, 200, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText() + wordT[wordL++]);
						else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 1: {// gastos start
					if (gastosT == 0) {
						char[] wordT = "USTED NO TIENE GASTOS!\n\n\n\n".toCharArray();
						sumItem.setBounds(0, 240, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText() + wordT[wordL++]);
						else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					} else if (nbGastos() == 1) {
						char[] wordT = ("TIENES EN TOTAL UN GASTO QUE VALE R$" + gastosT + "\n\n" + "DETALLADO COMO:\n"
								+ gastosDetalles() + "\n\n\n\n").toCharArray();
						sumItem.setBounds(0, 200, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText() + (wordT[wordL++]));
						else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					} else {
						char[] wordT = ("TIENES EN TOTAL R$" + gastosT + " COMO GASTOS\n\n" + "DIVIDIDO POR "
								+ nbGastos() + " COSAS\n\n" + "CON UN PROMEDIO DE R$" + gastosT / nbGastos() + "\n\n"
								+ "DETALLADO COMO:\n" + gastosDetalles() + "\n\n\n\n").toCharArray();
						sumItem.setBounds(0, 140, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText() + (wordT[wordL++]));
						else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 2: {// agg start
					if (agregadoT == 0) {
						char[] wordT = "NO TIENES AGREGADOS!\n\n\n\n".toCharArray();
						sumItem.setBounds(0, 240, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText() + (wordT[wordL++]));
						else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					} else if (nbAgregados() == 1) {
						char[] wordT = ("TIENES EN TOTAL UN AGREGADO QUE VALE R$" + agregadoT + "\n\n"
								+ "DETALLADO COMO:\n" + agregadoDetalles() + "\n\n\n\n").toCharArray();
						sumItem.setBounds(0, 200, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText() + (wordT[wordL++]));
						else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					} else {
						char[] wordT = ("TIENES EN TOTAL R$" + agregadoT + " COMO AGREGADOS\n\n" + "DIVIDIDO POR "
								+ nbAgregados() + " COSAS\n\n" + "CON UN PROMEDIO DE R$" + agregadoT / nbAgregados()
								+ "\n\n" + "DETALLADO COMO:\n" + agregadoDetalles() + "\n\n\n\n").toCharArray();
						sumItem.setBounds(0, 140, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText() + (wordT[wordL++]));
						else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 3: {// SUMMARY start
					if (agregadoT == 0)
						if (Integer.valueOf(panelCnum[10].getText()) > 0) {
							sumItem.setBounds(0, 120, 650, 550);
							char[] wordT = ("PARA RESUMIR\n\n" + "EMPEZAMOS EL DÍA CON R$" + initialDay.getText()
									+ "\n\nY VENDIMOS R$" + totalVenta + "\n\nY GASTO R$" + gastosT
									+ "\n\nQUE TERMINARÁ CON R$" + totalO + " EN TOTAL" + "\n\nCON UN R$"
									+ panelCnum[10].getText() + " COMO PIX" + "\n\n\n\n").toCharArray();
							if (wordL < wordT.length)
								sumItem.setText(sumItem.getText() + (wordT[wordL++]));
							else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						} else {
							sumItem.setBounds(0, 140, 650, 550);
							char[] wordT = ("PARA RESUMIR\n\n" + "EMPEZAMOS EL DÍA CON R$" + initialDay.getText()
									+ "\n\nY VENDIMOS R$" + totalVenta + "\n\nY GASTO R$" + gastosT
									+ "\n\nQUE TERMINARÁ CON R$" + totalO + " EN TOTAL" + "\n\n\n\n").toCharArray();
							if (wordL < wordT.length)
								sumItem.setText(sumItem.getText() + (wordT[wordL++]));
							else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					else if (Integer.valueOf(panelCnum[10].getText()) > 0) {
						sumItem.setBounds(0, 100, 650, 550);
						char[] wordT = ("PARA RESUMIR\n\n" + "EMPEZAMOS EL DÍA CON R$" + initialDay.getText()
								+ "\n\nY VENDIMOS R$" + totalVenta + "\n\nY GASTO R$" + gastosT + "\n\nY AGREGÓ R$"
								+ agregadoT + "\n\nQUE TERMINARÁ CON R$" + totalO + " EN TOTAL" + "\n\nCON UN R$"
								+ panelCnum[10].getText() + " COMO PIX" + "\n\n\n\n").toCharArray();
						if (wordL < wordT.length) {
							sumItem.setText(sumItem.getText() + (wordT[wordL++]));
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					} else {
						sumItem.setBounds(0, 120, 650, 550);
						char[] wordT = ("PARA RESUMIR\n\n" + "EMPEZAMOS EL DÍA CON R$" + initialDay.getText()
								+ "\n\nY VENDIMOS R$" + totalVenta + "\n\nY GASTO R$" + gastosT + "\n\nY AGREGÓ R$"
								+ agregadoT + "\n\nQUE TERMINARÁ CON R$" + totalO + " EN TOTAL" + "\n\n\n\n")
								.toCharArray();
						if (wordL < wordT.length) {
							sumItem.setText(sumItem.getText() + (wordT[wordL++]));
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 4: {// diferrence start
					if (totalO == totalCaja) {
						char[] wordT = "LA CAJA DIO BIEN\n\n NO HAY DIFERENCIA\n\n:)".toCharArray();
						sumItem.setBounds(0, 200, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText() + (wordT[wordL++]));
						else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					} else {
						char[] wordT = ("LA CAJA NO DIO BIEN\n\n" + "PARECE QUE "
								+ diffResult[1].getText().toUpperCase() + "\n\nREVISA LOS BOLETOS Y LA CAJA"
								+ "\n\n\n\n").toCharArray();
						sumItem.setBounds(0, 200, 650, 550);
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText() + (wordT[wordL++]));
						else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 5: {// remain for tmrw
					char[] wordT = ("QUEDARÁ PARA MAÑANA APROXIMADAMENTE\n\nR$" + restN + "\n\n\n\n").toCharArray();
					sumItem.setBounds(0, 220, 650, 550);
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText() + (wordT[wordL++]));
					else {
						order++;
						wordL = 0;
						sumItem.setText("");
					}
					break;
				}
				case 6: {// export button
					char[] wordT = "TOQUE EL BOTÓN PARA EXPORTAR EL RESULTADO\n\n\n\n".toCharArray();
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
				}
			}
		});

		sum.add(sumItem);
		sum.setVisible(true);
	}

	// Save the summary of the day
	private void exBtn() {
		try {
			String currentpath = System.getProperty("user.dir");
			File tempFile1 = new File(currentpath + "\\" + yearS);
			tempFile1.mkdir();
			File tempFile2 = new File(tempFile1 + "\\" + monthS);
			tempFile2.mkdir();
			File newFile = new File(tempFile2, titleName() + " " + dayS + " " + dayN + "-" + "reales.txt");
			FileWriter savedF = new FileWriter(newFile);
			savedF.write(titleName() + " - SUMARIO POR EL DIA " + dayS + " " + dayN + "-" + monthS + "-" + yearS
					+ System.lineSeparator() + System.lineSeparator());
			if (totalVenta == 0)
				savedF.write("*VENTAS:\nUSTED NO VENDIÓ NADA." + System.lineSeparator());
			else if (nbVentas() == 1)
				savedF.write("*VENTAS:\nUSTED VENDIÓ UNA VENTA SOLO QUE VALE R$" + totalVenta + System.lineSeparator());
			else
				savedF.write("*VENTAS:\nUSTED VENDIÓ R$" + totalVenta + ", DIVIDIENDO EN " + nbVentas() + " VENTAS, "
						+ "CON UN PROMEDIO DE R$" + totalVenta / nbVentas() + " POR VENTA." + System.lineSeparator());
			if (gastosT == 0)// GASTOS SAVE
				savedF.write(System.lineSeparator() + "*GASTOS:\nNO TIENES GASTOS!" + System.lineSeparator());
			else if (nbGastos() == 1)
				savedF.write(System.lineSeparator() + "*GASTOS:\nTIENES EN TOTAL UN GASTO QUE VALE R$" + gastosT + "."
						+ System.lineSeparator() + "DETALLADO COMO: " + System.lineSeparator() + gastosDetalles());
			else
				savedF.write(System.lineSeparator() + "*GASTOS:\nTIENES EN TOTAL R$" + gastosT + " COMO GASTOS, "
						+ "DIVIDIDO POR " + nbGastos() + " COSAS, " + "CON UN PROMEDIO DE R$" + gastosT / nbGastos()
						+ "." + System.lineSeparator() + "DETALLADO COMO: " + System.lineSeparator()
						+ gastosDetalles());
			if (agregadoT != 0) {// AGG SAVE if not 0
				if (nbAgregados() == 1)
					savedF.write(System.lineSeparator() + "*AGREGADOS:\nTIENES EN TOTAL UN AGREGADO QUE VALE R$"
							+ agregadoT + "." + System.lineSeparator() + "DETALLADO COMO: " + System.lineSeparator()
							+ agregadoDetalles());
				else
					savedF.write(System.lineSeparator() + "*AGREGADOS:\nTIENES EN TOTAL R$" + agregadoT
							+ " COMO AGREGADOS, " + "DIVIDIDO POR " + nbAgregados() + " COSAS, "
							+ "CON UN PROMEDIO DE R$" + agregadoT / nbAgregados() + "." + System.lineSeparator()
							+ "DETALLADO COMO: " + System.lineSeparator() + agregadoDetalles());
				savedF.write(System.lineSeparator() + "*PARA RESUMIR:\n" + "EMPEZAMOS EL DÍA CON R$"
						+ initialDay.getText() + "\nVENDIMOS R$" + totalVenta + "\nGASTO R$" + gastosT + "\nAGREGÓ R$"
						+ agregadoT + "\nQUE TERMINARÁ CON R$" + totalO + " EN TOTAL." + "\nCON UN R$"
						+ panelCnum[10].getText() + " COMO PIX" + System.lineSeparator());
			} else
				savedF.write(System.lineSeparator() + "*PARA RESUMIR:\n" + "EMPEZAMOS EL DÍA CON R$"
						+ initialDay.getText() + "\nVENDIMOS R$" + totalVenta + "\nGASTO R$" + gastosT
						+ "\nQUE TERMINARÁ CON R$" + totalO + " EN TOTAL" + "\nCON UN R$" + panelCnum[10].getText()
						+ " COMO PIX." + System.lineSeparator());
			if (totalO == totalCaja)
				savedF.write(System.lineSeparator() + "*LA CAJA DIO BIEN, " + "NO HAY DIFERENCIA" + ":)"
						+ System.lineSeparator());
			else
				savedF.write(System.lineSeparator() + "*LA CAJA NO DIO BIEN, " + "PARECE QUE "
						+ diffResult[1].getText().toUpperCase() + "." + System.lineSeparator());
			savedF.write(System.lineSeparator() + "*QUEDARÁ PARA MAÑANA APROXIMADAMENTE " + "R$" + restN + "."
					+ System.lineSeparator());
			savedF.write(System.lineSeparator() + "*GRACIAS Y HASTA MAÑANA :) ");
			savedF.close();

			JOptionPane opt = new JOptionPane("SALVADO CON ÉXITO, GRACIAS", JOptionPane.INFORMATION_MESSAGE);
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
			JButton aggPanel, JButton gastosPanel) {
		if (width > 1800 && height > 1000)
			resG(resoD, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel);
		else if (width > 1500 && height > 700)
			resM(resoD, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel);
		else if (width > 1300 && height > 700)
			resP(resoD, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel);
		else
			resXP(resoD, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel);
	}

	// Gastos frame if there is more than 4
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

	// Agregados frame if there is more than 4
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

	// Configuration tab
	private void confFrame(String[] conf, JButton notasF, JButton pesosF, JButton newDay, JButton clearEverthing,
			JMenuItem hideBtn, JMenuItem resoD, JButton gastosPanel, JButton aggPanel) {
		JFrame temp = new JFrame();
		temp.setTitle("CONFIGURACIÓN");
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
		JLabel op1 = new JLabel("ICONO");
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
			op1C.setSelectedIndex(Integer.valueOf(conf[0]));
		op1C.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Reales.this.setIconImage(iconImages[op1C.getSelectedIndex()].getImage());
				op1C.setSelectedIndex(op1C.getSelectedIndex());
			}
		});
		// OPTION 2 BUTTONS HIDE
		JLabel op2 = new JLabel("ESCONDER");
		op2.setBounds(50, 90, 150, 40);
		op2.setFont(First.myFont);
		String hOp[] = { "NADA", "LA FECHA", "LA FECHA Y LOS BOTONES" };
		JComboBox<String> btnsHideShow = new JComboBox<String>(hOp);
		btnsHideShow.setRenderer(dlcr);
		if (conf[1] != null && First.isNumeric(conf[1]))
			btnsHideShow.setSelectedIndex(Integer.valueOf(conf[1]));
		btnsHideShow.setBounds(305, 90, 300, 40);
		btnsHideShow.setFont(First.myFont);
		btnsHideShow.setBackground(First.lightC);
		btnsHideShow.setForeground(First.blueD);
		btnsHideShow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnsHideShow.setSelectedIndex(btnsHideShow.getSelectedIndex());
			}
		});
		// OPTION 2 DISABLE KEYBOARD SHORTCUT
		JLabel op3 = new JLabel("ATAJO DE TECLADO");
		op3.setBounds(50, 230, 250, 40);
		op3.setFont(First.myFont);
		JToggleButton btnsHideShow2 = new JToggleButton();
		if (conf[2] == null || conf[2].equals("false")) {
			btnsHideShow2.setText("SI");
		} else {
			btnsHideShow2.setText("NO");
			btnsHideShow2.setSelected(true);
		}
		btnsHideShow2.setBounds(415, 230, 80, 40);
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
					btnsHideShow2.setText("NO");
				else
					btnsHideShow2.setText("SI");
			}
		});

		// OPTION 3 CHANGE RESOLUTION
		JLabel op4 = new JLabel("RESOLUCIÓN");
		op4.setBounds(50, 160, 250, 40);
		op4.setFont(First.myFont);
		String res[] = { "OPTIMAL", "X-P", "P", "M", "G" };
		JComboBox<String> op2C = new JComboBox<>(res);
		op2C.setRenderer(dlcr);
		op2C.setBounds(365, 160, 180, 40);
		op2C.setFont(First.myFont);
		op2C.setBackground(First.lightC);
		op2C.setForeground(First.blueD);
		if (conf[3] != null)
			op2C.setSelectedIndex(Integer.valueOf(conf[3]));
		op2C.addActionListener(e -> {
			op2C.setSelectedIndex(op2C.getSelectedIndex());
			// Resolution
			if (op2C.getSelectedIndex() == 0) {
				opResolution(clearEverthing, pesosF, notasF, newDay, resoD, aggPanel, gastosPanel);
			} else if (op2C.getSelectedIndex() == 1)
				resXP(resoD, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel);
			else if (op2C.getSelectedIndex() == 2)
				resP(resoD, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel);
			else if (op2C.getSelectedIndex() == 3)
				resM(resoD, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel);
			else
				resG(resoD, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel);
		});
		// OPTION 5 AUTOSAVE
		JLabel op5 = new JLabel("AUTOGUARDAR");
		op5.setBounds(50, 300, 200, 40);
		op5.setFont(First.myFont);
		JToggleButton btnsHideShow3 = new JToggleButton();
		if (conf[4] == null || conf[4].equals("false")) {
			btnsHideShow3.setText("SI");
		} else {
			btnsHideShow3.setText("NO");
			btnsHideShow3.setSelected(true);
		}
		btnsHideShow3.setBounds(415, 300, 80, 40);
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
		// OP6 slider speed summary
		JLabel op6 = new JLabel("VELOCIDAD DE ANIMACIÓN");
		op6.setFont(First.myFont);
		op6.setBounds(50, 370, 340, 40);
		JLabel speedValue = new JLabel("MEDIANO");
		speedValue.setBounds(415, 390, 80, 40);
		speedValue.setFont(First.myFontXS);
		JSlider speedSumm = new JSlider();
		speedSumm.setBackground(First.grisD);
		speedSumm.setBounds(415, 360, 80, 40);
		speedSumm.setMaximum(2);
		speedSumm.setMinimum(0);
		speedSumm.setMajorTickSpacing(1);
		if (conf[6] == null || conf[6].equals("1")) {
			speedValue.setText("MEDIANO");
			speedSumm.setValue(1);
		} else if (conf[6].equals("0")) {
			speedSumm.setValue(0);
			speedValue.setText("LENTO");
		} else {
			speedSumm.setValue(2);
			speedValue.setText("RÁPIDO");
		}
		speedSumm.addChangeListener(e -> {
			if (speedSumm.getValue() == 0)
				speedValue.setText("LENTO");
			else if (speedSumm.getValue() == 1)
				speedValue.setText("MEDIANO");
			else
				speedValue.setText("RÁPIDO");
		});

		// Bottom line
		JButton defSet = new JButton("POR DEFECTO");
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
				op1C.setSelectedIndex(0);
				Reales.this.setIconImage(iconImages[0].getImage());
				btnsHideShow.setSelectedIndex(0);
				btnsHideShow2.setText("SI");
				btnsHideShow2.setSelected(false);
				op2C.setSelectedIndex(0);
				opResolution(clearEverthing, pesosF, notasF, newDay, resoD, aggPanel, gastosPanel);
				btnsHideShow3.setText("SI");
				btnsHideShow3.setSelected(false);
			}
		});
		// SAVE
		JButton save = new JButton("GUARDAR");
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
					savedF.write(op1C.getSelectedIndex() + System.lineSeparator());
					savedF.write(btnsHideShow.getSelectedIndex() + System.lineSeparator());
					savedF.write(btnsHideShow2.isSelected() + System.lineSeparator());
					savedF.write(op2C.getSelectedIndex() + System.lineSeparator());
					savedF.write(btnsHideShow3.isSelected() + System.lineSeparator());
					savedF.write(conf[5] + System.lineSeparator());
					savedF.write(speedSumm.getValue() + System.lineSeparator());
					savedF.close();
				} catch (Exception e2) {
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
		temp.add(btnsHideShow3);
		temp.add(op6);
		temp.add(speedSumm);
		temp.add(speedValue);
		temp.add(defSet);
		temp.add(save);
		temp.setVisible(true);
	}

	// Hide/show the buttons
	private void hideBtn(JButton notasF, JButton pesosF, JButton newDay, JButton clearEverthing, JMenuItem hideBtn) {
		if (pesosF.isShowing()) {
			pesosF.hide();
			clearEverthing.hide();
			notasF.hide();
			hideBtn.setText("MONSTRAR LOS BOTONES");
		} else {
			pesosF.show();
			clearEverthing.show();
			notasF.show();
			hideBtn.setText("ESCONDER LOS BOTONES");
		}
	}

	// Clear all
	private void clearAll() {
		int op = JOptionPane.showConfirmDialog(null, "¿QUIERES BORRAR TODO?", "BORRAR TODO",
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
			for (int i = 0; i < 10; i++)
				panelCnum[i].setText("");
			sumF();
		}
	}

	// NEW DAY
	private void newDay() {
		int op = JOptionPane.showConfirmDialog(null, "¿QUIERES EMPEZAR NUEVO DIA?", "NUEVO DIA",
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
			for (int i = 0; i < 5; i++)
				panelCnum[i].setText("");
			panelCnum[5].setText("" + nbOf20);
			sumF();
		}
	}

	// saveProgress
	private static void saveProgress() {
		try {
			FileWriter savedF = new FileWriter("cedros.txt");
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
			dataOpened = new BufferedReader(new FileReader(new File("cedros.txt")));
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
			aggBtn[0].setText("Más " + counter);
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
			aggBtn[1].setText("Más" + counter);
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
		// Calculate the diferencia
		if (totalCaja == totalO) {
			diffResult[1].setText("<html><center>No Hay Diferencia</html>");
			diffResult[1].setBackground(First.greenD);
			diffResult[1].setForeground(Color.white);
		} else {
			if (totalCaja > totalO) {
				diffResult[1].setText("Sobró R$" + (totalCaja - totalO));
				diffResult[1].setBackground(Color.orange);
				diffResult[1].setForeground(Color.black);
			} else {
				diffResult[1].setText("Faltó R$" + (totalO - totalCaja));
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
				// Hide
				if ((e.getKeyCode() == KeyEvent.VK_O) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0))
					hideBtn(notasF, pesosF, newDay, clearEverthing, hideBtn);
				else // Clear
				if ((e.getKeyCode() == KeyEvent.VK_B) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
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
				// Hide
				if ((e.getKeyCode() == KeyEvent.VK_O) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0))
					hideBtn(notasF, pesosF, newDay, clearEverthing, hideBtn);
				// GO TO Notas
				else if ((e.getKeyCode() == KeyEvent.VK_S) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
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
				// Hide
				if ((e.getKeyCode() == KeyEvent.VK_O) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0))
					hideBtn(notasF, pesosF, newDay, clearEverthing, hideBtn);
				// GO TO Notas
				else if ((e.getKeyCode() == KeyEvent.VK_S) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
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
				// Hide
				if ((e.getKeyCode() == KeyEvent.VK_O) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0))
					hideBtn(notasF, pesosF, newDay, clearEverthing, hideBtn);
				// GO TO Notas
				else if ((e.getKeyCode() == KeyEvent.VK_S) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
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

	// Resolution X-small
	private void resXP(JMenuItem resoD, JButton notasF, JButton pesosF, JButton newDay, JButton clearEverthing,
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
	private void resP(JMenuItem resoD, JButton notasF, JButton pesosF, JButton newDay, JButton clearEverthing,
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
	private void resM(JMenuItem resoD, JButton notasF, JButton pesosF, JButton newDay, JButton clearEverthing,
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
	private void resG(JMenuItem resoD, JButton notasF, JButton pesosF, JButton newDay, JButton clearEverthing,
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
			JOptionPane opt = new JOptionPane("NO HAY NADA PARA ARMAR!", JOptionPane.ERROR_MESSAGE);
			final JDialog dlg = opt.createDialog("Error");
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
		return keywords;
	}
}
