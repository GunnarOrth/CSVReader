package csvhelper;

import java.io.IOException;

public class StudentCsvReader extends CSVReader{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8745287651939746157L;
	private static final String STUDENT_NAME = "StudentGrade";
	private static final String QUIZ_GRADE = "QuizGrade";
	private static final String TEST_GRADE = "TestGrade";
	private static final String HOMEWORK_GRADE = "HomeworkGrade";
	private static final String PROJECT_GRADE = "ProjectGrade";
	private static final int EXPECTED_NUM_COLUMNS = 5;
	//private int minimum;
	
	public StudentCsvReader(String CSVfile) {
		super(CSVfile);
		// TODO Auto-generated constructor stub
	}

	public boolean checkCSV() {
		// TODO Auto-generated method stub
		
		boolean check = false;
		
		 try {
	         	line = reader.readLine();
	         	System.out.println(line);
	         	String[] row = line.split(",");
	         	
	         	boolean studentNameExists = false;
	    		boolean quizGradeExists = false;
	    		boolean testGradeExists = false;
	    		boolean homeworkGradeExists = false;
	    		boolean projectGradeExists = false;
	    		for(int i = 0; i < row.length; i++) {
	    			switch (row[i]) {
	    			case STUDENT_NAME:
	    				studentNameExists = true;
	    				break;
	    			case QUIZ_GRADE:
	    				quizGradeExists = true;
	    				break;
	    			case TEST_GRADE:
	    				testGradeExists = true;
	    				break;
	    			case HOMEWORK_GRADE:
	    				homeworkGradeExists = true;
	    				break;
	    			case PROJECT_GRADE:
	    				projectGradeExists = true;
	    				break;
	    			default:
	    				break;
	    			}
	    					
	    		}
	    		check = studentNameExists && quizGradeExists && testGradeExists && homeworkGradeExists && projectGradeExists&&(row.length == EXPECTED_NUM_COLUMNS);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 
		 return check;
	}

}
