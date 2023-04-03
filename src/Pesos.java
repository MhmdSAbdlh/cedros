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
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.ColorUIResource;

@SuppressWarnings("serial")
public class Pesos extends JFrame {

	static Font myFont = First.myFont;
	static Font myFontS = First.myFontS;
	static Color darkC = First.darkC;
	static Color lightC = First.lightC;
	static Color redC = new Color(254, 74, 74);
	static Color redD = new Color(161, 48, 48);
	static Color greenD = new Color(56, 161, 48);
	static Color greenC = new Color(74, 220, 63);
	static Border border = First.border;
	static int totalCol = 0, totalVenta = 0, totalO = 0;
	static int gastosT = 0, agregadoT = 0;
	static int restN, totalCaja = 0;
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
	private URL umg = getClass().getResource("images/nextd.png");
	private ImageIcon mg = new ImageIcon(umg);
	private URL uclear = getClass().getResource("images/clear.png");
	private ImageIcon clear = new ImageIcon(uclear);
	private URL reales = getClass().getResource("images/reales.png");
	private ImageIcon realesI = new ImageIcon(reales);
	static JTextField details[][] = new JTextField[5][15];// Numbers of notes
	static JTextField initialDay = new JTextField("0");// How much begin the day
	static JTextField agregadoTable[] = new JTextField[8];// Added to cash detailed
	static JTextField gastosTable[] = new JTextField[8];// Spend of the day detailed
	static JTextField panelCnum[] = new JTextField[11];
	// Define Parameter
	static JLabel total[] = new JLabel[8];// Total of every column
	static JLabel boletoN[] = new JLabel[6]; // B1,2,3,4,5
	static JLabel summaryT[] = new JLabel[9];// Summary table
	static JLabel gastos = new JLabel("G A S T O S");// Spend of the day TITLE
	static JLabel agregado = new JLabel("A G R E G A D O");// Added to cash title
	JLabel panelFoto[] = new JLabel[11];// Photo row
	static JLabel[] diffResult = new JLabel[2];// calculate the difference
	static JLabel[] restTmrw = new JLabel[2];// rest for tomorrow
	int width;
	int height;

	Pesos() {
		// Dimension
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int) screenSize.getWidth();
		height = (int) screenSize.getHeight();

		// remove button focus border
		UIDefaults defaults = UIManager.getLookAndFeelDefaults();
		defaults.put("Button.focus", new ColorUIResource(new Color(0, 0, 0, 0)));

