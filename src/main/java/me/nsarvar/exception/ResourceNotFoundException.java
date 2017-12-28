package me.nsarvar.exception;

/**
 * Created by nsarvar on 12/27/17.
 */
public class ResourceNotFoundException extends RuntimeException {
    private long resourceId;

    public ResourceNotFoundException(Long resourceId, String message) {
        super(message);
        this.resourceId = resourceId;
    }
}
