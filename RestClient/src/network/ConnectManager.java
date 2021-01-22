/*자바도 html 문서처럼, 웹서버와 http통신이 가능하다.*/
package network;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

class ConnectManager{
	URL url;
	HttpURLConnection con; //http통신을 위한 객체(헤더+바디를 구성해 서버와 데이터를 주고받는 방식)
						   //stateless 한 통신

	public void requestByGet(){ //Get방식으로 요청을 시도하는 메서드
		BufferedReader buffr=null;

		try{
			url = new URL("http://192.168.35.71:8888/rest/member");//요청 주소
			con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			
			//서버로부터 응답 데이터 가져오기
			buffr = new BufferedReader(new InputStreamReader(con.getInputStream())); //바이트 기반 스트림
			StringBuilder sb = new StringBuilder(); //문자열을 누적할 객체
			String data=null;

			while(true){
				data = buffr.readLine(); //한 줄 읽어들이기
				if(data==null)break;//읽어들일 데이터가 없다면 break
				sb.append(data);//읽어들인 문자열 누적
			}
			System.out.println("서버가 보낸 응답데이터는:"+sb.toString());

			int code = con.getResponseCode();//서버로부터 받은 응답코드 반환(이 시점에 이미 서버에 요청을 완료 후 응답도 받은 상태)			
			System.out.println("서버로부터 받은 응답코드는:"+code);
		}catch(MalformedURLException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(buffr!=null){
				try{
					buffr.close();
				}catch(IOException e){
				}
			}
		}
	}

	//Post 방식으로 요청을 시도하되,JSON 데이터 전송
	public int requestByPost(String requestUrl, String param){
		BufferedWriter buffw = null; //버퍼 처리된 문자 기반 스트림
		int code=0;

		try{
			//url = new URL("http://192.168.35.71:8888/rest/member");//요청 주소
			url = new URL(requestUrl);//요청 주소
			con = (HttpURLConnection)url.openConnection();
			//데이터형식을 헤더에 첨가해줘야, 서버측에서 제이슨데이터가 전송되어 온것임을 안다. 이게 바로 HTTP프로토콜간 약속이다
			con.setRequestProperty("Content-Type","application/json;charset=utf-8");
			con.setRequestMethod("POST");
			con.setDoOutput(true);//서버에 데이터를 출력하기 위해 필요한 옵션
			//요청을 떠나기 전에, 준비할게 있다면 여기서 준비하기, json 문자열 준비
			//JSON 객체 자체가 아닌 문자열로 준비하는 이유는? "{}"

			/*StringBuilder sb = new StringBuilder();
			sb.append("{");
			sb.append("\"m_id\":\"batman\",");
			sb.append("\"m_pass\":\"1234\",");
			sb.append("\"m_name\":\"배트맨\"");
			sb.append("}");*/

			//실행중인 프로그램에서 서버로 데이터를 보내야 하므로, 출력스트림으로 처리
			buffw = new BufferedWriter(new OutputStreamWriter(con.getOutputStream(),"UTF-8"));
			buffw.write(param);
			buffw.flush();

			code = con.getResponseCode();//요청+응답이 발생(이 시점에서)
			System.out.print("서버로부터 받은 응답 코드는"+code);

		}catch(MalformedURLException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(buffw!=null){
				try{
					buffw.close();
				}catch(IOException e){
				}
			}
		}
		return code;//응답코드 반환
	}

	public static void main(String[] args) 
	{
		ConnectManager manager = new ConnectManager();
		manager.requestByPost();
	}
}
