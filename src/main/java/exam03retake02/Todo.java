package exam03retake02;

public class Todo {

    private String text;
    private State state;
    private int priority;

    public Todo(String text, int priority) {
        this.text = text;
        if( priority >5 || priority <1){
            throw new IllegalArgumentException("Invalid");
        }
        this.priority = priority;
        this.state = State.NON_COMPLETED;
    }

    public String getText() {
        return text;
    }

    public State getState() {
        return state;
    }

    public int getPriority() {
        return priority;
    }

    public void complete() {
        this.state = State.COMPLETED;
    }
}
