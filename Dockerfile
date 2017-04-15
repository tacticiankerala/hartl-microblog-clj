FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/hartl-microblog-clj-0.0.1-SNAPSHOT-standalone.jar /hartl-microblog-clj/app.jar

EXPOSE 8080

CMD ["java", "-jar", "/hartl-microblog-clj/app.jar"]
