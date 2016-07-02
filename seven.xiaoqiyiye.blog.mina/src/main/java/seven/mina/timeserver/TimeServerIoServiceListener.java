package seven.mina.timeserver;

import org.apache.mina.core.service.IoService;
import org.apache.mina.core.service.IoServiceListener;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class TimeServerIoServiceListener implements IoServiceListener {

	@Override
	public void serviceActivated(IoService service) throws Exception {
		System.out.println("TimeServer activated");
	}

	@Override
	public void serviceIdle(IoService service, IdleStatus idleStatus)
			throws Exception {
		System.out.println("TimeServer Idle");
	}

	@Override
	public void serviceDeactivated(IoService service) throws Exception {
		System.out.println("TimeServer deactivated");
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		System.out.println("TimeServer session Created");
	}

	@Override
	public void sessionDestroyed(IoSession session) throws Exception {
		System.out.println("TimeServer destroyed");
	}

}
