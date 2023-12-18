package csvhelper;

/**
 * class to keep track of student scores and calculate average
 * has a constructor as well as getters and setters because I'm not sure which I'll use as of now
 */
public class Student {
		
	private int hwGrade;
	private int testGrade;
	private int quizGrade;
	private int projectGrade;
	private String name;
	private double score;
	private String passFail;
	private int min;
	
	//constant variables
	private static final double quizHWWeight = 0.20;
	private static final double testProjectWeight = 0.30;
	
	/**
	 * takes inputs to initialize scores, student names and minimum for student
	 * 
	 */
	public Student(String tempName, int x, int y, int z, int d, int minimum) {
		quizGrade = x;
		hwGrade = y;
		testGrade = z;
		projectGrade = d;
		min = minimum;
		setName(tempName);
		
		setScore(calculatePassFail());
	}
	public void writeHW(int x) {
		hwGrade = x;
	}
	
	public void writeTest(int x) {
		testGrade = x;
	}
	
	public void writeQuiz(int x) {
		quizGrade = x;
	}
	
	public void writeProject(int x) {
		projectGrade = x;
	}
	
	public int getHW() {
		return hwGrade;
	}
	
	public int getTest() {
		return testGrade;
	}
	
	public int getQuiz() {
		return quizGrade;
	}
	
	public int getProject() {
		return projectGrade;
	}
	
	//calculate weighted average
	public double calculatePassFail()
	{
		double wAverage = hwGrade*quizHWWeight+testGrade*testProjectWeight+quizGrade*quizHWWeight+projectGrade*testProjectWeight;
	//decides whether student passes or fails based on Average score and minimum taken in from CSVReader	
		if(wAverage > min)
		{
			passFail = "PASS";
		}
		else {
			passFail = "FAIL";
		}
		return wAverage;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassFail() {
		return passFail;
	}
	
	
	
}
