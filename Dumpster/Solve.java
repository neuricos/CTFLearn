import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Solve
{
	public static final String FLAG = "S+kUZtaHEYpFpv2ixuTnqBdORNzsdVJrAxWznyOljEo=";
	private static class Password
	{
		private byte[] passHash;

		public Password() throws Exception
		{
            this.passHash = new byte[] {7, 95, -34, 16, -89, -86, 73, 108, -128, 71, 43, 41, 100, 40, 53, -24};
		}
		
		public byte[] encrypt(byte[] msg) throws Exception
		{
			SecretKeySpec spec = new SecretKeySpec(passHash, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, spec);
			return cipher.doFinal(msg);
		}
		
		public byte[] decrypt(byte[] msg) throws Exception
		{
			SecretKeySpec spec = new SecretKeySpec(passHash, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, spec);
			return cipher.doFinal(msg);
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		Password pass = new Password();
		System.out.println(new String(pass.decrypt(Base64.getDecoder().decode(FLAG.getBytes()))));
		Thread.sleep(5000); //We did a heap dump right here.
	}
}
