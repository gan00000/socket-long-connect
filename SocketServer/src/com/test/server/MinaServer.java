package com.test.server;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class MinaServer {

	public static void main(String[] args) {
		try {
		//�������socket����� ������
		NioSocketAcceptor acceptor = new NioSocketAcceptor();
		//������Ϣ����handler
		acceptor.setHandler(new MinaHander());
		//ָ��������
		acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory()));
		//����������
		acceptor.getSessionConfig().setIdleTime(IdleStatus.READER_IDLE, 5);
//		acceptor.getSessionConfig().setReaderIdleTime(30);
		acceptor.bind(new InetSocketAddress(9999));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
