package typing_app.utility;

public class StopWatch {

    private static long start = 0;

    /**
     * Starts measuring processing time
     */
    public static void start() {
        start = System.nanoTime();
    }

    /**
     * Get elapsed microseconds since the start of measurement
     *
     * @return Elapsed time
     */
    public static long microTime() {
        return (System.nanoTime() - start) / 1000;
    }

    /**
     * Get elapsed milliseconds since the start of measurement
     *
     * @return Elapsed time
     */
    public static long milliTime() {
        return (System.nanoTime() - start) / 1000000;
    }

    /**
     * Get elapsed seconds since the start of measurement
     *
     * @return Elapsed time
     */
    public static long secondTime() {
        return (System.nanoTime() - start) / 1000000000;
    }
}