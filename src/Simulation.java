/**
 *
 */
public class Simulation {

    public static void main(String[] args) {

        //input
        TaxiCar[] taxiCarTable = createTaxiCarTable();

        //simulation
        TaxiCorpo jaxi = new TaxiCorpo(taxiCarTable);
        String firstReservation = jaxi.reserveAvailableTaxi(2,1);
        String secondReservation = jaxi.reserveAvailableTaxi(3,1);

        //output
        printTaxiCorpo(jaxi);
    }

    //output
    private static void printTaxiCorpo(TaxiCorpo taxiCorpo) {
        TaxiCar[] taxiCarTable = taxiCorpo.getTaxiCarTable();
        for(int i=0; i < taxiCarTable.length; i++) {
            printTaxiCar(taxiCarTable[i]);
        }
    }
    private static void printTaxiCar(TaxiCar taxiCar) {
        System.out.println("Taxi no:" + taxiCar.getId() + " isAvailable: " + taxiCar.isAvailable());
    }

    //input
    private static TaxiCar[] createTaxiCarTable() {
        TaxiCar[] taxiCarTable = new TaxiCar[3];

        taxiCarTable[0] = new TaxiCar("001", 1, 1);
        taxiCarTable[1] = new TaxiCar("002", 1, 5);
        taxiCarTable[2] = new TaxiCar("003", 5, 1);

        return taxiCarTable;
    }
}
