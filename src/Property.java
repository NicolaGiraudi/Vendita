public class Property {
    private String name;
    private int value;

    public Property(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return value == property.value &&
                name.equals(property.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + 31 * value;
    }
}
