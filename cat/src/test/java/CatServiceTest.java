import com.fyx.cat.CatApplication;
import com.fyx.cat.service.CatService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wushiyi
 * @date 2020/08/05
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CatApplication.class)
public class CatServiceTest {

    @Autowired
    private CatService catService;

    @Test
    public void testInit() throws CloneNotSupportedException {
        catService.init();
    }
}
