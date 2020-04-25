import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({ExecuteTestTest.class, BaseEngineerTest.class, InstabilityTest.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class JUnit4Runner {

}
