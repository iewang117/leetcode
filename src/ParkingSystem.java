public class ParkingSystem {
    private int[] park;

    public ParkingSystem(int big, int medium, int small) {
        park = new int[3];
        park[0] = big;
        park[1] = medium;
        park[2] = small;
    }

    public boolean addCar(int carType) {
        if((park[--carType]--)>0){

            return true;
        }else{
            return false;
        }
    }
}
