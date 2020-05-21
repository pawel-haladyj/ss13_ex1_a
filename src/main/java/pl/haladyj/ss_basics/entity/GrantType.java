package pl.haladyj.ss_basics.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class GrantType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private GrantTypeEnum name;

    @ManyToOne
    @JoinColumn(name = "client")
    @JsonIgnoreProperties({"grantTypes"})
    private Client client;

    public GrantType() {
    }

    public GrantType(Long id, GrantTypeEnum name, Client client) {
        this.id = id;
        this.name = name;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GrantTypeEnum getName() {
        return name;
    }

    public void setName(GrantTypeEnum name) {
        this.name = name;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrantType grantType = (GrantType) o;
        return Objects.equals(id, grantType.id) &&
                name == grantType.name &&
                Objects.equals(client, grantType.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, client);
    }
}
