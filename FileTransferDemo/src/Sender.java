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
    //���ػ���
    private static final int NETWORK_BUFFER_SIZE = 128 * 1024;
    //���������
    private final String destHost;
    //Ŀ��IP
    private final int destPort;
    //Ŀ��˿�
    private final String filePaths;
    //�������ļ�·��
    Sender(String host, int port, String filePath)
    {
    	//����Ŀ��IP,Ŀ��˿ں�,�������ļ�·��
        destHost = host;
        destPort = port;
        filePaths = filePath;
    }

    void start()
    {
        println("Attempting to connect to <%s:%d>", destHost, destPort);
        try (
                InputStream fileIn = new BufferedInputStream(new FileInputStream(filePaths), DISK_BUFFER_SIZE);
        		//�����ļ�����������
                Socket connection = new Socket(destHost, destPort);
        		//��������շ��׽���
                OutputStream dataOut = new BufferedOutputStream(connection.getOutputStream(), NETWORK_BUFFER_SIZE);
        		//�����ļ��������������
        )
        {
            println("Start sending file to <%s:%d>", destHost, destPort);
            long start = System.currentTimeMillis();
            //�����ʱ
            long totalBytesSend = 0;
            //���ݰ�����
            int byteRead = -1;
            //�����ֽ�
            while ((byteRead = fileIn.read()) != -1)
            {
            	//���ļ���������ȡ�ֽڵ�������
                dataOut.write(byteRead);
                //�ӻ��������ֽ�д�������
                ++totalBytesSend;
                //���ݰ�����
            }
            dataOut.flush();
            //ˢ�������,������ʣ�������ǿ�������Ŀ�ĵ�
            
            double timeUsed = (System.currentTimeMillis() - start) / 1000.;
            //�������ݴ�����ʱ
            double avgSpeed = (totalBytesSend / 1000.) / timeUsed;
            //����ÿ�����ݰ�����ƽ����ʱ
            println(
            	"Completed.%n\tTotal bytes send: %d bytes,%n\tTime used: %.3f sec,%n\tAverage speed: %.3f KB/s"
            		, totalBytesSend, timeUsed, avgSpeed);
            //��ӡ���������������ʱ
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