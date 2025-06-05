package pm;

import java.io.IOException;
import java.util.ArrayList;

public class ChatRoom {
	ArrayList<CopyClient> ru_list; // 방에 참여한 사용자들
	String roomName;
	ChatServer server;
	
	public ChatRoom(String n, ChatServer server) {
		this.roomName = n;
		this.server = server; // 방 나가기할때
		// ru_list에서는 삭제가되고 ChatServr의 u_list에는 추가되어야 함
		ru_list = new ArrayList<CopyClient>();
	}
	
	public void sendMsg(Protocol p) {  // 현재 방에 접속되어 있는 모든 사용자들에게
										// 데이터를 전달하는 기능
//		for(int i=0; i<ru_list.size(); i++) {
//			CopyClient cc = ru_list.get(i);
		for(CopyClient cc : ru_list) { 
			
			try {
				cc.out.writeObject(p);
				cc.out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void getOut(CopyClient cc) { // 방 나가기
		ru_list.remove(cc);
		// 만약 지금 나가는 CopyClient가 마지막일 때
		// 현재 방은 삭제되어야 한다.
		if(ru_list.size() == 0) {
			server.r_list.remove(this);
		}else {
			Protocol protocol = new Protocol();
			protocol.setCmd(4);
			protocol.setUser_names(getJoinNames());
			protocol.setMsg("***" + cc.nickName + "님 퇴장 ***\r\n");
			sendMsg(protocol);
		}
		// 대기실로 추가되어야 한다. (CopyClient)
		server.addClient(cc);
	}

	public void joinUser(CopyClient cc) { // 방 참여
		ru_list.add(cc);
		
		// 원본 클라이언트에게 전달할 프로토콜은 다시 작업함
		// 먼저 방에 참여한 참여자명단 수집
		Protocol protocol = new Protocol();
		protocol.setCmd(4);
		protocol.setUser_names(getJoinNames());
		protocol.setMsg("***" + cc.nickName + "님 입장 ***\r\n");
		
		// 이제 준비된 프로토콜은 현재 방에 참여된
		// 사용자들에게만 보낸다
		sendMsg(protocol);
	}
	
	public String[] getJoinNames() { // 현재 방에 참여하고 있는 사용자들의 명단
		String[] names = new String[ru_list.size()];
		int i = 0;
		for(CopyClient cc : ru_list) {
			names[i++] = cc.getNickName();
		}
		return names;
	}
	
	public void sendtf(Protocol p) {
		for(int i = -0; i < ru_list.size(); i++) {
			// 각 클라이언트 복사본들을 하나씩 얻어낸다.
			CopyClient cc = ru_list.get(i);
			try {
				cc.out.writeObject(p); // 각 복사본에게 보내고 복사본들은 원본들에게 보낸다.
				cc.out.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
