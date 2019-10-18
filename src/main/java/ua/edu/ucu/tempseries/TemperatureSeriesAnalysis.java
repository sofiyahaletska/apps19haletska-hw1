package ua.edu.ucu.tempseries;


import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {

    public double[] temperatureSeries;
    public TemperatureSeriesAnalysis() {

    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.temperatureSeries = temperatureSeries;
        for (int i = 0; i < temperatureSeries.length; i++) {
            if(temperatureSeries[i] < -273){
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
            double average_of_l = average();
            for (int i = 0; i < temperatureSeries.length; i++) {
                sum += Math.pow(temperatureSeries[i] - average_of_l, 2);
            }
            return Math.sqrt(sum/temperatureSeries.length);
        }
        throw new IllegalArgumentException();

    }

    public double min() {
        if (temperatureSeries.length > 0) {
            double min_t = temperatureSeries[0];
            for (int i = 0; i < temperatureSeries.length; i++) {
                if(temperatureSeries[i]< min_t) {
                    min_t = temperatureSeries[i];
                }
            }
            return min_t;
        }
        throw new IllegalArgumentException();

    }

    public double max() {
        if (temperatureSeries.length > 0) {
            double max_t = temperatureSeries[0];
            for (int i = 0; i < temperatureSeries.length; i++) {
                if(temperatureSeries[i] > max_t) {
                    max_t = temperatureSeries[i];
                }
            }
            return max_t;
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
            double min_d = Math.abs(temperatureSeries[0] - tempValue);
            double value = temperatureSeries[0];
            for (int i = 1; i < temperatureSeries.length; i++) {
                if (Math.abs(temperatureSeries[i] - tempValue) <= min_d) {
                    min_d = Math.abs(temperatureSeries[i] - tempValue);
                    value = temperatureSeries[i];
                }
            }
            return value;
        }
        throw new IllegalArgumentException();
    }

    public double[] findTempsLessThen(double tempValue) {
        double[] tempsless_list = new double[temperatureSeries.length];
        int j = 0;
        for (int i = 0; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] < tempValue) {
                tempsless_list[j] = temperatureSeries[i];
                j++;
            }
        }
        return tempsless_list;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        double[] tempsgreater_list = new double[temperatureSeries.length];
        int j = 0;
        for (int i = 0; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] >= tempValue) {
                tempsgreater_list[j] = temperatureSeries[i];
                j++;
            }
        }
        return tempsgreater_list;
    }

    public TempSummaryStatistics summaryStatistics() {
        if (temperatureSeries.length > 0) {
            return new TempSummaryStatistics(temperatureSeries);
        }
        throw new IllegalArgumentException();
    }
    public int addTemps(double... temps) {
        double[] new_Arr;
        if (temperatureSeries[temperatureSeries.length-temps.length] != 0.0) {
            new_Arr = new double[temperatureSeries.length*2];
        }
        else {
            new_Arr = new double[temperatureSeries.length];
        }
        int j = 0;
        int sum = 0;
        for (int i = 0; i < temperatureSeries.length; i++) {
            new_Arr[j] = temperatureSeries[i];
            if(temperatureSeries[i] != 0.0) {
                j++;
            }
            sum += temperatureSeries[i];
        }
        for (int i = 0; i < temps.length; i++) {
            new_Arr[j] = temps[i];
            j++;
            sum += temps[i];
        }
        this.temperatureSeries = new_Arr;
        return sum;
    }

}
