package com.example;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class EPLShootingLinearRegressionPlot extends JPanel {

    private double[] xValues; // Independent variable (e.g., shots)
    private double[] yValues; // Dependent variable (e.g., goals)
    private double slope;
    private double intercept;

    public EPLShootingLinearRegressionPlot(double[] xValues, double[] yValues) {
        this.xValues = xValues;
        this.yValues = yValues;
        fit();
    }

    private void fit() {
        // Compute slope and intercept for linear regression
        double xMean = Arrays.stream(xValues).average().orElse(0);
        double yMean = Arrays.stream(yValues).average().orElse(0);

        double numerator = 0;
        double denominator = 0;

        for (int i = 0; i < xValues.length; i++) {
            numerator += (xValues[i] - xMean) * (yValues[i] - yMean);
            denominator += Math.pow(xValues[i] - xMean, 2);
        }

        slope = numerator / denominator;
        intercept = yMean - slope * xMean;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set rendering hints for better quality
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set background color
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Set plot area
        int padding = 50;
        int plotWidth = getWidth() - 2 * padding;
        int plotHeight = getHeight() - 2 * padding;

        // Draw x and y axes
        g2d.setColor(Color.BLACK);
        g2d.drawLine(padding, padding, padding, getHeight() - padding); // y-axis
        g2d.drawLine(padding, getHeight() - padding, getWidth() - padding, getHeight() - padding); // x-axis

        // Draw actual data points
        g2d.setColor(Color.BLUE);
        for (int i = 0; i < xValues.length; i++) {
            int x = padding + (int) ((xValues[i] - min(xValues)) / (max(xValues) - min(xValues)) * plotWidth);
            int y = getHeight() - padding - (int) ((yValues[i] - min(yValues)) / (max(yValues) - min(yValues)) * plotHeight);
            g2d.fillOval(x - 2, y - 2, 4, 4);
        }

        // Draw regression line
        g2d.setColor(Color.RED);
        int x1 = padding;
        int y1 = getHeight() - padding - (int) ((slope * min(xValues) + intercept - min(yValues)) / (max(yValues) - min(yValues)) * plotHeight);
        int x2 = getWidth() - padding;
        int y2 = getHeight() - padding - (int) ((slope * max(xValues) + intercept - min(yValues)) / (max(yValues) - min(yValues)) * plotHeight);
        g2d.drawLine(x1, y1, x2, y2);
    }

    private double min(double[] values) {
        return Arrays.stream(values).min().orElseThrow();
    }

    private double max(double[] values) {
        return Arrays.stream(values).max().orElseThrow();
    }

    public static void main(String[] args) {
        // Sample data for demonstration
        double[] shots = {1, 1, 0, 14, 28, 36, 14, 0, 8, 16, 7, 20, 9, 10, 19, 0, 30, 0, 40, 17, 85, 41, 2, 19, 8, 2, 21, 31, 1, 29, 0, 0, 2, 6, 22, 45, 3, 47, 1, 16, 0, 2, 0, 61, 19, 2, 5, 0, 1, 2, 14, 6, 18, 11, 0, 10, 22, 4, 37, 5, 29, 23, 0, 4, 23, 12, 10, 70, 12, 9, 11, 6, 13, 0, 5, 13, 26, 25, 29, 4, 0, 18, 12, 17, 0, 8, 15, 59, 0, 7, 0, 28, 31, 12, 0, 0, 0, 4, 11, 1, 2, 27, 33, 3, 2, 12, 2, 0, 10, 11, 10, 0, 4, 4, 3, 0, 6, 10, 60, 6, 8, 24, 6, 16, 25, 0, 0, 16, 12, 4, 16, 21, 4, 2, 44, 1, 0, 16, 80, 0, 17, 4, 15, 0, 5, 7, 39, 21, 0, 28, 40, 6, 22, 11, 1, 0, 1, 31, 14, 0, 49, 3, 2, 51, 32, 2, 5, 16, 8, 9, 5, 11, 1, 57, 0, 1, 23, 3, 33, 78, 44, 0, 0, 90, 0, 7, 1, 23, 8, 3, 45, 40, 20, 73, 33, 9, 57, 3, 2, 23, 10, 7, 20, 7, 17, 1, 68, 0, 0, 17, 0, 22, 45, 5, 36, 11, 21, 93, 0, 1, 38, 1, 26, 2, 44, 15, 35, 0, 2, 70, 7, 0, 14, 2, 23, 4, 15, 31, 4, 9, 0, 50, 4, 45, 57, 7, 18, 12, 49, 37, 50, 15, 2, 6, 39, 3, 0, 15, 4, 36, 3, 3, 8, 6, 4, 5, 0, 0, 0, 6, 0, 0, 3, 1, 9, 0, 12, 6, 37, 23, 9, 17, 5, 14, 2, 44, 8, 6, 1, 5, 6, 0, 41, 8, 0, 34, 5, 33, 6, 3, 10, 7, 31, 2, 43, 10, 5, 32, 45, 16, 18, 7, 10, 4, 14, 6, 50, 0, 0, 0, 32, 28, 5, 0, 0, 34, 5, 10, 42, 22, 0, 26, 0, 35, 2, 47, 36, 10, 1, 8, 1, 13, 5, 1, 5, 34, 2, 7, 52, 2, 6, 8, 56, 4, 1, 24, 58, 4, 0, 14, 0, 21, 24, 5, 0, 4, 0, 0, 35, 5, 38, 11, 0, 14, 1, 5, 99, 0, 33, 15, 2, 37, 32, 0, 3, 30, 0, 0, 25, 0, 0, 0, 3, 21, 14, 0, 3, 8, 20, 20, 0, 38, 0, 69, 15, 35, 0, 2, 4, 0, 0, 4, 43, 2, 0, 3, 2, 0, 0, 15, 1, 42, 3, 0, 5, 0, 6, 19, 58, 0, 1, 0, 7, 4, 10, 27, 2, 0, 41, 6, 58, 0, 5, 0, 7, 13, 11, 57, 20, 6, 7, 13, 2, 10, 0, 79, 84, 8, 7, 1, 0, 0, 8, 2, 41, 0, 5, 31, 18, 9, 0, 14, 57, 7, 2, 29, 7, 10, 26, 3, 1, 12, 0, 88, 7, 38, 10, 0, 46, 4, 0, 54, 0, 22, 7, 51, 10, 4, 6, 11, 0, 8, 9, 0, 3, 39, 11, 19, 0, 7, 0, 6, 5, 8, 45, 7, 3, 0, 9, 0, 11, 30, 8, 2, 3, 6, 0, 0, 5, 9, 17, 0, 16, 2, 10, 36, 1, 91, 5, 34, 25, 3, 8, 0, 9, 41, 7, 29, 35, 59, 31, 10, 2, 9, 21, 12, 8, 25, 3, 16, 15, 58}; // Replace with actual shot data
        double[] goals = {0, 0, 0, 2, 9, 6, 1, 0, 0, 1, 1, 2, 2, 2, 2, 0, 2, 0, 3, 1, 8, 4, 0, 2, 0, 0, 4, 0, 0, 4, 0, 0, 0, 0, 6, 4, 0, 8, 0, 0, 0, 1, 0, 4, 4, 0, 1, 0, 0, 0, 2, 0, 0, 1, 0, 0, 1, 1, 3, 0, 2, 0, 0, 1, 2, 1, 2, 15, 1, 2, 4, 0, 1, 0, 0, 1, 2, 3, 4, 0, 0, 3, 0, 2, 0, 0, 1, 5, 0, 0, 0, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 9, 0, 1, 1, 0, 1, 1, 0, 0, 4, 1, 0, 1, 3, 0, 1, 5, 0, 0, 0, 8, 0, 1, 0, 2, 0, 1, 1, 2, 2, 0, 4, 6, 0, 1, 0, 0, 0, 0, 3, 3, 0, 7, 0, 0, 5, 2, 0, 1, 0, 1, 1, 0, 2, 0, 6, 0, 0, 2, 0, 6, 6, 3, 0, 0, 14, 0, 0, 0, 4, 0, 0, 6, 3, 1, 7, 1, 1, 4, 0, 0, 0, 0, 1, 2, 0, 0, 0, 9, 0, 0, 0, 0, 3, 4, 0, 4, 0, 0, 19, 0, 0, 3, 0, 3, 0, 9, 0, 10, 0, 0, 15, 0, 0, 3, 0, 5, 0, 0, 7, 0, 1, 0, 15, 0, 5, 9, 0, 0, 3, 4, 5, 8, 2, 0, 0, 5, 0, 0, 1, 0, 9, 1, 0, 1, 0, 2, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 2, 1, 5, 1, 0, 1, 0, 0, 0, 6, 0, 0, 0, 0, 1, 0, 4, 0, 0, 1, 2, 2, 1, 1, 2, 1, 4, 0, 9, 1, 0, 4, 4, 3, 1, 2, 1, 0, 3, 1, 6, 0, 0, 0, 3, 7, 0, 0, 0, 6, 0, 1, 8, 3, 0, 6, 0, 6, 0, 2, 7, 2, 1, 1, 0, 1, 0, 0, 1, 3, 0, 0, 7, 0, 1, 2, 9, 1, 0, 4, 8, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 2, 1, 5, 2, 0, 1, 0, 0, 11, 0, 2, 2, 0, 3, 4, 0, 0, 6, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 1, 0, 4, 0, 16, 1, 4, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 7, 0, 1, 0, 0, 0, 0, 6, 0, 0, 6, 1, 10, 0, 1, 0, 1, 0, 1, 7, 2, 1, 1, 4, 0, 0, 0, 14, 17, 2, 0, 0, 0, 0, 0, 0, 4, 0, 1, 3, 1, 1, 0, 0, 7, 3, 0, 6, 0, 3, 2, 0, 0, 0, 0, 16, 0, 6, 1, 0, 6, 1, 0, 3, 0, 1, 0, 3, 1, 1, 0, 1, 0, 1, 1, 0, 1, 4, 2, 1, 0, 1, 0, 0, 0, 1, 8, 0, 0, 0, 2, 0, 1, 2, 1, 1, 0, 2, 0, 0, 1, 2, 0, 0, 0, 0, 0, 6, 0, 18, 0, 4, 2, 0, 2, 0, 0, 4, 1, 7, 3, 8, 12, 1, 0, 0, 0, 0, 1, 2, 0, 1, 3, 7};    // Replace with actual goal data

        // Create plot panel
        JFrame frame = new JFrame("EPL Shooting Linear Regression Plot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        EPLShootingLinearRegressionPlot plot = new EPLShootingLinearRegressionPlot(shots, goals);
        frame.add(plot);
        frame.setVisible(true);
    }
}
