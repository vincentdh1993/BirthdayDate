import java.util.*;

public class Date { //Constructs a new Date representing the given year, month, and day. 
	int year;
	int month;
	int day;
	
	public Date(int year, int month, int day){ //Constructs a new Date representing the given year, month, and day. 
		this.year = year;
		this.month = month;
		this.day = day;
		
	}
	
	public Date(){ //Constructs a new Date representing today.
		           //The only place where my Date code may refer to TeacherDate. 
		int daysSinceEpoch = (int) ((System.currentTimeMillis()+TimeZone.getDefault().getRawOffset())/1000/60/60/24); //or
		int daysSinceEpoch2 = TeacherDate.getDaysSinceEpoch();
	}
	
	public int getDay(){ //return day.
		return this.day;
	}
	
	public int getMonth(){ //return month.
		return this.month;
	}
	
	public int getYear(){ //return year.
		return this.year;
	}
	
	public String getDayOfWeek(){//object that calculates the day of week.
		
		Date date = new Date(1753, 1, 1); // since 1753,1,1 was monday, 
		                                  //and I may assume that the year parameter value will be greater than or equal to 1753.
		int day = 0; //define the integer day as 0.
		while (!this.equals(date)){ //until equals the date,
			day++; //day increases
			date.nextDay(); //passes to the nextday.
		}
		if (day % 7 == 0) { //figure out the weekday by modifiers of 7.
			return "Monday";
		} else if (day % 7 == 1){
			return "Tuesday";
		} else if (day % 7 == 2){
			return "Wednesday";
		} else if (day % 7 == 3){
			return "Thursday";
		} else if (day % 7 == 4){
			return "Friday";
		} else if (day % 7 == 5){
			return "Saturday";
		} else {
			return "Sunday";
		}		
	}
	
	public boolean isLeapYear(){ //check if the year was a leap year.
		return this.year%4==0 && this.year!=1800 && this.year!=1900; //2000 is not a leap year
	}
	
	public void nextDay(){ //object that passes to the nextDay.
		int [] months = {31,28,31,30,31,30,31,31,30,31,30,31}; //create an array which contains all the ending days of each months.
		if(this.isLeapYear()){ //if the year was leapyear, month FEB should end in 29.
			months[1]=29;
		}
		if(this.day == 31 && this.month ==12){ //if the date is the last day of the year, it goes to next year, 1, 1.
			this.day = 1;
			this.month = 1;
			this.year++;
		}
		if(this.month==1 || this.month==3 || this.month==5 || this.month==7 || this.month==8||this.month == 10 || this.month == 12){ // for 31 ending months.
			if(this.day==31){
				this.month++;
				this.day =1;
			}
		}
		else if(this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11){ //for 30 ending months.
			if(this.day==30){
				this.month++;
				this.day=1;
			}
		}
		else{ //other wise, day just increases.
			day++;
		}
		
		
	}
	public String toString(){ //return the string of user input date.
		return this.year + "/" + this.month + "/" + this.day; 
	}
	
	public boolean equals(Object o){ //boolean object that returns whether the given object is a Date that refers to the same year/month/day as this Date.
		if (o instanceof Date){ //using the "instance of" method.
			Date other = (Date) o;
			return year == other.year && month == other.month && day == other.day; //true. 
		} else { 
			return false; //false.
		}
	}
	
} //class gwalho
