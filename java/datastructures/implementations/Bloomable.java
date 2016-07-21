package datastructures.implementations;

public interface Bloomable<E> {
    
    public void add(E value);
    
    @SuppressWarnings("unchecked")
    public void addAll(E... values);
    
    public boolean mightContain(E value);
    
    @SuppressWarnings("unchecked")
    public boolean mightContainAll(E... values);

}
