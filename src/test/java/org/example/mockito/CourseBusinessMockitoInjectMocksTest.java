package org.example.mockito;

import org.example.CourseBusiness;
import org.example.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CourseBusinessMockitoInjectMocksTest {
    @Mock
    CourseService mockService;
    @InjectMocks
    CourseBusiness business;
    @Captor
    ArgumentCaptor<String> argumentCaptor;
    List<String> courses;

    @BeforeEach
    void setup() {
        courses = Arrays.asList(
                "REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
                "Agile Desmistificado com Scrum, XP, Kanban e Trello",
                "Spotify Engineering Culture Desmistificado",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker",
                "Docker do Zero à Maestria - Contêinerização Desmistificada",
                "Docker para Amazon AWS Implante Apps Java e .NET com Travis CI",
                "Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
                "Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker",
                "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android",
                "Microsserviços do 0 com Spring Cloud, Kotlin e Docker"
        );
    }

    @Test
    void testCoursesRelatedToSpring_When_UsingAMock() {
        given(mockService.retrieveCourses("Gabriel")).willReturn(courses);

        var filteredCourses = business.retrieveCoursesRelatedToSpring("Gabriel");


        assertThat(filteredCourses.size(), is(4));
    }

    @DisplayName("Delete Courses not Related to Spring Using Mockito should call Method")
    @Test
    void DeleteCoursesNotRelatedToSpring_UsingMockitoVerify_Should_CallMethod_deleteCourse() {
        given(mockService.retrieveCourses("Gabriel")).willReturn(courses);

        business.deleteCoursesNotRelatedToSpring("Gabriel");

        verify(mockService, times(1)).deleteCourse("Docker do Zero à Maestria - Contêinerização Desmistificada");
        verify(mockService, atLeastOnce()).deleteCourse("Docker do Zero à Maestria - Contêinerização Desmistificada");
        verify(mockService, never()).deleteCourse("Microsserviços do 0 com Spring Cloud, Spring Boot e Docker");
    }

    @DisplayName("Delete Courses not Related to Spring Using Mockito should call Method V2")
    @Test
    void DeleteCoursesNotRelatedToSpring_UsingMockitoVerify_Should_CallMethod_deleteCourseV2() {

        courses = Arrays.asList(
                "Docker para Amazon AWS Implante Apps Java e .NET com Travis CI"
        );
        given(mockService.retrieveCourses("Gabriel")).willReturn(courses);

        business.deleteCoursesNotRelatedToSpring("Gabriel");

        then(mockService).should(times(7)).deleteCourse(argumentCaptor.capture());
        assertThat(argumentCaptor.getAllValues().size(), is(7));
    }
}