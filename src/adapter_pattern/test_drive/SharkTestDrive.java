package adapter_pattern.test_drive;

import adapter_pattern.object_adapter.WhaleAdapter;
import adapter_pattern.animal.BlueWhale;
import adapter_pattern.animal.GreatWhite;
import adapter_pattern.animal.Shark;
import adapter_pattern.animal.Whale;

public class SharkTestDrive {
    public static void main(String[] args) {
        System.out.println("--- Shark Test ----");
        Shark shark = new GreatWhite();
        shark.breathe();
        shark.bite();

        System.out.println("\n--- Whale Test ----");
        Whale whale = new BlueWhale();
        whale.breathe();
        whale.swallow();

        System.out.println("\n--- Whale Adapter Test ----");
        Shark whaleAdapter = new WhaleAdapter(whale);
        whaleAdapter.breathe();
        whaleAdapter.bite();
    }
}
