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
    //���ػ���
    private static final int NETWORK_BUFFER_SIZE = 128 * 1024;
    //���������

    private final int localPort;
    //���ض˿ں�
    private final String savePath;
    //����·��
    Receiver(int port, String path)
    {
    	//���ö˿ں�,�ļ��洢·��
        localPort = port;
        savePath = path;
    }

    void start()
    { 
        println("Start listening at port %d ...", localPort);
        try (
                ServerSocket connection = new ServerSocket(localPort);
        		//�����˿ں�
                Socket remote = connection.accept();
        		//�����ͷ��ͷ��׽���
        		
                InputStream dataIn = new BufferedInputStream(remote.getInputStream(), NETWORK_BUFFER_SIZE);
        		//�����ӷ��ͷ�����Ļ�����
                OutputStream fileOut = new BufferedOutputStream(new FileOutputStream(savePath), DISK_BUFFER_SIZE)
                //����������ļ�������
        )
        {
            println("Start receiving file from <%s:%d>", remote.getInetAddress().getHostAddress(), remote.getPort());
            //��ӡ���ͷ�IP,�˿ں�
            long start = System.currentTimeMillis();
            long totalBytesReceived = 0;
            //�������ݰ�����
            int byteReceived = -1;
            //�����ֽ�
            while ((byteReceived = dataIn.read()) != -1)
            {
                fileOut.write(byteReceived);
                //�������ֽ�һ��һ��д���ļ�
                ++totalBytesReceived;
                //���ݰ�����
            }
            fileOut.flush();
            //ˢ�������,������ʣ�������ǿ�������Ŀ�ĵ�
            
            double timeUsed = (System.currentTimeMillis() - start) / 1000.;
            //�������ݴ�����ʱ
            double avgSpeed = (totalBytesReceived / 1000.) / timeUsed;
            //����ÿ�����ݰ�����ƽ����ʱ
            println(
            "Completed, file saved to: %s.%n\tTotal bytes send: %d bytes,%n\tTime used: %.3f sec,%n\tAverage speed: %.3f KB/s"
            		, savePath, totalBytesReceived, timeUsed, avgSpeed);
            //��ӡ����·����������ʱ
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