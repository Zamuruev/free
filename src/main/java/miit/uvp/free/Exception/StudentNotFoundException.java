package miit.uvp.free.Exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Long id) {
        super("Could not find student " + id);
    }
}