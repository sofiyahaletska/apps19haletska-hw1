package ua.edu.ucu.tempseries;


import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {

    public double[] temperatureSeries;
    private final int maxTemp = -273;
    public TemperatureSeriesAnalysis() {

    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.temperatureSeries = temperatureSeries;
        for (int i = 0; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] < maxTemp) {
                throw new InputMismatchException();
            }
        }
    }

    public double average() {
        if (temperatureSeries.length > 0) {
            double sum = 0;
            for (int i = 0; i < temperatureSeries.length; i++) {
                sum += temperatureSeries[i];
            }
            return sum / temperatureSeries.length;
        }
        throw new IllegalArgumentException();
    }

    public double deviation() {
        if (temperatureSeries.length > 0) {
            double sum = 0;
            double[]array = temperatureSeries;
            double aveL = average();
            for (int i = 0; i < array.length; i++) {
                sum += (array[i] - aveL)*(array[i] - aveL);
            }
            return Math.sqrt(sum/temperatureSeries.length);
        }
        throw new IllegalArgumentException();

    }

    public double min() {
        if (temperatureSeries.length > 0) {
            double minT = temperatureSeries[0];
            for (int i = 0; i < temperatureSeries.length; i++) {
                if (temperatureSeries[i] < minT) {
                    minT = temperatureSeries[i];
                }
            }
            return minT;
        }
        throw new IllegalArgumentException();

    }

    public double max() {
        if (temperatureSeries.length > 0) {
            double maxT = temperatureSeries[0];
            for (int i = 0; i < temperatureSeries.length; i++) {
                if (temperatureSeries[i] > maxT) {
                    maxT = temperatureSeries[i];
                }
            }
            return maxT;
        }
        throw new IllegalArgumentException();

    }

    public double findTempClosestToZero() {
        if (temperatureSeries.length > 0) {
            return findTempClosestToValue(0);
        }
        throw new IllegalArgumentException();
    }


    public double findTempClosestToValue(double tempValue) {
        if (temperatureSeries.length > 0) {
            double minD = Math.abs(temperatureSeries[0] - tempValue);
            double value = temperatureSeries[0];
            for (int i = 1; i < temperatureSeries.length; i++) {
                if (Math.abs(temperatureSeries[i] - tempValue) <= minD) {
                    minD = Math.abs(temperatureSeries[i] - tempValue);
                    value = temperatureSeries[i];
                }
            }
            return value;
        }
        throw new IllegalArgumentException();
    }

    public double[] findTempsLessThen(double tempValue) {
        double[] tempslessL = new double[temperatureSeries.length];
        int j = 0;
        for (int i = 0; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] < tempValue) {
                tempslessL[j] = temperatureSeries[i];
                j++;
            }
        }
        return tempslessL;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        double[] tempsgreaterL = new double[temperatureSeries.length];
        int j = 0;
        for (int i = 0; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] >= tempValue) {
                tempsgreaterL[j] = temperatureSeries[i];
                j++;
            }
        }
        return tempsgreaterL;
    }

    public TempSummaryStatistics summaryStatistics() {
        if (temperatureSeries.length > 0) {
            return new TempSummaryStatistics(temperatureSeries);
        }
        throw new IllegalArgumentException();
    }
    public int addTemps(double... temps) {
        double[] newArr;
        if (temperatureSeries[temperatureSeries.length-temps.length] != 0.0) {
            newArr = new double[temperatureSeries.length*2];
        }
        else {
            newArr = new double[temperatureSeries.length];
        }
        int j = 0;
        int sum = 0;
        for (int i = 0; i < temperatureSeries.length; i++) {
            newArr[j] = temperatureSeries[i];
            if (temperatureSeries[i] != 0.0) {
                j++;
            }
            sum += temperatureSeries[i];
        }
        for (int i = 0; i < temps.length; i++) {
            newArr[j] = temps[i];
            j++;
            sum += temps[i];
        }
        this.temperatureSeries = newArr;
        return sum;
    }

}
