package ac.za.cput.domain;

/**
 * Category domain class implementing Builder pattern
 * @author Student
 */
public class Category {
    private final String id;
    private final String name;
    private final String description;

    private Category(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static class Builder {
        private String id;
        private String name;
        private String description;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder copy(Category category) {
            this.id = category.id;
            this.name = category.name;
            this.description = category.description;
            return this;
        }

        public Category build() {
            return new Category(this);
        }
    }
}
