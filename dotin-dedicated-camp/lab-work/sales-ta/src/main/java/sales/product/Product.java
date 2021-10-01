package sales.product;

public class Product {
    private final long id;
    private final String name;
    private final long basePrice;

    private Product(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.basePrice = builder.basePrice;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getBasePrice() {
        return basePrice;
    }

    public static class Builder {
        private long id;
        private String name = "";
        private long basePrice = 1;

        public Builder() {
            this.id = System.currentTimeMillis();
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder basePrice(long basePrice) {
            this.basePrice = basePrice;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
