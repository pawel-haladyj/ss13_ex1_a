package pl.haladyj.ss_basics.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="scopes")
public class Scope {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "client")
    @JsonIgnoreProperties({"scopes"})
    private Client client;

    public Scope() {
    }

    public Scope(Long id, String name, Client client) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
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
        Scope scope = (Scope) o;
        return Objects.equals(id, scope.id) &&
                Objects.equals(name, scope.name) &&
                Objects.equals(client, scope.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, client);
    }
}
