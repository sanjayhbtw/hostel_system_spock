package com.allstate_onboarding.hostel_system_spock.controller

import com.allstate_onboarding.hostel_system_spock.HostelSystemSpockApplication
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import spock.lang.Specification

@AutoConfigureMockMvc
@ContextConfiguration(classes = HostelSystemSpockApplication)
@TestPropertySource(
        properties = [
                "spring.datasource.url=jdbc:h2:mem:test_db",
                "spring.sql.init.mode=never"
        ]
)
class StudentControllerTest extends Specification {
//
//    @Autowired
//    private MockMvc mvc
//
//    def "should get student when student with id is present"() {
//        expect:
//        mvc.perform {
//            MockMvcRequestBuilders.get("/students/${1}")
//        }.andExpect {
//            MockMvcResultMatchers.status().isOk()
//        }
//    }
}
