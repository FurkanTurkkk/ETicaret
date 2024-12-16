FROM openjdk:23
WORKDIR /app
COPY target/eCommerce-0.0.1-SNAPSHOT.jar ecommerce.jar
EXPOSE 8080
CMD ["java","-jar","ecommerce.jar"]