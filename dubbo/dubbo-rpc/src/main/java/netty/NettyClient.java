package netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @Description:
 * @Author: zbj
 * @Date: 2025/2/11
 */
public class NettyClient {

    private String host;
    private int port;

    public NettyClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws InterruptedException {
        // 创建一个 EventLoopGroup
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            // 创建 Bootstrap 实例
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<Channel>() {
                        @Override
                        protected void initChannel(Channel ch) throws Exception {
                            // 添加编码器和解码器
                            ch.pipeline().addLast(new StringDecoder());  // 解码
                            ch.pipeline().addLast(new StringEncoder());  // 编码
                            ch.pipeline().addLast(new ClientHandler());  // 处理逻辑
                        }
                    });

            // 连接到服务端
            ChannelFuture future = bootstrap.connect(host, port).sync();

            // 发送请求
            String message = "Hello from client!";
            future.channel().writeAndFlush(message);

            // 等待响应
            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new NettyClient("localhost", 8080).start();
    }
}
