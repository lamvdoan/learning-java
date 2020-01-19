package facade_pattern.client;

import facade_pattern.facade.HomeTheaterFacade;

public class HomeTheaterTestDrive {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheater = new HomeTheaterFacade();
        homeTheater.watchTv();
        homeTheater.endTv();
    }
}
