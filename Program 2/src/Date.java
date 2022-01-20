import java.lang.String;

//this class formats the date
public class Date{
    String month;
    String day;
    String year;

    public String Date(String str)
    {
        String delimiter = new String();

        //if the date is separated by "-", string is separated by "-" and assign year, month and day
        if (str.indexOf('-') >= 0)
        {
            String[] ymd = str.split("-");
            year = ymd[0];
            month = ymd[1];
            day = ymd[2];
        }

        //if the date is separated by "/", string is separated by "/" and assign year, month and day
        else
        {
            String[] mdy = str.split("/");
            year = mdy[2];
            month = mdy[0];
            day = mdy[1];
        }

        //put the year month and day together and return the string
        String date = year+"/"+month+"/"+day;
        return date;
    }
}
