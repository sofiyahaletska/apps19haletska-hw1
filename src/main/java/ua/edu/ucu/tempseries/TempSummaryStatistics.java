package ua.edu.ucu.tempseries;


public class TempSummaryStatistics {
    private final double avgTemp;
    private final double devTemp;
    private final double minTemp;
    private final double maxTemp;

    TempSummaryStatistics(double[] temperatureSeries) {
        final TemperatureSeriesAnalysis ARR_TEMPERATURE = new TemperatureSeriesAnalysis(temperatureSeries);
        this.avgTemp = ARR_TEMPERATURE.average();
        this.devTemp = ARR_TEMPERATURE.deviation();
        this.minTemp = ARR_TEMPERATURE.min();
        this.maxTemp = ARR_TEMPERATURE.max();
    }
    public double getAvgTemp() {
        return avgTemp;
    }
    public double getDevTemp() {
        return devTemp;
    }
    public double getMinTemp() {
        return minTemp;
    }
    public double getMaxTemp() {
        return maxTemp;
    }
    
}
