package com.allstate_onboarding.hostel_system_spock.controller


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration
class StudentControllerTest extends Specification {

    @Autowired
    MockMvc mvc

    def "should get student when student with id is present"() {
        expect:
        mvc.perform(
                get("/students/${1}")
        ).andExpect(
                status().isOk()
        ).andDo(MockMvcResultHandlers.print()).andReturn().response
    }
}
