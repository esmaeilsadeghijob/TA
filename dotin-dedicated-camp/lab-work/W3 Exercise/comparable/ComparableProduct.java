public abstract class ComparableProduct implements Comparable<Product> {

    public abstract Product getObject();

    @Override
    public int compareTo(Product o) {
        return getObject().getName().compareTo(o.getName());
    }
}
