package seven.mina.timeserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class TimeServer {

	private static final int PORT = 7777;
	NioSocketAcceptor acceptor;
	
	public TimeServer(){
		this(PORT);
	}
	
	public TimeServer(int port){
		acceptor = new NioSocketAcceptor();
		init(port);
	}
	
	public void init(int port){
		try {
			//����SessionConfig
			acceptor.getSessionConfig().setReadBufferSize(2048);
			acceptor.getSessionConfig().setSendBufferSize(2048);
			
			//����FilterChain
			acceptor.getFilterChain().addFirst("logging", new LoggingFilter());
			acceptor.getFilterChain().addFirst("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
			
			//����IoHandler
			acceptor.setHandler(new TimeServerHandler());
			
			//��Ӽ�����IoServiceListener
			acceptor.addListener(new TimeServerIoServiceListener());
			
			//�󶨼����˿�
			acceptor.bind(new InetSocketAddress(port));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		new TimeServer();
	}
}
