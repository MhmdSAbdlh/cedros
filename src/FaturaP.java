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
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.plaf.metal.MetalToggleButtonUI;

@SuppressWarnings("serial")
public class FaturaP extends JFrame {
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
	static JLabel[][] cajaTroco = new JLabel[2][10];
	static JLabel[] trocoC = new JLabel[11];
	static JFormattedTextField[] trocoCT = new JFormattedTextField[11];
	static JLabel[][] troco = new JLabel[2][10];
	static JLabel[][] troco2 = new JLabel[2][10];
	static JLabel[][] troco3 = new JLabel[2][10];
	static String numbers[] = new String[104];
	static JLabel totalC = new JLabel("Total");
	static int totalFatura = 0, totalCV = 0, trocoV = 0;
	JLabel cambioC = new JLabel("Cliente");
	JLabel title[] = new JLabel[4];
	JLabel caja = new JLabel("Caja");
	private MouseListener m1, m2, m3;

	FaturaP() {
		// BTNS
		JButton cambioN = new JButton("<html><center>" + "MÉTODO" + "<br>" + "SMART" + "</center></html>");
		JButton cambioN2 = new JButton("<html><center>" + "MÉTODO" + "<br>" + "POPULAR" + "</center></html>");
		JButton cambioN3 = new JButton("<html><center>" + "MÉTODO" + "<br>" + " BÁSICO" + "</center></html>");
		JButton calculate = new JButton("Magic");
		JButton mainF = new JButton();
		JButton clearB = new JButton();
		JMenuItem hideBtn = new JMenuItem("ESCONDER EL BOTON");

		// Frame
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int) screenSize.getWidth();
		height = (int) screenSize.getHeight();
		this.setTitle("FATURA - P$");
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
		String conf[] = new String[4];
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
			url = getClass().getResource("images/icon/icon.png");
		} else if (conf[0].equals("1")) {
			url = getClass().getResource("images/icon/cedros.png");
		} else {
			url = getClass().getResource("images/icon/narjes.png");
		}
		this.setIconImage(new ImageIcon(url).getImage());

		// hide btns
		if (conf[1] == null || conf[1].equals("false")) {
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
			dataOpened = new BufferedReader(new FileReader(new File("cedrosP.txt")));
			while ((line = dataOpened.readLine()) != null) {
				numbers[z] = line.toString();
				z++;
			}
			dataOpened.close();
		} catch (Exception e) {
		}

		// Window1
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
			for (int j = 0; j < 10; j++) {
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
		for (int i = 0; i < 11; i++) {
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
			Popup p;

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				cambioN.setBackground(redD);
				p.hide();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				cambioN.setBackground(redC);
				p = PopupFactory.getSharedInstance().getPopup(cambioN, new JLabel("TOQUE AQUÍ PARA USARLO"),
						cambioN.getHeight() + cambioN.getX(), cambioN.getWidth() + cambioN.getY());
				p.show();
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		};
		m2 = new MouseListener() {
			Popup p;

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				cambioN2.setBackground(violetD);
				p.hide();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				cambioN2.setBackground(violetC);
				p = PopupFactory.getSharedInstance().getPopup(cambioN2, new JLabel("TOQUE AQUÍ PARA USARLO"),
						cambioN2.getHeight() + cambioN2.getX(), cambioN2.getWidth() + cambioN2.getY());
				p.show();
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		};
		m3 = new MouseListener() {
			Popup p;

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				cambioN3.setBackground(turD);
				p.hide();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				cambioN3.setBackground(turC);
				p = PopupFactory.getSharedInstance().getPopup(cambioN3, new JLabel("TOQUE AQUÍ PARA USARLO"),
						cambioN3.getHeight() + cambioN3.getX(), cambioN3.getWidth() + cambioN3.getY());
				p.show();
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
			for (int j = 0; j < 10; j++) {
				troco[i][j] = new JLabel();
				if (i == 1)
					troco[i][j].setText("0");
				troco[i][j].setHorizontalAlignment(0);
				troco[i][j].setBorder(First.border);
				troco[i][j].setOpaque(true);
				troco[i][j].setBackground(redC);
				troco[i][j].setForeground(Color.white);
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
			for (int j = 0; j < 10; j++) {
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
			for (int j = 0; j < 10; j++) {
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
			new Pesos();
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
		z = 93;
		for (int i = 0; i < 10; i++) {
			cajaTroco[1][9 - i].setText(numbers[z]);
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
		JMenuItem reales = new JMenuItem("PESOS");
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
			new Pesos();
			this.dispose();
		});
		if (conf[2] == null || conf[2].equals("false"))
			getHelp.addActionListener(e -> JOptionPane.showMessageDialog(null,
					"• CTRL + S → ir la pesos.\n" + "• CTRL + O → esconder los botones.\n"
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
		temp.setSize(500, 500);
		temp.setLocationRelativeTo(null);
		temp.setResizable(false);
		temp.setLayout(null);
		temp.getContentPane().setBackground(First.lightC);
		// Stuff
		JLabel op1 = new JLabel("ICONO");
		op1.setBounds(50, 20, 150, 80);
		op1.setFont(First.myFont);
		URL cedros1 = getClass().getResource("images/icon/icon.png");
		URL cedros2 = getClass().getResource("images/icon/cedros.png");
		URL narjes = getClass().getResource("images/icon/narjes.png");
		ImageIcon iconImages[] = new ImageIcon[3];
		iconImages[0] = new ImageIcon(getScaledImage(new ImageIcon(cedros1).getImage(), 50, 50));
		iconImages[1] = new ImageIcon(getScaledImage(new ImageIcon(cedros2).getImage(), 50, 50));
		iconImages[2] = new ImageIcon(getScaledImage(new ImageIcon(narjes).getImage(), 50, 50));
		JComboBox<ImageIcon> op1C = new JComboBox<>(iconImages);
		op1C.setBounds(320, 20, 80, 80);
		if (conf[0] != null)
			op1C.setSelectedIndex(Integer.valueOf(conf[0]));
		op1C.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FaturaP.this.setIconImage(iconImages[op1C.getSelectedIndex()].getImage());
				op1C.setSelectedIndex(op1C.getSelectedIndex());
			}
		});
		// OPTION 1 BUTTONS HIDE
		JLabel op2 = new JLabel("BOTONES");
		op2.setBounds(50, 120, 150, 50);
		op2.setFont(First.myFont);
		JToggleButton btnsHideShow = new JToggleButton();
		if (conf[1] == null || conf[1].equals("false")) {
			btnsHideShow.setText("SI");
		} else {
			btnsHideShow.setText("NO");
			btnsHideShow.setSelected(true);
		}
		btnsHideShow.setBounds(320, 120, 80, 50);
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
					realesF.hide();
					clearEverthing.hide();
					hideBtn.setText("MONSTRAR LOS BOTONES");
				} else {
					realesF.show();
					clearEverthing.show();
					hideBtn.setText("ESCONDER LOS BOTONES");
					btnsHideShow.setText("SI");
				}
			}
		});
		// OPTION 2 DISABLE KEYBOARD SHORTCUT
		JLabel op3 = new JLabel("ATAJO DE TECLADO");
		op3.setBounds(50, 190, 250, 50);
		op3.setFont(First.myFont);
		JToggleButton btnsHideShow2 = new JToggleButton();
		if (conf[2] == null || conf[2].equals("false")) {
			btnsHideShow2.setText("SI");
		} else {
			btnsHideShow2.setText("NO");
			btnsHideShow2.setSelected(true);
		}
		btnsHideShow2.setBounds(320, 190, 80, 50);
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
		op4.setBounds(50, 260, 250, 50);
		op4.setFont(First.myFont);
		String res[] = { "OPTIMAL", "X-P", "P", "M", "G" };
		JComboBox<String> op2C = new JComboBox<>(res);
		op2C.setBounds(280, 260, 140, 50);
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

		// SAVE
		JButton save = new JButton("Save");
		save.setBounds(200, 400, 100, 50);
		First.btnStyle(save);
		save.setBackground(First.darkC);
		save.setForeground(First.lightC);
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					FileWriter savedF = new FileWriter("conf.txt");
					savedF.write(op1C.getSelectedIndex() + System.lineSeparator());
					savedF.write(btnsHideShow.isSelected() + System.lineSeparator());
					savedF.write(btnsHideShow2.isSelected() + System.lineSeparator());
					savedF.write(op2C.getSelectedIndex() + System.lineSeparator());
					savedF.close();
				} catch (Exception e2) {
				}
				temp.dispose();
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
		temp.add(save);
		temp.setVisible(true);
	}

	private void clearAll(JButton cambioN, JButton cambioN2, JButton cambioN3) {
		for (int i = 0; i < 10; i++)
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
					new Pesos();
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
					new Pesos();
				} else if ((e.getKeyCode() == KeyEvent.VK_SHIFT)) {
					trocoCT[i].setNextFocusableComponent(details[0][0]);
					trocoCT[i].nextFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (i < 10) {
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
						trocoCT[i].setNextFocusableComponent(trocoCT[10]);
						trocoCT[i].nextFocus();
					}
			}
		});
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

	// Method 1 work
	private void cambioF() {
		for (int i = 0; i < 10; i++)
			cajaTroco[1][i].setText(Integer.valueOf(cajaTroco[1][i].getText()) - Integer.valueOf(troco[1][i].getText())
					+ Integer.valueOf(trocoCT[i].getText()) + "");
		saveProgress();
	}

	// Method 2 work
	private void cambioF2() {
		for (int i = 0; i < 10; i++)
			cajaTroco[1][i].setText(Integer.valueOf(cajaTroco[1][i].getText()) - Integer.valueOf(troco2[1][i].getText())
					+ Integer.valueOf(trocoCT[i].getText()) + "");
		saveProgress();
	}

	// Method 3 work
	private void cambioF3() {
		for (int i = 0; i < 10; i++)
			cajaTroco[1][i].setText(Integer.valueOf(cajaTroco[1][i].getText()) - Integer.valueOf(troco3[1][i].getText())
					+ Integer.valueOf(trocoCT[i].getText()) + "");
		saveProgress();
	}

	// Calculate everything
	private void calTodo(JButton cambioN, JButton cambioN2, JButton cambioN3) {
		totalFatura = 0;
		for (int i = 0; i < 10; i++)// Check if the value are number
			if (!details[i][0].getText().isBlank() && !details[i][2].getText().isBlank()
					&& First.isNumeric(details[i][0].getText()) && First.isNumeric(details[i][2].getText())) {
				detailsR[i].setText(
						Integer.valueOf(details[i][0].getText()) * Integer.valueOf(details[i][2].getText()) + "");
				totalFatura += Integer.valueOf(detailsR[i].getText());
			}
		for (int i = 0; i < 11; i++)
			if (!First.isNumeric(trocoCT[i].getText()))
				trocoCT[i].setText("0");
		// Calculate totals
		total.setText("$ " + totalFatura);
		totalCV = Integer.valueOf(trocoCT[0].getText()) + Integer.valueOf(trocoCT[1].getText()) * 2
				+ Integer.valueOf(trocoCT[2].getText()) * 5 + Integer.valueOf(trocoCT[3].getText()) * 10
				+ Integer.valueOf(trocoCT[4].getText()) * 20 + Integer.valueOf(trocoCT[5].getText()) * 50
				+ Integer.valueOf(trocoCT[6].getText()) * 100 + Integer.valueOf(trocoCT[7].getText()) * 200
				+ Integer.valueOf(trocoCT[8].getText()) * 500 + Integer.valueOf(trocoCT[9].getText()) * 1000
				+ Integer.valueOf(trocoCT[10].getText()) * 2000;
		totalC.setText("$ " + totalCV);
		cambio[3].setText("$ " + totalFatura);
		cambio[5].setText("$ " + totalCV);
		trocoV = totalCV - totalFatura;
		if (totalCV < totalFatura)
			cambio[4].setText("-$ " + (totalFatura - totalCV));
		else
			cambio[4].setText("$ " + (totalCV - totalFatura));
		// Trocos
		if (trocoV >= 0) {
			// method 1
			int trocoRest = trocoV;
			int nbOf1000 = Integer.valueOf(cajaTroco[1][9].getText()),
					nbOf500 = Integer.valueOf(cajaTroco[1][8].getText()),
					nbOf200 = Integer.valueOf(cajaTroco[1][7].getText()),
					nbOf100 = Integer.valueOf(cajaTroco[1][6].getText()),
					nbOf50 = Integer.valueOf(cajaTroco[1][5].getText()),
					nbOf20 = Integer.valueOf(cajaTroco[1][4].getText()),
					nbOf10 = Integer.valueOf(cajaTroco[1][3].getText()),
					nbOf5 = Integer.valueOf(cajaTroco[1][2].getText()),
					nbOf2 = Integer.valueOf(cajaTroco[1][1].getText()),
					nbOf1 = Integer.valueOf(cajaTroco[1][0].getText());
			// 1000
			if (trocoRest > 1000)
				if (((trocoRest / 100) & 1) == 1 && nbOf100 == 0 && nbOf200 * 200 >= (trocoRest - 500)
						&& trocoRest < 1500) {
					if (nbOf500 > 0) {
						nbOf500--;
						trocoRest -= 500;
					}
				} else {
					if (nbOf1000 > 0) {
						nbOf1000--;
						trocoRest -= 1000;
					}
				}
			// 100,200,500
			if (((trocoRest / 100) & 1) == 0 && nbOf100 == 0 && nbOf200 * 200 >= trocoRest)// we dont have 100
				while (trocoRest >= 200 && nbOf200 > 0) {
					nbOf200--;
					trocoRest -= 200;
				}
			else {// normal
				while (trocoRest >= 500 && nbOf500 > 0) {
					nbOf500--;
					trocoRest -= 500;
				}
				while (trocoRest >= 200 && nbOf200 > 0) {
					nbOf200--;
					trocoRest -= 200;
				}
				while (trocoRest >= 100 && nbOf100 > 0) {
					nbOf100--;
					trocoRest -= 100;
				}
			}
			// 100
			if (trocoRest > 100)
				if (((trocoRest / 10) & 1) == 1 && nbOf10 == 0 && nbOf20 * 20 >= (trocoRest - 50) && trocoRest < 150) {
					nbOf50--;
					trocoRest -= 50;
				} else {
					nbOf100--;
					trocoRest -= 100;
				}
			// 100,200,500
			if (((trocoRest / 100) & 1) == 0 && nbOf100 == 0)// we dont have 100
				while (trocoRest >= 200 && nbOf200 > 0) {
					nbOf200--;
					trocoRest -= 200;
				}
			else {// normal
				while (trocoRest >= 500 && nbOf500 > 0) {
					nbOf500--;
					trocoRest -= 500;
				}
				while (trocoRest >= 200 && nbOf200 > 0) {
					nbOf200--;
					trocoRest -= 200;
				}
				while (trocoRest >= 100 && nbOf100 > 0) {
					nbOf100--;
					trocoRest -= 100;
				}
			}
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
			if (trocoRest == 0) {// smart
				troco[1][9].setText(Integer.valueOf(cajaTroco[1][9].getText()) - nbOf1000 + "");
				troco[1][8].setText(Integer.valueOf(cajaTroco[1][8].getText()) - nbOf500 + "");
				troco[1][7].setText(Integer.valueOf(cajaTroco[1][7].getText()) - nbOf200 + "");
				troco[1][6].setText(Integer.valueOf(cajaTroco[1][6].getText()) - nbOf100 + "");
				troco[1][5].setText(Integer.valueOf(cajaTroco[1][5].getText()) - nbOf50 + "");
				troco[1][4].setText(Integer.valueOf(cajaTroco[1][4].getText()) - nbOf20 + "");
				troco[1][3].setText(Integer.valueOf(cajaTroco[1][3].getText()) - nbOf10 + "");
				troco[1][2].setText(Integer.valueOf(cajaTroco[1][2].getText()) - nbOf5 + "");
				troco[1][1].setText(Integer.valueOf(cajaTroco[1][1].getText()) - nbOf2 + "");
				troco[1][0].setText(Integer.valueOf(cajaTroco[1][0].getText()) - nbOf1 + "");
				cambioN.setText("√");
			} else {
				methodReserva();
				if (Integer.valueOf(troco[1][0].getText()) <= Integer.valueOf((cajaTroco[1][0].getText()))
						&& Integer.valueOf(troco[1][1].getText()) <= Integer.valueOf((cajaTroco[1][1].getText()))
						&& Integer.valueOf(troco[1][2].getText()) <= Integer.valueOf((cajaTroco[1][2].getText()))
						&& Integer.valueOf(troco[1][3].getText()) <= Integer.valueOf((cajaTroco[1][3].getText()))
						&& Integer.valueOf(troco[1][4].getText()) <= Integer.valueOf((cajaTroco[1][4].getText()))
						&& Integer.valueOf(troco[1][5].getText()) <= Integer.valueOf((cajaTroco[1][5].getText()))
						&& Integer.valueOf(troco[1][6].getText()) <= Integer.valueOf((cajaTroco[1][6].getText()))
						&& Integer.valueOf(troco[1][7].getText()) <= Integer.valueOf((cajaTroco[1][7].getText()))
						&& Integer.valueOf(troco[1][8].getText()) <= Integer.valueOf((cajaTroco[1][8].getText()))
						&& Integer.valueOf(troco[1][9].getText()) <= Integer.valueOf((cajaTroco[1][9].getText())))
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
					&& Integer.valueOf(troco2[1][6].getText()) <= Integer.valueOf((cajaTroco[1][6].getText()))
					&& Integer.valueOf(troco2[1][7].getText()) <= Integer.valueOf((cajaTroco[1][7].getText()))
					&& Integer.valueOf(troco2[1][8].getText()) <= Integer.valueOf((cajaTroco[1][8].getText()))
					&& Integer.valueOf(troco2[1][9].getText()) <= Integer.valueOf((cajaTroco[1][9].getText())))
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
					&& Integer.valueOf(troco3[1][6].getText()) <= Integer.valueOf((cajaTroco[1][6].getText()))
					&& Integer.valueOf(troco3[1][7].getText()) <= Integer.valueOf((cajaTroco[1][7].getText()))
					&& Integer.valueOf(troco3[1][8].getText()) <= Integer.valueOf((cajaTroco[1][8].getText()))
					&& Integer.valueOf(troco3[1][9].getText()) <= Integer.valueOf((cajaTroco[1][9].getText())))
				cambioN3.setText("√");
			else
				cambioN3.setText("X");
		} else

		{
			troco[1][9].setText("!");
			troco[1][8].setText("!");
			troco[1][7].setText("!");
			troco[1][6].setText("!");
			troco[1][5].setText("!");
			troco[1][4].setText("!");
			troco[1][3].setText("!");
			troco[1][2].setText("!");
			troco[1][1].setText("!");
			troco[1][0].setText("!");
			troco2[1][9].setText("!");
			troco2[1][8].setText("!");
			troco2[1][7].setText("!");
			troco2[1][6].setText("!");
			troco2[1][5].setText("!");
			troco2[1][4].setText("!");
			troco2[1][3].setText("!");
			troco2[1][2].setText("!");
			troco2[1][1].setText("!");
			troco2[1][0].setText("!");
			troco3[1][9].setText("!");
			troco3[1][8].setText("!");
			troco3[1][7].setText("!");
			troco3[1][6].setText("!");
			troco3[1][5].setText("!");
			troco3[1][4].setText("!");
			troco3[1][3].setText("!");
			troco3[1][2].setText("!");
			troco3[1][1].setText("!");
			troco3[1][0].setText("!");
		}
		cambioN.removeMouseListener(m1);
		cambioN2.removeMouseListener(m2);
		cambioN3.removeMouseListener(m3);
		if (cambioN.getText().equals("√")) {
			cambioN.setEnabled(true);
			cambioN.addMouseListener(m1);
		} else {
			cambioN.setEnabled(false);
			cambioN.removeMouseListener(m1);
		}
		if (cambioN2.getText().equals("√")) {
			cambioN2.setEnabled(true);
			cambioN2.addMouseListener(m2);
		} else {
			cambioN2.setEnabled(false);
			cambioN2.removeMouseListener(m2);
		}
		if (cambioN3.getText().equals("√")) {
			cambioN3.setEnabled(true);
			cambioN3.addMouseListener(m3);
		} else {
			cambioN3.setEnabled(false);
			cambioN3.removeMouseListener(m3);
		}
	}

	private void methodReserva() {
		// Por 1000
		troco[1][9].setText((trocoV / 1000) + "");
		// Por 100,200,500
		switch ((trocoV - (trocoV / 1000) * 1000) / 100) {
		case 0: {
			troco[1][8].setText("0");
			troco[1][7].setText("0");
			troco[1][6].setText("0");
			break;
		}
		case 1: {
			troco[1][8].setText("0");
			troco[1][7].setText("0");
			troco[1][6].setText("1");
			break;
		}
		case 2: {
			troco[1][8].setText("0");
			troco[1][7].setText("0");
			troco[1][6].setText("2");
			break;
		}
		case 3: {
			troco[1][8].setText("0");
			troco[1][7].setText("0");
			troco[1][6].setText("3");
			break;
		}
		case 4: {
			troco[1][8].setText("0");
			troco[1][7].setText("0");
			troco[1][6].setText("4");
			break;
		}
		case 5: {
			troco[1][8].setText("0");
			troco[1][7].setText("1");
			troco[1][6].setText("3");
			break;
		}
		case 6: {
			troco[1][8].setText("0");
			troco[1][7].setText("2");
			troco[1][6].setText("2");
			break;
		}
		case 7: {
			troco[1][8].setText("1");
			troco[1][7].setText("0");
			troco[1][6].setText("2");
			break;
		}
		case 8: {
			troco[1][8].setText("1");
			troco[1][7].setText("0");
			troco[1][6].setText("3");
			break;
		}
		case 9: {
			troco[1][8].setText("1");
			troco[1][7].setText("1");
			troco[1][6].setText("2");
			break;
		}
		}
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
		// Por 1000
		troco3[1][9].setText((trocoV / 1000) + "");
		// Por 100,200,500
		switch ((trocoV - (trocoV / 1000) * 1000) / 100) {
		case 0: {
			troco3[1][8].setText("0");
			troco3[1][7].setText("0");
			troco3[1][6].setText("0");
			break;
		}
		case 1: {
			troco3[1][8].setText("0");
			troco3[1][7].setText("0");
			troco3[1][6].setText("1");
			break;
		}
		case 2: {
			troco3[1][8].setText("0");
			troco3[1][7].setText("1");
			troco3[1][6].setText("0");
			break;
		}
		case 3: {
			troco3[1][8].setText("0");
			troco3[1][7].setText("1");
			troco3[1][6].setText("1");
			break;
		}
		case 4: {
			troco3[1][8].setText("0");
			troco3[1][7].setText("1");
			troco3[1][6].setText("2");
			break;
		}
		case 5: {
			troco3[1][8].setText("0");
			troco3[1][7].setText("2");
			troco3[1][6].setText("1");
			break;
		}
		case 6: {
			troco3[1][8].setText("0");
			troco3[1][7].setText("3");
			troco3[1][6].setText("0");
			break;
		}
		case 7: {
			troco3[1][8].setText("0");
			troco3[1][7].setText("3");
			troco3[1][6].setText("1");
			break;
		}
		case 8: {
			troco3[1][8].setText("0");
			troco3[1][7].setText("4");
			troco3[1][6].setText("0");
			break;
		}
		case 9: {
			troco3[1][8].setText("0");
			troco3[1][7].setText("4");
			troco3[1][6].setText("1");
			break;
		}
		}
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
		// Por 1000
		troco2[1][9].setText((trocoV / 1000) + "");
		// Por 100,200,500
		switch ((trocoV - (trocoV / 1000) * 1000) / 100) {
		case 0: {
			troco2[1][8].setText("0");
			troco2[1][7].setText("0");
			troco2[1][6].setText("0");
			break;
		}
		case 1: {
			troco2[1][8].setText("0");
			troco2[1][7].setText("0");
			troco2[1][6].setText("1");
			break;
		}
		case 2: {
			troco2[1][8].setText("0");
			troco2[1][7].setText("1");
			troco2[1][6].setText("0");
			break;
		}
		case 3: {
			troco2[1][8].setText("0");
			troco2[1][7].setText("1");
			troco2[1][6].setText("1");
			break;
		}
		case 4: {
			troco2[1][8].setText("0");
			troco2[1][7].setText("2");
			troco2[1][6].setText("0");
			break;
		}
		case 5: {
			troco2[1][8].setText("1");
			troco2[1][7].setText("0");
			troco2[1][6].setText("0");
			break;
		}
		case 6: {
			troco2[1][8].setText("1");
			troco2[1][7].setText("0");
			troco2[1][6].setText("1");
			break;
		}
		case 7: {
			troco2[1][8].setText("1");
			troco2[1][7].setText("1");
			troco2[1][6].setText("0");
			break;
		}
		case 8: {
			troco2[1][8].setText("1");
			troco2[1][7].setText("1");
			troco2[1][6].setText("1");
			break;
		}
		case 9: {
			troco2[1][8].setText("1");
			troco2[1][7].setText("2");
			troco2[1][6].setText("0");
			break;
		}
		}
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
			FileWriter savedF = new FileWriter("cedrosp.txt");
			int i = 0;
			while (i < 75) {// Details
				if ((numbers[i].isBlank() || Integer.valueOf(numbers[i]) == 0 || !First.isNumeric(numbers[i]))
						&& Integer.valueOf(temp) != 0 && !totalC.getText().isBlank()) {
					savedF.write(temp + System.lineSeparator());// total
					temp = "0";
					i++;
				} else {
					savedF.write(numbers[i] + System.lineSeparator());
					i++;
				}
			}
			savedF.write(numbers[i] + System.lineSeparator());// Initial
			i++;
			z = i + 8;
			while (i < z) {// Gatos
				savedF.write(numbers[i] + System.lineSeparator());
				i++;
			}
			z = i + 8;
			while (i < z) {// Agregado
				savedF.write(numbers[i] + System.lineSeparator());
				i++;
			}
			if (!First.isNumeric(trocoCT[10].getText()))
				trocoCT[10].setText("0");
			int nb2000 = Integer.valueOf(numbers[i]) + Integer.valueOf(trocoCT[10].getText());
			savedF.write(nb2000 + System.lineSeparator());// 2000
			z = i + 10;
			while (i < z) {// 100,500,200,100,50,20,10,5,2,1
				savedF.write(cajaTroco[1][z - i - 1].getText() + System.lineSeparator());
				i++;
			}

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
				for (int i = 0; i < 10; i++)// Check if the value are number
					if (!details[i][0].getText().isBlank() && !details[i][2].getText().isBlank()
							&& First.isNumeric(details[i][0].getText()) && First.isNumeric(details[i][2].getText())) {
						detailsR[i].setText(
								Integer.valueOf(details[i][0].getText()) * Integer.valueOf(details[i][2].getText())
										+ "");
						totalFatura += Integer.valueOf(detailsR[i].getText());
					} else
						detailsR[i].setText("");
				// Calculate totals
				total.setText("$ " + totalFatura);
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
		First.myFont = new Font("Tahoma", Font.BOLD, 15);
		First.myFontS = new Font("Tahoma", Font.BOLD, 12);

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

		// Caja
		caja.setBounds(20, 420, 431, 30);
		caja.setFont(First.myFont);

		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 10; j++) {
				if (j < 4)
					cajaTroco[i][j].setBounds(20 + 34 * j, 450 + 34 * i, 35, 35);
				else
					cajaTroco[i][j].setBounds(156 + 49 * (j - 4), 450 + 34 * i, 50, 35);
				cajaTroco[i][j].setFont(First.myFont);
				if (i == 0) {
					switch (j) {
					case 0:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 35, 35)));
						break;
					case 1:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 35, 35)));
						break;
					case 2:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 35, 35)));
						break;
					case 3:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 35, 35)));
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
					case 7:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i200.getImage(), 50, 35)));
						break;
					case 8:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i500.getImage(), 50, 35)));
						break;
					case 9:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i1000.getImage(), 50, 35)));
					default:
						break;
					}
				}
			}
		// Cambio Cliente
		cambioC.setBounds(400, 52, 410, 40);
		cambioC.setFont(First.myFont);
		for (int i = 0; i < 11; i++) {
			if (i < 4) {
				trocoC[i].setBounds(400 + 34 * i, 90, 35, 35);
				trocoCT[i].setBounds(400 + 34 * i, 125, 35, 35);
			} else {
				trocoC[i].setBounds(536 + 39 * (i - 4), 90, 40, 35);
				trocoCT[i].setBounds(536 + 39 * (i - 4), 125, 40, 35);
			}
			switch (i) {
			case 0:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 35, 35)));
				break;
			case 1:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 35, 35)));
				break;
			case 2:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 35, 35)));
				break;
			case 3:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 35, 35)));
				break;
			case 4:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i20.getImage(), 40, 35)));
				break;
			case 5:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i50.getImage(), 40, 35)));
				break;
			case 6:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i100.getImage(), 40, 35)));
				break;
			case 7:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i200.getImage(), 40, 35)));
				break;
			case 8:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i500.getImage(), 40, 35)));
				break;
			case 9:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i1000.getImage(), 40, 35)));
				break;
			case 10:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i2000.getImage(), 40, 35)));
				break;
			default:
				break;
			}
			trocoCT[i].setFont(First.myFont);
		}
		totalC.setBounds(400, 158, 410, 40);
		totalC.setFont(First.myFont);

		// Cambio panel
		for (int i = 0; i < 6; i++) {
			cambio[i].setFont(First.myFont);
			if (i < 3)
				cambio[i].setBounds(820, 90 + 34 * i, 80, 35);
		}
		cambio[3].setBounds(900, 124, 80, 35);
		cambio[4].setBounds(900, 158, 80, 35);
		cambio[5].setBounds(900, 90, 80, 35);

		// Cambio 1
		cambioN.setBounds(480, 250, 90, 69);
		cambioN.setFont(First.myFont);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 10; j++) {
				if (j < 4)
					troco[i][j].setBounds(570 + 34 * j, 250 + 34 * i, 35, 35);
				else
					troco[i][j].setBounds(706 + 44 * (j - 4), 250 + 34 * i, 45, 35);
				if (i == 0) {
					switch (j) {
					case 0:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 35, 35)));
						break;
					case 1:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 35, 35)));
						break;
					case 2:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 35, 35)));
						break;
					case 3:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 35, 35)));
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
					case 7:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i200.getImage(), 45, 35)));
						break;
					case 8:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i500.getImage(), 45, 35)));
						break;
					case 9:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i1000.getImage(), 45, 35)));
					default:
						break;
					}
				}
				troco[i][j].setFont(First.myFont);
			}

		// Cambio 2
		cambioN2.setBounds(480, 350, 90, 69);
		cambioN2.setFont(First.myFont);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 10; j++) {
				if (j < 4)
					troco2[i][j].setBounds(570 + 34 * j, 350 + 34 * i, 35, 35);
				else
					troco2[i][j].setBounds(706 + 44 * (j - 4), 350 + 34 * i, 45, 35);
				if (i == 0) {
					switch (j) {
					case 0:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 35, 35)));
						break;
					case 1:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 35, 35)));
						break;
					case 2:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 35, 35)));
						break;
					case 3:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 35, 35)));
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
					case 7:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i200.getImage(), 45, 35)));
						break;
					case 8:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i500.getImage(), 45, 35)));
						break;
					case 9:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i1000.getImage(), 45, 35)));
					default:
						break;
					}
				}
				troco2[i][j].setFont(First.myFont);
			}

		// Cambio 3
		cambioN3.setBounds(480, 450, 90, 69);
		cambioN3.setFont(First.myFont);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 10; j++) {
				if (j < 4)
					troco3[i][j].setBounds(570 + 34 * j, 450 + 34 * i, 35, 35);
				else
					troco3[i][j].setBounds(706 + 44 * (j - 4), 450 + 34 * i, 45, 35);
				if (i == 0) {
					switch (j) {
					case 0:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 35, 35)));
						break;
					case 1:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 35, 35)));
						break;
					case 2:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 35, 35)));
						break;
					case 3:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 35, 35)));
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
					case 7:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i200.getImage(), 45, 35)));
						break;
					case 8:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i500.getImage(), 45, 35)));
						break;
					case 9:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i1000.getImage(), 45, 35)));
					default:
						break;
					}
				}
				troco3[i][j].setFont(First.myFont);
			}
		mainF.setBounds(410, 320, 50, 50);
		mainF.setIcon(new ImageIcon(getScaledImage(mainIcon.getImage(), 50, 50)));
		clearB.setBounds(410, 230, 55, 55);
		clearB.setIcon(new ImageIcon(getScaledImage(clearI.getImage(), 55, 55)));

	}

	private void resP(JMenuItem resoD, JButton cambioN, JButton cambioN2, JButton mainF, JButton cambioN3,
			JButton clearB) {
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

		// Caja
		caja.setBounds(20, 490, 501, 51);
		caja.setFont(First.myFont);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 10; j++) {
				if (j < 4)
					cajaTroco[i][j].setBounds(20 + 44 * j, 540 + 39 * i, 45, 40);
				else
					cajaTroco[i][j].setBounds(196 + 54 * (j - 4), 540 + 39 * i, 55, 40);
				cajaTroco[i][j].setFont(First.myFont);
				if (i == 0) {
					switch (j) {
					case 0:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 45, 40)));
						break;
					case 1:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 45, 40)));
						break;
					case 2:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 45, 40)));
						break;
					case 3:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 45, 40)));
						break;
					case 4:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i20.getImage(), 55, 40)));
						break;
					case 5:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i50.getImage(), 55, 40)));
						break;
					case 6:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i100.getImage(), 55, 40)));
						break;
					case 7:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i200.getImage(), 55, 40)));
						break;
					case 8:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i500.getImage(), 55, 40)));
						break;
					case 9:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i1000.getImage(), 55, 40)));
					default:
						break;
					}
				}
			}
		// Cambio cliente
		cambioC.setBounds(500, 52, 500, 50);
		cambioC.setFont(First.myFont);
		for (int i = 0; i < 11; i++) {
			if (i < 4) {
				trocoC[i].setBounds(500 + 39 * i, 100, 40, 40);
				trocoCT[i].setBounds(500 + 39 * i, 140, 40, 40);
			} else {
				trocoC[i].setBounds(656 + 49 * (i - 4), 100, 50, 40);
				trocoCT[i].setBounds(656 + 49 * (i - 4), 140, 50, 40);
			}
			switch (i) {
			case 0:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 45, 40)));
				break;
			case 1:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 45, 40)));
				break;
			case 2:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 45, 40)));
				break;
			case 3:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 45, 40)));
				break;
			case 4:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i20.getImage(), 50, 40)));
				break;
			case 5:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i50.getImage(), 50, 40)));
				break;
			case 6:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i100.getImage(), 50, 40)));
				break;
			case 7:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i200.getImage(), 50, 40)));
				break;
			case 8:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i500.getImage(), 50, 40)));
				break;
			case 9:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i1000.getImage(), 50, 40)));
				break;
			case 10:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i2000.getImage(), 50, 40)));
				break;
			default:
				break;
			}
			trocoCT[i].setFont(First.myFont);
		}
		totalC.setBounds(500, 178, 500, 40);
		totalC.setFont(First.myFont);

		// Panel cambio
		for (int i = 0; i < 6; i++) {
			cambio[i].setFont(First.myFont);
			if (i < 3)
				cambio[i].setBounds(1020, 70 + 40 * i, 100, 40);
		}
		cambio[3].setBounds(1120, 110, 140, 40);
		cambio[4].setBounds(1120, 150, 140, 40);
		cambio[5].setBounds(1120, 70, 140, 40);

		// Cambio n1
		cambioN.setBounds(580, 270, 100, 79);
		cambioN.setFont(First.myFont);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 10; j++) {
				if (j < 4)
					troco[i][j].setBounds(680 + 49 * j, 270 + 39 * i, 50, 40);
				else
					troco[i][j].setBounds(876 + 59 * (j - 4), 270 + 39 * i, 60, 40);
				if (i == 0) {
					switch (j) {
					case 0:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 50, 40)));
						break;
					case 1:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 50, 40)));
						break;
					case 2:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 50, 40)));
						break;
					case 3:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 50, 40)));
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
					case 7:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i200.getImage(), 60, 40)));
						break;
					case 8:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i500.getImage(), 60, 40)));
						break;
					case 9:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i1000.getImage(), 60, 40)));
						break;
					default:
						break;
					}
				}
				troco[i][j].setFont(First.myFont);
			}
		// Cambio 2
		cambioN2.setBounds(580, 400, 100, 79);
		cambioN2.setFont(First.myFont);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 10; j++) {
				if (j < 4)
					troco2[i][j].setBounds(680 + 49 * j, 400 + 39 * i, 50, 40);
				else
					troco2[i][j].setBounds(876 + 59 * (j - 4), 400 + 39 * i, 60, 40);
				if (i == 0) {
					switch (j) {
					case 0:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 50, 40)));
						break;
					case 1:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 50, 40)));
						break;
					case 2:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 50, 40)));
						break;
					case 3:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 50, 40)));
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
					case 7:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i200.getImage(), 60, 40)));
						break;
					case 8:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i500.getImage(), 60, 40)));
						break;
					case 9:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i1000.getImage(), 60, 40)));
						break;
					default:
						break;
					}
				}
				troco2[i][j].setFont(First.myFont);
			}
		// Cambio 3
		cambioN3.setBounds(580, 530, 100, 79);
		cambioN3.setFont(First.myFont);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 10; j++) {
				if (j < 4)
					troco3[i][j].setBounds(680 + 49 * j, 530 + 39 * i, 50, 40);
				else
					troco3[i][j].setBounds(876 + 59 * (j - 4), 530 + 39 * i, 60, 40);
				if (i == 0) {
					switch (j) {
					case 0:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 50, 40)));
						break;
					case 1:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 50, 40)));
						break;
					case 2:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 50, 40)));
						break;
					case 3:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 50, 40)));
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
					case 7:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i200.getImage(), 60, 40)));
						break;
					case 8:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i500.getImage(), 60, 40)));
						break;
					case 9:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i1000.getImage(), 60, 40)));
						break;
					default:
						break;
					}
				}
				troco3[i][j].setFont(First.myFont);
			}
		mainF.setBounds(480, 380, 60, 60);
		mainF.setIcon(new ImageIcon(getScaledImage(mainIcon.getImage(), 60, 60)));
		clearB.setBounds(480, 280, 70, 70);
		clearB.setIcon(new ImageIcon(getScaledImage(clearI.getImage(), 70, 70)));
	}

	private void resM(JMenuItem resoD, JButton cambioN, JButton cambioN2, JButton mainF, JButton cambioN3,
			JButton clearB) {
		// Definitions
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

		// Panel 1 Invoice
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

		// Panel 2 Caja
		caja.setBounds(20, 560, 551, 50);
		caja.setFont(First.myFont);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 10; j++) {
				if (j < 4)
					cajaTroco[i][j].setBounds(20 + 49 * j, 610 + 49 * i, 50, 50);
				else
					cajaTroco[i][j].setBounds(216 + 59 * (j - 4), 610 + 49 * i, 60, 50);
				cajaTroco[i][j].setFont(First.myFont);
				if (i == 0) {
					switch (j) {
					case 0:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 50, 50)));
						break;
					case 1:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 50, 50)));
						break;
					case 2:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 50, 50)));
						break;
					case 3:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 50, 50)));
						break;
					case 4:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i20.getImage(), 60, 50)));
						break;
					case 5:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i50.getImage(), 60, 50)));
						break;
					case 6:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i100.getImage(), 60, 50)));
						break;
					case 7:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i200.getImage(), 60, 50)));
						break;
					case 8:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i500.getImage(), 60, 50)));
						break;
					case 9:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i1000.getImage(), 60, 50)));
						break;
					default:
						break;
					}
				}
			}

		// Cliente troco
		cambioC.setBounds(550, 52, 610, 60);
		cambioC.setFont(First.myFont);
		for (int i = 0; i < 11; i++) {
			if (i < 4)
				trocoC[i].setBounds(550 + 49 * i, 110, 50, 50);
			else
				trocoC[i].setBounds(746 + 59 * (i - 4), 110, 60, 50);
			switch (i) {
			case 0:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 50, 50)));
				break;
			case 1:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 50, 50)));
				break;
			case 2:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 50, 50)));
				break;
			case 3:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 50, 50)));
				break;
			case 4:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i20.getImage(), 60, 50)));
				break;
			case 5:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i50.getImage(), 60, 50)));
				break;
			case 6:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i100.getImage(), 60, 50)));
				break;
			case 7:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i200.getImage(), 60, 50)));
				break;
			case 8:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i500.getImage(), 60, 50)));
				break;
			case 9:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i1000.getImage(), 60, 50)));
				break;
			case 10:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i2000.getImage(), 60, 50)));
				break;
			default:
				break;
			}
			trocoCT[i].setFont(First.myFont);
			if (i < 4)
				trocoCT[i].setBounds(550 + 49 * i, 160, 50, 50);
			else
				trocoCT[i].setBounds(746 + 59 * (i - 4), 160, 60, 50);
		}
		totalC.setBounds(550, 208, 610, 50);
		totalC.setFont(First.myFont);

		// Cambio panel
		for (int i = 0; i < 6; i++) {
			cambio[i].setFont(First.myFont);
			if (i < 3)
				cambio[i].setBounds(1180, 80 + 50 * i, 110, 50);
		}
		cambio[3].setBounds(1288, 130, 150, 50);
		cambio[4].setBounds(1288, 180, 150, 50);
		cambio[5].setBounds(1288, 80, 150, 50);

		// 1st cambio
		cambioN.setBounds(662, 320, 120, 99);
		cambioN.setFont(First.myFont);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 10; j++) {
				if (j < 4)
					troco[i][j].setBounds(780 + 54 * j, 320 + 49 * i, 55, 50);
				else
					troco[i][j].setBounds(996 + 69 * (j - 4), 320 + 49 * i, 70, 50);
				if (i == 0) {
					switch (j) {
					case 0:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 55, 50)));
						break;
					case 1:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 55, 50)));
						break;
					case 2:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 55, 50)));
						break;
					case 3:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 55, 50)));
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
					case 7:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i200.getImage(), 70, 50)));
						break;
					case 8:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i500.getImage(), 70, 50)));
						break;
					case 9:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i1000.getImage(), 70, 50)));
						break;
					default:
						break;
					}
				}
				troco[i][j].setFont(First.myFont);
			}

		// 2nd cambio
		cambioN2.setBounds(662, 450, 120, 99);
		cambioN2.setFont(First.myFont);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 10; j++) {
				if (j < 4)
					troco2[i][j].setBounds(780 + 54 * j, 450 + 49 * i, 55, 50);
				else
					troco2[i][j].setBounds(996 + 69 * (j - 4), 450 + 49 * i, 70, 50);
				if (i == 0) {
					switch (j) {
					case 0:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 55, 50)));
						break;
					case 1:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 55, 50)));
						break;
					case 2:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 55, 50)));
						break;
					case 3:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 55, 50)));
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
					case 7:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i200.getImage(), 70, 50)));
						break;
					case 8:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i500.getImage(), 70, 50)));
						break;
					case 9:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i1000.getImage(), 70, 50)));
						break;
					default:
						break;
					}
				}
				troco2[i][j].setFont(First.myFont);
			}
		cambioN3.setBounds(662, 580, 120, 99);
		cambioN3.setFont(First.myFont);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 10; j++) {
				if (j < 4)
					troco3[i][j].setBounds(780 + 54 * j, 580 + 49 * i, 55, 50);
				else
					troco3[i][j].setBounds(996 + 69 * (j - 4), 580 + 49 * i, 70, 50);
				if (i == 0) {
					switch (j) {
					case 0:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 55, 50)));
						break;
					case 1:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 55, 50)));
						break;
					case 2:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 55, 50)));
						break;
					case 3:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 55, 50)));
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
					case 7:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i200.getImage(), 70, 50)));
						break;
					case 8:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i500.getImage(), 70, 50)));
						break;
					case 9:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i1000.getImage(), 70, 50)));
						break;
					default:
						break;
					}
				}
				troco3[i][j].setFont(First.myFont);
			}
		mainF.setBounds(550, 450, 70, 70);
		mainF.setIcon(new ImageIcon(getScaledImage(mainIcon.getImage(), 70, 70)));
		clearB.setBounds(550, 320, 70, 70);
		clearB.setIcon(new ImageIcon(getScaledImage(clearI.getImage(), 70, 70)));
	}

	private void resG(JMenuItem resoD, JButton cambioN, JButton cambioN2, JButton mainF, JButton cambioN3,
			JButton clearB) {
		// Definitions
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

		// Panel 1 Invoice
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

		// Panel 2 Caja
		caja.setBounds(20, 690, 711, 60);
		caja.setFont(First.myFont);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 10; j++) {
				if (j < 4)
					cajaTroco[i][j].setBounds(20 + 59 * j, 750 + 59 * i, 60, 60);
				else
					cajaTroco[i][j].setBounds(256 + 79 * (j - 4), 750 + 59 * i, 80, 60);
				cajaTroco[i][j].setFont(First.myFont);
				if (i == 0)
					switch (j) {
					case 0:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 60, 60)));
						break;
					case 1:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 60, 60)));
						break;
					case 2:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 60, 60)));
						break;
					case 3:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 60, 60)));
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
					case 7:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i200.getImage(), 80, 60)));
						break;
					case 8:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i500.getImage(), 80, 60)));
						break;
					case 9:
						cajaTroco[i][j].setIcon(new ImageIcon(getScaledImage(i1000.getImage(), 80, 60)));
						break;
					default:
						break;
					}
			}

		// Cliente troco
		cambioC.setBounds(700, 52, 790, 70);
		cambioC.setFont(First.myFont);
		for (int i = 0; i < 11; i++) {
			if (i < 4) {
				trocoC[i].setBounds(700 + 59 * i, 120, 60, 60);
				trocoCT[i].setBounds(700 + 59 * i, 180, 60, 60);
			} else {
				trocoC[i].setBounds(936 + 79 * (i - 4), 120, 80, 60);
				trocoCT[i].setBounds(936 + 79 * (i - 4), 180, 80, 60);
			}
			switch (i) {
			case 0:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 60, 60)));
				break;
			case 1:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 60, 60)));
				break;
			case 2:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 60, 60)));
				break;
			case 3:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 60, 60)));
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
			case 8:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i500.getImage(), 80, 60)));
				break;
			case 9:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i1000.getImage(), 80, 60)));
				break;
			case 10:
				trocoC[i].setIcon(new ImageIcon(getScaledImage(i2000.getImage(), 80, 60)));
				break;
			default:
				break;
			}
			trocoCT[i].setFont(First.myFont);
		}
		totalC.setBounds(700, 238, 790, 60);
		totalC.setFont(First.myFont);

		// Cambio panel
		for (int i = 0; i < 6; i++) {
			cambio[i].setFont(First.myFont);
			if (i < 3)
				cambio[i].setBounds(1500, 90 + 60 * i, 130, 60);
		}
		cambio[3].setBounds(1628, 150, 170, 60);
		cambio[4].setBounds(1628, 210, 170, 60);
		cambio[5].setBounds(1628, 90, 170, 60);

		// 1st cambio
		cambioN.setBounds(850, 370, 140, 119);
		cambioN.setFont(First.myFont);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 10; j++) {
				if (j < 4)
					troco[i][j].setBounds(990 + 60 * j, 370 + 59 * i, 60, 60);
				else
					troco[i][j].setBounds(1230 + 80 * (j - 4), 370 + 59 * i, 80, 60);
				if (i == 0) {
					switch (j) {
					case 0:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 60, 60)));
						break;
					case 1:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 60, 60)));
						break;
					case 2:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 60, 60)));
						break;
					case 3:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 60, 60)));
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
					case 7:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i200.getImage(), 80, 60)));
						break;
					case 8:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i500.getImage(), 80, 60)));
						break;
					case 9:
						troco[i][j].setIcon(new ImageIcon(getScaledImage(i1000.getImage(), 80, 60)));
						break;
					default:
						break;
					}
				} else
					troco[i][j].setFont(First.myFont);
			}

		// 2nd cambio
		cambioN2.setBounds(850, 550, 140, 119);
		cambioN2.setFont(First.myFont);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 10; j++) {
				if (j < 4)
					troco2[i][j].setBounds(990 + 60 * j, 550 + 59 * i, 60, 60);
				else
					troco2[i][j].setBounds(1230 + 80 * (j - 4), 550 + 59 * i, 80, 60);
				if (i == 0) {
					switch (j) {
					case 0:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 60, 60)));
						break;
					case 1:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 60, 60)));
						break;
					case 2:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 60, 60)));
						break;
					case 3:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 60, 60)));
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
					case 7:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i200.getImage(), 80, 60)));
						break;
					case 8:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i500.getImage(), 80, 60)));
						break;
					case 9:
						troco2[i][j].setIcon(new ImageIcon(getScaledImage(i1000.getImage(), 80, 60)));
						break;
					default:
						break;
					}
				}
				troco2[i][j].setFont(First.myFont);
			}

		// 3rd cambio
		cambioN3.setBounds(850, 730, 140, 119);
		cambioN3.setFont(First.myFont);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 10; j++) {
				if (j < 4)
					troco3[i][j].setBounds(990 + 60 * j, 730 + 59 * i, 60, 60);
				else
					troco3[i][j].setBounds(1230 + 80 * (j - 4), 730 + 59 * i, 80, 60);
				if (i == 0) {
					switch (j) {
					case 0:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i1.getImage(), 60, 60)));
						break;
					case 1:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i2.getImage(), 60, 60)));
						break;
					case 2:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i5.getImage(), 60, 60)));
						break;
					case 3:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i10.getImage(), 60, 60)));
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
					case 7:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i200.getImage(), 80, 60)));
						break;
					case 8:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i500.getImage(), 80, 60)));
						break;
					case 9:
						troco3[i][j].setIcon(new ImageIcon(getScaledImage(i1000.getImage(), 80, 60)));
						break;
					default:
						break;
					}
				}
				troco3[i][j].setFont(First.myFont);
			}
		mainF.setBounds(720, 520, 80, 80);
		mainF.setIcon(new ImageIcon(getScaledImage(mainIcon.getImage(), 80, 80)));
		clearB.setBounds(720, 350, 80, 80);
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
