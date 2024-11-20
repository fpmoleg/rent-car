package local.rent_car;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class CarControllerMockMvcTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllCarsAPI() throws Exception
    {
        mockMvc.perform(get("/api/cars"))
                .andExpect(status().isOk());
    }
}
