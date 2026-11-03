import java.util.ArrayList;
import java.util.List;

public class DeliveryPersonDAO {
    // Simulated database storage (replace or connect with your actual database/storage logic)
    private static List<DeliveryPerson> deliveryPersons = new ArrayList<>();
    private static int nextId = 1;

    public boolean addDeliveryPerson(DeliveryPerson deliveryPerson) {
        try {
            deliveryPerson.setDeliveryPersonId(nextId++);
            deliveryPersons.add(deliveryPerson);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public DeliveryPerson findDeliveryPersonById(int id) {
        for (DeliveryPerson dp : deliveryPersons) {
            if (dp.getDeliveryPersonId() == id) {
                return dp;
            }
        }
        return null;
    }

    public boolean updateDeliveryPerson(DeliveryPerson deliveryPerson) {
        DeliveryPerson existing = findDeliveryPersonById(deliveryPerson.getDeliveryPersonId());
        if (existing != null) {
            // Update fields if needed, or reference is already pointing to the mutable object
            return true;
        }
        return false;
    }

    public boolean deleteDeliveryPerson(int id) {
        DeliveryPerson deliveryPerson = findDeliveryPersonById(id);
        if (deliveryPerson != null) {
            deliveryPersons.remove(deliveryPerson);
            return true;
        }
        return false;
    }
}