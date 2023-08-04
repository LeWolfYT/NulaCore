package dev.sidgames.nulacore.feature;

public interface Feature {
    boolean isEnabled();
    void enable();
    void disable();
}
