package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Ignore;
import java.util.InputMismatchException;
public class TemperatureSeriesAnalysisTest {

    @Test
    public void testTemperatureSeriesAnalysisWithoutTemps() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
    }
    @Test(expected = InputMismatchException.class)
    public void testTemperatureSeriesAnalysis() {
        double[] temperatureSeries = {13.0, 8.1, -273.0, -280.5, 5.8, 4.7};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    }

    public void testAverageWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.average();
        assertEquals(-1.0, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);


        seriesAnalysis.average();
    }


    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.average();
        
        assertEquals(1.0, actualResult, 0.00001);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        seriesAnalysis.deviation();
    }

    @Test
    public void testDeviation() {
        double[] temperatureSeries = {3.0, -3.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.deviation();
        assertEquals(2.958039891549808, actualResult, 0.00001);
    }

    @Test
    public void testMax() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.max();
        assertEquals(5.0, actualResult, 0.00001);
    }

    @Test
    public void testMaxWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.max();
        assertEquals(-1.0, actualResult, 0.00001);
    }

    @Test
    public void testMaxWithEqualElementsArray() {
        double[] temperatureSeries = {1.0, 1.0, 1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.max();
        assertEquals(1.0, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.max();
    }

    @Test
    public void testMin() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.min();
        assertEquals(-5.0, actualResult, 0.00001);
    }

    @Test
    public void testMinWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.min();
        assertEquals(-1.0, actualResult, 0.00001);
    }

    @Test
    public void testMinWithEqualElementsArray() {
        double[] temperatureSeries = {1.0, 1.0, 1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.min();
        assertEquals(1.0, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.min();
    }

    @Test
    public void testfindTempClosestToZeroWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(-1.0, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testfindTempClosestToZeroWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.findTempClosestToZero();
    }

    @Test
    public void testfindTempClosestToZeroEqualElementArray() {
        double[] temperatureSeries = {3.0, 3.0, 3.0, 3.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(3.0, actualResult, 0.00001);
    }

    @Test
    public void testfindTempClosestToZero() {
        double[] temperatureSeries = {30.0, -5.0, 10.0, 1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(1.0, actualResult, 0.00001);
    }

    @Test
    public void testfindTempClosestToZeroPositiveNegative() {
        double[] temperatureSeries = {30.0, -5.0, 10.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(5.0, actualResult, 0.00001);
    }

    @Test
    public void testfindTempClosestToValueWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.findTempClosestToValue(-3.0);
        assertEquals(-1.0, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testfindTempClosestToValueWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.findTempClosestToValue(0.0);
    }

    @Test
    public void testfindTempClosestToValueEqualElementArray() {
        double[] temperatureSeries = {3.0, 3.0, 3.0, 3.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.findTempClosestToValue(-3.0);

        assertEquals(3.0, actualResult, 0.00001);
    }

    @Test
    public void testfindTempClosestToValue() {
        double[] temperatureSeries = {30.0, -5.0, 10.0, 1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.findTempClosestToValue(-3.0);
        assertEquals(-5.0, actualResult, 0.00001);
    }

    @Test
    public void testfindTempClosestToValuePositiveNegative() {
        double[] temperatureSeries = {30.0, -5.0, 10.0, -1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.findTempClosestToValue(-3.0);
        assertEquals(-1.0, actualResult, 0.00001);
    }

    @Test
    public void testfindTempsLessThenWithOneBiggerElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] actualResult = seriesAnalysis.findTempsLessThen(-3.0);
        assertArrayEquals(new double[]{0.0}, actualResult, 0.00001);
    }

    @Test
    public void testfindTempsLessThenWithOneSmallerElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] actualResult = seriesAnalysis.findTempsLessThen(3.0);
        assertArrayEquals(new double[]{-1.0}, actualResult, 0.00001);
    }

    @Test
    public void testfindTempsLessThenWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] actualResult = seriesAnalysis.findTempsLessThen(3.0);
        assertArrayEquals(new double[]{}, actualResult, 0.00001);
    }

    @Test
    public void testfindTempsLessThenEqualBiggerElementArray() {
        double[] temperatureSeries = {3.0, 3.0, 3.0, 3.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] actualResult = seriesAnalysis.findTempsLessThen(-3.0);
        assertArrayEquals(new double[]{0.0, 0.0, 0.0, 0.0}, actualResult, 0.00001);
    }

    @Test
    public void testfindTempsLessThenEqualSmallerElementArray() {
        double[] temperatureSeries = {3.0, 3.0, 3.0, 3.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] actualResult = seriesAnalysis.findTempsLessThen(4.0);
        assertArrayEquals(new double[]{3.0, 3.0, 3.0, 3.0}, actualResult, 0.00001);
    }

    @Test
    public void testfindTempsLessThen() {
        double[] temperatureSeries = {30.0, -5.0, 10.0, 1.0, 4.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] actualResult = seriesAnalysis.findTempsLessThen(4.0);
        assertArrayEquals(new double[]{-5.0, 1.0, 0.0, 0.0, 0.0}, actualResult, 0.00001);
    }

    @Test
    public void testfindTempsGreaterThenWithOneBiggerElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(-3.0);
        assertArrayEquals(new double[]{-1.0} , actualResult, 0.00001);
    }

    @Test
    public void testfindTempsGreaterThenWithOneSmallerElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(3.0);
        assertArrayEquals(new double[]{0.0}, actualResult, 0.00001);
    }

    @Test
    public void testfindTempsGreaterThenThenWithEmptyArray() {

        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(3.0);
        assertArrayEquals(new double[]{}, actualResult, 0.00001);
    }

    @Test
    public void testfindTempsGreaterThenEqualBiggerElementArray() {
        double[] temperatureSeries = {1.0, 2.0, 3.0, 3.5};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(-3.0);
        assertArrayEquals(new double[]{1.0, 2.0, 3.0, 3.5}, actualResult, 0.00001);
    }

    @Test
    public void testfindTempsGreaterThenEqualSmallerElementArray() {
        double[] temperatureSeries = {1.0, 2.0, 3.0, 3.5};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(4.0);
        assertArrayEquals(new double[]{0.0, 0.0, 0.0, 0.0}, actualResult, 0.00001);
    }

    @Test
    public void testfindTempsGreaterThen() {
        double[] temperatureSeries = {13.0, -5.0, 4.0, 5.0, 10.0, 9.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(5.0);
        assertArrayEquals(new double[]{13.0, 5.0, 10.0, 9.0, 0.0, 0.0}, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testsummaryStatisticsWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.summaryStatistics();
    }


    @Test
    public void testsummaryStatistics() {
        double[] temperatureSeries = {-1.0, 6.0, -5.0, 27.0, 4.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        TempSummaryStatistics stats = seriesAnalysis.summaryStatistics();
        double actualResultAv = stats.getAvgTemp();
        double actualResultD = stats.getDevTemp();
        double actualResultMax = stats.getMaxTemp();
        double actualResultMin = stats.getMinTemp();
        assertEquals(6.0, actualResultAv, 0.00001);
        assertEquals(10.132456102380443, actualResultD, 0.00001);
        assertEquals(27.0, actualResultMax, 0.00001);
        assertEquals(-5.0, actualResultMin, 0.00001);
    }

    @Test
    public void testaddTemps() {
        double[] temperatureSeries = {30.0, -5.0, 10.0, 1.0, 4.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] temps = {3.0, 9.0, 2.0};
        int expResult = 54;
        int actualResult = seriesAnalysis.addTemps(temps);
        assertEquals(10, seriesAnalysis.temperatureSeries.length, 0.00001);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testaddTempsWithoutDoubling() {
        double[] temperatureSeries = {30.0, -5.0, 0.0, 0.0, 0.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] temps = {3.0, 9.0, 2.0};
        int expResult = 39;
        int actualResult = seriesAnalysis.addTemps(temps);
        assertEquals(5, seriesAnalysis.temperatureSeries.length, 0.00001);
        assertEquals(expResult, actualResult, 0.00001);
    }
}