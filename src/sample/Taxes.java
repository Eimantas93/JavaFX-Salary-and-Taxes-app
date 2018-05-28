package sample;

public class Taxes {

    private double kidsNumber;
    private double salaryBruto;

    /**
     * Constructor.
     *
     * @param salaryBruto Salary bruto.
     */
    public Taxes(double salaryBruto) {
        this.salaryBruto = salaryBruto;
    }

    /**
     * Constructor.
     *
     * @param salaryBruto Salary bruto.
     * @param kidsNumber  Number of kids.
     */
    public Taxes(double salaryBruto, double kidsNumber) {
        this.salaryBruto = salaryBruto;
        this.kidsNumber = kidsNumber;
    }

    /**
     * Get VSD taxes.
     *
     * @return VSD taxes.
     */
    public double getVSD() {
        return salaryBruto * 0.3118;
    }

    /**
     * Get PSD taxes.
     *
     * @return PSD taxes.
     */
    public double getPSD() {
        return salaryBruto * 0.09;
    }

    /**
     * Get NPD size.
     *
     * @return NPD size.
     */
    public double getNPD() {
        return 310 - 0.5 * (salaryBruto - 380);
    }

    /**
     * Get PNPD size.
     *
     * @return PNPD size.
     */
    public double getPNPD() {
        return kidsNumber * 200;
    }

    /**
     * Get GPM taxes.
     *
     * @return GMP taxes.
     */
    public double getGPM() {
        return (salaryBruto - getNPD() - getPNPD()) * 0.15;
    }

    /**
     * Get work place cost.
     *
     * @return work place cost.
     */
    public double getWorkPlaceCost() {
        return salaryBruto + getVSD();
    }
}
