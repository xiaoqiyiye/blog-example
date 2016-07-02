package seven.mina.timeserver;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

public class TimeClient {

	public static void main(String[] args) {
		NioSocketConnector connector = new NioSocketConnector();

        connector.setConnectTimeoutMillis(30*1000L);
        
        connector.getFilterChain().addFirst("logging", new LoggingFilter());
        connector.getFilterChain().addFirst("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
        
        connector.setHandler(new TimeClientHandler());
        
        ConnectFuture future = connector.connect(new InetSocketAddress(7777));
        
        future.awaitUninterruptibly();
        
        System.out.println("future....");
        
        future.getSession().getCloseFuture().awaitUninterruptibly();
        
        System.out.println("session close");
        
        connector.dispose();
	}
}
