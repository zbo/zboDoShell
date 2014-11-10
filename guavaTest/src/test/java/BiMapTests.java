import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import junit.framework.Assert;
import org.testng.annotations.Test;

/**
 * Created by twer on 14-11-6.
 */
public class BiMapTests {
    @Test
    public void guava_bimap_basic_test(){
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("Sam", "123456");
        biMap.put("John", "456789");
        biMap.put("Ben", "147258");
        biMap.put("Joy", "1234567");
        String ret=biMap.inverse().get("1234567");
        Assert.assertEquals(ret,"Joy");
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void guava_bimap_exception_test(){
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("Sam", "123456");
        biMap.put("John", "456789");
        biMap.put("Ben", "147258");
        biMap.put("Joy", "123456");//two entries should not contains same value
        String ret=biMap.inverse().get("123456");
        Assert.assertEquals(ret,"Joy");
    }

}
