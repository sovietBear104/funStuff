package file;

import java.util.ArrayList;

public class FileAccess {

	private ArrayList<DataFile> files = new ArrayList<DataFile>();
	
	public FileAccess() {
	}
	
	public DataFile getFile(int indexOfFile) {
		return files.get(indexOfFile);
	}
	
	public void addFile(DataFile newFile) {
		files.add(newFile);
	}
	
}
