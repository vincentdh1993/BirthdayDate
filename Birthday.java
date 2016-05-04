import java.util.Scanner;

public class Birthday {
	public static void main (String[] args){
		Scanner console = new Scanner(System.in);
		System.out.println("What month, day, and year were you born? "); //ask user to input their birthday date.
		int month = console.nextInt();
		int day = console.nextInt();
		int year = console.nextInt();
		
		TeacherDate date = new TeacherDate(year,month,day); //represent specific date.
		TeacherDate today = new TeacherDate(); //represent today.
		
		System.out.println("You were born on "+date.toString()+", which was a "+date.getDayOfWeek()+".");
		if(date.isLeapYear()){ //if the date is on leap year,
			System.out.println(year+" was a leap year.");
		}
		if(date.getDay()==today.getDay() && date.getMonth()==today.getMonth()){
			System.out.println("Happy Birthday!!!!!! You are now age "+howoldY(date, today)+".");
		} else{
		System.out.println("Sadly, it is not your birthday. It will be your birthday in "+countdays(date, today)+" days.");
		}
		System.out.println("You are "+howoldD(date, today)+" days old.");
		
	}//main gwalho
	
	public static int countdays(TeacherDate date, TeacherDate today){ // method that counts until the birthday.
		int days = 0;
		TeacherDate todays = new TeacherDate(); // create a temporary todays class to prevent touching original today class.
		while(todays.getDay() != date.getDay() || todays.getMonth() != date.getMonth()){//While the date is not same,
			days++; //add the days until your birthday.
			todays.nextDay();
		}
		return days; //return days.
	}
	
	public static int howoldD(TeacherDate date, TeacherDate today){ //method that counts how old the user is in days.
		int howold = 0;
		TeacherDate temp = new TeacherDate(date.getYear(), date.getMonth(), date.getDay()); //create a temp class also to prevent touching original date class.
		while (!temp.equals(today)) {	//While not reaching the day,
			howold++; //keep adding
			temp.nextDay();
		}
		return howold; //return how old is the user.
	}
	
	public static int howoldY(TeacherDate date, TeacherDate today){ //method that calculates how year old is user.
		int x = today.getYear(); //today's year
		int y = date.getYear(); //user's birthday year.
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+x+" "+y);
		return x-y; //returning while calculating to reduce the redundancy.
	}
	
	
	
	
}//class gwalho
