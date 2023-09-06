package miit.uvp.free.Exception;

public class SchoolClassNotFoundException2 extends RuntimeException{
    public SchoolClassNotFoundException2(Long id) {super("Could not find schoolClass with Student" + id);}
}
