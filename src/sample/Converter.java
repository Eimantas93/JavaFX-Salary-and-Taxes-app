package sample;

public class Converter {
    /**
     * Calculate bruto salary.
     *
     * @param salaryNeto salary neto.
     * @param NPDAndPNPD NPD and PNPD taxes.
     * @return salary bruto.
     */
    public static double brutoToNeto(double salaryNeto, double NPDAndPNPD) {
        return (salaryNeto - NPDAndPNPD * 0.27) / 0.7;
    }
}
