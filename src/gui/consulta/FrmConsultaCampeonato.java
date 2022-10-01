package gui.consulta;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class FrmConsultaCampeonato extends JFrame  {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFiltro;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
					FrmConsultaCampeonato frame = new FrmConsultaCampeonato();
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
	public FrmConsultaCampeonato() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConsultaDeCampeonatos = new JLabel("Consulta de campeonatos por nombre");
		lblConsultaDeCampeonatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaDeCampeonatos.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblConsultaDeCampeonatos.setBounds(10, 26, 572, 36);
		contentPane.add(lblConsultaDeCampeonatos);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(43, 96, 91, 14);
		contentPane.add(lblNombre);
		
		txtFiltro = new JTextField();
		txtFiltro.setBounds(158, 93, 391, 20);
		contentPane.add(txtFiltro);
		txtFiltro.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 147, 506, 220);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nombre", "A\u00F1o"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(234);
		table.getColumnModel().getColumn(2).setPreferredWidth(110);
		scrollPane.setViewportView(table);
	}


}










