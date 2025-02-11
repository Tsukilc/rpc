package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @Description:
 * @Author: zbj
 * @Date: 2025/2/11
 */
public class NettyServer {

    private int port;

    public NettyServer(int port) {
        this.port = port;
    }

    public void start() throws InterruptedException {
        // 创建接收客户端连接的 EventLoopGroup
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // 创建处理每个连接的 EventLoopGroup
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            // 创建 ServerBootstrap 实例
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)  // 使用 NioServerSocketChannel
                    .childHandler(new ChannelInitializer<Channel>() {
                        @Override
                        protected void initChannel(Channel ch) throws Exception {
                            // 添加编码器和解码器
                            ch.pipeline().addLast(new StringDecoder());  // 解码
                            ch.pipeline().addLast(new StringEncoder());  // 编码
                            ch.pipeline().addLast(new ServerHandler());  // 处理逻辑
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)  // 设置 TCP 缓冲区
                    .childOption(ChannelOption.SO_KEEPALIVE, true);  // 设置保持连接

            // 启动服务器并绑定端口
            ChannelFuture future = bootstrap.bind(port).sync();
            System.out.println("Server started at port " + port);
            future.channel().closeFuture().sync();
        } finally {
            // 关闭 EventLoopGroup
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new NettyServer(8080).start();
    }
}
