#### BufferedReader 를 이용해서 시스템 입력받기



#### Scanner vs BufferReader

- Scanner
  - 정규 표현을 이용해 구문 분석과 지정된 데이터로 파싱하는 작업을 수행.
  - 동기화 되지 않아서 멀티 스레드에 안전하지 않음.
  - 버퍼크기가 작다. (1KB)
  - 개발자가 Exception Handling 하지 않는다.
- BufferedReader
  - String만 읽을 수 있다.
  - 동기화 되어있어 멀티스레드에 안전.
  - 버퍼크기가 크다. (8KB)
  - 개발자가 Exception Handling 해야한다.



BufferedReader의 속도가 동기화에도 불구하고, Scanner의 구문 분석과 데이터 파싱, 버퍼 크기 때문에 훨씬 빠르다. 

결론적으로 알고리즘을 풀이하는데 BufferedReader를 사용해야 한다는 생각을 했다. 이에따라 BufferedReader 을 사용하는 방법을 알아야 한다.



~~~java
InputStreamReader isr = new InputStreamReader(System.in);
BufferedReader br = new BufferedReader(isr);
StringTokenizer st;

st = new StringTokenizer(br.readLine(), " "); // 읽은 String 값을 파싱
st.nextToken()	// 지정해준 값에 따라서 값이 출력됨 이 역시 String
~~~





