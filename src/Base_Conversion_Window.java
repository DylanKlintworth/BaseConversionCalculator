//Project by Dylan Klintworth, Base Conversion Calculator
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Base_Conversion_Window extends JFrame {

	private JPanel contentPane; //create pane.
	private JTextField textFieldBase; //create textfield for base entry.
	private JTextField textFieldNumber; //create textfield for number entry.

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Base_Conversion_Window frame = new Base_Conversion_Window();
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
	public Base_Conversion_Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		BaseTen baseTen = new BaseTen(); //default constructor for base ten object.
		BaseEight baseEight = new BaseEight(); //default constructor for base eight object.
		BaseTwo baseTwo = new BaseTwo(); //default constructor for base two object.
		BaseSixteen baseSixteen = new BaseSixteen();//default constructor for base sixteen object.
		ConversionRegistry registry = new ConversionRegistry(); //Initialize the registry.
		
		JLabel lblEnterInitialBase = new JLabel("Enter Initial Base:");
		lblEnterInitialBase.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		GridBagConstraints gbc_lblEnterInitialBase = new GridBagConstraints();
		gbc_lblEnterInitialBase.anchor = GridBagConstraints.EAST;
		gbc_lblEnterInitialBase.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterInitialBase.gridx = 0;
		gbc_lblEnterInitialBase.gridy = 0;
		contentPane.add(lblEnterInitialBase, gbc_lblEnterInitialBase);
		
		textFieldBase = new JTextField();
		textFieldBase.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		GridBagConstraints gbc_textFieldBase = new GridBagConstraints();
		gbc_textFieldBase.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldBase.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldBase.gridx = 1;
		gbc_textFieldBase.gridy = 0;
		contentPane.add(textFieldBase, gbc_textFieldBase);
		textFieldBase.setColumns(10);
		
		JLabel lblEnterNumber = new JLabel("Enter number:");
		lblEnterNumber.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		GridBagConstraints gbc_lblEnterNumber = new GridBagConstraints();
		gbc_lblEnterNumber.anchor = GridBagConstraints.EAST;
		gbc_lblEnterNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterNumber.gridx = 0;
		gbc_lblEnterNumber.gridy = 1;
		contentPane.add(lblEnterNumber, gbc_lblEnterNumber);
		
		textFieldNumber = new JTextField();
		textFieldNumber.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		GridBagConstraints gbc_textFieldNumber = new GridBagConstraints();
		gbc_textFieldNumber.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNumber.gridx = 1;
		gbc_textFieldNumber.gridy = 1;
		contentPane.add(textFieldNumber, gbc_textFieldNumber);
		textFieldNumber.setColumns(10);
		
		JLabel lblBaseTen = new JLabel("Base 10:");
		lblBaseTen.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		GridBagConstraints gbc_lblBaseTen = new GridBagConstraints();
		gbc_lblBaseTen.insets = new Insets(0, 0, 5, 5);
		gbc_lblBaseTen.gridx = 0;
		gbc_lblBaseTen.gridy = 3;
		contentPane.add(lblBaseTen, gbc_lblBaseTen);
		
		JLabel lblBaseTenAnswer = new JLabel("");
		lblBaseTenAnswer.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		GridBagConstraints gbc_lblBaseTenAnswer = new GridBagConstraints();
		gbc_lblBaseTenAnswer.insets = new Insets(0, 0, 5, 0);
		gbc_lblBaseTenAnswer.gridx = 1;
		gbc_lblBaseTenAnswer.gridy = 3;
		contentPane.add(lblBaseTenAnswer, gbc_lblBaseTenAnswer);
		
		JLabel lblBaseSixteen = new JLabel("Base 16:");
		lblBaseSixteen.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		GridBagConstraints gbc_lblBaseSixteen = new GridBagConstraints();
		gbc_lblBaseSixteen.insets = new Insets(0, 0, 5, 5);
		gbc_lblBaseSixteen.gridx = 0;
		gbc_lblBaseSixteen.gridy = 4;
		contentPane.add(lblBaseSixteen, gbc_lblBaseSixteen);
		
		JLabel lblBaseSixteenAnswer = new JLabel("");
		lblBaseSixteenAnswer.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		GridBagConstraints gbc_lblBaseSixteenAnswer = new GridBagConstraints();
		gbc_lblBaseSixteenAnswer.insets = new Insets(0, 0, 5, 0);
		gbc_lblBaseSixteenAnswer.gridx = 1;
		gbc_lblBaseSixteenAnswer.gridy = 4;
		contentPane.add(lblBaseSixteenAnswer, gbc_lblBaseSixteenAnswer);
		
		JLabel lblBaseEight = new JLabel("Base 8:");
		lblBaseEight.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		GridBagConstraints gbc_lblBaseEight = new GridBagConstraints();
		gbc_lblBaseEight.insets = new Insets(0, 0, 5, 5);
		gbc_lblBaseEight.gridx = 0;
		gbc_lblBaseEight.gridy = 5;
		contentPane.add(lblBaseEight, gbc_lblBaseEight);
		
		JLabel lblBaseEightAnswer = new JLabel("");
		lblBaseEightAnswer.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		GridBagConstraints gbc_lblBaseEightAnswer = new GridBagConstraints();
		gbc_lblBaseEightAnswer.insets = new Insets(0, 0, 5, 0);
		gbc_lblBaseEightAnswer.gridx = 1;
		gbc_lblBaseEightAnswer.gridy = 5;
		contentPane.add(lblBaseEightAnswer, gbc_lblBaseEightAnswer);
		
		JLabel lblBaseTwo = new JLabel("Base 2:");
		lblBaseTwo.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		GridBagConstraints gbc_lblBaseTwo = new GridBagConstraints();
		gbc_lblBaseTwo.insets = new Insets(0, 0, 5, 5);
		gbc_lblBaseTwo.gridx = 0;
		gbc_lblBaseTwo.gridy = 6;
		contentPane.add(lblBaseTwo, gbc_lblBaseTwo);
		
		JLabel lblBaseTwoAnswer = new JLabel("");
		lblBaseTwoAnswer.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		GridBagConstraints gbc_lblBaseTwoAnswer = new GridBagConstraints();
		gbc_lblBaseTwoAnswer.insets = new Insets(0, 0, 5, 0);
		gbc_lblBaseTwoAnswer.gridx = 1;
		gbc_lblBaseTwoAnswer.gridy = 6;
		contentPane.add(lblBaseTwoAnswer, gbc_lblBaseTwoAnswer);
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { //if convert button is clicked, number is converted.
				if(textFieldBase.getText().equals(Integer.toString(2))) { //retrieves base from text field and uses base two methods accordingly.
					baseTwo.setBaseTwo(textFieldNumber.getText()); //sets BaseTwo object's number.
					lblBaseTenAnswer.setText(baseTwo.toBaseTen()); //presents conversion for all bases.
					lblBaseEightAnswer.setText(baseTwo.toBaseEight()); //presents conversion for all bases.
					lblBaseTwoAnswer.setText(baseTwo.toString());//presents conversion for all bases.
					lblBaseSixteenAnswer.setText(baseTwo.toBaseSixteen());//presents conversion for all bases.
					registry.addNumber(baseTwo); //adds conversions to registry.
				}else if(textFieldBase.getText().equals(Integer.toString(10))){ //retrieves base from text field and uses base ten methods accordingly.
					baseTen.setBaseTen(textFieldNumber.getText()); //sets BaseTen object's number.
					lblBaseTenAnswer.setText(baseTen.toString());//presents conversion for all bases.
					lblBaseTwoAnswer.setText(baseTen.toBaseTwo());//presents conversion for all bases.
					lblBaseEightAnswer.setText(baseTen.toBaseEight());//presents conversion for all bases.
					lblBaseSixteenAnswer.setText(baseTen.toBaseSixteen());//presents conversion for all bases.
					registry.addNumber(baseTen);//adds conversions to registry.
				}else if(textFieldBase.getText().equals(Integer.toString(8))) { //retrieves base from text field and uses base eight methods accordingly.
					baseEight.setBaseEight(textFieldNumber.getText()); //sets BaseEight object's number.
					lblBaseTenAnswer.setText(baseEight.toBaseTen());//presents conversion for all bases.
					lblBaseTwoAnswer.setText(baseEight.toBaseTwo());//presents conversion for all bases.
					lblBaseEightAnswer.setText(baseEight.toString());//presents conversion for all bases.
					lblBaseSixteenAnswer.setText(baseEight.toBaseSixteen());//presents conversion for all bases.
					registry.addNumber(baseEight); //adds conversions to registry.
				}else if(textFieldBase.getText().equals(Integer.toString(16))) { // //retrieves base from text field and uses base sixteen methods accordingly.
					baseSixteen.setBaseSixteen(textFieldNumber.getText()); //sets BaseSixteen object's number.
					lblBaseTenAnswer.setText(baseSixteen.toBaseTen());//presents conversion for all bases.
					lblBaseTwoAnswer.setText(baseSixteen.toBaseTwo());//presents conversion for all bases.
					lblBaseEightAnswer.setText(baseSixteen.toBaseEight());//presents conversion for all bases.
					lblBaseSixteenAnswer.setText(baseSixteen.toString());//presents conversion for all bases.
					registry.addNumber(baseSixteen); //adds conversions to registry.
				}else { //if user inputs invalid base then window prompts them to input a valid base.
					textFieldBase.setText("Input valid base: 2, 8, 10, 16");
					textFieldNumber.setText("Invalid base.");
					lblBaseTenAnswer.setText("Invalid base.");
					lblBaseTwoAnswer.setText("Invalid base.");
					lblBaseEightAnswer.setText("Invalid base.");
					lblBaseSixteenAnswer.setText("Invalid base.");
				}
				
			}
		});
		btnConvert.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		GridBagConstraints gbc_btnConvert = new GridBagConstraints();
		gbc_btnConvert.fill = GridBagConstraints.BOTH;
		gbc_btnConvert.insets = new Insets(0, 0, 5, 5);
		gbc_btnConvert.gridx = 0;
		gbc_btnConvert.gridy = 2;
		contentPane.add(btnConvert, gbc_btnConvert);
		
		JButton btnRegistry = new JButton("Registry"); //button to print registry.
		btnRegistry.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) { //if button is clicked it prints registry to console.
				System.out.println("Full List:");
				registry.printNumberList();
			}
		});
		GridBagConstraints gbc_btnRegistry = new GridBagConstraints();
		gbc_btnRegistry.insets = new Insets(0, 0, 0, 5);
		gbc_btnRegistry.gridx = 0;
		gbc_btnRegistry.gridy = 8;
		contentPane.add(btnRegistry, gbc_btnRegistry);
		
	}

}
