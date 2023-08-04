package dev.sidgames.nulacore.feature;

public class DisabledFeatureException extends Exception {
    public DisabledFeatureException() {
        super();
    }
    public DisabledFeatureException(String message) {
        super(message);
    }
    public DisabledFeatureException(String message, Throwable cause) {
        super(message, cause);
    }
    public DisabledFeatureException(Throwable cause) {
        super(cause);
    }
    protected DisabledFeatureException(String message, Throwable cause,
                        boolean enableSuppression,
                        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
