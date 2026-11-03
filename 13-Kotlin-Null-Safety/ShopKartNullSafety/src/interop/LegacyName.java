package interop;

public class LegacyName {

    public String findName(int id){
        if(id == 101){
            return "Asha";
        }
        if(id == 102){
            return "John";
        }
        return null;
    }

}
