package interviewprep.sidero;

/**
 * Given a month and an integer, return the new month after adding the integer
 */
public class MonthCompute {

    public static void main(String[] args) {

        System.out.println(MonthCompute.getMonth("Nov", 4));
        System.out.println(MonthCompute.getMonth("Nov", 2));
        System.out.println(MonthCompute.getMonth("Dec", 2));
        System.out.println(MonthCompute.getMonth("Dec", 24));
        System.out.println(MonthCompute.getMonth("Jan", 1));
        System.out.println(MonthCompute.getMonth("Feb", 4));
        System.out.println(MonthCompute.getMonth("Feb", 24));
        System.out.println(MonthCompute.getMonth("Feb", 48));
        System.out.println(MonthCompute.getMonth("Mar", 5));
    }

    private static final String[] MONTHS_OF_THE_YEAR = new String[]{
        "Jan",
        "Feb",
        "Mar",
        "Apr",
        "May",
        "Jun",
        "Jul",
        "Aug",
        "Sep",
        "Oct",
        "Nov",
        "Dec"
    };

    //"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"
    public static String getMonth(String month, int interval) {

        int position = -1;
        for(int i = 0; i < MONTHS_OF_THE_YEAR.length; i++) {

            if(MONTHS_OF_THE_YEAR[i].equals(month)) {

                position = i;
                break;
            }
        }

        return MONTHS_OF_THE_YEAR[ (interval + position) % MONTHS_OF_THE_YEAR.length];
    }
}