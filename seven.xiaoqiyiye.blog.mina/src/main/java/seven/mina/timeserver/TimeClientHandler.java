package seven.mina.timeserver;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class TimeClientHandler extends IoHandlerAdapter{

	int count = 0;
	
	@Override
	public void sessionCreated(IoSession session) throws Exception {
		session.write("hello" + count);
	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		String msg = message.toString();
		System.out.println("client rcv: " + msg);
		if(count ++ < 100){
			session.write("hello" + count);
		}else{
			session.write("quit");
		}
	}

}
