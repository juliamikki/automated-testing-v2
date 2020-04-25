import people.worker.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BaseEngineerTest {


    private Engineer engineer;

    public BaseEngineerTest(Engineer engineer) {
        this.engineer = engineer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumber() {
        return Arrays.asList(new Object[][]{
                {new ManualEngineer()},
                {new AutomationEngineer()}
        });
    }

    @Test
    public void verify1DefaultAnxiety() {
        assertEquals("Default Anxiety is not correct!", 3, engineer.getAnxiety());
    }

    @Test
    public void verify2Anxiety() {
        engineer.setAnxiety(11);
        assertEquals("Set Anxiety is not correct!", 11, engineer.getAnxiety());
    }

    @Test
    public void verifyRandomSkill() {
        assertTrue("Random engineer skill is not correct!",
                1 <= engineer.getSkill() && engineer.getSkill() <= 10);
    }
    @Test
    public void verifySetSkill() {
        engineer.setSkill(2);
        assertEquals("Engineer skill was set not correct!", 2, engineer.getSkill());
    }



}