		// Define Frame
		this.setTitle("CIERRE DE CAJA - $");
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				Object[] options = { "Si", "No", "Si /Nuevo Dia" };
				int selectedOption = JOptionPane.showOptionDialog(null, "¿Seguro que quieres salir?", "SALIR",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

				if (selectedOption == 0)
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
					for (int i = 0; i < 2; i++)
						panelCnum[i].setText("");
					sumF();
					System.exit(0);
				}
			}
		});

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
		this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/icon.png")).getImage());
		int temp;
		ArrayList<String> keywords = listMercadoria();

		// Panel 1
		for (int i = 0; i < 5; i++) {
			temp = 0;
			boletoN[i] = new JLabel("B" + (i + 1));
			boletoN[i].setForeground(lightC);
			this.add(boletoN[i]);
			for (int j = 0; j < 15; j++) {
				details[i][j] = new JTextField("");
				textFieldStyle(details[i][j]);
				if (details[i][j].getText().equals(""))
					temp += 0;
				tableFocus(i, j, this);
				this.add(details[i][j]);
			}
			total[i] = new JLabel("");
			First.labelStyle(total[i]);
			total[i].setText(temp + "");
			this.add(total[i]);
		}
		boletoN[5] = new JLabel("______________________________________");
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
		initialDay.setBackground(lightC);
		initialDay.setForeground(Color.black);
		initialDay.setCaretColor(darkC);
		initialDay.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// Clear
				if ((e.getKeyCode() == KeyEvent.VK_C) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					clearAll();
				}
				// GO TO GASTOS
				if ((e.getKeyCode() == KeyEvent.VK_G) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					initialDay.setNextFocusableComponent(gastosTable[0]);
					initialDay.nextFocus();
				}
				// GO TO AGG
				if ((e.getKeyCode() == KeyEvent.VK_A) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					initialDay.setNextFocusableComponent(agregadoTable[0]);
					initialDay.nextFocus();
				}
				// GO TO Details
				if ((e.getKeyCode() == KeyEvent.VK_D) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					initialDay.setNextFocusableComponent(details[0][0]);
					initialDay.nextFocus();
				}
				// GO TO Troco
				if ((e.getKeyCode() == KeyEvent.VK_T) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					initialDay.setNextFocusableComponent(panelCnum[0]);
					initialDay.nextFocus();
				}
			}
		});
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

		// Panel 3
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
			gastosTable[i].setFont(myFontS);
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
			agregadoTable[i].setFont(myFontS);
			aggFocus(i, this);
			this.add(agregadoTable[i]);
		}

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
			panelCnum[i].setForeground(darkC);
			panelCnum[i].setBackground(lightC);
			panelCnum[i].setCaretColor(darkC);
			cajaFocus(i, this);
			this.add(panelCnum[i]);
		}
		total[6] = new JLabel("TOTAL");// Total Label
		First.labelStyle(total[6]);
		total[6].setBackground(Color.black);
		total[6].setForeground(Color.white);
		this.add(total[6]);

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
		restTmrw[1] = new JLabel("$0");
		First.labelStyle(restTmrw[1]);
		this.add(restTmrw[1]);

