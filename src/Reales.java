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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.ColorUIResource;

@SuppressWarnings("serial")
public class Reales extends JFrame {

	static Font myFont = First.myFont;
	static Font myFontS = First.myFontS;
	static Color darkC = First.darkC;
	static Color lightC = First.lightC;
	static Color redC = new Color(254, 74, 74);
	static Color redD = new Color(161, 48, 48);
	static Color greenD = new Color(56, 161, 48);
	static Color greenC = new Color(74, 220, 63);
	static Border border = First.border;
	static int beta = 0;
	static int gama = 0;
	static int calcR;
	static int caja;
	static int restN;
	private URL u1000 = getClass().getResource("1000.jpg");
	private ImageIcon i1000 = new ImageIcon(u1000);
	private URL uS100 = getClass().getResource("s100.jpg");
	private ImageIcon iS100 = new ImageIcon(uS100);
	private URL u200 = getClass().getResource("200.jpg");
	private ImageIcon i200 = new ImageIcon(u200);
	private URL u100 = getClass().getResource("100.jpg");
	private ImageIcon i100 = new ImageIcon(u100);
	private URL u50 = getClass().getResource("50.jpg");
	private ImageIcon i50 = new ImageIcon(u50);
	private URL u20 = getClass().getResource("20.jpg");
	private ImageIcon i20 = new ImageIcon(u20);
	private URL u10 = getClass().getResource("10.jpg");
	private ImageIcon i10 = new ImageIcon(u10);
	private URL u5 = getClass().getResource("5.jpg");
	private ImageIcon i5 = new ImageIcon(u5);
	private URL u2 = getClass().getResource("2.jpg");
	private ImageIcon i2 = new ImageIcon(u2);
	private URL u1 = getClass().getResource("1.jpg");
	private ImageIcon i1 = new ImageIcon(u1);
	private URL umg = getClass().getResource("nextd.png");
	private ImageIcon mg = new ImageIcon(umg);
	private URL uclear = getClass().getResource("clear.png");
	private ImageIcon clear = new ImageIcon(uclear);
	private URL pesos = getClass().getResource("pesos.png");
	private ImageIcon pesosI = new ImageIcon(pesos);
	private URL notas = getClass().getResource("notas.png");
	private ImageIcon notasI = new ImageIcon(notas);
	static JTextField details[][] = new JTextField[5][15];// Numbers of notes
	static JTextField initialDay = new JTextField("0");// How much begin the day
	static JTextField agregadoTable[] = new JTextField[8];// Added to cash detailed
	static JTextField gastosTable[] = new JTextField[8];// Spend of the day detailed
	static JTextField panelCnum[] = new JTextField[10];
	// Define Parameter
	static JButton aggBtn[] = new JButton[2];// Combine the set of 1000 and 100
	static JLabel total[] = new JLabel[8];// Total of every column
	static JLabel boletoN[] = new JLabel[6]; // B1,2,3,4,5
	static JLabel summaryT[] = new JLabel[9];// Summary table
	static JLabel gastos = new JLabel("G A S T O S");// Spend of the day TITLE
	static JLabel agregado = new JLabel("A G R E G A D O");// Added to cash title
	static JLabel panelFoto[] = new JLabel[10];// Photo row
	static JLabel[] diffResult = new JLabel[2];// calculate the difference
	static JLabel[] restTmrw = new JLabel[2];// rest for tomorrow
	int width;
	int height;

	Reales() {
		// Dimension
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int) screenSize.getWidth();
		height = (int) screenSize.getHeight();

		// remove button focus border
		UIDefaults defaults = UIManager.getLookAndFeelDefaults();
		defaults.put("Button.focus", new ColorUIResource(new Color(0, 0, 0, 0)));

