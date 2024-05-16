package com.example;

import java.util.List;

public class MetricsCalculatorApp {

    public static void main(String[] args) {
        // Sample actual and predicted values
        double[] actual = {0, 0, 0, 2, 9, 6, 1, 0, 0, 1, 1, 2, 2, 2, 2, 0, 2, 0, 3, 1, 8, 4, 0, 2, 0, 0, 4, 0, 0, 4, 0, 0, 0, 0, 6, 4, 0, 8, 0, 0, 0, 1, 0, 4, 4, 0, 1, 0, 0, 0, 2, 0, 0, 1, 0, 0, 1, 1, 3, 0, 2, 0, 0, 1, 2, 1, 2, 15, 1, 2, 4, 0, 1, 0, 0, 1, 2, 3, 4, 0, 0, 3, 0, 2, 0, 0, 1, 5, 0, 0, 0, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 9, 0, 1, 1, 0, 1, 1, 0, 0, 4, 1, 0, 1, 3, 0, 1, 5, 0, 0, 0, 8, 0, 1, 0, 2, 0, 1, 1, 2, 2, 0, 4, 6, 0, 1, 0, 0, 0, 0, 3, 3, 0, 7, 0, 0, 5, 2, 0, 1, 0, 1, 1, 0, 2, 0, 6, 0, 0, 2, 0, 6, 6, 3, 0, 0, 14, 0, 0, 0, 4, 0, 0, 6, 3, 1, 7, 1, 1, 4, 0, 0, 0, 0, 1, 2, 0, 0, 0, 9, 0, 0, 0, 0, 3, 4, 0, 4, 0, 0, 19, 0, 0, 3, 0, 3, 0, 9, 0, 10, 0, 0, 15, 0, 0, 3, 0, 5, 0, 0, 7, 0, 1, 0, 15, 0, 5, 9, 0, 0, 3, 4, 5, 8, 2, 0, 0, 5, 0, 0, 1, 0, 9, 1, 0, 1, 0, 2, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 2, 1, 5, 1, 0, 1, 0, 0, 0, 6, 0, 0, 0, 0, 1, 0, 4, 0, 0, 1, 2, 2, 1, 1, 2, 1, 4, 0, 9, 1, 0, 4, 4, 3, 1, 2, 1, 0, 3, 1, 6, 0, 0, 0, 3, 7, 0, 0, 0, 6, 0, 1, 8, 3, 0, 6, 0, 6, 0, 2, 7, 2, 1, 1, 0, 1, 0, 0, 1, 3, 0, 0, 7, 0, 1, 2, 9, 1, 0, 4, 8, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 2, 1, 5, 2, 0, 1, 0, 0, 11, 0, 2, 2, 0, 3, 4, 0, 0, 6, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 1, 0, 4, 0, 16, 1, 4, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 7, 0, 1, 0, 0, 0, 0, 6, 0, 0, 6, 1, 10, 0, 1, 0, 1, 0, 1, 7, 2, 1, 1, 4, 0, 0, 0, 14, 17, 2, 0, 0, 0, 0, 0, 0, 4, 0, 1, 3, 1, 1, 0, 0, 7, 3, 0, 6, 0, 3, 2, 0, 0, 0, 0, 16, 0, 6, 1, 0, 6, 1, 0, 3, 0, 1, 0, 3, 1, 1, 0, 1, 0, 1, 1, 0, 1, 4, 2, 1, 0, 1, 0, 0, 0, 1, 8, 0, 0, 0, 2, 0, 1, 2, 1, 1, 0, 2, 0, 0, 1, 2, 0, 0, 0, 0, 0, 6, 0, 18, 0, 4, 2, 0, 2, 0, 0, 4, 1, 7, 3, 8, 12, 1, 0, 0, 0, 0, 1, 2, 0, 1, 3, 7};
        double[] predicted = {-0.203085232, -0.203654663, -0.342244182, 1.589349969, 3.521255837, 4.608143541, 1.576835076, -0.347484967, 0.751901948, 1.853661974, 0.617447665, 2.404714024, 0.892386388, 1.027744249, 2.264389754, -0.349929866, 3.778507948, -0.349810896, 5.161744714, 1.996504553, 11.38964188, 5.352388802, -0.083474498, 2.289126163, 0.75425833, -0.081478105, 2.569974322, 3.962173968, -0.220668941, 3.695227975, -0.36141825, -0.362538383, -0.08384099, 0.475595949, 2.715024709, 5.922628533, 0.052165248, 6.215938145, -0.226874998, 1.869220045, -0.363918021, -0.085415824, -0.368324889, 8.166501488, 2.301658705, -0.098273736, 0.324374776, -0.382389361, -0.242569789, -0.102244939, 1.59034341, 0.460928695, 2.154679367, 1.171398807, -0.380174502, 1.029752548, 2.724982822, 0.188089957, 4.845673311, 0.328476767, 3.723279506, 2.879305994, -0.372556793, 0.193063881, 2.884379352, 1.326639437, 1.043721503, 9.551149465, 1.319480106, 0.899885402, 1.177667989, 0.470700357, 1.453046793, -0.368104476, 0.331619867, 1.453884779, 3.277012728, 3.140279052, 3.701676431, 0.194905902, -0.365431133, 2.157863423, 1.314639959, 2.01852891, -0.365076787, 0.755643623, 1.738961767, 7.90995713, -0.367919427, 0.617823732, -0.367436303, 3.579440591, 4.011080567, 1.331933955, -0.361568593, -0.362833113, -0.36410651, 0.200477769, 1.191232591, -0.220303182, -0.079604426, 3.456350478, 4.303179717, 0.064647877, -0.080171016, 1.339012558, -0.079599525, -0.363747162, 1.054713749, 1.196819792, 1.055306883, -0.361537534, 0.205023387, 0.202627296, 0.06122884, -0.364595841, 0.486299755, 1.055710275, 8.156381466, 0.488075508, 0.772951307, 3.040553308, 0.492459123, 1.912258521, 3.190934353, -0.352127147, -0.353455175, 1.917839415, 1.344905131, 0.209520809, 1.914310383, 2.626500174, 0.211547885, -0.071755411, 5.89170384, -0.217768708, -0.360821358, 1.914399801, 11.02568917, -0.369945333, 2.069471528, 0.205350691, 1.785343213, -0.368810381, 0.347798455, 0.633079498, 5.229706479, 2.65396037, -0.372320781, 3.664559915, 5.393811969, 0.490443054, 2.797101055, 1.216346319, -0.221651526, -0.36663606, -0.223947075, 4.100993895, 1.652254451, -0.371572231, 6.700385156, 0.06006226, -0.084010372, 6.986032569, 4.257216918, -0.083362514, 0.351387143, 1.944993603, 0.78935259, 0.933819497, 0.353287097, 1.224822434, -0.22812459, 7.896973883, -0.37756243, -0.233478964, 2.971096963, 0.058891653, 4.431594321, 10.97455163, 6.10103747, -0.401538689, -0.403267889, 12.95712399, -0.399001728, 0.634811673, -0.250566358, 3.002728652, 0.781606977, 0.044886679, 6.253547938, 5.516519485, 2.568017596, 10.43790102, 4.538720161, 0.946868868, 8.167563716, 0.039167284, -0.112487861, 3.075229132, 1.109129895, 0.656506559, 2.631267123, 0.656939875, 2.178854582, -0.247129093, 9.938282663, -0.403574767, -0.405438941, 2.185805023, -0.401655065, 2.954153897, 6.464250606, 0.360545329, 5.110968287, 1.283510918, 2.8208668, 13.8813248, -0.357599163, -0.209238673, 5.343248168, -0.209824258, 3.554102335, -0.059249006, 6.268089134, 1.890631166, 4.89536587, -0.354868172, -0.058446895, 10.07888148, 0.690444156, -0.33288718, 1.717617862, -0.045343046, 3.032918048, 0.243234742, 1.85481503, 4.203320003, 0.245681779, 0.976572769, -0.337300564, 6.962113048, 0.247909732, 6.125493573, 7.862829832, 0.679873633, 2.256927113, 1.405060269, 6.700403597, 5.010790865, 6.885128829, 1.835094175, -0.034504159, 0.540447957, 5.285810151, 0.111493166, -0.319389925, 1.83651802, 0.256959878, 4.860343507, 0.110635452, 0.106584952, 0.822033869, 0.535365036, 0.251601577, 0.387023293, -0.326852466, -0.32863398, -0.330435021, 0.527222303, -0.334455657, -0.336316207, 0.091960057, -0.194346726, 0.951827939, -0.334677969, 1.384188724, 0.521495512, 4.966620648, 2.958033258, 0.955728012, 2.107962239, 0.388867175, 1.682624307, -0.033841504, 5.995004575, 0.827261185, 0.543665943, -0.171128674, 0.401768504, 0.547067307, -0.315761478, 5.56645311, 0.833350452, -0.31429386, 4.577882891, 0.409792697, 4.45797352, 0.552135827, 0.113937127, 1.12766333, 0.687506047, 4.179547386, -0.041411423, 5.927861025, 1.115624059, 0.392908437, 4.298979154, 6.181650229, 1.996387448, 2.283132732, 0.688734305, 1.119267781, 0.2465962, 1.70290489, 0.533573868, 6.935674252, -0.343656909, -0.345889749, -0.348151794, 4.324812758, 3.749429886, 0.374268439, -0.352888601, -0.355240783, 4.6044347, 0.36918618, 1.099101593, 5.758225979, 2.831596967, -0.355955306, 3.40931775, -0.364585064, 4.694828649, -0.079608162, 6.414396196, 4.883554891, 1.079346371, -0.234851688, 0.77711717, -0.244316311, 1.50363313, 0.339613515, -0.241462745, 0.340048368, 4.566447292, -0.098779357, 0.631848512, 7.214107343, -0.095973166, 0.488632693, 0.778470035, 7.80246281, 0.187023419, -0.255851016, 3.099964178, 8.054300329, 0.176993314, -0.405417861, 1.634903271, -0.400307554, 2.663164556, 3.105113999, 0.33372161, -0.395117704, 0.186807628, -0.396897862, -0.400075757, 4.720405452, 0.335535189, 5.189773042, 1.215381774, -0.409485613, 1.650878539, -0.261903639, 0.325831238, 14.1844803, -0.450629753, 4.548800797, 1.83416854, -0.147239483, 5.184684839, 4.448666405, -0.451256445, 0.004895348, 4.145927915, -0.459166656, -0.463266298, 3.360498983, -0.462879551, -0.467092739, -0.47138333, -0.014736375, 2.751296589, 1.69178513, -0.453287596, 0.004562921, 0.774850934, 2.616682474, 2.633906158, -0.44620404, 5.426292407, -0.449647033, 10.26222857, 1.836012081, 4.839368217, -0.406121828, -0.109593503, 0.190058022, -0.409511819, -0.41374585, 0.183964661, 6.05402102, -0.113963534, -0.4212282, 0.033827501, -0.119042302, -0.426657695, -0.43138568, 1.865576818, -0.276637665, 6.014824257, 0.032804592, -0.43498745, 0.340778475, -0.436539013, 0.495634413, 2.529927173, 8.634994687, -0.43539828, -0.282957703, -0.456127155, 0.645945939, 0.177474566, 1.127946623, 3.823081194, -0.136718165, -0.453355571, 6.004655726, 0.486643977, 8.685109093, -0.457621866, 0.319803605, -0.471926816, 0.620796338, 1.559562655, 1.259253482, 8.482925249, 2.693722751, 0.482040942, 0.63490086, 1.582725787, -0.186063098, 1.082023992, -0.493933219, 12.04861818, 12.61050014, 0.790706573, 0.63018085, -0.245537089, -0.396589522, -0.403156341, 0.770954098, -0.104706449, 5.645678174, -0.403703153, 0.333917459, 4.202730982, 2.278009531, 0.943528717, -0.405755029, 1.687301887, 8.15429769, 0.656700003, -0.13584502, 3.971544994, 0.606842597, 1.068738457, 3.467385774, -0.005097635, -0.309172599, 1.35839765, -0.447783659, 12.93807887, 0.641858089, 5.077813613, 1.072329284, -0.345114838, 6.182063905, 0.215004069, -0.370699101, 7.339601372, -0.437675119, 2.887680756, 0.635495253, 7.339922629, 1.135051785, 0.173604321, 0.478229054, 1.29180638, -0.472003421, 0.804114134, 0.961604777, -0.490343724, -0.019966804, 5.798194326, 1.274904144, 2.581103618, -0.530272594, 0.613583748, -0.557637783, 0.422693913, 0.267254171, 0.773028693, 6.918201446, 0.595434905, -0.044252599, -0.537481335, 0.921320005, -0.59313745, 1.204110315, 4.35648871, 0.753031687, -0.26205507, -0.146803301, 0.355168549, -0.732631412, -0.772123912, 0.048514965, 0.700164737, 2.048212554, -0.852454138, 1.906132139, -0.478237495, 0.897955122, 5.495459764, -0.641121514, 15.12181444, 0.346631291, 4.526193473, 3.268671889, 0.131428931, 0.870978912, -0.402402065, 0.884214589, 5.675985259, 0.676910657, 4.056453798, 4.713297664, 8.680390789, 4.506925741, 0.603363382, -0.423225423, 0.354570345, 1.904732254, 1.052492877, 0.788876472, 2.795543303, 0.28739931, 2.070835639, 3, 0.115}; // Example predicted values

        // Calculate and display metrics
        double rSquared = calculateRSquared(actual, predicted);
        System.out.println("R-squared: " + rSquared);

        int numPredictors = 1; // Replace with actual number of predictors used in your model
        int numSamples = actual.length; // Replace with actual number of samples in your dataset
        double adjustedRSquared = calculateAdjustedRSquared(rSquared, numPredictors, numSamples);
        System.out.println("Adjusted R-squared: " + adjustedRSquared);

        double mse = calculateMSE(actual, predicted);
        System.out.println("Mean Squared Error (MSE): " + mse);

        double mae = calculateMAE(actual, predicted);
        System.out.println("Mean Absolute Error (MAE): " + mae);

        double rmse = calculateRMSE(actual, predicted);
        System.out.println("Root Mean Squared Error (RMSE): " + rmse);
    }

