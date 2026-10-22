package resources;

public class TrackedResource implements AutoCloseable {
    private final String name;

    public TrackedResource(String name) {
        this.name = name;
        System.out.println("open "+ name);
    }

    public void use(boolean fail){
        System.out.println("use "+ name);
        if(fail){
            throw new IllegalStateException(name + " failed");
        }
    }


    public void close() {
        System.out.println("close "+ name);
    }
}
