package nl.hu.iac;

/**
 * Created by Nick Stuivenberg on 21-6-2017.
 * Bestaat de controller?
 */
import static org.assertj.core.api.Assertions.assertThat;

import nl.hu.iac.controller.CityController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {

    @Autowired
    private CityController controller;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}
