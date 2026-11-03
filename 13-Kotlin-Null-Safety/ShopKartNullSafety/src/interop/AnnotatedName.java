package interop;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AnnotatedName {
    @Nullable
    public String findName(int id){
        if(id == 101){
            return "Asha";
        }
        if(id == 102){
            return "John";
        }
        return null;
    }

    @NotNull
    public String greeting(@NotNull String name){
        return "Hello, "+ name;
    }
}
