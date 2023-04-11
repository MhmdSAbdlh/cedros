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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

	// Define Parameter
	static JTextField details[][] = new JTextField[5][15];// Numbers of notes
	static JTextField initialDay = new JTextField("0");// How much begin the day
	static JTextField agregadoTable[] = new JTextField[8];// Added to cash detailed
	static JTextField gastosTable[] = new JTextField[8];// Spend of the day detailed
	static JTextField panelCnum[] = new JTextField[11];
	static JLabel total[] = new JLabel[8];// Total of every column
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
	int width, height;
	String conf[] = new String[3];

	Pesos() {
		// Buttons
		JMenuItem hideBtn = new JMenuItem("ESCONDER LOS BOTONES");
		JButton clearEverthing = new JButton();
		JButton faturaBtn = new JButton();// FATURA BUTTON
		JButton realesF = new JButton();
		JButton newDay = new JButton("<html><center>Se Quedará<br>Para Mañana</center></html>");// REST
		JMenuItem novo = new JMenuItem("NOVO DIA");

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
		// Icon
		if (conf[0] == null || conf[0].equals("0"))
			url = getClass().getResource("images/icon/icon.png");
		else if (conf[0].equals("1"))
			url = getClass().getResource("images/icon/cedros.png");
		else {
			url = getClass().getResource("images/icon/narjes.png");
			restTmrw.hide();
		}
		this.setIconImage(new ImageIcon(url).getImage());
		// Hide and show BUTTONS
		if (conf[1] != null && !conf[1].equals("false")) {
			realesF.hide();
			clearEverthing.hide();
			faturaBtn.hide();
			novo.hide();
			hideBtn.setText("MONSTRAR LOS BOTONES");
			if (conf[0] != null && conf[0].equals("2"))
				newDay.hide();
		}

		// Panel 1
		int temp;
		for (int i = 0; i < 5; i++) {
			temp = 0;
			boletoN[i] = new JLabel("B" + (i + 1));
			boletoN[i].setForeground(First.lightC);
			this.add(boletoN[i]);
			for (int j = 0; j < 15; j++) {
				details[i][j] = new JTextField("");
				textFieldStyle(details[i][j]);
				if (details[i][j].getText().equals(""))
					temp += 0;
				if (conf[2] == null || conf[2].equals("false"))
					tableFocus(i, j, this, newDay, faturaBtn, realesF, clearEverthing, hideBtn);
				this.add(details[i][j]);
			}
			total[i] = new JLabel("");
			First.labelStyle(total[i]);
			total[i].setText(temp + "");
			this.add(total[i]);
		}
		boletoN[5] = new JLabel("______________________________________");
		boletoN[5].setForeground(First.lightC);
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
			iniFocus(newDay, faturaBtn, realesF, clearEverthing, hideBtn);
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

		// Panel 3
		First.labelStyle(gastos);
		gastos.setBackground(new Color(107, 35, 35));
		gastos.setForeground(Color.white);
		this.add(gastos);
		ArrayList<String> keywords = gastosYagregados();
		for (int i = 0; i < 4; i++) {
			gastosTable[i] = new JTextField();
			// Autocomplete
			AutoComplete autoComplete = new AutoComplete(gastosTable[i], keywords);
			gastosTable[i].getDocument().addDocumentListener(autoComplete);
			textFieldStyle(gastosTable[i]);
			gastosTable[i].setBackground(First.redD);
			gastosTable[i].setForeground(Color.white);
			if (conf[2] == null || conf[2].equals("false"))
				gasFocus(i, this, newDay, faturaBtn, realesF, clearEverthing, hideBtn);
			this.add(gastosTable[i]);
		}
		for (int i = 4; i < 8; i++) {
			gastosTable[i] = new JTextField();
			textFieldStyle(gastosTable[i]);
			gastosTable[i].setBackground(First.redC);
			gastosTable[i].setForeground(Color.white);
			if (conf[2] == null || conf[2].equals("false"))
				gasFocus(i, this, newDay, faturaBtn, realesF, clearEverthing, hideBtn);
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
			agregadoTable[i].setBackground(First.greenD);
			agregadoTable[i].setForeground(Color.white);
			if (conf[2] == null || conf[2].equals("false"))
				aggFocus(i, this, newDay, faturaBtn, realesF, clearEverthing, hideBtn);
			this.add(agregadoTable[i]);
		}
		for (int i = 4; i < 8; i++) {
			agregadoTable[i] = new JTextField();
			textFieldStyle(agregadoTable[i]);
			agregadoTable[i].setBackground(First.greenC);
			agregadoTable[i].setForeground(Color.white);
			if (conf[2] == null || conf[2].equals("false"))
				aggFocus(i, this, newDay, faturaBtn, realesF, clearEverthing, hideBtn);
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
			panelCnum[i].setForeground(First.darkC);
			panelCnum[i].setBackground(First.lightC);
			panelCnum[i].setCaretColor(First.darkC);
			if (conf[2] == null || conf[2].equals("false"))
				cajaFocus(i, this, newDay, faturaBtn, realesF, clearEverthing, hideBtn);
			this.add(panelCnum[i]);
		}
		total[6] = new JLabel("TOTAL");// Total Label
		First.labelStyle(total[6]);
		total[6].setBackground(Color.black);
		total[6].setForeground(Color.white);
		this.add(total[6]);

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
		JMenu file = new JMenu("ARCHIVO");
		JMenu goTo = new JMenu("IR A");
		JMenu help = new JMenu("AYUDA");
		JMenuItem clear = new JMenuItem("BORRAR TODO");
		JMenuItem calc = new JMenuItem("ASUMAR");
		JMenuItem save = new JMenuItem("SALVAR");
		JMenuItem exit = new JMenuItem("SALIR");
		JMenuItem reales = new JMenuItem("REALES");
		JMenuItem fatura = new JMenuItem("FATURA");
		JMenuItem getHelp = new JMenuItem("ATAJOS DE TECLADO");
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
		fatura.addActionListener(e -> {
			saveProgress();
			FaturaP.totalC.setText("0");
			FaturaP.total.setText("0");
			this.dispose();
			new FaturaP();
		});
		if (conf[2] == null || conf[2].equals("false"))
			if (conf[0] == null || conf[0].equals("0") || conf[0].equals("1"))
				getHelp.addActionListener(e -> JOptionPane.showMessageDialog(null,
						"• CTRL + S → ir la fatura.\n" + "• CTRL + R → ir al reales.\n" + "• CTRL + B → borrar todo.\n"
								+ "• CTRL + N → prepárate para el día siguiente.\n"
								+ "• FLECHAS → subir, abajo, derecha e izquierda.\n" + "• CTRL + D → ir al detalles.\n"
								+ "• CTRL + I → ir al inicio.\n" + "• CTRL + G → ir al gastos.\n"
								+ "• CTRL + A → ir al agregado.\n" + "• CTRL + T → ir a la caja.\n"
								+ "• CTRL + E → ir al ultimo numero.\n" + "• CTRL + O → esconder los botones",
						"ATAJOS DE TECLADO", 1));
			else
				getHelp.addActionListener(e -> JOptionPane.showMessageDialog(null,
						"• CTRL + S → ir la fatura.\n" + "• CTRL + R → ir al reales.\n" + "• CTRL + B → borrar todo.\n"
								+ "• FLECHAS → subir, abajo, derecha e izquierda.\n" + "• CTRL + D → ir al detalles.\n"
								+ "• CTRL + I → ir al inicio.\n" + "• CTRL + G → ir al gastos.\n"
								+ "• CTRL + A → ir al agregado.\n" + "• CTRL + T → ir a la caja.\n"
								+ "• CTRL + E → ir al ultimo numero.\n" + "• CTRL + O → esconder los botones",
						"ATAJOS DE TECLADO", 1));
		else
			getHelp.hide();
		hideBtn.addActionListener(e -> hideBtn(faturaBtn, realesF, newDay, clearEverthing, hideBtn));
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
				resG(resoD, realesF, faturaBtn, newDay, clearEverthing);
			} else if (width > 1500 && height > 700)
				resM(resoD, realesF, faturaBtn, newDay, clearEverthing);
			else if (width > 1300 && height > 700)
				resP(resoD, realesF, faturaBtn, newDay, clearEverthing);
			else
				resXP(resoD, realesF, faturaBtn, newDay, clearEverthing);
		});
		reso1.addActionListener(e -> resG(resoD, realesF, faturaBtn, newDay, clearEverthing));
		reso2.addActionListener(e -> resM(resoD, realesF, faturaBtn, newDay, clearEverthing));
		reso3.addActionListener(e -> resP(resoD, realesF, faturaBtn, newDay, clearEverthing));
		reso4.addActionListener(e -> resXP(resoD, realesF, faturaBtn, newDay, clearEverthing));
		file.add(novo);
		file.add(calc);
		file.add(clear);
		file.add(save);
		file.add(exit);
		goTo.add(reales);
		goTo.add(fatura);
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
			resG(resoD, realesF, faturaBtn, newDay, clearEverthing);
		} else if (width > 1500 && height > 700)
			resM(resoD, realesF, faturaBtn, newDay, clearEverthing);
		else if (width > 1300 && height > 700)
			resP(resoD, realesF, faturaBtn, newDay, clearEverthing);
		else
			resXP(resoD, realesF, faturaBtn, newDay, clearEverthing);

		// Close Popup
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

	}

	// Clear all funcion
	private void clearAll() {
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
	private void newDay() {
		int op = JOptionPane.showConfirmDialog(null, "¿QUIERES EMPEZAR NUEVO DIA?", "NUEVO DIA",
				JOptionPane.OK_CANCEL_OPTION);
		if (op == 0) {
			for (int i = 0; i < 5; i++)
				for (int j = 0; j < 15; j++)
					details[i][j].setText("");
			initialDay.setText(totalCaja + "");
			for (int i = 0; i < 8; i++)
				gastosTable[i].setText("");
			for (int i = 0; i < 8; i++)
				agregadoTable[i].setText("");
			if (conf[0] == null || conf[0].equals("0") || conf[0].equals("1")) {
				for (int i = 0; i < 2; i++)
					panelCnum[i].setText("");
				panelCnum[2].setText("" + nbOf500);
			}
			sumF();
		}
	}

	// Hide Btns
	private void hideBtn(JButton notasF, JButton pesosF, JButton newDay, JButton clearEverthing, JMenuItem hideBtn) {
		if (pesosF.isShowing()) {
			pesosF.hide();
			clearEverthing.hide();
			notasF.hide();
			hideBtn.setText("MONSTRAR LOS BOTONES");
			if (conf[0] != null && conf[0].equals("2"))
				newDay.hide();
		} else {
			pesosF.show();
			clearEverthing.show();
			notasF.show();
			hideBtn.setText("ESCONDER LOS BOTONES");
			if (conf[0] != null && conf[0].equals("2"))
				newDay.show();
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
	private void sumF() {
		saveProgress();
		for (int i = 0; i < 11; i++)// Caja empty values 0
			if (!First.isNumeric(panelCnum[i].getText()))
				panelCnum[i].setText(0 + "");
		if (!First.isNumeric(initialDay.getText()))// initial of the day 0
			initialDay.setText(0 + "");
		for (int i = 0; i < 4; i++) {// TitleCase gastos and agg
			gastosTable[i].setText(First.capitalizeString(gastosTable[i].getText()));
			agregadoTable[i].setText(First.capitalizeString(agregadoTable[i].getText()));
		}
		for (int i = 4; i < 8; i++)// spent 0
			if (!First.isNumeric(gastosTable[i].getText()))
				gastosTable[i].setText("");
		for (int i = 4; i < 8; i++)// added 0
			if (!First.isNumeric(agregadoTable[i].getText()))
				agregadoTable[i].setText("");
		// Calculate the totals
		totalVenta = 0;
		for (int i = 0; i < 5; i++) {
			totalCol = 0;
			for (int j = 0; j < 15; j++) {
				if (!First.isNumeric(details[i][j].getText())) {
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
			diffResult[1].setText("<html><center>No Hay Diferencia</html>");
			diffResult[1].setBackground(First.greenD);
			diffResult[1].setForeground(Color.white);
		} else {
			if (totalCaja > totalO) {
				diffResult[1].setText("Sobró $" + (totalCaja - totalO));
				diffResult[1].setBackground(Color.orange);
				diffResult[1].setForeground(Color.black);
			} else {
				diffResult[1].setText("Faltó $" + (totalO - totalCaja));
				diffResult[1].setBackground(First.redD);
				diffResult[1].setForeground(Color.white);
			}
		}
		// Calculate the restTmrw
		restN = totalCaja - Integer.valueOf(panelCnum[0].getText()) * 2000
				- Integer.valueOf(panelCnum[1].getText()) * 1000;
		nbOf500 = Integer.valueOf(panelCnum[2].getText());
		while (restN > 1000 && nbOf500 > 0) {
			restN -= 500;
			nbOf500--;
		}
		restTmrw.setText("$" + restN);
		restTmrw.setForeground(Color.black);
		restTmrw.setBackground(First.lightC);
	}

	// Key listener for the table
	private void tableFocus(int i, int j, JFrame frame, JButton newDay, JButton notasF, JButton pesosF,
			JButton clearEverthing, JMenuItem hideBtn) {
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
				}

				else// new day
				if ((e.getKeyCode() == KeyEvent.VK_N) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					if (conf[0] == null || conf[0].equals("0") || conf[0].equals("1"))
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

	// Key listener for the initial
	private void iniFocus(JButton newDay, JButton notasF, JButton pesosF, JButton clearEverthing, JMenuItem hideBtn) {
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
					if (conf[0] == null || conf[0].equals("0") || conf[0].equals("1"))
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
				}
			}
		});
	}

	// Key listener for the ADDITION
	private void aggFocus(int i, JFrame frame, JButton newDay, JButton notasF, JButton pesosF, JButton clearEverthing,
			JMenuItem hideBtn) {
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
				} // GO TO Reales
				else if ((e.getKeyCode() == KeyEvent.VK_R) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					saveProgress();
					frame.dispose();
					new Reales();
				} else// Clear
				if ((e.getKeyCode() == KeyEvent.VK_B) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					clearAll();
				} else// new day
				if ((e.getKeyCode() == KeyEvent.VK_N) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					if (conf[0] == null || conf[0].equals("0") || conf[0].equals("1"))
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
	private void gasFocus(int i, JFrame frame, JButton newDay, JButton notasF, JButton pesosF, JButton clearEverthing,
			JMenuItem hideBtn) {
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
				} // GO TO Reales
				else if ((e.getKeyCode() == KeyEvent.VK_R) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					saveProgress();
					frame.dispose();
					new Reales();
				} else// Clear
				if ((e.getKeyCode() == KeyEvent.VK_B) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					clearAll();
				} else
				// new day
				if ((e.getKeyCode() == KeyEvent.VK_N) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					if (conf[0] == null || conf[0].equals("0") || conf[0].equals("1"))
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
	private void cajaFocus(int i, JFrame frame, JButton newDay, JButton notasF, JButton pesosF, JButton clearEverthing,
			JMenuItem hideBtn) {
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
				} else // Clear
				if ((e.getKeyCode() == KeyEvent.VK_B) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					clearAll();
				} else// new day
				if ((e.getKeyCode() == KeyEvent.VK_N) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					if (conf[0] == null || conf[0].equals("0") || conf[0].equals("1"))
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

	private void resXP(JMenuItem resoD, JButton pesosF, JButton notasF, JButton newDay, JButton clearEverthing) {
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
		First.myFont = new Font("Tahoma", Font.BOLD, 17);
		First.myFontS = new Font("Tahoma", Font.BOLD, 12);
		for (int i = 0; i < 5; i++) {
			boletoN[i].setBounds(50 + i * 68, 5, 170, 40);
			total[i].setBounds(30 + i * 70, 500, 50, 29);
			boletoN[i].setFont(First.myFont);
			total[i].setFont(First.myFont);
			for (int j = 0; j < 15; j++) {
				details[i][j].setFont(First.myFontS);
				details[i][j].setBounds(30 + i * 70, 50 + j * 29, 50, 22);
			}
		}
		boletoN[5].setText("_______________________________");
		boletoN[5].setBounds(25, 472, 460, 20);
		total[5].setBounds(390, 500, 58, 30);
		total[7].setBounds(390, 470, 58, 30);
		boletoN[5].setFont(First.myFont);
		total[5].setFont(First.myFont);
		initialDay.setFont(First.myFont);
		total[7].setFont(First.myFont);
		for (int i = 0; i < 5; i++) {
			summaryT[i].setBounds(420, 50 + i * 30, 100, 30);
			summaryT[i].setFont(First.myFont);
		}
		initialDay.setBounds(520, 50, 70, 30);
		for (int i = 5; i < 9; i++) {
			summaryT[i].setBounds(520, 50 + (i - 4) * 30, 70, 30);
			summaryT[i].setFont(First.myFont);
		}
		gastos.setBounds(620, 50, 150, 30);
		agregado.setBounds(800, 50, 150, 30);
		gastos.setFont(First.myFont);
		agregado.setFont(First.myFont);
		for (int i = 0; i < 4; i++) {
			gastosTable[i].setBounds(620, 80 + 30 * i, 100, 30);
			agregadoTable[i].setBounds(800, 80 + 30 * i, 100, 30);
			gastosTable[i].setFont(First.myFont);
			agregadoTable[i].setFont(First.myFont);
		}
		for (int i = 4; i < 8; i++) {
			gastosTable[i].setBounds(720, 80 + 30 * (i - 4), 50, 30);
			agregadoTable[i].setBounds(900, 80 + 30 * (i - 4), 50, 30);
			gastosTable[i].setFont(First.myFont);
			agregadoTable[i].setFont(First.myFont);
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
		if (conf[0] != null && !conf[0].equals("0") && !conf[0].equals("1")) {
			newDay.setOpaque(false);
			newDay.setText("");
			newDay.setIcon(nextDI);
			newDay.setContentAreaFilled(false);
			newDay.setBorderPainted(false);
			newDay.setBounds(750, 440, 70, 70);
		} else
			newDay.setBounds(750, 420, 150, 45);
		total[6].setBounds(430, 330, 510, 40);
		restTmrw.setBounds(750, 464, 150, 25);
		pesosF.setBounds(675, 430, 50, 50);
		diffResult[0].setBounds(500, 420, 150, 35);
		diffResult[1].setBounds(500, 454, 150, 35);
		notasF.setBounds(920, 430, 50, 50);
		clearEverthing.setBounds(400, 400, 50, 50);
		total[6].setFont(First.myFont);
		diffResult[0].setFont(First.myFontS);
		diffResult[1].setFont(First.myFontS);
		restTmrw.setFont(First.myFontS);
		newDay.setFont(First.myFontS);
		notasF.setIcon(new ImageIcon(getScaledImage(notasI.getImage(), 50, 50)));
		pesosF.setIcon(new ImageIcon(getScaledImage(realesI.getImage(), 50, 50)));
		clearEverthing.setIcon(new ImageIcon(getScaledImage(clear.getImage(), 50, 50)));
	}

	private void resP(JMenuItem resoD, JButton pesosF, JButton notasF, JButton newDay, JButton clearEverthing) {
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
		for (int i = 0; i < 5; i++) {
			boletoN[i].setBounds(60 + i * 88, 5, 200, 50);
			total[i].setBounds(30 + i * 90, 600, 70, 29);
			boletoN[i].setFont(First.myFont);
			total[i].setFont(First.myFont);
			for (int j = 0; j < 15; j++) {
				details[i][j].setBounds(30 + i * 90, 55 + j * 35, 70, 25);
				details[i][j].setFont(First.myFontS);
			}
		}
		boletoN[5].setText("________________________________________");
		boletoN[5].setBounds(25, 550, 570, 50);
		total[5].setBounds(500, 590, 88, 35);
		total[7].setBounds(500, 560, 88, 30);
		boletoN[5].setFont(First.myFont);
		total[5].setFont(First.myFont);
		initialDay.setFont(First.myFont);
		total[7].setFont(First.myFont);
		for (int i = 0; i < 5; i++) {
			summaryT[i].setBounds(550, 50 + i * 40, 120, 40);
			summaryT[i].setFont(First.myFont);
		}
		initialDay.setBounds(670, 50, 80, 40);
		for (int i = 5; i < 9; i++) {
			summaryT[i].setBounds(670, 50 + (i - 4) * 40, 80, 40);
			summaryT[i].setFont(First.myFont);
		}
		gastos.setBounds(800, 50, 210, 40);
		agregado.setBounds(1050, 50, 210, 40);
		gastos.setFont(First.myFont);
		agregado.setFont(First.myFont);
		for (int i = 0; i < 4; i++) {
			gastosTable[i].setBounds(800, 90 + 40 * i, 150, 40);
			agregadoTable[i].setBounds(1050, 90 + 40 * i, 150, 40);
			gastosTable[i].setFont(First.myFont);
			agregadoTable[i].setFont(First.myFont);
		}
		for (int i = 4; i < 8; i++) {
			gastosTable[i].setBounds(950, 90 + 40 * (i - 4), 60, 40);
			agregadoTable[i].setBounds(1200, 90 + 40 * (i - 4), 60, 40);
			gastosTable[i].setFont(First.myFont);
			agregadoTable[i].setFont(First.myFont);
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
		if (conf[0] != null && !conf[0].equals("0") && !conf[0].equals("1")) {
			newDay.setOpaque(false);
			newDay.setText("");
			newDay.setIcon(nextDI);
			newDay.setContentAreaFilled(false);
			newDay.setBorderPainted(false);
			newDay.setBounds(950, 490, 70, 70);
		} else {
			newDay.setBounds(950, 480, 210, 55);
		}
		total[6].setBounds(580, 380, 600, 40);
		restTmrw.setBounds(950, 534, 210, 35);
		pesosF.setBounds(855, 500, 60, 60);
		diffResult[0].setBounds(620, 480, 200, 40);
		diffResult[1].setBounds(620, 519, 200, 50);
		notasF.setBounds(1180, 500, 60, 60);
		clearEverthing.setBounds(520, 460, 70, 70);
		total[6].setFont(First.myFont);
		diffResult[0].setFont(First.myFont);
		diffResult[1].setFont(First.myFont);
		restTmrw.setFont(First.myFont);
		newDay.setFont(First.myFont);
		notasF.setIcon(new ImageIcon(getScaledImage(notasI.getImage(), 60, 60)));
		pesosF.setIcon(new ImageIcon(getScaledImage(realesI.getImage(), 60, 60)));
		clearEverthing.setIcon(new ImageIcon(getScaledImage(clear.getImage(), 70, 70)));
	}

	private void resM(JMenuItem resoD, JButton pesosF, JButton notasF, JButton newDay, JButton clearEverthing) {
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
		for (int i = 0; i < 5; i++) {
			boletoN[i].setBounds(60 + i * 100, 5, 200, 50);
			total[i].setBounds(25 + i * 100, 690, 90, 32);
			boletoN[i].setFont(First.myFont);
			total[i].setFont(First.myFont);
			for (int j = 0; j < 15; j++) {
				details[i][j].setBounds(30 + i * 100, 55 + j * 40, 80, 30);
				details[i][j].setFont(First.myFontS);
			}
		}
		boletoN[5].setText("______________________________________");
		boletoN[5].setBounds(25, 632, 600, 50);
		total[5].setBounds(540, 680, 98, 35);
		total[7].setBounds(540, 650, 98, 30);
		boletoN[5].setFont(First.myFont);
		total[5].setFont(First.myFont);
		initialDay.setFont(First.myFont);
		total[7].setFont(First.myFont);
		for (int i = 0; i < 5; i++) {
			summaryT[i].setBounds(570, 50 + i * 50, 140, 50);
			summaryT[i].setFont(First.myFont);
		}
		initialDay.setBounds(710, 50, 90, 50);
		for (int i = 5; i < 9; i++) {
			summaryT[i].setBounds(710, 50 + (i - 4) * 50, 90, 50);
			summaryT[i].setFont(First.myFont);
		}
		gastos.setBounds(870, 50, 230, 50);
		agregado.setBounds(1170, 50, 230, 50);
		gastos.setFont(First.myFont);
		agregado.setFont(First.myFont);
		for (int i = 0; i < 4; i++) {
			gastosTable[i].setBounds(870, 100 + 50 * i, 160, 50);
			agregadoTable[i].setBounds(1170, 100 + 50 * i, 160, 50);
			gastosTable[i].setFont(First.myFont);
			agregadoTable[i].setFont(First.myFont);
		}
		for (int i = 4; i < 8; i++) {
			gastosTable[i].setBounds(1030, 100 + 50 * (i - 4), 70, 50);
			agregadoTable[i].setBounds(1330, 100 + 50 * (i - 4), 70, 50);
			gastosTable[i].setFont(First.myFont);
			agregadoTable[i].setFont(First.myFont);
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
		if (conf[0] != null && !conf[0].equals("0") && !conf[0].equals("1")) {
			newDay.setOpaque(false);
			newDay.setText("");
			newDay.setIcon(nextDI);
			newDay.setContentAreaFilled(false);
			newDay.setBorderPainted(false);
			newDay.setBounds(1070, 590, 70, 70);
		} else
			newDay.setBounds(1070, 570, 250, 65);
		total[6].setBounds(640, 480, 710, 50);
		restTmrw.setBounds(1070, 634, 250, 45);
		pesosF.setBounds(960, 590, 70, 70);
		diffResult[0].setBounds(680, 570, 250, 55);
		diffResult[1].setBounds(680, 624, 250, 55);
		notasF.setBounds(1350, 580, 80, 80);
		clearEverthing.setBounds(560, 540, 70, 70);
		total[6].setFont(First.myFont);
		diffResult[0].setFont(First.myFont);
		diffResult[1].setFont(First.myFont);
		restTmrw.setFont(First.myFont);
		newDay.setFont(First.myFont);
		notasF.setIcon(new ImageIcon(getScaledImage(notasI.getImage(), 80, 80)));
		pesosF.setIcon(new ImageIcon(getScaledImage(realesI.getImage(), 70, 70)));
		clearEverthing.setIcon(new ImageIcon(getScaledImage(clear.getImage(), 70, 70)));
	}

	private void resG(JMenuItem resoD, JButton pesosF, JButton notasF, JButton newDay, JButton clearEverthing) {
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
		for (int i = 0; i < 5; i++) {
			boletoN[i].setBounds(60 + i * 120, 5, 200, 50);
			total[i].setBounds(25 + i * 120, 850, 90, 32);
			boletoN[i].setFont(First.myFont);
			total[i].setFont(First.myFont);
			for (int j = 0; j < 15; j++) {
				details[i][j].setBounds(30 + i * 120, 65 + j * 50, 80, 35);
				details[i][j].setFont(First.myFontS);
			}
		}
		boletoN[5].setText("______________________________________");
		boletoN[5].setBounds(25, 790, 600, 50);
		total[5].setBounds(625, 830, 98, 45);
		total[7].setBounds(625, 790, 98, 40);
		boletoN[5].setFont(First.myFont);
		total[5].setFont(First.myFont);
		initialDay.setFont(First.myFont);
		total[7].setFont(First.myFont);
		for (int i = 0; i < 5; i++) {
			summaryT[i].setBounds(700, 50 + i * 60, 160, 60);
			summaryT[i].setFont(First.myFont);
		}
		initialDay.setBounds(860, 50, 110, 60);
		for (int i = 5; i < 9; i++) {
			summaryT[i].setBounds(860, 50 + (i - 4) * 60, 110, 60);
			summaryT[i].setFont(First.myFont);
		}
		gastos.setBounds(1100, 50, 270, 60);
		gastos.setFont(First.myFont);
		agregado.setFont(First.myFont);
		for (int i = 0; i < 4; i++) {
			gastosTable[i].setBounds(1100, 110 + 60 * i, 180, 60);
			agregadoTable[i].setBounds(1500, 110 + 60 * i, 180, 60);
			gastosTable[i].setFont(First.myFontS);
			agregadoTable[i].setFont(First.myFontS);
		}
		for (int i = 4; i < 8; i++) {
			gastosTable[i].setBounds(1280, 110 + 60 * (i - 4), 90, 60);
			agregadoTable[i].setBounds(1680, 110 + 60 * (i - 4), 90, 60);
			gastosTable[i].setFont(First.myFontS);
			agregadoTable[i].setFont(First.myFontS);
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
			panelCnum[i].setFont(First.myFont);
		}
		if (conf[0] != null && !conf[0].equals("0") && !conf[0].equals("1")) {
			newDay.setOpaque(false);
			newDay.setText("");
			newDay.setIcon(nextDI);
			newDay.setContentAreaFilled(false);
			newDay.setBorderPainted(false);
			newDay.setBounds(1270, 730, 70, 70);
		} else
			newDay.setBounds(1270, 700, 300, 75);
		total[6].setBounds(800, 570, 820, 60);
		restTmrw.setBounds(1270, 774, 300, 55);
		pesosF.setBounds(1140, 730, 80, 80);
		diffResult[0].setBounds(850, 700, 250, 65);
		diffResult[1].setBounds(850, 764, 250, 65);
		notasF.setBounds(1650, 700, 100, 100);
		clearEverthing.setBounds(650, 650, 80, 80);
		total[6].setFont(First.myFont);
		diffResult[0].setFont(First.myFont);
		diffResult[1].setFont(First.myFont);
		restTmrw.setFont(First.myFont);
		newDay.setFont(First.myFont);
		notasF.setIcon(new ImageIcon(getScaledImage(notasI.getImage(), 100, 100)));
		pesosF.setIcon(new ImageIcon(getScaledImage(realesI.getImage(), 80, 80)));
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
		return keywords;
	}
}
