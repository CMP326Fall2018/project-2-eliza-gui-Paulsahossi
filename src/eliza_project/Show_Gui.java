package eliza_project;

public class Show_Gui {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(
				new Runnable() {
			
			@Override
			public void run() {
				Eliza_Gui the_File_Gui = new Eliza_Gui();
			}
		});
		
	}

}
