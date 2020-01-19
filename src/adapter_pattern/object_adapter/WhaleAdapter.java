package adapter_pattern.object_adapter;

import adapter_pattern.animal.Shark;
import adapter_pattern.animal.Whale;

// Target interface: Shark
public class WhaleAdapter implements Shark {
    // Adaptee: Whale
    Whale whale;

    // Adapter: WhaleAdapter
    public WhaleAdapter(Whale whale) {
        this.whale = whale;
    }

    @Override
    public void bite() {
        whale.swallow();
    }

    @Override
    public void breathe() {
        whale.breathe();
    }
}
