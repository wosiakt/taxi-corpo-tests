/**
 *
 */
class TaxiCorpo {

    private TaxiCar[] taxiCarTable;

    TaxiCorpo(TaxiCar[] taxiCarTable) {
        this.taxiCarTable = taxiCarTable;
    }

    String reserveAvailableTaxi(double customerX, double customerY) {

        TaxiCar bestTaxi = findBestTaxiIfExist(customerX, customerY);

        if (bestTaxi == null) {
            return null;
        } else {
            bestTaxi.reserveTaxi();
            return bestTaxi.getId();
        }
    }

    private TaxiCar findBestTaxiIfExist(double customerX, double customerY) {
        double minDistance = Double.MAX_VALUE;
        TaxiCar bestTaxi = null;

        for (int i = 0; i < taxiCarTable.length; i++) {
            TaxiCar iTaxi = taxiCarTable[i];

            if (iTaxi.isAvailable()) {
                double distance = calculateDistance(customerX, customerY, iTaxi);
                if (distance < minDistance) {
                    minDistance = distance;
                    bestTaxi = iTaxi;
                }
            }
        }
        return bestTaxi;
    }

    private double calculateDistance(double customerX, double customerY, TaxiCar iTaxi) {
        double diffX = iTaxi.getXCoord() - customerX;
        double diffY = iTaxi.getYCoord() - customerY;
        double diffXSquared = diffX * diffX;
        double diffYSquared = diffY * diffY;
        return Math.sqrt(diffXSquared + diffYSquared);
    }

    TaxiCar[] getTaxiCarTable() {
        return taxiCarTable;
    }

}
