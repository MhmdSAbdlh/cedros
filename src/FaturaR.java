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
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.plaf.metal.MetalToggleButtonUI;

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
	int width, height;

	// Def
	static JTextField details[][] = new JTextField[10][3];
	static JLabel detailsR[] = new JLabel[10];
	static JLabel total = new JLabel("Total");
	static JLabel cambio[] = new JLabel[6];
	static JLabel[][] cajaTroco = new JLabel[2][7];
	static JLabel[] trocoC = new JLabel[8];
	static JFormattedTextField[] trocoCT = new JFormattedTextField[8];
	static JLabel[][] troco = new JLabel[2][7];
	static JLabel[][] troco2 = new JLabel[2][7];
	static JLabel[][] troco3 = new JLabel[2][7];
	static String numbers[] = new String[165];
	static JLabel totalC = new JLabel("Total");
	JLabel cambioC = new JLabel("Cliente");
	JLabel title[] = new JLabel[4];
	JLabel caja = new JLabel("Caja");
	static int totalFatura = 0, totalCV = 0, trocoV = 0;
	private MouseListener m1, m2, m3;

	FaturaR() {
		// Notification when its time to end the day
		long delay = ChronoUnit.MILLIS.between(LocalTime.now(), LocalTime.of(17, 30, 00));
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		scheduler.schedule(First.itsAlmostTime(), delay, TimeUnit.MILLISECONDS);

		// Btns
		JButton cambioN = new JButton("<html><center>" + "MÉTODO" + "<br>" + "SMART" + "</font></center></html>");
		JButton cambioN2 = new JButton("<html><center>" + "MÉTODO" + "<br>" + "POPULAR" + "</font></center></html>");
		JButton cambioN3 = new JButton("<html><center>" + "MÉTODO" + "<br>" + " BÁSICO" + "</font></center></html>");
		JButton calculate = new JButton("Magic");
		JButton mainF = new JButton();
		JButton clearB = new JButton();
		JMenuItem hideBtn = new JMenuItem("ESCONDER EL BOTON");

		// Frame
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int) screenSize.getWidth();
		height = (int) screenSize.getHeight();
		this.setTitle("FATURA - R$");
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
		this.getContentPane().setBackground(First.darkC);

		// Open Conf
		URL url;
		BufferedReader dataOpened = null;
		String line = "";
		int tempC = 0;
		String conf[] = new String[7];
		try {
			dataOpened = new BufferedReader(new FileReader(new File("conf.txt")));
			while ((line = dataOpened.readLine()) != null) {
				conf[tempC] = line.toString();
				tempC++;
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

		// hide btns
		if (conf[1] == null || !conf[1].equals("2")) {
			mainF.show();
			clearB.show();
			hideBtn.setText("ESCONDER LOS BOTONES");
		} else {
			mainF.hide();
			clearB.hide();
			hideBtn.setText("MONSTRAR LOS BOTONES");
		}

		// Open values of cash
		dataOpened = null;
		line = "";
		int z = 0;
		try {
			dataOpened = new BufferedReader(new FileReader(new File("cedros.txt")));
			while ((line = dataOpened.readLine()) != null) {
				numbers[z] = line.toString();
				z++;
			}
			dataOpened.close();
		} catch (Exception e) {
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
		title[0].setText("Cant");
		title[1].setText("Detalle");
		title[2].setText("P/Unit");
		title[3].setText("Importe");
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
		cambio[0].setText("Cliente");
		cambio[1].setText("Total");
		cambio[2].setText("Troco");

		// 1ST CAMBIO
		m1 = new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				cambioN.setBackground(redD);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				cambioN.setBackground(redC);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		};
		m2 = new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				cambioN2.setBackground(violetD);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				cambioN2.setBackground(violetC);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		};
		m3 = new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				cambioN3.setBackground(turD);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				cambioN3.setBackground(turC);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		};
		cambioN.setEnabled(false);
		cambioN.setBorder(First.border);
		cambioN.setForeground(First.lightC);
		cambioN.setBackground(redD);
		cambioN.setFocusable(false);
		cambioN.addActionListener(e -> {
			cambioF();
			cambioN.setText("<html><center>" + "MÉTODO" + "<br>" + "SMART" + "</center></html>");
			cambioN2.setText("<html><center>" + "MÉTODO" + "<br>" + " POPULAR" + "</center></html>");
			cambioN3.setText("<html><center>" + "MÉTODO" + "<br>" + " BÁSICO" + "</center></html>");
			cambioN.setEnabled(false);
			cambioN2.setEnabled(false);
			cambioN3.setEnabled(false);
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
		cambioN2.setEnabled(false);
		cambioN2.setBorder(First.border);
		cambioN2.setForeground(First.lightC);
		cambioN2.setBackground(violetD);
		cambioN2.setFocusable(false);
		cambioN2.addActionListener(e -> {
			cambioF2();
			cambioN.setText("<html><center>" + "MÉTODO" + "<br>" + "SMART" + "</center></html>");
			cambioN2.setText("<html><center>" + "MÉTODO" + "<br>" + " POPULAR" + "</center></html>");
			cambioN3.setText("<html><center>" + "MÉTODO" + "<br>" + " BÁSICO" + "</center></html>");
			cambioN.setEnabled(false);
			cambioN2.setEnabled(false);
			cambioN3.setEnabled(false);
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
		cambioN3.setEnabled(false);
		cambioN3.setBorder(First.border);
		cambioN3.setForeground(First.lightC);
		cambioN3.setBackground(turD);
		cambioN3.setFocusable(false);
		cambioN3.addActionListener(e -> {
			cambioF3();
			cambioN.setText("<html><center>" + "MÉTODO" + "<br>" + "SMART" + "</center></html>");
			cambioN2.setText("<html><center>" + "MÉTODO" + "<br>" + " POPULAR" + "</center></html>");
			cambioN3.setText("<html><center>" + "MÉTODO" + "<br>" + " BÁSICO" + "</center></html>");
			cambioN.setEnabled(false);
			cambioN2.setEnabled(false);
			cambioN3.setEnabled(false);
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
		JMenu file = new JMenu("ARCHIVO");
		JMenu goTo = new JMenu("IR A");
		JMenu help = new JMenu("AYUDA");
		JMenuItem clear = new JMenuItem("BORRAR TODO");
		JMenuItem calc = new JMenuItem("ASUMAR");
		JMenuItem option = new JMenuItem("CONFIGURACIÓN");
		JMenuItem exit = new JMenuItem("SALIR");
		JMenuItem reales = new JMenuItem("REALES");
		JMenuItem getHelp = new JMenuItem("ATAJOS DE TECLADO");
		JMenuItem creator = new JMenuItem("SOBRE EL CREADOR");
		JMenuItem about = new JMenuItem("SOBRE EL APLICATIVO");
		JMenu reso = new JMenu("RESOLUCIÓN");
		JMenuItem resoD = new JMenuItem("ÓPTIMO");
		JSeparator sep = new JSeparator();
		JMenuItem reso1 = new JMenuItem("GRANDE");
		JMenuItem reso2 = new JMenuItem("MEDIO");
		JMenuItem reso3 = new JMenuItem("PEQUENA");
		JMenuItem reso4 = new JMenuItem("X-PEQUENA");
		calc.addActionListener(e -> calTodo(cambioN, cambioN2, cambioN3));
		clear.addActionListener(e -> clearAll(cambioN, cambioN2, cambioN3));
		option.addActionListener(e -> confFrame(conf, mainF, clearB, hideBtn, resoD, cambioN, cambioN2, cambioN3));
		exit.addActionListener(e -> System.exit(0));
		reales.addActionListener(e -> {
			new Reales();
			this.dispose();
		});
		if (conf[2] == null || conf[2].equals("false"))
			getHelp.addActionListener(e -> JOptionPane.showMessageDialog(null,
					"• CTRL + S → ir la reales.\n" + "• CTRL + O → esconder los botones.\n"
							+ "• SHIFT → cambiar entre las dos tablas.\n"
							+ "• FLECHAS → subir, abajo, derecha e izquierda.\n",
					"ATAJOS DE TECLADO", 1));
		else
			getHelp.hide();
		hideBtn.addActionListener(e -> hideBtns(mainF, clearB, hideBtn));
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
				resG(resoD, cambioN, cambioN2, mainF, cambioN3, clearB);
			else if (width > 1500 && height > 700)
				resM(resoD, cambioN, cambioN2, mainF, cambioN3, clearB);
			else if (width > 1300 && height > 700)
				resP(resoD, cambioN, cambioN2, mainF, cambioN3, clearB);
			else
				resXP(resoD, cambioN, cambioN2, mainF, cambioN3, clearB);
		});
		reso1.addActionListener(e -> resG(resoD, cambioN, cambioN2, mainF, cambioN3, clearB));
		reso2.addActionListener(e -> resM(resoD, cambioN, cambioN2, mainF, cambioN3, clearB));
		reso3.addActionListener(e -> resP(resoD, cambioN, cambioN2, mainF, cambioN3, clearB));
		reso4.addActionListener(e -> resXP(resoD, cambioN, cambioN2, mainF, cambioN3, clearB));
		file.add(calc);
		file.add(clear);
		file.add(option);
		file.add(exit);
		goTo.add(reales);
		help.add(getHelp);
		help.add(hideBtn);
		help.add(creator);
		help.add(about);
		mb.add(file);
		mb.add(goTo);
		mb.add(reso);
		mb.add(help);
		this.setJMenuBar(mb);

		// Frame start
		this.getRootPane().setDefaultButton(calculate);
		this.setVisible(true);

		// Resolution
		if (conf[3] == null || conf[3].equals("0")) {
			if (width > 1800 && height > 1000)
				resG(resoD, cambioN, cambioN2, mainF, cambioN3, clearB);
			else if (width > 1500 && height > 700)
				resM(resoD, cambioN, cambioN2, mainF, cambioN3, clearB);
			else if (width > 1300 && height > 700)
				resP(resoD, cambioN, cambioN2, mainF, cambioN3, clearB);
			else
				resXP(resoD, cambioN, cambioN2, mainF, cambioN3, clearB);
		} else if (conf[3].equals("1"))
			resXP(resoD, cambioN, cambioN2, mainF, cambioN3, clearB);
		else if (conf[3].equals("2"))
			resP(resoD, cambioN, cambioN2, mainF, cambioN3, clearB);
		else if (conf[3].equals("3"))
			resM(resoD, cambioN, cambioN2, mainF, cambioN3, clearB);
		else
			resG(resoD, cambioN, cambioN2, mainF, cambioN3, clearB);

		// Close popup
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				Object[] options = { "Si", "No" };
				int selectedOption = JOptionPane.showOptionDialog(null, "¿Seguro que quieres salir?", "SALIR",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

				if (selectedOption == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});

	}

	private void confFrame(String[] conf, JButton realesF, JButton clearEverthing, JMenuItem hideBtn, JMenuItem resoD,
			JButton cambioN, JButton cambioN2, JButton cambioN3) {
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
				FaturaR.this.setIconImage(iconImages[op1C.getSelectedIndex()].getImage());
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
		btnsHideShow.setFont(First.myFontS);
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
		btnsHideShow2.setBounds(405, 230, 100, 40);
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
		op2C.setFont(First.myFontS);
		op2C.setBackground(First.lightC);
		op2C.setForeground(First.blueD);
		if (conf[3] != null)
			op2C.setSelectedIndex(Integer.valueOf(conf[3]));
		op2C.addActionListener(e -> {
			op2C.setSelectedIndex(op2C.getSelectedIndex());
			// Resolution
			if (op2C.getSelectedIndex() == 0) {
				if (width > 1800 && height > 1000)
					resG(resoD, cambioN, cambioN2, realesF, cambioN3, clearEverthing);
				else if (width > 1500 && height > 700)
					resM(resoD, cambioN, cambioN2, realesF, cambioN3, clearEverthing);
				else if (width > 1300 && height > 700)
					resP(resoD, cambioN, cambioN2, realesF, cambioN3, clearEverthing);
				else
					resXP(resoD, cambioN, cambioN2, realesF, cambioN3, clearEverthing);
			} else if (op2C.getSelectedIndex() == 1)
				resXP(resoD, cambioN, cambioN2, realesF, cambioN3, clearEverthing);
			else if (op2C.getSelectedIndex() == 2)
				resP(resoD, cambioN, cambioN2, realesF, cambioN3, clearEverthing);
			else if (op2C.getSelectedIndex() == 3)
				resM(resoD, cambioN, cambioN2, realesF, cambioN3, clearEverthing);
			else
				resG(resoD, cambioN, cambioN2, realesF, cambioN3, clearEverthing);
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

		// bottom line
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
				FaturaR.this.setIconImage(iconImages[0].getImage());
				btnsHideShow.setSelectedIndex(0);
				btnsHideShow2.setText("SI");
				btnsHideShow2.setSelected(false);
				op2C.setSelectedIndex(0);
				if (width > 1800 && height > 1000)
					resG(resoD, cambioN, cambioN2, realesF, cambioN3, clearEverthing);
				else if (width > 1500 && height > 700)
					resM(resoD, cambioN, cambioN2, realesF, cambioN3, clearEverthing);
				else if (width > 1300 && height > 700)
					resP(resoD, cambioN, cambioN2, realesF, cambioN3, clearEverthing);
				else
					resXP(resoD, cambioN, cambioN2, realesF, cambioN3, clearEverthing);
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
					savedF.write(conf[6] + System.lineSeparator());
					savedF.close();
				} catch (Exception e2) {
				}
				temp.dispose();
				FaturaR.this.dispose();
				new FaturaR();
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

	private void clearAll(JButton cambioN, JButton cambioN2, JButton cambioN3) {
		for (int i = 0; i < 7; i++)
			trocoCT[i].setText("0");
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 3; j++)
				details[i][j].setText("");
		for (int i = 0; i < 9; i++)
			detailsR[i].setText("");
		calTodo(cambioN, cambioN2, cambioN3);
		cambioN.setText("<html><center>" + "MÉTODO" + "<br>" + "SMART" + "</center></html>");
		cambioN2.setText("<html><center>" + "MÉTODO" + "<br>" + " POPULAR" + "</center></html>");
		cambioN3.setText("<html><center>" + "MÉTODO" + "<br>" + " BÁSICO" + "</center></html>");
		cambioN.setEnabled(false);
		cambioN2.setEnabled(false);
		cambioN3.setEnabled(false);
	}

	// Hide the button
	private void hideBtns(JButton mainF, JButton clearB, JMenuItem hideBtn) {
		if (mainF.isShowing()) {
			mainF.hide();
			clearB.hide();
			hideBtn.setText("MONSTRAR EL BOTON");
		} else {
			mainF.show();
			clearB.show();
			hideBtn.setText("ESCONDER EL BOTON");
		}
	}

	// Focus for the fatura
	private void tableFocus(int i, int j, JFrame frame, JButton mainF, JButton clearB, JMenuItem hideBtn) {
		details[i][j].addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// Hide
				if ((e.getKeyCode() == KeyEvent.VK_O) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0))
					hideBtns(mainF, clearB, hideBtn);
				// GO TO Main
				else if ((e.getKeyCode() == KeyEvent.VK_S) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					frame.dispose();
					new Reales();
				} else if ((e.getKeyCode() == KeyEvent.VK_SHIFT)) {
					details[i][j].setNextFocusableComponent(trocoCT[0]);
					details[i][j].nextFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
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
				if ((e.getKeyCode() == KeyEvent.VK_O) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0))
					hideBtns(mainF, clearB, hideBtn);
				// GO TO Main
				else if ((e.getKeyCode() == KeyEvent.VK_S) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					frame.dispose();
					new Reales();
				} else if ((e.getKeyCode() == KeyEvent.VK_SHIFT)) {
					trocoCT[i].setNextFocusableComponent(details[0][0]);
					trocoCT[i].nextFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
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
		cambioN.removeMouseListener(m1);
		cambioN2.removeMouseListener(m2);
		cambioN3.removeMouseListener(m3);
		if (cambioN.getText().equals("√")) {
			cambioN.setEnabled(true);
			cambioN.addMouseListener(m1);
			cambioN.setBorder(First.workM);
		} else {
			cambioN.setEnabled(false);
			cambioN.removeMouseListener(m1);
			cambioN.setBorder(First.border);
		}
		if (cambioN2.getText().equals("√")) {
			cambioN2.setEnabled(true);
			cambioN2.addMouseListener(m2);
			cambioN2.setBorder(First.workM);
		} else {
			cambioN2.setEnabled(false);
			cambioN2.removeMouseListener(m2);
			cambioN2.setBorder(First.border);
		}
		if (cambioN3.getText().equals("√")) {
			cambioN3.setEnabled(true);
			cambioN3.addMouseListener(m3);
			cambioN3.setBorder(First.workM);
		} else {
			cambioN3.setEnabled(false);
			cambioN3.removeMouseListener(m3);
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

	// SAVE NEW VALUE
	private static void saveProgress() {
		String temp = totalFatura + "";
		int z = 0;
		try {
			FileWriter savedF = new FileWriter("cedros.txt");
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
			savedF.write("0" + System.lineSeparator());// set of 100
			i++;// valor of 200 in the cash + that the cliente paid
			if (!First.isNumeric(trocoCT[7].getText()))
				trocoCT[7].setText("0");
			int nb200 = Integer.valueOf(numbers[i]) + Integer.valueOf(trocoCT[7].getText());
			savedF.write(nb200 + System.lineSeparator());
			i++;
			z = i + 7;
			while (i < z) {// Valores from 1 to 100
				savedF.write(cajaTroco[1][z - i - 1].getText() + System.lineSeparator());
				i++;
			}
			savedF.write(numbers[i]);// pix save
			savedF.close();
		} catch (Exception e) {
		}
	}

	// Style of textField
	private void textFieldStyle(JTextField tf) {
		tf.setBackground(blueC);
		tf.setForeground(blueD);
		tf.setFont(First.myFont);
		tf.setBorder(First.border);
		tf.setHorizontalAlignment(0);
		tf.setCaretColor(First.darkC);
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
		tf.setCaretColor(First.darkC);
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

	private void resXP(JMenuItem resoD, JButton cambioN, JButton cambioN2, JButton mainF, JButton cambioN3,
			JButton clearB) {
		// dimensions
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

	private void resP(JMenuItem resoD, JButton cambioN, JButton cambioN2, JButton mainF, JButton cambioN3,
			JButton clearB) {
		// dimensions
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
		First.myFont = new Font("Tahoma", Font.BOLD, 17);
		First.myFontS = new Font("Tahoma", Font.BOLD, 14);

		// invoice
		for (int i = 0; i < 4; i++)
			title[i].setFont(First.myFont);
		title[0].setBounds(40, 40, 60, 40);
		title[1].setBounds(98, 40, 180, 40);
		title[2].setBounds(276, 40, 70, 40);
		title[3].setBounds(344, 40, 100, 40);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 3; j++)
				details[i][j].setFont(First.myFont);
			details[i][0].setBounds(40, 80 + i * 35, 60, 35);
			details[i][1].setBounds(98, 80 + i * 35, 180, 35);
			details[i][2].setBounds(276, 80 + i * 35, 70, 35);
		}
		for (int i = 0; i < 10; i++) {
			detailsR[i].setBounds(344, 80 + i * 35, 100, 35);
			detailsR[i].setFont(First.myFont);
		}
		total.setFont(First.myFont);
		total.setBounds(344, 428, 100, 40);

		// caja
		caja.setBounds(20, 520, 50, 79);
		caja.setFont(First.myFont);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 7; j++) {
				cajaTroco[i][j].setBounds(70 + 59 * j, 520 + 39 * i, 60, 40);
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

	private void resM(JMenuItem resoD, JButton cambioN, JButton cambioN2, JButton mainF, JButton cambioN3,
			JButton clearB) {
		// dimensions
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
		caja.setBounds(20, 580, 60, 99);
		caja.setFont(First.myFont);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 7; j++) {
				cajaTroco[i][j].setBounds(80 + 69 * j, 580 + 49 * i, 70, 50);
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

	private void resG(JMenuItem resoD, JButton cambioN, JButton cambioN2, JButton mainF, JButton cambioN3,
			JButton clearB) {
		// dimensions
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
		ArrayList<String> keywords = new ArrayList<String>(61);
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
