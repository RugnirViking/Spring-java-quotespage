package com.example.rest_service.model_tests;

import com.example.rest_service.models.Author;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuthorModelTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testAuthorFields(){
        Author test_author = new Author();
        test_author.setId(32L);
        test_author.setName("Test McTestperson");

        assertEquals(32, test_author.getId());
        assertEquals("Test McTestperson", test_author.getName());
    }
    @Test
    void testAuthorConstructor(){
        Author test_author = new Author(32L, "Test2 McTestperson2");

        assertEquals(32, test_author.getId());
        assertEquals("Test2 McTestperson2", test_author.getName());
    }

    @Test
    void testAuthorEquality(){
        Author test_author = new Author(32L, "Test3 McTestperson3");
        Author test_author2 = new Author(32L, "Test3 McTestperson3");

        assertEquals(test_author, test_author2);
    }
}
