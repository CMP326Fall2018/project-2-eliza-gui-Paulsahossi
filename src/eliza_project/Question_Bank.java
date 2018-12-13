package eliza_project;

import java.util.Random;

public class Question_Bank {

	private String [] questions;
	private int currQuestionIndex;
	public static final int NUM_QUESTIONS = 20; 
	
	public Question_Bank(){
		questions = new String [NUM_QUESTIONS];
		populateQuestionArray();
	}
	
	
	private void populateQuestionArray(){
		questions[0]= "Which three words describe you best?";
		questions[1]= "Which is your best feature?";
		questions[2]= "Which common saying or phrase describes you?";
		questions[3]= "What’s the best thing that’s happened to you this week?";
		questions[4]= "Who was your role model when you were a child?";
		questions[5]= "Who was your favorite teacher and why?";
		questions[6]= "What was your favorite subject at school?";
		questions[7]= "What did you want to be when you grew up?";
		questions[8]= "If you could have one wish come true what would it be?";
		questions[9]= "Which would you prefer — three wishes over five years or one wish right now?";
		questions[10]= "What piece of technology brings you the most joy?";
		questions[11]= "What animal best represents your personality?";
		questions[12]= "What did you think you were good at but are actually quite bad at?";
		questions[13]= "Who is a better cook your mother or grandmother?";
		questions[14]= "Is there an app that you hate but use anyways?";
		questions[15]= "What looks delicious but tastes terrible?";
		questions[16]= "What was the funniest way that you have been injured?";
		questions[17]= "What would be the coolest animal to scale up to the size of a horse?";
		questions[18]= "What would be the absolute worst name you could give your child?";
		questions[19]= "How do you feel about putting pineapple on pizza?";
	}
	
	public String getNextQuestion() {
		
		currQuestionIndex = (int) (Math.random() * NUM_QUESTIONS);
		return questions[currQuestionIndex];
	}

}

