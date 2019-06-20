package ru.frost.training;

import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ActiveProfiles(profiles = "test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class TrainingApplicationTests {

    public static final String FIN_URL = "/company/stock/list";
    public static final String SUCCESS_FILE = "/dict/all-company-success.json";

    @Autowired
    private MockMvc mockmvc;

    @Rule
    public final WireMockRule wireMockRule =
            new WireMockRule(wireMockConfig().port(4545));

    @Test
    public void contextLoads() throws Exception {
        setUpWireMock(SUCCESS_FILE, FIN_URL);

        mockmvc.perform(get("/companies"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data", hasSize(2)));
    }

    private void setUpWireMock(String pathFile, String requestUrl) {
        ResponseDefinitionBuilder response = WireMock.aResponse()
                .withHeader("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE)
                .withBodyFile(pathFile);

        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo(requestUrl)).willReturn(response));
    }

}
