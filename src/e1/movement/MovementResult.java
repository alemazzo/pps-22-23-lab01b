package e1.movement;

/**
 * The result of a movement
 */
public enum MovementResult {
    
    /**
     * The movement was successful
     */
    SUCCESS,

    /**
     * The movement failed because the movement was not valid
     */
    FAILURE,

    /**
     * The movement succeeded and a piece was captured
     */
    CAPTURE
}
