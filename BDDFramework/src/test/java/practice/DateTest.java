package practice;

import util.WebDriverUtil;

public class DateTest {
	public static void main(String[] args) {
		String date = new WebDriverUtil().sysDate();
		System.out.println(date);
	}

}
