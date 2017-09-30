/**
 *
 */
class TaxiCar {

    private String id;
    private boolean isAvailable;
    private double xCoord;
    private double yCoord;

    TaxiCar(String id, double x, double y) {
        this.id = id;
        isAvailable = true;
        xCoord = x;
        yCoord = y;
    }

    String getId() {
        return id;
    }

    boolean isAvailable() {
        return isAvailable;
    }

    void reserveTaxi() {
        isAvailable = false;
    }

    double getXCoord() {
        return xCoord;
    }

    double getYCoord() {
        return yCoord;
    }
}
