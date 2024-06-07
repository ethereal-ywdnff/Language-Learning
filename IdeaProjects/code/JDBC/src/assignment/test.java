package assignment;

public class test {
    public static void main(String[] args) throws Exception {

    /*
        String createTableComponents = "CREATE TABLE Components (\n" +
                "componentName VARCHAR(100) NOT NULL,\n" +
                "unitCost DOUBLE NOT NULL\n" +
                "brandName VARCHAR(100) NOT NULL\n" +
                "serialNumber VARCHAR(100) NOT NULL\n;)";

        String createTableWheel = "CREATE TABLE Wheel (" +
                "Diameter DOUBLE NOT NULL" +
                "WheelStyle INT NOT NULL" +
                "BrakeStyle INT NOT NULL)";

        //PreparedStatement preparedStatement1 = conn.prepareStatement(createTableWheel);
        //preparedStatement1.executeUpdate();

        PreparedStatement preparedStatement2 = conn.prepareStatement(createTableComponents);
        preparedStatement2.executeUpdate();

        Components components = new Components();
        components.addWheel();
    */

    Customer customer = new Customer();
    customer.setUsername("zhjpe");
    customer.setPassword("12345678");
    //System.out.println(customer.getPassword());

    CustomerLogin customerLogin = new CustomerLogin();
    customerLogin.customerLogin(customer);

    System.out.println("Hello " + customer.getForename() + " " + customer.getSurname());

    }
}
