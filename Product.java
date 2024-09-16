import java.util.Objects;

public  class Product{

      private String ID;

      private String name;

      private String description;

      private double cost;


        public Product( String ID,String name, String description, double cost) {

            this.ID = ID;
            this.name = name;
            this.description = description;
            this.cost = cost;
        }

        public String productName(){
            return name + " " + description;
        }


        public String toJSON(){

            String DQ = "\"";

            return "{"+ DQ + "ID" + DQ + ":" + DQ + this.ID + DQ + "," + DQ + "name" + DQ + ":" + DQ + this.name + DQ + "," + DQ + "description" + DQ + ":" + DQ + this.description + DQ +  "," + DQ + "cost" + DQ + ":" + DQ + this.cost + DQ + "}";
        }

        public String toXML(){
            return String.format("<product><ID>%S</ID><name>%s</name><description>%s</description><cost>%.2f</cost></product>", ID, name,description,cost);
        }

        public String toCSV(){
            return String.format("%s,%s,%s,%.2f", ID, name, description,cost);
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(cost, product.cost) == 0 && Objects.equals(ID, product.ID) && Objects.equals(name, product.name) && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, description, cost);
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}