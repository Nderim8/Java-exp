package purse;

import java.io.IOException;
import java.io.RandomAccessFile;
public class FileManager {
	private RandomAccessFile file;
	
	public static final int INT_SIZE=4;
	public static final int DOUBLE_SIZE=8;
	public static final int RECORD_SIZE=12;
	
	public FileManager()
	{
		file=null;
	}
	public void open(String fileName)throws IOException
	{
		file=new RandomAccessFile(fileName,"rw");
	}
	public int size()throws IOException
	{
		return(int)file.length()/RECORD_SIZE;
	}
	public void close() throws IOException
	{
		if(file!=null)
			file.close();
		file=null;
	}
	public Purse read()throws IOException
	{
		int id=file.readInt();
		double balance=file.readDouble();
		return new Purse(id,balance);
	}
	public void write(Purse aPurse)throws IOException
	{
		file.writeInt(aPurse.ktheID());
		file.writeDouble(aPurse.ktheBalancenKorente());
	}

}
