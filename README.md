# WAS

구현 스펙

1. Host 헤더 해석. 
2. JSON 설정파일로 Host 별로 ROOT 디렉토리를 다르게 지정, 에러 파일별 파일명 지정.
3. 에러파일별 설정파일 지정된 파일 반환.
4. .exe 파일 접근 제한
--> 연관파일 : /was/src/main/resources/host.json

실행 예 :
 - com.homework.App.java 실행

5. logback 설정
--> 연관파일 : /was/src/main/resources/logback.xml

6. Simple WAS 구현
실행 예 : 
 1. com.homework.ServletApp.java 실행
 2. http://127.0.0.1/Hello?name=Peter
 3. http://127.0.0.1/service.Hello?name=Peter