		// Define Frame
		this.setTitle("CIERRE DE CAJA - R$");
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setAlwaysOnTop(false);
		// Resolution
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
		this.getContentPane().setBackground(darkC);
		this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("icon.png")).getImage());
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
					for (int i = 0; i < 5; i++)
						for (int j = 0; j < 15; j++)
							details[i][j].setText("");
					initialDay.setText(restN + "");
					for (int i = 0; i < 8; i++)
						gastosTable[i].setText("");
					for (int i = 0; i < 8; i++)
						agregadoTable[i].setText("");
					for (int i = 0; i < 5; i++)
						panelCnum[i].setText("");
					sumF();
					System.exit(0);
				}
			}
		});

		ArrayList<String> keywords = listMercadoria();

		// Panel 1
		int temp;
		for (int i = 0; i < 5; i++) {
			temp = 0;
			boletoN[i] = new JLabel("B" + (i + 1));
			boletoN[i].setForeground(lightC);
			this.add(boletoN[i]);
			for (int j = 0; j < 15; j++) {
				details[i][j] = new JTextField("");
				textFieldStyle(details[i][j]);
				if (details[i][j].getText().equals("")) {
					temp += 0;
				}
				tableFocus(i, j, this);
				this.add(details[i][j]);
			}
			total[i] = new JLabel("");
			First.labelStyle(total[i]);
			total[i].setText(temp + "");
			this.add(total[i]);
		}
		boletoN[5] = new JLabel();
		boletoN[5].setForeground(lightC);
		this.add(boletoN[5]);
		total[5] = new JLabel("0");
		First.labelStyle(total[5]);
		total[5].setBackground(Color.black);
		total[5].setForeground(Color.white);
		this.add(total[5]);
		total[7] = new JLabel("Total");
		First.labelStyle(total[7]);
		total[7].setBackground(Color.white);
		total[7].setForeground(Color.black);
		this.add(total[7]);

		// Panel 2
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
		summaryT[0].setBackground(new Color(212, 212, 212));
		summaryT[0].setForeground(Color.black);
		summaryT[1].setBackground(redD);
		summaryT[1].setForeground(Color.white);
		summaryT[2].setBackground(greenD);
		summaryT[2].setForeground(Color.white);
		summaryT[3].setBackground(new Color(48, 107, 161));
		summaryT[3].setForeground(Color.white);
		summaryT[4].setBackground(Color.black);
		summaryT[4].setForeground(Color.white);
		textFieldStyle(initialDay);
		initialDay.setCaretColor(darkC);
		initialDay.setBackground(lightC);
		initialDay.setForeground(Color.black);
		iniFocus(this);
		this.add(initialDay);
		for (int i = 5; i < 9; i++) {
			summaryT[i] = new JLabel("0");
			summaryT[i].setForeground(lightC);
			summaryT[i].setBorder(border);
			summaryT[i].setFocusable(false);
			summaryT[i].setOpaque(true);
			summaryT[i].setHorizontalAlignment(0);
			this.add(summaryT[i]);
		}
		summaryT[5].setBackground(redC);
		summaryT[6].setBackground(greenC);
		summaryT[7].setBackground(new Color(70, 156, 235));
		summaryT[8].setBackground(new Color(80, 80, 80));

		// Panel 3 , gastos and agg
		First.labelStyle(gastos);
		gastos.setBackground(new Color(107, 35, 35));
		gastos.setForeground(Color.white);
		this.add(gastos);
		for (int i = 0; i < 4; i++) {
			gastosTable[i] = new JTextField();
			// Autocomplete
			AutoComplete autoComplete = new AutoComplete(gastosTable[i], keywords);
			gastosTable[i].getDocument().addDocumentListener(autoComplete);
			textFieldStyle(gastosTable[i]);
			gastosTable[i].setBackground(redD);
			gastosTable[i].setForeground(Color.white);
			gasFocus(i, this);
			this.add(gastosTable[i]);
		}
		for (int i = 4; i < 8; i++) {
			gastosTable[i] = new JTextField();
			textFieldStyle(gastosTable[i]);
			gastosTable[i].setBackground(redC);
			gastosTable[i].setForeground(Color.white);
			gasFocus(i, this);
			this.add(gastosTable[i]);
		}
		First.labelStyle(agregado);
		agregado.setBackground(new Color(30, 84, 25));
		agregado.setForeground(Color.white);
		this.add(agregado);
		for (int i = 0; i < 4; i++) {
			agregadoTable[i] = new JTextField();
			// Autocomplete
			AutoComplete autoComplete = new AutoComplete(agregadoTable[i], keywords);
			agregadoTable[i].getDocument().addDocumentListener(autoComplete);
			textFieldStyle(agregadoTable[i]);
			agregadoTable[i].setBackground(greenD);
			agregadoTable[i].setForeground(Color.white);
			aggFocus(i, this);
			this.add(agregadoTable[i]);
		}
		for (int i = 4; i < 8; i++) {
			agregadoTable[i] = new JTextField();
			textFieldStyle(agregadoTable[i]);
			agregadoTable[i].setBackground(greenC);
			agregadoTable[i].setForeground(Color.white);
			aggFocus(i, this);
			this.add(agregadoTable[i]);
		}

		// Panel 4
		for (int i = 0; i < 10; i++) {
			panelFoto[i] = new JLabel();
			First.labelStyle(panelFoto[i]);
			this.add(panelFoto[i]);
		}
		// Caja detailed
		for (int i = 0; i < 10; i++) {
			panelCnum[i] = new JTextField("0");
			textFieldStyle(panelCnum[i]);
			panelCnum[i].setCaretColor(darkC);
			panelCnum[i].setForeground(darkC);
			panelCnum[i].setBackground(lightC);
			cajaFocus(i, this);
			this.add(panelCnum[i]);
		}
		total[6] = new JLabel("TOTAL");// Total Label
		First.labelStyle(total[6]);
		total[6].setBackground(Color.black);
		total[6].setForeground(Color.white);
		this.add(total[6]);

		aggBtn[0] = new JButton();
		First.btnStyle(aggBtn[0]);
		aggBtn[0].setBackground(new Color(0x6fa39f));
		aggBtn[0].setForeground(Color.white);
		aggBtn[0].hide();
		aggBtn[0].addActionListener(e -> addSetMil());
		this.add(aggBtn[0]);
		aggBtn[1] = new JButton();
		First.btnStyle(aggBtn[1]);
		aggBtn[1].setBackground(new Color(0xd7841c));
		aggBtn[1].setForeground(Color.white);
		aggBtn[1].hide();
		aggBtn[1].addActionListener(e -> addSetHun());
		this.add(aggBtn[1]);

		// Panel 5
		diffResult[0] = new JLabel("Differencia");
		First.labelStyle(diffResult[0]);
		diffResult[0].setBackground(Color.black);
		diffResult[0].setForeground(lightC);
		this.add(diffResult[0]);
		diffResult[1] = new JLabel("No Hay Differencia");
		First.labelStyle(diffResult[1]);
		this.add(diffResult[1]);

		restTmrw[0] = new JLabel("Quedará para mañana");
		First.labelStyle(restTmrw[0]);
		restTmrw[0].setBackground(Color.black);
		restTmrw[0].setForeground(lightC);
		this.add(restTmrw[0]);
		restTmrw[1] = new JLabel("R$0");
		First.labelStyle(restTmrw[1]);
		this.add(restTmrw[1]);

		JButton notasF = new JButton();
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

		JButton pesosF = new JButton();
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
		JButton newDay = new JButton();// Every calculate
		JButton clearEverthing = new JButton();
		newDay.setFocusable(false);
		newDay.setOpaque(false);
		newDay.setContentAreaFilled(false);
		newDay.setBorderPainted(false);
		newDay.addActionListener(e -> newDay());
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
		JMenu file = new JMenu("ARCHIVO");
		JMenu goTo = new JMenu("IR A");
		JMenu help = new JMenu("AYUDA");
		JMenuItem novo = new JMenuItem("NOVO DIA");
		JMenuItem clear = new JMenuItem("BORRAR TODO");
		JMenuItem calc = new JMenuItem("ASUMAR");
		JMenuItem save = new JMenuItem("SALVAR");
		JMenuItem exit = new JMenuItem("SALIR");
		JMenuItem pesos = new JMenuItem("PESOS");
		JMenuItem fatura = new JMenuItem("FATURA");
		JMenuItem getHelp = new JMenuItem("ATAJOS DE TECLADO");
		JMenuItem hideBtn = new JMenuItem("ESCONDER LOS BOTONES");
		JMenuItem about = new JMenuItem("SOBRE EL APLICATIVO");
		novo.addActionListener(e -> newDay());
		calc.addActionListener(e -> sumF());
		clear.addActionListener(e -> clearAll());
		save.addActionListener(e -> saveProgress());
		hideBtn.addActionListener(e -> {
			hideBtn(notasF, pesosF, newDay, clearEverthing, hideBtn);
		});
		exit.addActionListener(e -> System.exit(0));
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
		getHelp.addActionListener(e -> JOptionPane.showMessageDialog(null,
				"• CTRL + S → ir la fatura.\n" + "• CTRL + P → ir al pesos.\n" + "• CTRL + B → borrar todo.\n"
						+ "• CTRL + N → prepárate para el día siguiente.\n"
						+ "• FLECHAS → subir, abajo, derecha e izquierda.\n" + "• CTRL + D → ir al detalles.\n"
						+ "• CTRL + I → ir al inicio.\n" + "• CTRL + G → ir al gastos.\n"
						+ "• CTRL + A → ir al agregado.\n" + "• CTRL + T → ir a la caja.\n"
						+ "• CTRL + E → ir al ultimo numero.\n" + "• CTRL + M → mas un 100 o de 1000 si posible.\n",
				"ATAJOS DE TECLADO", 1));
		about.addActionListener(
				e -> JOptionPane.showMessageDialog(null, "Crédito y Diseñado por MhmdSAbdlh ©", "SOBRE MI", 1));
		JMenu reso = new JMenu("RESOLUCIÓN");
		JMenuItem reso1 = new JMenuItem("GRANDE");
		JMenuItem reso2 = new JMenuItem("MEDIO");
		JMenuItem reso3 = new JMenuItem("PEQUENA");
		JMenuItem reso4 = new JMenuItem("X-PEQUENA");
		reso.add(reso4);
		reso.add(reso3);
		reso.add(reso2);
		reso.add(reso1);
		reso1.addActionListener(e -> resG(notasF, pesosF, newDay, clearEverthing));
		reso2.addActionListener(e -> resM(notasF, pesosF, newDay, clearEverthing));
		reso3.addActionListener(e -> resP(notasF, pesosF, newDay, clearEverthing));
		reso4.addActionListener(e -> resXP(notasF, pesosF, newDay, clearEverthing));
		file.add(novo);
		file.add(calc);
		file.add(clear);
		file.add(save);
		file.add(exit);
		goTo.add(pesos);
		goTo.add(fatura);
		help.add(getHelp);
		help.add(hideBtn);
		help.add(about);

		mb.add(file);
		mb.add(goTo);
		mb.add(reso);
		mb.add(help);
		this.setJMenuBar(mb);

		// Frame Run
		openProgress();
		sumF();
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
		if (width > 1800 && height > 1000) {
			resG(notasF, pesosF, newDay, clearEverthing);
		} else if (width > 1500 && height > 700)
			resM(notasF, pesosF, newDay, clearEverthing);
		else if (width > 1300 && height > 700)
			resP(notasF, pesosF, newDay, clearEverthing);
		else
			resXP(notasF, pesosF, newDay, clearEverthing);
	}

	private void hideBtn(JButton notasF, JButton pesosF, JButton newDay, JButton clearEverthing, JMenuItem hideBtn) {
		if (pesosF.isShowing()) {
			pesosF.hide();
			clearEverthing.hide();
			newDay.hide();
			notasF.hide();
			hideBtn.setText("MONSTRAR LOS BOTONES");
		} else {
			pesosF.show();
			clearEverthing.show();
			newDay.show();
			notasF.show();
			hideBtn.setText("ESCONDER LOS BOTONES");
		}
	}

	// Clear all
	private static void clearAll() {
		int op = JOptionPane.showConfirmDialog(null, "¿QUIERES BORRAR TODO?", "BORRAR TODO",
				JOptionPane.OK_CANCEL_OPTION);
		if (op == 0) {
			for (int i = 0; i < 5; i++)
				for (int j = 0; j < 15; j++)
					details[i][j].setText("");
			initialDay.setText("");
			for (int i = 0; i < 8; i++)
				gastosTable[i].setText("");
			for (int i = 0; i < 8; i++)
				agregadoTable[i].setText("");
			for (int i = 0; i < 10; i++)
				panelCnum[i].setText("");
			sumF();
		}
	}

	// NEW DAY
	private static void newDay() {
		int op = JOptionPane.showConfirmDialog(null, "¿QUIERES EMPEZAR NUEVO DIA?", "NUEVO DIA",
				JOptionPane.OK_CANCEL_OPTION);
		if (op == 0) {
			for (int i = 0; i < 5; i++)
				for (int j = 0; j < 15; j++)
					details[i][j].setText("");
			initialDay.setText(restN + "");
			for (int i = 0; i < 8; i++)
				gastosTable[i].setText("");
			for (int i = 0; i < 8; i++)
				agregadoTable[i].setText("");
			for (int i = 0; i < 5; i++)
				panelCnum[i].setText("");
			sumF();
		}
	}

	// Check the input text if it is a number
	private static boolean isNumeric(String number) {
		try {
			Integer.parseInt(number);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	// saveProgress
	private static void saveProgress() {
		try {
			FileWriter savedF = new FileWriter("cedros.txt");
			for (int i = 0; i < 5; i++)
				for (int j = 0; j < 15; j++)
					savedF.write(details[i][j].getText() + System.lineSeparator());
			savedF.write(initialDay.getText() + System.lineSeparator());
			for (int i = 0; i < 8; i++)
				savedF.write(gastosTable[i].getText() + System.lineSeparator());
			for (int i = 0; i < 8; i++)
				savedF.write(agregadoTable[i].getText() + System.lineSeparator());

			for (int i = 0; i < 10; i++)
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
		String numbers[] = new String[103];
		try {
			dataOpened = new BufferedReader(new FileReader(new File("cedros.txt")));
			while ((line = dataOpened.readLine()) != null) {
				numbers[z] = line.toString();
				z++;
			}
			z = 0;
			for (int i = 0; i < 5; i++)
				for (int k = 0; k < 15; k++) {
					details[i][k].setText(numbers[z]);
					z++;
				}
			initialDay.setText(numbers[z]);
			z++;
			for (int i = 0; i < 8; i++) {
				gastosTable[i].setText(numbers[z]);
				z++;
			}
			for (int i = 0; i < 8; i++) {
				agregadoTable[i].setText(numbers[z]);
				z++;
			}
			for (int i = 0; i < 10; i++) {
				panelCnum[i].setText(numbers[z]);
				z++;
			}
			dataOpened.close();
		} catch (Exception e) {
		}
	}

	// Add a set of 1000
	private static void addSetMil() {
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
	private static void addSetHun() {
		int numHun = Integer.valueOf(panelCnum[5].getText()) * 20;
		int counter = 0;
		while (numHun > 100) {
			numHun -= 100;
			counter++;
		}
		panelCnum[1].setText(Integer.valueOf(panelCnum[1].getText()) + counter + "");
		panelCnum[5].setText(Integer.valueOf(panelCnum[5].getText()) - 5 * counter + "");

		numHun = Integer.valueOf(panelCnum[6].getText()) * 10;
		counter = 0;
		while (numHun > 100) {
			numHun -= 100;
			counter++;
		}
		panelCnum[1].setText(Integer.valueOf(panelCnum[1].getText()) + counter + "");
		panelCnum[6].setText(Integer.valueOf(panelCnum[6].getText()) - 10 * counter + "");
		aggBtn[1].hide();
	}

	// Calculate everything
	private static void sumF() {
		saveProgress();
		for (int i = 0; i < 10; i++)// Caja empty values 0
			if (!isNumeric(panelCnum[i].getText()))
				panelCnum[i].setText(0 + "");
		if (!isNumeric(initialDay.getText()))// initial of the day 0
			initialDay.setText(0 + "");
		for (int i = 4; i < 8; i++)// spent 0
			if (!isNumeric(gastosTable[i].getText()))
				gastosTable[i].setText("");
		for (int i = 4; i < 8; i++)// added 0
			if (!isNumeric(agregadoTable[i].getText()))
				agregadoTable[i].setText("");
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
			aggBtn[0].setText("Mas " + counter);
		} else
			aggBtn[0].hide();
		// Add set of 100
		int numHund = Integer.valueOf(panelCnum[5].getText()) * 20;
		counter = 0;
		while (numHund > 100) {
			numHund -= 100;
			counter++;
		}
		numHund = Integer.valueOf(panelCnum[6].getText()) * 10;
		while (numHund > 100) {
			numHund -= 100;
			counter++;
		}
		if (counter > 0) {
			aggBtn[1].show();
			aggBtn[1].setText("Mas " + counter);
		} else
			aggBtn[1].hide();
		// Calculate the totals
		gama = 0;
		for (int i = 0; i < 5; i++) {
			beta = 0;
			for (int j = 0; j < 15; j++) {
				if (!isNumeric(details[i][j].getText())) {
					details[i][j].setText("");
					beta += 0;
				} else {
					beta += Integer.valueOf(details[i][j].getText());
				}
			}
			total[i].setText(beta + "");
			gama += Integer.valueOf(total[i].getText());
		}
		total[5].setText(gama + "");
		// Calculate total of spent
		summaryT[5].setText(((gastosTable[4].getText().equals("") ? 0 : Integer.valueOf(gastosTable[4].getText()))
				+ (gastosTable[5].getText().equals("") ? 0 : Integer.valueOf(gastosTable[5].getText()))
				+ (gastosTable[6].getText().equals("") ? 0 : Integer.valueOf(gastosTable[6].getText()))
				+ (gastosTable[7].getText().equals("") ? 0 : Integer.valueOf(gastosTable[7].getText()))) + "");
		// Calculate total of added
		summaryT[6].setText(((agregadoTable[4].getText().equals("") ? 0 : Integer.valueOf(agregadoTable[4].getText()))
				+ (agregadoTable[5].getText().equals("") ? 0 : Integer.valueOf(agregadoTable[5].getText()))
				+ (agregadoTable[6].getText().equals("") ? 0 : Integer.valueOf(agregadoTable[6].getText()))
				+ (agregadoTable[7].getText().equals("") ? 0 : Integer.valueOf(agregadoTable[7].getText()))) + "");

		summaryT[7].setText(total[5].getText());// Total of sells
		// Calculate total
		summaryT[8].setText(((initialDay.getText().equals("") ? 0 : Integer.valueOf(initialDay.getText()))
				- (summaryT[5].getText().equals("") ? 0 : Integer.valueOf(summaryT[5].getText()))
				+ (summaryT[6].getText().equals("") ? 0 : Integer.valueOf(summaryT[6].getText()))
				+ (summaryT[7].getText().equals("") ? 0 : Integer.valueOf(summaryT[7].getText()))) + "");
		// Calculate total of caja
		total[6].setText("" + ((panelCnum[0].getText().equals("") ? 0 : Integer.valueOf(panelCnum[0].getText()) * 1000)
				+ (panelCnum[1].getText().equals("") ? 0 : Integer.valueOf(panelCnum[1].getText()) * 100)
				+ (panelCnum[2].getText().equals("") ? 0 : Integer.valueOf(panelCnum[2].getText()) * 200)
				+ (panelCnum[3].getText().equals("") ? 0 : Integer.valueOf(panelCnum[3].getText()) * 100)
				+ (panelCnum[4].getText().equals("") ? 0 : Integer.valueOf(panelCnum[4].getText()) * 50)
				+ (panelCnum[5].getText().equals("") ? 0 : Integer.valueOf(panelCnum[5].getText()) * 20)
				+ (panelCnum[6].getText().equals("") ? 0 : Integer.valueOf(panelCnum[6].getText()) * 10)
				+ (panelCnum[7].getText().equals("") ? 0 : Integer.valueOf(panelCnum[7].getText()) * 5)
				+ (panelCnum[8].getText().equals("") ? 0 : Integer.valueOf(panelCnum[8].getText()) * 2)
				+ (panelCnum[9].getText().equals("") ? 0 : Integer.valueOf(panelCnum[9].getText()) * 1)));
		// Calculate the diferencia
		caja = Integer.valueOf(total[6].getText());
		calcR = Integer.valueOf(summaryT[8].getText());
		if (caja == calcR) {
			diffResult[1].setText("<html><center>No hay diferencia<br>Todo Bien</html>");
			diffResult[1].setBackground(greenD);
			diffResult[1].setForeground(Color.white);
		} else {
			if (caja > calcR) {
				diffResult[1].setText("Sobro R$" + (caja - calcR));
				diffResult[1].setBackground(Color.orange);
				diffResult[1].setForeground(Color.black);
			} else {
				diffResult[1].setText("Falto R$" + (-caja + calcR));
				diffResult[1].setBackground(redD);
				diffResult[1].setForeground(Color.white);
			}
		}
		// Calculate the restTmrw
		restN = caja - Integer.valueOf(panelCnum[0].getText()) * 1000 - Integer.valueOf(panelCnum[1].getText()) * 100
				- Integer.valueOf(panelCnum[2].getText()) * 200 - Integer.valueOf(panelCnum[3].getText()) * 100
				- Integer.valueOf(panelCnum[4].getText()) * 50;
		if (restN > 200)
			restN -= (20 * Integer.valueOf(panelCnum[5].getText()));
		restTmrw[1].setText("R$" + restN);
		restTmrw[1].setForeground(Color.black);
		restTmrw[1].setBackground(lightC);
	}

	// Key listener for the table
	private static void tableFocus(int i, int j, JFrame frame) {
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
				} else// Clear
				if ((e.getKeyCode() == KeyEvent.VK_B) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					clearAll();
				} else// new day
				if ((e.getKeyCode() == KeyEvent.VK_N) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					newDay();
				} else// Direction
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (i < 4) {
						details[i][j].setNextFocusableComponent(details[i + 1][j]);
						details[i][j].nextFocus();
					} else {
						if (j != 14) {
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
							details[i][j].setNextFocusableComponent(details[4][j - 1]);
							details[i][j].nextFocus();
						} else {
							details[i][j].setNextFocusableComponent(details[4][14]);
							details[i][j].nextFocus();
						}
					}
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (j > 0) {
						details[i][j].setNextFocusableComponent(details[i][j - 1]);
						details[i][j].nextFocus();
					} else {
						if (i != 0) {
							details[i][j].setNextFocusableComponent(details[i - 1][14]);
							details[i][j].nextFocus();
						} else {
							details[i][j].setNextFocusableComponent(details[4][14]);
							details[i][j].nextFocus();
						}
					}
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					if (j < 14) {
						details[i][j].setNextFocusableComponent(details[i][j + 1]);
						details[i][j].nextFocus();
					} else {
						if (i != 4) {
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
				} else // M for add set 100 and 1000
				if ((e.getKeyCode() == KeyEvent.VK_M) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0))
					if (aggBtn[0].isShowing() && aggBtn[1].isShowing()) {
						addSetMil();
						addSetHun();
					} else if (aggBtn[0].isShowing())
						addSetMil();
					else if (aggBtn[1].isShowing())
						addSetHun();
			}
		});
	}

	// Key listener for the initial
	private void iniFocus(JFrame frame) {
		initialDay.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// GO TO Notas
				if ((e.getKeyCode() == KeyEvent.VK_S) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					saveProgress();
					frame.dispose();
					FaturaR.totalC.setText("0");
					FaturaR.total.setText("0");
					new FaturaR();
				}
				// GO TO pesos
				if ((e.getKeyCode() == KeyEvent.VK_P) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					saveProgress();
					frame.dispose();
					new Pesos();
				} else // Clear
				if ((e.getKeyCode() == KeyEvent.VK_B) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					clearAll();
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
					initialDay.setNextFocusableComponent(panelCnum[0]);
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
			}
		});
	}

	// Key listener for the ADDITION
	private static void aggFocus(int i, JFrame frame) {
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
					if (i > 0) {
						agregadoTable[i].setNextFocusableComponent(agregadoTable[i - 1]);
						agregadoTable[i].nextFocus();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					if (i < 7) {
						agregadoTable[i].setNextFocusableComponent(agregadoTable[i + 1]);
						agregadoTable[i].nextFocus();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (i < 4) {
						agregadoTable[i].setNextFocusableComponent(agregadoTable[i + 4]);
						agregadoTable[i].nextFocus();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (i > 3) {
						agregadoTable[i].setNextFocusableComponent(agregadoTable[i - 4]);
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
			}
		});
	}

	// Key listener for the SPENT
	private static void gasFocus(int i, JFrame frame) {
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
				} else// direction
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (i > 0) {
						gastosTable[i].setNextFocusableComponent(gastosTable[i - 1]);
						gastosTable[i].nextFocus();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					if (i < 7) {
						gastosTable[i].setNextFocusableComponent(gastosTable[i + 1]);
						gastosTable[i].nextFocus();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (i < 4) {
						gastosTable[i].setNextFocusableComponent(gastosTable[i + 4]);
						gastosTable[i].nextFocus();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (i > 3) {
						gastosTable[i].setNextFocusableComponent(gastosTable[i - 4]);
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

			}
		});
	}

	// Key listener for the CASH
	private static void cajaFocus(int i, JFrame frame) {
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
			}
		});
	}

	// Style of textField
	private static void textFieldStyle(JTextField tf) {
		tf.setBackground(darkC);
		tf.setForeground(lightC);
		tf.setFont(myFont);
		tf.setBorder(border);
		tf.setHorizontalAlignment(0);
		tf.setCaretColor(lightC);
		tf.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				((JTextField) e.getSource()).selectAll();
			}

			@Override
			public void focusLost(FocusEvent e) {
				sumF();
			}
		});

	}

	private void resXP(JButton notasF, JButton pesosF, JButton newDay, JButton clearEverthing) {
		this.setSize(1000, 600);
		myFont = new Font("Tahoma", Font.BOLD, 16);
		myFontS = new Font("Tahoma", Font.BOLD, 12);
		for (int i = 0; i < 5; i++) {
			boletoN[i].setBounds(50 + i * 68, 5, 170, 40);
			boletoN[i].setFont(myFont);
			total[i].setBounds(25 + i * 70, 500, 60, 24);
			total[i].setFont(myFont);
			for (int j = 0; j < 15; j++) {
				details[i][j].setFont(myFontS);
				details[i][j].setBounds(30 + i * 70, 50 + j * 29, 50, 22);
			}
		}
		boletoN[5].setText("__________________________________");
		boletoN[5].setBounds(25, 472, 460, 20);
		total[5].setBounds(390, 500, 58, 30);
		total[7].setBounds(390, 470, 58, 30);
		boletoN[5].setFont(myFont);
		total[5].setFont(myFont);
		initialDay.setFont(myFont);
		total[7].setFont(myFont);
		for (int i = 0; i < 5; i++) {
			summaryT[i].setBounds(420, 50 + i * 30, 100, 30);
			summaryT[i].setFont(myFont);
		}
		initialDay.setBounds(520, 50, 70, 30);
		for (int i = 5; i < 9; i++) {
			summaryT[i].setBounds(520, 50 + (i - 4) * 30, 70, 30);
			summaryT[i].setFont(myFont);
		}
		gastos.setBounds(620, 50, 150, 30);
		agregado.setBounds(800, 50, 150, 30);
		gastos.setFont(myFont);
		agregado.setFont(myFont);
		for (int i = 0; i < 4; i++) {
			gastosTable[i].setBounds(620, 80 + 30 * i, 100, 30);
			agregadoTable[i].setBounds(800, 80 + 30 * i, 100, 30);
			gastosTable[i].setFont(myFont);
			agregadoTable[i].setFont(myFont);
		}
		for (int i = 4; i < 8; i++) {
			gastosTable[i].setBounds(720, 80 + 30 * (i - 4), 50, 30);
			agregadoTable[i].setBounds(900, 80 + 30 * (i - 4), 50, 30);
			gastosTable[i].setFont(myFontS);
			agregadoTable[i].setFont(myFontS);
		}
		for (int i = 0; i < 10; i++) {
			panelFoto[i].setBounds(430 + 50 * i, 240, 50, 40);
			panelCnum[i].setBounds(430 + 50 * i, 280, 50, 40);
			panelCnum[i].setFont(myFont);
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
		aggBtn[0].setBounds(430, 220, 50, 20);
		aggBtn[1].setBounds(480, 220, 50, 20);
		total[6].setBounds(430, 320, 500, 40);
		diffResult[0].setBounds(500, 420, 150, 30);
		diffResult[1].setBounds(500, 449, 150, 40);
		restTmrw[0].setBounds(750, 420, 150, 40);
		restTmrw[1].setBounds(750, 459, 150, 30);
		aggBtn[0].setFont(myFontS);
		aggBtn[1].setFont(myFontS);
		total[6].setFont(myFont);
		diffResult[0].setFont(myFontS);
		diffResult[1].setFont(myFontS);
		restTmrw[0].setFont(myFontS);
		restTmrw[1].setFont(myFontS);
		notasF.setBounds(670, 470, 50, 50);
		pesosF.setBounds(670, 410, 50, 35);
		newDay.setBounds(920, 430, 50, 50);
		clearEverthing.setBounds(400, 400, 50, 50);
		notasF.setIcon(new ImageIcon(getScaledImage(notasI.getImage(), 50, 50)));
		pesosF.setIcon(new ImageIcon(getScaledImage(pesosI.getImage(), 50, 35)));
		newDay.setIcon(new ImageIcon(getScaledImage(mg.getImage(), 50, 50)));
		clearEverthing.setIcon(new ImageIcon(getScaledImage(clear.getImage(), 50, 50)));
	}

	private void resP(JButton notasF, JButton pesosF, JButton newDay, JButton clearEverthing) {
		this.setSize(1300, 700);
		myFont = new Font("Tahoma", Font.BOLD, 18);
		myFontS = new Font("Tahoma", Font.BOLD, 15);
		for (int i = 0; i < 5; i++) {
			boletoN[i].setBounds(60 + i * 88, 5, 200, 50);
			boletoN[i].setFont(myFont);
			total[i].setBounds(30 + i * 90, 600, 70, 29);
			for (int j = 0; j < 15; j++) {
				details[i][j].setBounds(30 + i * 90, 55 + j * 35, 70, 25);
				details[i][j].setFont(myFontS);
			}
		}
		boletoN[5].setText("________________________________________");
		boletoN[5].setBounds(25, 550, 570, 50);
		total[5].setBounds(500, 590, 88, 35);
		total[7].setBounds(500, 560, 88, 30);
		boletoN[5].setFont(myFont);
		total[5].setFont(myFont);
		initialDay.setFont(myFont);
		total[7].setFont(myFont);
		for (int i = 0; i < 5; i++) {
			summaryT[i].setBounds(550, 50 + i * 40, 120, 40);
			summaryT[i].setFont(myFont);
		}
		initialDay.setBounds(670, 50, 80, 40);
		for (int i = 5; i < 9; i++) {
			summaryT[i].setBounds(670, 50 + (i - 4) * 40, 80, 40);
			summaryT[i].setFont(myFont);
		}
		gastos.setBounds(800, 50, 210, 40);
		agregado.setBounds(1050, 50, 210, 40);
		gastos.setFont(myFont);
		agregado.setFont(myFont);
		for (int i = 0; i < 4; i++) {
			gastosTable[i].setBounds(800, 90 + 40 * i, 150, 40);
			agregadoTable[i].setBounds(1050, 90 + 40 * i, 150, 40);
			gastosTable[i].setFont(myFont);
			agregadoTable[i].setFont(myFont);
		}
		for (int i = 4; i < 8; i++) {
			gastosTable[i].setBounds(950, 90 + 40 * (i - 4), 60, 40);
			agregadoTable[i].setBounds(1200, 90 + 40 * (i - 4), 60, 40);
			gastosTable[i].setFont(myFontS);
			agregadoTable[i].setFont(myFontS);
		}
		for (int i = 0; i < 10; i++) {
			panelFoto[i].setBounds(580 + 60 * i, 300, 60, 40);
			panelCnum[i].setBounds(580 + 60 * i, 340, 60, 40);
			panelCnum[i].setFont(myFont);
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
		aggBtn[0].setBounds(580, 280, 60, 20);
		aggBtn[1].setBounds(640, 280, 60, 20);
		total[6].setBounds(580, 380, 600, 40);
		diffResult[0].setBounds(620, 480, 200, 40);
		diffResult[1].setBounds(620, 519, 200, 50);
		restTmrw[0].setBounds(950, 480, 210, 50);
		restTmrw[1].setBounds(950, 529, 210, 40);
		aggBtn[0].setFont(myFontS);
		aggBtn[1].setFont(myFontS);
		total[6].setFont(myFont);
		diffResult[0].setFont(myFont);
		diffResult[1].setFont(myFont);
		restTmrw[0].setFont(myFont);
		restTmrw[1].setFont(myFont);
		notasF.setBounds(850, 550, 60, 60);
		pesosF.setBounds(850, 460, 60, 43);
		newDay.setBounds(1180, 490, 70, 70);
		clearEverthing.setBounds(510, 470, 60, 60);
		notasF.setIcon(new ImageIcon(getScaledImage(notasI.getImage(), 60, 60)));
		pesosF.setIcon(new ImageIcon(getScaledImage(pesosI.getImage(), 60, 43)));
		newDay.setIcon(new ImageIcon(getScaledImage(mg.getImage(), 70, 70)));
		clearEverthing.setIcon(new ImageIcon(getScaledImage(clear.getImage(), 60, 60)));
	}

	private void resM(JButton notasF, JButton pesosF, JButton newDay, JButton clearEverthing) {
		this.setSize(1500, 800);
		myFont = First.myFont;
		myFontS = First.myFontS;
		for (int i = 0; i < 5; i++) {
			boletoN[i].setBounds(60 + i * 100, 5, 200, 50);
			boletoN[i].setFont(myFont);
			total[i].setBounds(25 + i * 100, 690, 90, 32);
			total[i].setFont(myFont);
			for (int j = 0; j < 15; j++) {
				details[i][j].setBounds(30 + i * 100, 55 + j * 40, 80, 30);
				details[i][j].setFont(myFontS);
			}
		}
		boletoN[5].setText("______________________________________");
		boletoN[5].setBounds(25, 632, 600, 50);
		total[5].setBounds(540, 680, 98, 35);
		total[7].setBounds(540, 650, 98, 30);
		boletoN[5].setFont(myFont);
		total[5].setFont(myFont);
		initialDay.setFont(myFont);
		total[7].setFont(myFont);
		for (int i = 0; i < 5; i++) {
			summaryT[i].setFont(myFont);
			summaryT[i].setBounds(570, 50 + i * 50, 140, 50);
		}
		initialDay.setBounds(710, 50, 90, 50);
		for (int i = 5; i < 9; i++) {
			summaryT[i].setFont(myFont);
			summaryT[i].setBounds(710, 50 + (i - 4) * 50, 90, 50);
		}
		gastos.setBounds(870, 50, 230, 50);
		agregado.setBounds(1170, 50, 230, 50);
		gastos.setFont(myFont);
		agregado.setFont(myFont);
		for (int i = 0; i < 4; i++) {
			gastosTable[i].setBounds(870, 100 + 50 * i, 160, 50);
			agregadoTable[i].setBounds(1170, 100 + 50 * i, 160, 50);
			gastosTable[i].setFont(myFont);
			agregadoTable[i].setFont(myFont);
		}
		for (int i = 4; i < 8; i++) {
			gastosTable[i].setBounds(1030, 100 + 50 * (i - 4), 70, 50);
			agregadoTable[i].setBounds(1330, 100 + 50 * (i - 4), 70, 50);
			gastosTable[i].setFont(myFontS);
			agregadoTable[i].setFont(myFontS);
		}
		for (int i = 0; i < 10; i++) {
			panelFoto[i].setBounds(640 + 70 * i, 360, 70, 50);
			panelCnum[i].setBounds(640 + 70 * i, 410, 70, 50);
			panelCnum[i].setFont(myFont);
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
		aggBtn[0].setBounds(640, 331, 70, 30);
		aggBtn[1].setBounds(710, 331, 70, 30);
		total[6].setBounds(640, 460, 700, 50);
		diffResult[0].setBounds(680, 570, 250, 50);
		diffResult[1].setBounds(680, 620, 250, 60);
		restTmrw[0].setBounds(1070, 570, 250, 60);
		restTmrw[1].setBounds(1070, 620, 250, 50);
		notasF.setBounds(960, 650, 70, 70);
		pesosF.setBounds(960, 550, 70, 50);
		newDay.setBounds(1350, 580, 70, 70);
		clearEverthing.setBounds(550, 540, 70, 70);
		aggBtn[0].setFont(myFontS);
		aggBtn[1].setFont(myFontS);
		total[6].setFont(myFont);
		diffResult[0].setFont(myFont);
		diffResult[1].setFont(myFont);
		restTmrw[0].setFont(myFont);
		restTmrw[1].setFont(myFont);
		notasF.setIcon(new ImageIcon(getScaledImage(notasI.getImage(), 70, 70)));
		pesosF.setIcon(new ImageIcon(getScaledImage(pesosI.getImage(), 70, 50)));
		newDay.setIcon(new ImageIcon(getScaledImage(mg.getImage(), 70, 70)));
		clearEverthing.setIcon(new ImageIcon(getScaledImage(clear.getImage(), 70, 70)));
	}

	private void resG(JButton notasF, JButton pesosF, JButton newDay, JButton clearEverthing) {
		this.setSize(1820, 980);
		myFont = new Font("Tahoma", Font.BOLD, 24);
		myFontS = new Font("Tahoma", Font.BOLD, 20);
		for (int i = 0; i < 5; i++) {
			boletoN[i].setBounds(60 + i * 120, 5, 200, 50);
			boletoN[i].setFont(myFontS);
			total[i].setBounds(25 + i * 120, 850, 90, 32);
			total[i].setFont(myFontS);
			for (int j = 0; j < 15; j++) {
				details[i][j].setBounds(30 + i * 120, 65 + j * 50, 80, 35);
				details[i][j].setFont(myFontS);
			}
		}
		boletoN[5].setText("______________________________________");
		boletoN[5].setBounds(25, 790, 600, 50);
		total[5].setBounds(625, 830, 98, 45);
		total[7].setBounds(625, 790, 98, 40);
		boletoN[5].setFont(myFont);
		total[5].setFont(myFont);
		initialDay.setFont(myFont);
		total[7].setFont(myFont);

		for (int i = 0; i < 5; i++) {
			summaryT[i].setBounds(700, 50 + i * 60, 160, 60);
			summaryT[i].setFont(myFont);
		}
		initialDay.setBounds(860, 50, 110, 60);
		for (int i = 5; i < 9; i++) {
			summaryT[i].setBounds(860, 50 + (i - 4) * 60, 110, 60);
			summaryT[i].setFont(myFont);
		}
		gastos.setBounds(1100, 50, 270, 60);
		gastos.setFont(myFont);
		agregado.setFont(myFont);
		for (int i = 0; i < 4; i++) {
			gastosTable[i].setBounds(1100, 110 + 60 * i, 180, 60);
			agregadoTable[i].setBounds(1500, 110 + 60 * i, 180, 60);
			gastosTable[i].setFont(myFontS);
			agregadoTable[i].setFont(myFontS);
		}
		for (int i = 4; i < 8; i++) {
			gastosTable[i].setBounds(1280, 110 + 60 * (i - 4), 90, 60);
			agregadoTable[i].setBounds(1680, 110 + 60 * (i - 4), 90, 60);
			gastosTable[i].setFont(myFontS);
			agregadoTable[i].setFont(myFontS);
		}
		agregado.setBounds(1500, 50, 270, 60);
		for (int i = 0; i < 10; i++) {
			panelFoto[i].setBounds(800 + 80 * i, 450, 80, 60);
			panelCnum[i].setBounds(800 + 80 * i, 510, 80, 60);
			panelCnum[i].setFont(myFont);
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
		total[6].setBounds(800, 570, 800, 60);
		aggBtn[0].setBounds(800, 412, 80, 40);
		aggBtn[1].setBounds(880, 412, 80, 40);
		diffResult[0].setBounds(850, 700, 250, 60);
		diffResult[1].setBounds(850, 759, 250, 70);
		restTmrw[0].setBounds(1270, 700, 300, 70);
		restTmrw[1].setBounds(1270, 769, 300, 60);
		notasF.setBounds(1150, 800, 70, 70);
		pesosF.setBounds(1150, 670, 70, 70);
		newDay.setBounds(1650, 750, 80, 80);
		clearEverthing.setBounds(650, 650, 70, 70);
		aggBtn[0].setFont(myFontS);
		aggBtn[1].setFont(myFontS);
		total[6].setFont(myFont);
		diffResult[0].setFont(myFont);
		diffResult[1].setFont(myFont);
		restTmrw[0].setFont(myFontS);
		restTmrw[1].setFont(myFontS);
		notasF.setIcon(new ImageIcon(getScaledImage(notasI.getImage(), 70, 70)));
		pesosF.setIcon(new ImageIcon(getScaledImage(pesosI.getImage(), 70, 70)));
		newDay.setIcon(new ImageIcon(getScaledImage(mg.getImage(), 80, 80)));
		clearEverthing.setIcon(new ImageIcon(getScaledImage(clear.getImage(), 70, 70)));
	}

	private Image getScaledImage(Image srcImg, int w, int h) {
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(srcImg, 0, 0, w, h, null);
		g2.dispose();

		return resizedImg;
	}

	private ArrayList<String> listMercadoria() {
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
		return keywords;
	}
}