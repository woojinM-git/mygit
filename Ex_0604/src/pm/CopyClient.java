package pm;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class CopyClient extends Thread {

	Socket s;
	ChatServer server;
	
	// 통신을 위한 스트림들
	ObjectOutputStream out;
	ObjectInputStream in;
	
	String ip, nickName;
	
	ChatRoom currentRoom; // 현재 참여하고 있는 방 만약 currentRoom이 null일때는 
						// 현재 사용자는 대기실에 있는 것이다.
	
	public CopyClient(Socket s, ChatServer ex3_ChatServer) {
		this.s = s;
		this.server = ex3_ChatServer;
		
		// in/out스트림들 생성, ip도 얻어내야 한다.
		try {
			in = new ObjectInputStream(s.getInputStream());
			out = new ObjectOutputStream(s.getOutputStream());
			ip = s.getInetAddress().getHostAddress(); // 접속자 IP
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // 생성자의 끝

	@Override
	public void run() {
		// 현재 Thread는 서버에 실제 클라이언트를 대신하면서
		// 언제, 어느 때에 원격에 있는 클라이언트가 서버로 메세지를 보낼지 모르므로
		// 항상 inputstream을 read를 수행하여 메세지가 올때까지 기다려야 한다.
		bk:while(true) {
			try {
				// 스트림으로부터 객체를 읽어낸다.
				Object obj = in.readObject();
				if(obj != null) {
					Protocol protocol = (Protocol) obj;
					// protocol의 cmd값이 뭐냐에 따라 작업의 구분을 구현한다.
					switch(protocol.getCmd()) {
					case 3: // 원격의 클라이언트에 있는 Thread를 소멸시키기 위해 메세지를 보냄
						out.writeObject(protocol);
						break bk; // while을 나가기 위한 레이블 달아주기
					case 1: // 서버에 접속한 경우
						// 사용자가 입력한 대화명을 얻어내어 nickName에 저장한다.
						this.nickName = protocol.getMsg();
						System.out.println(this.nickName+"입장");
						
						Protocol p = new Protocol();
						p.cmd = 1;
						// 명단 수집
						p.setUser_names(server.getNames()); // 배열형태로 저장
						p.setRoom_names(server.getRoomNames());			
						
						server.sendProtocol(p); // 접속자 모두에게 보냄
						break;
					case 2: // 채팅메세지
						// 메세지 앞에 nickName을 붙여서 msg에 다시 저장하자
						protocol.setMsg(nickName+":"+protocol.getMsg());
						
						currentRoom.sendtf(protocol); // 접속자 모두에게 전달
						System.out.println("채팅보냈음");
						break;
					case 4: // 방만들기
						currentRoom = new ChatRoom(protocol.getMsg(), server);
						server.r_list.add(currentRoom);
						
						// 대기실에서 현재 CopyClient를 삭제
						server.removeClient(this);
						currentRoom.joinUser(this);
						break;
					case 5: // 방 나가기
						if(currentRoom != null) {
							// 원격에 있는 클라이언트가 [방 나가기]라는
							// 버튼을 수행했을 때 수행
							currentRoom.getOut(this);
							currentRoom = null; // ***************
							protocol.setUser_names(server.getNames());
							protocol.setRoom_names(server.getRoomNames());
							out.writeObject(protocol);
						}
						break;
					case 6: // 방 참여하기
						// 사용자가 선택한 방의 index값을 얻어내자
						int idx = protocol.index;
						currentRoom = server.r_list.get(idx); // 참여 방 가져오기
						// 대기실에서 현재 CopyClient를 삭제
						server.removeClient(this);
						currentRoom.joinUser(this);
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // 무한반복의 끝
		
		try {
			if(out != null) 
				out.close();
			if(in != null)
				in.close();
			if(s != null)
				s.close();
			
			if(currentRoom != null) {
				currentRoom.getOut(this);
			}else {
			// 서버에서 나를 삭제하고
			server.removeClient(this);
			
			// 내가 없어졌다고 모두에게 전달해야함
			Protocol p = new Protocol();
			p.cmd = 1;
			p.setUser_names(server.getNames()); // 배열형태로 저장
			server.sendProtocol(p); // 접속자 모두에게 보냄
			
			System.out.println(this.nickName+"퇴장");			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 현재 이름을 반환하는 기능
	public String getNickName() {
		return nickName;
	}
	
}

