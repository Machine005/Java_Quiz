import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class InstanceCallbackDigest implements Runnable{
	
	private String filename;
	private InstanceCallbackDigestUserInterface callback;
	
	public InstanceCallbackDigest(String filename, InstanceCallbackDigestUserInterface callback) {
		this.filename = filename;
		this.callback = callback;
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		
		try(FileInputStream in = new FileInputStream(filename)){
			MessageDigest sha = MessageDigest.getInstance("SHA-256");
			DigestInputStream din = new DigestInputStream(in, sha);
			
			while(din.read()!=-1);
			
			din.close();
			byte[] digest = sha.digest();
			callback.receiveDigest(digest);
			
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	
}
