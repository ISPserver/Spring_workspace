/*�ڹٵ� html ����ó��, �������� http����� �����ϴ�.*/
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
	HttpURLConnection con; //http����� ���� ��ü(���+�ٵ� ������ ������ �����͸� �ְ�޴� ���)
						   //stateless �� ���

	public void requestByGet(){ //Get������� ��û�� �õ��ϴ� �޼���
		BufferedReader buffr=null;

		try{
			url = new URL("http://192.168.35.71:8888/rest/member");//��û �ּ�
			con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			
			//�����κ��� ���� ������ ��������
			buffr = new BufferedReader(new InputStreamReader(con.getInputStream())); //����Ʈ ��� ��Ʈ��
			StringBuilder sb = new StringBuilder(); //���ڿ��� ������ ��ü
			String data=null;

			while(true){
				data = buffr.readLine(); //�� �� �о���̱�
				if(data==null)break;//�о���� �����Ͱ� ���ٸ� break
				sb.append(data);//�о���� ���ڿ� ����
			}
			System.out.println("������ ���� ���䵥���ʹ�:"+sb.toString());

			int code = con.getResponseCode();//�����κ��� ���� �����ڵ� ��ȯ(�� ������ �̹� ������ ��û�� �Ϸ� �� ���䵵 ���� ����)			
			System.out.println("�����κ��� ���� �����ڵ��:"+code);
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

	//Post ������� ��û�� �õ��ϵ�,JSON ������ ����
	public int requestByPost(String requestUrl, String param){
		BufferedWriter buffw = null; //���� ó���� ���� ��� ��Ʈ��
		int code=0;

		try{
			//url = new URL("http://192.168.35.71:8888/rest/member");//��û �ּ�
			url = new URL(requestUrl);//��û �ּ�
			con = (HttpURLConnection)url.openConnection();
			//������������ ����� ÷�������, ���������� ���̽������Ͱ� ���۵Ǿ� �°����� �ȴ�. �̰� �ٷ� HTTP�������ݰ� ����̴�
			con.setRequestProperty("Content-Type","application/json;charset=utf-8");
			con.setRequestMethod("POST");
			con.setDoOutput(true);//������ �����͸� ����ϱ� ���� �ʿ��� �ɼ�
			//��û�� ������ ����, �غ��Ұ� �ִٸ� ���⼭ �غ��ϱ�, json ���ڿ� �غ�
			//JSON ��ü ��ü�� �ƴ� ���ڿ��� �غ��ϴ� ������? "{}"

			/*StringBuilder sb = new StringBuilder();
			sb.append("{");
			sb.append("\"m_id\":\"batman\",");
			sb.append("\"m_pass\":\"1234\",");
			sb.append("\"m_name\":\"��Ʈ��\"");
			sb.append("}");*/

			//�������� ���α׷����� ������ �����͸� ������ �ϹǷ�, ��½�Ʈ������ ó��
			buffw = new BufferedWriter(new OutputStreamWriter(con.getOutputStream(),"UTF-8"));
			buffw.write(param);
			buffw.flush();

			code = con.getResponseCode();//��û+������ �߻�(�� ��������)
			System.out.print("�����κ��� ���� ���� �ڵ��"+code);

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
		return code;//�����ڵ� ��ȯ
	}

	public static void main(String[] args) 
	{
		ConnectManager manager = new ConnectManager();
		manager.requestByPost();
	}
}
