package ch.timo.f1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BackendcontrollerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetDriversEndpoint() {
        ResponseEntity<String> response = restTemplate.getForEntity("/drivers", String.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
    }

    @Test
    public void testGetCircuitsEndpoint() {
        ResponseEntity<String> response = restTemplate.getForEntity("/circuits", String.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
    }

    @Test
    public void testGetConstructorsEndpoint() {
        ResponseEntity<String> response = restTemplate.getForEntity("/constructors", String.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
    }

    @Test
    public void testGetRaceEndpoint() {
        ResponseEntity<String> response = restTemplate.getForEntity("/race", String.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
    }
}
