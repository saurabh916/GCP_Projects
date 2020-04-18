FROM openjdk:8
ADD target/bootondocker.jar bootondocker.jar
EXPOSE 8095
ENTRYPOINT ["java", "-jar", "bootondocker.jar"]