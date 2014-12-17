import org.modelmapper.ModelMapper;
import org.testng.annotations.Test;

/**
 * Created by twer on 14-11-25.
 */
public class ModelMapperTest {
    @Test
    public void mapper_test_first_case(){
        ModelMapper mapper=new ModelMapper();
        TransferPackage tp = new TransferPackage("test1",2);
        TransferPackageArchive copy = mapper.map(tp, TransferPackageArchive.class);
        System.out.printf(copy.toString());
    }
}
