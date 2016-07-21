package hashing.test;

import hashing.implementations.Hasher;
import playgroundutils.BaseTest;

public abstract class HasherTest extends BaseTest {
    
    protected Class<?> clazz;
    protected Hasher hasher;
    
    public HasherTest(Class<?> clazz) {
        this.clazz = clazz;
    }
    
    @Override
    public void before() {
        try {
            hasher = (Hasher) clazz.newInstance();
        }
        catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void after() {
        hasher = null;
    }

}
