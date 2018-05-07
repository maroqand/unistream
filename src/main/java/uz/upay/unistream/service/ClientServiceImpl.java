package uz.upay.unistream.service;

/**
 * Created by Sarvar Nishonboyev on Apr 22, 2018
 */

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import uz.upay.unistream.dto.Client;
import uz.upay.unistream.Unistream;
import uz.upay.unistream.utils.Auth;

@Data
@Service
@PropertySource(value = "classpath:api.properties")
public class ClientServiceImpl extends Unistream implements ClientService {

    private final String clientRoute = "/v2/clients/{id}";
    private final String clientsRoute = "/v2/clients";
    HttpHeaders headers;

    @Autowired
    private RestTemplate restTemplate;

    public ClientServiceImpl() {
        super();
    }

    @Override
    public String serviceName() {
        return null;
    }

    /**
     * Returns a client by it's id.
     *
     * @param id globally unique identifier
     * @return
     */
    @Override
    public Client getClient(int id) throws HttpClientErrorException, ResourceAccessException {
        String route = createRoute(clientRoute);

        UriComponents path = UriComponentsBuilder.fromPath(clientRoute).buildAndExpand(String.valueOf(id));

        headers = Auth.createAuthHeader(app_key, app_secret, path);

        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<Client> response;
        response = restTemplate.exchange(route, HttpMethod.GET, entity, Client.class, id);
        System.out.println(response.toString());

        return response.getBody();
    }
}