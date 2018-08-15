import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver
{
    private static final int DISK_BUFFER_SIZE = 64 * 1024;
    //本地缓存
    private static final int NETWORK_BUFFER_SIZE = 128 * 1024;
    //网络包缓存

    private final int localPort;
    //本地端口号
    private final String savePath;
    //保存路径
    Receiver(int port, String path)
    {
    	//设置端口号,文件存储路径
        localPort = port;
        savePath = path;
    }

    void start()
    { 
        println("Start listening at port %d ...", localPort);
        try (
                ServerSocket connection = new ServerSocket(localPort);
        		//监听端口号
                Socket remote = connection.accept();
        		//建立和发送方套接字
        		
                InputStream dataIn = new BufferedInputStream(remote.getInputStream(), NETWORK_BUFFER_SIZE);
        		//创建从发送方输入的缓冲流
                OutputStream fileOut = new BufferedOutputStream(new FileOutputStream(savePath), DISK_BUFFER_SIZE)
                //创建输出到文件缓冲流
        )
        {
            println("Start receiving file from <%s:%d>", remote.getInetAddress().getHostAddress(), remote.getPort());
            //打印发送方IP,端口号
            long start = System.currentTimeMillis();
            long totalBytesReceived = 0;
            //接收数据包总数
            int byteReceived = -1;
            //接收字节
            while ((byteReceived = dataIn.read()) != -1)
            {
                fileOut.write(byteReceived);
                //将接收字节一个一个写入文件
                ++totalBytesReceived;
                //数据包计数
            }
            fileOut.flush();
            //刷新输出流,缓冲流剩余的数据强制输出到目的地
            
            double timeUsed = (System.currentTimeMillis() - start) / 1000.;
            //计算数据传输用时
            double avgSpeed = (totalBytesReceived / 1000.) / timeUsed;
            //计算每个数据包传输平均用时
            println(
            "Completed, file saved to: %s.%n\tTotal bytes send: %d bytes,%n\tTime used: %.3f sec,%n\tAverage speed: %.3f KB/s"
            		, savePath, totalBytesReceived, timeUsed, avgSpeed);
            //打印保存路径及所有用时
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void println(String format, Object... args)
    {
        System.out.format("[%s] : %s%n", this.getClass().getSimpleName(), String.format(format, args));
    }
}