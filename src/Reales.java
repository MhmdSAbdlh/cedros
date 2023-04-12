/*
 CTRL + / Folding enabled or disable using toggle switch
Ctrl + * : expands code block After folding is enabled, The below command works
Collapse All -> Ctrl + Shift + / (Numpad Divide)
Expand All -> Ctrl + Shift + * (Numpad Multiply)

Ctrl + Shift + F : clean code
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.*;

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

	// Define Parameter
	static JTextField initialDay = new JTextField("0");// How much begin the day
	static JTextField agregadoTable[] = new JTextField[8];// Added to cash detailed
	static JTextField gastosTable[] = new JTextField[8];// Spend of the day detailed
	static JTextField panelCnum[] = new JTextField[10];
	static JTextField details[][] = new JTextField[5][15];// Numbers of notes
	static JButton aggBtn[] = new JButton[2];// Combine the set of 1000 and 100
	static JLabel total[] = new JLabel[8];// Total of every column
	static JLabel boletoN[] = new JLabel[6]; // B1,2,3,4,5
	static JLabel summaryT[] = new JLabel[9];// Summary table
	static JLabel gastos = new JLabel("G A S T O S");// Spend of the day TITLE
	static JLabel agregado = new JLabel("A G R E G A D O");// Added to cash title
	static JLabel panelFoto[] = new JLabel[10];// Photo row
	static JLabel[] diffResult = new JLabel[2];// calculate the difference
	static JLabel restTmrw = new JLabel();// rest for tomorrow
	static int totalCol = 0, totalVenta = 0, totalO = 0;
	static int gastosT = 0, agregadoT = 0;
	static int restN, totalCaja = 0, nbOf20 = 0;
	int width, height;

	Reales() {
		// Buttons
		JMenuItem hideBtn = new JMenuItem("ESCONDER LOS BOTONES");
		JButton clearEverthing = new JButton();
		JButton pesosF = new JButton();
		JButton notasF = new JButton();// FATURA BUTTON
		JButton newDay = new JButton("<html><center>Se Quedará<br>Para Mañana</center></html>");// REST

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
		String conf[] = new String[4];
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
			url = getClass().getResource("images/icon/icon.png");
		} else if (conf[0].equals("1")) {
			url = getClass().getResource("images/icon/cedros.png");
		} else {
			url = getClass().getResource("images/icon/narjes.png");
		}
		this.setIconImage(new ImageIcon(url).getImage());
		// BUTTONS
		if (conf[1] == null || conf[1].equals("false")) {
			pesosF.show();
			clearEverthing.show();
			notasF.show();
			hideBtn.setText("ESCONDER LOS BOTONES");
		} else {
			pesosF.hide();
			clearEverthing.hide();
			notasF.hide();
			hideBtn.setText("MONSTRAR LOS BOTONES");
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
				if (details[i][j].getText().equals("")) {
					temp += 0;
				}
				if (conf[2] == null || conf[2].equals("false"))
					tableFocus(i, j, this, newDay, notasF, pesosF, clearEverthing, hideBtn);
				this.add(details[i][j]);
			}
			total[i] = new JLabel("");
			First.labelStyle(total[i]);
			total[i].setText(temp + "");
			this.add(total[i]);
		}
		boletoN[5] = new JLabel();
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
		initialDay.setCaretColor(First.darkC);
		initialDay.setBackground(First.lightC);
		initialDay.setForeground(Color.black);
		if (conf[2] == null || conf[2].equals("false"))
			iniFocus(newDay, notasF, pesosF, clearEverthing, hideBtn);
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

		// Panel 3 , gastos and agg
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
				gasFocus(i, this, newDay, notasF, pesosF, clearEverthing, hideBtn);
			this.add(gastosTable[i]);
		}
		for (int i = 4; i < 8; i++) {
			gastosTable[i] = new JTextField();
			textFieldStyle(gastosTable[i]);
			gastosTable[i].setBackground(First.redC);
			gastosTable[i].setForeground(Color.white);
			if (conf[2] == null || conf[2].equals("false"))
				gasFocus(i, this, newDay, notasF, pesosF, clearEverthing, hideBtn);
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
				aggFocus(i, this, newDay, notasF, pesosF, clearEverthing, hideBtn);
			this.add(agregadoTable[i]);
		}
		for (int i = 4; i < 8; i++) {
			agregadoTable[i] = new JTextField();
			textFieldStyle(agregadoTable[i]);
			agregadoTable[i].setBackground(First.greenC);
			agregadoTable[i].setForeground(Color.white);
			if (conf[2] == null || conf[2].equals("false"))
				aggFocus(i, this, newDay, notasF, pesosF, clearEverthing, hideBtn);
			this.add(agregadoTable[i]);
		}

		// Panel 4 Caja detailed
		for (int i = 0; i < 10; i++) {
			panelFoto[i] = new JLabel();
			First.labelStyle(panelFoto[i]);
			this.add(panelFoto[i]);
		}
		for (int i = 0; i < 10; i++) {
			panelCnum[i] = new JTextField("0");
			textFieldStyle(panelCnum[i]);
			panelCnum[i].setCaretColor(First.darkC);
			panelCnum[i].setForeground(First.darkC);
			panelCnum[i].setBackground(First.lightC);
			if (conf[2] == null || conf[2].equals("false"))
				cajaFocus(i, this, newDay, notasF, pesosF, clearEverthing, hideBtn);
			this.add(panelCnum[i]);
		}
		total[6] = new JLabel("TOTAL");// Total Label
		First.labelStyle(total[6]);
		total[6].setBackground(Color.black);
		total[6].setForeground(Color.white);
		this.add(total[6]);
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
		JMenuItem about = new JMenuItem("SOBRE EL APLICATIVO");
		JMenu reso = new JMenu("RESOLUCIÓN");
		JMenuItem resoD = new JMenuItem("ÓPTIMO");
		JSeparator sep = new JSeparator();
		JMenuItem reso1 = new JMenuItem("GRANDE");
		JMenuItem reso2 = new JMenuItem("MEDIO");
		JMenuItem reso3 = new JMenuItem("PEQUENA");
		JMenuItem reso4 = new JMenuItem("X-PEQUENA");
		novo.addActionListener(e -> newDay());
		calc.addActionListener(e -> sumF());
		clear.addActionListener(e -> clearAll());
		save.addActionListener(e -> saveProgress());
		hideBtn.addActionListener(e -> hideBtn(notasF, pesosF, newDay, clearEverthing, hideBtn));
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
		if (conf[2] == null || conf[2].equals("false"))
			getHelp.addActionListener(e -> JOptionPane.showMessageDialog(null,
					"• CTRL + S → ir la fatura.\n" + "• CTRL + P → ir al pesos.\n" + "• CTRL + B → borrar todo.\n"
							+ "• CTRL + N → prepárate para el día siguiente.\n"
							+ "• FLECHAS → subir, abajo, derecha e izquierda.\n" + "• CTRL + D → ir al detalles.\n"
							+ "• CTRL + I → ir al inicio.\n" + "• CTRL + G → ir al gastos.\n"
							+ "• CTRL + A → ir al agregado.\n" + "• CTRL + T → ir a la caja.\n"
							+ "• CTRL + E → ir al ultimo numero.\n" + "• CTRL + M → mas un 100 o de 1000 si posible.\n"
							+ "• CTRL + O → esconder los botones",
					"ATAJOS DE TECLADO", 1));
		else
			getHelp.hide();
		about.addActionListener(
				e -> JOptionPane.showMessageDialog(null, "Crédito y Diseñado por MhmdSAbdlh ©", "SOBRE MI", 1));
		reso.add(resoD);
		reso.add(sep);
		reso.add(reso4);
		reso.add(reso3);
		reso.add(reso2);
		reso.add(reso1);
		resoD.addActionListener(e -> {
			if (width > 1800 && height > 1000)
				resG(resoD, notasF, pesosF, newDay, clearEverthing);
			else if (width > 1500 && height > 700)
				resM(resoD, notasF, pesosF, newDay, clearEverthing);
			else if (width > 1300 && height > 700)
				resP(resoD, notasF, pesosF, newDay, clearEverthing);
			else
				resXP(resoD, notasF, pesosF, newDay, clearEverthing);
		});
		reso1.addActionListener(e -> resG(resoD, notasF, pesosF, newDay, clearEverthing));
		reso2.addActionListener(e -> resM(resoD, notasF, pesosF, newDay, clearEverthing));
		reso3.addActionListener(e -> resP(resoD, notasF, pesosF, newDay, clearEverthing));
		reso4.addActionListener(e -> resXP(resoD, notasF, pesosF, newDay, clearEverthing));
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
			if (width > 1800 && height > 1000)
				resG(resoD, notasF, pesosF, newDay, clearEverthing);
			else if (width > 1500 && height > 700)
				resM(resoD, notasF, pesosF, newDay, clearEverthing);
			else if (width > 1300 && height > 700)
				resP(resoD, notasF, pesosF, newDay, clearEverthing);
			else
				resXP(resoD, notasF, pesosF, newDay, clearEverthing);
		} else if (conf[3].equals("1"))
			resXP(resoD, notasF, pesosF, newDay, clearEverthing);
		else if (conf[3].equals("2"))
			resP(resoD, notasF, pesosF, newDay, clearEverthing);
		else if (conf[3].equals("3"))
			resM(resoD, notasF, pesosF, newDay, clearEverthing);
		else
			resG(resoD, notasF, pesosF, newDay, clearEverthing);

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

	}

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
	private void newDay() {
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
			panelCnum[5].setText("" + nbOf20);
			sumF();
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
		saveProgress();
		for (int i = 0; i < 10; i++)// Caja empty values 0
			if (!First.isNumeric(panelCnum[i].getText()))
				panelCnum[i].setText(0 + "");
		if (!First.isNumeric(initialDay.getText()))// initial of the day 0
			initialDay.setText(0 + "");
		for (int i = 4; i < 8; i++)// spent 0
			if (!First.isNumeric(gastosTable[i].getText()))
				gastosTable[i].setText("");
		for (int i = 4; i < 8; i++)// added 0
			if (!First.isNumeric(agregadoTable[i].getText()))
				agregadoTable[i].setText("");
		for (int i = 0; i < 4; i++) {// TitleCase gastos and agg
			gastosTable[i].setText(First.capitalizeString(gastosTable[i].getText()));
			agregadoTable[i].setText(First.capitalizeString(agregadoTable[i].getText()));
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
		for (int i = 0; i < 5; i++) {
			totalCol = 0;
			for (int j = 0; j < 15; j++) {
				if (!First.isNumeric(details[i][j].getText())) {
					details[i][j].setText("");
					totalCol += 0;
				} else
					totalCol += Integer.valueOf(details[i][j].getText());
			}
			total[i].setText(totalCol + "");
			totalVenta += Integer.valueOf(total[i].getText());
		}
		total[5].setText("R$" + totalVenta);
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
		total[6].setText("R$" + totalCaja);
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
					addSetKey();
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
					else
						addSetKey();
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
					else
						addSetKey();
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
					else
						addSetKey();
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

	private void resXP(JMenuItem resoD, JButton notasF, JButton pesosF, JButton newDay, JButton clearEverthing) {
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
		for (int i = 0; i < 5; i++) {
			boletoN[i].setBounds(50 + i * 68, 5, 170, 40);
			boletoN[i].setFont(First.myFont);
			total[i].setBounds(25 + i * 70, 500, 60, 24);
			total[i].setFont(First.myFont);
			for (int j = 0; j < 15; j++) {
				details[i][j].setFont(First.myFontS);
				details[i][j].setBounds(30 + i * 70, 50 + j * 29, 50, 22);
			}
		}
		boletoN[5].setText("__________________________________");
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
			gastosTable[i].setFont(First.myFontS);
			agregadoTable[i].setFont(First.myFontS);
		}
		for (int i = 0; i < 10; i++) {
			panelFoto[i].setBounds(430 + 50 * i, 240, 50, 40);
			panelCnum[i].setBounds(430 + 50 * i, 280, 50, 40);
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
		aggBtn[0].setBounds(430, 220, 50, 20);
		aggBtn[1].setBounds(480, 220, 50, 20);
		total[6].setBounds(430, 320, 500, 40);
		diffResult[0].setBounds(500, 420, 150, 35);
		diffResult[1].setBounds(500, 454, 150, 35);
		newDay.setBounds(750, 420, 150, 45);
		restTmrw.setBounds(750, 464, 150, 25);
		notasF.setBounds(920, 430, 50, 50);
		pesosF.setBounds(675, 430, 50, 50);
		clearEverthing.setBounds(400, 400, 50, 50);
		aggBtn[0].setFont(First.myFontS);
		aggBtn[1].setFont(First.myFontS);
		total[6].setFont(First.myFont);
		diffResult[0].setFont(First.myFontS);
		diffResult[1].setFont(First.myFontS);
		restTmrw.setFont(First.myFontS);
		newDay.setFont(First.myFontS);
		notasF.setIcon(new ImageIcon(getScaledImage(notasI.getImage(), 50, 50)));
		pesosF.setIcon(new ImageIcon(getScaledImage(pesosI.getImage(), 50, 50)));
		clearEverthing.setIcon(new ImageIcon(getScaledImage(clear.getImage(), 50, 50)));
	}

	private void resP(JMenuItem resoD, JButton notasF, JButton pesosF, JButton newDay, JButton clearEverthing) {
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
		for (int i = 0; i < 5; i++) {
			boletoN[i].setBounds(60 + i * 88, 5, 200, 50);
			boletoN[i].setFont(First.myFont);
			total[i].setBounds(30 + i * 90, 600, 70, 29);
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
			gastosTable[i].setFont(First.myFontS);
			agregadoTable[i].setFont(First.myFontS);
		}
		for (int i = 0; i < 10; i++) {
			panelFoto[i].setBounds(580 + 60 * i, 300, 60, 40);
			panelCnum[i].setBounds(580 + 60 * i, 340, 60, 40);
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
		aggBtn[0].setBounds(580, 280, 60, 20);
		aggBtn[1].setBounds(640, 280, 60, 20);
		total[6].setBounds(580, 380, 600, 40);
		diffResult[0].setBounds(620, 480, 200, 45);
		diffResult[1].setBounds(620, 524, 200, 45);
		newDay.setBounds(950, 480, 210, 55);
		restTmrw.setBounds(950, 534, 210, 35);
		notasF.setBounds(1180, 500, 60, 60);
		pesosF.setBounds(855, 500, 60, 60);
		clearEverthing.setBounds(510, 470, 60, 60);
		aggBtn[0].setFont(First.myFontS);
		aggBtn[1].setFont(First.myFontS);
		total[6].setFont(First.myFont);
		diffResult[0].setFont(First.myFont);
		diffResult[1].setFont(First.myFont);
		restTmrw.setFont(First.myFont);
		newDay.setFont(First.myFont);
		notasF.setIcon(new ImageIcon(getScaledImage(notasI.getImage(), 60, 60)));
		pesosF.setIcon(new ImageIcon(getScaledImage(pesosI.getImage(), 60, 60)));
		clearEverthing.setIcon(new ImageIcon(getScaledImage(clear.getImage(), 60, 60)));
	}

	private void resM(JMenuItem resoD, JButton notasF, JButton pesosF, JButton newDay, JButton clearEverthing) {
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
		for (int i = 0; i < 5; i++) {
			boletoN[i].setBounds(60 + i * 100, 5, 200, 50);
			boletoN[i].setFont(First.myFont);
			total[i].setBounds(25 + i * 100, 690, 90, 32);
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
			summaryT[i].setFont(First.myFont);
			summaryT[i].setBounds(570, 50 + i * 50, 140, 50);
		}
		initialDay.setBounds(710, 50, 90, 50);
		for (int i = 5; i < 9; i++) {
			summaryT[i].setFont(First.myFont);
			summaryT[i].setBounds(710, 50 + (i - 4) * 50, 90, 50);
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
			gastosTable[i].setFont(First.myFontS);
			agregadoTable[i].setFont(First.myFontS);
		}
		for (int i = 0; i < 10; i++) {
			panelFoto[i].setBounds(640 + 70 * i, 360, 70, 50);
			panelCnum[i].setBounds(640 + 70 * i, 410, 70, 50);
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
		aggBtn[0].setBounds(640, 331, 70, 30);
		aggBtn[1].setBounds(710, 331, 70, 30);
		total[6].setBounds(640, 460, 700, 50);
		diffResult[0].setBounds(680, 570, 250, 55);
		diffResult[1].setBounds(680, 624, 250, 55);
		newDay.setBounds(1070, 570, 250, 65);
		restTmrw.setBounds(1070, 634, 250, 45);
		notasF.setBounds(1350, 580, 80, 80);
		pesosF.setBounds(960, 590, 70, 70);
		clearEverthing.setBounds(550, 540, 70, 70);
		aggBtn[0].setFont(First.myFontS);
		aggBtn[1].setFont(First.myFontS);
		total[6].setFont(First.myFont);
		diffResult[0].setFont(First.myFont);
		diffResult[1].setFont(First.myFont);
		restTmrw.setFont(First.myFont);
		newDay.setFont(First.myFont);
		notasF.setIcon(new ImageIcon(getScaledImage(notasI.getImage(), 80, 80)));
		pesosF.setIcon(new ImageIcon(getScaledImage(pesosI.getImage(), 70, 70)));
		clearEverthing.setIcon(new ImageIcon(getScaledImage(clear.getImage(), 70, 70)));
	}

	private void resG(JMenuItem resoD, JButton notasF, JButton pesosF, JButton newDay, JButton clearEverthing) {
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
		for (int i = 0; i < 5; i++) {
			boletoN[i].setBounds(60 + i * 120, 5, 200, 50);
			boletoN[i].setFont(First.myFontS);
			total[i].setBounds(25 + i * 120, 850, 90, 32);
			total[i].setFont(First.myFontS);
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
		for (int i = 0; i < 10; i++) {
			panelFoto[i].setBounds(800 + 80 * i, 450, 80, 60);
			panelCnum[i].setBounds(800 + 80 * i, 510, 80, 60);
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
		total[6].setBounds(800, 570, 800, 60);
		aggBtn[0].setBounds(800, 412, 80, 40);
		aggBtn[1].setBounds(880, 412, 80, 40);
		diffResult[0].setBounds(850, 700, 250, 65);
		diffResult[1].setBounds(850, 764, 250, 65);
		newDay.setBounds(1270, 700, 300, 75);
		restTmrw.setBounds(1270, 774, 300, 55);
		notasF.setBounds(1650, 700, 100, 100);
		pesosF.setBounds(1140, 730, 80, 80);
		clearEverthing.setBounds(650, 650, 80, 80);
		aggBtn[0].setFont(First.myFontS);
		aggBtn[1].setFont(First.myFontS);
		total[6].setFont(First.myFont);
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

	private Image getScaledImage(Image srcImg, int w, int h) {
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(srcImg, 0, 0, w, h, null);
		g2.dispose();

		return resizedImg;
	}

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
