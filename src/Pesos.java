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
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
import javax.swing.plaf.metal.MetalToggleButtonUI;

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
	int width, height;
	String conf[] = new String[6];
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
		// Buttons
		JMenuItem hideBtn = new JMenuItem("ESCONDER LOS BOTONES");
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
		if (conf[1] != null && !conf[1].equals("false")) {
			realesF.hide();
			clearEverthing.hide();
			faturaBtn.hide();
			novo.hide();
			hideBtn.setText("MONSTRAR LOS BOTONES");
			if (conf[0] != null && conf[0].equals("3"))
				newDay.hide();
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
		JMenu file = new JMenu("ARCHIVO");
		JMenu goTo = new JMenu("IR A");
		JMenu help = new JMenu("AYUDA");
		JMenuItem clear = new JMenuItem("BORRAR TODO");
		JMenuItem calc = new JMenuItem("ASUMAR");
		JMenuItem save = new JMenuItem("SALVAR");
		JMenuItem option = new JMenuItem("CONFIGURACIÓN");
		JMenuItem exit = new JMenuItem("SALIR");
		JMenuItem reales = new JMenuItem("REALES");
		JMenuItem fatura = new JMenuItem("FATURA");
		JMenuItem getHelp = new JMenuItem("ATAJOS DE TECLADO");
		JMenuItem creator = new JMenuItem("SOBRE EL CREADOR");
		JMenuItem about = new JMenuItem("SOBRE EL APLICATIVO");
		JMenu reso = new JMenu("RESOLUCIÓN");
		JSeparator sep = new JSeparator();
		JMenuItem reso1 = new JMenuItem("GRANDE");
		JMenuItem reso2 = new JMenuItem("MEDIO");
		JMenuItem reso3 = new JMenuItem("PEQUENA");
		JMenuItem reso4 = new JMenuItem("X-PEQUENA");
		novo.addActionListener(e -> newDay());
		calc.addActionListener(e -> sumF());
		clear.addActionListener(e -> clearAll());
		save.addActionListener(e -> saveProgress());
		option.addActionListener(e -> confFrame(conf, faturaBtn, realesF, newDay, clearEverthing, hideBtn, resoD,
				gastosPanel, aggPanel));
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
			getHelp.addActionListener(e -> JOptionPane.showMessageDialog(null,
					"• CTRL + S → ir la fatura.\n" + "• CTRL + R → ir al reales.\n" + "• CTRL + B → borrar todo.\n"
							+ "• CTRL + N → prepárate para el día siguiente.\n"
							+ "• FLECHAS → subir, abajo, derecha e izquierda.\n" + "• CTRL + D → ir al detalles.\n"
							+ "• CTRL + I → ir al inicio.\n" + "• CTRL + G → ir al gastos.\n"
							+ "• CTRL + A → ir al agregado.\n" + "• CTRL + T → ir a la caja.\n"
							+ "• CTRL + E → ir al ultimo numero.\n" + "• CTRL + O → esconder los botones.\n"
							+ "• CTRL + C → abrir el configuración.",
					"ATAJOS DE TECLADO", 1));
		else
			getHelp.hide();
		hideBtn.addActionListener(e -> hideBtn(faturaBtn, realesF, newDay, clearEverthing, hideBtn));
		creator.addActionListener(
				e -> JOptionPane.showMessageDialog(null, "Crédito y Diseñado por MhmdSAbdlh ©", "SOBRE MI", 1));
		about.addActionListener(e -> JOptionPane.showMessageDialog(null,
				"ESTA APLICACIÓN ESTÁ DISEÑADA PARA CEDROS Y NARJES FREE SHOP.\r\n"
						+ "TIENE MARCO PARA CERRAR LA CAJA TANTO EN REALES COMO PESOS.\r\n"
						+ "TIENE UN MARCO PARA CALCULAR EL TROCO DE UNA VENTA TANTO EN REALES COMO PESOS.\r\n"
						+ "SABE CÓMO QUEDARÁ PARA EL PRÓXIMO DÍA.\r\n" + "3 MÉTODOS PARA DAR EL CAMBIO.\r\n"
						+ "CAMBIARÁ TODO SEGÚN EL ICONO SELECCIONADO.\r\n" + "\r\n" + "MOHAMAD ABDALLAH ABBASS ©",
				"CEDROS/NARJES", 1));
		reso.add(resoD);
		reso.add(sep);
		reso.add(reso4);
		reso.add(reso3);
		reso.add(reso2);
		reso.add(reso1);
		resoD.addActionListener(e -> {
			if (width > 1800 && height > 1000)
				resG(resoD, realesF, faturaBtn, newDay, clearEverthing, gastosPanel, aggPanel);
			else if (width > 1500 && height > 700)
				resM(resoD, realesF, faturaBtn, newDay, clearEverthing, gastosPanel, aggPanel);
			else if (width > 1300 && height > 700)
				resP(resoD, realesF, faturaBtn, newDay, clearEverthing, gastosPanel, aggPanel);
			else
				resXP(resoD, realesF, faturaBtn, newDay, clearEverthing, gastosPanel, aggPanel);
		});
		reso1.addActionListener(e -> resG(resoD, realesF, faturaBtn, newDay, clearEverthing, gastosPanel, aggPanel));
		reso2.addActionListener(e -> resM(resoD, realesF, faturaBtn, newDay, clearEverthing, gastosPanel, aggPanel));
		reso3.addActionListener(e -> resP(resoD, realesF, faturaBtn, newDay, clearEverthing, gastosPanel, aggPanel));
		reso4.addActionListener(e -> resXP(resoD, realesF, faturaBtn, newDay, clearEverthing, gastosPanel, aggPanel));
		file.add(novo);
		file.add(calc);
		file.add(clear);
		file.add(save);
		file.add(option);
		file.add(exit);
		goTo.add(reales);
		goTo.add(fatura);
		help.add(getHelp);
		help.add(hideBtn);
		help.add(creator);
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
		if (conf[3] == null || conf[3].equals("0")) {
			if (width > 1800 && height > 1000)
				resG(resoD, realesF, faturaBtn, newDay, clearEverthing, gastosPanel, aggPanel);
			else if (width > 1500 && height > 700)
				resM(resoD, realesF, faturaBtn, newDay, clearEverthing, gastosPanel, aggPanel);
			else if (width > 1300 && height > 700)
				resP(resoD, realesF, faturaBtn, newDay, clearEverthing, gastosPanel, aggPanel);
			else
				resXP(resoD, realesF, faturaBtn, newDay, clearEverthing, gastosPanel, aggPanel);
		} else if (conf[3].equals("1"))
			resXP(resoD, realesF, faturaBtn, newDay, clearEverthing, gastosPanel, aggPanel);
		else if (conf[3].equals("2"))
			resP(resoD, realesF, faturaBtn, newDay, clearEverthing, gastosPanel, aggPanel);
		else if (conf[3].equals("3"))
			resM(resoD, realesF, faturaBtn, newDay, clearEverthing, gastosPanel, aggPanel);
		else
			resG(resoD, realesF, faturaBtn, newDay, clearEverthing, gastosPanel, aggPanel);

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
		temp.setTitle("CONFIGURACIÓN");
		temp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		temp.setAlwaysOnTop(false);
		temp.setSize(500, 500);
		temp.setLocationRelativeTo(null);
		temp.setResizable(false);
		temp.setLayout(null);
		temp.getContentPane().setBackground(First.lightC);
		// Stuff
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
		op1C.setBounds(320, 20, 70, 50);
		if (conf[0] != null)
			op1C.setSelectedIndex(Integer.valueOf(conf[0]));
		op1C.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Pesos.this.setIconImage(iconImages[op1C.getSelectedIndex()].getImage());
				op1C.setSelectedIndex(op1C.getSelectedIndex());
			}
		});
		// OPTION 1 BUTTONS HIDE
		JLabel op2 = new JLabel("BOTONES");
		op2.setBounds(50, 90, 150, 50);
		op2.setFont(First.myFont);
		JToggleButton btnsHideShow = new JToggleButton();
		if (conf[1] == null || conf[1].equals("false")) {
			btnsHideShow.setText("SI");
		} else {
			btnsHideShow.setText("NO");
			btnsHideShow.setSelected(true);
		}
		btnsHideShow.setBounds(320, 90, 80, 50);
		btnsHideShow.setFont(First.myFont);
		btnsHideShow.setBorder(First.border);
		btnsHideShow.setBackground(First.greenC);
		btnsHideShow.setForeground(First.lightC);
		btnsHideShow.setFocusable(false);
		btnsHideShow.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnsHideShow.setBackground(First.greenC);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnsHideShow.setBackground(First.greenD);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnsHideShow.setUI(new MetalToggleButtonUI() {
			@Override
			protected Color getSelectColor() {
				return First.redC;
			}
		});
		btnsHideShow.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					btnsHideShow.setText("NO");
					pesosF.hide();
					clearEverthing.hide();
					notasF.hide();
					hideBtn.setText("MONSTRAR LOS BOTONES");
					if (op1C.getSelectedIndex() == 2)
						newDay.hide();
				} else {
					btnsHideShow.setText("SI");
					pesosF.show();
					clearEverthing.show();
					notasF.show();
					hideBtn.setText("ESCONDER LOS BOTONES");
					if (op1C.getSelectedIndex() == 2)
						newDay.show();
				}
			}
		});
		// OPTION 2 DISABLE KEYBOARD SHORTCUT
		JLabel op3 = new JLabel("ATAJO DE TECLADO");
		op3.setBounds(50, 160, 250, 50);
		op3.setFont(First.myFont);
		JToggleButton btnsHideShow2 = new JToggleButton();
		if (conf[2] == null || conf[2].equals("false")) {
			btnsHideShow2.setText("SI");
		} else {
			btnsHideShow2.setText("NO");
			btnsHideShow2.setSelected(true);
		}
		btnsHideShow2.setBounds(320, 160, 80, 50);
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
		op4.setBounds(50, 220, 250, 50);
		op4.setFont(First.myFont);
		String res[] = { "OPTIMAL", "X-P", "P", "M", "G" };
		JComboBox<String> op2C = new JComboBox<>(res);
		op2C.setBounds(280, 220, 140, 50);
		op2C.setFont(First.myFont);
		op2C.setBackground(First.blueC);
		op2C.setForeground(First.darkC);
		if (conf[3] != null)
			op2C.setSelectedIndex(Integer.valueOf(conf[3]));
		op2C.addActionListener(e -> {
			op2C.setSelectedIndex(op2C.getSelectedIndex());
			// Resolution
			if (op2C.getSelectedIndex() == 0) {
				if (width > 1800 && height > 1000)
					resG(resoD, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel);
				else if (width > 1500 && height > 700)
					resM(resoD, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel);
				else if (width > 1300 && height > 700)
					resP(resoD, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel);
				else
					resXP(resoD, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel);
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
		op5.setBounds(50, 290, 180, 50);
		op5.setFont(First.myFont);
		JToggleButton btnsHideShow3 = new JToggleButton();
		if (conf[4] == null || conf[4].equals("false")) {
			btnsHideShow3.setText("SI");
		} else {
			btnsHideShow3.setText("NO");
			btnsHideShow3.setSelected(true);
		}
		btnsHideShow3.setBounds(320, 290, 80, 50);
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
		JButton defSet = new JButton("POR DEFECTO");
		defSet.setBounds(70, 400, 170, 50);
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
				Pesos.this.setIconImage(iconImages[0].getImage());
				btnsHideShow.setText("SI");
				btnsHideShow.setSelected(false);
				btnsHideShow2.setText("SI");
				btnsHideShow2.setSelected(false);
				op2C.setSelectedIndex(0);
				if (width > 1800 && height > 1000)
					resG(resoD, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel);
				else if (width > 1500 && height > 700)
					resM(resoD, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel);
				else if (width > 1300 && height > 700)
					resP(resoD, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel);
				else
					resXP(resoD, notasF, pesosF, newDay, clearEverthing, gastosPanel, aggPanel);
				btnsHideShow3.setText("SI");
				btnsHideShow3.setSelected(false);
			}
		});
		// SAVE
		JButton save = new JButton("SAVE");
		save.setBounds(300, 400, 100, 50);
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
					savedF.write(btnsHideShow.isSelected() + System.lineSeparator());
					savedF.write(btnsHideShow2.isSelected() + System.lineSeparator());
					savedF.write(op2C.getSelectedIndex() + System.lineSeparator());
					savedF.write(btnsHideShow3.isSelected() + System.lineSeparator());
					savedF.write(conf[5] + System.lineSeparator());
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
		temp.add(op3);
		temp.add(btnsHideShow);
		temp.add(btnsHideShow2);
		temp.add(op2C);
		temp.add(op4);
		temp.add(op5);
		temp.add(btnsHideShow3);
		temp.add(defSet);
		temp.add(save);
		temp.setVisible(true);
	}

	// Clear all funcion
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
		}
	}

	// Hide Btns
	private void hideBtn(JButton notasF, JButton pesosF, JButton newDay, JButton clearEverthing, JMenuItem hideBtn) {
		if (pesosF.isShowing()) {
			pesosF.hide();
			clearEverthing.hide();
			notasF.hide();
			hideBtn.setText("MONSTRAR LOS BOTONES");
			if (conf[0] != null && conf[0].equals("3"))
				newDay.hide();
		} else {
			pesosF.show();
			clearEverthing.show();
			notasF.show();
			hideBtn.setText("ESCONDER LOS BOTONES");
			if (conf[0] != null && conf[0].equals("3"))
				newDay.show();
		}
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
			if (!First.isNumeric(panelCnum[i].getText()))
				panelCnum[i].setText(0 + "");
		if (!First.isNumeric(initialDay.getText()))// initial of the day 0
			initialDay.setText(0 + "");
		for (int i = 8; i < 16; i++)// spent 0
			if (!First.isNumeric(gastosTable[i].getText()))
				gastosTable[i].setText("");
		for (int i = 8; i < 16; i++)// added 0
			if (!First.isNumeric(agregadoTable[i].getText()))
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
				if (!First.isNumeric(details[i][j].getText())) {
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
		if (!conf[0].equals("3")) {
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
		First.myFont = new Font("Tahoma", Font.BOLD, 17);
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
		total[6].setBounds(390, 500, 78, 30);
		total[8].setBounds(390, 470, 78, 30);
		initialDay.setBounds(520, 50, 70, 30);
		total[6].setFont(First.myFont);
		initialDay.setFont(First.myFont);
		total[8].setFont(First.myFont);
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
			gastosTable[i].setFont(First.myFont);
			agregadoTable[i].setFont(First.myFont);
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
		if (conf[0].equals("3")) {
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
		clearEverthing.setBounds(400, 400, 50, 50);
		total[7].setFont(First.myFont);
		diffResult[0].setFont(First.myFontS);
		diffResult[1].setFont(First.myFontS);
		restTmrw.setFont(First.myFontS);
		newDay.setFont(First.myFontS);
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
			total[i].setBounds(30 + i * 70, 570, 70, 29);
			total[i].setFont(First.myFont);
			for (int j = 0; j < 20; j++) {
				details[i][j].setBounds(30 + i * 70, 55 + j * 25, 70, 25);
				details[i][j].setFont(First.myFontS);
			}
		}
		total[6].setBounds(500, 590, 88, 35);
		total[8].setBounds(500, 560, 88, 30);
		initialDay.setBounds(670, 50, 80, 40);
		total[6].setFont(First.myFont);
		initialDay.setFont(First.myFont);
		total[8].setFont(First.myFont);
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
		if (conf[0].equals("3")) {
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
		notasF.setBounds(1180, 500, 60, 60);
		clearEverthing.setBounds(520, 460, 70, 70);
		total[7].setFont(First.myFont);
		diffResult[0].setFont(First.myFont);
		diffResult[1].setFont(First.myFont);
		restTmrw.setFont(First.myFont);
		newDay.setFont(First.myFont);
		notasF.setIcon(new ImageIcon(getScaledImage(notasI.getImage(), 60, 60)));
		pesosF.setIcon(new ImageIcon(getScaledImage(realesI.getImage(), 60, 60)));
		clearEverthing.setIcon(new ImageIcon(getScaledImage(clear.getImage(), 70, 70)));
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
			total[i].setBounds(30 + i * 80, 670, 80, 32);
			total[i].setFont(First.myFont);
			for (int j = 0; j < 20; j++) {
				details[i][j].setBounds(30 + i * 80, 55 + j * 30, 80, 30);
				details[i][j].setFont(First.myFontS);
			}
		}
		total[6].setBounds(540, 680, 98, 35);
		total[8].setBounds(540, 650, 98, 30);
		initialDay.setBounds(710, 50, 90, 50);
		total[6].setFont(First.myFont);
		initialDay.setFont(First.myFont);
		total[8].setFont(First.myFont);
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
		if (conf[0].equals("3")) {
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
		notasF.setBounds(1350, 580, 80, 80);
		clearEverthing.setBounds(560, 540, 70, 70);
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
			total[i].setBounds(30 + i * 90, 800, 90, 40);
			total[i].setFont(First.myFontS);
			for (int j = 0; j < 20; j++) {
				details[i][j].setBounds(30 + i * 90, 65 + j * 35, 90, 35);
				details[i][j].setFont(First.myFontS);
			}
		}
		total[6].setBounds(625, 830, 98, 45);
		total[8].setBounds(625, 790, 98, 40);
		boletoN[5].setFont(First.myFont);
		total[6].setFont(First.myFont);
		initialDay.setFont(First.myFont);
		total[8].setFont(First.myFont);
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
		if (conf[0].equals("3")) {
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
		clearEverthing.setBounds(650, 650, 80, 80);
		total[7].setFont(First.myFont);
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
		return keywords;
	}
}
