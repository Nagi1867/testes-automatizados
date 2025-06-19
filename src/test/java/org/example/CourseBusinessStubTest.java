package org.example;

import org.example.service.CourseService;
import org.example.stubs.CouseServiceStub;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CourseBusinessStubTest {
    @Test
    void testCoursesRelatedToSpring_When_UsingAStub() {
        CourseService stubService = new CouseServiceStub();
        CourseBusiness business = new CourseBusiness(stubService);

        var filteredCourses = business.retrieveCoursesRelatedToSpring("Gabriel");

        assertEquals(4, filteredCourses.size());
    }

    @Test
    void testCoursesRelatedToSpring_When_UsingAFooBarStudent() {
        CourseService stubService = new CouseServiceStub();
        CourseBusiness business = new CourseBusiness(stubService);

        var filteredCourses = business.retrieveCoursesRelatedToSpring("Foo Bar");

        assertEquals(4, filteredCourses.size());
    }
}