package Leetcode.BFS;

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
public class LC16031603DesignParkingSystem {


    private int big;
    private int medium;
    private  int small;

    public LC16031603DesignParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium=medium;
        this.small=small;
    }

    public boolean addCar(int carType) {
        if(carType ==1 && big != 0){
            this.big -=1;
            return true;
        }
        if(carType ==2 && medium != 0){
            this.medium -=1;
            return true;
        }
        if(carType ==3 && small != 0){
            this.small -=1;
            return true;
        }
        return false;


    }

}
