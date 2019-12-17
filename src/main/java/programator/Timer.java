package programator;

public class Timer {

    public static String timeTaken(long startTime, long endTime) {
        long minute = (endTime - startTime) / 1000 / 60;
        long seconds = (endTime - startTime) / 1000 - (minute * 60);
        long millis = (endTime - startTime) - (seconds * 1000) - (minute * 1000 * 60);
        return  minute + "min. " + seconds + "sec. " + millis + "ms.";
    }
}
