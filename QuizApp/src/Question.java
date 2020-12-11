
public class Question {
	private String question; 
	private String a;
	private String b;
	private String c; 
	private String d; 
	private String answer; 
	
	public String getQuestion() { //getter for question
		return question; 
	}
	
	public void setQuestion(String question) { //setter for question 
		this.question = question; 
	}
	
	public String getA() { // getter for a
		return a; 
	}
	
	public void setA(String a) { //setter for a 
		this.a = a; 
	}
	
	public String getB() { //getter for b
		return b; 
	}
	
	public void setB(String b) { //setter for b
		this.b = b; 
	}
	
	public String getC() { //getter for c
		return c; 
	}
	
	public void setC(String c) { //setter for c
		this.c = c; 
	}
	
	public String getD() { //getter for d
		return d; 
	}
	
	public void setD(String d) { // setter for d
		this.d = d; 
	}
	
	public String getAnswer() { //getter for answer 
		return answer; 
	}
	
	public void setAnswer(String answer) {  // setter for answer 
		this.answer = answer; 
	}
	
	public Question(String question, String a, String b, String c, String d, String answer) { // question constructor 
		setQuestion(question); 
		setA(a); 
		setB(b); 
		setC(c); 
		setD(d); 
		setAnswer(answer); 
}
	
	@Override
	public String toString() {
		return String.format("%s\nA. %s\nB. %s\nC. %s\nD. %s\n",question,a,b,c,d); // turn to string 
	}
}
