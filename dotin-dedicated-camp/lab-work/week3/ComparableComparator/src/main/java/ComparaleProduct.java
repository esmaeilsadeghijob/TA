
    public abstract class ComparaleProduct implements Comparable<Product> {

        public abstract Product getObject();

        @Override
        public int compareTo(Product o) {
            return getObject().getName().compareTo(o.getName());
        }
    }

