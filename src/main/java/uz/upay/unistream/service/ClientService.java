package uz.upay.unistream.service;

public interface ClientService {

    /**
     * Return a name of the service such as Unistream, TransferTo
     *
     * @return
     */
    String serviceName();

    /**
     * Returns a client by it's id.
     *
     * @param id globally unique identifier
     * @return
     */
    Object getClient(int id);

}
