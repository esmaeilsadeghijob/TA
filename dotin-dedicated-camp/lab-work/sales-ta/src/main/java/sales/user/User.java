package sales.user;

public class User {
    private final long id;
    private final String username;
    private final String password;
    private final long suggestedPrice;

    private User(Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.password = builder.password;
        this.suggestedPrice = builder.suggestedPrice;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public long getSuggestedPrice() {
        return suggestedPrice;
    }

    public static class Builder {
        // Required parameters
        private long id;
        private String username = "";
        private String password = "";
        private long suggestedPrice = 1;

        public Builder() {
            this.id = System.currentTimeMillis();
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder suggestedPrice(long suggestedPrice) {
            this.suggestedPrice = suggestedPrice;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
