package modern;

public record Address(String city, String zip) {
    public Address {
        if(city == null || city.isBlank()){
            throw new IllegalArgumentException("city required");
        }
    }
}
