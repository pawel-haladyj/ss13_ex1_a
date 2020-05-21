package pl.haladyj.ss_basics.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String clientId;
    private String secret;

    @OneToMany(mappedBy = "client")
    @JsonIgnoreProperties({"client","id","scopes"})
    private List<GrantType> grantTypes;

    @OneToMany(mappedBy = "client")
    @JsonIgnoreProperties({"client","id","grantTypes"})
    private List<Scope> scopes;

    public Client() {
    }

    public Client(Long id, String clientId, String secret, List<GrantType> grantTypes, List<Scope> scopes) {
        this.id = id;
        this.clientId = clientId;
        this.secret = secret;
        this.grantTypes = grantTypes;
        this.scopes = scopes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public List<GrantType> getGrantTypes() {
        return grantTypes;
    }

    public void setGrantTypes(List<GrantType> grantTypes) {
        this.grantTypes = grantTypes;
    }

    public List<Scope> getScopes() {
        return scopes;
    }

    public void setScopes(List<Scope> scopes) {
        this.scopes = scopes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(clientId, client.clientId) &&
                Objects.equals(secret, client.secret) &&
                Objects.equals(grantTypes, client.grantTypes) &&
                Objects.equals(scopes, client.scopes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, secret, grantTypes, scopes);
    }
}
