package miit.uvp.free.Exception;

public class SubjectNotFoundException extends RuntimeException{
    public SubjectNotFoundException(Long id) {
        super("Could not find subject " + id);
    }

}
