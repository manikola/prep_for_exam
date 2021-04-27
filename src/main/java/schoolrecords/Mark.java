package schoolrecords;

public class Mark {

    private MarkType markType;
    private Subject subject;
    private Tutor tutor;

    public Mark(MarkType markType, Subject subject, Tutor tutor) {
        this.markType = markType;
        if(subject == null){
            throw new NullPointerException("Both subject and tutor must be provided!");
        }
        this.subject = subject;
        this.tutor = tutor;
    }

    public MarkType getMarkType() {
        return markType;
    }

    public Subject getSubject() {
        return subject;
    }

    public Tutor getTutor() {
        return tutor;
    }

    @Override
    public String toString() {
        return markType.getDescription() + "(" + markType.getValue() + ")";
    }

    private boolean isEmpty(String str) {
        return (str == null || str.isBlank());
    }
}
