package pl.haladyj.ss_basics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;
import pl.haladyj.ss_basics.repository.ClientRepository;
import pl.haladyj.ss_basics.security.model.SecurityClient;

@Service
public class JpaClientDetailsService implements ClientDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        var client  = clientRepository
                .findClientByClientId(clientId)
                .orElseThrow(()->new ClientRegistrationException("ClientId not found"));

        var securityClient = new SecurityClient(client);

        return securityClient;
    }

}
