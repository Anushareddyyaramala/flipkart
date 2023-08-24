package GenericUtilities;

import java.util.Date;

public class JavaUtilities {
	public String getSystemDateInFormat()

    {

        Date d = new Date();

        String[] dArr = d.toString().split(" ");

        String date = dArr[2];

        String month = dArr[1];

        String year = dArr[5];

        String time = dArr[3].replace(":", "-");

        String currentDateAndTime = date+" "+month+" "+year+" "+time;

        return currentDateAndTime;

    }
}
