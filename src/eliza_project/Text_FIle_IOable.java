package eliza_project;

public interface Text_FIle_IOable {

	public void createNewFile(String fileName);
	public void appendToFile(String fileName, String text);
	public String readFile(String fileName);
	public String longestWords(String fileName);
	public String readDelimetedFile(String fileName, String delimeter);
	public String alphaSort(String fileName, String delimeter);
	public String ShortesWords(String fileName);

		
}
