package learn.rabbitMQ;

public class DTO {

}

class  consumerType{
    private String name;
    private int id;

    public consumerType() {
    }

    @Override
    public String toString() {
        return "consumerType{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public consumerType(String name, int id) {
        this.name = name;
        this.id = id;
    }
}