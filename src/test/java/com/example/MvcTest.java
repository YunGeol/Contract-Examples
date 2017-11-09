package com.example;

import com.example.provider.controller.PersonCheckingService;
import com.example.provider.controller.PersonInfo;
import com.example.provider.controller.ProducerController;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.argThat;

@RunWith(MockitoJUnitRunner.class)
public abstract class MvcTest {

    @Mock
    PersonCheckingService personCheckingService;

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(new ProducerController(personCheckingService));
        given(
            personCheckingService.shouldGetBeer(
                argThat(oldEnough())
            )
        ).willReturn(true);
    }

    private TypeSafeMatcher<PersonInfo> oldEnough() {
        return new TypeSafeMatcher<PersonInfo>() {
            @Override protected boolean matchesSafely(PersonInfo personInfo) {
                return personInfo.getAge() >= 20;
            }

            @Override public void describeTo(Description description) {

            }
        };
    }

}
