/*
 * We are given a specific time(like 02:23), we need to get the angle 
 * between hour and minute(less than 180)
 */

public class clockAngle {
	public static void main(String[] args) {
		doTests();
	}
	
	public static double angle(String time) {
		
		double hour = Double.parseDouble(time.substring(0, 2));
		double min = Double.parseDouble(time.substring(3,5));
		// one hour is 30 degree
		// one min is 6 degree
		// when a min passes, the handle of hour also moves 0.5 degree
		double angle = Math.abs(hour * 30 + min * 0.5 - min * 6);
		return angle > 180 ? angle - 180 : angle;
	}
	
	public static void doTests() {
		String time = "02:33";
		System.out.println(angle(time));
	}
}
