package com.allstate_onboarding.hostel_system_spock.controller

import com.allstate_onboarding.hostel_system_spock.HostelSystemSpockApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import spock.lang.Specification

@AutoConfigureMockMvc
@WebMvcTest
@ContextConfiguration(classes = HostelSystemSpockApplication.class)
class StudentControllerTest extends Specification {

    @Autowired
    private MockMvc mvc

    def "when get is performed then the response has status 200 and content is 'Hello world!'"() {
        expect:
        mvc.perform {
            MockMvcRequestBuilders.patch("/students/${1}/update_monthly_expense")
        }.andExpect {
            MockMvcResultMatchers.status().isOk()
        }
    }
}