    // Method to calculate R-squared
    public static double calculateRSquared(double[] actual, double[] predicted) {
        double meanActual = calculateMean(actual);
        double ssTotal = 0.0;
        double ssResidual = 0.0;
        for (int i = 0; i < actual.length; i++) {
            ssTotal += Math.pow(actual[i] - meanActual, 2);
            ssResidual += Math.pow(actual[i] - predicted[i], 2);
        }
        return 1.0 - (ssResidual / ssTotal);
    }

    // Method to calculate adjusted R-squared
    public static double calculateAdjustedRSquared(double rSquared, int numPredictors, int numSamples) {
        return 1 - ((1 - rSquared) * (numSamples - 1) / (numSamples - numPredictors - 1));
    }

    // Method to calculate Mean Squared Error (MSE)
    public static double calculateMSE(double[] actual, double[] predicted) {
        double sum = 0.0;
        for (int i = 0; i < actual.length; i++) {
            sum += Math.pow(actual[i] - predicted[i], 2);
        }
        return sum / actual.length;
    }

    // Method to calculate Mean Absolute Error (MAE)
    public static double calculateMAE(double[] actual, double[] predicted) {
        double sum = 0.0;
        for (int i = 0; i < actual.length; i++) {
            sum += Math.abs(actual[i] - predicted[i]);
        }
        return sum / actual.length;
    }

    // Method to calculate Root Mean Squared Error (RMSE)
    public static double calculateRMSE(double[] actual, double[] predicted) {
        return Math.sqrt(calculateMSE(actual, predicted));
    }

    // Method to calculate mean of an array
    private static double calculateMean(double[] values) {
        double sum = 0.0;
        for (double value : values) {
            sum += value;
        }
        return sum / values.length;
    }
}
