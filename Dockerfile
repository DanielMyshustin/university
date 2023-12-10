FROM openjdk:17
WORKDIR /app
COPY target/UniversitySchedule-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-jar", "UniversitySchedule-0.0.1-SNAPSHOT.jar"]