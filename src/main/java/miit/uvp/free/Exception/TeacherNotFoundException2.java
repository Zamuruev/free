package miit.uvp.free.Exception;

public class TeacherNotFoundException2 extends RuntimeException {
    public TeacherNotFoundException2(String position) {
        super("Could not find teacher " + position);
    }
}
