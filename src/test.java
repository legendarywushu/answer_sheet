package cn;

public class test {
	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getQuestion() {
		return question;
	}

	public void setQusetion(String question) {
		this.question = question;
	}

	public String getOptA() {
		return optA;
	}

	public void setOptA(int OptA) {
		this.optA = optA;
	}

	public String getOptB() {
		return optB;
	}

	public void setOptB(String OptB) {
		this.optB = optB;
	}

	public String getOptC() {
		return optC;
	}

	public void setOptC(String OptC) {
		this.optC = optC;
	}
	public String getOptD() {
		return optD;
	}

	public void setOptD(String OptD) {
		this.optD = optD;
	}
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String Answer) {
		this.answer = answer;
	}

	public String tid;
	public String question;
	public String optA;
	public String optB;
	public String optC;
	public String optD;
	public String answer;
	
	
	public test() {
		
	}
	public test(String tid, 
			String question, String optA, 
			String optB, String optC,String optD,String answer) {
		this.tid = tid;
		this.question = question;
		this.optA = optA;
		this.optB = optB;
		this.optC = optC;
		this.optD = optD;
		this.answer = answer;
	}
	public static void main(String[] args) {
		

	}
}
