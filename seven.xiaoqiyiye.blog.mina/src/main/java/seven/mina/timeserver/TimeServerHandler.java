package seven.mina.timeserver;


import java.util.Date;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class TimeServerHandler extends IoHandlerAdapter {

	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		String rcv = message.toString();
		if("quit".equalsIgnoreCase(rcv)){
			session.close(true);
		}
		System.out.println("srv rcv:" + rcv);
		Date date = new Date();
		session.write("svr send:" + date.toString());
	}
	
}
