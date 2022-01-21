package lapr.project.model;

public class EnergyVoyage {

    private double k_external;
    private double k_middle;
    private double k_internal;


    public double energyCalculator(double hours_voyage1, double temperature1,
                                   double hours_voyage2, double temperature2, double type) {

        if (type != -5 && type != 7) {
            return 0;
        }
        if (type == -5) {
           k_external = 15;
           k_middle = 0.030;
           k_internal = 0.033;
        }
        if (type == 7) {
            k_external = 273;
            k_middle = 0.045;
            k_internal = 0.055;
        }

        double a = 2.56;
        double b = 2.44;
        double c = 6.09;
        double totalAreaExposed = 2 * (2 * b * 4 * a) + 3 * (2 *b * 5 * c); // 40 contentores
        double thicknessExternal = 0.002;
        double thicknessMiddle = 0.095;
        double thicknessInternal = 0.003;
        double r1 = thicknessExternal / (k_external * totalAreaExposed);
        double r2 = thicknessMiddle / (k_middle * totalAreaExposed);
        double r3 = thicknessInternal / (k_internal * totalAreaExposed);
        double rtotal = r1 + r2 + r3;

        double Q1 = (temperature1 - type) / rtotal;
        double E1 = Q1 * 3600 * hours_voyage1;

        double Q2 = (temperature2 - type) / rtotal;
        double E2 = Q2 * 3600 * hours_voyage2;

        return E1 + E2;
    }

}
