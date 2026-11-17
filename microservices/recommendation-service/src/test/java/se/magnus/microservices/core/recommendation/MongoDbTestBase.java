package se.magnus.microservices.core.recommendation;


import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.mongodb.MongoDBContainer;

public abstract class MongoDbTestBase {
  private static MongoDBContainer database = new MongoDBContainer("mongo:8.0.4");

  static {
    database.start();
  }

  @DynamicPropertySource
  static void setProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.mongodb.host", database::getHost);
    registry.add("spring.mongodb.port", () -> database.getMappedPort(27017));
    registry.add("spring.mongodb.database", () -> "test");
  }
}
