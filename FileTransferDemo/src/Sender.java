import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Sender
{
    private static final int DISK_BUFFER_SIZE = 64 * 1024;
    //本地缓存
    private static final int NETWORK_BUFFER_SIZE = 128 * 1024;
    //网络包缓存
    private final String destHost;
    //目标IP
    private final int destPort;
    //目标端口
    private final String filePaths;
    //待发送文件路径
    Sender(String host, int port, String filePath)
    {
    	//设置目标IP,目标端口号,待发送文件路径
        destHost = host;
        destPort = port;
        filePaths = filePath;
    }

    void start()
    {
        println("Attempting to connect to <%s:%d>", destHost, destPort);
        try (
                InputStream fileIn = new BufferedInputStream(new FileInputStream(filePaths), DISK_BUFFER_SIZE);
        		//创建文件读入输入流
                Socket connection = new Socket(destHost, destPort);
        		//创建与接收方套接字
                OutputStream dataOut = new BufferedOutputStream(connection.getOutputStream(), NETWORK_BUFFER_SIZE);
        		//创建文件发送输出缓冲流
        )
        {
            println("Start sending file to <%s:%d>", destHost, destPort);
            long start = System.currentTimeMillis();
            //传输计时
            long totalBytesSend = 0;
            //数据包计数
            int byteRead = -1;
            //发送字节
            while ((byteRead = fileIn.read()) != -1)
            {
            	//从文件输入流读取字节到缓冲流
                dataOut.write(byteRead);
                //从缓冲流将字节写入输出流
                ++totalBytesSend;
                //数据包计数
            }
            dataOut.flush();
            //刷新输出流,缓冲流剩余的数据强制输出到目的地
            
            double timeUsed = (System.currentTimeMillis() - start) / 1000.;
            //计算数据传输用时
            double avgSpeed = (totalBytesSend / 1000.) / timeUsed;
            //计算每个数据包传输平均用时
            println(
            	"Completed.%n\tTotal bytes send: %d bytes,%n\tTime used: %.3f sec,%n\tAverage speed: %.3f KB/s"
            		, totalBytesSend, timeUsed, avgSpeed);
            //打印传输次数及所有用时
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