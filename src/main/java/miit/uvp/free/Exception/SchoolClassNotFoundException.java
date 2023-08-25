package miit.uvp.free.Exception;

public class SchoolClassNotFoundException  extends RuntimeException{
    public SchoolClassNotFoundException(Long id) {
        super("Could not find schoolClass " + id);
    }
}
