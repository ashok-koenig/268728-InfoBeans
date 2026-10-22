package resources;

public class Main {
    public static void main(String[] args) {
        System.out.println("-- old way");
        TrackedResource old = null;
        try{
            old = new TrackedResource("old-way");
            old.use(false);
        } finally {
            if(old != null){
                old.close();
            }
        }

        System.out.println("-- try-with-resources");
        try (TrackedResource file = new TrackedResource("file")){
            file.use(false);
        }

        System.out.println("-- tow resources, body fails");
        try (TrackedResource file = new TrackedResource("file");
            TrackedResource db = new TrackedResource("database")){
            file.use(false);
            db.use(true);
        }catch (IllegalStateException e){
            System.out.println("Exception: "+ e.getMessage());
        }
    }
}
