package csvhelper;

import java.util.ArrayList;

/**
 * report builder used to make a report of a student's name and score in format for the report writer
 */
public class StudentReport {

	
	private ArrayList<Student> studentReportArr = new ArrayList<Student>();
	/**
	 * takes in builder class and copies builders student array to student reports student arraylist
	 * @param builder
	 */
	private StudentReport(ReportBuilder builder) {
		
		studentReportArr = builder.studentArr;
		
	}

	/**
	 * overrides toString function, uses fancy java for loop to increment over array list and append strings to stringbuilder
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(Student i: studentReportArr)
		{
			StringBuilder temp = new StringBuilder("Student: ").append(i.getName()).append("\nPassed: ").append(i.getPassFail())
					.append("\n\n");;
			sb.append(temp);
		}
		return sb.toString();
	}

	/**
	 * report builder class
	 */
	public static class ReportBuilder {

		private ArrayList<Student> studentArr = new ArrayList<Student>();
		private int minimum;
		
		//takes in student and adds to array list
		public ReportBuilder addStudent(Student x)
		{
			this.studentArr.add(x);
			return this;
		}
		
		public ReportBuilder addMin(int x) {
			this.minimum = x;
			return this;
		}
		
		public void buildStudent(ArrayList<String[]> arrayOfLines) {
			for(String[] row: arrayOfLines) {
				//System.out.println(row[0]);
				String name = row[0];
		  
				String quizString = row[1];
				int quiz = Integer.parseInt(quizString);
		    
				String hwString = row[2];
				int hw = Integer.parseInt(hwString);
		    
				String testString = row[3];
				int test = Integer.parseInt(testString);
		    
				String projectString = row[4];
				int project = Integer.parseInt(projectString);
		    
				//create temporary student
				Student temp = new Student(name, quiz, hw, test, project, minimum);
				addStudent(temp);
			}
			// TODO Auto-generated method stub
			
		}
		
		//builds a student report
		public StudentReport build() {
			return new StudentReport(this);
		}
	}
}
