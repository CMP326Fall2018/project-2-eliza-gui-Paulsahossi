package eliza_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Eliza_Gui extends JFrame implements ActionListener{
	private int QuestionsCounter = 0;
	private int SessionCounter = 0;
	private Question_Bank qb = new Question_Bank();
	private Text_File_Handler tfHandler = new Text_File_Handler();
	private JButton jbStartSession, jbNextQuestion, jbFinishSession, jbViewAllQA,
	jbViewLonguestWords, jbViewLonguestWordsAlpha;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JTextField jTextField;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private Font font = new Font("SansCherif",12,12);
	
	
	
	private static final int GUI_WIDTH = 600;	
	private static final int GUI_HEIGHT = 600;
	private static final int NUM_COLS_TEXT_AREA = GUI_WIDTH/12;
	private static final int NUM_ROWS_TEXT_AREA = GUI_HEIGHT/30;
	private static final String ACTION_COMMAND_Start_Session = "Start Session";
	private static final String ACTION_COMMAND_Finish_Session = "Finish Session";
	private static final String ACTION_COMMAND_Next_Question = "Next Question";
	private static final String ACTION_COMMAND_View_All_QA = "View all Q & A";
	private static final String ACTION_COMMAND_View_Longuest_Words = "View Longuest Words";
	private static final String ACTION_COMMAND_View_Longuest_Words_Alpha = "View Longuest Words Alphabetically";
	
	
	public Eliza_Gui(){
		JPanel mainJP = new JPanel();
//		mainJP.setBackground(Color.LIGHT_GRAY );
		jbStartSession = new JButton(ACTION_COMMAND_Start_Session);//can do the same for others to avoid typo problems
		jbFinishSession = new JButton(ACTION_COMMAND_Finish_Session);
		jbNextQuestion = new JButton (ACTION_COMMAND_Next_Question );
		jbViewAllQA = new JButton(ACTION_COMMAND_View_All_QA);
		jbViewLonguestWords = new JButton(ACTION_COMMAND_View_Longuest_Words);
		jbViewLonguestWordsAlpha = new JButton(ACTION_COMMAND_View_Longuest_Words_Alpha);
		
		jbStartSession.addActionListener(this);
		jbNextQuestion.addActionListener(this);
		jbFinishSession.addActionListener(this);
		jbViewAllQA.addActionListener(this);
		jbViewLonguestWords.addActionListener(this);
		jbViewLonguestWordsAlpha.addActionListener(this);
		
		jbStartSession.setFont(font);
		jbNextQuestion.setFont(font);
		jbFinishSession.setFont(font);
		jbViewAllQA.setFont(font);
		jbViewLonguestWords.setFont(font);
		jbViewLonguestWordsAlpha.setFont(font);
		
		textArea = new JTextArea(20, 49);
		textArea = new JTextArea(20, 49);
		scrollPane = new JScrollPane(textArea);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jTextField = new JTextField(45);
		jLabel1 = new JLabel();	
		jLabel1.setText("Welcome to the Eliza therapy session. Please 'Start Session' to begin");
		jLabel2 = new JLabel();
//		jLabel.setSize(GUI_WIDTH, NUM_COLS_TEXT_AREA);
//		jLabel.setBackground(Color.BLACK);
		jLabel1.setFont(font);
		jLabel2.setFont(font);
//		jLabel2.setHorizontalAlignment(20);
		jTextField.setFont(font);
		
		
		mainJP.add(jLabel1);
		mainJP.add(jLabel2);
		mainJP.add(jTextField);
		mainJP.add(jbStartSession);
		mainJP.add(jbNextQuestion);
		mainJP.add(jbFinishSession);
		mainJP.add(jbViewAllQA);
		mainJP.add(jbViewLonguestWords);
		mainJP.add(jbViewLonguestWordsAlpha);
		mainJP.add(scrollPane);
		add(mainJP);
		
		jbNextQuestion.setVisible(false);
		jbFinishSession.setVisible(false);
		jbViewAllQA.setVisible(false);
		jbViewLonguestWords.setVisible(false);
		jbViewLonguestWordsAlpha.setVisible(false);
		scrollPane.setVisible(false);
		jTextField.setVisible(false);
		
		setSize(GUI_WIDTH, GUI_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		tfHandler = new Text_File_Handler();
		tfHandler.createNewFile("SessionsFile");
		tfHandler.createNewFile("AnswersFile");
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	String btnFace = e.getActionCommand();
			//		e.getSource();
	switch(btnFace){
		case ACTION_COMMAND_Start_Session:
			QuestionsCounter++;
			SessionCounter++;
			jLabel1.setText("Session#" +SessionCounter+ " Q" +QuestionsCounter+ ": "+ qb.getNextQuestion());
			jLabel2.setText(" Answer: ");
			jTextField.setVisible(true);
			jbNextQuestion.setVisible(true);
			jbStartSession.setVisible(false);
			jTextField.setEditable(true);
			break;
			
		case ACTION_COMMAND_Next_Question:
			tfHandler.appendToFile("SessionsFile", jLabel1.getText() +  "\n\t"+ jLabel2.getText() + jTextField.getText() + "\n");
			tfHandler.appendToFile("AnswersFile", jTextField.getText());
			QuestionsCounter++;
			jLabel1.setText("Session#" +SessionCounter+ " Q" +QuestionsCounter+ ": "+ qb.getNextQuestion());
			jLabel2.setText(" Answer: ");
			jTextField.setText("");
//			jTextField.requestFocus();
			if (QuestionsCounter == Question_Bank.NUM_QUESTIONS) {
				jbNextQuestion.setVisible(false);
				jbFinishSession.setVisible(true);
				
			}
		break;
		
		case ACTION_COMMAND_Finish_Session:
			jTextField.setEditable(false);
			tfHandler.appendToFile("SessionsFile", jLabel1.getText() + "\n\t"+ jLabel2.getText()+ jTextField.getText() + "\n");
			tfHandler.appendToFile("AnswersFile", jTextField.getText());
			jTextField.setText("");
			QuestionsCounter = 0;
			int SessionNum = SessionCounter+1;
			jbViewAllQA.setVisible(true);
			jbViewLonguestWords.setVisible(true);
			jbViewLonguestWordsAlpha.setVisible(true);
			scrollPane.setVisible(true);
			textArea.setEditable(false);
			jbFinishSession.setVisible(false);
			jbStartSession.setVisible(true);
			jLabel1.setText("Press 'Start Session' to begin session#"+ SessionNum);
			JOptionPane.showConfirmDialog (null, "Wowww "+ "'" + tfHandler.longestWords("AnswersFile") + "'" + " and " +"'" +tfHandler.ShortesWords("AnswersFile") 
			+ "'" + " seem very important to you!", "Observation",JOptionPane.DEFAULT_OPTION);
			break;
			
		case ACTION_COMMAND_View_All_QA:
			textArea.setText(tfHandler.readFile("SessionsFile"));
			break;
			
		case ACTION_COMMAND_View_Longuest_Words :
		textArea.setText(tfHandler.readDelimetedFile("AnswersFile"," "));
			
			break;
			
		case ACTION_COMMAND_View_Longuest_Words_Alpha:
			textArea.setText(tfHandler.alphaSort("AnswersFile"," "));
			break;

	
	}
		
	}
	

}
	
	

