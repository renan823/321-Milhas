package principal;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DestinoDAO;
import dao.FusoDAO;
import dao.Relatorio;
import dao.TransporteDAO;
import dao.TuristicoDAO;
import dao.ViagemDAO;
import bean.Transporte;
import bean.Turistico;
import bean.Viagem;
import bean.Destino;
import bean.Fuso;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLayeredPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.TextField;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class Interface extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JTextField textFieldAddTransporteMODELO;
	private JTextField textFieldAddTransporteCOD;
	private JTextField textFieldAddTransporteTIPO;
	private JTextField textFieldAddTransportePASSAGEIROS;
	private JTextField textFieldAddTransporteCARGA;
	private JTextField textFieldAddTransporteCOMBUSTIVEL;
	private JTextField textFieldDelTransporteCOD;
	private JTextField textFieldEditTransporteMODELO;
	private JTextField textFieldEditTransporteCOD;
	private JTextField textFieldEditTransporteTIPO;
	private JTextField textFieldEditTransportePASSAGEIROS;
	private JTextField textFieldEditTransporteCARGA;
	private JTextField textFieldEditTransporteCOMBUSTIVEL;
	private JTable tableListTransporte;
	private JTextField textFieldAddDestinoHABITANTES;
	private JTextField textFieldAddDestinoCIDADE;
	private JTextField textFieldAddDestinoESTADO;
	private JTextField textFieldAddDestinoCOORDENADAS;
	private JTextField textFieldAddDestinoPAIS;
	private JTextField textFieldDelDestinoCIDADE;
	private JTextField textFieldDelDestinoESTADO;
	private JTextField textFieldDelDestinoPAIS;
	private JTable tableListDestino;
	private JTextField textFieldEditDestinoHABITANTES;
	private JTextField textFieldEditDestinoESTADO;
	private JTextField textFieldEditDestinoPAIS;
	private JTable tableRelTTransporte;
	private JTable tableListViagem;
	private JTextField textFieldAddViagemCODIGO;
	private JTextField textFieldAddViagemDISTANCIA;
	private JTextField textFieldDelViagemCODIGO;
	private JTextField textFieldAddFusoFUSO;
	private JTextField textFieldAddTuristicoNOME;
	private JTextField textFieldEditViagemCODIGO;
	private JTextField textFieldEditViagemDISTANCIA;
	private JTable tableListTuristicos;
	private JTextField textFieldValorViagemVALOR;
	
	ArrayList<Destino> destinos = new ArrayList<>();
	ArrayList<Transporte> transportes = new ArrayList<>();
	ArrayList<Viagem> viagens = new ArrayList<>();
	
	ArrayList<String> comboBoxDestinos = new ArrayList<>();
	ArrayList<String> comboBoxTransportes = new ArrayList<>();
	ArrayList<String> comboBoxViagens = new ArrayList<>();
	
	int totalTransportes;
	int totalDestinos;
	int totalViagens;
	private JTextField textFieldEditDestinoCIDADE;
	private JTextField textFieldEditDestinoCOORDENADAS;
	private JTable tableValorViagem;
	private JTable tableDuracaoViagem;
	private JTextField textFieldDuracaoViagemVALOR;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public void Switch_screen(JPanel p) {
		layeredPane.removeAll();
		layeredPane.add(p);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	public boolean checkValues(ArrayList<String> lista) {
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).isEmpty()) {
				return false;
			}
		}
		return true;
	}
	

	public double getValorViagem(double distancia){
		return distancia * 1.5;
	}

	public double getDuracaoViagem(double distancia){
		int velocidade = 450;
		return distancia/velocidade;
	}
	
	
	
	public Interface() {
		
		TransporteDAO tdao = new TransporteDAO();
		DestinoDAO ddao = new DestinoDAO();
		ViagemDAO vdao = new ViagemDAO();
		Relatorio rdao = new Relatorio();
		FusoDAO fdao = new FusoDAO();
		TuristicoDAO tudao = new TuristicoDAO();
		
		Color bgColor = new Color(0, 37, 86);
		
		
		
		//Configurar tela inteira (cheia)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		contentPane.add(layeredPane);
		
		//Add paineis
		JPanel home = new JPanel();
		home.setBackground(bgColor);
		home.setBounds(0, 0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		layeredPane.add(home);
		home.setLayout(null);
				
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Interface.class.getResource("/img/Logo.png")));
		lblNewLabel.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 -250, (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2 -250, 500, 500);
		home.add(lblNewLabel);
		
		
		//CADASTRAR TRANSPORTE
		JPanel panelAddTransporte = new JPanel();
		panelAddTransporte.setBackground(bgColor);
		panelAddTransporte.setBounds(0, 0, 1920, 1021);
		//layeredPane.add(panelAddTransporte);
		panelAddTransporte.setLayout(null);
		
		textFieldAddTransporteMODELO = new JTextField();
		textFieldAddTransporteMODELO.setBounds(265, 499, 196, 34);
		panelAddTransporte.add(textFieldAddTransporteMODELO);
		textFieldAddTransporteMODELO.setColumns(10);
		
		textFieldAddTransporteCOD = new JTextField();
		textFieldAddTransporteCOD.setColumns(10);
		textFieldAddTransporteCOD.setBounds(265, 256, 196, 34);
		panelAddTransporte.add(textFieldAddTransporteCOD);
		
		textFieldAddTransporteTIPO = new JTextField();
		textFieldAddTransporteTIPO.setColumns(10);
		textFieldAddTransporteTIPO.setBounds(677, 256, 196, 34);
		panelAddTransporte.add(textFieldAddTransporteTIPO);
		
		textFieldAddTransportePASSAGEIROS = new JTextField();
		textFieldAddTransportePASSAGEIROS.setColumns(10);
		textFieldAddTransportePASSAGEIROS.setBounds(677, 499, 196, 34);
		panelAddTransporte.add(textFieldAddTransportePASSAGEIROS);
		
		textFieldAddTransporteCARGA = new JTextField();
		textFieldAddTransporteCARGA.setColumns(10);
		textFieldAddTransporteCARGA.setBounds(1088, 256, 196, 34);
		panelAddTransporte.add(textFieldAddTransporteCARGA);
		
		textFieldAddTransporteCOMBUSTIVEL = new JTextField();
		textFieldAddTransporteCOMBUSTIVEL.setColumns(10);
		textFieldAddTransporteCOMBUSTIVEL.setBounds(1088, 499, 196, 34);
		panelAddTransporte.add(textFieldAddTransporteCOMBUSTIVEL);
		
		JLabel addTransporteTitulo = new JLabel("Adicionar Transporte");
		addTransporteTitulo.setForeground(Color.WHITE);
		addTransporteTitulo.setFont(new Font("Verdana", Font.BOLD, 30));
		addTransporteTitulo.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 400/2, 80, 400, 34);
		panelAddTransporte.add(addTransporteTitulo);
		
		JButton btnAddTransporte = new JButton("Cadastrar");
		btnAddTransporte.setFont(new Font("Verdana", Font.BOLD, 15));
		btnAddTransporte.setForeground(new Color(255, 255, 255));
		btnAddTransporte.setBackground(new Color(0, 206, 209));
		btnAddTransporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int codigo;
				int carga;
				int passageiros;
				
				ArrayList<String> inputs = new ArrayList<>();
				
				inputs.add(textFieldAddTransporteCOD.getText());
				inputs.add(textFieldAddTransporteCARGA.getText());
				inputs.add(textFieldAddTransportePASSAGEIROS.getText());
				inputs.add(textFieldAddTransporteTIPO.getText());
				inputs.add(textFieldAddTransporteMODELO.getText());
				inputs.add(textFieldAddTransporteCOMBUSTIVEL.getText());
				
				if(!checkValues(inputs)) {
					JOptionPane.showMessageDialog(null, "Existe um erro em algum dos campos!");
					return;
				}
				
				codigo = Integer.parseInt(textFieldAddTransporteCOD.getText());
				carga = Integer.parseInt(textFieldAddTransporteCARGA.getText());
				passageiros = Integer.parseInt(textFieldAddTransportePASSAGEIROS.getText());
				
				String tipo = textFieldAddTransporteTIPO.getText();
				String modelo = textFieldAddTransporteMODELO.getText();
				String combustivel = textFieldAddTransporteCOMBUSTIVEL.getText();
				
				textFieldAddTransporteCOD.setText("");
				textFieldAddTransporteCARGA.setText("");
				textFieldAddTransportePASSAGEIROS.setText("");
				textFieldAddTransporteTIPO.setText("");
				textFieldAddTransporteMODELO.setText("");
				textFieldAddTransporteCOMBUSTIVEL.setText("");

				if(tdao.getTransporte(codigo)){
					JOptionPane.showMessageDialog(null, "Esse transporte j� existe!");
					return;
				}
				else{
					Transporte t = new Transporte(codigo, tipo, carga, passageiros, modelo, combustivel);
					tdao.inserir(t);
					JOptionPane.showMessageDialog(null, "Transporte cadastrado");
				}
			}
		});
		btnAddTransporte.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 188/2, (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() -180, 188, 55);
		panelAddTransporte.add(btnAddTransporte);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1.setBounds(265, 218, 103, 20);
		panelAddTransporte.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tipo");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(677, 218, 103, 20);
		panelAddTransporte.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("N\u00B0 Carga");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(1088, 218, 103, 20);
		panelAddTransporte.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Modelo");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(265, 461, 103, 20);
		panelAddTransporte.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("N\u00B0 Passageiros");
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(677, 461, 163, 20);
		panelAddTransporte.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Combust\u00EDvel");
		lblNewLabel_1_5.setForeground(Color.WHITE);
		lblNewLabel_1_5.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_5.setBounds(1088, 461, 103, 20);
		panelAddTransporte.add(lblNewLabel_1_5);

		
		//DELETAR TRANSPORTE
		JPanel panelDelTransporte = new JPanel();
		panelDelTransporte.setBackground(bgColor);
		panelDelTransporte.setBounds(0, 0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		//layeredPane.add(panelDelTransporte);
		panelDelTransporte.setLayout(null);
		
		textFieldDelTransporteCOD = new JTextField();
		textFieldDelTransporteCOD.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 -100, 200, 200, 34);
		panelDelTransporte.add(textFieldDelTransporteCOD);
		textFieldDelTransporteCOD.setColumns(10);
		
		JLabel delTransporteTitulo = new JLabel("Deletar Transporte");
		delTransporteTitulo.setForeground(Color.WHITE);
		delTransporteTitulo.setFont(new Font("Verdana", Font.BOLD, 30));
		delTransporteTitulo.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 330/2, 80, 330, 34);
		panelDelTransporte.add(delTransporteTitulo);
		
		JButton btnDelTransporte = new JButton("Deletar");
		btnDelTransporte.setFont(new Font("Verdana", Font.BOLD, 15));
		btnDelTransporte.setForeground(new Color(255, 255, 255));
		btnDelTransporte.setBackground(new Color(0, 206, 209));
		btnDelTransporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codigo;
				
				ArrayList<String> inputs = new ArrayList<>();
				
				inputs.add(textFieldDelTransporteCOD.getText());
				
				if(!checkValues(inputs)) {
					JOptionPane.showMessageDialog(null, "Existe um erro em algum dos campos!");
					return;
				}
				
				codigo = Integer.parseInt(textFieldDelTransporteCOD.getText());
				
				textFieldDelTransporteCOD.setText("");
				
				if(tdao.getTransporte(codigo)){
				 	Transporte t = new Transporte();
				 	t.setCodigo(codigo);
				 	if(!vdao.verifyTransporte(t)) {
				 		tdao.remover(t);
					 	JOptionPane.showMessageDialog(null, "Transporte excluído!");
					 	return;
				 	}
				 	JOptionPane.showMessageDialog(null, "Esse transporte não pode ser exclu�do!");
				}
				else{
					JOptionPane.showMessageDialog(null, "Esse transporte não existe!");
				 	return;
				}
			}
		});
		btnDelTransporte.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 188/2, (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() -180, 188, 55);
		panelDelTransporte.add(btnDelTransporte);
		
		JLabel lblNewLabel_1_6 = new JLabel("C\u00F3digo");
		lblNewLabel_1_6.setForeground(Color.WHITE);
		lblNewLabel_1_6.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_6.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 -100, 167, 103, 20);
		panelDelTransporte.add(lblNewLabel_1_6);
		
		
		//EDITAR TRANSPORTE
		JPanel panelEditTransporte = new JPanel();
		panelEditTransporte.setBackground(bgColor);
		panelEditTransporte.setBounds(0, 0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		//layeredPane.add(panelEditTransporte);
		panelEditTransporte.setLayout(null);
		
		textFieldEditTransporteMODELO = new JTextField();
		textFieldEditTransporteMODELO.setBounds(265, 499, 196, 34);
		panelEditTransporte.add(textFieldEditTransporteMODELO);
		textFieldEditTransporteMODELO.setColumns(10);
		
		textFieldEditTransporteCOD = new JTextField();
		textFieldEditTransporteCOD.setColumns(10);
		textFieldEditTransporteCOD.setBounds(265, 256, 196, 34);
		panelEditTransporte.add(textFieldEditTransporteCOD);
		
		textFieldEditTransporteTIPO = new JTextField();
		textFieldEditTransporteTIPO.setColumns(10);
		textFieldEditTransporteTIPO.setBounds(677, 256, 196, 34);
		panelEditTransporte.add(textFieldEditTransporteTIPO);
		
		textFieldEditTransportePASSAGEIROS = new JTextField();
		textFieldEditTransportePASSAGEIROS.setColumns(10);
		textFieldEditTransportePASSAGEIROS.setBounds(677, 499, 196, 34);
		panelEditTransporte.add(textFieldEditTransportePASSAGEIROS);
		
		textFieldEditTransporteCARGA = new JTextField();
		textFieldEditTransporteCARGA.setColumns(10);
		textFieldEditTransporteCARGA.setBounds(1088, 256, 196, 34);
		panelEditTransporte.add(textFieldEditTransporteCARGA);
		
		textFieldEditTransporteCOMBUSTIVEL = new JTextField();
		textFieldEditTransporteCOMBUSTIVEL.setColumns(10);
		textFieldEditTransporteCOMBUSTIVEL.setBounds(1088, 499, 196, 34);
		panelEditTransporte.add(textFieldEditTransporteCOMBUSTIVEL);
		
		JLabel editTransporteTitulo = new JLabel("Editar Transporte");
		editTransporteTitulo.setForeground(Color.WHITE);
		editTransporteTitulo.setFont(new Font("Verdana", Font.BOLD, 30));
		editTransporteTitulo.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 330/2, 80, 330, 34);
		panelEditTransporte.add(editTransporteTitulo);
		
		JButton btnEditTransporte = new JButton("Editar");
		btnEditTransporte.setFont(new Font("Verdana", Font.BOLD, 15));
		btnEditTransporte.setForeground(new Color(255, 255, 255));
		btnEditTransporte.setBackground(new Color(0, 206, 209));
		btnEditTransporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int codigo;
				int carga;
				int passageiros;
				
				ArrayList<String> inputs = new ArrayList<>();
				
				inputs.add(textFieldEditTransporteCOD.getText());
				inputs.add(textFieldEditTransporteCARGA.getText());
				inputs.add(textFieldEditTransportePASSAGEIROS.getText());
				inputs.add(textFieldEditTransporteTIPO.getText());
				inputs.add(textFieldEditTransporteMODELO.getText());
				inputs.add(textFieldEditTransportePASSAGEIROS.getText());
				
				if(!checkValues(inputs)) {
					JOptionPane.showMessageDialog(null, "Existe um erro em algum dos campos!");
					return;
				}
				
				codigo = Integer.parseInt(textFieldEditTransporteCOD.getText());
				carga = Integer.parseInt(textFieldEditTransporteCARGA.getText());
				passageiros = Integer.parseInt(textFieldEditTransportePASSAGEIROS.getText());
				
				String tipo = textFieldEditTransporteTIPO.getText();
				String modelo = textFieldEditTransporteMODELO.getText();
				String combustivel = textFieldEditTransportePASSAGEIROS.getText();
				
				textFieldEditTransporteCOD.setText("");
				textFieldEditTransporteCARGA.setText("");
				textFieldEditTransportePASSAGEIROS.setText("");
				textFieldEditTransporteTIPO.setText("");
				textFieldEditTransporteMODELO.setText("");
				textFieldEditTransporteCOMBUSTIVEL.setText("");
				
				 if(tdao.getTransporte(codigo)){
				 	Transporte t = new Transporte(codigo, tipo, carga, passageiros, modelo, combustivel);
				 	tdao.alterar(t);
				 	JOptionPane.showMessageDialog(null, "Transporte editado!");
				 }
				 else{
				 	JOptionPane.showMessageDialog(null, "Esse transporte nÃ£o existe!");
				 	return;
				 }
			}
		});
		btnEditTransporte.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 188/2, (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() -180, 188, 55);
		panelEditTransporte.add(btnEditTransporte);
		
		JLabel lblNewLabel_1_7 = new JLabel("C\u00F3digo");
		lblNewLabel_1_7.setForeground(Color.WHITE);
		lblNewLabel_1_7.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_7.setBounds(265, 218, 103, 20);
		panelEditTransporte.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_8 = new JLabel("Tipo");
		lblNewLabel_1_8.setForeground(Color.WHITE);
		lblNewLabel_1_8.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_8.setBounds(677, 218, 103, 20);
		panelEditTransporte.add(lblNewLabel_1_8);
		
		JLabel lblNewLabel_1_9 = new JLabel("N\u00B0 Carga");
		lblNewLabel_1_9.setForeground(Color.WHITE);
		lblNewLabel_1_9.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_9.setBounds(1088, 218, 103, 20);
		panelEditTransporte.add(lblNewLabel_1_9);
		
		JLabel lblNewLabel_2 = new JLabel("Modelo");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_2.setBounds(265, 461, 103, 20);
		panelEditTransporte.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("N\u00B0 Passageiros");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(677, 461, 163, 20);
		panelEditTransporte.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Combust\u00EDvel");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_2_2.setBounds(1088, 461, 103, 20);
		panelEditTransporte.add(lblNewLabel_2_2);
		
		
		//LISTAR TRANSPORTE
		JPanel panelListTransporte = new JPanel();
		panelListTransporte.setBackground(bgColor);
		panelListTransporte.setBounds(0, 0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		//layeredPane.add(panelListTransporte);
		panelListTransporte.setLayout(null);
				
		JScrollPane scrollPane = new JScrollPane();
		panelListTransporte.add(scrollPane);
				
		tableListTransporte = new JTable();
		scrollPane.setViewportView(tableListTransporte);
		scrollPane.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 750/2, 340, 750, 170);
				
		tableListTransporte.setModel(new DefaultTableModel(
			new Object[][] {
				},
				new String[] {
					"C\u00F3digo", "Tipo", "N\u00B0 Carga", "N\u00B0 Passageiros", "Modelo", "Combust\u00EDvel"
				}
			) {
				Class[] columnTypes = new Class[] {
					Integer.class, String.class, Integer.class, Integer.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			}
		);
		tableListTransporte.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 250, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() -250, 500, 170);
			
		JLabel listTransporteTitulo = new JLabel("Listar Transportes");
		listTransporteTitulo.setForeground(Color.WHITE);
		listTransporteTitulo.setFont(new Font("Verdana", Font.BOLD, 30));
		listTransporteTitulo.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 330/2, 80, 330, 34);
		panelListTransporte.add(listTransporteTitulo);
		
		//CADASTRAR DESTINO
		JPanel panelAddDestino = new JPanel();
		panelAddDestino.setBackground(bgColor);
		panelAddDestino.setBounds(0, 0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		//layeredPane.add(panelAddDestino);
		panelAddDestino.setLayout(null);
		
		textFieldAddDestinoHABITANTES = new JTextField();
		textFieldAddDestinoHABITANTES.setBounds(265, 499, 196, 34);
		panelAddDestino.add(textFieldAddDestinoHABITANTES);
		textFieldAddDestinoHABITANTES.setColumns(10);
		
		textFieldAddDestinoCIDADE = new JTextField();
		textFieldAddDestinoCIDADE.setColumns(10);
		textFieldAddDestinoCIDADE.setBounds(265, 256, 196, 34);
		panelAddDestino.add(textFieldAddDestinoCIDADE);
		
		textFieldAddDestinoESTADO = new JTextField();
		textFieldAddDestinoESTADO.setColumns(10);
		textFieldAddDestinoESTADO.setBounds(677, 256, 196, 34);
		panelAddDestino.add(textFieldAddDestinoESTADO);
		
		textFieldAddDestinoCOORDENADAS = new JTextField();
		textFieldAddDestinoCOORDENADAS.setColumns(10);
		textFieldAddDestinoCOORDENADAS.setBounds(677, 499, 196, 34);
		panelAddDestino.add(textFieldAddDestinoCOORDENADAS);
		
		textFieldAddDestinoPAIS = new JTextField();
		textFieldAddDestinoPAIS.setColumns(10);
		textFieldAddDestinoPAIS.setBounds(1088, 256, 196, 34);
		panelAddDestino.add(textFieldAddDestinoPAIS);
		
		
		JLabel addDestinoTitulo = new JLabel("Adicionar Destino");
		addDestinoTitulo.setBounds(640, 9, 83, 14);
		addDestinoTitulo.setForeground(Color.WHITE);
		addDestinoTitulo.setFont(new Font("Verdana", Font.BOLD, 30));
		addDestinoTitulo.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 330/2, 80, 330, 34);
		panelAddDestino.add(addDestinoTitulo);
		
		JButton btnAddDestino = new JButton("Cadastrar");
		btnAddDestino.setBounds(728, 5, 81, 23);
		btnAddDestino.setFont(new Font("Verdana", Font.BOLD, 15));
		btnAddDestino.setForeground(new Color(255, 255, 255));
		btnAddDestino.setBackground(new Color(0, 206, 209));
		btnAddDestino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int nHab;
				
				ArrayList<String> inputs = new ArrayList<>();
				
				inputs.add(textFieldAddDestinoHABITANTES.getText());
				inputs.add(textFieldAddDestinoCIDADE.getText());
				inputs.add(textFieldAddDestinoESTADO.getText());
				inputs.add(textFieldAddDestinoCOORDENADAS.getText());
				inputs.add(textFieldAddDestinoPAIS.getText());
				
				if(!checkValues(inputs)) {
					JOptionPane.showMessageDialog(null, "Existe um erro em algum dos campos!");
					return;
				}
				
				nHab = Integer.parseInt(textFieldAddDestinoHABITANTES.getText());
				
				String cidade = textFieldAddDestinoCIDADE.getText();
				String estado = textFieldAddDestinoESTADO.getText();
				String pais = textFieldAddDestinoPAIS.getText();
				String coordenadas = textFieldAddDestinoCOORDENADAS.getText();
				
				textFieldAddDestinoHABITANTES.setText("");
				textFieldAddDestinoCIDADE.setText("");
				textFieldAddDestinoESTADO.setText("");
				textFieldAddDestinoCOORDENADAS.setText("");
				textFieldAddDestinoPAIS.setText("");
				
				if(ddao.getDestino(cidade, estado, pais)){
				 	JOptionPane.showMessageDialog(null, "Esse destino j� existe!");
					return;
				 }
				 else{
					Destino d = new Destino(cidade, estado, pais, nHab, coordenadas);
					ddao.inserir(d);
				 	JOptionPane.showMessageDialog(null, "Destino cadastrado!");
				 	return;
				 }
			}
		});
		btnAddDestino.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 188/2, (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() -180, 188, 55);
		panelAddDestino.add(btnAddDestino);
		
		JLabel lblNewLabel_2_3 = new JLabel("Cidade");
		lblNewLabel_2_3.setForeground(Color.WHITE);
		lblNewLabel_2_3.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_2_3.setBounds(265, 218, 103, 20);
		panelAddDestino.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("N\u00B0 Habitantes");
		lblNewLabel_2_4.setForeground(Color.WHITE);
		lblNewLabel_2_4.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_2_4.setBounds(265, 461, 125, 20);
		panelAddDestino.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("Estado");
		lblNewLabel_2_5.setForeground(Color.WHITE);
		lblNewLabel_2_5.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_2_5.setBounds(677, 218, 74, 20);
		panelAddDestino.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_6 = new JLabel("Pa\u00EDs");
		lblNewLabel_2_6.setForeground(Color.WHITE);
		lblNewLabel_2_6.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_2_6.setBounds(1088, 218, 58, 20);
		panelAddDestino.add(lblNewLabel_2_6);
		
		JLabel lblNewLabel_2_7 = new JLabel("Coordenadas");
		lblNewLabel_2_7.setForeground(Color.WHITE);
		lblNewLabel_2_7.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_2_7.setBounds(677, 461, 125, 20);
		panelAddDestino.add(lblNewLabel_2_7);
		
		//DELETAR DESTINO
		JPanel panelDelDestino = new JPanel();
		panelDelDestino.setBackground(bgColor);
		panelDelDestino.setBounds(0, 0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		//layeredPane.add(panelDelDestino);
		panelDelDestino.setLayout(null);
		
		textFieldDelDestinoCIDADE = new JTextField();
		textFieldDelDestinoCIDADE.setBounds(265, 256, 196, 34);
		panelDelDestino.add(textFieldDelDestinoCIDADE);
		textFieldDelDestinoCIDADE.setColumns(10);
		
		
		textFieldDelDestinoESTADO = new JTextField();
		textFieldDelDestinoESTADO.setColumns(10);
		textFieldDelDestinoESTADO.setBounds(677, 256, 196, 34);
		panelDelDestino.add(textFieldDelDestinoESTADO);
		
		textFieldDelDestinoPAIS = new JTextField();
		textFieldDelDestinoPAIS.setColumns(10);
		textFieldDelDestinoPAIS.setBounds(1088, 256, 196, 34);
		panelDelDestino.add(textFieldDelDestinoPAIS);
		
		JLabel delDestinoTitulo = new JLabel("Deletar Destino");
		delDestinoTitulo.setForeground(Color.WHITE);
		delDestinoTitulo.setFont(new Font("Verdana", Font.BOLD, 30));
		delDestinoTitulo.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 330/2, 80, 330, 34);
		panelDelDestino.add(delDestinoTitulo);
		
		JButton btnDelDestino = new JButton("Deletar");
		btnDelDestino.setFont(new Font("Verdana", Font.BOLD, 15));
		btnDelDestino.setForeground(new Color(255, 255, 255));
		btnDelDestino.setBackground(new Color(0, 206, 209));
		btnDelDestino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<String> inputs = new ArrayList<>();
				
				inputs.add(textFieldDelDestinoCIDADE.getText());
				inputs.add(textFieldDelDestinoESTADO.getText());
				inputs.add(textFieldDelDestinoPAIS.getText());
				
				if(!checkValues(inputs)) {
					JOptionPane.showMessageDialog(null, "Existe um erro em algum dos campos!");
					return;
				}
				
				String cidade = textFieldDelDestinoCIDADE.getText();
				String estado = textFieldDelDestinoESTADO.getText();
				String pais = textFieldDelDestinoPAIS.getText();
				
				textFieldDelDestinoCIDADE.setText("");
				textFieldDelDestinoESTADO.setText("");
				textFieldDelDestinoPAIS.setText("");
				
				if(ddao.getDestino(cidade, estado, pais)){
				 	Destino d = new Destino();
				 	d.setCidade(cidade);
				 	d.setEstado(estado);
				 	d.setPais(pais);
				 	if(!vdao.verifyDestino(d) && !tudao.verifyTuristico(d) && !fdao.verifyFuso(d)) { 
				 		ddao.remover(d);
					 	JOptionPane.showMessageDialog(null, "Destino exclu�do");
					 	return;
				 	}
				 	JOptionPane.showMessageDialog(null, "Esse destino n�o pode ser exclu�do!");
				 }
				 else{
				 	JOptionPane.showMessageDialog(null, "Esse destino nÃ£o existe!");
				 	return;
				 }
			}
		});
		btnDelDestino.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 188/2, (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() -180, 188, 55);
		panelDelDestino.add(btnDelDestino);
		
		JLabel lblNewLabel_2_8 = new JLabel("Cidade");
		lblNewLabel_2_8.setForeground(Color.WHITE);
		lblNewLabel_2_8.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_2_8.setBounds(265, 218, 125, 20);
		panelDelDestino.add(lblNewLabel_2_8);
		
		JLabel lblNewLabel_2_9 = new JLabel("Estado");
		lblNewLabel_2_9.setForeground(Color.WHITE);
		lblNewLabel_2_9.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_2_9.setBounds(677, 218, 125, 20);
		panelDelDestino.add(lblNewLabel_2_9);
		
		JLabel lblNewLabel_3 = new JLabel("Pa\u00EDs");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_3.setBounds(1088, 218, 125, 20);
		panelDelDestino.add(lblNewLabel_3);
		
		
		//EDITAR DESTINO
		JPanel panelEditDestino = new JPanel();
		panelEditDestino.setBackground(bgColor);
		panelEditDestino.setBounds(0, 0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		//layeredPane.add(panelEditDestino);
		panelEditDestino.setLayout(null);

		textFieldEditDestinoHABITANTES = new JTextField();
		textFieldEditDestinoHABITANTES.setBounds(265, 499, 196, 34);
		panelEditDestino.add(textFieldEditDestinoHABITANTES);
		textFieldEditDestinoHABITANTES.setColumns(10);
		
		textFieldEditDestinoCIDADE = new JTextField();
		textFieldEditDestinoCIDADE.setColumns(10);
		textFieldEditDestinoCIDADE.setBounds(265, 256, 196, 34);
		panelEditDestino.add(textFieldEditDestinoCIDADE);
		
		textFieldEditDestinoESTADO = new JTextField();
		textFieldEditDestinoESTADO.setColumns(10);
		textFieldEditDestinoESTADO.setBounds(677, 256, 196, 34);
		panelEditDestino.add(textFieldEditDestinoESTADO);
		
		textFieldEditDestinoCOORDENADAS = new JTextField();
		textFieldEditDestinoCOORDENADAS.setColumns(10);
		textFieldEditDestinoCOORDENADAS.setBounds(677, 499, 196, 34);
		panelEditDestino.add(textFieldEditDestinoCOORDENADAS);
		
		textFieldEditDestinoPAIS = new JTextField();
		textFieldEditDestinoPAIS.setColumns(10);
		textFieldEditDestinoPAIS.setBounds(1088, 256, 196, 34);
		panelEditDestino.add(textFieldEditDestinoPAIS);
		
		JLabel editDestinoTitulo = new JLabel("Editar Destino");
		editDestinoTitulo.setBounds(640, 9, 83, 14);
		editDestinoTitulo.setForeground(Color.WHITE);
		editDestinoTitulo.setFont(new Font("Verdana", Font.BOLD, 30));
		editDestinoTitulo.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 330/2, 80, 330, 34);
		panelEditDestino.add(editDestinoTitulo);
		
		JButton btnEditDestino = new JButton("Editar");
		btnEditDestino.setBounds(728, 5, 81, 23);
		btnEditDestino.setFont(new Font("Verdana", Font.BOLD, 15));
		btnEditDestino.setForeground(new Color(255, 255, 255));
		btnEditDestino.setBackground(new Color(0, 206, 209));
		btnEditDestino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int nHab;
				
				ArrayList<String> inputs = new ArrayList<>();
				
				inputs.add(textFieldEditDestinoHABITANTES.getText());
				inputs.add(textFieldEditDestinoCIDADE.getText());
				inputs.add(textFieldEditDestinoESTADO.getText());
				inputs.add(textFieldEditDestinoCOORDENADAS.getText());
				inputs.add(textFieldEditDestinoPAIS.getText());
				
				if(!checkValues(inputs)) {
					JOptionPane.showMessageDialog(null, "Existe um erro em algum dos campos!");
					return;
				}
				
				nHab = Integer.parseInt(textFieldEditDestinoHABITANTES.getText());
				
				String cidade = textFieldEditDestinoCIDADE.getText();
				String estado = textFieldEditDestinoESTADO.getText();
				String pais = textFieldEditDestinoPAIS.getText();
				String coordenadas = textFieldEditDestinoCOORDENADAS.getText();
				
				textFieldEditDestinoHABITANTES.setText("");
				textFieldEditDestinoCIDADE.setText("");
				textFieldEditDestinoESTADO.setText("");
				textFieldEditDestinoCOORDENADAS.setText("");
				textFieldEditDestinoPAIS.setText("");
				
				if(ddao.getDestino(cidade, estado, pais)){
				 	Destino d = new Destino(cidade, estado, pais, nHab, coordenadas);
					ddao.alterar(d);
				 	JOptionPane.showMessageDialog(null, "Destino editado!");
				 }
				 else{
				 	JOptionPane.showMessageDialog(null, "Esse destino n�o existe!");
				 	return;
				 }
			}
		});
		btnEditDestino.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 188/2, (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() -180, 188, 55);
		panelEditDestino.add(btnEditDestino);
		
		JLabel lblNewLabel_3_1 = new JLabel("Cidade");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(265, 218, 103, 20);
		panelEditDestino.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("N\u00B0 Habitantes");
		lblNewLabel_3_2.setForeground(Color.WHITE);
		lblNewLabel_3_2.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_3_2.setBounds(265, 461, 125, 20);
		panelEditDestino.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Estado");
		lblNewLabel_3_3.setForeground(Color.WHITE);
		lblNewLabel_3_3.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_3_3.setBounds(677, 218, 74, 20);
		panelEditDestino.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("Pa\u00EDs");
		lblNewLabel_3_4.setForeground(Color.WHITE);
		lblNewLabel_3_4.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_3_4.setBounds(1088, 218, 58, 20);
		panelEditDestino.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_5 = new JLabel("Coordenadas");
		lblNewLabel_3_5.setForeground(Color.WHITE);
		lblNewLabel_3_5.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_3_5.setBounds(677, 461, 125, 20);
		panelEditDestino.add(lblNewLabel_3_5);

		
		//LISTAR DESTINO
		JPanel panelListDestino = new JPanel();
		panelListDestino.setBackground(bgColor);
		panelListDestino.setBounds(0, 0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		//layeredPane.add(panelListDestino);
		panelListDestino.setLayout(null);
				
		JScrollPane scrollPane1 = new JScrollPane();
		panelListDestino.add(scrollPane1);
				
		tableListDestino = new JTable();
		scrollPane1.setViewportView(tableListDestino);
		scrollPane1.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 750/2, 340, 750, 170);
				
		tableListDestino.setModel(new DefaultTableModel(
			new Object[][] {
				},
				new String[] {
					"Cidade", "Estado", "Pa\u00EDs", "Coordenadas", "N\u00B0 Habitantes"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, String.class, Integer.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			}
		);
		tableListDestino.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 250, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() -250, 500, 170);
			
		JLabel listDestinoTitulo = new JLabel("Listar Destinos");
		listDestinoTitulo.setForeground(Color.WHITE);
		listDestinoTitulo.setFont(new Font("Verdana", Font.BOLD, 30));
		listDestinoTitulo.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 330/2, 80, 330, 34);
		panelListDestino.add(listDestinoTitulo);
		
		//CADASTRAR VIAGEM
		JPanel panelAddViagem = new JPanel();
		panelAddViagem.setBackground(bgColor);
		panelAddViagem.setBounds(0, 0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		//layeredPane.add(panelAddViagem);
		panelAddViagem.setLayout(null);
		
		textFieldAddViagemCODIGO = new JTextField();
		textFieldAddViagemCODIGO.setBounds(265, 256, 196, 34);
		panelAddViagem.add(textFieldAddViagemCODIGO);
		textFieldAddViagemCODIGO.setColumns(10);
		
		JComboBox<String> comboBoxAddViagemDESTINO = new JComboBox<String>();
		comboBoxAddViagemDESTINO.setBounds(677, 256, 196, 34);
		panelAddViagem.add(comboBoxAddViagemDESTINO);
		
		JComboBox<String> comboBoxAddViagemTRANSPORTE = new JComboBox<String>();
		comboBoxAddViagemTRANSPORTE.setBounds(1088, 256, 196, 34);
		panelAddViagem.add(comboBoxAddViagemTRANSPORTE);
		
		textFieldAddViagemDISTANCIA = new JTextField();
		textFieldAddViagemDISTANCIA.setColumns(10);
		textFieldAddViagemDISTANCIA.setBounds(265, 499, 196, 34);
		panelAddViagem.add(textFieldAddViagemDISTANCIA);
		
		
		JPanel calendarioAddViagemPARTIDA = new JPanel();
		calendarioAddViagemPARTIDA.setBounds(677, 499, 200, 200);
		calendarioAddViagemPARTIDA.setBackground(bgColor);
		
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl datePickerAddViagemPARTIDA = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		 
		calendarioAddViagemPARTIDA.add(datePickerAddViagemPARTIDA);
		panelAddViagem.add(calendarioAddViagemPARTIDA);
		
		JPanel calendarioAddViagemCHEGADA = new JPanel();
		calendarioAddViagemCHEGADA.setBounds(1088, 499, 200, 200);
		calendarioAddViagemCHEGADA.setBackground(bgColor);
		
		UtilDateModel model1 = new UtilDateModel();
		Properties p1 = new Properties();
		p1.put("text.today", "Today");
		p1.put("text.month", "Month");
		p1.put("text.year", "Year");
		JDatePanelImpl datePanel1 = new JDatePanelImpl(model1, p1);
		JDatePickerImpl datePickerAddViagemCHEGADA = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
		 
		calendarioAddViagemCHEGADA.add(datePickerAddViagemCHEGADA);
		panelAddViagem.add(calendarioAddViagemCHEGADA);
		
		JLabel addViagemTitulo = new JLabel("Adicionar Viagem");
		addViagemTitulo.setForeground(Color.WHITE);
		addViagemTitulo.setFont(new Font("Verdana", Font.BOLD, 30));
		addViagemTitulo.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 330/2, 80, 330, 34);
		panelAddViagem.add(addViagemTitulo);
		
		JButton btnAddViagem = new JButton("Cadastrar");
		btnAddViagem.setFont(new Font("Verdana", Font.BOLD, 15));
		btnAddViagem.setForeground(new Color(255, 255, 255));
		btnAddViagem.setBackground(new Color(0, 206, 209));
		btnAddViagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int codigo;
				double distancia;
				double duracao;
				double valor;
				
				int dayC = datePickerAddViagemCHEGADA.getModel().getDay();
				int monthC = datePickerAddViagemCHEGADA.getModel().getMonth()+1;
				int yearC = datePickerAddViagemCHEGADA.getModel().getYear();
				String dataC = dayC+"/"+monthC+"/"+yearC;
				
				SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
				Date chegada = null;
				try {
					chegada = new java.sql.Date(DateFor.parse(dataC).getTime());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
				int dayP = datePickerAddViagemPARTIDA.getModel().getDay();
				int monthP = datePickerAddViagemPARTIDA.getModel().getMonth()+1;
				int yearP = datePickerAddViagemPARTIDA.getModel().getYear();
				String dataP = dayP+"/"+monthP+"/"+yearP;
				
				SimpleDateFormat DateFor2 = new SimpleDateFormat("dd/MM/yyyy");
				Date partida = null;
				try {
					partida = new java.sql.Date(DateFor2.parse(dataP).getTime());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
				
				String selectDestino = (String) comboBoxAddViagemDESTINO.getSelectedItem();
				String selectTransporte = (String) comboBoxAddViagemTRANSPORTE.getSelectedItem();
				
				ArrayList<String> inputs = new ArrayList<>();
				
				inputs.add(textFieldAddViagemCODIGO.getText());
				inputs.add(selectDestino);
				inputs.add(selectTransporte);
				inputs.add(textFieldAddViagemCODIGO.getText());
				
				if(!checkValues(inputs)) {
					JOptionPane.showMessageDialog(null, "Existe um erro em algum dos campos!");
					return;
				}
				
				String[] valorDestino = selectDestino.split("/");
				String cidade = valorDestino[0];
				String estado = valorDestino[1];
				String pais = valorDestino[2];
				
				
				String[] valorTransporte = selectTransporte.split("/");
				int codigoTransporte = Integer.parseInt(valorTransporte[0]);
				
				if(!tdao.getTransporte(codigoTransporte)){
					JOptionPane.showMessageDialog(null, "Esse transporte n�o existe!");
					return;
				}

				if(!ddao.getDestino(cidade, estado, pais)){
					JOptionPane.showMessageDialog(null, "Esse destino n�o existe!");
					return;
				}

				Destino d = new Destino();
				d.setCidade(cidade);
				d.setEstado(estado);
				d.setPais(pais);

				Transporte t = new Transporte();
				t.setCodigo(codigoTransporte);

				codigo = Integer.parseInt(textFieldAddViagemCODIGO.getText());
				distancia = Double.parseDouble(textFieldAddViagemDISTANCIA.getText());
				duracao = getDuracaoViagem(distancia);
				valor = getValorViagem(distancia);
				
				textFieldAddViagemCODIGO.setText("");
				textFieldAddViagemDISTANCIA.setText("");

				if(vdao.getViagem(codigo)){
					JOptionPane.showMessageDialog(null, "Essa viagem j� existe!");
					return;
				}
				
			
				Viagem v = new Viagem(codigo, d, t, distancia, duracao, partida, chegada, valor);
				vdao.inserir(v);
				JOptionPane.showMessageDialog(null, "Viagem cadastrada!");
			}
		});
		btnAddViagem.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 188/2, (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() -180, 188, 55);
		panelAddViagem.add(btnAddViagem);
		
		JLabel lblNewLabel_3_6 = new JLabel("C\u00F3digo");
		lblNewLabel_3_6.setForeground(Color.WHITE);
		lblNewLabel_3_6.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_3_6.setBounds(265, 218, 103, 20);
		panelAddViagem.add(lblNewLabel_3_6);
		
		JLabel lblNewLabel_3_7 = new JLabel("Destino");
		lblNewLabel_3_7.setForeground(Color.WHITE);
		lblNewLabel_3_7.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_3_7.setBounds(677, 218, 103, 20);
		panelAddViagem.add(lblNewLabel_3_7);
		
		JLabel lblNewLabel_3_8 = new JLabel("Transporte");
		lblNewLabel_3_8.setForeground(Color.WHITE);
		lblNewLabel_3_8.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_3_8.setBounds(1088, 218, 103, 20);
		panelAddViagem.add(lblNewLabel_3_8);
		
		JLabel lblNewLabel_3_9 = new JLabel("Distancia");
		lblNewLabel_3_9.setForeground(Color.WHITE);
		lblNewLabel_3_9.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_3_9.setBounds(265, 461, 103, 20);
		panelAddViagem.add(lblNewLabel_3_9);
		
		JLabel lblNewLabel_4 = new JLabel("Partida");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_4.setBounds(677, 461, 163, 20);
		panelAddViagem.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Chegada");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_4_1.setBounds(1088, 461, 103, 20);
		panelAddViagem.add(lblNewLabel_4_1);
		
		

		//DELETAR VIAGEM
		JPanel panelDelViagem = new JPanel();
		panelDelViagem.setBackground(bgColor);
		panelDelViagem.setBounds(0, 0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		//layeredPane.add(panelDelViagem);
		panelDelViagem.setLayout(null);
		
		textFieldDelViagemCODIGO = new JTextField();
		textFieldDelViagemCODIGO.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 -100, 200, 200, 34);
		panelDelViagem.add(textFieldDelViagemCODIGO);
		textFieldDelViagemCODIGO.setColumns(10);
		
		JLabel delViagemTitulo = new JLabel("Deletar Viagem");
		delViagemTitulo.setForeground(Color.WHITE);
		delViagemTitulo.setFont(new Font("Verdana", Font.BOLD, 30));
		delViagemTitulo.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 300/2, 80, 300, 34);
		panelDelViagem.add(delViagemTitulo);
		
		JButton btnDelViagem = new JButton("Deletar");
		btnDelViagem.setFont(new Font("Verdana", Font.BOLD, 15));
		btnDelViagem.setForeground(new Color(255, 255, 255));
		btnDelViagem.setBackground(new Color(0, 206, 209));
		btnDelViagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codigo;
				
				ArrayList<String> inputs = new ArrayList<>();
				
				inputs.add(textFieldDelViagemCODIGO.getText());
				
				if(!checkValues(inputs)) {
					JOptionPane.showMessageDialog(null, "Existe um erro em algum dos campos!");
					return;
				}
				
				codigo = Integer.parseInt(textFieldDelViagemCODIGO.getText());
				
				textFieldDelViagemCODIGO.setText("");
				
				if(vdao.getViagem(codigo)){
					Viagem v = new Viagem();
				 	v.setCodigo(codigo);
				 	vdao.remover(v);
				 	JOptionPane.showMessageDialog(null, "Viagem excluÃ­da!");
				}
				else{
					JOptionPane.showMessageDialog(null, "Essa viagem nÃ£o existe!");
				 	return;
				}
			}
		});
		btnDelViagem.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 188/2, (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() -180, 188, 55);
		panelDelViagem.add(btnDelViagem);
		
		JLabel lblNewLabel_4_2 = new JLabel("C\u00F3digo");
		lblNewLabel_4_2.setForeground(Color.WHITE);
		lblNewLabel_4_2.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_4_2.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 -100, 167, 103, 20);
		panelDelViagem.add(lblNewLabel_4_2);
		


		//EDITAR VIAGEM
		JPanel panelEditViagem = new JPanel();
		panelEditViagem.setBackground(bgColor);
		panelEditViagem.setBounds(0, 0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		//layeredPane.add(panelEditViagem);
		panelEditViagem .setLayout(null);
		
		textFieldEditViagemCODIGO = new JTextField();
		textFieldEditViagemCODIGO.setBounds(265, 256, 196, 34);
		panelEditViagem.add(textFieldEditViagemCODIGO);
		textFieldEditViagemCODIGO.setColumns(10);
		
		JComboBox<String> comboBoxEditViagemDESTINO = new JComboBox<String>();
		comboBoxEditViagemDESTINO.setBounds(677, 256, 196, 34);
		panelEditViagem.add(comboBoxEditViagemDESTINO);
		
		JComboBox<String> comboBoxEditViagemTRANSPORTE = new JComboBox<String>();
		comboBoxEditViagemTRANSPORTE.setBounds(1088, 256, 196, 34);
		panelEditViagem.add(comboBoxEditViagemTRANSPORTE);
		
		textFieldEditViagemDISTANCIA = new JTextField();
		textFieldEditViagemDISTANCIA.setColumns(10);
		textFieldEditViagemDISTANCIA.setBounds(265, 499, 196, 34);
		panelEditViagem.add(textFieldEditViagemDISTANCIA);
		
		JPanel calendarioEditViagemPARTIDA = new JPanel();
		calendarioEditViagemPARTIDA.setBounds(677, 499, 200, 200);
		calendarioEditViagemPARTIDA.setBackground(bgColor);
		
		UtilDateModel model2 = new UtilDateModel();
		Properties p2 = new Properties();
		p2.put("text.today", "Today");
		p2.put("text.month", "Month");
		p2.put("text.year", "Year");
		JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p2);
		JDatePickerImpl datePickerEditViagemPARTIDA = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
		 
		calendarioEditViagemPARTIDA.add(datePickerEditViagemPARTIDA);
		panelEditViagem.add(calendarioEditViagemPARTIDA);
		
		JPanel calendarioEditViagemCHEGADA = new JPanel();
		calendarioEditViagemCHEGADA.setBounds(1088, 499, 200, 200);
		calendarioEditViagemCHEGADA.setBackground(bgColor);
		
		UtilDateModel model3 = new UtilDateModel();
		Properties p3 = new Properties();
		p3.put("text.today", "Today");
		p3.put("text.month", "Month");
		p3.put("text.year", "Year");
		JDatePanelImpl datePanel3 = new JDatePanelImpl(model3, p3);
		JDatePickerImpl datePickerEditViagemCHEGADA = new JDatePickerImpl(datePanel3, new DateLabelFormatter());
		 
		calendarioEditViagemCHEGADA.add(datePickerEditViagemCHEGADA);
		panelEditViagem.add(calendarioEditViagemCHEGADA);
		
		
		JLabel editViagemTitulo = new JLabel("Editar Viagem");
		editViagemTitulo.setForeground(Color.WHITE);
		editViagemTitulo.setFont(new Font("Verdana", Font.BOLD, 30));
		editViagemTitulo.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 330/2, 80, 330, 34);
		panelEditViagem.add(editViagemTitulo);
		
		JButton btnEditViagem = new JButton("Editar");
		btnEditViagem.setFont(new Font("Verdana", Font.BOLD, 15));
		btnEditViagem.setForeground(new Color(255, 255, 255));
		btnEditViagem.setBackground(new Color(0, 206, 209));
		btnEditViagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int codigo;
				double distancia;
				double duracao;
				double valor;
				
				String selectDestino = (String) comboBoxEditViagemDESTINO.getSelectedItem();
				String selectTransporte = (String) comboBoxEditViagemTRANSPORTE.getSelectedItem();
				
				ArrayList<String> inputs = new ArrayList<>();
				
				inputs.add(textFieldEditViagemCODIGO.getText());
				inputs.add(selectDestino);
				inputs.add(selectTransporte);
				inputs.add(textFieldEditViagemDISTANCIA.getText());
				
				if(!checkValues(inputs)) {
					JOptionPane.showMessageDialog(null, "Existe um erro em algum dos campos!");
					return;
				}
				
				int dayC = datePickerEditViagemCHEGADA.getModel().getDay();
				int monthC = datePickerEditViagemCHEGADA.getModel().getMonth()+1;
				int yearC = datePickerEditViagemCHEGADA.getModel().getYear();
				String dataC = dayC+"/"+monthC+"/"+yearC;
				
				SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
				Date chegada = null;
				try {
					chegada = new java.sql.Date(DateFor.parse(dataC).getTime());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
				
				int dayP = datePickerEditViagemPARTIDA.getModel().getDay();
				int monthP = datePickerEditViagemPARTIDA.getModel().getMonth()+1;
				int yearP = datePickerEditViagemPARTIDA.getModel().getYear();
				String dataP = dayP+"/"+monthP+"/"+yearP;
				
				SimpleDateFormat DateFor2 = new SimpleDateFormat("dd/MM/yyyy");
				Date partida = null;
				try {
					partida = new java.sql.Date(DateFor2.parse(dataP).getTime());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
				String[] valorDestino = selectDestino.split("/");
				String cidade = valorDestino[0];
				String estado = valorDestino[1];
				String pais = valorDestino[2];
				
				String[] valorTransporte = selectTransporte.split("/");
				int codigoTransporte = Integer.parseInt(valorTransporte[0]);
				
				
				if(!tdao.getTransporte(codigoTransporte)){
					JOptionPane.showMessageDialog(null, "Esse trasnporte n�o existe!");
					return;
				}

				if(!ddao.getDestino(cidade, estado, pais)){
					JOptionPane.showMessageDialog(null, "Esse destino n�o existe!");
					return;
				}

				Destino d = new Destino();
				d.setCidade(cidade);
				d.setEstado(estado);
				d.setPais(pais);

				Transporte t = new Transporte();
				t.setCodigo(codigoTransporte);
				

			
				codigo = Integer.parseInt(textFieldEditViagemCODIGO.getText());
				distancia = Double.parseDouble(textFieldEditViagemDISTANCIA.getText());
				duracao = getDuracaoViagem(distancia);
				valor = getValorViagem(distancia);
				
				textFieldEditViagemCODIGO.setText("");
				textFieldEditViagemDISTANCIA.setText("");

				
				if(!vdao.getViagem(codigo)){
					JOptionPane.showMessageDialog(null, "Essa viagem não existe!");
					return;
				}
				
				Viagem v = new Viagem(codigo, d, t, distancia, duracao, partida, chegada, valor);
				vdao.alterar(v);
				JOptionPane.showMessageDialog(null, "Viagem editada!");
				
			}
		});
		btnEditViagem.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 188/2, (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() -180, 188, 55);
		panelEditViagem.add(btnEditViagem);
		
		JLabel lblNewLabel_4_3 = new JLabel("C\u00F3digo");
		lblNewLabel_4_3.setForeground(Color.WHITE);
		lblNewLabel_4_3.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_4_3.setBounds(265, 218, 103, 20);
		panelEditViagem.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_4_4 = new JLabel("Destino");
		lblNewLabel_4_4.setForeground(Color.WHITE);
		lblNewLabel_4_4.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_4_4.setBounds(677, 218, 103, 20);
		panelEditViagem.add(lblNewLabel_4_4);
		
		JLabel lblNewLabel_4_5 = new JLabel("Transporte");
		lblNewLabel_4_5.setForeground(Color.WHITE);
		lblNewLabel_4_5.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_4_5.setBounds(1088, 218, 103, 20);
		panelEditViagem.add(lblNewLabel_4_5);
		
		JLabel lblNewLabel_4_6 = new JLabel("Distancia");
		lblNewLabel_4_6.setForeground(Color.WHITE);
		lblNewLabel_4_6.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_4_6.setBounds(265, 461, 103, 20);
		panelEditViagem.add(lblNewLabel_4_6);
		
		JLabel lblNewLabel_4_7 = new JLabel("Partida");
		lblNewLabel_4_7.setForeground(Color.WHITE);
		lblNewLabel_4_7.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_4_7.setBounds(677, 461, 163, 20);
		panelEditViagem.add(lblNewLabel_4_7);
		
		JLabel lblNewLabel_4_8 = new JLabel("Chegada");
		lblNewLabel_4_8.setForeground(Color.WHITE);
		lblNewLabel_4_8.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_4_8.setBounds(1088, 461, 103, 20);
		panelEditViagem.add(lblNewLabel_4_8);
		
		
		//LISTAR VIAGEM
		JPanel panelListViagem = new JPanel();
		panelListViagem.setBackground(bgColor);
		panelListViagem.setBounds(0, 0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		//layeredPane.add(panelListViagem);
		panelListViagem.setLayout(null);
		
		JScrollPane scrollPane2 = new JScrollPane();
		panelListViagem.add(scrollPane2);
		
		tableListViagem = new JTable();
		scrollPane2.setViewportView(tableListViagem );
		scrollPane2.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 750/2, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() -750, 750, 170);
		
		tableListViagem.setModel(new DefaultTableModel(
			new Object[][] {
		},
		new String[] {
			"Codigo", "Cidade", "Estado", "Pa\u00EDs", "Transporte", "Distancia", "Duracao", "Partida", "Chegada", "Valor"
		}
			) {
		Class[] columnTypes = new Class[] {
			Integer.class, String.class, String.class, String.class, Integer.class, Double.class, Double.class, String.class, String.class, Double.class
		};
		public Class getColumnClass(int columnIndex) {
			return columnTypes[columnIndex];
		}
			}
		);
		tableListViagem.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 250, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() -250, 500, 170);
		

		JLabel listViagemTitulo = new JLabel("Listar Viagens");
		listViagemTitulo.setForeground(Color.WHITE);
		listViagemTitulo.setFont(new Font("Verdana", Font.BOLD, 30));
		listViagemTitulo.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 330/2, 80, 330, 34);
		panelListViagem.add(listViagemTitulo);
		


		//CADASTRAR FUSO
		JPanel panelAddFuso = new JPanel();
		panelAddFuso.setBackground(bgColor);
		panelAddFuso.setBounds(0, 0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		//layeredPane.add(panelAddFuso);
		panelAddFuso.setLayout(null);
		
		textFieldAddFusoFUSO = new JTextField();
		textFieldAddFusoFUSO.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 -100, 350, 200, 34);
		panelAddFuso.add(textFieldAddFusoFUSO);
		textFieldAddFusoFUSO.setColumns(10);
		
		JComboBox<String> comboBoxAddFusoDESTINO = new JComboBox<String>();
		comboBoxAddFusoDESTINO.setModel(new DefaultComboBoxModel<String>(comboBoxDestinos.toArray(new String[0])));
		comboBoxAddFusoDESTINO.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 -100, 200, 200, 34);
		panelAddFuso.add(comboBoxAddFusoDESTINO);
		
		JLabel addFusoTitulo = new JLabel("Adicionar Fuso Horário");
		addFusoTitulo.setForeground(Color.WHITE);
		addFusoTitulo.setFont(new Font("Verdana", Font.BOLD, 30));
		addFusoTitulo.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 350/2, 80, 400, 34);
		panelAddFuso.add(addFusoTitulo);
		
		JButton btnAddFuso = new JButton("Adicionar");
		btnAddFuso.setFont(new Font("Verdana", Font.BOLD, 15));
		btnAddFuso.setForeground(new Color(255, 255, 255));
		btnAddFuso.setBackground(new Color(0, 206, 209));
		btnAddFuso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fuso;
				
				ArrayList<String> inputs = new ArrayList<>();
				
				inputs.add(textFieldAddFusoFUSO.getText());
				
				if(!checkValues(inputs)) {
					JOptionPane.showMessageDialog(null, "Existe um erro em algum dos campos!");
					return;
				}
				
				fuso = Integer.parseInt(textFieldAddFusoFUSO.getText());

				String selectDestino = (String) comboBoxAddFusoDESTINO.getSelectedItem();
				
				String[] valorDestino = selectDestino.split("/");
				String cidade = valorDestino[0];
				String estado = valorDestino[1];
				String pais = valorDestino[2];
				
				textFieldAddFusoFUSO.setText("");
				
				if(!ddao.getDestino(cidade, estado, pais)){
					JOptionPane.showMessageDialog(null, "Esse destino nÃ£o existe!");
					return;
				}
				
				Fuso f = new Fuso(cidade, estado, pais, fuso);
				
				if(!fdao.getFuso(f)) {
					fdao.inserir(f);
					JOptionPane.showMessageDialog(null, "Fuso adicionado!");
					return;
				}
				JOptionPane.showMessageDialog(null, "Este fuso j� existe nesse destino!");
			}
		});
		btnAddFuso.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 188/2, (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() -180, 188, 55);
		panelAddFuso.add(btnAddFuso);
		
		
		JLabel lblNewLabel_4_9 = new JLabel("Fuso");
		lblNewLabel_4_9.setForeground(Color.WHITE);
		lblNewLabel_4_9.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_4_9.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 -100, 317, 103, 20);
		panelAddFuso.add(lblNewLabel_4_9);
		
		

		//CADASTRAR PONTO TURÃ�STICO
		JPanel panelAddTuristico = new JPanel();
		panelAddTuristico.setBackground(bgColor);
		panelAddTuristico.setBounds(0, 0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		//layeredPane.add(panelAddTuristico);
		panelAddTuristico.setLayout(null);
		
		textFieldAddTuristicoNOME = new JTextField();
		textFieldAddTuristicoNOME.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 -100, 350, 200, 34);
		panelAddTuristico.add(textFieldAddTuristicoNOME);
		textFieldAddTuristicoNOME.setColumns(10);
		
		JComboBox<String> comboBoxAddTuristicoDESTINO = new JComboBox<String>();
		comboBoxAddTuristicoDESTINO.setModel(new DefaultComboBoxModel<String>(comboBoxDestinos.toArray(new String[0])));
		comboBoxAddTuristicoDESTINO.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 -100, 200, 200, 34);
		panelAddTuristico.add(comboBoxAddTuristicoDESTINO);
		
		JLabel addTuristicoTitulo = new JLabel("Adicionar Ponto Turístio");
		addTuristicoTitulo.setForeground(Color.WHITE);
		addTuristicoTitulo.setFont(new Font("Verdana", Font.BOLD, 30));
		addTuristicoTitulo.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 430/2, 80, 430, 34);
		panelAddTuristico.add(addTuristicoTitulo);
		
		JButton btnAddTuristico = new JButton("Adicionar");
		btnAddTuristico.setFont(new Font("Verdana", Font.BOLD, 15));
		btnAddTuristico.setForeground(new Color(255, 255, 255));
		btnAddTuristico.setBackground(new Color(0, 206, 209));
		btnAddTuristico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ArrayList<String> inputs = new ArrayList<>();
				
				inputs.add(textFieldAddTuristicoNOME.getText());
				
				if(!checkValues(inputs)) {
					JOptionPane.showMessageDialog(null, "Existe um erro em algum dos campos!");
					return;
				}
				
				String turistico = textFieldAddTuristicoNOME.getText();

				String selectDestino = (String) comboBoxAddTuristicoDESTINO.getSelectedItem();
				
				String[] valorDestino = selectDestino.split("/");
				String cidade = valorDestino[0];
				String estado = valorDestino[1];
				String pais = valorDestino[2];
				
				 textFieldAddTuristicoNOME.setText("");
				
				if(!ddao.getDestino(cidade, estado, pais)){
					JOptionPane.showMessageDialog(null, "Esse destino n�o existe!");
					return;
				}
				Turistico t = new Turistico(cidade, estado, pais, turistico);
				
				if(!tudao.getTuristico(t)) {
					tudao.inserir(t);
					JOptionPane.showMessageDialog(null, "Ponto tur�stico cadastrado!");
					return;
				}
				JOptionPane.showMessageDialog(null, "Esse ponto tur�stico j� existe nesse destino!");
			}
		});
		btnAddTuristico.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 188/2, (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() -180, 188, 55);
		panelAddTuristico.add(btnAddTuristico);
		
		
		JLabel lblNewLabel_5 = new JLabel("Nome");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_5.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 -100, 317, 103, 20);
		panelAddTuristico.add(lblNewLabel_5);
		

		
		//TOTAL DE TRANSPORTES
		JPanel panelRelTTransporte = new JPanel();
		panelRelTTransporte.setBackground(bgColor);
		panelRelTTransporte.setBounds(0, 0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		//layeredPane.add(panelRelTTransporte);
		panelRelTTransporte.setLayout(null);

		JLabel RelTTransporteTitulo = new JLabel("Total de transportes");
		RelTTransporteTitulo.setForeground(Color.WHITE);
		RelTTransporteTitulo.setFont(new Font("Verdana", Font.BOLD, 30));
		RelTTransporteTitulo.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 370/2, 80, 370, 34);
		panelRelTTransporte.add(RelTTransporteTitulo);
		
		JLabel resultadoTTransporte = new JLabel("");
		resultadoTTransporte.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 -180/2, 150, 180, 20);
		resultadoTTransporte.setForeground(Color.WHITE);
		resultadoTTransporte.setFont(new Font("Verdana", Font.BOLD, 20));
		panelRelTTransporte.add(resultadoTTransporte);
		

		//TOTAL DE DESTINOS
		JPanel panelRelTDestino = new JPanel();
		panelRelTDestino.setBackground(bgColor);
		panelRelTDestino.setBounds(0, 0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		//layeredPane.add(panelRelTDestino);
		panelRelTDestino.setLayout(null);
		
		JLabel RelTDestinoTitulo = new JLabel("Total de destinos");
		RelTDestinoTitulo.setForeground(Color.WHITE);
		RelTDestinoTitulo.setFont(new Font("Verdana", Font.BOLD, 30));
		RelTDestinoTitulo.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 370/2, 80, 370, 34);
		panelRelTDestino.add(RelTDestinoTitulo);
		
		JLabel resultadoTDestino = new JLabel("");
		resultadoTDestino.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 -180/2, 150, 180, 20);
		resultadoTDestino.setForeground(Color.WHITE);
		resultadoTDestino.setFont(new Font("Verdana", Font.BOLD, 20));
		panelRelTDestino.add(resultadoTDestino);
		

		//TOTAL DE VIAGENS
		JPanel panelRelTViagem = new JPanel();
		panelRelTViagem.setBackground(bgColor);
		panelRelTViagem.setBounds(0, 0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		//layeredPane.add(panelRelTViagem);
		panelRelTViagem.setLayout(null);
		
		JLabel RelTViagemTitulo = new JLabel("Total de viagens");
		RelTViagemTitulo.setForeground(Color.WHITE);
		RelTViagemTitulo.setFont(new Font("Verdana", Font.BOLD, 30));
		RelTViagemTitulo.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 370/2, 80, 370, 34);
		panelRelTViagem.add(RelTViagemTitulo);
		
		JLabel resultadoTViagem = new JLabel("");
		resultadoTViagem.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 -180/2, 150, 180, 20);
		resultadoTViagem.setForeground(Color.WHITE);
		resultadoTViagem.setFont(new Font("Verdana", Font.BOLD, 20));
		panelRelTViagem.add(resultadoTViagem);
		
						
		//CONSULTA DURA��O VIAGEM
		JPanel panelRelDuracao = new JPanel();
		panelRelDuracao.setBackground(bgColor);
		panelRelDuracao.setBounds(0, 0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		//layeredPane.add(panelRelDuracao);
		panelRelDuracao.setLayout(null);
		
		JLabel RelDuracaoViagem = new JLabel("Dura��o de viagens");
		RelDuracaoViagem.setForeground(Color.WHITE);
		RelDuracaoViagem.setFont(new Font("Verdana", Font.BOLD, 30));
		RelDuracaoViagem.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 370/2, 60, 370, 34);
		panelRelDuracao.add(RelDuracaoViagem);
		
		textFieldDuracaoViagemVALOR = new JTextField();
		textFieldDuracaoViagemVALOR.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 -100, 200, 200, 34);
		panelRelDuracao.add(textFieldDuracaoViagemVALOR);
		textFieldDuracaoViagemVALOR.setColumns(10);
		
		JScrollPane scrollPane4 = new JScrollPane();
		panelRelDuracao.add(scrollPane4);
		
		tableDuracaoViagem = new JTable();
		scrollPane4.setViewportView(tableDuracaoViagem );
		scrollPane4.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 750/2, 340, 750, 170);
		
		tableDuracaoViagem.setModel(new DefaultTableModel(
			new Object[][] {
		},
		new String[] {
			"Codigo", "Cidade", "Estado", "Pa\u00EDs", "Transporte", "Distancia", "Duracao", "Partida", "Chegada", "Valor"
		}
			) {
		Class[] columnTypes = new Class[] {
			Integer.class, String.class, String.class, String.class, Integer.class, Double.class, Double.class, String.class, String.class, Double.class
		};
		public Class getColumnClass(int columnIndex) {
			return columnTypes[columnIndex];
		}
			}
		);
		tableDuracaoViagem.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 700, 1000, 1400, 170);
		
		JButton btnDuracaoViagem = new JButton("Buscar");
		btnDuracaoViagem.setFont(new Font("Verdana", Font.BOLD, 15));
		btnDuracaoViagem.setForeground(new Color(255, 255, 255));
		btnDuracaoViagem.setBackground(new Color(0, 206, 209));
		btnDuracaoViagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ArrayList<String> inputs = new ArrayList<>();
				
				inputs.add(textFieldDuracaoViagemVALOR.getText());
				
				if(!checkValues(inputs)) {
					JOptionPane.showMessageDialog(null, "Existe um erro em algum dos campos!");
					return;
				}
				
				double valor = Double.parseDouble(textFieldDuracaoViagemVALOR.getText());

				viagens = rdao.duracaoViagem(valor);
				
				textFieldDuracaoViagemVALOR.setText("");
				
				DefaultTableModel model5 = (DefaultTableModel) tableDuracaoViagem.getModel();
				model5.setRowCount(0);
				for(int i = 0; i < viagens.size(); i++){
					Viagem v = viagens.get(i);
					Destino d = v.getDestino();
					Transporte t = v.getTransporte();
					model5.addRow(new Object[] {v.getCodigo(), d.getCidade(), d.getEstado(), d.getPais(), t.getCodigo(), v.getDistancia(), v.getDuracao(), v.getPartida(), v.getChegada(), v.getValor()});
				}
			};
		});
		btnDuracaoViagem.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 188/2, (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() -180, 188, 55);
		panelRelDuracao.add(btnDuracaoViagem);
		
		JLabel RelDuracaoViagemTotal = new JLabel("Duração em horas");
		RelDuracaoViagemTotal.setForeground(Color.WHITE);
		RelDuracaoViagemTotal.setFont(new Font("Verdana", Font.BOLD, 15));
		RelDuracaoViagemTotal.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 200/2, 167, 200, 34);
		panelRelDuracao.add(RelDuracaoViagemTotal);
		
		
		
		//CONSULTA VALOR VIAGEM
		JPanel panelRelValor = new JPanel();
		panelRelValor.setBackground(bgColor);
		panelRelValor.setBounds(0, 0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		//layeredPane.add(panelRelValor);
		panelRelValor.setLayout(null);
		
		JScrollPane scrollPane3 = new JScrollPane();
		panelRelValor.add(scrollPane3);
		
		tableValorViagem = new JTable();
		scrollPane3.setViewportView(tableValorViagem );
		scrollPane3.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 750/2, 340, 750, 170);
		
		tableValorViagem.setModel(new DefaultTableModel(
			new Object[][] {
		},
		new String[] {
			"Codigo", "Cidade", "Estado", "Pa\u00EDs", "Transporte", "Distancia", "Duracao", "Partida", "Chegada", "Valor"
		}
			) {
		Class[] columnTypes = new Class[] {
			Integer.class, String.class, String.class, String.class, Integer.class, Double.class, Double.class, String.class, String.class, Double.class
		};
		public Class getColumnClass(int columnIndex) {
			return columnTypes[columnIndex];
		}
			}
		);
		tableValorViagem.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 700, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() -250, 1400, 170);
		

		textFieldValorViagemVALOR= new JTextField();
		textFieldValorViagemVALOR.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 -100, 140, 200, 34);
		panelRelValor.add(textFieldValorViagemVALOR);
		textFieldValorViagemVALOR.setColumns(10);

			
		JLabel valorViagemTitulo = new JLabel("Valor de Viagens");
		valorViagemTitulo.setForeground(Color.WHITE);
		valorViagemTitulo.setFont(new Font("Verdana", Font.BOLD, 30));
		valorViagemTitulo.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 300/2, 60, 300, 34);
		panelRelValor.add(valorViagemTitulo);

		JButton btnValorViagem = new JButton("Buscar");
		btnValorViagem.setFont(new Font("Verdana", Font.BOLD, 15));
		btnValorViagem.setForeground(new Color(255, 255, 255));
		btnValorViagem.setBackground(new Color(0, 206, 209));
		btnValorViagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				double valor; 

				ArrayList<String> inputs = new ArrayList<>();
				
				inputs.add(textFieldValorViagemVALOR.getText());
				
				if(!checkValues(inputs)) {
					JOptionPane.showMessageDialog(null, "Existe um erro em algum dos campos!");
					return;
				}

				valor = Double.parseDouble(textFieldValorViagemVALOR.getText());
				textFieldValorViagemVALOR.setText("");

				viagens = rdao.valorViagem(valor);
				
				if(viagens.size() == 0) {
					JOptionPane.showMessageDialog(null, "Nada foi encontrado!");
					return;
				}
				
				DefaultTableModel model4 = (DefaultTableModel) tableValorViagem.getModel();
				model4.setRowCount(0);
				for(int i = 0; i < viagens.size(); i++){
					Viagem v = viagens.get(i);
					Destino d = v.getDestino();
					Transporte t = v.getTransporte();
					model4.addRow(new Object[] {v.getCodigo(), d.getCidade(), d.getEstado(), d.getPais(), t.getCodigo(), v.getDistancia(), v.getDuracao(), v.getPartida(), v.getChegada(), v.getValor()});
				};
			};
		});
		btnValorViagem.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 188/2, (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() -180, 188, 55);
		panelRelValor.add(btnValorViagem);

		JLabel lblNewLabel_5_1 = new JLabel("Valor base");
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_5_1.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 -100, 117, 103, 20);
		panelRelValor.add(lblNewLabel_5_1);

		//CONSULTA PONTOS TURÃ�STICOS DESTINO
		JPanel panelRelPontosTuristicos = new JPanel();
		panelRelPontosTuristicos.setBackground(bgColor);
		panelRelPontosTuristicos.setBounds(0, 0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		//layeredPane.add(panelRelPontosTuristicos);
		panelRelPontosTuristicos.setLayout(null);
		
		JComboBox<String> comboBoxRelTuristicosDESTINO = new JComboBox<String>();
		comboBoxRelTuristicosDESTINO.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 -100, 160, 200, 34);
		panelRelPontosTuristicos.add(comboBoxRelTuristicosDESTINO);
		
		JLabel relTuristicoTitulo = new JLabel("Pontos tur�sticos");
		relTuristicoTitulo.setForeground(Color.WHITE);
		relTuristicoTitulo.setFont(new Font("Verdana", Font.BOLD, 30));
		relTuristicoTitulo.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 350/2, 80, 400, 34);
		panelRelPontosTuristicos.add(relTuristicoTitulo);
		
		JScrollPane scrollPane5 = new JScrollPane();
		panelRelPontosTuristicos.add(scrollPane5);
				
		tableListTuristicos = new JTable();
		scrollPane5.setViewportView(tableListTuristicos );
		scrollPane5.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 750/2, 340, 750, 170);
				
		tableListTuristicos.setModel(new DefaultTableModel(
			new Object[][] {
				},
				new String[] {
					"Cidade", "Estado", "Pais", "Nome"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			}
		);
		tableListTuristicos.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 500, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() -250, 1000, 170);
		
		JButton btnRelTuristico = new JButton("Buscar");
		btnRelTuristico.setFont(new Font("Verdana", Font.BOLD, 15));
		btnRelTuristico.setForeground(new Color(255, 255, 255));
		btnRelTuristico.setBackground(new Color(0, 206, 209));
		btnRelTuristico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String selectDestino = (String) comboBoxRelTuristicosDESTINO.getSelectedItem();
				
				String[] valorDestino = selectDestino.split("/");
				String cidade = valorDestino[0];
				String estado = valorDestino[1];
				String pais = valorDestino[2];
				
				Destino d = new Destino();
				d.setCidade(cidade);
				d.setEstado(estado);
				d.setPais(pais);

				DefaultTableModel model = (DefaultTableModel) tableListTuristicos.getModel();
				model.setRowCount(0);
				ArrayList<Turistico> pontosTuristicos = rdao.pontosTuristicos(d);
				for(int i = 0; i < pontosTuristicos.size(); i++){
					Turistico t = pontosTuristicos.get(i);
					model.addRow(new Object[] {t.getCidade(), t.getEstado(), t.getPais(), t.getNome()});
				}
			}
		});
		btnRelTuristico.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - 188/2, (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() -180, 188, 55);
		panelRelPontosTuristicos.add(btnRelTuristico);
		
		
		//CONFIGURAR MENUS
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuTransporte = new JMenu("Transporte");
		menuBar.add(menuTransporte);
		
		JMenuItem addTransporte = new JMenuItem("Adicionar");
		addTransporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_screen(panelAddTransporte);
			}
		});
		menuTransporte.add(addTransporte);
		
		JMenuItem delTransporte = new JMenuItem("Deletar");
		delTransporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_screen(panelDelTransporte);
			}
		});
		menuTransporte.add(delTransporte);
		
		JMenuItem editTransporte = new JMenuItem("Editar");
		editTransporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_screen(panelEditTransporte);
			}
		});
		menuTransporte.add(editTransporte);
		
		JMenuItem listTransporte = new JMenuItem("Listar");
		listTransporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transportes = tdao.listar();
				
				if(transportes.size() == 0) {
					JOptionPane.showMessageDialog(null, "Nada foi encontrado!");
				}
				
				DefaultTableModel model1 = (DefaultTableModel) tableListTransporte.getModel();
				model1.setRowCount(0);
				for(int i = 0; i < transportes.size(); i++){
					Transporte t = transportes.get(i);
					model1.addRow(new Object[] {t.getCodigo(), t.getTipo(), t.getCarga(), t.getPassageiros(), t.getModelo(), t.getCombustivel()});
				}
				Switch_screen(panelListTransporte);
			}
		});
		menuTransporte.add(listTransporte);
		
		JMenu menuDestino = new JMenu("Destino");
		menuBar.add(menuDestino);
		
		JMenuItem addDestino = new JMenuItem("Adicionar");
		addDestino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_screen(panelAddDestino);
			}
		});
		menuDestino.add(addDestino);
		
		JMenuItem delDestino = new JMenuItem("Deletar");
		delDestino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_screen(panelDelDestino);
			}
		});
		menuDestino.add(delDestino);
		
		JMenuItem editDestino = new JMenuItem("Editar");
		editDestino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_screen(panelEditDestino);
			}
		});
		menuDestino.add(editDestino);
		
		JMenuItem listDestino = new JMenuItem("Listar");
		listDestino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				destinos = ddao.listar();
				
				if(destinos.size() == 0) {
					JOptionPane.showMessageDialog(null, "Nada foi encontrado!");
				}
				
				DefaultTableModel model2 = (DefaultTableModel) tableListDestino.getModel();
				model2.setRowCount(0);
				for(int i = 0; i < destinos.size(); i++){
					Destino d = destinos.get(i);
					model2.addRow(new Object[] {d.getCidade(), d.getEstado(), d.getPais(), d.getCoordenadas(), d.getnHab()});
				}
				Switch_screen(panelListDestino);
			}
		});
		menuDestino.add(listDestino);
		
		JMenu menuViagem = new JMenu("Viagem");
		menuBar.add(menuViagem);
		
		JMenuItem addViagem = new JMenuItem("Adicionar");
		addViagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				destinos = ddao.listar();
				transportes = tdao.listar();
				comboBoxDestinos.clear();
				comboBoxTransportes.clear();
				
				for(int i = 0; i < transportes.size(); i++){
					String codigo = Integer.toString(transportes.get(i).getCodigo());
					String tipo = transportes.get(i).getTipo();
					String modelo = transportes.get(i).getModelo();
					comboBoxAddViagemTRANSPORTE.addItem(codigo+"/"+tipo+"/"+modelo);
				}
				
				for(int i = 0; i < destinos.size(); i++){
					String cidade = destinos.get(i).getCidade();
					String estado = destinos.get(i).getEstado();
					String pais = destinos.get(i).getPais();
					comboBoxAddViagemDESTINO.addItem(cidade+"/"+estado+"/"+pais);
				}
				
				Switch_screen(panelAddViagem);
			}
		});
		menuViagem.add(addViagem);
		
		JMenuItem delViagem = new JMenuItem("Deletar");
		delViagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_screen(panelDelViagem);
			}
		});
		menuViagem.add(delViagem);
		
		JMenuItem editViagem = new JMenuItem("Editar");
		editViagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				destinos = ddao.listar();
				transportes = tdao.listar();
				
				for(int i = 0; i < transportes.size(); i++){
					String codigo = Integer.toString(transportes.get(i).getCodigo());
					String tipo = transportes.get(i).getTipo();
					String modelo = transportes.get(i).getModelo();
					comboBoxEditViagemTRANSPORTE.addItem((String)codigo+"/"+tipo+"/"+modelo);
				}
				
				for(int i = 0; i < destinos.size(); i++){
					String cidade = destinos.get(i).getCidade();
					String estado = destinos.get(i).getEstado();
					String pais = destinos.get(i).getPais();
					comboBoxEditViagemDESTINO.addItem((String)cidade+"/"+estado+"/"+pais);
				}
				
				Switch_screen(panelEditViagem);
			}
		});
		menuViagem.add(editViagem);
		
		JMenuItem listViagem = new JMenuItem("Listar");
		listViagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viagens = vdao.listar();
				
				if(viagens.size() == 0) {
					JOptionPane.showMessageDialog(null, "Nada foi encontrado!");
				}
				
				DefaultTableModel model3 = (DefaultTableModel) tableListViagem.getModel();
				model3.setRowCount(0);
				for(int i = 0; i < viagens.size(); i++){
					Viagem v = viagens.get(i);
					Destino d = v.getDestino();
					Transporte t = v.getTransporte();
					model3.addRow(new Object[] {v.getCodigo(), d.getCidade(), d.getEstado(), d.getPais(), t.getCodigo(), v.getDistancia(), v.getDuracao(), v.getPartida(), v.getChegada(), v.getValor()});
				}
				
				Switch_screen(panelListViagem);
			}
		});
		menuViagem.add(listViagem);
		
		JMenu menuFuso = new JMenu("Fuso Hor\u00E1rio");
		menuBar.add(menuFuso);
		
		JMenuItem addFuso = new JMenuItem("Adicionar");
		addFuso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				destinos = ddao.listar();
				
				for(int i = 0; i < destinos.size(); i++){
					String cidade = destinos.get(i).getCidade();
					String estado = destinos.get(i).getEstado();
					String pais = destinos.get(i).getPais();
					comboBoxAddFusoDESTINO.addItem((String) cidade+"/"+estado+"/"+pais);
				}
				
				Switch_screen(panelAddFuso);
			}
		});
		menuFuso.add(addFuso);
		
		JMenu menuTuristico = new JMenu("Ponto Tur\u00EDstico");
		menuBar.add(menuTuristico);
		
		JMenuItem addTuristico = new JMenuItem("Adicionar");
		addTuristico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				destinos = ddao.listar();
				
				for(int i = 0; i < destinos.size(); i++){
					String cidade = destinos.get(i).getCidade();
					String estado = destinos.get(i).getEstado();
					String pais = destinos.get(i).getPais();
					comboBoxAddTuristicoDESTINO.addItem(cidade+"/"+estado+"/"+pais);
				}
				
				Switch_screen(panelAddTuristico);
			}
		});
		menuTuristico.add(addTuristico);
		
		JMenu menuRelatorios = new JMenu("Relat\u00F3rios");
		menuBar.add(menuRelatorios);
		
		JMenuItem relTotalTransportes = new JMenuItem("Total Transportes");
		relTotalTransportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totalTransportes = rdao.totalTransportes();
				resultadoTTransporte.setText(Integer.toString(totalTransportes) + " transportes");
				
				Switch_screen(panelRelTTransporte);
			}
		});
		menuRelatorios.add(relTotalTransportes);
		
		JMenuItem relTotalDestinos = new JMenuItem("Total Destinos");
		relTotalDestinos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totalDestinos = rdao.totalDestinos();
				resultadoTDestino.setText(Integer.toString(totalDestinos) + " destinos");
				
				Switch_screen(panelRelTDestino);
			}
		});
		menuRelatorios.add(relTotalDestinos);
		
		JMenuItem relTotalViagens = new JMenuItem("Total Viagens");
		relTotalViagens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totalViagens = rdao.totalViagens();
				resultadoTViagem.setText(Integer.toString(totalViagens) + " viagens");
				
				Switch_screen(panelRelTViagem);
			}
		});
		menuRelatorios.add(relTotalViagens);
		
		JMenuItem relDuracaoViagem = new JMenuItem("Dura\u00E7\u00E3o Viagem");
		relDuracaoViagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viagens = vdao.listar();
				comboBoxViagens.clear();
				
				for(int i = 0; i < viagens.size(); i++){
					String codigo = Integer.toString(viagens.get(i).getCodigo());
					String cidade = viagens.get(i).getDestino().getCidade();
					String estado = viagens.get(i).getDestino().getEstado();
					String pais = viagens.get(i).getDestino().getPais();
					comboBoxViagens.add(codigo+"/"+cidade+"/"+estado+"/"+pais);
				}
				
				Switch_screen(panelRelDuracao);
			}
		});
		menuRelatorios.add(relDuracaoViagem);
		
		JMenuItem relValorViagem = new JMenuItem("Valor Viagem");
		relValorViagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viagens = vdao.listar();
				comboBoxViagens.clear();
				
				for(int i = 0; i < viagens.size(); i++){
					String codigo = Integer.toString(viagens.get(i).getCodigo());
					String cidade = viagens.get(i).getDestino().getCidade();
					String estado = viagens.get(i).getDestino().getEstado();
					String pais = viagens.get(i).getDestino().getPais();
					comboBoxViagens.add(codigo+"/"+cidade+"/"+estado+"/"+pais);
				}
				
				Switch_screen(panelRelValor);
			}
		});
		menuRelatorios.add(relValorViagem);
		
		JMenuItem relPontosTuristicos = new JMenuItem("Pontos Tur\u00EDsticos");
		relPontosTuristicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				destinos = ddao.listar();

				for(int i = 0; i < destinos.size(); i++){
					String cidade = destinos.get(i).getCidade();
					String estado = destinos.get(i).getEstado();
					String pais = destinos.get(i).getPais();
					comboBoxRelTuristicosDESTINO.addItem(cidade+"/"+estado+"/"+pais);
				}
				
				Switch_screen(panelRelPontosTuristicos);
			}
		});
		menuRelatorios.add(relPontosTuristicos);

	}
}
