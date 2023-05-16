package businessLayer.validators;


/**
 * Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * Apr 03, 2017
 */
public interface Validator<T> {

    /**
     * @param t obiect de validat
     */
    public void validate(T t);
}