//		JButton notasF = new JButton();
//		notasF.setBounds(800, 650, 70, 70);
//		notasF.setFocusable(true);
//		notasF.setOpaque(false);
//		notasF.setContentAreaFilled(false);
//		notasF.setBorderPainted(false);
//		notasF.setIcon(notasI);
//		notasF.addActionListener(e -> {
//			saveProgress();
//			this.dispose();
//			new Notas();
//		});
//		this.add(notasF);

		JButton realesF = new JButton();
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
		JMenuItem reales = new JMenuItem("REALES");
		// JMenuItem fatura = new JMenuItem("BORRAR TODO");
		JMenuItem getHelp = new JMenuItem("ATAJOS DE TECLADO");
		JMenuItem hideBtn = new JMenuItem("ESCONDER LOS BOTONES");
		JMenuItem about = new JMenuItem("SOBRE EL APLICATIVO");
		novo.addActionListener(e -> newDay());
		calc.addActionListener(e -> sumF());
		clear.addActionListener(e -> clearAll());
		save.addActionListener(e -> saveProgress());
		exit.addActionListener(e -> System.exit(0));
		reales.addActionListener(e -> {
			saveProgress();
			new Reales();
			this.dispose();
		});
		getHelp.addActionListener(e -> JOptionPane.showMessageDialog(null,
				// "• CTRL + S → ir la fatura.\n"
				"• CTRL + R → ir al reales.\n" + "• CTRL + B → borrar todo.\n"
						+ "• CTRL + N → prepárate para el día siguiente.\n"
						+ "• FLECHAS → subir, abajo, derecha e izquierda.\n" + "• CTRL + D → ir al detalles.\n"
						+ "• CTRL + I → ir al inicio.\n" + "• CTRL + G → ir al gastos.\n"
						+ "• CTRL + A → ir al agregado.\n" + "• CTRL + T → ir a la caja.\n"
						+ "• CTRL + E → ir al ultimo numero.\n",
				"ATAJOS DE TECLADO", 1));
		hideBtn.addActionListener(e -> {
			if (realesF.isShowing()) {
				realesF.hide();
				clearEverthing.hide();
				newDay.hide();
				hideBtn.setText("MONSTRAR LOS BOTONES");
			} else {
				realesF.show();
				clearEverthing.show();
				newDay.show();
				hideBtn.setText("ESCONDER LOS BOTONES");
			}
		});
		about.addActionListener(
				e -> JOptionPane.showMessageDialog(null, "Crédito y Diseñado por MhmdSAbdlh ©", "SOBRE MI", 1));
		JMenu reso = new JMenu("RESOLUCIÓN");
		JMenuItem resoD = new JMenuItem("ÓPTIMO");
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
		resoD.addActionListener(e -> {
			if (width > 1800 && height > 1000) {
				resG(resoD, realesF, newDay, clearEverthing);
			} else if (width > 1500 && height > 700)
				resM(resoD, realesF, newDay, clearEverthing);
			else if (width > 1300 && height > 700)
				resP(resoD, realesF, newDay, clearEverthing);
			else
				resXP(resoD, realesF, newDay, clearEverthing);
		});
		reso1.addActionListener(e -> resG(resoD, realesF, newDay, clearEverthing));
		reso2.addActionListener(e -> resM(resoD, realesF, newDay, clearEverthing));
		reso3.addActionListener(e -> resP(resoD, realesF, newDay, clearEverthing));
		reso4.addActionListener(e -> resXP(resoD, realesF, newDay, clearEverthing));
		file.add(novo);
		file.add(calc);
		file.add(clear);
		file.add(save);
		file.add(exit);
		goTo.add(reales);
		help.add(getHelp);
		help.add(hideBtn);
		help.add(about);
		mb.add(file);
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
		if (width > 1800 && height > 1000) {
			resG(resoD, realesF, newDay, clearEverthing);
		} else if (width > 1500 && height > 700)
			resM(resoD, realesF, newDay, clearEverthing);
		else if (width > 1300 && height > 700)
			resP(resoD, realesF, newDay, clearEverthing);
		else
			resXP(resoD, realesF, newDay, clearEverthing);
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

	// Clear all funcion
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
			for (int i = 0; i < 11; i++)
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
			for (int i = 0; i < 2; i++)
				panelCnum[i].setText("");
			sumF();
		}
	}

	// saveProgress
	private static void saveProgress() {
		try {
			FileWriter savedF = new FileWriter("cedrosP.txt");
			for (int i = 0; i < 5; i++)
				for (int j = 0; j < 15; j++)
					savedF.write(details[i][j].getText() + System.lineSeparator());
			savedF.write(initialDay.getText() + System.lineSeparator());
			for (int i = 0; i < 8; i++)
				savedF.write(gastosTable[i].getText() + System.lineSeparator());
			for (int i = 0; i < 8; i++)
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
		String numbers[] = new String[104];
		try {
			dataOpened = new BufferedReader(new FileReader(new File("cedrosP.txt")));
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
			for (int i = 0; i < 11; i++) {
				panelCnum[i].setText(numbers[z]);
				z++;
			}
			dataOpened.close();
		} catch (Exception e) {
		}
	}

	// Calculate everything
	private static void sumF() {
		saveProgress();
		for (int i = 0; i < 11; i++)// Caja empty values 0
			if (!isNumeric(panelCnum[i].getText()))
				panelCnum[i].setText(0 + "");
		if (!isNumeric(initialDay.getText()))// initial of the day 0
			initialDay.setText(0 + "");
		for (int i = 0; i < 4; i++) {// TitleCase gastos and agg
			gastosTable[i].setText(capitalizeString(gastosTable[i].getText()));
			agregadoTable[i].setText(capitalizeString(agregadoTable[i].getText()));
		}
		for (int i = 4; i < 8; i++)// spent 0
			if (!isNumeric(gastosTable[i].getText()))
				gastosTable[i].setText("");
		for (int i = 4; i < 8; i++)// added 0
			if (!isNumeric(agregadoTable[i].getText()))
				agregadoTable[i].setText("");
		// Calculate the totals
		totalVenta = 0;
		for (int i = 0; i < 5; i++) {
			totalCol = 0;
			for (int j = 0; j < 15; j++) {
				if (!isNumeric(details[i][j].getText())) {
					details[i][j].setText("");
					totalCol += 0;
				} else {
					totalCol += Integer.valueOf(details[i][j].getText());
				}
			}
			total[i].setText(totalCol + "");
			totalVenta += Integer.valueOf(total[i].getText());
		}
		total[5].setText("$" + totalVenta);
		// Calculate total of spent
		gastosT = ((gastosTable[4].getText().equals("") ? 0 : Integer.valueOf(gastosTable[4].getText()))
				+ (gastosTable[5].getText().equals("") ? 0 : Integer.valueOf(gastosTable[5].getText()))
				+ (gastosTable[6].getText().equals("") ? 0 : Integer.valueOf(gastosTable[6].getText()))
				+ (gastosTable[7].getText().equals("") ? 0 : Integer.valueOf(gastosTable[7].getText())));
		summaryT[5].setText("" + gastosT);
		// Calculate total of added
		agregadoT = ((agregadoTable[4].getText().equals("") ? 0 : Integer.valueOf(agregadoTable[4].getText()))
				+ (agregadoTable[5].getText().equals("") ? 0 : Integer.valueOf(agregadoTable[5].getText()))
				+ (agregadoTable[6].getText().equals("") ? 0 : Integer.valueOf(agregadoTable[6].getText()))
				+ (agregadoTable[7].getText().equals("") ? 0 : Integer.valueOf(agregadoTable[7].getText())));
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
		total[6].setText("$" + totalCaja);
		// Calculate the diferencia
		if (totalCaja == totalO) {
			diffResult[1].setText("<html><center>No hay diferencia<br>Todo Bien</html>");
			diffResult[1].setBackground(greenD);
			diffResult[1].setForeground(Color.white);
		} else {
			if (totalCaja > totalO) {
				diffResult[1].setText("Sobro $" + (totalCaja - totalO));
				diffResult[1].setBackground(Color.orange);
				diffResult[1].setForeground(Color.black);
			} else {
				diffResult[1].setText("Falto $" + (totalO - totalCaja));
				diffResult[1].setBackground(redD);
				diffResult[1].setForeground(Color.white);
			}
		}
		// Calculate the restTmrw
		restN = totalCaja - Integer.valueOf(panelCnum[0].getText()) * 2000
				- Integer.valueOf(panelCnum[1].getText()) * 1000 - Integer.valueOf(panelCnum[2].getText()) * 500;
		restTmrw[1].setText("$" + restN);
		restTmrw[1].setForeground(Color.black);
		restTmrw[1].setBackground(lightC);
	}

	// Key listener for the table
	private static void tableFocus(int i, int j, JFrame frame) {
		details[i][j].addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyCode() == KeyEvent.VK_R) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					saveProgress();
					frame.dispose();
					new Reales();
				} else// Clear
				if ((e.getKeyCode() == KeyEvent.VK_B) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					clearAll();
				}

				else// new day
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
				}
			}
		});
	}

	// Key listener for the ADDITION
	private static void aggFocus(int i, JFrame frame) {
		agregadoTable[i].addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyCode() == KeyEvent.VK_R) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					saveProgress();
					frame.dispose();
					new Reales();
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
				}

			}
		});
	}

	// Key listener for the SPENT
	private static void gasFocus(int i, JFrame frame) {
		gastosTable[i].addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyCode() == KeyEvent.VK_R) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					saveProgress();
					frame.dispose();
					new Reales();
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
				}

			}
		});
	}

	// Key listener for the CASH
	private static void cajaFocus(int i, JFrame frame) {
		panelCnum[i].addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyCode() == KeyEvent.VK_R) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					saveProgress();
					frame.dispose();
					new Reales();
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

	private void resXP(JMenuItem resoD, JButton pesosF, JButton newDay, JButton clearEverthing) {
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
		myFont = new Font("Tahoma", Font.BOLD, 17);
		myFontS = new Font("Tahoma", Font.BOLD, 12);
		for (int i = 0; i < 5; i++) {
			boletoN[i].setBounds(50 + i * 68, 5, 170, 40);
			total[i].setBounds(30 + i * 70, 500, 50, 29);
			boletoN[i].setFont(myFont);
			total[i].setFont(myFont);
			for (int j = 0; j < 15; j++) {
				details[i][j].setFont(myFontS);
				details[i][j].setBounds(30 + i * 70, 50 + j * 29, 50, 22);
			}
		}
		boletoN[5].setText("_______________________________");
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
			gastosTable[i].setFont(myFont);
			agregadoTable[i].setFont(myFont);
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
			panelCnum[i].setFont(myFont);
		}
		total[6].setBounds(430, 330, 510, 40);
		diffResult[0].setBounds(500, 420, 150, 30);
		diffResult[1].setBounds(500, 449, 150, 40);
		restTmrw[0].setBounds(750, 420, 150, 40);
		restTmrw[1].setBounds(750, 459, 150, 30);
		total[6].setFont(myFont);
		diffResult[0].setFont(myFontS);
		diffResult[1].setFont(myFontS);
		restTmrw[0].setFont(myFontS);
		restTmrw[1].setFont(myFontS);
		pesosF.setBounds(670, 440, 50, 50);
		newDay.setBounds(920, 430, 50, 50);
		clearEverthing.setBounds(400, 400, 50, 50);
		pesosF.setIcon(new ImageIcon(getScaledImage(realesI.getImage(), 50, 50)));
		newDay.setIcon(new ImageIcon(getScaledImage(mg.getImage(), 48, 48)));
		clearEverthing.setIcon(new ImageIcon(getScaledImage(clear.getImage(), 50, 50)));
	}

	private void resP(JMenuItem resoD, JButton pesosF, JButton newDay, JButton clearEverthing) {
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
		myFont = new Font("Tahoma", Font.BOLD, 18);
		myFontS = new Font("Tahoma", Font.BOLD, 15);
		for (int i = 0; i < 5; i++) {
			boletoN[i].setBounds(60 + i * 88, 5, 200, 50);
			total[i].setBounds(30 + i * 90, 600, 70, 29);
			boletoN[i].setFont(myFont);
			total[i].setFont(myFont);
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
			gastosTable[i].setFont(myFont);
			agregadoTable[i].setFont(myFont);
		}
		for (int i = 0; i < 11; i++) {
			if (i < 7) {
				panelFoto[i].setBounds(580 + 60 * i, 300, 60, 40);
				panelCnum[i].setBounds(580 + 60 * i, 340, 60, 40);
			} else {
				panelFoto[i].setBounds(1000 + 45 * (i - 7), 300, 45, 40);
				panelCnum[i].setBounds(1000 + 45 * (i - 7), 340, 45, 40);
			}
			panelCnum[i].setFont(myFont);
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
		total[6].setBounds(580, 380, 600, 40);
		diffResult[0].setBounds(620, 480, 200, 40);
		diffResult[1].setBounds(620, 519, 200, 50);
		restTmrw[0].setBounds(950, 480, 210, 50);
		restTmrw[1].setBounds(950, 529, 210, 40);
		pesosF.setBounds(850, 500, 60, 60);
		newDay.setBounds(1185, 490, 60, 60);
		clearEverthing.setBounds(520, 460, 70, 70);
		total[6].setFont(myFont);
		diffResult[0].setFont(myFont);
		diffResult[1].setFont(myFont);
		restTmrw[0].setFont(myFont);
		restTmrw[1].setFont(myFont);
		pesosF.setIcon(new ImageIcon(getScaledImage(realesI.getImage(), 60, 60)));
		newDay.setIcon(new ImageIcon(getScaledImage(mg.getImage(), 60, 60)));
		clearEverthing.setIcon(new ImageIcon(getScaledImage(clear.getImage(), 70, 70)));
	}

	private void resM(JMenuItem resoD, JButton pesosF, JButton newDay, JButton clearEverthing) {
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
		myFont = First.myFont;
		myFontS = First.myFontS;
		for (int i = 0; i < 5; i++) {
			boletoN[i].setBounds(60 + i * 100, 5, 200, 50);
			total[i].setBounds(25 + i * 100, 690, 90, 32);
			boletoN[i].setFont(myFont);
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
			summaryT[i].setBounds(570, 50 + i * 50, 140, 50);
			summaryT[i].setFont(myFont);
		}
		initialDay.setBounds(710, 50, 90, 50);
		for (int i = 5; i < 9; i++) {
			summaryT[i].setBounds(710, 50 + (i - 4) * 50, 90, 50);
			summaryT[i].setFont(myFont);
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
			gastosTable[i].setFont(myFont);
			agregadoTable[i].setFont(myFont);
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
			panelCnum[i].setFont(myFont);
		}
		total[6].setBounds(640, 480, 710, 50);
		diffResult[0].setBounds(680, 570, 250, 50);
		diffResult[1].setBounds(680, 620, 250, 60);
		restTmrw[0].setBounds(1070, 570, 250, 60);
		restTmrw[1].setBounds(1070, 620, 250, 50);
		pesosF.setBounds(960, 600, 70, 70);
		newDay.setBounds(1370, 580, 70, 70);
		clearEverthing.setBounds(560, 540, 70, 70);
		total[6].setFont(myFont);
		diffResult[0].setFont(myFont);
		diffResult[1].setFont(myFont);
		restTmrw[0].setFont(myFont);
		restTmrw[1].setFont(myFont);
		pesosF.setIcon(new ImageIcon(getScaledImage(realesI.getImage(), 70, 70)));
		newDay.setIcon(new ImageIcon(getScaledImage(mg.getImage(), 70, 70)));
		clearEverthing.setIcon(new ImageIcon(getScaledImage(clear.getImage(), 70, 70)));
	}

	private void resG(JMenuItem resoD, JButton pesosF, JButton newDay, JButton clearEverthing) {
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
		myFont = new Font("Tahoma", Font.BOLD, 24);
		myFontS = new Font("Tahoma", Font.BOLD, 20);
		for (int i = 0; i < 5; i++) {
			boletoN[i].setBounds(60 + i * 120, 5, 200, 50);
			total[i].setBounds(25 + i * 120, 850, 90, 32);
			boletoN[i].setFont(myFont);
			total[i].setFont(myFont);
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
			panelCnum[i].setFont(myFont);
		}
		total[6].setBounds(800, 570, 820, 60);
		diffResult[0].setBounds(850, 700, 250, 60);
		diffResult[1].setBounds(850, 759, 250, 70);
		restTmrw[0].setBounds(1270, 700, 300, 70);
		restTmrw[1].setBounds(1270, 769, 300, 60);
		pesosF.setBounds(1150, 720, 80, 80);
		newDay.setBounds(1650, 750, 80, 80);
		clearEverthing.setBounds(650, 650, 80, 80);
		total[6].setFont(myFont);
		diffResult[0].setFont(myFont);
		diffResult[1].setFont(myFont);
		restTmrw[0].setFont(myFont);
		restTmrw[1].setFont(myFont);
		pesosF.setIcon(new ImageIcon(getScaledImage(realesI.getImage(), 80, 80)));
		newDay.setIcon(new ImageIcon(getScaledImage(mg.getImage(), 80, 80)));
		clearEverthing.setIcon(new ImageIcon(getScaledImage(clear.getImage(), 80, 80)));
	}

	private Image getScaledImage(Image srcImg, int w, int h) {
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(srcImg, 0, 0, w, h, null);
		g2.dispose();

		return resizedImg;
	}

	// String to titlecase
	private static String capitalizeString(String string) {
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

	// Auto
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
