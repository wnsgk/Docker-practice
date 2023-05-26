#Docker Base Image
FROM openjdk:11-jdk

#컨테이너 내에서 사용할 수 있는 변수를 지정할 수 있다.
ARG JAR_FILE=build/libs/*.jar

#위에 선언했던 JAR_FILE 변수를 컨테이너의 app.jar로 복사한다.
COPY ${JAR_FILE} app.jar

#컨테이너가 시작되었을 때 스크립트 실행
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "/app.jar"]

#docker build -t dockertestimg로 이미지 생성
#docker images로 확인 가능
#docker run -p <호스트 시스템의 포트>:<컨테이너 안의 포트> <도커이미지명>로 container실행
#docker ps로 실행확인