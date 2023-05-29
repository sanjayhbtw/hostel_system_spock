package com.allstate_onboarding.hostel_system_spock.controller


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
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
        ).andExpect(
                content().json("{\"id\":1,\"name\":\"joe\",\"monthlyExpenses\":0}")
        ).andDo(MockMvcResultHandlers.print()).andReturn().response
    }

    def "should throw error when student with id is not present"() {
        expect:
        mvc.perform(
                get("/students/${2}")
        ).andExpect(
                status().isNotFound()
        ).andDo(MockMvcResultHandlers.print()).andReturn().response
    }


    def "should update monthly expenses for student when student, hostel and room are all present"() {
        expect:
        mvc.perform(
                patch("/students/${1}/update_monthly_expense")
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().json("{\"id\":1,\"name\":\"joe\",\"monthlyExpenses\":10000}")
        ).andDo(MockMvcResultHandlers.print()).andReturn().response
    }
}
