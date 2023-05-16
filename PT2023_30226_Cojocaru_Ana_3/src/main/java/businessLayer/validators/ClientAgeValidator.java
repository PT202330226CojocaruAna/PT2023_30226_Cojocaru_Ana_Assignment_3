package businessLayer.validators;

import model.Client;

/**
 *  Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 *  Apr 03, 2017
 */
public class ClientAgeValidator implements Validator<Client> {
    private static final int MIN_AGE = 0;
    private static final int MAX_AGE = 30;

    /**
     * @param t obiect de validat
     */
    public void validate(Client t) {

        if (t.getAge() < MIN_AGE || t.getAge() > MAX_AGE) {
            throw new IllegalArgumentException("The Student Age limit is not respected!");
        }

    }

}
