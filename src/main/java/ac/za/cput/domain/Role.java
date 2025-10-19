package ac.za.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

/**
 * Role domain class implementing Builder pattern
 * @author Student
 */
@Entity
public class Role {
    @Id
    private String id;
    private String name;

    protected Role() {}

    private Role(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id) && Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public static class Builder {
        private String id;
        private String name;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder copy(Role role) {
            this.id = role.id;
            this.name = role.name;
            return this;
        }

        public Role build() {
            return new Role(this);
        }
    }
}
