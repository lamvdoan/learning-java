package adapter_pattern.class_adapter;

import adapter_pattern.animal.BlueWhale;

// Assume multiple inheritance is supported, it will also inherit GreatWhite
public class WhaleShark extends BlueWhale {

    // Shark methods
    public void bite() {
        swallow();
    }

    @Override
    public void breathe() {
        // This won't work in Java since different languages handle overriding super methods differently
    }
}
